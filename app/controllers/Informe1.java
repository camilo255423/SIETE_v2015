package controllers;

import java.util.List;

import models.EvaluacionMateria;
import models.Profesor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Informe1 extends Controller {

    public static Result index() {
    
    	return null;
    }
   public static Result informeProfesor()
   {
	   String documento = Form.form().bindFromRequest().get("documento");
   	String semestre = "20132";
   	Profesor profesor = new Profesor(documento,"","");
   	List<EvaluacionMateria> evaluacionMaterias = profesor.getEvaluacion(semestre);
   	List<Profesor> profesores = Profesor.findAllBySemestre("20132");
   	return ok(views.html.informes.informeprofesor.render(evaluacionMaterias));
   }
}  