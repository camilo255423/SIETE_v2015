package controllers;



import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
/**
 * Clase que contiene los métodos para validar el usuario
 * mediante el web service de la Institución
 * @author Camilo Rodríguez
 *
 */
public class LoginWebService {
  
	/**
	 * Identificación de la aplicación
	 */
    public static final String token ="123456";
    /**
	 * Dirección del servior
	 */
    public static final String serverURI= "http://ws.seguridadpermanencia.com/";
    /**
     * URL
     */
    public static final String url="http://oas1012.inpahu.edu.co/SeguridadPermanencia-war/GestionAccesoPermanencia?WSDL";
	
    /**
     * Método encargado de autenticar el usuario mediante el webservice de la universidad
     * @param usuario 
     * @param clave
     * @return returna la cédula del usuario autenticado , null en caso de que la autenticación
     * haya fallado, o -1 en caso de que haya algún error de conexión con el web service de la institución.
     */
    public static String autenticar(String usuario, String clave)
	{
		SOAPMessage soapResponse=null;
		String [] respuesta;
		 try {
		        // Create SOAP Connection
		        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		        // Send SOAP Message to SOAP Server.
		          soapResponse = soapConnection.call(createSOAPRequest(usuario, clave), url);

		         soapConnection.close();
		    } catch (Exception e) {
		        System.err.println("Error occurred while sending SOAP Request to Server");
		        e.printStackTrace();
		    }
		 respuesta = LoginWebService.soapMessageToString(soapResponse).split("-");
		 if(LoginWebService.soapMessageToString(soapResponse).contains("SUCCESSFUL"))
		 {
			 return respuesta[5]; // retorna la cédula del usuario
		 }
		 else  if(LoginWebService.soapMessageToString(soapResponse).contains("FAILURE"))
		 {
			 return null;
		 }		 
		
		 return "-1";
	}
	private static SOAPMessage createSOAPRequest(String usuario, String clave) throws Exception {

	    
	    MessageFactory messageFactory = MessageFactory.newInstance();
	    SOAPMessage soapMessage = messageFactory.createMessage();
	    
	    SOAPPart soapPart = soapMessage.getSOAPPart();

	

	    // SOAP Envelope
	    SOAPEnvelope envelope = soapPart.getEnvelope();
	   envelope.addNamespaceDeclaration("ns1", serverURI);
	  
	 
	    SOAPBody soapBody = envelope.getBody();
	    SOAPElement soapBodyElem = soapBody.addChildElement("strValidarUsuario");

	    SOAPElement soapBodyElemToken = soapBodyElem.addChildElement("pTokenAplicacion");
	    soapBodyElem.setPrefix("ns1");
	    soapBodyElemToken.addTextNode(token);
	    SOAPElement soapBodyElempUsuario = soapBodyElem.addChildElement("pUsuario");
	    soapBodyElempUsuario.addTextNode(usuario);
	    SOAPElement soapBodyElempClave = soapBodyElem.addChildElement("pClave");
	    soapBodyElempClave.addTextNode(clave);

	    
	  

	    soapMessage.saveChanges();


	    return soapMessage;
	}


	public static String soapMessageToString(SOAPMessage message) 
    {
        String result = null;

        if (message != null) 
        {
            ByteArrayOutputStream baos = null;
            try 
            {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos); 
                result = baos.toString();
            } 
            catch (Exception e) 
            {
            } 
            finally 
            {
                if (baos != null) 
                {
                    try 
                    {
                        baos.close();
                    } 
                    catch (IOException ioe) 
                    {
                    }
                }
            }
        }
        return result;
    }

}
