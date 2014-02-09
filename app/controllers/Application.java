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
import org.apache.poi.ss.util.CellRangeAddress;

import play.*;
import models.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

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
    public static Result excel()
    {
 		String documento = "51625497";
     	String semestre = "20132";
     	Profesor profesor = new Profesor(documento,"","");
     	Evaluacion evaluacion = profesor.getEvaluacion(semestre);
    		HSSFWorkbook workbook = new HSSFWorkbook();
    		HSSFSheet sheet = workbook.createSheet("Docencia");
    		//Create a new row in current sheet
    		int fila=0;
    		int columna=0;
    		//DOCENCIA
    		for(EvaluacionMateria ev : evaluacion.getEvaluacionDocencia())
    		{
    			columna=0;
    		Row row = sheet.createRow(fila++);
    		//Create a new cell in current row
    		Cell cell = row.createCell(columna);
    		cell.setCellValue(ev.getMateria().getNombre());
    		row = sheet.createRow(fila++);
    		row.createCell(columna++).setCellValue("Encuestados: "+ev.getEvaluados() +" de "+ev.getMateria().getInscritos()+", "+ 
" porcentaje "+ (10000*ev.getEvaluados()/ev.getMateria().getInscritos()/100.0)+"%");
    		row = sheet.createRow(fila++);
    		row.createCell(columna++).setCellValue("Enunciado");
    		row.createCell(columna++).setCellValue("Nivel Inferior");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Bajo");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Medio");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Alto");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Superior");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		fila++;
    		row = sheet.createRow(fila++);
    		columna = 0;
    		row.createCell(columna++).setCellValue("");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		List<Pregunta> preguntas = Pregunta.getPreguntasEvaluacion(Pregunta.DOCENCIA);
    		String saberes[]={"Saber Pedagógico","Saber Específico","Saber Relacional"};
    		int w=0;
    		for(int i=0;i<=11;i++)
    		{
    		int indice = ev.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()));
	    		if(indice>=0)
	    		{
	    			Pregunta pregunta= ev.getPreguntas().get(indice);
	    			row = sheet.createRow(fila++);
	        		columna = 0;
	        		row.createCell(columna++).setCellValue(pregunta.getEnunciado());
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.SUPERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.SUPERIOR]);
	    			
	    		
	    		if(i==5 || i==8 || i==11)
	    		{
	    			row = sheet.createRow(fila++);
	    			columna=0;
	    			row.createCell(columna++).setCellValue("Promedio "+saberes[w]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.SUPERIOR]);
	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.SUPERIOR]);
	    		w++;
	    		}
	    		}
	    			
	    	}
    		row = sheet.createRow(fila++);
    		}
    		//DOCENCIA AUTOEVALUACIÓN
    		for(EvaluacionMateria evm : evaluacion.getEvaluacionDocencia())
    		{
    		int indiceMat = evaluacion.getEvaluacionDocencia().indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evm.getMateria(),false));
    		if(indiceMat>=0)
    		{	
    			EvaluacionMateria ev = evaluacion.getEvaluacionDocencia().get(indiceMat);
    			columna=0;
        		Row row = sheet.createRow(fila++);
        		//Create a new cell in current row
        		Cell cell = row.createCell(columna);
        		cell.setCellValue(ev.getMateria().getNombre());
        		row = sheet.createRow(fila++);
        		row.createCell(columna++).setCellValue("AUTOEVALUACIÓN");
        		row = sheet.createRow(fila++);
        		row.createCell(columna++).setCellValue("Enunciado");
        		row.createCell(columna++).setCellValue("Nivel Inferior");
        		row.createCell(columna++).setCellValue("");
        		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
        		row.createCell(columna++).setCellValue("Nivel Bajo");
        		row.createCell(columna++).setCellValue("");
        		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
        		row.createCell(columna++).setCellValue("Nivel Medio");
        		row.createCell(columna++).setCellValue("");
        		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
        		row.createCell(columna++).setCellValue("Nivel Alto");
        		row.createCell(columna++).setCellValue("");
        		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
        		row.createCell(columna++).setCellValue("Nivel Superior");
        		row.createCell(columna++).setCellValue("");
        		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
        		fila++;
        		row = sheet.createRow(fila++);
        		columna = 0;
        		row.createCell(columna++).setCellValue("");
        		row.createCell(columna++).setCellValue("Resp");
        		row.createCell(columna++).setCellValue("%");
        		row.createCell(columna++).setCellValue("Resp");
        		row.createCell(columna++).setCellValue("%");
        		row.createCell(columna++).setCellValue("Resp");
        		row.createCell(columna++).setCellValue("%");
        		row.createCell(columna++).setCellValue("Resp");
        		row.createCell(columna++).setCellValue("%");
        		row.createCell(columna++).setCellValue("Resp");
        		row.createCell(columna++).setCellValue("%");
        		List<Pregunta> preguntas = Pregunta.getPreguntasEvaluacion(Pregunta.DOCENCIA);
        		String saberes[]={"Saber Pedagógico","Saber Específico","Saber Relacional"};
        		int w=0;
        		for(int i=0;i<=11;i++)
        		{
        		int indice = ev.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()));
    	    		if(indice>=0)
    	    		{
    	    			
    	    			Pregunta pregunta= ev.getPreguntas().get(indice);
    	    			row = sheet.createRow(fila++);
    	        		columna = 0;
    	        		row.createCell(columna++).setCellValue(pregunta.getEnunciado());
    	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.INFERIOR]);
    	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.INFERIOR]);
    	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.BAJO]);
    	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.BAJO]);
    	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.MEDIO]);
    	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.MEDIO]);
    	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.ALTO]);
    	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.ALTO]);
    	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.SUPERIOR]);
    	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.SUPERIOR]);
    	    			
    	    		
    	    		if(i==5 || i==8 || i==11)
    	    		{
    	    			row = sheet.createRow(fila++);
    	    			columna=0;
    	    			row.createCell(columna++).setCellValue("Promedio "+saberes[w]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.INFERIOR]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.INFERIOR]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.BAJO]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.BAJO]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.MEDIO]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.MEDIO]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.ALTO]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.ALTO]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioRespuestas()[w][Nivel.SUPERIOR]);
    	        		row.createCell(columna++).setCellValue(ev.getPromedioPorcentaje()[w][Nivel.SUPERIOR]);
    	    		w++;
    	    		}
    	    		}
    	    			
    	    	}
        		row = sheet.createRow(fila++);
    		}
    		}
    		//GESTIÓN
    		sheet = workbook.createSheet("Gestión");
    			columna=0;
    			fila=0;
    		Row row = sheet.createRow(fila++);
    		//Create a new cell in current row
    		Cell cell = row.createCell(columna);
    		EvaluacionGestion eg;
    		for(int g=1;g<=2;g++)
    		{	columna=0;
    			row = sheet.createRow(fila++);
    		if(g==1)
    		{	
    		 eg= evaluacion.getEvaluacionGestion();
    			row.createCell(columna++).setCellValue("Gestión");
    		}
    		else
    		{	
    		eg = evaluacion.getAutoEvaluacionGestion();
    		row.createCell(columna++).setCellValue("Gestión Autoevaluación");
    		}
    		
    	
    		row = sheet.createRow(fila);
    		columna=0;
    		row.createCell(columna++).setCellValue("Enunciado");
    		row.createCell(columna++).setCellValue("No cumple");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Cumple Parcialmente");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Cumple Totalmente");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("No Aplica");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		
    		fila++;
    		row = sheet.createRow(fila++);
    		columna = 0;
    		row.createCell(columna++).setCellValue("");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");

    		List<Pregunta> preguntas = Pregunta.getPreguntasEvaluacion(Pregunta.GESTION);
    		for(int i=0;i<=5;i++)
    		{
    		int indice = eg.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()));
	    		if(indice>=0)
	    		{
	    			Pregunta pregunta= eg.getPreguntas().get(indice);
	    			row = sheet.createRow(fila++);
	        		columna = 0;
	        		row.createCell(columna++).setCellValue(pregunta.getEnunciado());
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.ALTO]);
	        
	    			
	    		}
	    			
	    		}
    		row = sheet.createRow(fila++);
			columna=0;
			row.createCell(columna++).setCellValue("Promedio ");
    		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.INFERIOR]);
    		row.createCell(columna++).setCellValue(eg.getPromedioPorcentaje()[Nivel.INFERIOR]);
    		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.BAJO]);
    		row.createCell(columna++).setCellValue(eg.getPromedioPorcentaje()[Nivel.BAJO]);
    		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.MEDIO]);
    		row.createCell(columna++).setCellValue(eg.getPromedioPorcentaje()[Nivel.MEDIO]);
    		row.createCell(columna++).setCellValue(eg.getPromedioRespuestas()[Nivel.ALTO]);
    		row.createCell(columna++).setCellValue(eg.getPromedioPorcentaje()[Nivel.ALTO]);

    		}//fin gestión i =1 to 2
    		//Investigación
    		sheet = workbook.createSheet("Investigación");
    			columna=0;
    			fila=0;
    		 row = sheet.createRow(fila++);
    		//Create a new cell in current row
    		 cell = row.createCell(columna);
    		EvaluacionInvestigacion ei;
    		for(int g=1;g<=2;g++)
    		{	columna=0;
    			row = sheet.createRow(fila++);
    		if(g==1)
    		{	
    		 ei= evaluacion.getEvaluacionInvestigacion();
    			row.createCell(columna++).setCellValue("Investigación");
    		}
    		else
    		{	
    		ei = evaluacion.getAutoEvaluacionInvestigacion();
    		row.createCell(columna++).setCellValue("Investigación Autoevaluación");
    		}
    		
    	
    		row = sheet.createRow(fila);
    		columna=0;
    		row.createCell(columna++).setCellValue("Enunciado");
    		row.createCell(columna++).setCellValue("Nivel Inferior");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Bajo");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Medio");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Alto");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		row.createCell(columna++).setCellValue("Nivel Superior");
    		row.createCell(columna++).setCellValue("");
    		sheet.addMergedRegion(new CellRangeAddress(fila,fila, columna-2, columna-1));
    		
    		fila++;
    		row = sheet.createRow(fila++);
    		columna = 0;
    		row.createCell(columna++).setCellValue("");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");
    		row.createCell(columna++).setCellValue("Resp");
    		row.createCell(columna++).setCellValue("%");

    		List<Pregunta> preguntas = Pregunta.getPreguntasEvaluacion(Pregunta.INVESTIGACION);
    		for(int i=0;i<=5;i++)
    		{
    		int indice = ei.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()));
	    		if(indice>=0)
	    		{
	    			Pregunta pregunta= ei.getPreguntas().get(indice);
	    			row = sheet.createRow(fila++);
	        		columna = 0;
	        		row.createCell(columna++).setCellValue(pregunta.getEnunciado());
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.INFERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.BAJO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.MEDIO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.ALTO]);
	        		row.createCell(columna++).setCellValue(pregunta.getNumeroRespuestasNivel()[Nivel.SUPERIOR]);
	        		row.createCell(columna++).setCellValue(pregunta.getPorecentajeNivel()[Nivel.SUPERIOR]);
	    			
	    		}
	    			
	    		}
    		row = sheet.createRow(fila++);
			columna=0;
			row.createCell(columna++).setCellValue("Promedio ");
    		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.INFERIOR]);
    		row.createCell(columna++).setCellValue(ei.getPromedioPorcentaje()[Nivel.INFERIOR]);
    		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.BAJO]);
    		row.createCell(columna++).setCellValue(ei.getPromedioPorcentaje()[Nivel.BAJO]);
    		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.MEDIO]);
    		row.createCell(columna++).setCellValue(ei.getPromedioPorcentaje()[Nivel.MEDIO]);
    		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.ALTO]);
    		row.createCell(columna++).setCellValue(ei.getPromedioPorcentaje()[Nivel.ALTO]);
      		row.createCell(columna++).setCellValue(ei.getPromedioRespuestas()[Nivel.SUPERIOR]);
    		row.createCell(columna++).setCellValue(ei.getPromedioPorcentaje()[Nivel.SUPERIOR]);

    		}//fin Investigación i =1 to 2

    		row = sheet.createRow(fila++);
    		
    		//Set value to new value
    		 FileOutputStream out;
    		 File file = new File("new.xls");
    		
    		try {
    		    out = 
    		            new FileOutputStream(file);
    		    workbook.write(out);
    		    out.close();
    		    System.out.println("Excel written successfully..");
    		    
    		} catch (FileNotFoundException e) {
    		    e.printStackTrace();
    		} catch (IOException e) {
    		    e.printStackTrace();
    		}
    		
    		return ok(file);
           // return ok(index.render("Your new application is ready."));
        
    }
    public static Result prueba(){
    /*
    public static Result prueba()
    {
    /*	String documento = "1014177975";
       	String semestre = "20132";
       	Profesor profesor = new Profesor(documento,"","");
       	Evaluacion evaluacion = profesor.getEvaluacion(semestre);
       	
       	return ok("prueba :"+evaluacion.toString());
    	*/
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
		
		Document document = new Document();
	   document.open();
	    File file=null; 
		String documento = "51625497";
    	String semestre = "20132";
    	Profesor profesor = Profesor.findByDocumento(documento);
    	Evaluacion evaluacion = profesor.getEvaluacion(semestre);
    	List<Profesor> profesores = Profesor.findAllBySemestre("20132");
		try {
			file = new File("prueba.pdf");
			PdfWriter writer = PdfWriter.getInstance(document,
					
			        new FileOutputStream(file));
			
			    document.open();
		
		//    	return ok(views.html.informes.informedocencia.render(evaluacion,profesores));    

			   // XMLWorkerHelper.getInstance().parseXHtml(writer, document,
			    //    new StringReader("<html><head><title>Test</title></head><body><div style=\"padding-top:200px;\"><p style=\"text-align:center;padding-top:200px;\">This is a test</p></div></body></html>"));
	 //XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(views.html.pdf.informeprofesor.render(evaluacion.getEvaluacionDocencia(), evaluacion.getEvaluacionGestion(), evaluacion.getAutoEvaluacionGestion(), evaluacion.getEvaluacionInvestigacion(), evaluacion.getAutoEvaluacionInvestigacion(),null,"").toString()));
        	
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
		
	   // ok(views.html.informes.tabladocencia.render(evaluacion.getEvaluacionDocencia().get(0),"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5));
		
		
		return ok(file);
    //	return ok("");

    }
}

//}
