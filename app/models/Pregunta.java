package models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Pregunta {
	
	static final int PEDAGOGICO = 101;
	static final int ESPECIFICO = 102;
	static final int RELACIONAL = 103;
	static final String preguntasTitulos[]={"Pedagógico 1",
		"Pedagógico 2","Pedagógico 3","Pedagógico 4","Pedagógico 5","Pedagógico 6",
		"Específico 7","Específico 8","Específico 9",
		"Relacional 10","Relacional 11","Relacional 12"};
	
	int tipoPregunta;
	String titulo;
	String enunciado;
	int numeroRespuestasNivel[] = new int[5];
	
	public Pregunta(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Pregunta(int tipoPregunta, String titulo, String enunciado) {
		super();
		this.tipoPregunta = tipoPregunta;
		this.titulo = titulo;
		this.enunciado = enunciado;
	}

	public static List<Pregunta> getPreguntasEvaluacion()
	{
		List<Pregunta> preguntas = new ArrayList<Pregunta> ();
		for(int i=0; i<preguntasTitulos.length;i++)
		{
			int tipoPregunta=PEDAGOGICO;
			if(i+1<6) tipoPregunta=PEDAGOGICO;
			else
			if(i+1>=7 && i+1<=9) tipoPregunta=ESPECIFICO;
			else
				tipoPregunta=RELACIONAL;
		
			preguntas.add(new Pregunta(tipoPregunta,preguntasTitulos[i],""));
			
			
		}
		
		
		return preguntas;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pregunta p = (Pregunta) obj;
	
		return titulo.equals(p.titulo);
	}
	

	public int getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(int tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int[] getNumeroRespuestasNivel() {
		return numeroRespuestasNivel;
	}

	public void setNumeroRespuestasNivel(int[] numeroRespuestasNivel) {
		this.numeroRespuestasNivel = numeroRespuestasNivel;
	}

	@Override
	public String toString() {
		return "Pregunta [tipoPregunta=" + tipoPregunta + ", titulo=" + titulo
				+ ", enunciado=" + enunciado + ", numeroRespuestasNivel="
				+ Arrays.toString(numeroRespuestasNivel) + "]";
	}
	
	
}
