package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Pregunta;
import play.db.DB;

public class InformesDAO {
	final static String  consultaEvaluacionMaterias = 
			"select MATERIA as materia ,VALOR as valor , CONTEO as conteo,f.TITULO as pregunta, ENUNCIADO as enunciado, "
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
			+"where valor like ? ) b " // 1 semestre
			+"where a.IDRESULTADOS =b.IDRESULTADOS "
			+"and a.valor like '%||%' and a.valor not like ?) d "  //2 semestre
			+"where c.IDRESULTADOS =d.z "
			+") h "
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
		int indiceMateria;
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
			p.setString(1, "%%"+semestre+"%%");
			p.setString(2, "%%"+semestre+"%%");
			p.setString(3, "%%"+documentoProfesor+"%%");
			ResultSet rs=p.executeQuery();
			
			while (rs.next()) {
				s = rs.getString("materia").split("\\|\\|");
				tipoEvaluacion = EvaluacionMateria.EVALUACION;
				codigoMateria = s[0];
				grupo = s[1];
				tituloPregunta = rs.getString("pregunta");
				
				numeroRespuestas = rs.getInt("conteo");
				if(rs.getString("tipo_evaluacion").contains("AUTOEVALUACION")) tipoEvaluacion = EvaluacionMateria.AUTOEVALUACION;
				
				indiceMateria=evaluacionMaterias.indexOf
				(new EvaluacionMateria(tipoEvaluacion,new Materia(codigoMateria,grupo),false));
				System.out.println(evaluacionMaterias);
				System.out.println(new EvaluacionMateria(tipoEvaluacion,new Materia(codigoMateria,grupo),false));
				if(indiceMateria!=-1)
				{	
					EvaluacionMateria ev = evaluacionMaterias.get(indiceMateria);
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
						//if(indicePregunta==0) System.out.println("indiceMateria:"+indiceMateria+"antes"+pregunta);
						pregunta.setEnunciado(rs.getString("enunciado"));
						pregunta.getNumeroRespuestasNivel()[nivel]=numeroRespuestas;
						
				//		if(indicePregunta==0) System.out.println("Codiop Materia"+codigoMateria+" grupo "+grupo+" preg "+tituloPregunta+"Nivel "+nivel+" Respuestas: "+numeroRespuestas);
					//	if(indicePregunta==0) System.out.println(pregunta);
						}
					}
				}							
			}
			// realiza los cálculos de los porcentajes y promedios
			
			for(EvaluacionMateria evaluacionMateria:evaluacionMaterias)
			{
				/*
				int sum=0;
				Pregunta pregunta = evaluacionMateria.getPreguntas().get(0);
				for(int i=0; i<pregunta.getNumeroRespuestasNivel().length;i++)
				{
					sum = sum + pregunta.getNumeroRespuestasNivel()[i];
				}
				evaluacionMateria.setEvaluados(sum);
				//porcentajes
				for(Pregunta preg:evaluacionMateria.getPreguntas())
				{
					for( int j=0; j<preg.getNumeroRespuestasNivel().length;j++)
					{
						if(evaluacionMateria.getEvaluados()>0)
						{	
						preg.getPorecentajeNivel()[Nivel.INFERIOR] =  preg.getNumeroRespuestasNivel()[Nivel.INFERIOR] /(double)evaluacionMateria.getEvaluados();
						preg.getPorecentajeNivel()[Nivel.BAJO] =  preg.getNumeroRespuestasNivel()[Nivel.BAJO] /(double)evaluacionMateria.getEvaluados();
						preg.getPorecentajeNivel()[Nivel.MEDIO] =  preg.getNumeroRespuestasNivel()[Nivel.MEDIO] /(double)evaluacionMateria.getEvaluados();
						preg.getPorecentajeNivel()[Nivel.ALTO] =  preg.getNumeroRespuestasNivel()[Nivel.ALTO] /(double)evaluacionMateria.getEvaluados();
						preg.getPorecentajeNivel()[Nivel.SUPERIOR] =  preg.getNumeroRespuestasNivel()[Nivel.SUPERIOR] /(double)evaluacionMateria.getEvaluados();
						}
					}
				}
				//promedios
			  
				for(Pregunta preg:evaluacionMateria.getPreguntas())
				{
					int tipo = preg.getTipoPregunta();
					for( nivel=0; nivel<preg.getNumeroRespuestasNivel().length;nivel++)
					{
						
						evaluacionMateria.getPromedioRespuestas()[tipo][nivel] =  evaluacionMateria.getPromedioRespuestas()[tipo][nivel] + preg.getNumeroRespuestasNivel()[nivel];
						evaluacionMateria.getPromedioPorcentaje()[tipo][nivel] =  evaluacionMateria.getPromedioPorcentaje()[tipo][nivel] + preg.getPorecentajeNivel()[nivel];
				
					}
					
					
				}
				
				for( nivel=0; nivel<=4;nivel++)
				{
					evaluacionMateria.getPromedioRespuestas()[Pregunta.PEDAGOGICO][nivel] =  evaluacionMateria.getPromedioRespuestas()[Pregunta.PEDAGOGICO][nivel] /6;
					evaluacionMateria.getPromedioPorcentaje()[Pregunta.PEDAGOGICO][nivel] =  evaluacionMateria.getPromedioRespuestas()[Pregunta.PEDAGOGICO][nivel] /6;
					evaluacionMateria.getPromedioRespuestas()[Pregunta.ESPECIFICO][nivel] =  evaluacionMateria.getPromedioRespuestas()[Pregunta.ESPECIFICO][nivel] /3;
					evaluacionMateria.getPromedioPorcentaje()[Pregunta.ESPECIFICO][nivel] =  evaluacionMateria.getPromedioRespuestas()[Pregunta.ESPECIFICO][nivel] /3;
					evaluacionMateria.getPromedioRespuestas()[Pregunta.RELACIONAL][nivel] =  evaluacionMateria.getPromedioRespuestas()[Pregunta.RELACIONAL][nivel] /3;
					evaluacionMateria.getPromedioPorcentaje()[Pregunta.RELACIONAL][nivel] =  evaluacionMateria.getPromedioRespuestas()[Pregunta.RELACIONAL][nivel] /3;
		
				}
			*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		
		}	
         
     
	}
	
	

}
