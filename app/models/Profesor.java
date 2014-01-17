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
			String periodo[] = Periodo.getFecha(semestre);
			p.setString(1, periodo[Periodo.FECHAINICIO]);
			p.setString(2, periodo[Periodo.FECHAFIN]);
			ResultSet rs=p.executeQuery();
			System.out.println(periodo[Periodo.FECHAINICIO]);
			System.out.println(periodo[Periodo.FECHAFIN]);
			while (rs.next()) {
				profesores.add(new Profesor(rs.getString("documento"),
						rs.getString("nombres"),rs.getString("apellidos")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return profesores;
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
	/*	List<Materia> materias = Materia.findByProfesorAndSemestre(documento, semestre);
		List<EvaluacionMateria> evaluacion = new ArrayList<EvaluacionMateria> ();
		for(Materia materia:materias)
		{
			evaluacion.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,materia,true));
		}*/
		Evaluacion evaluacion = InformesDAO.getInformeDetalladoPorMateria(documento, semestre);
		return evaluacion;
	}
	
	@Override
	public String toString() {
		return "Profesor [documento=" + documento + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + "]";
	}

	private static final String consultaProfesores ="select cli_numdcto as documento, cli_nombres as nombres, cli_apellidos as apellidos "
	+"from sai.RCT_CLIENTES where  cli_numdcto in "
	+"(select distinct codigo_profesor from sai.tbl_instancia_evadoc where  IDCUESTIONARIOH in " 
	+"(SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "
	+"where fecha_inicia >  to_date(?,'yyyy-mm-dd') "
	+"and fecha_inicia < to_date(?,'yyyy-mm-dd'))) " 
	+"order by apellidos, nombres asc";
	
	
}
