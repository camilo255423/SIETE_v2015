package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class DirectivoSemestre {
	Usuario usuario;
	String cargo;
	String semestre;
	Facultad facultad;
	


	

	public DirectivoSemestre(Usuario usuario, String cargo, String semestre,
			Facultad facultad) {
		super();
		this.usuario = usuario;
		this.cargo = cargo;
		this.semestre = semestre;
		this.facultad = facultad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * Borra el permiso para un usuario
	 * @param documento String documento del usuario
	 * @return
	 */
	public static boolean delete(String documento)
	{
		Connection con = DB.getConnection();
		PreparedStatement p;
		int numeroFilas=0;
		
		try {
			p = con.prepareStatement(sqlBorrar);
			
			p.setString(1, documento);
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
	 * Método que devuelve una Lista con todos los Directivos existentes por Semestre.
	 * @return List<Permiso> permisos existentes
	 */
	public static List<DirectivoSemestre>  findAllBySemeste(String semestre)
	{
		Connection con = DB.getConnection();
		List<DirectivoSemestre> directivos = new ArrayList<DirectivoSemestre>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaUsuarios);
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				DirectivoSemestre directivo =
						new DirectivoSemestre(new Usuario(rs.getString("DOCUMENTO"),rs.getString("NOMBRE"),""), rs.getString("CARGO"), semestre, new Facultad(rs.getString("ID_DECAN"),rs.getString("NOMBRE")));
				directivos.add(directivo);
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return directivos;
	}
	/**
	 * Consulta de todos los permisos
	 */
		private static final String consultaUsuarios = "select r.ID_ROL as ID_ROL, cli_numdcto  AS DOCUMENTO, " +
				"a.PRO_CODPROGRAMA AS CODIGO_PROGRAMA, "+
		"PRO_NOMBREPROG AS NOMBRE_PROGRAMA, "+ 
		"cli_apellidos || ' ' || cli_nombres as NOMBRE  " +
		"from rol r inner join permiso p "+  
		"on r.id_rol=p.id_rol inner join sai.rct_clientes c on p.cedula = c.cli_numdcto "+ 
		"left join sai.art_programas a "+
		"on a.pro_codprograma=p.centro_costo_programa ";
		/**
		 * Consulta de permiso por documento
		 */
		private static final String consultaDirectivosPorSemestre = "Select CLI_NUMDCTO as DOCUMENTO,cli_apellidos || ' ' || cli_nombres as NOMBRE," +
				"CARGO,ID_DECAN, facultad.nombre as FACULTAD from " +
		 "sai.rct_clientes,directivo_semestre, facultad " +
		 "where id_decan=id_facultad and sai.rct_clientes.CLI_NUMDCTO=directivo_semestre and semestre=?";
		/** 
		 * sql que borra un registro
		 */
		private static final String sqlBorrar = "delete from DirectivoSemestre where CLI_NUMDCTO=? and CARGO=? and ID_DECAN=?";
		/**
		 * sql que inserta un registro
		 */
		private static final String sqlInsertar = "INSERT INTO PERMISO VALUES (?,?,?)";

}
