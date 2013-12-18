package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Materia {
	
	String codigoMateria;
	String nombre;
	String grupo;
	int inscritos;
	
	public Materia(String codigoMateria, String nombre, String grupo,
			int inscritos) {
		super();
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.grupo = grupo;
		this.inscritos = inscritos;
	}


	public Materia(String codigoMateria, String grupo) {
		super();
		this.codigoMateria = codigoMateria;
		this.grupo = grupo;
	}


	public static List<Materia> findByProfesorAndSemestre(String documento, String semestre)
	{
     	Connection con = DB.getConnection();
		List<Materia> materias = new ArrayList<Materia>();
		PreparedStatement p;
		try {
			p = con.prepareStatement(consultaMaterias);
			p.setString(1, semestre);
			p.setString(2, documento);
			ResultSet rs=p.executeQuery();
			
			while (rs.next()) {
				materias.add(new Materia(rs.getString("codigo_materia"),
						rs.getString("nombre_materia"),rs.getString("grupo"),rs.getInt("inscritos")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	
		
		
		return materias;
	}


	@Override
	public String toString() {
		return "Materia [codigoMateria=" + codigoMateria + ", nombre=" + nombre
				+ ", grupo=" + grupo + ", inscritos=" + inscritos + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Materia materia = (Materia)obj;
		// TODO Auto-generated method stub
		return this.codigoMateria==materia.codigoMateria && this.grupo==materia.grupo;
	}
	

	public String getCodigoMateria() {
		return codigoMateria;
	}


	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public int getInscritos() {
		return inscritos;
	}


	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}


	private static final String consultaMaterias = "SELECT "   
						          + "AM.MAT_NOMBRE AS nombre_materia,"
						          + "GRP.MAT_CODIGO AS codigo_materia,"
						          + "GRP.GRU_CODIGO AS grupo,"
						          + "GRP.GRU_CUPO_ASIGNADO AS inscritos "
						          + "FROM   SAI.ART_MATERIAS AM,"
						          + "SAI.ART_GRUPOS_VIGENTES GRP "
						          + "WHERE       GRP.GRU_SEMESTRE = ? "
						          + "AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "
						          + "AND GRP.CLI_TIPODCTO <> 'OT' "
						          + "AND GRP.CLI_TDCTO_PROF <> 'OT' "
						          + "AND AM.MAT_CODIGO = GRP.MAT_CODIGO "
						          + "AND GRP.CLI_NDCTO_PROF = ? "
						          + "ORDER BY  nombre_materia desc";
}
