package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Clase DAO que se encarga de hacer las consultas de los informes 4, 5 y 6(por facultad, por programa)
 * Las constantes consultaPorFacultad, consultaPorPrograma contienen las consultas respectivas 
 * a la base de datos.
 * @author Camilo Rodríguez
 *
 */
public class ReportesDAO {
	/**
	 *  sql consulta evaluación por facultad
	 */
	final static String consultaPorFacultad="select codigo_facultad, nombre_facultad, avg(porcentaje) as porcentaje, valor, saber,tipo_evaluacion "+
"from "+
"( "+
"select distinct NIT codprof, id_facultad as codigo_facultad, nombre_facultad as nombre_facultad "+
"from( "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,facultad_centro_costo f "+
"where  "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) " +
//1.1 fecha contrato 1.2. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'CAT%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo "+
"UNION ALL "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,FACULTAD_CENTRO_COSTO F "+
"where "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) "+
// 1.3. fecha contrato 1.4.fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'DOC%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo )  "+
" )  facultades,  "+
"(select parcial.tipo_evaluacion as tipo_evaluacion, parcial.cedula as cedula, valor, 100*conteo/total.total as porcentaje  "+
", parcial.saber as saber from  "+
"(  "+
"SELECT aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, '', '', '',0,aa1.cedula as cedula,aa2.VALOR as valor,sum(aa2.CONTEO) as conteo,SUBSTR (aa2.PREGUNTA,1,4) as saber FROM   "+ 
"(SELECT AM.MAT_NOMBRE AS nombre_materia,   "+
"       GRP.MAT_CODIGO AS codigo_materia,   "+
"       GRP.GRU_CODIGO AS grupo,  "+
"       GRP.GRU_CUPO_ASIGNADO AS inscritos,  "+
"       GRP.CLI_NDCTO_PROF as cedula  "+
"       FROM   SAI.ART_MATERIAS AM,  "+
"       (select GRU_SEMESTRE,GRU_CODIGO, MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_HISTORIA_GRUPOS union select GRU_SEMESTRE, GRU_CODIGO,MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_GRUPOS_VIGENTES) GRP  "+
"        WHERE       GRP.GRU_SEMESTRE = ?  "+ // 2 semestre
"        AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE  "+
"        AND GRP.CLI_TIPODCTO <> 'OT'  "+
"        AND GRP.CLI_TDCTO_PROF <> 'OT'  "+
"        AND AM.MAT_CODIGO = GRP.MAT_CODIGO  "+
"        ) aa1 left join  "+
"(select MATERIA,VALOR, CONTEO,f.TITULO as pregunta,  G.TITULO AS TIPO_CUESTIONARIO,  "+ 
"SUBSTR (MATERIA, 1, INSTR (MATERIA, '|') - 1) as codigo_materia,   "+
"SUBSTR (MATERIA, INSTR (MATERIA, '|',2) + 2, INSTR (MATERIA, '|',3) - 4) as grupo  "+
"from  "+
"(select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from  "+
"(SELECT *  "+
"from (select *  "+
"from sai.tbl_resultados) c,  "+
"(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from  "+
"(select *  "+
"from sai.tbl_resultados) a,  "+
"(select distinct IDRESULTADOS, valor  "+
"from sai.tbl_resultados  "+
"where valor like ?) b  "+ // 3 %semestre%
"where a.IDRESULTADOS =b.IDRESULTADOS  "+
"and a.valor like '%||%' and a.valor not like ?) d  "+ // 4 %semestre%
"where c.IDRESULTADOS =d.z  "+
") h  "+
"where valor not like '%||%'  "+
"group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w,  "+
"sai.TBL_H_PREGUNTAS f,  "+
"sai.TBL_H_CUESTIONARIOS g  "+
"where  "+
"w.IDPREGUNTAH= f.IDPREGUNTAH  "+
"and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH  "+
"order by materia,pregunta  "+
") aa2  "+
"on aa1.codigo_materia=aa2.codigo_materia and aa1.grupo = aa2.grupo  "+
"where SUBSTR (aa2.PREGUNTA,1,4)='Rela' or SUBSTR (aa2.PREGUNTA,1,4) ='Peda' or SUBSTR (aa2.PREGUNTA,1,4)='Espe'  "+
"group by aa2.TIPO_CUESTIONARIO,aa1.cedula, aa2.VALOR,SUBSTR (aa2.PREGUNTA,1,4)  "+
"union  "+
"  select t,  "+
"           '',  "+
"           '',  "+
"           'nn',  "+
"           0,  "+
"           codProf,  "+
"           respuesta,  "+
"           count(*),  "+
"         saber  "+
"from(  "+
"SELECT     "+
"     distinct  "+     
"         RTA.IDPREGUNTAH,  "+
"           HCU.TITULO t,  "+
"          DR.CLI_NUMDCTO as codProf,  "+
"           'nn',  "+
"           0,  "+
"          RTA.VALOR RESPUESTA,  "+
"           1,  "+
"           SUBSTR (PRE.TITULO,1,4) as saber  "+
"    FROM   sai.TBL_H_PREGUNTAS PRE,  "+
"           sai.RCT_CLIENTES CLI,  "+
"           sai.TBL_INSTANCIA_EVADOC DDOC,  "+
"           sai.TBL_ENCUESTADO TE,  "+
"           sai.TBL_H_CUESTIONARIOS HCU,  "+
"           sai.TBL_DOCENTE_ROL TDRO,  "+
"           sai.TBL_RESULTADOS RTA,  "+
"           sai.TBL_RESULTADOS_EVADOC RTADDOC,  "+
"           (SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL  "+
"              FROM   sai.TBL_DOCENTE_RELACION TDRE  "+
"             WHERE   ID_DOCENTE_ROL IN  "+
"                           (SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR  "+
"   WHERE  "+
"   HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS  "+
"	where fecha_inicia >  to_date(?,'yyyy-mm-dd')   "+ // 5 fecha inicio
"	and fecha_inicia < to_date(?,'yyyy-mm-dd') and (titulo like '%INVEST%' or titulo like '%GEST%')))  "+ // 6 fecha fin
"             AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO  "+
"           AND DR.CLI_NUMDCTO = DDOC.CODIGO_PROFESOR  "+
"           AND TDRO.ID_DOCENTE_ROL = DR.ID_DOCENTE_ROL  "+
"           AND HCU.IDCUESTIONARIOH = TE.IDCUESTIONARIOH  "+
"           AND RTA.IDRESULTADOS = TE.IDRESULTADOS  "+
"           AND TE.CEDULA = TDRO.CLI_NUMDCTO  "+
"           AND HCU.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH  "+
"           AND HCU.IDCUESTIONARIOH = RTA.IDCUESTIONARIOH  "+
"           AND RTA.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH  "+
"           AND RTA.IDRESULTADOS = RTADDOC.IDRESULTADO  "+
"           AND RTA.IDPREGUNTAH = PRE.IDPREGUNTAH  "+
"           AND RTADDOC.IDINSTANCIA = DDOC.IDINSTANCIA  "+
"           AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy-mm-dd')  "+ // 7 fecha inicio
" ) zz  "+
"group by  "+
"t,  "+
"           '',  "+
"           'nn',  "+
"           0,  "+
"           codProf,  "+
"           respuesta,  "+
"           saber  "+
"  UNION  "+
"SELECT     HCU.TITULO,  "+
"           CLI.CLI_TIPODCTO,  "+
"           '',  "+
"           'nn',  "+
"           0,  "+
"           CEDULA,  "+
"           VALOR,  "+
"           count(*),  "+
"           SUBSTR (PRE.TITULO,1,4)  "+
"    FROM   sai.TBL_RESULTADOS RE,  "+
"           sai.TBL_H_PREGUNTAS PRE,  "+
"           sai.RCT_CLIENTES CLI,  "+
"           sai.TBL_H_CUESTIONARIOS HCU,  "+
"           sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP,  "+
"           sai.TBL_ENCUESTADO ENC,  "+
"           (SELECT   DISTINCT  "+
"                     (CLI.CLI_NUMDCTO),  "+
"                     RTA.IDRESULTADOS, "+
"                     ENC.IDCUESTIONARIOH, "+
"                     DECODE ( "+
"                        (LENGTH ( "+
"                            SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1) "+
"                         )), "+
"                        6, "+
"                        SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1), "+
"                        '' "+
"                     ) "+
"                        MATERIA, "+
"                     CPR.ORDEN, "+
"                     DECODE ( "+
"                        (LENGTH ( "+
"                            SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4) "+
"                         )), "+
"                        3, "+
"                        SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4), "+
"                        '' "+
"                     ) "+
"                        GRUPO "+
"              FROM   sai.RCT_CLIENTES CLI, "+
"                     sai.TBL_ENCUESTADO ENC, "+
"                     sai.TBL_RESULTADOS RTA, "+
"                     sai.TBL_H_CUESTIONARIOS CUE, "+
"                     sai.TBL_H_CUESTIONARIO_PREGUNTAS CPR, "+
"                     sai.TBL_H_PREGUNTAS PRE "+
"             WHERE       ENC.IDRESULTADOS = RTA.IDRESULTADOS "+
"                     AND RTA.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"                     AND RTA.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"                     AND CUE.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"                     AND PRE.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"                     AND CUE.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"                     AND ENC.CEDULA = CLI.CLI_NUMDCTO "+
"                     AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd')) "+ // 8 fecha inicio
"           DBAC "+
"   WHERE       ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"	where fecha_inicia >  to_date(?,'yyyy-mm-dd')  "+ // 9 fecha inicio
"	and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+ // 10 fecha fin
"           AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
"                            FROM   sai.TBL_DOCENTE_RELACION "+
"                           WHERE   ESTADO = 'ACT') "+
"           AND CLI.CLI_NUMDCTO = CEDULA "+
"           AND DBAC.CLI_NUMDCTO = CEDULA "+
"           AND DBAC.IDRESULTADOS = RE.IDRESULTADOS "+
"           AND DBAC.IDRESULTADOS = ENC.IDRESULTADOS "+
"           AND DBAC.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"           AND DBAC.IDCUESTIONARIOH = HCU.IDCUESTIONARIOH "+
"           AND DBAC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND DBAC.ORDEN = THCP.ORDEN "+
"           AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
"           AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"           AND RE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"           AND RE.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"           AND HCU.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"           AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"           AND ENC.FECHA >= TO_DATE (?, 'yyyy/mm/dd') "+ // 11 fecha inicio
" and (HCU.TITULO like '%AUTO%GEST%' or HCU.TITULO like '%AUTO%INV%') "+ 
" and (PRE.TITULO like '%Gest%' or PRE.TITULO like '%Inves%' ) "+
" group by  "+
"   HCU.TITULO, "+
"           CLI.CLI_TIPODCTO, "+
"           CEDULA, "+
"          'nn', "+
"           0, "+
"           VALOR, "+
"           SUBSTR (PRE.TITULO,1,4) "+
") parcial, "+
"(SELECT aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, '', '', '',0,aa1.cedula as cedula,sum(aa2.CONTEO) as total,SUBSTR (aa2.PREGUNTA,1,4) as saber FROM "+ 
"(SELECT AM.MAT_NOMBRE AS nombre_materia, "+
"       GRP.MAT_CODIGO AS codigo_materia, "+
"       GRP.GRU_CODIGO AS grupo, "+
"       GRP.GRU_CUPO_ASIGNADO AS inscritos, "+
"       GRP.CLI_NDCTO_PROF as cedula "+
"       FROM   SAI.ART_MATERIAS AM, "+
"       (select GRU_SEMESTRE,GRU_CODIGO, MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_HISTORIA_GRUPOS union select GRU_SEMESTRE, GRU_CODIGO,MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_GRUPOS_VIGENTES) GRP "+
"        WHERE       GRP.GRU_SEMESTRE = ? "+ // 12 semestre
"        AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "+
"        AND GRP.CLI_TIPODCTO <> 'OT' "+
"        AND GRP.CLI_TDCTO_PROF <> 'OT' "+
"        AND AM.MAT_CODIGO = GRP.MAT_CODIGO "+
"        ) aa1 left join "+
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
"where valor like ?) b "+ // 13 %semestre%
"where a.IDRESULTADOS =b.IDRESULTADOS "+
"and a.valor like '%||%' and a.valor not like ?) d "+ // 14 %semestre% 
"where c.IDRESULTADOS =d.z "+
") h "+
"where valor not like '%||%' "+
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
"group by aa2.TIPO_CUESTIONARIO,aa1.cedula, SUBSTR (aa2.PREGUNTA,1,4) "+
"union "+
"  select t, "+
"           '', "+
"           '', "+
"           'nn', "+
"           0, "+
"           codProf, "+
"           count(*), "+
"         saber "+
"from( "+
"SELECT   "+ 
"     distinct "+     
"         RTA.IDPREGUNTAH, "+
"           HCU.TITULO t, "+
"          DR.CLI_NUMDCTO as codProf, "+
"           'nn', "+
"           0, "+
"          RTA.VALOR RESPUESTA, "+
"           1, "+
"          SUBSTR (PRE.TITULO,1,4) as saber "+
"    FROM   sai.TBL_H_PREGUNTAS PRE, "+
"           sai.RCT_CLIENTES CLI, "+
"           sai.TBL_INSTANCIA_EVADOC DDOC, "+
"           sai.TBL_ENCUESTADO TE, "+
"           sai.TBL_H_CUESTIONARIOS HCU, "+
"           sai.TBL_DOCENTE_ROL TDRO,  "+
"           sai.TBL_RESULTADOS RTA, "+
"           sai.TBL_RESULTADOS_EVADOC RTADDOC, "+
"           (SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL "+
"              FROM   sai.TBL_DOCENTE_RELACION TDRE "+
"             WHERE   ID_DOCENTE_ROL IN "+
"                           (SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR "+
"   WHERE "+
"   HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"	where fecha_inicia >  to_date(?,'yyyy/mm/dd')  "+ // 15. fecha inicio
"	and fecha_inicia < to_date(?,'yyyy/mm/dd') and (titulo like '%INVEST%' or titulo like '%GEST%'))) "+ // 16 fecha fin
"             AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO "+
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
"           AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy/mm/dd') "+ // 17. fecha inicio
") zz "+
"group by "+
"t, "+
"           '', "+
"           'nn', "+
"           0, "+
"           codProf, "+
"           saber "+
"UNION "+
"SELECT     HCU.TITULO, "+
"           CLI.CLI_TIPODCTO, "+
"           '', "+
"           'nn', "+
"           0, "+
"           CEDULA, "+
"           count(*), "+
"           SUBSTR (PRE.TITULO,1,4) "+
"    FROM   sai.TBL_RESULTADOS RE, "+
"           sai.TBL_H_PREGUNTAS PRE, "+
"           sai.RCT_CLIENTES CLI, "+
"           sai.TBL_H_CUESTIONARIOS HCU, "+
"           sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP, "+
"           sai.TBL_ENCUESTADO ENC, "+
"           (SELECT   DISTINCT "+
"                     (CLI.CLI_NUMDCTO), "+
"                     RTA.IDRESULTADOS, "+
"                     ENC.IDCUESTIONARIOH, "+
"                     DECODE ( "+
"                        (LENGTH ( "+
"                            SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1) "+
"                         )), "+
"                        6, "+
"                        SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1), "+
"                        '' "+
"                     ) "+
"                        MATERIA, "+
"                     CPR.ORDEN, "+
"                     DECODE ( "+
"                        (LENGTH ( "+
"                            SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4) "+
"                         )), "+
"                        3, "+
"                        SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4), "+
"                        '' "+
"                     ) "+
"                        GRUPO "+
"              FROM   sai.RCT_CLIENTES CLI, "+
"                     sai.TBL_ENCUESTADO ENC, "+
"                     sai.TBL_RESULTADOS RTA, "+
"                     sai.TBL_H_CUESTIONARIOS CUE, "+
"                     sai.TBL_H_CUESTIONARIO_PREGUNTAS CPR, "+
"                     sai.TBL_H_PREGUNTAS PRE "+
"             WHERE       ENC.IDRESULTADOS = RTA.IDRESULTADOS "+
"                     AND RTA.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"                     AND RTA.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"                     AND CUE.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"                     AND PRE.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"                     AND CUE.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"                     AND ENC.CEDULA = CLI.CLI_NUMDCTO "+
"                     AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd')) "+ // 18 fecha inicio
"           DBAC "+
"   WHERE       ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"	where fecha_inicia >  to_date(?,'yyyy-mm-dd')  "+ // 19 fecha inicio
"	and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+ // 20 fecha fin
"           AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
"                            FROM   sai.TBL_DOCENTE_RELACION "+
"                           WHERE   ESTADO = 'ACT') "+
"           AND CLI.CLI_NUMDCTO = CEDULA "+
"           AND DBAC.CLI_NUMDCTO = CEDULA "+
"           AND DBAC.IDRESULTADOS = RE.IDRESULTADOS "+
"           AND DBAC.IDRESULTADOS = ENC.IDRESULTADOS "+
"           AND DBAC.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"           AND DBAC.IDCUESTIONARIOH = HCU.IDCUESTIONARIOH "+
"           AND DBAC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND DBAC.ORDEN = THCP.ORDEN "+
"           AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
"           AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"           AND RE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"           AND RE.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"           AND HCU.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"           AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"           AND ENC.FECHA >= TO_DATE (?, 'yyyy/mm/dd') "+ // 21. fecha inicio
"           and (HCU.TITULO like '%AUTO%GEST%' or HCU.TITULO like '%AUTO%INV%') "+ 
" and (PRE.TITULO like '%Gest%' or PRE.TITULO like '%Inves%' ) "+
" group by  "+
"   HCU.TITULO, "+
"           CLI.CLI_TIPODCTO, "+
"           CEDULA, "+
"          'nn', "+
"           0, "+
"           SUBSTR (PRE.TITULO,1,4) "+
" ) total "+
" where parcial.tipo_evaluacion=total.tipo_evaluacion and parcial.cedula=total.cedula and parcial.saber=total.saber "+
") niveles "+
"where facultades.codprof=niveles.cedula "+
"and codigo_facultad=? "+ // 22.codigo facultad
"group by "+
"codigo_facultad, nombre_facultad,  valor, saber,tipo_evaluacion  "+
"order by codigo_facultad, nombre_facultad, tipo_evaluacion, saber ";
/**
 * sql consulta evaluación por programa
 */
	final static String consultaPorPrograma="select codigo_programa, nombre_programa, avg(porcentaje) as porcentaje, valor, saber,tipo_evaluacion  "+
