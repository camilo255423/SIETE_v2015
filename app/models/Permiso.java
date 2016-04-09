package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa el permiso para un usuario.
 * Por lo general para los directores de programa.
 * @author Camilo Rodríguez
 *
 */
public class Permiso {
	/**
	 * Usuario sobre el cual se otorga el permiso
	 */
	Usuario usuario;
	String nombrePermiso;
	String codigoPermiso;
	
	

	public Permiso(Usuario usuario, String codigoPermiso) {
		super();
		this.usuario = usuario;
		this.codigoPermiso = codigoPermiso;
		this.nombrePermiso = this.getNombrePermisoByCodigo(usuario, codigoPermiso);
	}
	private String getNombrePermisoByCodigo(Usuario usuario, String codigoPermiso)
	{
		String nombrePermiso = "";
		if(usuario.rol.equals(Rol.ADMINISTRADOR)){
			nombrePermiso="ADMINISTRADOR";
		}
		else if(usuario.rol.equals(Rol.COORDINADOR)){
			Programa programa = Programa.findById(codigoPermiso);
			nombrePermiso=programa.getNombre();
			
		}
		else if(usuario.rol.equals(Rol.COORDINADOR_DE_AREA)){
			Area area = Area.findById(codigoPermiso);
			nombrePermiso=area.getNombre();
		}
		else if(usuario.rol.equals(Rol.DECANO) || usuario.rol.equals(Rol.SECRETARIA_FACULTAD)){
			Facultad facultad = Facultad.findById(codigoPermiso);
			nombrePermiso=facultad.getNombre();
		}
		else throw  new UnsupportedOperationException("ID ROL NO VALIDO PARA PERMISO, ID="+usuario.rol);	
		
		return nombrePermiso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombrePermiso() {
		return nombrePermiso;
	}

	public void setNombrePermiso(String nombrePermiso) {
		this.nombrePermiso = nombrePermiso;
	}

	public String getCodigoPermiso() {
		return codigoPermiso;
	}

	public void setCodigoPermiso(String codigoPermiso) {
		this.codigoPermiso = codigoPermiso;
	}

	/**
	 * Método encargado de insertar un nuevo registro en la base de datos.
	 * @param documento Documento el usuario
	 * @param idRol id del ROl (administrador 1 o Director de Programa 2) 
	 * @param codigoPrograma código del programa sobre el cual se otorga permiso para el caso de director de programa.
	 * @return
	 */
	public static boolean save(String documento,String idRol, String codigoPrograma ) 
	{
		Connection con = DB.getConnection();
		PreparedStatement p;
		int numeroFilas=0;
		
		try {
			p = con.prepareStatement(sqlInsertar);
			
			p.setString(1, documento);
			p.setString(2, idRol);
			p.setString(3, codigoPrograma);
			numeroFilas = p.executeUpdate();
			con.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	
		
		
		return true;
	}
	/**
	 * Borra el permiso para un usuario
	 * @param documento String documento del usuario
	 * @return
	 */
	public static boolean delete(String documento, String codPrograma)
	{
		Connection con = DB.getConnection();
		PreparedStatement p;
		int numeroFilas=0;
		
		try {
			p = con.prepareStatement(sqlBorrar);
			
			p.setString(1, documento);
			p.setString(2, codPrograma);
			numeroFilas = p.executeUpdate();
			
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return numeroFilas>0;
		
	}
	/**
	 * Método que devuelve una Lista con todos los permisos existentes.
	 * @return List<Permiso> permisos existentes
	 */
	public static List<Permiso>  findAll()
	{
		Connection con = DB.getConnection();
		List<Permiso> permisos = new ArrayList<Permiso>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaUsuarios);
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				Permiso permiso = new Permiso(new Usuario(rs.getString("NOMBRE"),rs.getString("DOCUMENTO"),rs.getString("ID_ROL")),
						rs.getString("CODIGO_PERMISO"));
				permisos.add(permiso);
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return permisos;
	}
	/**
	 * Método que encuentra un permiso apartir del documento del usuario.
	 * @param documento String documento del usuario
	 * @return Permiso encontrado o null en caso de no encontrar un permiso asociado al documento. 
	 */
	public static Permiso  findByDocumento(String documento)
	{
		Connection con = DB.getConnection();
		Permiso permiso = null;
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaUsuarioPorDocumento);
			p.setString(1, documento);
			ResultSet rs=p.executeQuery();
			if (rs.next()) {
				permiso = new Permiso(new Usuario(rs.getString("NOMBRE"),rs.getString("DOCUMENTO"),rs.getString("ID_ROL")),
						"");
				
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return permiso;
	}
	/**
	 * Determina si un permiso ya existe en la base de datos
	 * @param documento
	 * @param idRol
	 * @param codigoPrograma
	 * @return  boolean
	 */
	public static boolean  existePermiso(String documento, String idRol, String codigoPrograma)
	{
		Connection con = DB.getConnection();
		PreparedStatement p;
		boolean existe=false;
		try {
			p = con.prepareStatement(consultaPermiso);
			p.setString(1, documento);
			p.setString(2, idRol);
			p.setString(3, codigoPrograma);
			ResultSet rs=p.executeQuery();
			if (rs.next()) {
				existe= true;
				
			}
			
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return existe;
	}
	public static boolean  existeUsuarioRolDiferente(String documento, String idRol)
	{
		Connection con = DB.getConnection();
		PreparedStatement p;
		boolean existe=false;
		try {
			p = con.prepareStatement(consultaUsuarioRolPermiso);
			p.setString(1, documento);
			ResultSet rs=p.executeQuery();
			if (rs.next()) {
				if(!rs.getString("ID_ROL").equals(idRol)){
				existe= true;
				}
				
			}
			
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return existe;
	}
	
/**
 * Consulta de todos los permisos
 */
	private static final String consultaUsuarios = "select r.ID_ROL as ID_ROL, cli_numdcto  AS DOCUMENTO, " +
    "p.centro_costo_programa as CODIGO_PERMISO, " +
	"cli_apellidos || ' ' || cli_nombres as NOMBRE  " +
	"from rol r inner join permiso p "+  
	"on r.id_rol=p.id_rol inner join sai.rct_clientes c on p.cedula = c.cli_numdcto "+ 
	" order by NOMBRE ";
	/**
	 * Consulta de permiso por documento
	 */
	private static final String consultaUsuarioPorDocumento = "select r.ID_ROL as ID_ROL, cli_numdcto  AS DOCUMENTO, " +
	"p.centro_costo_programa as CODIGO_PERMISO, " +
	"cli_apellidos || ' ' || cli_nombres as NOMBRE  " +
	"from rol r inner join permiso p "+  
	"on r.id_rol=p.id_rol inner join sai.rct_clientes c on p.cedula = c.cli_numdcto "+ 
	"where p.cedula = ?";
	
	/** 
	 * sql que borra un registro
	 */
	private static final String sqlBorrar = "delete from permiso where CEDULA=? and CENTRO_COSTO_PROGRAMA=?";
	/**
	 * sql que inserta un registro
	 */
	private static final String sqlInsertar = "INSERT INTO PERMISO VALUES (?,?,?)";
	
	private static final String consultaPermiso = "select * from permiso where cedula=? and id_rol=? and centro_costo_programa=?";
	
	private static final String consultaUsuarioRolPermiso = "select * from permiso where cedula=?";
	 

}
