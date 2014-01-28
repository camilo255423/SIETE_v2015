package models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Pregunta {
	
	public static final int PEDAGOGICO = 0;
	public static final int ESPECIFICO = 1;
	public static final int RELACIONAL = 2;
	public static final int GESTION = 3;
	public static final int INVESTIGACION = 4;
	public static final int DOCENCIA = 5;
	public static final String preguntasTitulos[]={"Pedagógico 1",
		"Pedagógico 2","Pedagógico 3","Pedagógico 4","Pedagógico 5","Pedagógico 6",
		"Específico 7","Específico 8","Específico 9",
		"Relacional 10","Relacional 11","Relacional 12"};
	public static final String preguntasTitulosGestion[]={"Gestión 1", "Gestión 2", "Gestión 3", "Gestión 4", "Gestión 5", "Gestión 6","Gestión 7"};
	public static final String preguntasTitulosInvestigacion[]={"Investigativo 1", "Investigativo 2", "Investigativo 3", "Investigativo 4", "Investigativo 5", "Investigativo 6"};
	
	int tipoPregunta;
	String titulo;
	String enunciado;
	int numeroRespuestasNivel[] = new int[5];
	double porecentajeNivel[] = new double[5];

	
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

	public static List<Pregunta> getPreguntasEvaluacion(int tipo)
	{
		List<Pregunta> preguntas = new ArrayList<Pregunta> ();
		if(tipo==DOCENCIA)
		{	
			for(int i=0; i<preguntasTitulos.length;i++)
			{
				int tipoPregunta=PEDAGOGICO;
				if(i+1<=6) tipoPregunta=PEDAGOGICO;
				else
				if(i+1>=7 && i+1<=9) tipoPregunta=ESPECIFICO;
				else
					tipoPregunta=RELACIONAL;
			
				preguntas.add(new Pregunta(tipoPregunta,preguntasTitulos[i],""));
				
				
			}
		}
		if(tipo==GESTION)
		{
			for(int i=0; i<preguntasTitulosGestion.length;i++)
			{
				preguntas.add(new Pregunta(tipo,preguntasTitulosGestion[i],""));
			}
		}
		if(tipo==INVESTIGACION)
		{
			for(int i=0; i<preguntasTitulosInvestigacion.length;i++)
			{
				preguntas.add(new Pregunta(tipo,preguntasTitulosInvestigacion[i],""));
			}
			
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

	public double[] getPorecentajeNivel() {
		return porecentajeNivel;
	}

	public void setPorecentajeNivel(double[] porecentajeNivel) {
		this.porecentajeNivel = porecentajeNivel;
	}

	

	@Override
	public String toString() {
		return "Pregunta [tipoPregunta=" + tipoPregunta + ", titulo=" + titulo
				+ ", enunciado=" + enunciado + ", numeroRespuestasNivel="
				+ Arrays.toString(numeroRespuestasNivel) + "]";
	}
	
	
}
