package controllers;


import java.util.ArrayList;
import java.util.List;


import models.*;
import play.data.Form;
import play.mvc.*;


public class Application extends Controller {
	public static class Login {

        public String email;
        public String password;
        
        public String validate() {
        String cedula = LoginWebService.autenticar(email, password);
           if (cedula!=null) {
        	   session().clear();
               session("rol", Rol.ADMINISTRADOR);
               session("documento",cedula);
              
            }
           else {
        	   return "Usuario o contraseña incorrecta";
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
    	List<Profesor> profesores = Profesor.findAllBySemestre(semestre);
    	
    	return ok(views.html.lista.render(profesores,0));
    	}
    	if(valor.equals("facultades"))
    	{	
    	List<Facultad> facultades = Facultad.findAll();
    	return ok(views.html.listafacultades.render(facultades,0));
    	}
    	if(valor.equals("programas"))
    	{	
    	List<Programa> programas = Programa.findAll();
    	return ok(views.html.listaprogramas.render(programas,0));
    	}
    	if(valor.equals("participantes"))
    	{
    		return ok("participantes");
    	}
       	return ok(views.html.lista.render(null,0));
       	
    }
    
}
