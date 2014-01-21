package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Periodo {
	
	public static final int FECHAINICIO = 0;
	public static final int FECHAFIN = 1;
	public static final String consultaSemestres = "select distinct gru_semestre as semestre " +
			"from sai.art_grupos_vigentes order by gru_semestre desc";
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
	public static List<String> findAll()
	{
		List<String> semestres = new ArrayList<String>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement p;
			p = con.prepareStatement(consultaSemestres);
			ResultSet rs=p.executeQuery();	
			while (rs.next()) {
				semestres.add(rs.getString("semestre"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		
		}
		return semestres;
	}

}
