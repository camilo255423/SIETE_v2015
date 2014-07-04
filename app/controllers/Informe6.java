package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import models.Evaluacion;
import models.EvaluacionGestion;
import models.EvaluacionInvestigacion;
import models.EvaluacionMateria;
import models.Facultad;
import models.InformesDAO;
import models.Nivel;
import models.NumeroParticipantes;
import models.Pregunta;
import models.Profesor;
import models.Programa;
import models.ReportesDAO;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Este controlador se encarga de procesar las solicitudes del informe 6
 * correspondiente al informe de participantes.
 * Genera la vista  html, pdf y  excel.
 * @author Camilo Rodríguez
 *
 *
 */

public class Informe6 extends Controller {
	@Security.Authenticated(Secured.class)
    public static Result index() {
    
    	return null;
    }
	@Security.Authenticated(Secured.class)
    public static Result informeParticipantes()
    {
    	String semestre = Form.form().bindFromRequest().get("semestre");
    	NumeroParticipantes numeroParticipantes = NumeroParticipantes.findBySemestre(semestre);
      return ok(views.html.informes.informeparticipantes.render(numeroParticipantes.getEstudiantesEvaluadosPorFacultad(),
    			numeroParticipantes.getDocentesEvaluadosPorEstudiantesPorFacultad(),
     			numeroParticipantes.getDocentesConAutoevaluacionPorFacultad(),
   			numeroParticipantes.getDirectivosGestionEvaluadosPorFacultad(),
   			numeroParticipantes.getDirectivosInvestigacionEvaluadosPorFacultad(),semestre));
    	
 	
    }
	/**
	 * Genera el respectivo pdf para el informe 6-informe de participantes. 
	 * @param documento Este parámetro no se utiliza
	 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
	 * @return devuelve el pdf generado
	 */
	@Security.Authenticated(Secured.class)
    public static Result pdf(String Documento, String semestre)
    {
 			Document document = new Document();
 		    document.open();
 		    File file=null; 
 	
 		   NumeroParticipantes numeroParticipantes = NumeroParticipantes.findBySemestre(semestre);
 	    	
 			try {
 				file = new File("Participantes Evaluación Docente "+semestre+".pdf");
 				PdfWriter writer = PdfWriter.getInstance(document,
 						
 				        new FileOutputStream(file));
 				String imagen = routes.Assets.at(Application.LOGO_INPAHU).absoluteURL(request());
 				
 				document.open();
 				//XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeparticipantes.render
 						(numeroParticipantes.getEstudiantesEvaluadosPorFacultad(),
 				    			numeroParticipantes.getDocentesEvaluadosPorEstudiantesPorFacultad(),
 				     			numeroParticipantes.getDocentesConAutoevaluacionPorFacultad(),
 				   			numeroParticipantes.getDirectivosGestionEvaluadosPorFacultad(),
 				   			numeroParticipantes.getDirectivosInvestigacionEvaluadosPorFacultad(), semestre, imagen).toString()));
 	        

 	 			response().setContentType("application/x-download");  
 	 	  		response().setHeader("Content-disposition","attachment; filename="+"Participantes Evaluación Docente "+semestre+".pdf");
 	 	   	
 	 		    

 	 		    document.close();
 	 			return ok(file);
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
 			finally {
 		        file.delete();
 		    }

