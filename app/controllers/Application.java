package controllers;

import java.util.ArrayList;
import java.util.List;

import play.*;
import models.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	String documento = "51625497";
    	String semestre = "20132";
    	Profesor profesor = new Profesor(documento,"","");
    	Evaluacion evaluacion = profesor.getEvaluacion(semestre);
    	List<Profesor> profesores = Profesor.findAllBySemestre("20132");
    	List<String> semestres = Periodo.findAll();
    	return ok(views.html.informes.informedocencia.render(evaluacion.getEvaluacionDocencia(),profesores,semestres));
    }
    public static Result cambioSemestre()
    {
    	String semestre = Form.form().bindFromRequest().get("semestre");
        	
       	List<Profesor> profesores = Profesor.findAllBySemestre(semestre);
       
       	return ok(views.html.lista.render(profesores,0));
       	
    }
    public static Result prueba()
    {
    	String documento = "1014177975";
       	String semestre = "20132";
       	Profesor profesor = new Profesor(documento,"","");
       	Evaluacion evaluacion = profesor.getEvaluacion(semestre);
       	
       	return ok("prueba :"+evaluacion.toString());
    	
  /*  	String documento = "51625497";
    	String semestre = "20132";
    	Profesor profesor = new Profesor(documento,"","");
    	Evaluacion evaluacion = profesor.getEvaluacion(semestre);
    	List<Profesor> profesores = Profesor.findAllBySemestre("20132");
    	return ok(views.html.informes.informedocencia.render(evaluacion,profesores));
    	*/
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
