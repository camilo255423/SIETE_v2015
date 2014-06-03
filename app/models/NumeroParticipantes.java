package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;
/**
 * Modelo que representa el número de participantes por cada Faculta en los 
 * campos de la Docencia, la Gestión y la Investigación.
 * @author Camilo Rodríguez
 *
 */
public class NumeroParticipantes {
	/**
	 * Arreglo con Lista de facultades con el número de estudiantes
	 * que evaluaron a los docentes.
	 */
	ArrayList<Facultad> estudiantesEvaluadosPorFacultad;
	/**
	 * Arreglo con Lista de facultades con el número de docentes evaluados
	 */
	ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad;
/**
* Arreglo con Lista de facultades con el número de Docentes
*  que realizaron la autoevaluación.
*/
	ArrayList<Facultad> docentesConAutoevaluacionPorFacultad;
/**
* Arreglo con Lista de facultades con el número de directivos
* que evaluaron gestión.
 */
	ArrayList<Facultad> directivosGestionEvaluadosPorFacultad;
	/**
	* Arreglo con Lista de facultades con el número de directivos
	* que evaluaron Investigación.
	 */
	ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad;
	/**
	 * Constructos
	 * @param estudiantesEvaluadosPorFacultad
	 * @param docentesEvaluadosPorEstudiantesPorFacultad
	 * @param docentesConAutoevaluacionPorFacultad
	 * @param directivosGestionEvaluadosPorFacultad
	 * @param directivosInvestigacionEvaluadosPorFacultad
	 */
	public NumeroParticipantes(
			ArrayList<Facultad> estudiantesEvaluadosPorFacultad,
			ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad,
			ArrayList<Facultad> docentesConAutoevaluacionPorFacultad,
			ArrayList<Facultad> directivosGestionEvaluadosPorFacultad,
			ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad) {
		super();
		this.estudiantesEvaluadosPorFacultad = estudiantesEvaluadosPorFacultad;
		this.docentesEvaluadosPorEstudiantesPorFacultad = docentesEvaluadosPorEstudiantesPorFacultad;
		this.docentesConAutoevaluacionPorFacultad = docentesConAutoevaluacionPorFacultad;
		this.directivosGestionEvaluadosPorFacultad = directivosGestionEvaluadosPorFacultad;
		this.directivosInvestigacionEvaluadosPorFacultad = directivosInvestigacionEvaluadosPorFacultad;
	}
	/**
	 * Método que devuelve un objeto NumeroParticipantes con los datos de participación 
	 * según el semestre
	 * @param semestre String
	 * @return objeto NumeroParticipantes
	 */
	public static NumeroParticipantes findBySemestre(String semestre)
	{
		ArrayList<Facultad> estudiantesEvaluadosPorFacultad=null;
		ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad=null;
		ArrayList<Facultad> docentesConAutoevaluacionPorFacultad=null;
		ArrayList<Facultad> directivosGestionEvaluadosPorFacultad=null;
		ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad=null;
		Connection con = DB.getConnection();
		PreparedStatement p;
		
		String periodo[] = Periodo.getFecha(semestre);
		String fechaContrato = Periodo.getFechaContrato(semestre);
			try {
				p = con.prepareStatement(NumeroParticipantes.consultaEstudiantesEvaluadosPorFacultad);
				p.setString(1, semestre);
				p.setString(2, semestre);
				p.setString(3, periodo[Periodo.FECHAINICIO]);
				p.setString(4, periodo[Periodo.FECHAFIN]);
				estudiantesEvaluadosPorFacultad = NumeroParticipantes.consultarParticipantes(p); 
				
				p = con.prepareStatement(NumeroParticipantes.consultaDocentesEvaluadosPorEstudiantesPorFacultad);
				p.setString(1, fechaContrato);
				p.setString(2, fechaContrato);
				p.setString(3, fechaContrato);
				p.setString(4, fechaContrato);
				p.setString(5, fechaContrato);
				p.setString(6, fechaContrato);
				p.setString(7, fechaContrato);
				p.setString(8, fechaContrato);
				p.setString(9, periodo[Periodo.FECHAINICIO]);
				p.setString(10, periodo[Periodo.FECHAFIN]);
				docentesEvaluadosPorEstudiantesPorFacultad = NumeroParticipantes.consultarParticipantes(p);
				
				p = con.prepareStatement(NumeroParticipantes.consultaDocentesConAutoevaluacionPorFacultad);
				p.setString(1, fechaContrato);
				p.setString(2, fechaContrato);
				p.setString(3, fechaContrato);
				p.setString(4, fechaContrato);
				p.setString(5, fechaContrato);
				p.setString(6, fechaContrato);
				p.setString(7, fechaContrato);
				p.setString(8, fechaContrato);
				p.setString(9, periodo[Periodo.FECHAINICIO]);
				p.setString(10, periodo[Periodo.FECHAFIN]);
				p.setString(11, semestre);
				p.setString(12, periodo[Periodo.FECHAINICIO]);
				docentesConAutoevaluacionPorFacultad = NumeroParticipantes.consultarParticipantes(p);

				
				p = con.prepareStatement(NumeroParticipantes.consultaDirectivosGestionEvaluadosPorFacultad);
			
				p.setString(1, periodo[Periodo.FECHAINICIO]);
				p.setString(2, periodo[Periodo.FECHAFIN]);
				directivosGestionEvaluadosPorFacultad = NumeroParticipantes.consultarParticipantes(p);
				
				p = con.prepareStatement(NumeroParticipantes.consultaDirectivosInvestigacionEvaluadosPorFacultad);
				p.setString(1, periodo[Periodo.FECHAINICIO]);
				p.setString(2, periodo[Periodo.FECHAFIN]);
				directivosInvestigacionEvaluadosPorFacultad = NumeroParticipantes.consultarParticipantes(p);
				con.close();		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return new NumeroParticipantes(estudiantesEvaluadosPorFacultad, docentesEvaluadosPorEstudiantesPorFacultad, docentesConAutoevaluacionPorFacultad, directivosGestionEvaluadosPorFacultad, directivosInvestigacionEvaluadosPorFacultad);
	}
	/**
	 * Método que genera el respectivo modelo de participantes:
	 * estudiantes, docentes, gestión , investigación.
	 * @param p PreparedStatment con la respectiva consulta
	 * @return ArrayList<Facultad>  con el número de participantes
	 */
	private static ArrayList<Facultad> consultarParticipantes(PreparedStatement p)
	{
		
		ArrayList<Facultad> facultades = new ArrayList<Facultad>();
		
		try {
				ResultSet rs=p.executeQuery();
			while (rs.next()) {
				facultades.add(new Facultad(rs.getString("IDFACULTAD"),
						rs.getString("FACULTAD"),rs.getInt("PARTICIPANTES"),
						rs.getInt("TOTAL"),rs.getDouble("PORCENTAJE")));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Excepcion : "+e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return facultades;
	}
	/**
	 * 
	 * @return  ArrayList<Facultad> Estudiantes evaluados por facultad
	 */
	public ArrayList<Facultad> getEstudiantesEvaluadosPorFacultad() {
		return estudiantesEvaluadosPorFacultad;
	}
	/**
	 * 
	 * @param estudiantesEvaluadosPorFacultad Estudiantes evaluados por facultad
	 */
	public void setEstudiantesEvaluadosPorFacultad(
			ArrayList<Facultad> estudiantesEvaluadosPorFacultad) {
		this.estudiantesEvaluadosPorFacultad = estudiantesEvaluadosPorFacultad;
	}
	/**
	 * 
	 * @return ArrayList<Facultad> Docentes evaluados por estudiantes por cada facultad
	 */
	public ArrayList<Facultad> getDocentesEvaluadosPorEstudiantesPorFacultad() {
		return docentesEvaluadosPorEstudiantesPorFacultad;
	}
	/**
	 * 
	 * @param docentesEvaluadosPorEstudiantesPorFacultad Docentes evaluados por estudiantes por cada facultad
	 */
	public void setDocentesEvaluadosPorEstudiantesPorFacultad(
			ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad) {
		this.docentesEvaluadosPorEstudiantesPorFacultad = docentesEvaluadosPorEstudiantesPorFacultad;
	}
	/**
	 * 
	 * @return ArrayList<Facultad> Docentes con autoevaluación por cada facultad.
	 */
	public ArrayList<Facultad> getDocentesConAutoevaluacionPorFacultad() {
		return docentesConAutoevaluacionPorFacultad;
	}
	/**
	 * 
	 * @param docentesConAutoevaluacionPorFacultad Docentes con autoevaluación por cada facultad.
	 */
	public void setDocentesConAutoevaluacionPorFacultad(
			ArrayList<Facultad> docentesConAutoevaluacionPorFacultad) {
		this.docentesConAutoevaluacionPorFacultad = docentesConAutoevaluacionPorFacultad;
	}
	/**
	 * 
	 * @return ArrayList<Facultad> directivos que evaluaron gestión por cada facultad.
	 */
	public ArrayList<Facultad> getDirectivosGestionEvaluadosPorFacultad() {
		return directivosGestionEvaluadosPorFacultad;
	}
	/**
	 * 
	 * @param directivosGestionEvaluadosPorFacultad directivos que evaluaron gestión por cada facultad.
	 */
	public void setDirectivosGestionEvaluadosPorFacultad(
			ArrayList<Facultad> directivosGestionEvaluadosPorFacultad) {
		this.directivosGestionEvaluadosPorFacultad = directivosGestionEvaluadosPorFacultad;
	}
	/**
	 * 
	 * @return ArrayList<Facultad> Directivos que evaluaron investigación por facultad.
	 */
	public ArrayList<Facultad> getDirectivosInvestigacionEvaluadosPorFacultad() {
		return directivosInvestigacionEvaluadosPorFacultad;
	}
	
	public void setDirectivosInvestigacionEvaluadosPorFacultad(
			ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad) {
		this.directivosInvestigacionEvaluadosPorFacultad = directivosInvestigacionEvaluadosPorFacultad;
	}
	/**
	 * Consulta de número de estudiantes que evaluaron por facultad
	 */
	private static final String consultaEstudiantesEvaluadosPorFacultad ="select a.id_facultad as idFacultad, a.facultad as facultad, inscritos as total, encuestados as participantes, 100*encuestados/inscritos as porcentaje from "+
"(select id_facultad,facultad,count(*) as inscritos from ( "+
"SELECT     distinct FAC.ID_DECAN as id_facultad, "+
"           FAC.DESCRIP as  facultad, "+
"           EST.CLI_NUMDCTO "+
"    FROM   sai.ART_ESTUDIANTES EST, "+
"           sai.RCT_CLIENTES CLI, "+
"           sai.ART_PROGRAMAS PGM, "+
"           sai.SCT_DECAN FAC, "+
"           sai.ART_LIQUIDACION_ENC LIQ "+
"   WHERE       CLI.CLI_TIPODCTO = EST.CLI_TIPODCTO "+
"           AND CLI.CLI_NUMDCTO = EST.CLI_NUMDCTO "+
"           AND SUBSTR (EST.EST_CODIGO, 10, 3) = PGM.PRO_CODPROGRAMA "+
"           AND PGM.PRO_ID_DECAN = FAC.ID_DECAN "+
"           AND EST.EST_CODIGO = LIQ.EST_CODIGO "+
"           AND LIQ.PRO_CODIGO = '1' "+
"           AND LIQ.LIQ_SEMESTRE = ? "+
"           AND FAC.ID_DECAN <> 12 "+
"           AND LIQ.LIQ_VALOR > 0 "+
"           AND LIQ.LIQ_ESTADO = 'PAG' "+
") p "+
"group by "+ 
"id_facultad, "+
"facultad) a, "+
"( "+
"select id_facultad,facultad,count(*) as encuestados from ( "+
"SELECT     distinct FAC.ID_DECAN as id_facultad, "+
"           FAC.DESCRIP as  facultad, "+
"           EST.CLI_NUMDCTO "+
"    FROM   sai.ART_ESTUDIANTES EST, "+
"           sai.RCT_CLIENTES CLI, "+
"           sai.ART_PROGRAMAS PGM, "+
"           sai.SCT_DECAN FAC, "+
"           sai.ART_LIQUIDACION_ENC LIQ "+
"   WHERE       CLI.CLI_TIPODCTO = EST.CLI_TIPODCTO "+
"           AND CLI.CLI_NUMDCTO = EST.CLI_NUMDCTO "+
"           AND SUBSTR (EST.EST_CODIGO, 10, 3) = PGM.PRO_CODPROGRAMA "+
"           AND PGM.PRO_ID_DECAN = FAC.ID_DECAN "+
"           AND EST.EST_CODIGO = LIQ.EST_CODIGO "+
"           AND LIQ.PRO_CODIGO = '1' "+
"           AND LIQ.LIQ_SEMESTRE = ? "+
"           AND FAC.ID_DECAN <> 12 "+
"           AND LIQ.LIQ_VALOR > 0 "+
"           AND LIQ.LIQ_ESTADO = 'PAG' "+
"           and  EST.CLI_NUMDCTO in (select distinct cedula "+
" from sai.tbl_encuestado "+
"where fecha> to_date(?, 'yyyy-mm-dd') "+
"and fecha< to_date(?, 'yyyy-mm-dd')) "+
") p "+
"group by "+ 
"id_facultad, "+
"facultad "+
") b "+
"where a.id_facultad=b.id_facultad "+ 
"order by idFacultad"; 
	/**
	 * Consulta de número de docentes evaluados por estudiantes por facultad
	 */
	private static final String consultaDocentesEvaluadosPorEstudiantesPorFacultad=
"select aa.ID_DECAN as idFacultad,aa.facultad,evaluados as participantes, inscritos as total, evaluados*100/inscritos as porcentaje "+
"from "+
"( "+
"select count(distinct NIT) as inscritos, id_facultad as id_decan, nombre_facultad as facultad "+
"from( "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,facultad_centro_costo f "+
"where  "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) " +
//1 fecha contrato 2. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'CAT%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo "+
"UNION ALL "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,FACULTAD_CENTRO_COSTO F "+
"where "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) "+
// 3. fecha contrato 4.fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'DOC%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo ) group by id_facultad, nombre_facultad "+
" ) aa, "+
"( "+
"select count(distinct NIT) as evaluados, id_facultad as id_decan "+
"from( "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,facultad_centro_costo f "+
"where  "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) " +
// 5. fecha contrato 6. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'CAT%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo "+
"UNION ALL "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,FACULTAD_CENTRO_COSTO F "+
"where "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) "+
// 7. fecha contrato 8. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'DOC%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo) "+
" where nit in  "+
" ( "+
"select distinct(SUBSTR (rta.VALOR, 1, INSTR (rta.VALOR, '|') - 1) ) "+
"from sai.tbl_encuestado enc,    sai.tbl_resultados rta, "+
"           sai.tbl_h_cuestionarios cue,  sai.tbl_h_cuestionario_preguntas cpr, "+
"             sai.tbl_h_preguntas pre "+
"           where    enc.idresultados = rta.idresultados "+
"                     AND rta.idpreguntah = cpr.idpreguntah "+
"                     AND rta.idcuestionarioh = cpr.idcuestionarioh "+
"                     AND cue.idcuestionarioh = cpr.idcuestionarioh "+
"                     AND pre.idpreguntah = cpr.idpreguntah "+
"                     AND cue.idcuestionarioh = enc.idcuestionarioh "+
"                     and rta.VALOR like '%||%' "+
"					  and cue.titulo like '%ESTUDIANTES%' "+
"                     and not rta.VALOR like '%||%||%' "+
"                     and   ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"where fecha_inicia >  to_date(?,'yyyy-mm-dd')   "+
"and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+
") "+
"group by id_facultad "+
") bb "+
"where aa.id_decan= bb.id_decan "+
"order By IDFACULTAD ";	 
	/**
	 * Consulta de número de docentes que realizaron autoevaluación por facultad
	 */
