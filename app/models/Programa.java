package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa un programa
 * @author Camilo Rodríguez
 *
 */
public class Programa {
	/**
	 * Codigo del programa
	 */
	String codPrograma;
	/**
	 * Nombre del programa
	 */
	String nombre;

    
	/**
	 * 
	 * @param codPrograma Codigo del programa
	 * @param nombre Nombre del programa
	 */

	public Programa(String codPrograma, String nombre) {
		super();
		this.codPrograma = codPrograma;
		this.nombre = nombre;
	}

/**
 * Devuelve una lista con todos los programas almacenados en la base de datos
 * @return List<Programa>
 */
	public static List<Programa> findAll()
	{
     	Connection con = DB.getConnection();
		List<Programa> programas = new ArrayList<Programa>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaProgramas);
			
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				programas.add(new Programa(rs.getString("codprograma"),
						rs.getString("nombre")));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return programas;
	}
	public static List<Programa> findProgramasByDirector(String cedula)
	{
     	Connection con = DB.getConnection();
		List<Programa> programas = new ArrayList<Programa>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaProgramasPorDirector);
			p.setString(1, cedula);
				
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				programas.add(new Programa(rs.getString("codprograma"),
						rs.getString("nombre")));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return programas;
	}
		
	

/**
 * 
 * @return String código del programa
 */

	public String getCodPrograma() {
		return codPrograma;
	}
/**
 * 
 * @param codPrograma String código del programa
 */

	public void setCodPrograma(String codPrograma) {
		this.codPrograma = codPrograma;
	}

/**
 * 
 * @return String nombre del programa
 */
	public String getNombre() {
		return nombre;
	}
/**
 * 
 * @param nombre String nombre del programa
 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static Programa findById(String id)
	{
     	Connection con = DB.getConnection();
		Programa programa=null;
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaIdPrograma);
			
			p.setString(1, id);
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				programa = new Programa(rs.getString("codprograma"),
						rs.getString("nombre"));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return programa;
	}


	@Override
	public String toString() {
		return "Programa [codPrograma=" + codPrograma + ", nombre=" + nombre
				+ "]";
	}


	private static final String consultaProgramas ="select pro_codprograma as codprograma, pro_nombreprog as nombre " +
			"from sai.art_programas where pro_estado='ACT' "+
			" order by pro_nombreprog";
	private static final String consultaIdPrograma ="select pro_codprograma as codprograma, pro_nombreprog as nombre " +
			"from sai.art_programas "+
			" where pro_codprograma = ?";
	
	private static final String consultaProgramasPorDirector = "select pro_codprograma as codprograma, pro_nombreprog as nombre " 
			+" from sai.art_programas a,permiso b " 
			+" where a.PRO_CODPROGRAMA = b.CENTRO_COSTO_PROGRAMA "
			+" and cedula = ?"; // cedula


	
}
