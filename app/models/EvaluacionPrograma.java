package models;

import java.util.ArrayList;
import java.util.List;
/**
 * Modelo que representa la evaluación de un programa.
 * @author Camilo Rodríguez
 *
 */
public class EvaluacionPrograma {
	
	String codPrograma;
	String programa;
	List<EvaluacionMateria> EvaluacionDocencia;
	EvaluacionGestion EvaluacionGestion;
	EvaluacionInvestigacion EvaluacionInvestigacion;
	EvaluacionGestion AutoEvaluacionGestion;
	EvaluacionInvestigacion AutoEvaluacionInvestigacion;
	ArrayList mejorCampo = new ArrayList();
	ArrayList peorCampo = new ArrayList();
	public EvaluacionPrograma()
	{}
	/**
	 * 
	 * @param codPrograma String código del Programa
	 * @param programa String nombre del Programa
	 * @param evaluacionDocencia Lista con objetos EvaluacionMateria, corresponde al campo de la Docencia
	 * @param evaluacionGestion Objeto EvaluacionGestion con la evaluación de la gestión
	 * @param evaluacionInvestigacion Objeto EvaluacionInvestigacion con la evaluación de Investigación
	 * @param autoEvaluacionGestion Objeto EvaluacionGestion con la autoevaluación de la gestión
	 * @param autoEvaluacionInvestigacion Objeto EvaluacionInvestigacion con la autoevaluación de Investigación
	 */
	public EvaluacionPrograma(String codPrograma, String programa,
			List<EvaluacionMateria> evaluacionDocencia,
			models.EvaluacionGestion evaluacionGestion,
			models.EvaluacionInvestigacion evaluacionInvestigacion,
			models.EvaluacionGestion autoEvaluacionGestion,
			models.EvaluacionInvestigacion autoEvaluacionInvestigacion) {
		super();
		this.codPrograma = codPrograma;
		this.programa = programa;
		EvaluacionDocencia = evaluacionDocencia;
		EvaluacionGestion = evaluacionGestion;
		EvaluacionInvestigacion = evaluacionInvestigacion;
		AutoEvaluacionGestion = autoEvaluacionGestion;
		AutoEvaluacionInvestigacion = autoEvaluacionInvestigacion;
	}
	

	

}
