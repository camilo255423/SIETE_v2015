package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;
/**
 * clase que permite restringir las acciones de los controladores
 * a usuarios autenticados
 * @author Camilo Rodríguez
 *
 */
public class Secured extends Security.Authenticator {
	/**
	 * Devuelve el documento del usuario registrado en la variable de sesión
	 */

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("documento");
    }
    
    /**
     * Método que redirecciona al login en caso de que el usuario
     * no esté autenticado.
     */
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.login());
    }
}