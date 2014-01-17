package models;

import java.util.List;

public class EvaluacionInvestigacion {
	int tipoEvaluacion;
	List<Pregunta> preguntas = null;
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
	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
