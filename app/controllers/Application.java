package controllers;

import java.util.ArrayList;
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
    	
    	
    	String documento = "51625497";
    	String semestre = "20132";
    	Profesor profesor = new Profesor(documento,"","");
    	List<EvaluacionMateria> evaluacionMaterias = profesor.getEvaluacion(semestre);
    	List<Profesor> profesores = Profesor.findAllBySemestre("20132");
    	return ok(views.html.informes.informedocencia.render(evaluacionMaterias,profesores));
    	
    	/*
    	List<EvaluacionMateria> ev = new ArrayList<EvaluacionMateria>();
    	
    	ev.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("AA","050"),false));
    	ev.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("AACCDD","150"),false));
    	ev.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("WWAA","050"),false));
    	
    	System.out.println(ev.indexOf
				(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("WWAA","050"),false)));
    	return ok("prueba:");
    */	
    }

}
