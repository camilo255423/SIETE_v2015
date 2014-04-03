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
import com.avaje.ebean.*;

@Entity
public class Usuario extends Model {

    @Id
    public String email;
    public String nombre;
    public String password;
    String documento;
    String rol;
  
    


	public static Usuario authenticate(String email, String password) {
        if (email.equals("123") && email.equals("123"))
        {
        	return new Usuario(email, email, password, "51832657", Rol.PROFESOR);
        }
        if (email.equals("456") && email.equals("456"))
        {
        	return new Usuario(email, email, password, "",Rol.COORDINADOR);
        }
        if (email.equals("789") && email.equals("789"))
        {
        	return new Usuario(email, email, password, "",Rol.ADMINISTRADOR);
        }
        return null;
    }


   

	public Usuario(String email, String nombre, String password,
			String documento, String rol) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.documento = documento;
		this.rol = rol;
	}
	public Usuario( String nombre,
			String documento, String rol) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.rol = rol;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombreRol()
	{
		if(this.rol.equals(Rol.ADMINISTRADOR)) return "ADMINISTRADOR";
		else if (this.rol.equals(Rol.COORDINADOR)) return "COORDINADOR";
		return "PROFESOR";
	}




	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return usuarios;
	}
	public Usuario findByDocumento(String documento)
	{
		return null;
	}
	private static final String consultaUsuarios = "select  CLI_NUMDCTO as documento, CLI_APELLIDOS || ' ' || CLI_NOMBRES as nombres " +
			"from sai.rct_clientes where "+
	" CLI_NUMDCTO || CLI_APELLIDOS || ' ' || ' ' || CLI_NOMBRES like ? order by nombres";
	
	
	private static final String consultaBuscarPorDocumento="select c.CLI_NUMDCTO as documento, cli_apellidos ||' '||cli_nombres as nombre, " +
	" id_rol from sai.rct_clientes c left join permiso p "+ 
	" on c.CLI_NUMDCTO = p.CEDULA "+ 
    " where c.CLI_NUMDCTO =?";

	


}