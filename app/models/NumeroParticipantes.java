package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class NumeroParticipantes {
	ArrayList<Facultad> estudiantesEvaluadosPorFacultad;
	ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad;
	ArrayList<Facultad> docentesConAutoevaluacionPorFacultad;
	ArrayList<Facultad> directivosGestionEvaluadosPorFacultad;
	ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad;
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
			try {
				p = con.prepareStatement(NumeroParticipantes.consultaEstudiantesEvaluadosPorFacultad);
				p.setString(1, semestre);
				p.setString(2, semestre);
				p.setString(3, periodo[Periodo.FECHAINICIO]);
				p.setString(4, periodo[Periodo.FECHAFIN]);
				estudiantesEvaluadosPorFacultad = NumeroParticipantes.consultarParticipantes(p); 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return new NumeroParticipantes(estudiantesEvaluadosPorFacultad, docentesEvaluadosPorEstudiantesPorFacultad, docentesConAutoevaluacionPorFacultad, directivosGestionEvaluadosPorFacultad, directivosInvestigacionEvaluadosPorFacultad);
	}
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
	public ArrayList<Facultad> getEstudiantesEvaluadosPorFacultad() {
		return estudiantesEvaluadosPorFacultad;
	}
	public void setEstudiantesEvaluadosPorFacultad(
			ArrayList<Facultad> estudiantesEvaluadosPorFacultad) {
		this.estudiantesEvaluadosPorFacultad = estudiantesEvaluadosPorFacultad;
	}
	public ArrayList<Facultad> getDocentesEvaluadosPorEstudiantesPorFacultad() {
		return docentesEvaluadosPorEstudiantesPorFacultad;
	}
	public void setDocentesEvaluadosPorEstudiantesPorFacultad(
			ArrayList<Facultad> docentesEvaluadosPorEstudiantesPorFacultad) {
		this.docentesEvaluadosPorEstudiantesPorFacultad = docentesEvaluadosPorEstudiantesPorFacultad;
	}
	public ArrayList<Facultad> getDocentesConAutoevaluacionPorFacultad() {
		return docentesConAutoevaluacionPorFacultad;
	}
	public void setDocentesConAutoevaluacionPorFacultad(
			ArrayList<Facultad> docentesConAutoevaluacionPorFacultad) {
		this.docentesConAutoevaluacionPorFacultad = docentesConAutoevaluacionPorFacultad;
	}
	public ArrayList<Facultad> getDirectivosGestionEvaluadosPorFacultad() {
		return directivosGestionEvaluadosPorFacultad;
	}
	public void setDirectivosGestionEvaluadosPorFacultad(
			ArrayList<Facultad> directivosGestionEvaluadosPorFacultad) {
		this.directivosGestionEvaluadosPorFacultad = directivosGestionEvaluadosPorFacultad;
	}
	public ArrayList<Facultad> getDirectivosInvestigacionEvaluadosPorFacultad() {
		return directivosInvestigacionEvaluadosPorFacultad;
	}
	public void setDirectivosInvestigacionEvaluadosPorFacultad(
			ArrayList<Facultad> directivosInvestigacionEvaluadosPorFacultad) {
		this.directivosInvestigacionEvaluadosPorFacultad = directivosInvestigacionEvaluadosPorFacultad;
	}
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
	private static final String consultaDocentesEvaluadosPorEstudiantesPorFacultad=
"select a.ID_DECAN as idFacultad,facultad,evaluados as participantes, total, evaluados*100/inscritos as porcentaje "+
"from "+
"( "+
"SELECT   count(distinct NIT) as inscritos, facultad_centro_costo.ID_DECAN as id_decan, facultad_centro_costo.nombre as facultad "+
"  FROM   ICEBERG.EMPLEADO E, ICEBERG.CENTRO_COSTO CC, facultad_centro_costo "+
" WHERE    E.CENTRO_COSTO = CC.CENTRO_COSTO "+
"  and to_date('2013-10-03','yyyy-mm-dd')>fecha_ingreso and "+ 
" to_date('2013-10-03','yyyy-mm-dd')<E.FECHA_FIN_CONTRATO "+
" and CC.CENTRO_COSTO_PREDECESOR=facultad_centro_costo.centro_costo "+
" group by facultad_centro_costo.ID_DECAN,facultad_centro_costo.nombre "+
" ) a, "+
"(SELECT   count(distinct NIT) as evaluados, facultad_centro_costo.ID_DECAN as id_decan "+
"  FROM   ICEBERG.EMPLEADO E, ICEBERG.CENTRO_COSTO CC, facultad_centro_costo "+
" WHERE    E.CENTRO_COSTO = CC.CENTRO_COSTO "+
"  and to_date('2013-10-03','yyyy-mm-dd')>fecha_ingreso and "+ 
" to_date('2013-10-03','yyyy-mm-dd')<E.FECHA_FIN_CONTRATO "+
" and CC.CENTRO_COSTO_PREDECESOR=facultad_centro_costo.centro_costo "+
" and nit in  "+
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
"                     and not rta.VALOR like '%||%||%' "+
"                     and   ENC.IDCUESTIONARIOH IN ((SELECT IDCUESTIONARIOH FROM SAI.TBL_H_CUESTIONARIOS "+
"where fecha_inicia >  to_date('2013-01-01','yyyy-mm-dd')   "+
"and fecha_inicia < to_date('2013-06-01','yyyy-mm-dd'))) "+
") "+
"group by facultad_centro_costo.ID_DECAN "+
") b "+
"where a.ID_DECAN = b.ID_DECAN "+
"order By IDFACULTAD ";	 


}
