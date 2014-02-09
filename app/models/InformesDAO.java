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
	final static String consultaInformeFinal = "SELECT aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, '', '', '',0,aa2.VALOR,sum(aa2.CONTEO) as suma,SUBSTR (aa2.PREGUNTA,1,4) as saber FROM "+ 
"(SELECT AM.MAT_NOMBRE AS nombre_materia, "+
       "GRP.MAT_CODIGO AS codigo_materia, "+ 
       "GRP.GRU_CODIGO AS grupo, "+
       "GRP.GRU_CUPO_ASIGNADO AS inscritos "+
       "FROM   SAI.ART_MATERIAS AM, "+
       "SAI.ART_GRUPOS_VIGENTES GRP "+
       "WHERE       GRP.GRU_SEMESTRE = ? "+ // 1 semestre
       "AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "+
       "AND GRP.CLI_TIPODCTO <> 'OT' "+
       "AND GRP.CLI_TDCTO_PROF <> 'OT' "+
       "AND AM.MAT_CODIGO = GRP.MAT_CODIGO "+
       "AND GRP.CLI_NDCTO_PROF = ?) aa1 left join "+  // 2 documento
"(select MATERIA,VALOR, CONTEO,f.TITULO as pregunta,  G.TITULO AS TIPO_CUESTIONARIO, "+ 
"SUBSTR (MATERIA, 1, INSTR (MATERIA, '|') - 1) as codigo_materia,  "+
"SUBSTR (MATERIA, INSTR (MATERIA, '|',2) + 2, INSTR (MATERIA, '|',3) - 4) as grupo "+
"from "+
"(select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from "+
"(SELECT * "+
"from (select * "+
"from sai.tbl_resultados) c, "+
"(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from "+
"(select * "+
"from sai.tbl_resultados) a, "+
"(select distinct IDRESULTADOS, valor "+
"from sai.tbl_resultados "+
"where valor like ?) b "+ // 3 %semestre%
"where a.IDRESULTADOS =b.IDRESULTADOS "+
"and a.valor like '%||%' and a.valor not like ?) d "+ // 4 %semestre%
"where c.IDRESULTADOS =d.z "+
") h  "+
"where profesor like ? "+ //5 %documento%
"and valor not like '%||%' "+
"group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w, "+
"sai.TBL_H_PREGUNTAS f, "+
"sai.TBL_H_CUESTIONARIOS g "+
"where "+
"w.IDPREGUNTAH= f.IDPREGUNTAH "+
"and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH "+
"order by materia,pregunta "+
") aa2 "+
"on aa1.codigo_materia=aa2.codigo_materia and aa1.grupo = aa2.grupo "+
"where SUBSTR (aa2.PREGUNTA,1,4)='Rela' or SUBSTR (aa2.PREGUNTA,1,4) ='Peda' or SUBSTR (aa2.PREGUNTA,1,4)='Espe' "+
"group by aa2.TIPO_CUESTIONARIO,aa2.VALOR,SUBSTR (aa2.PREGUNTA,1,4) "+
"union "+
"SELECT    "+
 "         HCU.TITULO, "+
 "         CLI.CLI_TIPODCTO, "+
 "         DR.CLI_NUMDCTO AS CODIGO_PROFESOR, "+
 "         'nn', "+
 "         0, "+
 "        RTA.VALOR RESPUESTA, "+
 "        count(*), "+
 "        SUBSTR (PRE.TITULO,1,4)  AS CONSECUTIVO "+
 "  FROM   sai.TBL_H_PREGUNTAS PRE, "+
 "         sai.RCT_CLIENTES CLI, "+
 "         sai.TBL_INSTANCIA_EVADOC DDOC, "+
 "         sai.TBL_ENCUESTADO TE, "+
 "         sai.TBL_H_CUESTIONARIOS HCU, "+
 "         sai.TBL_DOCENTE_ROL TDRO,  "+
 "         sai.TBL_RESULTADOS RTA, "+
 "         sai.TBL_RESULTADOS_EVADOC RTADDOC, "+
 "         (SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL "+
 "            FROM   sai.TBL_DOCENTE_RELACION TDRE "+
 "           WHERE   ID_DOCENTE_ROL IN "+
 "                         (SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR "+
 " WHERE "+
 " HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
