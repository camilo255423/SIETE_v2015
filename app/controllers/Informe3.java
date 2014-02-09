package controllers;

import models.Evaluacion;
import models.EvaluacionMateria;
import models.InformesDAO;
import models.Profesor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Informe3 extends Controller {

    public static Result index() {
    
    	return null;
    }
    public static Result informeProfesor()
    {
    	//String documento = Form.form().bindFromRequest().get("documento");
       	//String semestre = Form.form().bindFromRequest().get("semestre");
    	String documento = "51832657";
    	String semestre = "20132";
    	Profesor profesor = Profesor.findByDocumento(documento);
    	Evaluacion evaluacion = InformesDAO.getInformeFinal(documento, semestre);
    	EvaluacionMateria evaluacionDocencia=null;
    	EvaluacionMateria autoEvaluacionDocencia=null;
    	if(evaluacion.getEvaluacionDocencia().size()>=1) evaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(0);
    	if(evaluacion.getEvaluacionDocencia().size()>=2) autoEvaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(1);
    	//return ok(evaluacion.toString());
    	if(evaluacionDocencia==null) System.out.println("ed vale null");
    	if(autoEvaluacionDocencia==null) System.out.println("aed vale null");
    	return ok(views.html.informes.informefinal.render(evaluacionDocencia,autoEvaluacionDocencia,evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),evaluacion.getAutoEvaluacionInvestigacion()));
    	
 	
    }
}    