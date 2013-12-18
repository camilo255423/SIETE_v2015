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
	return evaluacionMateria.materia.equals(evaluacionMateria) && this.tipoEvaluacion==evaluacionMateria.tipoEvaluacion;
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


	
}
