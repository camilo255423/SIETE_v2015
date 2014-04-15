package models;

public class Nivel {

	public static final int INFERIOR = 0;
	public static final int BAJO = 1;
	public static final int MEDIO = 2;
	public static final int ALTO = 3;
	public static final int SUPERIOR = 4;
	
	public static String toString(int nivel)
	{
		if(nivel==INFERIOR) return "Inferior";
		if(nivel==BAJO) return "Bajo";
		if(nivel==MEDIO) return "Medio";
		if(nivel==ALTO) return "Alto";
		if(nivel==SUPERIOR) return "Superior";
		
		return "Nivel no Válido";
	}
	

}
