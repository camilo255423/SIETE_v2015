package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Usuario extends Model {

    @Id
    public String email;
    public String name;
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


   

	public Usuario(String email, String name, String password,
			String documento, String rol) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.documento = documento;
		this.rol = rol;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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




	public String getDocumento() {
		return documento;
	}




	public void setDocumento(String documento) {
		this.documento = documento;
	}





}