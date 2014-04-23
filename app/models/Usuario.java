package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.db.DB;
import play.db.ebean.*;


public class Usuario extends Model {

    public String email;
    public String nombre;
    public String password;
    String documento;
    String rol;
  
    

	public Usuario()
	{
		
	}
/**
 * 
 * @param email String correo o nombre de usuario
 * @param nombre String nombre del usuario
 * @param password String contraseña
 * @param documento String documento del usuario
 * @param rol String Rol del usuario
 */
	public Usuario(String email, String nombre, String password,
			String documento, String rol) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.documento = documento;
		this.rol = rol;
	}
	/**
	 * 
	 * @param nombre String nombre del usuario
	 * @param documento String documento del usuario
	 * @param rol String Rol del usuario
	 */
	public Usuario( String nombre,
			String documento, String rol) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.rol = rol;
	}

/**
 * 
 * @return String nombre de usuario o correo
 */

	public String getEmail() {
		return email;
	}

/**
 * 
 * @param email String nombre de usuario o correo
 */
	public void setEmail(String email) {
		this.email = email;
	}


	
/**
 * 
 * @return String nombre del usuario
 */

	public String getNombre() {
		return nombre;
	}


/**
 * 
 * @param nombre String nombre del usuario
 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/**
 * 
 * @return String contraseña
 */


	public String getPassword() {
		return password;
	}

/**
 * 
 * @param password String contraseña
 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return String rol del usuario
	 */

	public String getRol() {
		return rol;
	}

/**
 * 
 * @param rol String rol del usuario
 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	/**
	 * 
	 * @return String rol del usuario
	 */
	public String getNombreRol()
	{
		if(this.rol.equals(Rol.ADMINISTRADOR)) return "ADMINISTRADOR";
		else if (this.rol.equals(Rol.COORDINADOR)) return "DIRECTOR DE PROGRAMA";
		return "PROFESOR";
	}
/**
 * 
 * @return String documento del usuario
 */


	public String getDocumento() {
		return documento;
	}

/**
 * 
 * @param documento String documento del usuario
 */

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * Método que devuelve una lista de Usuarios realizando una búsqueda por el nombre o parte del nombre.
	 * Se utiliza para la función de autocompletar en la interfaz. 
	 * @param termino String con el nombre o parte el nombre del usuario a buscar
	 * @return Lista de usuarios que cumplen el criterio de búsqueda.
	 */
	public static List<Usuario> findAllByNombre(String termino)
	{
     	Connection con = DB.getConnection();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaUsuarios);
		
			p.setString(1, "%%"+termino+"%%");
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				usuarios.add(new Usuario("",rs.getString("nombres"),""
						,rs.getString("documento"),""));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return usuarios;
	}
	/**
	 * Busca un usuario por su documento
	 * @param documento String documento el usuario
	 * @return objeto de tipo Usuario encontrado o null en caso de que no se encuentre un usuario con ese documento.
	 */
	public static Usuario findByDocumento(String documento)
	{
		Connection con = DB.getConnection();
		Usuario usuario = null;
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaBuscarPorDocumento);
		
			p.setString(1, documento);
		
			ResultSet rs=p.executeQuery();
			if (rs.next()) {
				usuario = 
				new Usuario(rs.getString("nombre"), rs.getString("documento"),
						rs.getString("id_rol"));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return usuario;
	}
	/**
	 * Consulta de todos los usuarios.
	 */
	private static final String consultaUsuarios = "select  CLI_NUMDCTO as documento, CLI_APELLIDOS || ' ' || CLI_NOMBRES as nombres " +
			"from sai.rct_clientes where "+
	" CLI_NUMDCTO || CLI_APELLIDOS || ' ' || ' ' || CLI_NOMBRES like ? order by nombres";
	
	/**
	 * Consulta que busca un usuario por documento.
	 */
	private static final String consultaBuscarPorDocumento="select c.CLI_NUMDCTO as documento, cli_apellidos ||' '||cli_nombres as nombre, " +
	" id_rol from sai.rct_clientes c left join permiso p "+ 
	" on c.CLI_NUMDCTO = p.CEDULA "+ 
    " where c.CLI_NUMDCTO =?";

	


}
