package models;

import java.util.List;
/**
 * Modelo que representa la evaluación en Investigación 
 * @author Camilo Rodríguez
 *
 */
public class EvaluacionInvestigacion {
	int tipoEvaluacion;
	List<Pregunta> preguntas = null;
	double promedioRespuestas[] = new double[5];
	double promedioPorcentaje[] = new double[5];
	public EvaluacionInvestigacion(int tipoEvaluacion) {
		super();
		this.tipoEvaluacion = tipoEvaluacion;
		this.preguntas=Pregunta.getPreguntasEvaluacion(Pregunta.INVESTIGACION);
		
		
	}
	@Override
	public String toString() {
		return "EvaluacionInvestigacion [tipoEvaluacion=" + tipoEvaluacion
				+ ", preguntas=" + preguntas + "]";
	}
	/**
	 * 
	 * @return int tipo de evaluación: Evaluacion o Autoevaluación
	 */
	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	/**
	 * 
	 * @param tipoEvaluacion int : Evaluación o Autoevaluación
	 */
	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	/**
	 * 
	 * @return List de objetos Pregunta, preguntas del campo de la investigación
	 */
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	/**
	 * 
	 * @param preguntas List de objetos Pregunta, preguntas del campo de la investigación
	 */
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	/**
	 * 
	 * @return arreglo double con el promedio de respuestas por nivel
	 */
	public double[] getPromedioRespuestas() {
		return promedioRespuestas;
	}
	/**
	 * 
	 * @param promedioRespuestas arreglo double con el promedio de respuestas por nivel
	 */
	public void setPromedioRespuestas(double[] promedioRespuestas) {
		this.promedioRespuestas = promedioRespuestas;
	}
	/**
	 * 
	 * @return arreglo double con el Porcentaje promedio por Nivel
	 */
	public double[] getPromedioPorcentaje() {
		return promedioPorcentaje;
	}
	/**
	 * 
	 * @param promedioPorcentaje arreglo double con el Porcentaje promedio por Nivel
	 */
	public void setPromedioPorcentaje(double[] promedioPorcentaje) {
		this.promedioPorcentaje = promedioPorcentaje;
	}
	
	
	
}
