package models;

import java.util.List;

public class EvaluacionGestion {
	int tipoEvaluacion;
	List<Pregunta> preguntas = null;
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
