package models;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	String documento;
	String nombre;
	List<EvaluacionMateria> evaluacion = null;
	public Profesor(String documento, String semestre) {
		super();
		this.documento = documento;
		List<Materia> materias = Materia.findByProfesorAndSemestre(documento, semestre);
		for(Materia materia:materias)
		{
			evaluacion.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,materia,true));
		}
	}
	
}