private  static final String consultaDocentesConAutoevaluacionPorFacultad =
"select aa.ID_DECAN as idFacultad,aa.facultad,evaluados as participantes, inscritos as total, evaluados*100/inscritos as porcentaje "+
"from "+
"( "+
"select count(distinct NIT) as inscritos, id_facultad as id_decan, nombre_facultad as facultad "+
"from( "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,facultad_centro_costo f "+
"where  "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) " +
//1 fecha contrato 2. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'CAT%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo "+
"UNION ALL "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,FACULTAD_CENTRO_COSTO F "+
"where "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) "+
// 3. fecha contrato 4.fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'DOC%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo ) group by id_facultad, nombre_facultad "+
" ) aa, "+
"( "+
"select count(distinct NIT) as evaluados, id_facultad as id_decan "+
"from( "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,facultad_centro_costo f "+
"where  "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) " +
// 5. fecha contrato 6. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'CAT%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo "+
"UNION ALL "+
"SELECT a.*, b.*,f.nombre as nombre_facultad, f.ID_DECAN as id_facultad "+
"FROM v1_empleado a,interfaz.v_centro_costo b,cc_predecesor_facultad c,FACULTAD_CENTRO_COSTO F "+
"where "+
"FECHA_INGRESO<to_date(?,'yyyy-mm-dd') AND (FECHA_FIN_CONTRATO>to_date(?,'yyyy-mm-dd') or FECHA_FIN_CONTRATO is null) "+
// 7. fecha contrato 8. fecha contrato
"AND a.EMPRESA IN ('CAT', 'DOC') AND a.NOMBRE_CARGO LIKE  'DOC%' AND b.centro_costo = a.centro_costo AND c.cc_predecesor=b.CENTRO_COSTO_PREDECESOR "+
"and c.centro_costo= f.centro_costo) "+
" where nit in  ( "+
"  SELECT    DISTINCT CEDULA "+
"    FROM   sai.TBL_RESULTADOS RE, "+
"           sai.TBL_H_PREGUNTAS PRE, "+
"           sai.RCT_CLIENTES CLI, "+
"           sai.TBL_H_CUESTIONARIOS HCU, "+
"           sai.TBL_INSTANCIA_EVADOC TIE, "+
"           sai.TBL_RESULTADOS_EVADOC TRE, "+
"           sai.TBL_H_CUESTIONARIO_PREGUNTAS THCP, "+
"           sai.TBL_ENCUESTADO ENC "+
"   WHERE   HCU.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+ 
"where fecha_inicia >  to_date(?,'yyyy-mm-dd') "+  
"and fecha_inicia < to_date(?,'yyyy-mm-dd'))) "+
"AND CEDULA IN (SELECT   DISTINCT (CLI_NUMDCTO) "+
"                            FROM   sai.TBL_DOCENTE_RELACION "+
"                           WHERE   ESTADO = 'ACT') "+
"           AND CLI.CLI_NUMDCTO = CEDULA "+
"           AND RE.IDRESULTADOS = ENC.IDRESULTADOS "+
"           AND HCU.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND ENC.IDCUESTIONARIOH = RE.IDCUESTIONARIOH "+
"           AND ENC.IDCUESTIONARIOH = THCP.IDCUESTIONARIOH "+
"           AND RE.IDPREGUNTAH = PRE.IDPREGUNTAH "+
"           AND PRE.IDPREGUNTAH = THCP.IDPREGUNTAH "+
"           AND TIE.IDINSTANCIA = TRE.IDINSTANCIA "+
"           AND ENC.IDRESULTADOS = TRE.IDRESULTADO "+
"           AND HCU.IDCUESTIONARIOH = ENC.IDCUESTIONARIOH "+
"           AND ENC.IDCUESTIONARIOH = TIE.IDCUESTIONARIOH "+
"           AND RE.IDCUESTIONARIOH = TIE.IDCUESTIONARIOH "+
"           AND HCU.IDCUESTIONARIOH = TIE.IDCUESTIONARIOH "+
"           AND TIE.PERIODO =? "+
"           AND TIE.CODIGO_PROFESOR = CLI.CLI_NUMDCTO "+
"           AND TIE.CODIGO_PROFESOR = CEDULA "+
"           AND ENC.FECHA >= TO_DATE (?, 'yyyy/mm/dd') "+
") "+
" group by id_facultad "+
" ) bb "+
" where aa.ID_DECAN = bb.ID_DECAN "+
" order by idFacultad ";
/**
 * Consulta de número de directivos que evaluaron gestión por facultad
 */
