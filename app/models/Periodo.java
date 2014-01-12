package models;

public class Periodo {
	
	public static final int FECHAINICIO = 0;
	public static final int FECHAFIN = 1;
	
	public static String[] getFecha(String periodo)
	{
		String fecha[]= new String [2];
		
		String ano = periodo.substring(0, 4);
		String semestre = periodo.substring(4, 4);
		if(semestre.equals("1"))
		{	
			fecha[Periodo.FECHAINICIO]=ano+"-"+"01"+"-"+"01";
			fecha[Periodo.FECHAFIN]=ano+"-"+"06"+"-"+"30";
			
		}	
		else
		{	
			fecha[Periodo.FECHAINICIO]=ano+"-"+"06"+"-"+"01";
			fecha[Periodo.FECHAFIN]=ano+"-"+"12"+"-"+"31";
			
		}			
		
		return fecha;
	}

}
