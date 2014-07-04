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
import models.InformesDAO;
import models.Nivel;
import models.Pregunta;
import models.Profesor;
import models.Programa;
import models.SaberNivel;
import models.ReportesDAO;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Este controlador se encarga de procesar las solicitudes del informe 5
 * correspondiente al informe por Programa.
 * Genera la vista  html, pdf y  excel.
 * @author Camilo Rodríguez
 *
 *
 */

public class Informe5 extends Controller {
	@Security.Authenticated(Secured.class)
    public static Result index() {
    
    	return null;
    }
	@Security.Authenticated(Secured.class)
    public static Result informePrograma()
    {
    	ArrayList<SaberNivel> mejorPeorSaberDocencia;
    	String codigoPrograma = Form.form().bindFromRequest().get("documento");
       	String semestre = Form.form().bindFromRequest().get("semestre");
        Programa programa = Programa.findById(codigoPrograma);
 		
    	Evaluacion evaluacion = ReportesDAO.getInformePrograma(codigoPrograma, semestre);
    	EvaluacionMateria evaluacionDocencia=null;
    	EvaluacionMateria autoEvaluacionDocencia=null;

    	if(evaluacion.getEvaluacionDocencia().size()>=1) evaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(0);
    	if(evaluacion.getEvaluacionDocencia().size()>=2) autoEvaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(1);
    	mejorPeorSaberDocencia = ReportesDAO.getMejorPeorCampoDocencia(evaluacion.getEvaluacionDocencia());
    	return ok(views.html.informes.informeprograma.render(evaluacionDocencia,autoEvaluacionDocencia,
    			evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),
    			evaluacion.getAutoEvaluacionInvestigacion(),mejorPeorSaberDocencia,programa,semestre));
    	
 	
    }
	/**
	 * Genera el respectivo pdf para el informe 5-informe por Programa. 
	 * @param documento Recibe de la vista el id del Programa
	 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
	 * @return devuelve el pdf generado
	 */
	@Security.Authenticated(Secured.class)
    public static Result pdf(String codigoPrograma, String semestre)
    {
 			Document document = new Document();
 		    document.open();
 		    File file=null; 
 		  
 	
 		   Programa programa = Programa.findById(codigoPrograma);
 		  ArrayList<SaberNivel> mejorPeorSaberDocencia;
 	    	
 		  Evaluacion evaluacion = ReportesDAO.getInformePrograma(codigoPrograma, semestre);
 	    	EvaluacionMateria evaluacionDocencia=null;
 	    	EvaluacionMateria autoEvaluacionDocencia=null;
 	    	if(evaluacion.getEvaluacionDocencia().size()>=1) evaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(0);
 	    	if(evaluacion.getEvaluacionDocencia().size()>=2) autoEvaluacionDocencia =  evaluacion.getEvaluacionDocencia().get(1);
 	    	mejorPeorSaberDocencia = ReportesDAO.getMejorPeorCampoDocencia(evaluacion.getEvaluacionDocencia());
 	    	
 			try {
 				file = new File("Programa "+programa.getCodPrograma()+" "+programa.getNombre()+" "+semestre+".pdf");
 				PdfWriter writer = PdfWriter.getInstance(document,
 						
 				        new FileOutputStream(file));
 				String imagen = routes.Assets.at(Application.LOGO_INPAHU).absoluteURL(request());
 				
 				document.open();
 				//XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeheteroevaluacion.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), profesor, semestre, imagen).toString()));
 				XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeprograma.render(evaluacionDocencia,autoEvaluacionDocencia,evaluacion.getEvaluacionGestion(),evaluacion.getEvaluacionInvestigacion(),evaluacion.getAutoEvaluacionGestion(),evaluacion.getAutoEvaluacionInvestigacion(),
 						mejorPeorSaberDocencia,programa, semestre, imagen).toString()));
 				 
 	 			response().setContentType("application/x-download");  
 	 	  		response().setHeader("Content-disposition","attachment; filename="+"Programa "+programa.getCodPrograma()+" "+programa.getNombre()+" "+semestre+".pdf");
 	 	   	
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
	 * Genera el archivo excel del informe 5-informe por Programa
	 * @param documento Recibe de la vista el id del Programa
	 * @param semestre Recibe de la vista el semestre seleccionado por el usuario
	 * @return devuelve el archivo de excel generado.
	 */
	@Security.Authenticated(Secured.class)
    public static Result excel(String codigoPrograma, String semestre)
    {
    	Programa programa = Programa.findById(codigoPrograma);
    	Evaluacion evaluacion = ReportesDAO.getInformePrograma(codigoPrograma, semestre);
    	ArrayList<SaberNivel>mejorPeor = ReportesDAO.getMejorPeorCampoDocencia(evaluacion.getEvaluacionDocencia());
 	    
   		HSSFWorkbook workbook = new HSSFWorkbook();
   		EvaluacionGestion eg = evaluacion.getEvaluacionGestion();
   		EvaluacionGestion aeg = evaluacion.getAutoEvaluacionGestion(); 
   		EvaluacionInvestigacion ei = evaluacion.getEvaluacionInvestigacion();
   		EvaluacionInvestigacion aei = evaluacion.getAutoEvaluacionInvestigacion();
   		HSSFSheet sheet = workbook.createSheet("Informe Programa");
   		double porcentajeDocenciaEstudiantes=0.8;
   		double porcentajeDocenciaAutoevaluacion=0.2;
   		double porcentajeGestion=0.6;
   		double porcentajeGestionAutoevaluacion=0.4;
   		double porcentajeInvestigacion=0.6;
   		double porcentajeInvestigacionAutoevaluacion=0.4;
   		
	    int fila=0;
   		int columna=0;
   		Row row = null;
   		//DOCENCIA
   		EvaluacionMateria ev =  evaluacion.getEvaluacionDocencia().get(0);
   		EvaluacionMateria aev =  evaluacion.getEvaluacionDocencia().get(1);
   			columna=0;
   		 row = sheet.createRow(fila++);
   		row = sheet.createRow(fila++);
   		String saberes[]={"Saber Pedagógico","Saber Específico","Saber Relacional"};
   		row.createCell(columna++).setCellValue("Mejor Saber Docencia: "+mejorPeor.get(0).getSaber()+" Nivel: "+Nivel.toString(mejorPeor.get(0).getNivel()) +" "+ mejorPeor.get(0).getPromedio()+ "% "+  
   			 ", Peor Saber Docencia: "+mejorPeor.get(1).getSaber()+" Nivel: "+Nivel.toString(mejorPeor.get(1).getNivel())+" "+mejorPeor.get(1).getPromedio()+"%");
   		columna=0;
  		 row = sheet.createRow(fila++);
  		row = sheet.createRow(fila++);
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
 		row.createCell(columna++).setCellValue(porcentajeInvestigacion*ei.getPromedioRespuestas()[Nivel.INFERIOR]+porcentajeInvestigacionAutoevaluacion*aei.getPromedioRespuestas()[Nivel.INFERIOR]);
 		  
   		
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Bajo");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.BAJO]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.BAJO]);	
 		row.createCell(columna++).setCellValue(porcentajeInvestigacion*ei.getPromedioRespuestas()[Nivel.BAJO]+porcentajeInvestigacionAutoevaluacion*aei.getPromedioRespuestas()[Nivel.BAJO]);
 		  
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Medio");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.MEDIO]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.MEDIO]);	
 		row.createCell(columna++).setCellValue(porcentajeInvestigacion*ei.getPromedioRespuestas()[Nivel.MEDIO]+porcentajeInvestigacionAutoevaluacion*aei.getPromedioRespuestas()[Nivel.MEDIO]);
 		  
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Alto");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.ALTO]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.ALTO]);	
 		row.createCell(columna++).setCellValue(porcentajeInvestigacion*ei.getPromedioRespuestas()[Nivel.ALTO]+porcentajeInvestigacionAutoevaluacion*aei.getPromedioRespuestas()[Nivel.ALTO]);
 		  
   		row = sheet.createRow(fila++);
   		columna=0;
   		row.createCell(columna++).setCellValue("Superior");
   		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.SUPERIOR]);	
   		row.createCell(columna++).setCellValue(aei.getPromedioRespuestas()[Nivel.SUPERIOR]);	
 		row.createCell(columna++).setCellValue(porcentajeInvestigacion*ei.getPromedioRespuestas()[Nivel.SUPERIOR]+porcentajeInvestigacionAutoevaluacion*aei.getPromedioRespuestas()[Nivel.SUPERIOR]);
 		  
   		//Set value to new value
   		 FileOutputStream out;
   		 File file = new File("Programa "+programa.getCodPrograma()+" "+programa.getNombre()+" "+semestre+".xls");
   		
   		try {
   		    out = 
   		            new FileOutputStream(file);
   		    workbook.write(out);
   		    out.close();
   			response().setContentType("application/x-download");  
   		  	response().setHeader("Content-disposition","attachment; filename="+"Programa "+programa.getCodPrograma()+" "+programa.getNombre()+" "+semestre+".xls");
   		   		
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