package models;

import java.util.ArrayList;
import java.util.List;

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
