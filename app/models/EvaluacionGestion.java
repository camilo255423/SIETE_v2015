package models;

import java.util.List;

public class EvaluacionGestion {
	int tipoEvaluacion;
	List<Pregunta> preguntas = null;
	double promedioRespuestas[] = new double[4];
	double promedioPorcentaje[] = new double[4];
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