" where fecha_inicia >  to_date(?,'yyyy-mm-dd')  "+ // 6 fecha inicio
" and fecha_inicia < to_date(?,'yyyy-mm-dd') and (titulo like '%INVEST%' or titulo like '%GEST%'))) "+ // 7 fecha fin
  "        AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO "+
  "        AND DR.CLI_NUMDCTO = DDOC.CODIGO_PROFESOR "+
  "        AND TDRO.ID_DOCENTE_ROL = DR.ID_DOCENTE_ROL "+
  "        AND HCU.IDCUESTIONARIOH = TE.IDCUESTIONARIOH "+
  "        AND RTA.IDRESULTADOS = TE.IDRESULTADOS "+
  "        AND TE.CEDULA = TDRO.CLI_NUMDCTO "+
  "        AND HCU.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
  "        AND HCU.IDCUESTIONARIOH = RTA.IDCUESTIONARIOH "+
  "        AND RTA.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
  "        AND RTA.IDRESULTADOS = RTADDOC.IDRESULTADO "+
  "        AND RTA.IDPREGUNTAH = PRE.IDPREGUNTAH "+
  "        AND RTADDOC.IDINSTANCIA = DDOC.IDINSTANCIA "+
  "        AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy-mm-dd') "+ // 8 fecha inicio
  "        and codigo_profesor=? "+ //9 documento
  "       group by  "+
  "       HCU.TITULO, "+
  "        CLI.CLI_TIPODCTO, "+
  "       DR.CLI_NUMDCTO, "+
  "        'nn', "+
  "        0, "+
  "       RTA.VALOR,  "+
  "       SUBSTR (PRE.TITULO,1,4)";
	final static String consultaEvaluacion = "SELECT aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, aa1.NOMBRE_MATERIA, aa1.CODIGO_MATERIA, aa1.GRUPO,aa1.INSCRITOS,aa2.VALOR,aa2.CONTEO,aa2.PREGUNTA,aa2.ENUNCIADO " +
			"FROM (SELECT AM.MAT_NOMBRE AS nombre_materia, GRP.MAT_CODIGO AS codigo_materia, GRP.GRU_CODIGO AS grupo," +
			"GRP.GRU_CUPO_ASIGNADO AS inscritos "+
			"FROM   SAI.ART_MATERIAS AM, "+ 
			"SAI.ART_GRUPOS_VIGENTES GRP "+
			"WHERE       GRP.GRU_SEMESTRE = ? "+ // 1 SEMESTRE
			"AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "+
			"AND GRP.CLI_TIPODCTO <> 'OT' "+
			"AND GRP.CLI_TDCTO_PROF <> 'OT' "+
			"AND AM.MAT_CODIGO = GRP.MAT_CODIGO "+
			"AND GRP.CLI_NDCTO_PROF = ?) aa1 left join "+ // 2 CEDULA
			"(select MATERIA,VALOR, CONTEO,f.TITULO as pregunta, ENUNCIADO, G.TITULO AS TIPO_CUESTIONARIO, "+ 
			"SUBSTR (MATERIA, 1, INSTR (MATERIA, '|') - 1) as codigo_materia, "+ 
			"SUBSTR (MATERIA, INSTR (MATERIA, '|',2) + 2, INSTR (MATERIA, '|',3) - 4) as grupo "+
			"from (select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from "+
			"(SELECT * from (select * from sai.tbl_resultados) c, "+
			"(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from "+
			"(select * 	from sai.tbl_resultados) a, "+
			"(select distinct IDRESULTADOS, valor "+
			"from sai.tbl_resultados "+
 			"where valor like ?) b "+ //3 %SEMESTRE%
			"where a.IDRESULTADOS =b.IDRESULTADOS "+
			"and a.valor like '%||%' and a.valor not like ?) d "+ // 4 %SEMESTRE%
			"where c.IDRESULTADOS =d.z ) h "+
			"where profesor like ? "+ //5 %CEDULA%
			"and valor not like '%||%' "+
			"group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w, "+
			"sai.TBL_H_PREGUNTAS f, "+
			"sai.TBL_H_CUESTIONARIOS g "+
			"where w.IDPREGUNTAH= f.IDPREGUNTAH "+
			"and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH "+
			"order by materia,pregunta ) aa2 "+
			"on aa1.codigo_materia=aa2.codigo_materia and aa1.grupo = aa2.grupo "+
			"union	SELECT HCU.TITULO, CLI.CLI_TIPODCTO, CEDULA, CLI.CLI_NOMBRES,0,VALOR,1,PRE.TITULO AS CONSECUTIVO,ENUNCIADO "+
				    "FROM   sai.TBL_RESULTADOS RE, "+
				    "sai.TBL_H_PREGUNTAS PRE, sai.RCT_CLIENTES CLI,sai.TBL_H_CUESTIONARIOS HCU,sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP,sai.TBL_ENCUESTADO ENC, "+
				           "(SELECT   DISTINCT "+
				                     "(CLI.CLI_NUMDCTO), "+ 
				                     "RTA.IDRESULTADOS, "+
				                     "ENC.IDCUESTIONARIOH, "+
				                     "DECODE ( "+
				                        "(LENGTH ( "+
				                            " SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1) "+
				                        " )), "+
				                        " 6, "+
				                        "SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1), "+
				                        "'' "+
				                     ") "+
				                     "MATERIA, "+
				                     "CPR.ORDEN, "+
				                     "DECODE ( "+
				                     "(LENGTH ( "+
				                          "SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4) "+
				                        ")), "+
				                        "3, "+
				                       "SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4), "+
				                       "'' "+
				                     ") "+
				                      "GRUPO "+
				              "FROM   sai.RCT_CLIENTES CLI, "+
				               "sai.TBL_ENCUESTADO ENC, "+
				               "sai.TBL_RESULTADOS RTA, "+
				               "sai.TBL_H_CUESTIONARIOS CUE, "+
				               "sai.TBL_H_CUESTIONARIO_PREGUNTAS CPR, "+
				               "sai.TBL_H_PREGUNTAS PRE "+
				             "WHERE       ENC.IDRESULTADOS = RTA.IDRESULTADOS "+
				                    "AND RTA.IDPREGUNTAH = CPR.IDPREGUNTAH " +
				                    "AND RTA.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
				                    "AND CUE.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH " +
				                    "AND PRE.IDPREGUNTAH = CPR.IDPREGUNTAH "+
				                    "AND CUE.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
				                     "AND ENC.CEDULA = CLI.CLI_NUMDCTO "+
				                     "AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd')) "+ // 6 FECHA INICIO
				           "DBAC WHERE       ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
				           "where fecha_inicia >  to_date(?,'yyyy-mm-dd') "+ // 7 FECHA INICIO
				           "and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+ // 8 FECHA FIN
				           "AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
				           "FROM   sai.TBL_DOCENTE_RELACION "+
				           "WHERE   ESTADO = 'ACT') "+
				           "AND CLI.CLI_NUMDCTO = CEDULA "+
				           "AND DBAC.CLI_NUMDCTO = CEDULA "+
				           "AND DBAC.IDRESULTADOS = RE.IDRESULTADOS "+
				           "AND DBAC.IDRESULTADOS = ENC.IDRESULTADOS "+
				           "AND DBAC.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
				           "AND DBAC.IDCUESTIONARIOH = HCU.IDCUESTIONARIOH "+
				           "AND DBAC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
				           "AND DBAC.ORDEN = THCP.ORDEN "+
				           "AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
				           "AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
				           "AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
				           "AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
				           "AND RE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
				           "AND RE.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
				           "AND HCU.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
				           "AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
				           "AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd') "+ // 9 FECHA INICIO
				 "and CEDULA = ? "+ // 10 CEDULA
				 "UNION " +
				 "SELECT HCU.TITULO, CLI.CLI_TIPODCTO, DR.CLI_NUMDCTO AS CODIGO_PROFESOR,'nn',0,RTA.VALOR RESPUESTA,1,PRE.TITULO AS CONSECUTIVO, "+   
 "ENUNCIADO "+   
      "FROM   sai.TBL_H_PREGUNTAS PRE, "+
           "sai.RCT_CLIENTES CLI, "+
           "sai.TBL_INSTANCIA_EVADOC DDOC, "+
           "sai.TBL_ENCUESTADO TE, "+
           "sai.TBL_H_CUESTIONARIOS HCU, "+
           "sai.TBL_DOCENTE_ROL TDRO, "+
           "sai.TBL_RESULTADOS RTA, "+
           "sai.TBL_RESULTADOS_EVADOC RTADDOC, "+
           "(SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL "+
           "FROM   sai.TBL_DOCENTE_RELACION TDRE "+
           "WHERE   ID_DOCENTE_ROL IN "+
           "(SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR "+
   "WHERE "+
   "HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
	"where fecha_inicia >  to_date(?,'yyyy-mm-dd') "+ // 11 fecha inicio
	"and fecha_inicia < to_date(?,'yyyy-mm-dd') and (titulo like '%INVEST%' or titulo like '%GEST%'))) "+ // 12.fecha fin
           "AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO " +
           "AND DR.CLI_NUMDCTO = DDOC.CODIGO_PROFESOR "+
           "AND TDRO.ID_DOCENTE_ROL = DR.ID_DOCENTE_ROL "+
           "AND HCU.IDCUESTIONARIOH = TE.IDCUESTIONARIOH "+
           "AND RTA.IDRESULTADOS = TE.IDRESULTADOS "+
           "AND TE.CEDULA = TDRO.CLI_NUMDCTO "+
           "AND HCU.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
           "AND HCU.IDCUESTIONARIOH = RTA.IDCUESTIONARIOH "+
           "AND RTA.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
           "AND RTA.IDRESULTADOS = RTADDOC.IDRESULTADO  "+
           "AND RTA.IDPREGUNTAH = PRE.IDPREGUNTAH "+
           "AND RTADDOC.IDINSTANCIA = DDOC.IDINSTANCIA "+
           "AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy/mm/dd') "+ //13 fecha inicio
           " and codigo_profesor=? "+ // 14.cedula
	"union "+
	"SELECT     HCU.TITULO, "+
	           "'', "+
	           "TIE.CODIGO_MATERIA, "+
	           "TIE.CODIGO_GRUPO, "+
	           "0, "+
	           "VALOR, "+
	           "1, "+
	           "PRE.TITULO AS CONSECUTIVO, "+
	           "ENUNCIADO "+
	    "FROM   sai.TBL_RESULTADOS RE, "+
	           "sai.TBL_H_PREGUNTAS PRE, "+
	           "sai.RCT_CLIENTES CLI, "+
	           "sai.TBL_H_CUESTIONARIOS HCU, "+
	           "sai.TBL_INSTANCIA_EVADOC TIE, "+
	           "sai.TBL_RESULTADOS_EVADOC TRE, "+
	           "sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP, "+
	           "sai.TBL_ENCUESTADO ENC "+
	   "WHERE ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
		"where fecha_inicia >  to_date(?,'yyyy-mm-dd') "+ // 15 fecha inicio 
		"and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+ // 16 fecha fin
	    "AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
	                            "FROM   sai.TBL_DOCENTE_RELACION "+
	                           "WHERE   ESTADO = 'ACT') "+
	           "AND CLI.CLI_NUMDCTO = CEDULA "+
	           "AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
	           "AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
	           "AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
	           "AND ENC.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
	           "AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
	           "AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
	           "AND TIE.IDINSTANCIA = TRE.IDINSTANCIA "+
	           "AND ENC.IDRESULTADOS = TRE.IDRESULTADO "+
	           "AND HCU.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
	           "AND ENC.IDCUESTIONARIOH = TIE.IDCUESTIONARIOH "+
	           "AND RE.IDCUESTIONARIOH = TIE.IDCUESTIONARIOH "+
	           "AND HCU.IDCUESTIONARIOH = TIE.IDCUESTIONARIOH "+
	           "AND TIE.PERIODO = ? "+ // 17. semestre
	           "AND TIE.CODIGO_PROFESOR = CLI.CLI_NUMDCTO "+
	           "AND TIE.CODIGO_PROFESOR = CEDULA "+
	           "AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd') "+ // 18 fecha inicio
	           "and codigo_profesor=? "; // 19 cedula
	
	final static String consultaHeteroEvaluacion = "Select aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, aa1.NOMBRE_MATERIA, aa1.CODIGO_MATERIA, aa1.GRUPO,aa1.INSCRITOS,aa2.VALOR,sum(aa2.CONTEO) as suma,SUBSTR (aa2.PREGUNTA,1,4) as saber from"+ 
