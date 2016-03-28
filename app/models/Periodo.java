package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa un semestre
 * Provee métodos para establecer a qué semestre equivale una fecha
 * o a qué fechas corresponde un semestre
 * También cuenta con un método que devulve los semestres registrados en la base 
 * de datos.
 * @author Camilo Rodríguez
 *
 */
public class Periodo {
	
	public static final int FECHAINICIO = 0;
	public static final int FECHAFIN = 1;
	public static final String consultaSemestres = "select distinct gru_semestre as semestre " +
			"from sai.art_grupos_vigentes where gru_semestre>=? order by gru_semestre desc";
	/**
	 * Devuelve un arreglos de 2 String que contiene la fecha de inicio y la fecha de finalización
	 * del semestre para un semestre dado
	 * @param periodo String que representa al semestre (ej. 20132)
	 * @return arreglo de Strings con fechas con formato yyyy-mm-dd
	 */
	public static String[] getFecha(String periodo)
	{
		String fecha[]= new String [2];
		
		String ano = periodo.substring(0, 4);
		char semestre = periodo.charAt(4);
		if(semestre=='1')
		{	
			fecha[Periodo.FECHAINICIO]=ano+"-"+"01"+"-"+"01";
			fecha[Periodo.FECHAFIN]=ano+"-"+"06"+"-"+"30";
			
		}	
		else
		{	
			fecha[Periodo.FECHAINICIO]=ano+"-"+"08"+"-"+"01";
			fecha[Periodo.FECHAFIN]=ano+"-"+"12"+"-"+"31";
			
		}			
		
		return fecha;
	}
	/**
	 * Método que devuelve un String con una fecha intermedia para un semestre dado.
	 * Se utiliza para determinar si un docente está o no contratado en cierto semestre.
	 * @param periodo String con el semestre (ej. 20132)
	 * @return String con una fecha intermedia que está dentro del semestre. formato yyyy-mm-dd
	 */
	public static String getFechaContrato(String periodo)
	{
		String fecha;
		
		String ano = periodo.substring(0, 4);
		char semestre = periodo.charAt(4);
		if(semestre=='1')
		{	
			fecha=ano+"-"+"05"+"-"+"03";
			
		}	
		else
		{	
			fecha=ano+"-"+"11"+"-"+"03";
			
		}			
		
		return fecha;
	}
	/**
	 * Devuelve una lista de Strings con los semestres registrados en la base
	 * de datos.
	 * 
	 * @return lista de Strings con los semestres registrados en la base
	 * de datos.
	 */
	public static List<String> findAll(String semestreMinimo)
	{
		List<String> semestres = new ArrayList<String>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement p;
			p = con.prepareStatement(consultaSemestres);
			p.setString(1, semestreMinimo);
			ResultSet rs=p.executeQuery();	
			while (rs.next()) {
				semestres.add(rs.getString("semestre"));		
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		
		}
		return semestres;
	}

}
