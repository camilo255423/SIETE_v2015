package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa una Facultad.
 * Contiene código de Faculta, nombre, estudiantes participantes , total de inscritos y porcentaje de
 * participación
 * @author Camilo Rodríguez
 *
 */
public class Facultad {
	
	String codFacultad;
	String nombre;
	int participantes;
    int total;
    double porcentaje;
	/**
	 * 
	 * @param codFacultad String código de la facultad
	 * @param nombre String nombre de la facultad
	 */
	public Facultad(String codFacultad, String nombre) {
		super();
		this.codFacultad = codFacultad;
		this.nombre = nombre;
	}
	/**
	 * 
	 * @param codFacultad String código de la facultad
	 * @param nombre String nombre de la facultad
	 * @param participantes int número de estudiantes participantes
	 * @param total int número total de estudiantes inscritos
	 * @param porcentaje double porcentaje de estudiantes participantes
	 */
	public Facultad(String codFacultad, String nombre, int participantes,
			int total, double porcentaje) {
		super();
		this.codFacultad = codFacultad;
		this.nombre = nombre;
		this.participantes = participantes;
		this.total = total;
		this.porcentaje = porcentaje;
	}
/**
 * 
 * @return Devuelve una lista con todas las facultades(Objetos de tipo Facultad)
 */
	public static List<Facultad> findAll()
	{
     	Connection con = DB.getConnection();
		List<Facultad> facultades = new ArrayList<Facultad>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaFacultades);
			
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				facultades.add(new Facultad(rs.getString("ID_DECAN"),
						rs.getString("DESCRIP")));
			}
			  con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return facultades;
	}
	
	public static List<Facultad> findAllByDecano(String cedula)
	{
     	Connection con = DB.getConnection();
		List<Facultad> facultades = new ArrayList<Facultad>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaFacultadesDecano);
			p.setString(1, cedula);
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				facultades.add(new Facultad(rs.getString("ID_DECAN"),
						rs.getString("DESCRIP")));
			}
			  con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return facultades;
	}
	/**
	 * Busca una facultad por su código
	 * @param id código de la facultad
	 * @return Objeto de tipo Facultad encontrado o null en caso de que no se encuentre facultad
	 * con dicho código
	 */
	public static Facultad findById(String id)
	{
     	Connection con = DB.getConnection();
		Facultad facultad=null;
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaIdFacultad);
			
			p.setString(1, id);
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				facultad = new Facultad(rs.getString("ID_DECAN"),
						rs.getString("DESCRIP"));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return facultad;
	}
	

/**
 * 
 * @return código de la facultad
 */

	public String getCodFacultad() {
		return codFacultad;
	}
/**
 * 
 * @param codFacultad código de la facultad
 */
	public void setCodFacultad(String codFacultad) {
		this.codFacultad = codFacultad;
	}
/**
 * 
 * @return String nombre de la facultad
 */
	public String getNombre() {
		return nombre;
	}
/**
 * 
 * @param nombre String nombre de la facultad
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * 
 * @return int número de participantes
 */
	public int getParticipantes() {
		return participantes;
	}
/**
 * 
 * @param participantes int número de participantes
 */
	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}
/**
 * 
 * @return int número total de inscritos
 */
	public int getTotal() {
		return total;
	}
/**
 * 
 * @param total int número total de inscritos
 */
	public void setTotal(int total) {
		this.total = total;
	}
/**
 * 
 * @return double porcentaje de estudiantes participantes
 */
	public double getPorcentaje() {
		return porcentaje;
	}
/**
 * 
 * @param porcentaje double porcentaje de estudiantes participantes
 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}




	@Override
	public String toString() {
		return "Facultad [codFacultad=" + codFacultad + ", nombre=" + nombre
				+ ", participantes=" + participantes + ", total=" + total
				+ ", porcentaje=" + porcentaje + "]";
	}



/**
 * Consultas de búsqueda de todas las facultades y búsqueda por código de facultad.
 */
	private static final String consultaFacultades ="select * from sai.SCT_DECAN where id_decan>=1 and id_decan<=4";
	private static final String consultaIdFacultad ="select * from sai.SCT_DECAN where id_decan=?";
	private static final String consultaFacultadesDecano="select * from sai.sct_decan, permiso "+
	"where centro_costo_programa=id_decan and id_rol=5 and cedula = ?";
	
}
