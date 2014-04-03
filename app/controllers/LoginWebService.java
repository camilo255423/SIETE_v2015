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

public class LoginWebService {
  
    public static final String token ="123456";
    public static final String serverURI= "http://ws.seguridadpermanencia.com/";
    public static final String url="http://oas1012.inpahu.edu.co/SeguridadPermanencia-war/GestionAccesoPermanencia?WSDL";
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
			 return respuesta[7]; // retorna la cédula del usuario
		 }
		 
		 return null;
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
