package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Area {
	String codArea;
	String nombre;
	public Area(String codArea, String nombre) {
		super();
		this.codArea = codArea;
		this.nombre = nombre;
	}
	
	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static String getConsultaareas() {
		return consultaAreas;
	}

	public static String getConsultaidarea() {
		return consultaIdArea;
	}

	public static String getConsultaareascoordinador() {
		return consultaAreasCoordinador;
	}

	public static List<Area> findAll()
	{
     	Connection con = DB.getConnection();
		List<Area> areas = new ArrayList<Area>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaAreas);
			
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				areas.add(new Area(rs.getString("CENTRO_COSTO"),
						rs.getString("NOMBRE")));
			}
			  con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return areas;
	}
	public static Area findById(String id)
	{
     	Connection con = DB.getConnection();
		Area area=null;
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaIdArea);
			
			p.setString(1, id);
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				area = new Area(rs.getString("CENTRO_COSTO"),
						rs.getString("NOMBRE"));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return area;
	}
	public static List<Area> findAllByCoordinador(String cedula)
	{
     	Connection con = DB.getConnection();
		List<Area> areas = new ArrayList<Area>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaAreasCoordinador);
			p.setString(1, cedula);
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				areas.add(new Area(rs.getString("CENTRO_COSTO"),
						rs.getString("NOMBRE")));
			}
			  con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return areas;
	}
	
	@Override
	public String toString() {
		return "Area [codArea=" + codArea + ", nombre=" + nombre + "]";
	}

	private static final String consultaAreas ="select * from AREA_CENTRO_COSTO";
	private static final String consultaIdArea ="select * from AREA_CENTRO_COSTO where CENTRO_COSTO=?";
	private static final String consultaAreasCoordinador="select * from AREA_CENTRO_COSTO, PERMISO "+ 
	"where PERMISO.CENTRO_COSTO_PROGRAMA=AREA_CENTRO_COSTO.CENTRO_COSTO and ID_ROL=4 and CEDULA=?";


}
