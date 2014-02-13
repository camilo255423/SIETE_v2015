package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

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
    	String documento = Form.form().bindFromRequest().get("documento");
       	String semestre = Form.form().bindFromRequest().get("semestre");
    
    	Profesor profesor = Profesor.findByDocumento(documento);
    	Evaluacion evaluacion = InformesDAO.getInformeFinal(documento, semestre);
    	EvaluacionMateria evaluacionDocencia=null;
    	EvaluacionMateria autoEvaluacionDocencia=null;
    	if(evaluacion.getEvaluacionDocencia().size()>=1) evaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(0);
    	if(evaluacion.getEvaluacionDocencia().size()>=2) autoEvaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(1);

    	return ok(views.html.informes.informefinal.render(evaluacionDocencia,autoEvaluacionDocencia,evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),evaluacion.getAutoEvaluacionInvestigacion()));
    	
 	
    }
    public static Result pdf(String documento, String semestre)
    {
 			Document document = new Document();
 		    document.open();
 		    File file=null; 
 		    File folder = new File(".");
 		    final File[] files = folder.listFiles();
 		    for ( final File f : files ) {
 		    	System.out.println(f);
 		    	if(f.getName().contains(".pdf"))
 		    	{	
 			        if ( !f.delete() ) {
 			            System.err.println( "Can't remove " + f.getAbsolutePath() );
 			        }
 		    	}
 		    }
 		   Profesor profesor = Profesor.findByDocumento(documento);
 		   Evaluacion evaluacion = InformesDAO.getInformeFinal(documento, semestre);
 	    	EvaluacionMateria evaluacionDocencia=null;
 	    	EvaluacionMateria autoEvaluacionDocencia=null;
 	    	if(evaluacion.getEvaluacionDocencia().size()>=1) evaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(0);
 	    	if(evaluacion.getEvaluacionDocencia().size()>=2) autoEvaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(1);

 			try {
 				file = new File(profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".pdf");
 				PdfWriter writer = PdfWriter.getInstance(document,
 						
 				        new FileOutputStream(file));
 				String imagen = routes.Assets.at("images/logo-inpahu.png").absoluteURL(request());
 				System.out.println("Ejecutando!!!");
 				document.open();
 				//XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informefinal.render(evaluacionDocencia,autoEvaluacionDocencia,evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),evaluacion.getAutoEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 	        	
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (DocumentException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}

 		
 		    

 		    document.close();
 			return ok(file);
 	    
    }

}    