 			return ok("");

 	    
    }
	 /**
		 * Genera el archivo excel del informe 6-informe de participantes
		 * @param documento Este parámetro no se utiliza
		 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
		 * @return devuelve el archivo de excel generado.
		 */
	@Security.Authenticated(Secured.class)
	public static Result excel(String codigoPrograma, String semestre)
    {
    	NumeroParticipantes numeroParticipantes = NumeroParticipantes.findBySemestre(semestre);
        	HSSFWorkbook workbook = new HSSFWorkbook();
        	ArrayList<Facultad> estudiantesEvaluadosPorFacultad = numeroParticipantes.getEstudiantesEvaluadosPorFacultad();
        	ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad = numeroParticipantes.getDocentesEvaluadosPorEstudiantesPorFacultad();
        	ArrayList<Facultad> docentesConAutoevaluacionPorFacultad = numeroParticipantes.getDocentesConAutoevaluacionPorFacultad();
        	ArrayList<Facultad> directivosGestionEvaluadosPorFacultad = numeroParticipantes.getDirectivosGestionEvaluadosPorFacultad();
        	ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad = numeroParticipantes.getDirectivosInvestigacionEvaluadosPorFacultad();
        	HSSFSheet sheet = workbook.createSheet("Número de participantes "+semestre);
   		
   		
   		
	    double total=0;
	    int fila=0;
   		int columna=0;
   		Row row = null;
   		//No estudiantes
   		columna=0;
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		row.createCell(columna).setCellValue("Número de estudiantes evaluados");
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Facultad");
   		row.createCell(columna++).setCellValue("No de Estudiantes Participantes");
   		row.createCell(columna++).setCellValue("Total Estudiantes");
   		row.createCell(columna++).setCellValue("Porcentaje");
   		for(Facultad facultad:estudiantesEvaluadosPorFacultad)
   		{	
   		columna=0;
   		row = sheet.createRow(fila++);
  	   	row.createCell(columna++).setCellValue(facultad.getNombre());
   		row.createCell(columna++).setCellValue(facultad.getParticipantes());
   		row.createCell(columna++).setCellValue(facultad.getTotal());
   		row.createCell(columna++).setCellValue(facultad.getPorcentaje());
   		}
   	//No docentes evaluados por estudiantes
   		columna=0;
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		row.createCell(columna).setCellValue("Número de docentes evaluados por los estudiantes");
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Facultad");
   		row.createCell(columna++).setCellValue("No de Docentes");
   		row.createCell(columna++).setCellValue("Total Estudiantes");
   		row.createCell(columna++).setCellValue("Porcentaje");
   		for(Facultad facultad:docentesEvaluadosPorEstudiantesPorFacultad)
   		{	
   		columna=0;
   		row = sheet.createRow(fila++);
  	   	row.createCell(columna++).setCellValue(facultad.getNombre());
   		row.createCell(columna++).setCellValue(facultad.getParticipantes());
   		row.createCell(columna++).setCellValue(facultad.getTotal());
   		row.createCell(columna++).setCellValue(facultad.getPorcentaje());
   		}
   	//No docentes con autoevaluación
   		columna=0;
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		row.createCell(columna).setCellValue("Número de docentes con autoevaluación");
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Facultad");
   		row.createCell(columna++).setCellValue("No de Docentes");
   		row.createCell(columna++).setCellValue("Total Estudiantes");
   		row.createCell(columna++).setCellValue("Porcentaje");
   		for(Facultad facultad:docentesConAutoevaluacionPorFacultad)
   		{	
   		columna=0;
   		row = sheet.createRow(fila++);
  	   	row.createCell(columna++).setCellValue(facultad.getNombre());
   		row.createCell(columna++).setCellValue(facultad.getParticipantes());
   		row.createCell(columna++).setCellValue(facultad.getTotal());
   		row.createCell(columna++).setCellValue(facultad.getPorcentaje());
   		}
   	//No directivos que realizaron gestión
   		columna=0;
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		row.createCell(columna).setCellValue("Número de directivos que evaluaron gestión");
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Facultad");
   		row.createCell(columna++).setCellValue("No de Directivos");
   		row.createCell(columna++).setCellValue("Total Estudiantes");
   		row.createCell(columna++).setCellValue("Porcentaje");
   		for(Facultad facultad:directivosGestionEvaluadosPorFacultad)
   		{	
   		columna=0;
   		row = sheet.createRow(fila++);
  	   	row.createCell(columna++).setCellValue(facultad.getNombre());
   		row.createCell(columna++).setCellValue(facultad.getParticipantes());
   		row.createCell(columna++).setCellValue(facultad.getTotal());
   		row.createCell(columna++).setCellValue(facultad.getPorcentaje());
   		}
   	//No estudiantes
   		columna=0;
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		row.createCell(columna).setCellValue("Número de directivos");
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Facultad");
   		row.createCell(columna++).setCellValue("No de Estudiantes Participantes");
   		row.createCell(columna++).setCellValue("Total Estudiantes");
   		row.createCell(columna++).setCellValue("Porcentaje");
   		for(Facultad facultad:directivosInvestigacionEvaluadosPorFacultad)
   		{	
   		columna=0;
   		row = sheet.createRow(fila++);
  	   	row.createCell(columna++).setCellValue(facultad.getNombre());
   		row.createCell(columna++).setCellValue(facultad.getParticipantes());
   		row.createCell(columna++).setCellValue(facultad.getTotal());
   		row.createCell(columna++).setCellValue(facultad.getPorcentaje());
   		}
   		//Set value to new value
   		 FileOutputStream out;
   		 File file = new File("Número de participantes evaluación desempeño docente "+semestre+".xls");
   		
   		try {
   		    out = 
   		            new FileOutputStream(file);
   		    workbook.write(out);
   		    out.close();
   			response().setContentType("application/x-download");  
   		  	response().setHeader("Content-disposition","attachment; filename="+"Participantes Evaluación Docente "+semestre+".xls");
   		   	
   	   		return ok(file);
	    
   		    
   		} catch (FileNotFoundException e) {
   		    e.printStackTrace();
   		} catch (IOException e) {
   		    e.printStackTrace();
   		}
   		finally {
	        file.delete();
	    }

		return ok("");
   	
    }


}    