public static final String consultaDirectivosGestionEvaluadosPorFacultad=
"select a.ID_DECAN as idFacultad,facultad,encuestados as participantes, total, encuestados*100/total as porcentaje "+ 
"from "+
"("+
"select count(distinct cli_numdcto) as total, facultad_centro_costo.ID_DECAN as id_decan, facultad_centro_costo.nombre as facultad "+ 
" from sai.tbl_docente_rol, facultad_centro_costo  "+ 
" where estado='ACT' and cargo='DI' and facultad_centro_costo.id_decan = sai.tbl_docente_rol.id_decan  "+ 
"group by facultad_centro_costo.ID_DECAN,facultad_centro_costo.nombre  "+ 
") a, "+  
"(  "+ 
"select count(distinct cli_numdcto) as encuestados, facultad_centro_costo.ID_DECAN as id_decan "+  
" from sai.tbl_docente_rol, facultad_centro_costo   "+ 
" where estado='ACT' and cargo='DI' and facultad_centro_costo.id_decan = sai.tbl_docente_rol.id_decan "+  
"and cli_numdcto in  "+ 
"(  "+ 
"select distinct(CEDULA) "+  
"from sai.tbl_encuestado enc,    sai.tbl_resultados rta, "+  
"           sai.tbl_h_cuestionarios cue,  sai.tbl_h_cuestionario_preguntas cpr, "+  
"             sai.tbl_h_preguntas pre  "+ 
"           where    enc.idresultados = rta.idresultados "+  
"                     AND rta.idpreguntah = cpr.idpreguntah  "+ 
"                     AND rta.idcuestionarioh = cpr.idcuestionarioh "+  
"                     AND cue.idcuestionarioh = cpr.idcuestionarioh  "+ 
"                     AND pre.idpreguntah = cpr.idpreguntah  "+ 
"                     AND cue.idcuestionarioh = enc.idcuestionarioh "+  
"                     and cue.titulo like '%GESTION%'  "+ 
"                     and   ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+  
"where fecha_inicia >  to_date(?,'yyyy-mm-dd')    "+ 
"and fecha_inicia < to_date(?,'yyyy-mm-dd')))  "+ 
")  "+ 
"group by facultad_centro_costo.ID_DECAN "+  
") b  "+ 
" where a.ID_DECAN = b.ID_DECAN "+  
" order by idFacultad  ";