"(SELECT AM.MAT_NOMBRE AS nombre_materia, "+
       "GRP.MAT_CODIGO AS codigo_materia, "+
       "GRP.GRU_CODIGO AS grupo, "+
       "GRP.GRU_CUPO_ASIGNADO AS inscritos "+
       "FROM   SAI.ART_MATERIAS AM, "+
       "SAI.ART_GRUPOS_VIGENTES GRP "+
       "WHERE       GRP.GRU_SEMESTRE = ? "+ //1 semestre
       "AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "+
       "AND GRP.CLI_TIPODCTO <> 'OT' "+
       "AND GRP.CLI_TDCTO_PROF <> 'OT' "+
       "AND AM.MAT_CODIGO = GRP.MAT_CODIGO "+
       "AND GRP.CLI_NDCTO_PROF = ?) aa1 left join "+ // 2 documento
"(select MATERIA,VALOR, CONTEO,f.TITULO as pregunta,  G.TITULO AS TIPO_CUESTIONARIO, "+ 
"SUBSTR (MATERIA, 1, INSTR (MATERIA, '|') - 1) as codigo_materia, "+ 
"SUBSTR (MATERIA, INSTR (MATERIA, '|',2) + 2, INSTR (MATERIA, '|',3) - 4) as grupo "+
"from "+
"(select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from "+
"(SELECT * "+
"from (select * "+
"from sai.tbl_resultados) c, "+
"(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from "+ 
"(select * "+
"from sai.tbl_resultados) a, "+
"(select distinct IDRESULTADOS, valor "+
"from sai.tbl_resultados "+
"where valor like ?) b "+ // 3 %semestre%
"where a.IDRESULTADOS =b.IDRESULTADOS "+
"and a.valor like '%||%' and a.valor not like ?) d "+ // 4 %semestre%
"where c.IDRESULTADOS =d.z "+
") h "+
"where profesor like ? "+ // 5 %documento%
"and valor not like '%||%' "+
"group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w, "+
"sai.TBL_H_PREGUNTAS f, "+
"sai.TBL_H_CUESTIONARIOS g "+
"where "+
"w.IDPREGUNTAH= f.IDPREGUNTAH "+
"and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH "+
"order by materia,pregunta "+
") aa2 "+
"on aa1.codigo_materia=aa2.codigo_materia and aa1.grupo = aa2.grupo "+
"group by aa2.TIPO_CUESTIONARIO, aa1.NOMBRE_MATERIA, aa1.CODIGO_MATERIA, aa1.GRUPO,aa1.INSCRITOS,aa2.VALOR,SUBSTR (aa2.PREGUNTA,1,4) "+
"union "+
"   SELECT "+   
"           HCU.TITULO, "+
"           CLI.CLI_TIPODCTO, "+
"          DR.CLI_NUMDCTO AS CODIGO_PROFESOR, "+
"           'nn', "+
"           0, "+
"          RTA.VALOR RESPUESTA, "+
"           count(*), "+
"          SUBSTR (PRE.TITULO,1,4)  AS CONSECUTIVO "+
"    FROM   sai.TBL_H_PREGUNTAS PRE,  "+
"           sai.RCT_CLIENTES CLI, "+
"           sai.TBL_INSTANCIA_EVADOC DDOC, "+
"           sai.TBL_ENCUESTADO TE, "+
"           sai.TBL_H_CUESTIONARIOS HCU, "+
"           sai.TBL_DOCENTE_ROL TDRO,  "+
"            sai.TBL_RESULTADOS RTA, "+
"           sai.TBL_RESULTADOS_EVADOC RTADDOC, "+
"            (SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL "+
"              FROM   sai.TBL_DOCENTE_RELACION TDRE "+
"             WHERE   ID_DOCENTE_ROL IN "+
"                           (SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR "+
"   WHERE "+
"   HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"	where fecha_inicia >  to_date(?,'yyyy-mm-dd') "+ // 6 fecha inicio
"	and fecha_inicia < to_date(?,'yyyy-mm-dd') and (titulo like '%INVEST%' or titulo like '%GEST%'))) "+ // 7 fecha_fin
"           AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO "+
"           AND DR.CLI_NUMDCTO = DDOC.CODIGO_PROFESOR "+
"           AND TDRO.ID_DOCENTE_ROL = DR.ID_DOCENTE_ROL "+
"           AND HCU.IDCUESTIONARIOH = TE.IDCUESTIONARIOH "+
"           AND RTA.IDRESULTADOS = TE.IDRESULTADOS "+
"           AND TE.CEDULA = TDRO.CLI_NUMDCTO "+
"           AND HCU.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
"           AND HCU.IDCUESTIONARIOH = RTA.IDCUESTIONARIOH "+
"           AND RTA.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
"           AND RTA.IDRESULTADOS = RTADDOC.IDRESULTADO "+
"           AND RTA.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"           AND RTADDOC.IDINSTANCIA = DDOC.IDINSTANCIA "+
"           AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy-mm-dd') "+ // 8 fecha de inicio
"           and codigo_profesor=? "+ // 9 documento
"          group by  "+
"          HCU.TITULO, "+
"           CLI.CLI_TIPODCTO, "+
"          DR.CLI_NUMDCTO, "+
"           'nn', "+
"           0, "+
"          RTA.VALOR, "+
"          SUBSTR (PRE.TITULO,1,4)";
	
	public static Evaluacion
	getInformeFinal(String documentoProfesor, String semestre)
	{
		 List<EvaluacionMateria> evaluacionMaterias = new ArrayList<EvaluacionMateria>();
		 EvaluacionGestion evaluacionGestion = new EvaluacionGestion(Pregunta.GESTION); 
		 EvaluacionInvestigacion evaluacionInvestigacion = new EvaluacionInvestigacion(Pregunta.INVESTIGACION); 
		 EvaluacionGestion autoEvaluacionGestion = new EvaluacionGestion(Pregunta.GESTION); 
		 EvaluacionInvestigacion autoEvaluacionInvestigacion = new EvaluacionInvestigacion(Pregunta.INVESTIGACION); 
		 Connection con = DB.getConnection();
		 String periodo[] = Periodo.getFecha(semestre);
		 EvaluacionMateria ev=null;
		 double totalDocencia[]= new double[3];
		 double totalAutoEvalDocencia[]= new double[3];
		 double totalGestion=0;
		 double totalAutoEvalGestion=0;
		 double totalInvestigacion=0;
		 double totalAutoEvalInvestigacion=0;
		int indicePregunta;
		int indiceMateria;
		int nivel;
		String s[];
		int tipoEvaluacion=0;
		String codigoMateria;
		PreparedStatement p;
		String grupo;
		String tituloPregunta;
		int numeroRespuestas;
		String materiaAnterior="";
		 try {
				p = con.prepareStatement(consultaInformeFinal);
				p.setString(1, semestre);
				p.setString(2, documentoProfesor);
				p.setString(3, "%%"+semestre+"%%");
				p.setString(4, "%%"+semestre+"%%");
				p.setString(5, "%%"+documentoProfesor+"%%");
				p.setString(6, periodo[Periodo.FECHAINICIO]);
				p.setString(7, periodo[Periodo.FECHAFIN]);
				p.setString(8, periodo[Periodo.FECHAINICIO]);
				p.setString(9, documentoProfesor);
				ResultSet rs=p.executeQuery();
				int saber = 0;
				
				while (rs.next()) {
				
				if(rs.getString("tipo_evaluacion").contains("ESTUDIANTES") || rs.getString("tipo_evaluacion").contains("AUTOEVALUACION DE LA DOCENCIA"))
				{	
					
					if(!(rs.getString("tipo_evaluacion")).equals(materiaAnterior))
					{
						tipoEvaluacion = EvaluacionMateria.EVALUACION;
						if(rs.getString("tipo_evaluacion").contains("AUTOEVALUACION")) 
							{
							tipoEvaluacion = EvaluacionMateria.AUTOEVALUACION;
					
							}
						
				
						ev = new EvaluacionMateria(tipoEvaluacion,new Materia("",rs.getString("tipo_evaluacion"),"", 0),false);
						
						materiaAnterior=rs.getString("tipo_evaluacion");
						evaluacionMaterias.add(ev);
						
					}
					if(rs.getString("saber").equals("Peda")) saber=0;
					else if(rs.getString("saber").equals("Espe")) saber=1;
					else if(rs.getString("saber").equals("Rela")) saber=2;
					else saber=10;
					
					if(saber<3)
					{	
						System.out.println(rs.getString("valor"));
					System.out.println("valor"+rs.getInt("valor"));	
					System.out.println("suma"+rs.getInt("suma"));
					ev.getPromedioRespuestas()[saber][rs.getInt("valor")-1]=rs.getInt("suma");
						if (tipoEvaluacion == EvaluacionMateria.AUTOEVALUACION)
						{
							totalAutoEvalDocencia[saber]=totalAutoEvalDocencia[saber]+rs.getInt("suma");
						}
						else
						{
							totalDocencia[saber]=totalDocencia[saber]+rs.getInt("suma");
						}
					}
					
					
				}
				if(evaluacionMaterias.size()==0) evaluacionMaterias.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("","","", 0),false));
				if(evaluacionMaterias.size()==1) evaluacionMaterias.add(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,new Materia("","","", 0),false));
				if(rs.getString("saber").equals("Gest"))
				{
					if(rs.getString("tipo_evaluacion").contains("AUTO"))
					{	
					autoEvaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("suma");
					totalAutoEvalGestion = totalAutoEvalGestion + rs.getInt("suma");
					}
					else
					{	
					evaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("suma");
					totalGestion = totalGestion + rs.getInt("suma");
					}
					
				}
				if(rs.getString("saber").equals("Inve"))
				{	if(rs.getString("tipo_evaluacion").contains("AUTO"))
					{
					autoEvaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("suma");
					totalAutoEvalInvestigacion = totalAutoEvalInvestigacion + rs.getInt("suma");
					}
					else
					{	
					evaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("suma");
					totalInvestigacion = totalInvestigacion + rs.getInt("suma"); 
					}
				}
				}
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Excepcion : "+e.getMessage());
				System.out.println(e.getLocalizedMessage());
			
			}
		 
		 double total;
		 for(int i=0;i<=3;i++)
		 {	 
			 if(totalGestion>0) evaluacionGestion.getPromedioRespuestas()[i] = evaluacionGestion.getPromedioRespuestas()[i]/totalGestion;
			 if(totalAutoEvalGestion>0) autoEvaluacionGestion.getPromedioRespuestas()[i] = evaluacionGestion.getPromedioRespuestas()[i]/totalAutoEvalGestion;
		 }
		 for(int i=0;i<=4;i++)
		 {	 
			 if(totalInvestigacion>0) evaluacionInvestigacion.getPromedioRespuestas()[i] = evaluacionInvestigacion.getPromedioRespuestas()[i]/totalInvestigacion;
			 if(totalAutoEvalInvestigacion>0) autoEvaluacionInvestigacion.getPromedioRespuestas()[i] = autoEvaluacionInvestigacion.getPromedioRespuestas()[i]/totalAutoEvalInvestigacion;
		 }
		 for(int i=0;i<=4;i++)
		 {	 
			 for(int j=0;j<=2;j++)
			 {
				 if(totalDocencia[j]>0) evaluacionMaterias.get(0).getPromedioRespuestas()[j][i] =  evaluacionMaterias.get(0).getPromedioRespuestas()[j][i]/totalDocencia[j];
				 if(totalAutoEvalDocencia[j]>0) evaluacionMaterias.get(1).getPromedioRespuestas()[j][i] =  evaluacionMaterias.get(1).getPromedioRespuestas()[j][i]/totalAutoEvalDocencia[j];
			 }
		 }
		 return new Evaluacion(evaluacionMaterias, evaluacionGestion, evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion);

		
		
	}
	public static Evaluacion
	getInformeHeteroEvaluacion(String documentoProfesor, String semestre)
	{
		List<EvaluacionMateria> evaluacionMaterias = new ArrayList<EvaluacionMateria>();
		 EvaluacionGestion evaluacionGestion = new EvaluacionGestion(Pregunta.GESTION); 
		 EvaluacionInvestigacion evaluacionInvestigacion = new EvaluacionInvestigacion(Pregunta.INVESTIGACION); 
		 Connection con = DB.getConnection();
		 String periodo[] = Periodo.getFecha(semestre);
//19246543
		 int tipoEvaluacion;
		 String codigoMateria;
		 String grupo;
		 EvaluacionMateria ev=null;
		 PreparedStatement p;
		 String materiaAnterior="";
		 try {
				p = con.prepareStatement(consultaHeteroEvaluacion);
				p.setString(1, semestre);
				p.setString(2, documentoProfesor);
				p.setString(3, "%%"+semestre+"%%");
				p.setString(4, "%%"+semestre+"%%");
				p.setString(5, "%%"+documentoProfesor+"%%");
				p.setString(6, periodo[Periodo.FECHAINICIO]);
				p.setString(7, periodo[Periodo.FECHAFIN]);
				p.setString(8, periodo[Periodo.FECHAINICIO]);
				p.setString(9, documentoProfesor);
				ResultSet rs=p.executeQuery();
				int saber = 0;
				
				while (rs.next()) {
				
				if(rs.getString("tipo_evaluacion").contains("ESTUDIANTES"))
				{	
				
					if(!(rs.getString("CODIGO_MATERIA")+" "+rs.getString("GRUPO")).equals(materiaAnterior))
					{
						tipoEvaluacion = EvaluacionMateria.EVALUACION;
						if(rs.getString("tipo_evaluacion").contains("AUTOEVALUACION")) 
							{
							tipoEvaluacion = EvaluacionMateria.AUTOEVALUACION;
					
							}
						
				
						codigoMateria = rs.getString("CODIGO_MATERIA");
						grupo = rs.getString("GRUPO");
						ev = new EvaluacionMateria(tipoEvaluacion,new Materia(codigoMateria,rs.getString("NOMBRE_MATERIA"),grupo, rs.getInt("inscritos")),true);
						
						materiaAnterior=rs.getString("CODIGO_MATERIA")+" "+rs.getString("GRUPO");
						evaluacionMaterias.add(ev);
						
					}
					if(rs.getString("saber").equals("Peda")) saber=0;
					else if(rs.getString("saber").equals("Espe")) saber=1;
					else if(rs.getString("saber").equals("Rela")) saber=2;
					else saber=10;
					
					if(saber<3)
					{	
						System.out.println(rs.getString("valor"));
					System.out.println("valor"+rs.getInt("valor"));	
					System.out.println("suma"+rs.getInt("suma"));
					ev.getPromedioRespuestas()[saber][rs.getInt("valor")-1]=rs.getInt("suma");
					}
					
					
				}
				
				if(rs.getString("saber").equals("Gest"))
					evaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("suma");
				if(rs.getString("saber").equals("Inve"))
					evaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("suma");
				}
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Excepcion : "+e.getMessage());
				System.out.println(e.getLocalizedMessage());
			
			}
		 
							 
		 return new Evaluacion(evaluacionMaterias, evaluacionGestion, evaluacionInvestigacion,null,null);
		 
	}
	
	public static Evaluacion
	getInformeDetalladoPorMateria(String documentoProfesor, String semestre)
	{
		 List<EvaluacionMateria> evaluacionMaterias = new ArrayList<EvaluacionMateria>();
		 EvaluacionGestion evaluacionGestion = new EvaluacionGestion(Pregunta.GESTION); 
		 EvaluacionInvestigacion evaluacionInvestigacion = new EvaluacionInvestigacion(Pregunta.INVESTIGACION); 
		 EvaluacionGestion autoEvaluacionGestion = new EvaluacionGestion(Pregunta.GESTION); 
		 EvaluacionInvestigacion autoEvaluacionInvestigacion = new EvaluacionInvestigacion(Pregunta.INVESTIGACION); 
		 Connection con = DB.getConnection();
		 String periodo[] = Periodo.getFecha(semestre);

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
		String materiaAnterior="";
		try {
			p = con.prepareStatement(consultaEvaluacion);
			p.setString(1, semestre);
			p.setString(2, documentoProfesor);
			p.setString(3, "%%"+semestre+"%%");
			p.setString(4, "%%"+semestre+"%%");
			p.setString(5, "%%"+documentoProfesor+"%%");
			p.setString(6, periodo[Periodo.FECHAINICIO]);
			p.setString(7, periodo[Periodo.FECHAINICIO]);
			p.setString(8, periodo[Periodo.FECHAFIN]);
			p.setString(9, periodo[Periodo.FECHAINICIO]);
			p.setString(10, documentoProfesor);
			
			p.setString(11, periodo[Periodo.FECHAINICIO]);
			p.setString(12, periodo[Periodo.FECHAFIN]);
		
			p.setString(13, periodo[Periodo.FECHAINICIO]);
			p.setString(14, documentoProfesor);
			
	
			p.setString(15, periodo[Periodo.FECHAINICIO]);
			p.setString(16, periodo[Periodo.FECHAFIN]);
			p.setString(17, semestre);
			p.setString(18, periodo[Periodo.FECHAINICIO]);
			p.setString(19, documentoProfesor);
			
			
			ResultSet rs=p.executeQuery();
			
			EvaluacionMateria ev=null;
			while (rs.next()) {
			
			if(rs.getString("tipo_evaluacion").contains("ESTUDIANTES") || rs.getString("tipo_evaluacion").contains("AUTOEVALUACION DE LA DOCENCIA"))
			{	
				
				if(!(rs.getString("CODIGO_MATERIA")+" "+rs.getString("GRUPO")).equals(materiaAnterior))
				{
					tipoEvaluacion = EvaluacionMateria.EVALUACION;
					if(rs.getString("tipo_evaluacion").contains("AUTOEVALUACION")) 
						{
						tipoEvaluacion = EvaluacionMateria.AUTOEVALUACION;
				
						}
					
			
					codigoMateria = rs.getString("CODIGO_MATERIA");
					grupo = rs.getString("GRUPO");
					ev = new EvaluacionMateria(tipoEvaluacion,new Materia(codigoMateria,rs.getString("NOMBRE_MATERIA"),grupo, rs.getInt("inscritos")),true);
					
					materiaAnterior=rs.getString("CODIGO_MATERIA")+" "+rs.getString("GRUPO");
					evaluacionMaterias.add(ev);
					
				}
				
				tituloPregunta = rs.getString("pregunta");
				
				numeroRespuestas = rs.getInt("conteo");
				
				
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
					// realiza los cálculos de los porcentajes y promedios
					
					for(EvaluacionMateria evaluacionMateria:evaluacionMaterias)
					{
						
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
					
					}	
											
			}
			if(rs.getString("tipo_evaluacion").contains("GESTI"))
			{	
			
				Pregunta pregunta;
				
				tituloPregunta = rs.getString("pregunta");
				
				indicePregunta = evaluacionGestion.getPreguntas().indexOf(new Pregunta(tituloPregunta));
				numeroRespuestas = rs.getInt("conteo");
				EvaluacionGestion eg;
				if(indicePregunta!=-1)
				{	
				if(rs.getString("tipo_evaluacion").contains("AUTOEVAL"))
				{
					pregunta = autoEvaluacionGestion.getPreguntas().get(indicePregunta);
					eg = autoEvaluacionGestion;
				}
				else
				{
					
					pregunta = evaluacionGestion.getPreguntas().get(indicePregunta);
					eg = evaluacionGestion;
				}

				pregunta.setEnunciado(rs.getString("enunciado"));
				nivel = Integer.parseInt(rs.getString("valor")) -1;
				
				
				pregunta.getNumeroRespuestasNivel()[nivel]=numeroRespuestas;
				pregunta.getPorecentajeNivel()[nivel]=100;	
				eg.getPromedioPorcentaje()[nivel]=eg.getPromedioPorcentaje()[nivel]+100;
				eg.getPromedioRespuestas()[nivel]++;
				}

											
			}
			if(rs.getString("tipo_evaluacion").contains("INVESTIGA"))
			{	
				tituloPregunta = rs.getString("pregunta");
				Pregunta pregunta;
				numeroRespuestas = rs.getInt("conteo");
				indicePregunta = evaluacionInvestigacion.getPreguntas().indexOf(new Pregunta(tituloPregunta));
				EvaluacionInvestigacion ei=null;
				if(indicePregunta!=-1)
				{	
				nivel = Integer.parseInt(rs.getString("valor")) -1;
				if(rs.getString("tipo_evaluacion").contains("AUTOEVAL"))
				{
					pregunta = autoEvaluacionInvestigacion.getPreguntas().get(indicePregunta);
					ei=autoEvaluacionInvestigacion;
				}
					else
					{
					pregunta = evaluacionInvestigacion.getPreguntas().get(indicePregunta);
					ei=evaluacionInvestigacion;
					}
				pregunta.setEnunciado(rs.getString("enunciado"));
				pregunta.getNumeroRespuestasNivel()[nivel]=numeroRespuestas;
				pregunta.getPorecentajeNivel()[nivel]=100;
				ei.getPromedioPorcentaje()[nivel]=ei.getPromedioPorcentaje()[nivel]+100;
				ei.getPromedioRespuestas()[nivel]++;
											
				
				}
			
			}
			}
			
			} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		
		}
		for( nivel=0; nivel<=3;nivel++)
		{	
			evaluacionGestion.getPromedioPorcentaje()[nivel] = evaluacionGestion.getPromedioPorcentaje()[nivel]/6;
			evaluacionGestion.getPromedioRespuestas()[nivel] = evaluacionGestion.getPromedioRespuestas()[nivel]/6;
			autoEvaluacionGestion.getPromedioRespuestas()[nivel] = autoEvaluacionGestion.getPromedioRespuestas()[nivel]/6;
			autoEvaluacionGestion.getPromedioPorcentaje()[nivel] = autoEvaluacionGestion.getPromedioPorcentaje()[nivel]/6;
		} 
     return new Evaluacion(evaluacionMaterias, evaluacionGestion, evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion);
	}
	
	

}
