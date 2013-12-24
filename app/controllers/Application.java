package controllers;

import java.util.List;

import play.*;
import models.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result prueba()
    {
    	
    	String s = "";
    	String documento = "51625497";
    	String semestre = "20132";
    	Profesor profesor = new Profesor(documento, semestre);
    	List<EvaluacionMateria> evaluacionMaterias = profesor.getEvaluacion();
    
    	return ok(views.html.informes.informedocencia.render(evaluacionMaterias));
    }

}
