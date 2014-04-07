package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Profesor {
	
	String documento;
	String nombres;
	String apellidos;
    
	public Profesor(String documento, String nombres, String apellidos) {
		super();
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	public static List<Profesor> findAllBySemestre(String semestre)
	{
     	Connection con = DB.getConnection();
		List<Profesor> profesores = new ArrayList<Profesor>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaProfesores);
			String fecha = Periodo.getFechaContrato(semestre);
			p.setString(1, fecha);
			p.setString(2, fecha);
			System.out.println(fecha);
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				profesores.add(new Profesor(rs.getString("documento"),
						rs.getString("nombres"),rs.getString("primer_apellido")+" "+rs.getString("segundo_apellido")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesores;
	}
	public static List<Profesor> findAllBySemestreAndPrograma(String semestre, String codigoPrograma)
	{
     	Connection con = DB.getConnection();
		List<Profesor> profesores = new ArrayList<Profesor>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaProfesoresPrograma);
			String fecha = Periodo.getFechaContrato(semestre);
			p.setString(1, fecha);
			p.setString(2, fecha);
			p.setString(3, codigoPrograma);
			System.out.println(fecha);
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				profesores.add(new Profesor(rs.getString("documento"),
						rs.getString("nombre"),rs.getString("primer_apellido")+" "+rs.getString("segundo_apellido")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesores;
	}
	public static Profesor findByDocumento(String documento)
	{
     	Connection con = DB.getConnection();
		Profesor profesor=null;
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaProfesor);
			
			p.setString(1, documento);
		
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				profesor = new Profesor(rs.getString("documento"),
						rs.getString("nombres"),rs.getString("apellidos"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesor;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Evaluacion getEvaluacion(String semestre) {

		Evaluacion evaluacion = InformesDAO.getInformeDetalladoPorMateria(documento, semestre);
		return evaluacion;
	}
	
	@Override
	public String toString() {
		return "Profesor [documento=" + documento + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + "]";
	}

	private static final String consultaProfesores =" SELECT  distinct NIT as documento, nombre as nombres, primer_apellido,segundo_apellido "+
  "FROM   ICEBERG.EMPLEADO "+
 "WHERE to_date(?,'yyyy-mm-dd')>fecha_ingreso and "+ 
 "to_date(?,'yyyy-mm-dd')<FECHA_FIN_CONTRATO "+
  "order by primer_apellido, segundo_apellido, nombre ";
	private static final String consultaProfesoresPrograma ="SELECT  nit as documento, primer_apellido,segundo_apellido, nombre "+
  "FROM   ICEBERG.EMPLEADO e inner join sai.art_programas on   e.centro_costo=sai.art_programas.igecodigo "+
 "WHERE to_date(?,'yyyy-mm-dd')>fecha_ingreso and "+ 
 "to_date(?,'yyyy-mm-dd')<FECHA_FIN_CONTRATO "+ 
 "and sai.art_programas.pro_codprograma=? "+
  "order by primer_apellido, segundo_apellido, nombre ";
	
	private static final String consultaProfesor = "select cli_numdcto as documento, cli_nombres as nombres, cli_apellidos as apellidos "
			+"from sai.RCT_CLIENTES where  cli_numdcto = ?";
	
}
