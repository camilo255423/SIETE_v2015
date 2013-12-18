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
    	String documento = "52172636";
    	String semestre = "20132";
    	List<Materia> materias = Materia.findByProfesorAndSemestre(documento, semestre);
    	for(Materia materia:materias)
    	{
    		s=s+materia+"\n";
    	}
    	System.out.println("Controlador Prueba");
    	
    	return ok("prueba: "+"\n"+s);
    }

}
