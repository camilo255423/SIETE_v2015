package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class InformesDAO {
	final static String  consultaEvaluacionMaterias = 
			"select MATERIA as materia ,VALOR as valor , CONTEO as contero,f.TITULO as pregunta, ENUNCIADO as enunciado, "
			+"G.TITULO AS tipo_evaluacion from "
	        +"(select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from "
	        +"(SELECT * "
	        +"from (select * "
			+"from sai.tbl_resultados) c, "
			+"(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from "
			+"(select * "
			+"from sai.tbl_resultados) a, "
			+"(select distinct IDRESULTADOS, valor "
			+"from sai.tbl_resultados "
			+"where valor like ?) b " // 1 semestre
			+"where a.IDRESULTADOS =b.IDRESULTADOS "
			+"and a.valor like '%||%' and a.valor not like ?) d "  //2 semestre
			+"where c.IDRESULTADOS =d.z "
			+") h"
			+"where profesor like ? " // 3 documento profesor
			+"and valor not like '%||%' "
			+"group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w, "
			+"sai.TBL_H_PREGUNTAS f, "
			+"sai.TBL_H_CUESTIONARIOS g "
			+"where "
			+"w.IDPREGUNTAH= f.IDPREGUNTAH "
			+"and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH ";

	
	public static void
	getInformeDetalladoPorMateria(String documentoProfesor, String semestre, List<EvaluacionMateria> evaluacionMaterias)
	{
		
		Connection con = DB.getConnection();
		int indicePregunta;
		int nivel;
		String s[];
		int tipoEvaluacion;
		String codigoMateria;
		PreparedStatement p;
		String grupo;
		String tituloPregunta;
		int numeroRespuestas;
		
		try {
			p = con.prepareStatement(consultaEvaluacionMaterias);
			p.setString(1, semestre);
			p.setString(2, semestre);
			p.setString(3, documentoProfesor);
			ResultSet rs=p.executeQuery();
			
			while (rs.next()) {
				s = rs.getString("materia").split("\\|\\|");
				tipoEvaluacion = EvaluacionMateria.EVALUACION;
				codigoMateria = s[0];
				grupo = s[1];
				tituloPregunta = rs.getString("pregunta");
				
				numeroRespuestas = rs.getInt("conteo");
				if(rs.getString("tipo_evaluacion").contains("AUTOEVALUACION")) tipoEvaluacion = EvaluacionMateria.AUTOEVALUACION;
				
				EvaluacionMateria ev = 
						evaluacionMaterias.get(evaluacionMaterias.indexOf
								(new EvaluacionMateria(tipoEvaluacion,new Materia(codigoMateria,grupo),false)));
				if(tituloPregunta.contains("Observaciones"))
				{
					ev.getObservaciones().add(rs.getString("valor"));
				}
				else
				{
					indicePregunta = ev.getPreguntas().indexOf(new Pregunta(tituloPregunta));
					
					if(indicePregunta!=-1)
					{	
					nivel = Integer.parseInt(rs.getString("valor")) -1;
					Pregunta pregunta = ev.getPreguntas().get(indicePregunta);
					pregunta.setEnunciado(rs.getString("enunciado"));
					pregunta.getNumeroRespuestasNivel()[nivel]=numeroRespuestas;
					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}	
          
     
	}
	
	

}