"	from "+
"	(SELECT  distinct "+ 
"	           p.pro_codprograma as codigo_programa, "+
"	           p.pro_nombreprog as nombre_programa, "+
"	           GRP.CLI_NDCTO_PROF as codprof "+
"	    FROM   (select GRU_SEMESTRE,GRU_CODIGO, MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_HISTORIA_GRUPOS union select GRU_SEMESTRE, GRU_CODIGO,MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_GRUPOS_VIGENTES) GRP , "+
"	         sai.art_materias_pensum m, sai.art_programas p, RCT_CLIENTES CLI "+
"	   WHERE   m.MAT_CODIGO=grp.MAT_CODIGO and m.PRO_CODPROGRAMA = p.PRO_CODPROGRAMA "+
"	           AND GRP.GRU_SEMESTRE = ? "+ // 1. semestre
"	           AND GRP.CLI_TDCTO_PROF = CLI.CLI_TIPODCTO "+
"	           AND GRP.CLI_NDCTO_PROF = CLI.CLI_NUMDCTO "+
"	           AND GRP.CLI_NDCTO_PROF <> '000000000000')  programas, "+
"	(select parcial.tipo_evaluacion as tipo_evaluacion, parcial.cedula as cedula, valor, 100*conteo/total.total as porcentaje "+
"	, parcial.saber as saber from "+
"	( "+
"	SELECT aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, '', '', '',0,aa1.cedula as cedula,aa2.VALOR as valor,sum(aa2.CONTEO) as conteo,SUBSTR (aa2.PREGUNTA,1,4) as saber FROM "+ 
"	(SELECT AM.MAT_NOMBRE AS nombre_materia, "+
"	       GRP.MAT_CODIGO AS codigo_materia, "+
"	       GRP.GRU_CODIGO AS grupo, "+
"	       GRP.GRU_CUPO_ASIGNADO AS inscritos, "+
"	       GRP.CLI_NDCTO_PROF as cedula "+
"	       FROM   SAI.ART_MATERIAS AM, "+
"	      (select GRU_SEMESTRE,GRU_CODIGO, MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_HISTORIA_GRUPOS union select GRU_SEMESTRE, GRU_CODIGO,MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_GRUPOS_VIGENTES) GRP "+
"	        WHERE       GRP.GRU_SEMESTRE = ? "+ // 2. semestre
"	        AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "+
"	        AND GRP.CLI_TIPODCTO <> 'OT' "+
"	        AND GRP.CLI_TDCTO_PROF <> 'OT' "+
"	        AND AM.MAT_CODIGO = GRP.MAT_CODIGO "+
"	        ) aa1 left join "+
"	(select MATERIA,VALOR, CONTEO,f.TITULO as pregunta,  G.TITULO AS TIPO_CUESTIONARIO, "+ 
"	SUBSTR (MATERIA, 1, INSTR (MATERIA, '|') - 1) as codigo_materia,  "+
"	SUBSTR (MATERIA, INSTR (MATERIA, '|',2) + 2, INSTR (MATERIA, '|',3) - 4) as grupo "+
"	from "+
"	(select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from "+
"	(SELECT * "+
"	from (select * "+
"	from sai.tbl_resultados) c, "+
"	(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from "+
"	(select * "+
"	from sai.tbl_resultados) a, "+
"	(select distinct IDRESULTADOS, valor "+
"	from sai.tbl_resultados "+
"	where valor like ?) b "+ // 3. %semestre%
"	where a.IDRESULTADOS =b.IDRESULTADOS "+
"	and a.valor like '%||%' and a.valor not like ?) d "+ // 4. %semestre%
"	where c.IDRESULTADOS =d.z "+
"	) h "+
"	where valor not like '%||%' "+
"	group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w, "+
"	sai.TBL_H_PREGUNTAS f, "+
"	sai.TBL_H_CUESTIONARIOS g "+
"	where "+
"	w.IDPREGUNTAH= f.IDPREGUNTAH "+
"	and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH "+
"	order by materia,pregunta "+
"	) aa2 "+
"	on aa1.codigo_materia=aa2.codigo_materia and aa1.grupo = aa2.grupo "+
"	where SUBSTR (aa2.PREGUNTA,1,4)='Rela' or SUBSTR (aa2.PREGUNTA,1,4) ='Peda' or SUBSTR (aa2.PREGUNTA,1,4)='Espe' "+
"	group by aa2.TIPO_CUESTIONARIO,aa1.cedula, aa2.VALOR,SUBSTR (aa2.PREGUNTA,1,4) "+
"	union "+
"	  select t, "+
"	           '', "+
"	           '', "+
"	           'nn', "+
"	           0, "+
"	           codProf, "+
"	           respuesta, "+
"	           count(*), "+
"	         saber "+
"	from( "+
"	SELECT   "+ 
"	     distinct "+     
"	         RTA.IDPREGUNTAH, "+
"	           HCU.TITULO t, "+
"	          DR.CLI_NUMDCTO as codProf, "+
"	           'nn', "+
"	           0, "+
"	          RTA.VALOR RESPUESTA, "+
"	           1, "+
"	           SUBSTR (PRE.TITULO,1,4) as saber "+
"	    FROM   sai.TBL_H_PREGUNTAS PRE, "+
"	           sai.RCT_CLIENTES CLI, "+
"	           sai.TBL_INSTANCIA_EVADOC DDOC, "+
"	           sai.TBL_ENCUESTADO TE, "+
"	           sai.TBL_H_CUESTIONARIOS HCU, "+
"	           sai.TBL_DOCENTE_ROL TDRO,  "+
"	           sai.TBL_RESULTADOS RTA, "+
"	           sai.TBL_RESULTADOS_EVADOC RTADDOC, "+
"	           (SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL "+
"	              FROM   sai.TBL_DOCENTE_RELACION TDRE "+
"	             WHERE   ID_DOCENTE_ROL IN "+
"	                           (SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR "+
"	   WHERE "+
"	   HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"		where fecha_inicia >  to_date(?,'yyyy/mm/dd') "+ //5. fecha inicio
"		and fecha_inicia < to_date(?,'yyyy/mm/dd') and (titulo like '%INVEST%' or titulo like '%GEST%'))) "+ //6 fecha fin
"	             AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO "+
"	           AND DR.CLI_NUMDCTO = DDOC.CODIGO_PROFESOR "+
"	           AND TDRO.ID_DOCENTE_ROL = DR.ID_DOCENTE_ROL "+
"	           AND HCU.IDCUESTIONARIOH = TE.IDCUESTIONARIOH "+
"	           AND RTA.IDRESULTADOS = TE.IDRESULTADOS "+
"	           AND TE.CEDULA = TDRO.CLI_NUMDCTO "+
"	           AND HCU.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
"	           AND HCU.IDCUESTIONARIOH = RTA.IDCUESTIONARIOH "+
"	           AND RTA.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
"	           AND RTA.IDRESULTADOS = RTADDOC.IDRESULTADO "+
"	           AND RTA.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"	           AND RTADDOC.IDINSTANCIA = DDOC.IDINSTANCIA "+
"	           AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy/mm/dd') "+ // 7. fecha inicio
"	) zz "+
"	group by "+
"	t, "+
"	           '', "+
"	           'nn', "+
"	           0, "+
"	           codProf, "+
"	           respuesta, "+
"	           saber "+
"	  UNION "+
"	SELECT     HCU.TITULO, "+
"	           CLI.CLI_TIPODCTO, "+
"	           '', "+
"	           'nn', "+
"	           0, "+
"	           CEDULA, "+
"	           VALOR, "+
"	           count(*), "+
"	           SUBSTR (PRE.TITULO,1,4) "+
"	    FROM   sai.TBL_RESULTADOS RE, "+
"	           sai.TBL_H_PREGUNTAS PRE, "+
"	           sai.RCT_CLIENTES CLI, "+
"	           sai.TBL_H_CUESTIONARIOS HCU, "+
"	           sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP, "+
"	           sai.TBL_ENCUESTADO ENC, "+
"	           (SELECT   DISTINCT "+
"	                     (CLI.CLI_NUMDCTO), "+
"	                     RTA.IDRESULTADOS, "+
"	                     ENC.IDCUESTIONARIOH, "+
"	                     DECODE ( "+
"	                        (LENGTH ( "+
"	                            SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1) "+
"	                         )), "+
"	                        6, "+
"	                        SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1), "+
"	                        '' "+
"	                     ) "+
"	                        MATERIA, "+
"	                     CPR.ORDEN, "+
"	                     DECODE ( "+
"	                        (LENGTH ( "+
"	                            SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4) "+
"	                         )), "+
"	                        3, "+
"	                        SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4), "+
"	                        '' "+
"	                     ) "+
"	                        GRUPO "+
"	              FROM   sai.RCT_CLIENTES CLI, "+
"	                     sai.TBL_ENCUESTADO ENC, "+
"	                     sai.TBL_RESULTADOS RTA, "+
"	                     sai.TBL_H_CUESTIONARIOS CUE, "+
"	                     sai.TBL_H_CUESTIONARIO_PREGUNTAS CPR, "+
"	                     sai.TBL_H_PREGUNTAS PRE "+
"	             WHERE       ENC.IDRESULTADOS = RTA.IDRESULTADOS "+
"	                     AND RTA.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"	                     AND RTA.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"	                     AND CUE.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"	                     AND PRE.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"	                     AND CUE.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"	                     AND ENC.CEDULA = CLI.CLI_NUMDCTO "+
"	                     AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd')) "+ // 8. fecha inicio
"	           DBAC "+
"	   WHERE       ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"		where fecha_inicia >  to_date(?,'yyyy-mm-dd') "+  // 9. fecha inicio
"		and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+ // 10.  fecha fin
"	           AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
"	                            FROM   sai.TBL_DOCENTE_RELACION "+
"	                           WHERE   ESTADO = 'ACT') "+
"	           AND CLI.CLI_NUMDCTO = CEDULA "+
"	           AND DBAC.CLI_NUMDCTO = CEDULA "+
"	           AND DBAC.IDRESULTADOS = RE.IDRESULTADOS "+
"	           AND DBAC.IDRESULTADOS = ENC.IDRESULTADOS "+
"	           AND DBAC.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"	           AND DBAC.IDCUESTIONARIOH = HCU.IDCUESTIONARIOH "+
"	           AND DBAC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"	           AND DBAC.ORDEN = THCP.ORDEN "+
"	           AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
"	           AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"	           AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"	           AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"	           AND RE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"	           AND RE.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"	           AND HCU.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"	           AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"	           AND ENC.FECHA >= TO_DATE (?, 'yyyy/mm/dd') "+ // 11. fecha inicio
" and (HCU.TITULO like '%AUTO%GEST%' or HCU.TITULO like '%AUTO%INV%') "+ 
"	 and (PRE.TITULO like '%Gest%' or PRE.TITULO like '%Inves%' ) "+
"	 group by "+ 
"	   HCU.TITULO, "+
"	           CLI.CLI_TIPODCTO, "+
"	           CEDULA, "+
"	          'nn', "+
"	           0, "+
"	           VALOR, "+
"	           SUBSTR (PRE.TITULO,1,4) "+
"	) parcial, "+
"	(SELECT aa2.TIPO_CUESTIONARIO AS tipo_evaluacion, '', '', '',0,aa1.cedula as cedula,sum(aa2.CONTEO) as total,SUBSTR (aa2.PREGUNTA,1,4) as saber FROM "+ 
"	(SELECT AM.MAT_NOMBRE AS nombre_materia, "+
"	       GRP.MAT_CODIGO AS codigo_materia, "+
"	       GRP.GRU_CODIGO AS grupo, "+
"	       GRP.GRU_CUPO_ASIGNADO AS inscritos, "+
"	       GRP.CLI_NDCTO_PROF as cedula "+
"	       FROM   SAI.ART_MATERIAS AM, "+
"	       (select GRU_SEMESTRE,GRU_CODIGO, MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_HISTORIA_GRUPOS union select GRU_SEMESTRE, GRU_CODIGO,MAT_CODIGO, GRU_CUPO_ASIGNADO, CLI_NDCTO_PROF,CLI_TIPODCTO,CLI_TDCTO_PROF from SAI.ART_GRUPOS_VIGENTES) GRP "+
"	        WHERE       GRP.GRU_SEMESTRE = ? "+ // 12 semestre
"	        AND AM.MAT_SEMESTRE = GRP.GRU_SEMESTRE "+
"	        AND GRP.CLI_TIPODCTO <> 'OT' "+
"	        AND GRP.CLI_TDCTO_PROF <> 'OT' "+
"	        AND AM.MAT_CODIGO = GRP.MAT_CODIGO "+
"	        ) aa1 left join "+
"	(select MATERIA,VALOR, CONTEO,f.TITULO as pregunta,  G.TITULO AS TIPO_CUESTIONARIO, "+ 
"	SUBSTR (MATERIA, 1, INSTR (MATERIA, '|') - 1) as codigo_materia, "+ 
"	SUBSTR (MATERIA, INSTR (MATERIA, '|',2) + 2, INSTR (MATERIA, '|',3) - 4) as grupo "+
"	from "+
"	(select IDCUESTIONARIOH,IDPREGUNTAH,materia, valor, count(*) as conteo from "+
"	(SELECT * "+
"	from (select * "+
"	from sai.tbl_resultados) c, "+
"	(select a.IDRESULTADOS as z, a.valor as profesor , b.valor as materia from "+
"	(select * "+
"	from sai.tbl_resultados) a, "+
"	(select distinct IDRESULTADOS, valor "+
"	from sai.tbl_resultados "+
"	where valor like ?) b "+ //13. %semestre%
"	where a.IDRESULTADOS =b.IDRESULTADOS "+
"	and a.valor like '%||%' and a.valor not like ?) d "+ //14. %semestre%
"	where c.IDRESULTADOS =d.z "+
"	) h "+
"	where valor not like '%||%' "+
"	group by materia, IDCUESTIONARIOH,  IDPREGUNTAH, valor) w, "+
"	sai.TBL_H_PREGUNTAS f, "+
"	sai.TBL_H_CUESTIONARIOS g "+
"	where "+
"	w.IDPREGUNTAH= f.IDPREGUNTAH "+
"	and w.IDCUESTIONARIOH=g.IDCUESTIONARIOH "+
"	order by materia,pregunta "+
"	) aa2 "+
"	on aa1.codigo_materia=aa2.codigo_materia and aa1.grupo = aa2.grupo "+
"	where SUBSTR (aa2.PREGUNTA,1,4)='Rela' or SUBSTR (aa2.PREGUNTA,1,4) ='Peda' or SUBSTR (aa2.PREGUNTA,1,4)='Espe' "+
"	group by aa2.TIPO_CUESTIONARIO,aa1.cedula, SUBSTR (aa2.PREGUNTA,1,4) "+
"	union "+
"	  select t, "+
"	           '', "+
"	           '', "+
"	           'nn', "+
"	           0, "+
"	           codProf, "+
"	           count(*), "+
"	         saber "+
"	from( "+
"	SELECT "+   
"	     distinct "+     
"	         RTA.IDPREGUNTAH, "+
"	           HCU.TITULO t, "+
"	          DR.CLI_NUMDCTO as codProf, "+
"	           'nn', "+
"	           0, "+
"	          RTA.VALOR RESPUESTA, "+
"	           1, "+
"	           SUBSTR (PRE.TITULO,1,4) as saber "+
"	    FROM   sai.TBL_H_PREGUNTAS PRE, "+
"	           sai.RCT_CLIENTES CLI, "+
"	           sai.TBL_INSTANCIA_EVADOC DDOC, "+
"	           sai.TBL_ENCUESTADO TE, "+
"	           sai.TBL_H_CUESTIONARIOS HCU, "+
"	           sai.TBL_DOCENTE_ROL TDRO,       "+
"	           sai.TBL_RESULTADOS RTA, "+
"	           sai.TBL_RESULTADOS_EVADOC RTADDOC, "+
"	           (SELECT   CLI_NUMDCTO, ID_DOCENTE_ROL "+
"	              FROM   sai.TBL_DOCENTE_RELACION TDRE "+
"	             WHERE   ID_DOCENTE_ROL IN "+
"	                           (SELECT   ID_DOCENTE_ROL FROM sai.TBL_DOCENTE_ROL)) DR "+
"	   WHERE "+
"	   HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"		where fecha_inicia >  to_date(?,'yyyy/mm/dd')  "+ // 15 fecha inicio
"		and fecha_inicia < to_date(?,'yyyy/mm/dd') and (titulo like '%INVEST%' or titulo like '%GEST%'))) "+ // 16. fecha fin
"	             AND TDRO.CLI_NUMDCTO = CLI.CLI_NUMDCTO "+
"	           AND DR.CLI_NUMDCTO = DDOC.CODIGO_PROFESOR "+
"	           AND TDRO.ID_DOCENTE_ROL = DR.ID_DOCENTE_ROL "+
"	           AND HCU.IDCUESTIONARIOH = TE.IDCUESTIONARIOH "+
"	           AND RTA.IDRESULTADOS = TE.IDRESULTADOS "+
"	           AND TE.CEDULA = TDRO.CLI_NUMDCTO "+
"	           AND HCU.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
"	           AND HCU.IDCUESTIONARIOH = RTA.IDCUESTIONARIOH "+
"	           AND RTA.IDCUESTIONARIOH = DDOC.IDCUESTIONARIOH "+
"	           AND RTA.IDRESULTADOS = RTADDOC.IDRESULTADO "+
"	           AND RTA.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"	           AND RTADDOC.IDINSTANCIA = DDOC.IDINSTANCIA "+
"	           AND HCU.FECHA_INICIA > TO_DATE (?, 'yyyy/mm/dd') "+ // 17. fecha inicio
"	) zz "+
"	group by "+
"	t, "+
"	           '', "+
"	           'nn', "+
"	           0, "+
"	           codProf, "+
"	           saber "+
"	UNION "+
"	SELECT     HCU.TITULO, "+
"	           CLI.CLI_TIPODCTO, "+
"	           '', "+
"	           'nn', "+
"	           0, "+
"	           CEDULA, "+
"	           count(*), "+
"	           SUBSTR (PRE.TITULO,1,4) "+
"	    FROM   sai.TBL_RESULTADOS RE, "+
"	           sai.TBL_H_PREGUNTAS PRE, "+
"	           sai.RCT_CLIENTES CLI, "+
"	           sai.TBL_H_CUESTIONARIOS HCU, "+
"	           sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP, "+
"	           sai.TBL_ENCUESTADO ENC, "+
"	           (SELECT   DISTINCT "+
"	                     (CLI.CLI_NUMDCTO), "+
"	                     RTA.IDRESULTADOS, "+
"	                     ENC.IDCUESTIONARIOH, "+
"	                     DECODE ( "+
"	                        (LENGTH ( "+
"	                            SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1) "+
"	                         )), "+
"	                        6, "+
"	                        SUBSTR (RTA.VALOR, 1, INSTR (RTA.VALOR, '|') - 1), "+
"	                        '' "+
"	                     ) "+
"	                        MATERIA, "+
"	                     CPR.ORDEN, "+
"	                     DECODE ( "+
"	                        (LENGTH ( "+
"	                            SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4) "+
"	                         )), "+
"	                        3, "+
"	                        SUBSTR (RTA.VALOR, 9, INSTR (RTA.VALOR, '|') - 4), "+
"	                        '' "+
"	                     ) "+
"	                        GRUPO "+
"	              FROM   sai.RCT_CLIENTES CLI, "+
"	                     sai.TBL_ENCUESTADO ENC, "+
"	                     sai.TBL_RESULTADOS RTA, "+
"	                     sai.TBL_H_CUESTIONARIOS CUE, "+
"	                     sai.TBL_H_CUESTIONARIO_PREGUNTAS CPR, "+
"	                     sai.TBL_H_PREGUNTAS PRE "+
"	             WHERE       ENC.IDRESULTADOS = RTA.IDRESULTADOS "+
"	                     AND RTA.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"	                     AND RTA.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"	                     AND CUE.IDCUESTIONARIOH = CPR.IDCUESTIONARIOH "+
"	                     AND PRE.IDPREGUNTAH = CPR.IDPREGUNTAH "+
"	                     AND CUE.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"	                     AND ENC.CEDULA = CLI.CLI_NUMDCTO "+
"	                     AND ENC.FECHA >= TO_DATE (?, 'yyyy-mm-dd')) "+ // 18. fecha inicio
"	           DBAC "+
"	   WHERE       ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"		where fecha_inicia >  to_date(?,'yyyy-mm-dd')  "+ // 19. fecha inicio
"		and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+ // 20. fecha fin
"	           AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
"	                            FROM   sai.TBL_DOCENTE_RELACION "+
"	                           WHERE   ESTADO = 'ACT') "+
"	           AND CLI.CLI_NUMDCTO = CEDULA "+
"	           AND DBAC.CLI_NUMDCTO = CEDULA "+
"	           AND DBAC.IDRESULTADOS = RE.IDRESULTADOS "+
"	           AND DBAC.IDRESULTADOS = ENC.IDRESULTADOS "+
"	           AND DBAC.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"	           AND DBAC.IDCUESTIONARIOH = HCU.IDCUESTIONARIOH "+
"	           AND DBAC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"	           AND DBAC.ORDEN = THCP.ORDEN "+
"	           AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
"	           AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"	           AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"	           AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"	           AND RE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"	           AND RE.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"	           AND HCU.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"	           AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"	           AND ENC.FECHA >= TO_DATE (?, 'yyyy/mm/dd') "+  // 21 fecha inicio
"	           and (HCU.TITULO like '%AUTO%GEST%' or HCU.TITULO like '%AUTO%INV%') "+ 
"	 and (PRE.TITULO like '%Gest%' or PRE.TITULO like '%Inves%' ) "+
"	 group by "+ 
"	   HCU.TITULO, "+
"	           CLI.CLI_TIPODCTO, "+
"	           CEDULA, "+
"	          'nn', "+
"	           0, "+
"	           SUBSTR (PRE.TITULO,1,4) "+
"	) total "+
"	where parcial.tipo_evaluacion=total.tipo_evaluacion and parcial.cedula=total.cedula and parcial.saber=total.saber "+
"	) niveles "+
"	where programas.codprof=niveles.cedula "+
" and codigo_programa=? "+
"	group by "+
"	codigo_programa, nombre_programa,  valor, saber,tipo_evaluacion "+
" order by codigo_programa, nombre_programa, tipo_evaluacion, saber";
	/**
	 * Método que devuelve un modelo con el informe por facultad.
	 * @param codigoFacultad String código de la facultad a revisar
	 * @param semestre String semestre a revisar. Por ej. 20132.
	 * @return objeto de tipo Evaluacion con el informe de la facultad.
	 */
	public static Evaluacion
	getInformeFacultad(String codigoFacultad, String semestre)
	{
		 EvaluacionPrograma evaluacion = new EvaluacionPrograma();
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
		String fechaContrato = Periodo.getFechaContrato(semestre);
		
		 try {
				p = con.prepareStatement(consultaPorFacultad);
				p.setString(1, fechaContrato);
				p.setString(2, fechaContrato);
				p.setString(3, fechaContrato);
				p.setString(4, fechaContrato);
				p.setString(5, semestre);
				p.setString(6, "%%"+semestre+"%%");
				p.setString(7, "%%"+semestre+"%%");
				p.setString(8, periodo[Periodo.FECHAINICIO]);
				p.setString(9, periodo[Periodo.FECHAFIN]);
				p.setString(10, periodo[Periodo.FECHAINICIO]);
				p.setString(11, periodo[Periodo.FECHAINICIO]);
				p.setString(12, periodo[Periodo.FECHAINICIO]);
				p.setString(13, periodo[Periodo.FECHAFIN]);
				p.setString(14, periodo[Periodo.FECHAINICIO]);
				p.setString(15, semestre);
				p.setString(16, "%%"+semestre+"%%");
				p.setString(17, "%%"+semestre+"%%");
				p.setString(18, periodo[Periodo.FECHAINICIO]);
				p.setString(19, periodo[Periodo.FECHAFIN]);
				p.setString(20, periodo[Periodo.FECHAINICIO]);
				p.setString(21, periodo[Periodo.FECHAINICIO]);
				p.setString(22, periodo[Periodo.FECHAINICIO]);
				p.setString(23, periodo[Periodo.FECHAFIN]);
				p.setString(24, periodo[Periodo.FECHAINICIO]);
				p.setString(25, codigoFacultad);
				
				ResultSet rs=p.executeQuery();
				int saber = 0;
				String codPrograma="";
		
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
					
					ev.getPromedioRespuestas()[saber][rs.getInt("valor")-1]=rs.getInt("porcentaje");
					
					}
					
					
				}
				
				if(rs.getString("saber").equals("Gest"))
				{
				
					if(rs.getString("tipo_evaluacion").contains("AUTO"))
					{	
					autoEvaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
							
					}
					else
					{	
					evaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
					
					}
					
				}
				if(rs.getString("saber").equals("Inve"))
				{	if(rs.getString("tipo_evaluacion").contains("AUTO"))
					{
					autoEvaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
					
					}
					else
					{	
					evaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
					
					}
				}
				}
				con.close();	
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Excepcion : "+e.getMessage());
				System.out.println(e.getLocalizedMessage());
			
			}
		 
		 if(evaluacionMaterias.size()==0) evaluacionMaterias.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("","","", 0),false));
		 if(evaluacionMaterias.size()>=1) evaluacionMaterias.add(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,new Materia("","","", 0),false));
			

		
	
		 return new Evaluacion(evaluacionMaterias, evaluacionGestion, evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion);

		
		
	}

