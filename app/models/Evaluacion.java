package models;

import java.util.List;

public class Evaluacion {
	public List<EvaluacionMateria> getEvaluacionDocencia() {
		return EvaluacionDocencia;
	}



	public void setEvaluacionDocencia(List<EvaluacionMateria> evaluacionDocencia) {
		EvaluacionDocencia = evaluacionDocencia;
	}



	public EvaluacionGestion getEvaluacionGestion() {
		return EvaluacionGestion;
	}



	public void setEvaluacionGestion(EvaluacionGestion evaluacionGestion) {
		EvaluacionGestion = evaluacionGestion;
	}



	public EvaluacionInvestigacion getEvaluacionInvestigacion() {
		return EvaluacionInvestigacion;
	}



	public void setEvaluacionInvestigacion(
			EvaluacionInvestigacion evaluacionInvestigacion) {
		EvaluacionInvestigacion = evaluacionInvestigacion;
	}



	public EvaluacionGestion getAutoEvaluacionGestion() {
		return AutoEvaluacionGestion;
	}



	public void setAutoEvaluacionGestion(EvaluacionGestion autoEvaluacionGestion) {
		AutoEvaluacionGestion = autoEvaluacionGestion;
	}



	public EvaluacionInvestigacion getAutoEvaluacionInvestigacion() {
		return AutoEvaluacionInvestigacion;
	}



	public void setAutoEvaluacionInvestigacion(
			EvaluacionInvestigacion autoEvaluacionInvestigacion) {
		AutoEvaluacionInvestigacion = autoEvaluacionInvestigacion;
	}



	List<EvaluacionMateria> EvaluacionDocencia;
	EvaluacionGestion EvaluacionGestion;
	EvaluacionInvestigacion EvaluacionInvestigacion;
	EvaluacionGestion AutoEvaluacionGestion;
	EvaluacionInvestigacion AutoEvaluacionInvestigacion;



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
