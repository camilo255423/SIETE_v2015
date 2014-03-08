package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Programa {
	
	String codPrograma;
	String nombre;

    
	

	public Programa(String codPrograma, String nombre) {
		super();
		this.codPrograma = codPrograma;
		this.nombre = nombre;
	}


	public static List<Programa> findAll()
	{
     	Connection con = DB.getConnection();
		List<Programa> programas = new ArrayList<Programa>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaFacultad);
			
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				programas.add(new Programa(rs.getString("codprograma"),
						rs.getString("nombre")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return programas;
	}
		
	



	public String getCodPrograma() {
		return codPrograma;
	}


	public void setCodPrograma(String codPrograma) {
		this.codPrograma = codPrograma;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	private static final String consultaFacultad ="select pro_codprograma as codprograma, pro_nombreprog as nombre " +
			"from sai.art_programas "+
			" order by pro_nombreprog";

	
}