/**
 * Consulta de número de directivos  que evaluaron investigación por facultad
 */
public static final String consultaDirectivosInvestigacionEvaluadosPorFacultad=
"select a.ID_DECAN as idFacultad,facultad,encuestados as participantes, total, encuestados*100/total as porcentaje "+ 
"from "+
"("+
"select count(distinct cli_numdcto) as total, facultad_centro_costo.ID_DECAN as id_decan, facultad_centro_costo.nombre as facultad "+ 
" from sai.tbl_docente_rol, facultad_centro_costo  "+ 
" where estado='ACT' and cargo='CI' and facultad_centro_costo.id_decan = sai.tbl_docente_rol.id_decan  "+ 
"group by facultad_centro_costo.ID_DECAN,facultad_centro_costo.nombre  "+ 
") a, "+  
"(  "+ 
"select count(distinct cli_numdcto) as encuestados, facultad_centro_costo.ID_DECAN as id_decan "+  
" from sai.tbl_docente_rol, facultad_centro_costo   "+ 
" where estado='ACT' and cargo='CI' and facultad_centro_costo.id_decan = sai.tbl_docente_rol.id_decan "+  
"and cli_numdcto in  "+ 
"(  "+ 
"select distinct(CEDULA) "+  
"from sai.tbl_encuestado enc,    sai.tbl_resultados rta, "+  
"           sai.tbl_h_cuestionarios cue,  sai.tbl_h_cuestionario_preguntas cpr, "+  
"             sai.tbl_h_preguntas pre  "+ 
"           where    enc.idresultados = rta.idresultados "+  
"                     AND rta.idpreguntah = cpr.idpreguntah  "+ 
"                     AND rta.idcuestionarioh = cpr.idcuestionarioh "+  
"                     AND cue.idcuestionarioh = cpr.idcuestionarioh  "+ 
"                     AND pre.idpreguntah = cpr.idpreguntah  "+ 
"                     AND cue.idcuestionarioh = enc.idcuestionarioh "+  
"                     and cue.titulo like '%INVEST%'  "+ 
"                     and   ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+  
"where fecha_inicia >  to_date(?,'yyyy-mm-dd')    "+ 
"and fecha_inicia < to_date(?,'yyyy-mm-dd')))  "+ 
")  "+ 
"group by facultad_centro_costo.ID_DECAN "+  
") b  "+ 
" where a.ID_DECAN = b.ID_DECAN "+  
" order by idFacultad  ";

}
