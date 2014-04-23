package models;

import java.util.List;
/**
 * Clase que representa la evaluación de un profesor o un programa
 * 
 * @author Camilo Rodríguez
 *
 */
public class Evaluacion {
/**
 * Lista de evaluaciones de cada materia
 */
	List<EvaluacionMateria> EvaluacionDocencia;
	/**
	 * Evaluación en gestión
	 */
	EvaluacionGestion EvaluacionGestion;
	/**
	 * Evaluación en Investigación
	 */
	EvaluacionInvestigacion EvaluacionInvestigacion;
	/**
	 * Autoevaluación en gestión
	 */
	EvaluacionGestion AutoEvaluacionGestion;
	/**
	 * Autoevaluación en investigación
	 */
	EvaluacionInvestigacion AutoEvaluacionInvestigacion;

	/**
	 * 
	 * @return Devuelve una lista de tipo EvaluacionMateria con las 
	 * evaluaciones de las asignaturas
	 */
	public List<EvaluacionMateria> getEvaluacionDocencia() {
		return EvaluacionDocencia;
	}
	/**
	 * 
	 * @param evaluacionDocencia Lista de tipo EvaluacionMateria con las 
	 * evaluaciones de las asignaturas
	 */


	public void setEvaluacionDocencia(List<EvaluacionMateria> evaluacionDocencia) {
		EvaluacionDocencia = evaluacionDocencia;
	}

/**
 * 
 * @return Retorna un objeto de tipo EvaluacionGestion con la evaluación de la gestión
 */

	public EvaluacionGestion getEvaluacionGestion() {
		return EvaluacionGestion;
	}

/**
 * 
 * @param EvaluacionGestion objeto de tipo EvaluacionGestion con la evaluación de la gestión
 */

	public void setEvaluacionGestion(EvaluacionGestion evaluacionGestion) {
		EvaluacionGestion = evaluacionGestion;
	}

/**
 * 
 * @return  objeto de tipo EvaluacionInvestigación con la evaluación en Investigación
 */

	public EvaluacionInvestigacion getEvaluacionInvestigacion() {
		return EvaluacionInvestigacion;
	}

/**
 * 
 * @param evaluacionInvestigacion objeto de tipo EvaluacionInvestigación con la evaluación en Investigación
 */

	public void setEvaluacionInvestigacion(
			EvaluacionInvestigacion evaluacionInvestigacion) {
		EvaluacionInvestigacion = evaluacionInvestigacion;
	}

/**
 * 
 * @return  objeto de tipo EvaluacionGestion con la autoevaluación de la gestión
 */

	public EvaluacionGestion getAutoEvaluacionGestion() {
		return AutoEvaluacionGestion;
	}

/**
 * 
 * @param autoEvaluacionGestion objeto de tipo EvaluacionGestion con la autoevaluación de la gestión
 */

	public void setAutoEvaluacionGestion(EvaluacionGestion autoEvaluacionGestion) {
		AutoEvaluacionGestion = autoEvaluacionGestion;
	}

/**
 * 
 * @return objeto de tipo EvaluacionInvestigacion con la autoevaluación de Investigación
 */

	public EvaluacionInvestigacion getAutoEvaluacionInvestigacion() {
		return AutoEvaluacionInvestigacion;
	}
/**
 * 
 * @param autoEvaluacionInvestigacion
 */


	public void setAutoEvaluacionInvestigacion(
			EvaluacionInvestigacion autoEvaluacionInvestigacion) {
		AutoEvaluacionInvestigacion = autoEvaluacionInvestigacion;
	}

/**
 * 
 * @param evaluacionDocencia Lista con la evaluación de las asignaturas
 * @param evaluacionGestion Evaluación de la gestión
 * @param evaluacionInvestigacion Evaluación de la Investigación
 * @param autoEvaluacionGestion Autoevaluación de la Gestión
 * @param autoEvaluacionInvestigacion Autoevaluación de la Investigación
 */



	public Evaluacion(List<EvaluacionMateria> evaluacionDocencia,
			models.EvaluacionGestion evaluacionGestion,
			models.EvaluacionInvestigacion evaluacionInvestigacion,
			models.EvaluacionGestion autoEvaluacionGestion,
			models.EvaluacionInvestigacion autoEvaluacionInvestigacion) {
		super();
		EvaluacionDocencia = evaluacionDocencia;
		EvaluacionGestion = evaluacionGestion;
		EvaluacionInvestigacion = evaluacionInvestigacion;
		AutoEvaluacionGestion = autoEvaluacionGestion;
		AutoEvaluacionInvestigacion = autoEvaluacionInvestigacion;
	}



	@Override
	public String toString() {
		return "Evaluacion [EvaluacionDocencia=" + EvaluacionDocencia
				+ ", EvaluacionGestion=" + EvaluacionGestion
				+ ", EvaluacionInvestigacion=" + EvaluacionInvestigacion
				+ ", AutoEvaluacionGestion=" + AutoEvaluacionGestion
				+ ", AutoEvaluacionInvestigacion="
				+ AutoEvaluacionInvestigacion + "]";
	}



	
	

}
