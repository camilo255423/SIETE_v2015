package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import models.AutocompleteValue;
import models.Permiso;
import models.Rol;
import models.Usuario;


import com.fasterxml.jackson.databind.node.ObjectNode;



import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

public class Admin extends Controller{
	public static List<String> locations() {
		   final List<String> result = new ArrayList<String>();
		   final String[] timeZones = TimeZone.getAvailableIDs();
		   for (int i = 0; i < timeZones.length; i++) {
		      final String[] parts = timeZones[i].split("/");
		      if (parts.length == 2 && parts[1].matches("[A-Za-z_]+")) {
		         final String location = parts[1].replaceAll("_", " ");
		         result.add(location);
		      }
		   }
		   Collections.sort(result);
		   return result;
	}
	public static Result borrar()
	{
		String documento = Form.form().bindFromRequest().get("documento");
		String codPrograma = Form.form().bindFromRequest().get("codPrograma");
		if(Permiso.delete(documento,codPrograma))
		{	
		return ok("ok");
		}
		return ok("error");
	}
	
	public static Result insertar()
	{
		String documento = Form.form().bindFromRequest().get("documento");
		String idRol = Form.form().bindFromRequest().get("idRol");
		String codigoPrograma = Form.form().bindFromRequest().get("codigoPrograma");
		if(Permiso.existePermiso(documento, idRol, codigoPrograma))
		{
			return ok("duplicado");
		}
		
		if(Permiso.save(documento,idRol,codigoPrograma))
		{	
		return ok("ok");
		}
		return ok("error");
	}
	
	public static int AUTOCOMPLETE_MAX = 20;
	

	public static Result autocompleteLabel(final String termino) {
		final List<AutocompleteValue> response = new ArrayList<AutocompleteValue>();
		
		   ObjectNode result = Json.newObject();
		   int i=0;
		   for (Usuario usuario : Usuario.findAllByNombre(termino.toUpperCase())) {
			   ObjectNode nodo = Json.newObject();
			   nodo.put("value", usuario.getDocumento());
			   nodo.put("label", usuario.getNombre());
		       result.put(i+"", nodo);
		      
		      if (response.size() == AUTOCOMPLETE_MAX) {
		         break;
		      }
		      i++;
		   }
		   
		   return ok(result);
	}
	@Security.Authenticated(Secured.class)
	  public static Result index() {
		  if(!session("rol").equals(Rol.ADMINISTRADOR))
		  {
			  return ok("Acceso denegado para este rol");
		  }
	    	List<Permiso> permisos = Permiso.findAll();
	    
	    	return ok(views.html.admin.render(permisos));
	    }

}
