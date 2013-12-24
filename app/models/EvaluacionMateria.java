package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class EvaluacionMateria {
	
	public static final int EVALUACION=1;
	public static final int AUTOEVALUACION=2;
	
	int tipoEvaluacion;
	Materia materia;
	int evaluados;
	double promedioRespuestas[][] = new double[3][5];
	double promedioPorcentaje[][] = new double[3][5];
	
	List<Pregunta> preguntas = null;
	List<String> observaciones = new ArrayList<String>();
	
	
	
	public EvaluacionMateria(int tipoEvaluacion, Materia materia, boolean conPreguntas) {
		super();
		this.tipoEvaluacion = tipoEvaluacion;
		this.materia = materia;
		if(conPreguntas)
		{
			this.preguntas=Pregunta.getPreguntasEvaluacion();
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		EvaluacionMateria evaluacionMateria = (EvaluacionMateria)obj;
	return evaluacionMateria.materia.equals(evaluacionMateria.getMateria()) && this.tipoEvaluacion==evaluacionMateria.getTipoEvaluacion();
	}

	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<String> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<String> observaciones) {
		this.observaciones = observaciones;
	}

	public EvaluacionMateria(int tipoEvaluacion, Materia materia,
			List<Pregunta> preguntas, List<String> observaciones) {
		super();
		this.tipoEvaluacion = tipoEvaluacion;
		this.materia = materia;
		this.preguntas = preguntas;
		this.observaciones = observaciones;
	}
	public int getEvaluados() {
		return evaluados;
	}


	public void setEvaluados(int evaluados) {
		this.evaluados = evaluados;
	}
	public double[][] getPromedioRespuestas() {
		return promedioRespuestas;
	}

	public void setPromedioRespuestas(double[][] promedioRespuestas) {
		this.promedioRespuestas = promedioRespuestas;
	}

	public double[][] getPromedioPorcentaje() {
		return promedioPorcentaje;
	}

	public void setPromedioPorcentaje(double[][] promedioPorcentaje) {
		this.promedioPorcentaje = promedioPorcentaje;
	}

	@Override
	public String toString() {
		return "EvaluacionMateria [tipoEvaluacion=" + tipoEvaluacion
				+ ", materia=" + materia + ", preguntas=" + preguntas
				+ ", observaciones=" + observaciones + "]";
	}
	
	
}