/**
 * Método que devuelve un modelo con el informe por facultad. 
 * @param codigoPrograma String código del programa a revisar.
 * @param semestre String semestre a revisar. Por ej. 20132
 * @return objeto de tipo Evaluación con el informe del programa.
 */

public static Evaluacion
getInformePrograma(String codigoPrograma, String semestre)
{
	 EvaluacionPrograma evaluacion = new EvaluacionPrograma();
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
			p = con.prepareStatement(consultaPorPrograma);
			p.setString(1, semestre);
			p.setString(2, semestre);
			p.setString(3, "%%"+semestre+"%%");
			p.setString(4, "%%"+semestre+"%%");
			p.setString(5, periodo[Periodo.FECHAINICIO]);
			p.setString(6, periodo[Periodo.FECHAFIN]);
			p.setString(7, periodo[Periodo.FECHAINICIO]);
			p.setString(8, periodo[Periodo.FECHAINICIO]);
			p.setString(9, periodo[Periodo.FECHAINICIO]);
			p.setString(10, periodo[Periodo.FECHAFIN]);
			p.setString(11, periodo[Periodo.FECHAINICIO]);
			p.setString(12, semestre);
			p.setString(13, "%%"+semestre+"%%");
			p.setString(14, "%%"+semestre+"%%");
			p.setString(15, periodo[Periodo.FECHAINICIO]);
			p.setString(16, periodo[Periodo.FECHAFIN]);
			p.setString(17, periodo[Periodo.FECHAINICIO]);
			p.setString(18, periodo[Periodo.FECHAINICIO]);
			p.setString(19, periodo[Periodo.FECHAINICIO]);
			p.setString(20, periodo[Periodo.FECHAFIN]);
			p.setString(21, periodo[Periodo.FECHAINICIO]);
			p.setString(22, codigoPrograma);
			
			ResultSet rs=p.executeQuery();
			int saber = 0;
			String codPrograma="";
	
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
				
				ev.getPromedioRespuestas()[saber][rs.getInt("valor")-1]=rs.getInt("porcentaje");
				
				}
				
				
			}
			
			if(rs.getString("saber").equals("Gest"))
			{
			
				if(rs.getString("tipo_evaluacion").contains("AUTO"))
				{	
				autoEvaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
						
				}
				else
				{	
				evaluacionGestion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
				
				}
				
			}
			if(rs.getString("saber").equals("Inve"))
			{	if(rs.getString("tipo_evaluacion").contains("AUTO"))
				{
				autoEvaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
				
				}
				else
				{	
				evaluacionInvestigacion.getPromedioRespuestas()[rs.getInt("valor")-1]=rs.getInt("porcentaje");
				
				}
			}
			}
			con.close();	
	 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		
		}
	 
	 if(evaluacionMaterias.size()==0) evaluacionMaterias.add(new EvaluacionMateria(EvaluacionMateria.EVALUACION,new Materia("","","", 0),false));
	 if(evaluacionMaterias.size()>=1) evaluacionMaterias.add(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,new Materia("","","", 0),false));
		

	

	 return new Evaluacion(evaluacionMaterias, evaluacionGestion, evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion);

	
	
}
/**
 * Método que devuelve un arreglo con el mejor y peor saber en el campo de la docencia en 
 * la evaluación de un programa o facultad
 * @param evaluaciones ArrayList con la evaluación en el campo de la docencia
 * @return ArrayList de tipo SaberNivel con el peor y el mejor Saber.
 */
