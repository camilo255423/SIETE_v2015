package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Permiso {
	Usuario usuario;
	public Permiso(Usuario usuario, Programa programa) {
		super();
		this.usuario = usuario;
		this.programa = programa;
	}


	Programa programa;
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Programa getPrograma() {
		return programa;
	}


	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
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
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return true;
	}
	public static boolean delete(String documento)
	{
		Connection con = DB.getConnection();
		PreparedStatement p;
		int numeroFilas=0;
		
		try {
			p = con.prepareStatement(sqlBorrar);
			
			p.setString(1, documento);
			numeroFilas = p.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return numeroFilas>0;
		
	}
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
						new Programa(rs.getString("CODIGO_PROGRAMA"),rs.getString("NOMBRE_PROGRAMA")));
				permisos.add(permiso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return permisos;
	}
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
						new Programa(rs.getString("CODIGO_PROGRAMA"),rs.getString("NOMBRE_PROGRAMA")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return permiso;
	}
	

	private static final String consultaUsuarios = "select r.ID_ROL as ID_ROL, cli_numdcto  AS DOCUMENTO, " +
			"a.PRO_CODPROGRAMA AS CODIGO_PROGRAMA, "+
	"PRO_NOMBREPROG AS NOMBRE_PROGRAMA, "+ 
	"cli_apellidos || ' ' || cli_nombres as NOMBRE  " +
	"from rol r inner join permiso p "+  
	"on r.id_rol=p.id_rol inner join sai.rct_clientes c on p.cedula = c.cli_numdcto "+ 
	"left join sai.art_programas a "+
	"on a.pro_codprograma=p.centro_costo_programa ";
	private static final String consultaUsuarioPorDocumento = "select r.ID_ROL as ID_ROL, cli_numdcto  AS DOCUMENTO, " +
			"a.PRO_CODPROGRAMA AS CODIGO_PROGRAMA, "+
	"PRO_NOMBREPROG AS NOMBRE_PROGRAMA, "+ 
	"cli_apellidos || ' ' || cli_nombres as NOMBRE  " +
	"from rol r inner join permiso p "+  
	"on r.id_rol=p.id_rol inner join sai.rct_clientes c on p.cedula = c.cli_numdcto "+ 
	"left join sai.art_programas a "+
	"on a.pro_codprograma=p.centro_costo_programa where p.cedula = ?";
	private static final String sqlBorrar = "delete from permiso where CEDULA=?";
	
	private static final String sqlInsertar = "INSERT INTO PERMISO VALUES (?,?,?)";
	 

}
