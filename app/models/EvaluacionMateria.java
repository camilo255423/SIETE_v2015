package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa la evaluación o la autoevaluación
 * de una asignatura para un profesor
 * @author Camilo Rodríguez
 *
 */
public class EvaluacionMateria {
	/**
	 * Constantes usadas para indicar si es EVALUACIÓN o AUTOEVALUACIÓN
	 */
	public static final int EVALUACION=1;
	public static final int AUTOEVALUACION=2;
	
	int tipoEvaluacion;
	Materia materia;
	int evaluados;
	double promedioRespuestas[][] = new double[3][5];
	double promedioPorcentaje[][] = new double[3][5];
	
	List<Pregunta> preguntas = null;
	List<String> observaciones = new ArrayList<String>();
	
	
	/**
	 * Constructor
	 * @param tipoEvaluacion int indicando Evaluación 1 o Autoevaluación 2
	 * @param materia Objeto que representa a una Materia
	 * @param conPreguntas (true o falso) Indica si el objeto se generará con las preguntas del campo de la Docencia o no
	 */
	public EvaluacionMateria(int tipoEvaluacion, Materia materia, boolean conPreguntas) {
		super();
		this.tipoEvaluacion = tipoEvaluacion;
		this.materia = materia;
		if(conPreguntas)
		{
			this.preguntas=Pregunta.getPreguntasEvaluacion(Pregunta.DOCENCIA);
		}
	
		
	}
	/**
	 * 
	 * @param tipoEvaluacion tipoEvaluacion int indicando Evaluación 1 o Autoevaluación 2
	 * @param materia materia Objeto que representa a una Materia
	 * @param preguntas Lista de objetos Pregunta
	 * @param observaciones Lista de String con las observaciones de los estudiantes
	 */
		public EvaluacionMateria(int tipoEvaluacion, Materia materia,
				List<Pregunta> preguntas, List<String> observaciones) {
			super();
			this.tipoEvaluacion = tipoEvaluacion;
			this.materia = materia;
			this.preguntas = preguntas;
			this.observaciones = observaciones;
		}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		EvaluacionMateria evaluacionMateria = (EvaluacionMateria)obj;
		
	return this.getMateria().equals(evaluacionMateria.getMateria()) && this.tipoEvaluacion==evaluacionMateria.getTipoEvaluacion();
	}
/**
 * 
 * @return int indicando Evaluación 1 o Autoevaluación 2
 */
	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}
/**
 * 
 * @param tipoEvaluacion int indicando Evaluación 1 o Autoevaluación 2
 */
	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
/**
 * 
 * @return Objeto con los datos de la asignatura
 */
	public Materia getMateria() {
		return materia;
	}
/**
 * 
 * @param materia Objeto con los datos de la asignatura
 */
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
/**
 * 
 * @return Lista de objetos de tipo Pregunta
 */
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
/**
 * 
 * @param preguntas Lista de objetos de tipo Pregunta
 */
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
/**
 * 
 * @return Lista de Strings con las observaciones hechas por los estudiantes
 */
	public List<String> getObservaciones() {
		return observaciones;
	}
/**
 * 
 * @param observaciones Lista de Strings con las observaciones hechas por los estudiantes
 */
	public void setObservaciones(List<String> observaciones) {
		this.observaciones = observaciones;
	}
/**
 * 
 * @return int número de estudiantes evaluados para esta asignatura
 */
	public int getEvaluados() {
		return evaluados;
	}
/**
 * 
 * @param evaluados int número de estudiantes evaluados para esta asignatura
 */

	public void setEvaluados(int evaluados) {
		this.evaluados = evaluados;
	}
	/**
	 * 
	 * @return matriz double con promedio de respuestas por saber y nivel 
	 */
	public double[][] getPromedioRespuestas() {
		return promedioRespuestas;
	}
/**
 * 
 * @param promedioRespuestas matriz double de promedio por respuestas por saber y nivel 
 */
	public void setPromedioRespuestas(double[][] promedioRespuestas) {
		this.promedioRespuestas = promedioRespuestas;
	}
/**
 * 
 * @return matriz double con porcentaje de  respuestas por saber y nivel 
 */
	public double[][] getPromedioPorcentaje() {
		return promedioPorcentaje;
	}
/**
 * 
 * @param promedioPorcentaje matriz double con porcentaje de  respuestas por saber y nivel 
 */
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
