package models;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	String documento;
	String nombre;
	List<EvaluacionMateria> evaluacion = new ArrayList<EvaluacionMateria> ();
	public Profesor(String documento, String semestre) {
		super();
		this.documento = documento;
		List<Materia> materias = Materia.findByProfesorAndSemestre(documento, semestre);
		for(Materia materia:materias)
		{
			evaluacion.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,materia,true));
		}
		InformesDAO.getInformeDetalladoPorMateria(documento, semestre, evaluacion);
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<EvaluacionMateria> getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(List<EvaluacionMateria> evaluacion) {
		this.evaluacion = evaluacion;
	}
	
	
}
