package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa aun paciente
 * @author Camilo Rodríguez
 *
 */
public class Profesor {
	/**
	 * Documento del profesor
	 */
	String documento;
	/**
	 * Nombres del profesor
	 */
	String nombres;
	/**
	 * Apellidos
	 */
	String apellidos;
    /**
     * 
     * @param documento
     * @param nombres
     * @param apellidos
     */
	public Profesor(String documento, String nombres, String apellidos) {
		super();
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	/**
	 * Método que devuelve una lista de profesores contratados para un semestre dado
	 * @param semestre String semestre en revisión. Ej. 20132
	 * @return List<Profesor> 
	 */
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
			p.setString(3, fecha);
			p.setString(4, fecha);

			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				profesores.add(new Profesor(rs.getString("documento"),
						rs.getString("nombres"),rs.getString("primer_apellido")+" "+rs.getString("segundo_apellido")));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesores;
	}
	/**
	 * Método que devuelve una lista de profesores según semestre y programa
	 * @param semestre String semestre a revisar
	 * @param codigoPrograma String programa a revisar
	 * @return List<Profesor> 
	 */
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
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				profesores.add(new Profesor(rs.getString("documento"),
						rs.getString("nombre"),rs.getString("primer_apellido")+" "+rs.getString("segundo_apellido")));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesores;
	}
	
	/**
	 * 
	 * @param semestre
	 * @param codigoPrograma
	 * @return List<Profesor>
	 */
	
	public static List<Profesor> findAllBySemestreAndFacultad(String semestre, String codigoFacultad)
	{
     	Connection con = DB.getConnection();
		List<Profesor> profesores = new ArrayList<Profesor>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaProfesoresFacultadSemestre);
			p.setString(1, semestre);
			p.setString(2, codigoFacultad);
			ResultSet rs=p.executeQuery();
			while (rs.next()) {
				profesores.add(new Profesor(rs.getString("documento"),
						rs.getString("nombre"),rs.getString("primer_apellido")+" "+rs.getString("segundo_apellido")));
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesores;
	}
	/**
	 * Método que encuentra un profesor por su documento
	 * @param documento String documento el profesor
	 * @return objeto de tipo Profesor o null en caso de que no se encuentre profesor asociado a ese documento
	 */
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
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesor;
	}
	/**
	 * 
	 * @return String documento del profesor
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * 
	 * @param documento String documento del profesor
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * 
	 * @return String nombres del profesor
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * 
	 * @param nombres String nombres del profesor
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * 
	 * @return String apellidos del profesor
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * 
	 * @param apellidos String apellidos del profesor
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Método que devuelve la evaluación detallada de un profesor para un semestre dado
	 * @param semestre String semestre ej. 20132
	 * @return objeto de tipo Evaluacion
	 */
	public Evaluacion getEvaluacion(String semestre) {

		Evaluacion evaluacion = InformesDAO.getInformeDetalladoPorMateria(documento, semestre);
		return evaluacion;
	}
	
	@Override
	public String toString() {
		return "Profesor [documento=" + documento + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + "]";
	}
/**
 * Consulta sql que devuelve todos los profesores para un semestre dado
 */
	
	private static final String consultaProfesores ="SELECT  distinct NIT as documento, nombre_empleado as nombres, ' ' as primer_apellido,' ' as segundo_apellido "+
"from ( "+
"SELECT  * "+
"FROM v1_empleado "+   
"where  "+
"EMPRESA IN ('CAT', 'DOC') "+
"AND NOMBRE_CARGO LIKE  'CAT%' "+
"AND FECHA_INGRESO<to_date(?,'yyyy-mm-dd') "+
"AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') "+
"or FECHA_FIN_CONTRATO is null) "+
"UNION ALL "+
"SELECT  * "+
"FROM v1_empleado "+   
"where  "+
" EMPRESA IN ('CAT', 'DOC') "+
"AND NOMBRE_CARGO LIKE  'DOC%' "+
"AND FECHA_INGRESO<to_date(?,'yyyy-mm-dd') "+
"AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') "+
"or FECHA_FIN_CONTRATO is null) "+
") "+
"order by nombres";
  
		
	/**
	 * Consulta sql que permite encontrar los docentes por programa y semestre
	 */
	
	private static final String consultaProfesoresPrograma ="SELECT  nit as documento, primer_apellido,segundo_apellido, nombre "+
			  "FROM   ICEBERG.EMPLEADO e inner join sai.art_programas on   e.centro_costo=sai.art_programas.igecodigo "+
			 "WHERE to_date(?,'yyyy-mm-dd')>fecha_ingreso and "+  //1. fecha contrato
			 "to_date(?,'yyyy-mm-dd')<FECHA_FIN_CONTRATO "+  //2. fecha contrato
			 "and sai.art_programas.pro_codprograma=? "+    //3. codigo programa
			  "order by primer_apellido, segundo_apellido, nombre ";
	
	private static final String consultaProfesoresFacultadSemestre="SELECT  nit as documento, primer_apellido,segundo_apellido, nombre "+ 
			"FROM DIT_DOCENTE_FACULTAD "+
			"WHERE PERIODO=? AND ID_DECAN=? "+
			"order by primer_apellido, segundo_apellido, nombre ";
	
	/**
	 * Consulta sql que encuentra un profesor por documento
	 */
	private static final String consultaProfesor = "select cli_numdcto as documento, cli_nombres as nombres, cli_apellidos as apellidos "
			+"from sai.RCT_CLIENTES where  cli_numdcto = ?";
	
}
