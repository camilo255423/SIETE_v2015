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
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
/**
 * Este controlador se encarga de procesar las solicitudes del informe 3
 * correspondiente al informe Final.
 * Genera la vista  html, pdf y  excel.
 * @author Camilo Rodríguez
 *
 *
 */
public class Informe3 extends Controller {

    public static Result index() {
    
    		Document document = new Document();
 		    document.open();
 		    File file=null; 
 		    File folder = new File(".");
 		    final File[] files = folder.listFiles();
 		    for ( final File f : files ) {
 		    	
 		    	if(f.getName().contains(".pdf"))
 		    	{	
 			        if ( !f.delete() ) {
 			            System.err.println( "Can't remove " + f.getAbsolutePath() );
 			        }
 		    	}
 		    }
 		  
 			try {
 				file = new File("Final.pdf");
 				PdfWriter writer = PdfWriter.getInstance(document,
 						
 				        new FileOutputStream(file));
 				String imagen = "http://192.168.1.215/imagenes/v1/apps/ulises/logoEafit.gif";
 				String imagen2 = routes.Assets.at("images/logoNIT.gif").absoluteURL(request());
				String imagen3 = routes.Assets.at("images/logo.jpg").absoluteURL(request());
 				document.open();
 				//XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.prueba.render(imagen,imagen2,imagen3).toString()));
 	        	
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

 			response().setContentType("application/x-download");  
 	  		response().setHeader("Content-disposition","attachment; filename="+"Final.pdf");
 	   	
 		    

 		    document.close();
 			return ok(file);
 	    
    }
	@Security.Authenticated(Secured.class)
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
    	
    	return ok(views.html.informes.informefinal.render(evaluacionDocencia,autoEvaluacionDocencia,evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),evaluacion.getAutoEvaluacionInvestigacion(),profesor,semestre));
    	
 	
    }
	/**
	 * Genera el respectivo pdf para el informe 3-informe Final. 
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
 		   Evaluacion evaluacion = InformesDAO.getInformeFinal(documento, semestre);
 	    	EvaluacionMateria evaluacionDocencia=null;
 	    	EvaluacionMateria autoEvaluacionDocencia=null;
 	    	if(evaluacion.getEvaluacionDocencia().size()>=1) evaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(0);
 	    	if(evaluacion.getEvaluacionDocencia().size()>=2) autoEvaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(1);

 			try {
 				file = new File("Final "+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".pdf");
 				PdfWriter writer = PdfWriter.getInstance(document,
 						
 				        new FileOutputStream(file));
 				String imagen = routes.Assets.at(Application.LOGO_INPAHU).absoluteURL(request());
 				
 				document.open();
 				//XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informefinal.render(evaluacionDocencia,autoEvaluacionDocencia,evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),evaluacion.getAutoEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				response().setContentType("application/x-download");  
 	 	  		response().setHeader("Content-disposition","attachment; filename="+"Final "+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".pdf");
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
	 * Genera el archivo excel del informe 3-informe Final
	 * @param documento Recibe de la vista el documento seleccionado por el usuario
	 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
	 * @return devuelve el archivo de excel generado.
	 */
	@Security.Authenticated(Secured.class)
	public static Result excel(String documento, String semestre)
    {
    	Profesor profesor = Profesor.findByDocumento(documento);
    	Evaluacion evaluacion = InformesDAO.getInformeFinal(documento, semestre);
   		HSSFWorkbook workbook = new HSSFWorkbook();
   		EvaluacionGestion eg = evaluacion.getEvaluacionGestion();
   		EvaluacionGestion aeg = evaluacion.getAutoEvaluacionGestion(); 
   		EvaluacionInvestigacion ei = evaluacion.getEvaluacionInvestigacion();
   		EvaluacionInvestigacion aei = evaluacion.getAutoEvaluacionInvestigacion();
   		HSSFSheet sheet = workbook.createSheet("Informe Final");
   		double porcentajeDocenciaEstudiantes=0.8;
   		double porcentajeDocenciaAutoevaluacion=0.2;
   		double porcentajeGestion=0.6;
   		double porcentajeGestionAutoevaluacion=0.2;
   		
   		
	    double total=0;
	    int fila=0;
   		int columna=0;
   		Row row = null;
   		//DOCENCIA
   		EvaluacionMateria ev =  evaluacion.getEvaluacionDocencia().get(0);
   		EvaluacionMateria aev =  evaluacion.getEvaluacionDocencia().get(1);
   			columna=0;
   		 row = sheet.createRow(fila++);
   		//Create a new cell in current row
   		Cell cell = row.createCell(columna);
   		row = sheet.createRow(fila++);
   		List<Pregunta> preguntas = Pregunta.getPreguntasEvaluacion(Pregunta.DOCENCIA);
   		String saberes[]={"Saber Pedagógico","Saber Específico","Saber Relacional"};
   		for(int w=0;w<=2;w++)
   		{
   		
   		
   		columna=0;	
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue(saberes[w]);
   		row.createCell(columna++).setCellValue("Porcentaje de Respuestas Estudiantes, Ponderación 80%");
   		row.createCell(columna++).setCellValue("Porcentaje de Respuestas Autoevaluación, Ponderación 20%");
   		row.createCell(columna++).setCellValue("Evaluación Resultante");
   		columna=0;
   		row = sheet.createRow(fila++);
  	   	row.createCell(columna++).setCellValue("Nivel Inferior");
   		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.INFERIOR]);
   		row.createCell(columna++).setCellValue(aev.getPromedioRespuestas()[w][Nivel.INFERIOR]);
   		row.createCell(columna++).setCellValue(porcentajeDocenciaEstudiantes*ev.getPromedioRespuestas()[w][Nivel.INFERIOR]+porcentajeDocenciaAutoevaluacion*aev.getPromedioRespuestas()[w][Nivel.INFERIOR]);
   		
   		columna=0;
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Nivel Bajo");
   		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.BAJO]);
   		row.createCell(columna++).setCellValue(aev.getPromedioRespuestas()[w][Nivel.BAJO]);
   		row.createCell(columna++).setCellValue(porcentajeDocenciaEstudiantes*ev.getPromedioRespuestas()[w][Nivel.BAJO]+porcentajeDocenciaAutoevaluacion*aev.getPromedioRespuestas()[w][Nivel.BAJO]);
   		
   		columna=0;
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Nivel Medio");
   		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.MEDIO]);
   		row.createCell(columna++).setCellValue(aev.getPromedioRespuestas()[w][Nivel.MEDIO]);
   		row.createCell(columna++).setCellValue(porcentajeDocenciaEstudiantes*ev.getPromedioRespuestas()[w][Nivel.MEDIO]+porcentajeDocenciaAutoevaluacion*aev.getPromedioRespuestas()[w][Nivel.MEDIO]);
   		
   		columna=0;
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Nivel Alto");
   		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.ALTO]);
   		row.createCell(columna++).setCellValue(aev.getPromedioRespuestas()[w][Nivel.ALTO]);
   		row.createCell(columna++).setCellValue(porcentajeDocenciaEstudiantes*ev.getPromedioRespuestas()[w][Nivel.ALTO]+porcentajeDocenciaAutoevaluacion*aev.getPromedioRespuestas()[w][Nivel.ALTO]);
   		
   		columna=0;
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Nivel Superior");
   		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.SUPERIOR]);
   		row.createCell(columna++).setCellValue(aev.getPromedioRespuestas()[w][Nivel.SUPERIOR]);
   		row.createCell(columna++).setCellValue(porcentajeDocenciaEstudiantes*ev.getPromedioRespuestas()[w][Nivel.SUPERIOR]+porcentajeDocenciaAutoevaluacion*aev.getPromedioRespuestas()[w][Nivel.SUPERIOR]);
   		row = sheet.createRow(fila++);
   		
   		}
   	
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Gestión");
   		row.createCell(columna++).setCellValue("Porcentaje de Respuestas Directivo, Ponderación 60%");
   		row.createCell(columna++).setCellValue("Porcentaje de Respuestas Autoevaluación, Ponderación 40%");
   		row.createCell(columna++).setCellValue("Evaluación Resultante");
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("No cumple");
   		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.INFERIOR]);	
   		row.createCell(columna++).setCellValue(aeg.getPromedioRespuestas()[Nivel.INFERIOR]);	
   		row.createCell(columna++).setCellValue(porcentajeGestion*eg.getPromedioRespuestas()[Nivel.INFERIOR]+porcentajeGestionAutoevaluacion*aeg.getPromedioRespuestas()[Nivel.INFERIOR]);
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Cumple Parcialmente");
   		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.BAJO]);	
   		row.createCell(columna++).setCellValue(aeg.getPromedioRespuestas()[Nivel.BAJO]);	
   		row.createCell(columna++).setCellValue(porcentajeGestion*eg.getPromedioRespuestas()[Nivel.BAJO]+porcentajeGestionAutoevaluacion*aeg.getPromedioRespuestas()[Nivel.BAJO]);
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Cumple Totalmente");
   		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.MEDIO]);	
   		row.createCell(columna++).setCellValue(aeg.getPromedioRespuestas()[Nivel.MEDIO]);	
   		row.createCell(columna++).setCellValue(porcentajeGestion*eg.getPromedioRespuestas()[Nivel.MEDIO]+porcentajeGestionAutoevaluacion*aeg.getPromedioRespuestas()[Nivel.MEDIO]);
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("No Aplica");
   		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.ALTO]);	
   		row.createCell(columna++).setCellValue(aeg.getPromedioRespuestas()[Nivel.ALTO]);	
   		row.createCell(columna++).setCellValue(porcentajeGestion*eg.getPromedioRespuestas()[Nivel.ALTO]+porcentajeGestionAutoevaluacion*aeg.getPromedioRespuestas()[Nivel.ALTO]);
   		
		
   		row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Investigación");
   		row.createCell(columna++).setCellValue("Porcentaje de Respuestas Directivo, Ponderación 60%");
   		row.createCell(columna++).setCellValue("Porcentaje de Respuestas Autoevaluación, Ponderación 40%");
   		row.createCell(columna++).setCellValue("Evaluación Resultante");
   		columna=0;
   		row = sheet.createRow(fila++);
   		row.createCell(columna++).setCellValue("Inferior");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.INFERIOR]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.INFERIOR]);	
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Bajo");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.BAJO]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.BAJO]);	
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Medio");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.MEDIO]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.MEDIO]);	
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Alto");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.ALTO]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.ALTO]);	
		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Superior");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.SUPERIOR]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.SUPERIOR]);	
   		
   		//Set value to new value
   		 FileOutputStream out;
   		 File file = new File("Final "+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".xls");
   		
   		try {
   		    out = 
   		            new FileOutputStream(file);
   		    workbook.write(out);
   		    out.close();
   		 response().setContentType("application/x-download");  
   		response().setHeader("Content-disposition","attachment; filename="+"Final "+profesor.getApellidos()+" "+profesor.getNombres()+" "+semestre+".xls");
    	
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
