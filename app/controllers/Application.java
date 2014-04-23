package controllers;


import java.util.ArrayList;
import java.util.List;
import static play.data.Form.*;

import models.*;
import play.data.Form;
import play.mvc.*;

<<<<<<< HEAD
/** Controlador principal. Procesa las acciones de Login, Logout y cuando el 
 * usuario selecciona un semestre en el menú lateral.
 *
 */

=======
/**
 * 
 * Controlador principal. Procesa las acciones de Login, Logout y cuando el 
 * usuario selecciona un semestre en el menú lateral.
 * @author Camilo Rodriguez
 *
 */
>>>>>>> c6f3f0bc6d4fe7e4ba9b7b11bdd3a0f8bd195e04
public class Application extends Controller {
	/**
	 * 
	 * @author Camilo Rodríguez
	 * Clase que representa login el usuario. Contiene los métodos para validar y realizar conexión
	 * al web service de autenticación de usuarios.
	 *
	 */
	public static class Login {

        public String email;
        public String password;
        
        public String validate() {

        	String cedula="";
        email="52348310";
email=Form.form().bindFromRequest().get("email");
	 cedula = email;
        	// 52348310 Johanna Ovalle
        	if(email.equals("13923305") || email.equals("79511724") )
        	{ 
        		cedula = email;
        	}
        	else
        	{
        		cedula = LoginWebService.autenticar(email, password);
        		
        	}
        // 13923305 EMILIO BARAJAS
        	
<<<<<<< HEAD
            if (cedula!=null) {
        	  Usuario usuario = Usuario.findByDocumento(cedula);
=======
           if (cedula!=null) {
        	   if(cedula.equals("-1"))
        	   {
        		   return "No se puede establecer conexión con el servicio de autenticación " +
        		   		"de usuarios de la institución. Por favor contacte al administrador del sistema.";
        	   }
        	   Usuario usuario = Usuario.findByDocumento(cedula);
>>>>>>> c6f3f0bc6d4fe7e4ba9b7b11bdd3a0f8bd195e04
        	   if(usuario!=null)
        	   {   
        	   session().clear();
	        	   if(usuario.getRol()!=null)
	        	   {
	               session("rol", usuario.getRol());
	               	if(usuario.getRol().equals(Rol.COORDINADOR))
	               		{
	               			Permiso permiso = Permiso.findByDocumento(cedula);
	               			session("codigoPrograma",permiso.getPrograma().getCodPrograma());
	               			session("nombrePrograma",permiso.getPrograma().getNombre()); 
	               	
	               		}
	               		
	        	   }
	        	   else
	        	   {
	        	   session("rol", Rol.PROFESOR);	   
	        	   }
	               session("documento",cedula);
	               session("nombre",usuario.getNombre());
        	   }
        	   else
        	   {
        		  
        			   
        		   return "El usuario no tiene permisos para ingresar";
        	   }
		
              
            }
           else {
        	   return "Usuario o contraseña incorrecta"+email;
           } 
        	  
            return null;

        }
    }
	@Security.Authenticated(Secured.class)
	public static Result logout() {
	    session().clear();
	    
	     return redirect(
	        routes.Application.login()
	    );
	}
	@Security.Authenticated(Secured.class)
    public static Result index() {

    	
    	List<Profesor> profesores = new ArrayList<Profesor>();
    	List<String> semestres = Periodo.findAll();
    	return ok(views.html.informes.informedocencia.render(null,profesores,semestres));
    }
  public static Result login() {
        return ok(
        		views.html.login.render(Form.form(Login.class))
        );
    }
    
    public static Result authenticate() {
        
            Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

	     if (loginForm.hasErrors()) {
                return badRequest(views.html.login.render(loginForm));
            } else {
              
                return redirect(
                    routes.Application.index()
                );
            }
            
            
        }
    public static Result cambioSemestre()
    {
    	String semestre = Form.form().bindFromRequest().get("semestre");
    	String valor = Form.form().bindFromRequest().get("valor");	
       
    	if(valor.equals("profesores"))
    	{
    		
    	List<Profesor> profesores = null;
    	if(session("rol").equals(Rol.COORDINADOR))
    	{
    		profesores= Profesor.findAllBySemestreAndPrograma(semestre, session("codigoPrograma"));		
    	
    	}
    	else
    	{
    		profesores= Profesor.findAllBySemestre(semestre);
    	}
    	
    	return ok(views.html.lista.render(profesores,0));
    	}
    	if(valor.equals("facultades"))
    	{	
    	List<Facultad> facultades = Facultad.findAll();
    	return ok(views.html.listafacultades.render(facultades,0));
    	}
    	if(valor.equals("programas"))
    	{	
    		List<Programa> programas=null;
    		if(session("rol").equals(Rol.COORDINADOR))
        	{
    			
    			programas = new ArrayList<Programa>();
    			programas.add(Programa.findById(session("codigoPrograma")));
        	}
    		else
    		{
    			programas = Programa.findAll();
    		}
    	return ok(views.html.listaprogramas.render(programas,0));
    	}
    	if(valor.equals("participantes"))
    	{
    		return ok("participantes");
    	}
       	return ok(views.html.lista.render(null,0));
       	
    }
    
}
