package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
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
import models.InformesDAO;
import models.Nivel;
import models.Pregunta;
import models.Profesor;
import play.data.Form;
import play.mvc.*;
/**
 * Este controlador se encarga de procesar las solicitudes del informe 2
 * correspondiente al informe de Heteroevaluación.
 * Genera la vista  html, pdf y  excel.
 * @author Camilo Rodríguez
 *
 *
 */
public class Informe2 extends Controller {
	@Security.Authenticated(Secured.class)
    public static Result index() {
    
    	return null;
    }
	/**
	 * Genera el respectivo pdf para el informe 2-Heteroevaluación. 
	 * @param documento Recibe de la vista el documento seleccionado por el usuario
	 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
	 * @return devuelve el pdf generado
	 */
	@Security.Authenticated(Secured.class)
    public static Result pdf(String documento, String semestre)
    {
 			Document document = new Document();
 		    document.open();
 		    File file=null; 
 		    Profesor profesor = Profesor.findByDocumento(documento);
 	    	Evaluacion evaluacion = InformesDAO.getInformeHeteroEvaluacion(documento, semestre);
 	    	
 			try {
 				file = new File(profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".pdf");
 				PdfWriter writer = PdfWriter.getInstance(document,
 						
 				        new FileOutputStream(file));
 				String imagen = Application.LOGO_INPAHU;
 				
 				document.open();
 				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				response().setContentType("application/x-download");  
 	 	  		response().setHeader("Content-disposition","attachment; filename="+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".pdf");
 	 	   	    

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
	 * Genera el archivo excel del informe 2-Heteroevaluación
	 * @param documento Recibe de la vista el documento seleccionado por el usuario
	 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
	 * @return devuelve el archivo de excel generado.
	 */
	
	@Security.Authenticated(Secured.class)
	public static Result excel(String documento, String semestre)
    {
    	Profesor profesor = Profesor.findByDocumento(documento);
    	Evaluacion evaluacion = InformesDAO.getInformeHeteroEvaluacion(documento, semestre);
   		HSSFWorkbook workbook = new HSSFWorkbook();
   		EvaluacionGestion eg = evaluacion.getEvaluacionGestion();
   		EvaluacionInvestigacion ei = evaluacion.getEvaluacionInvestigacion();
   		HSSFSheet sheet = workbook.createSheet("Heteroevaluación");
   		//Create a new row in current sheet
   	    double total=0;
	    int fila=0;
   		int columna=0;
   		Row row = null;
   		//DOCENCIA
   		for(EvaluacionMateria ev : evaluacion.getEvaluacionDocencia())
   		{
   			columna=0;
   		 row = sheet.createRow(fila++);
   		//Create a new cell in current row
   		Cell cell = row.createCell(columna);
   		cell.setCellValue(ev.getMateria().getNombre());
   		row = sheet.createRow(fila++);
   		String saberes[]={"Saber Pedagógico","Saber Específico","Saber Relacional"};
   		for(int w=0;w<=2;w++)
   		{
   		
   		
   		total = ev.getPromedioRespuestas()[w][Nivel.INFERIOR] + ev.getPromedioRespuestas()[w][Nivel.BAJO] +
   				ev.getPromedioRespuestas()[w][Nivel.MEDIO] + ev.getPromedioRespuestas()[w][Nivel.ALTO] +ev.getPromedioRespuestas()[w][Nivel.SUPERIOR];
   		if(total>0)
   		{
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue(saberes[w]);
   		row = sheet.createRow(fila++);
   	   	columna=0;
   	   	row.createCell(columna++).setCellValue("Nivel Inferior");
   	   	row.createCell(columna++).setCellValue("Nivel Bajo");
   	   	row.createCell(columna++).setCellValue("Nivel Medio");
   	   	row.createCell(columna++).setCellValue("Nivel Alto");
   	   	row.createCell(columna++).setCellValue("Nivel Superior");	
   		columna=0;
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.INFERIOR]/total);
		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.BAJO]/total);
		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.MEDIO]/total);
		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.ALTO]/total);
		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.SUPERIOR]/total);
   		}
   		}
   		}
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Gestión");
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		columna=0;

   		row.createCell(columna++).setCellValue("No cumple");
   		row.createCell(columna++).setCellValue("Cumple Parcialmente");
   		row.createCell(columna++).setCellValue("Cumple Totalmente");
   		row.createCell(columna++).setCellValue("No Aplica");
   		
   		fila++;
   		row = sheet.createRow(fila++);
   		columna = 0;
   	
   		total = eg.getPromedioRespuestas()[Nivel.INFERIOR] + eg.getPromedioRespuestas()[Nivel.BAJO] +
   				eg.getPromedioRespuestas()[Nivel.MEDIO] + eg.getPromedioRespuestas()[Nivel.ALTO];
   		if(total>0)
   		{	
   		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.INFERIOR]/total);		
		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.BAJO]/total);
		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.MEDIO]/total);
		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.ALTO]/total);
   		}
		
		row = sheet.createRow(fila++);
		columna=0;
   		row.createCell(columna++).setCellValue("Investigación");
   		columna=0;
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Nivel Inferior");
   		row.createCell(columna++).setCellValue("Nivel Bajo");
   		row.createCell(columna++).setCellValue("Nivel Medio");
   		row.createCell(columna++).setCellValue("Nivel Alto");
   		row.createCell(columna++).setCellValue("Nivel Superior");
   		fila++;
   		row = sheet.createRow(fila++);
   		columna = 0;
   	
   		
   		total = eg.getPromedioRespuestas()[Nivel.INFERIOR] + ei.getPromedioRespuestas()[Nivel.BAJO] +
   				eg.getPromedioRespuestas()[Nivel.MEDIO] + ei.getPromedioRespuestas()[Nivel.ALTO] +ei.getPromedioRespuestas()[Nivel.SUPERIOR];
   		if(total>0)
   		{	
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.INFERIOR]/total);
		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.BAJO]/total);
		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.MEDIO]/total);
		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.ALTO]/total);
		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.SUPERIOR]/total);
   		}
   		
   		//Set value to new value
   		 FileOutputStream out;
   		 File file = new File("Heteroevaluación "+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".xls");
   		
   		try {
   		    out = 
   		            new FileOutputStream(file);
   		    workbook.write(out);
   		    out.close();
   		 response().setContentType("application/x-download");  
   		response().setHeader("Content-disposition","attachment; filename="+"Heteroevaluación "+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".xls");
    	
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
	/**
	 * Genera la página web del informe 2-Heteroevaluación. Recibe los parámetros documento y semestre desde
	 * la vista por POST
	 * @return Retorna la información hacia la vista: views.html.informes.informeprofesor
	 */
	@Security.Authenticated(Secured.class)
	public static Result informeProfesor()
    {
    	String documento = Form.form().bindFromRequest().get("documento");
       	String semestre = Form.form().bindFromRequest().get("semestre");
    	
    	Profesor profesor = Profesor.findByDocumento(documento);
    	Evaluacion evaluacion = InformesDAO.getInformeHeteroEvaluacion(documento, semestre);
    	
    	return ok(views.html.informes.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(),evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),profesor,semestre ));
    	
 	
    }
}