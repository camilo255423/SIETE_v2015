package models;

import java.util.List;
/**
 * Modelo que representa la evaluación en Gestión 
 * @author Camilo Rodríguez
 *
 */
public class EvaluacionGestion {
	
	int tipoEvaluacion;
	List<Pregunta> preguntas = null;
	double promedioRespuestas[] = new double[4];
	double promedioPorcentaje[] = new double[4];
	
	/**
	 * 
	 * El constructor genera las preguntas para el modelo de gestión
	 * a partir de las definiciones en la clase Pregunta.
	 * @param tipoEvaluacion El constructor recibe el tipo de evaluación de Gestión: EVALUACIÓN o AUTOEVALUACIÓN
	 */
	public EvaluacionGestion(int tipoEvaluacion) {
		super();
		this.tipoEvaluacion = tipoEvaluacion;
		this.preguntas=Pregunta.getPreguntasEvaluacion(Pregunta.GESTION);
		
		
	}
	@Override
	public String toString() {
		return "EvaluacionGestion [tipoEvaluacion=" + tipoEvaluacion
				+ ", preguntas=" + preguntas + "]";
	}
	/**
	 * Devuelve el tipo de Evaluación: EVALUACION O AUTOEVALUACION
	 * @return devuelve un entero
	 */
	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	/**
	 * 
	 * @param tipoEvaluacion
	 */
	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public double[] getPromedioRespuestas() {
		return promedioRespuestas;
	}
	public void setPromedioRespuestas(double[] promedioRespuestas) {
		this.promedioRespuestas = promedioRespuestas;
	}
	public double[] getPromedioPorcentaje() {
		return promedioPorcentaje;
	}
	public void setPromedioPorcentaje(double[] promedioPorcentaje) {
		this.promedioPorcentaje = promedioPorcentaje;
	}
	
	

}