public static ArrayList<SaberNivel> getMejorPeorCampoDocencia(List<EvaluacionMateria> evaluaciones)
{
	String saber []={"PEDAGOGICO","ESPECIFICO","RELACIONAL"};
	ArrayList<SaberNivel> maximos = new ArrayList<SaberNivel>();
	ArrayList<SaberNivel> mejorPeor = new ArrayList<SaberNivel>();
	SaberNivel mejor, peor;
	double resultado=0;
	
	for(int i=0;i<3;i++)
	{
		maximos.add(new SaberNivel(saber[i]));
		for(int j=0;j<5;j++)
		{	
			resultado = evaluaciones.get(0).getPromedioRespuestas()[i][j] *0.8 + evaluaciones.get(1).getPromedioRespuestas()[i][j]*0.2;
			if(resultado>maximos.get(i).promedio)
			{	
			 maximos.get(i).promedio = resultado;
			 maximos.get(i).nivel=j;
			 
			}
		}
	}
	mejor = maximos.get(0);
	peor = maximos.get(0);
	for(int i=1;i<3;i++)
	{
			if(maximos.get(i).nivel>mejor.nivel)
			{
				mejor = maximos.get(i);
			}
			else
			{
				if(maximos.get(i).nivel==mejor.nivel && maximos.get(i).promedio>mejor.promedio)
				{
					mejor = maximos.get(i);
				}
			}
			if(maximos.get(i).nivel<peor.nivel)
			{
				peor = maximos.get(i);
			}
			else
			{
				if(maximos.get(i).nivel==peor.nivel && maximos.get(i).promedio<peor.promedio)
				{
					peor = maximos.get(i);
				}
			}
			
		
	}
	mejorPeor.add(mejor);
	mejorPeor.add(peor);
	return mejorPeor;
}


}
