
package views.html.pdf

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object informeparticipantes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(estudiantesEvaluadosPorFacultad:List[Facultad],
    			docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],
    			docentesConAutoevaluacionPorFacultad:List[Facultad],
    			directivosGestionEvaluadosPorFacultad:List[Facultad],
    			directivosInvestigacionEvaluadosPorFacultad:List[Facultad],
    			 semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*6.40*/("""
"""),format.raw/*9.1*/("""<div id="informe">
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td style="font-size: 8pt; class="row_headers" width='222'>&nbsp;</td>
    <td style="font-size: 8pt; class="row_headers" width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*13.99*/imagen)),format.raw/*13.105*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Evaluación del Desempeño Docente """),_display_(Seq[Any](/*18.73*/semestre)),format.raw/*18.81*/("""</b></p></div>
	<div style="text-align:center"><p><b>Informe Número de Participantes por Facultad</b></p></div>

 """),_display_(Seq[Any](/*21.3*/defining(new DecimalFormat("##0.00"))/*21.40*/{formato=>_display_(Seq[Any](format.raw/*21.50*/("""
<div class="tabs">
	
 	<div id="tabs-estudiantes">       
	<h3>Número de Estudiantes Evaluados</h3>
		<table border="1">
		<tbody>
		<tr>
			<td style="font-size: 8pt; class="row_headers"><b>Facultad</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Número de Participantes</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Total Estudiantes</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Porcentaje</b></td>
		</tr>
		"""),_display_(Seq[Any](/*34.4*/for(facultad <- estudiantesEvaluadosPorFacultad) yield /*34.52*/{_display_(Seq[Any](format.raw/*34.53*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*36.52*/facultad/*36.60*/.getNombre())),format.raw/*36.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*37.67*/facultad/*37.75*/.getParticipantes())),format.raw/*37.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*38.67*/facultad/*38.75*/.getTotal())),format.raw/*38.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*39.67*/formato/*39.74*/.format(facultad.getPorcentaje()))),format.raw/*39.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*41.4*/("""
		</tbody>
	    </table>
	</div>	   
	<div id="tabs-docentes">	
		<h3>Número de Docentes Evaluados por los Estudiantes</h3>
		<table border="1">
		<tbody>
		<tr>
			<td style="font-size: 8pt; class="row_headers"><b>Facultad</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Número de Docentes Evaluados</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Número Total de Docentes</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Porcentaje</b></td>
		</tr>
		"""),_display_(Seq[Any](/*55.4*/for(facultad <- docentesEvaluadosPorEstudiantesPorFacultad) yield /*55.63*/{_display_(Seq[Any](format.raw/*55.64*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*57.52*/facultad/*57.60*/.getNombre())),format.raw/*57.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*58.67*/facultad/*58.75*/.getParticipantes())),format.raw/*58.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*59.67*/facultad/*59.75*/.getTotal())),format.raw/*59.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*60.67*/formato/*60.74*/.format(facultad.getPorcentaje()))),format.raw/*60.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*62.4*/("""
		</tbody>
	    </table>
	</div> <!-- div docentes -->


<div id="tabs-autoeval">
	<h3>Número de Docentes que realizaron Autoevaluación</h3>
		<table border="1">
		<tbody>
		<tr>
			<td style="font-size: 8pt; class="row_headers"><b>Facultad</b></td>
			<td style="font-size: 8pt; class="row_headers" width='3cm' align="center"><b>Número de Docentes con Autoevaluación</b></td>
			<td style="font-size: 8pt; class="row_headers" width='3cm' align="center"><b>Número Total de Docentes</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Porcentaje</b></td>
		</tr>
		"""),_display_(Seq[Any](/*78.4*/for(facultad <- docentesConAutoevaluacionPorFacultad) yield /*78.57*/{_display_(Seq[Any](format.raw/*78.58*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*80.52*/facultad/*80.60*/.getNombre())),format.raw/*80.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*81.67*/facultad/*81.75*/.getParticipantes())),format.raw/*81.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*82.67*/facultad/*82.75*/.getTotal())),format.raw/*82.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*83.67*/formato/*83.74*/.format(facultad.getPorcentaje()))),format.raw/*83.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*85.4*/("""
		</tbody>
	    </table>
</div>
<div id="tabs-gestion">
<h3>Número de Directivos que evaluaron la gestión de sus docentes</h3>
		<table border="1">
		<tbody>
		<tr>
			<td style="font-size: 8pt; class="row_headers"><b>Facultad</b></td>
			<td style="font-size: 8pt; class="row_headers" width='3cm' align="center"><b>Número de Directivos Participantes</b></td>
			<td style="font-size: 8pt; class="row_headers" width='3cm' align="center"><b>Número Total de Docentes</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Porcentaje</b></td>
		</tr>
		"""),_display_(Seq[Any](/*99.4*/for(facultad <- directivosGestionEvaluadosPorFacultad) yield /*99.58*/{_display_(Seq[Any](format.raw/*99.59*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*101.52*/facultad/*101.60*/.getNombre())),format.raw/*101.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*102.67*/facultad/*102.75*/.getParticipantes())),format.raw/*102.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*103.67*/facultad/*103.75*/.getTotal())),format.raw/*103.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*104.67*/formato/*104.74*/.format(facultad.getPorcentaje()))),format.raw/*104.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*106.4*/("""
		</tbody>
	    </table>
</div>
<div id="tabs-investigacion">
<h3>Número de Directivos que evaluaron investigación</h3>
		<table border="1">
		<tbody>
		<tr>
			<td style="font-size: 8pt; class="row_headers"><b>Facultad</b></td>
			<td style="font-size: 8pt; class="row_headers" width='3cm' align="center"><b>Número de Directivos Participantes</b></td>
			<td style="font-size: 8pt; class="row_headers" width='3cm' align="center"><b>Número Total de Docentes</b></td>
			<td style="font-size: 8pt; class="row_headers"><b>Porcentaje</b></td>
		</tr>
		"""),_display_(Seq[Any](/*120.4*/for(facultad <- directivosInvestigacionEvaluadosPorFacultad) yield /*120.64*/{_display_(Seq[Any](format.raw/*120.65*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*122.52*/facultad/*122.60*/.getNombre())),format.raw/*122.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*123.67*/facultad/*123.75*/.getParticipantes())),format.raw/*123.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*124.67*/facultad/*124.75*/.getTotal())),format.raw/*124.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*125.67*/formato/*125.74*/.format(facultad.getPorcentaje()))),format.raw/*125.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*127.4*/("""
		</tbody>
	    </table>
</div>
</div> <!-- tabs -->
""")))})),format.raw/*132.2*/("""
</div>  <!-- div informe -->
"""))}
    }
    
    def render(estudiantesEvaluadosPorFacultad:List[Facultad],docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],docentesConAutoevaluacionPorFacultad:List[Facultad],directivosGestionEvaluadosPorFacultad:List[Facultad],directivosInvestigacionEvaluadosPorFacultad:List[Facultad],semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen)
    
    def f:((List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String,String) => play.api.templates.HtmlFormat.Appendable) = (estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen) => apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 03 10:49:41 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/pdf/informeparticipantes.scala.html
                    HASH: 173c74b5238a36a96ebb8be207bca044692fc482
                    MATRIX: 875->1|1363->343|1390->397|1672->643|1701->649|1982->894|2012->902|2162->1017|2208->1054|2256->1064|2751->1524|2815->1572|2854->1573|2950->1633|2967->1641|3001->1653|3109->1725|3126->1733|3167->1752|3275->1824|3292->1832|3325->1843|3433->1915|3449->1922|3505->1955|3555->1974|4086->2470|4161->2529|4200->2530|4296->2590|4313->2598|4347->2610|4455->2682|4472->2690|4513->2709|4621->2781|4638->2789|4671->2800|4779->2872|4795->2879|4851->2912|4901->2931|5512->3507|5581->3560|5620->3561|5716->3621|5733->3629|5767->3641|5875->3713|5892->3721|5933->3740|6041->3812|6058->3820|6091->3831|6199->3903|6215->3910|6271->3943|6321->3962|6915->4521|6985->4575|7024->4576|7121->4636|7139->4644|7174->4656|7283->4728|7301->4736|7343->4755|7452->4827|7470->4835|7504->4846|7613->4918|7630->4925|7687->4958|7738->4977|8326->5529|8403->5589|8443->5590|8540->5650|8558->5658|8593->5670|8702->5742|8720->5750|8762->5769|8871->5841|8889->5849|8923->5860|9032->5932|9049->5939|9106->5972|9157->5991|9244->6046
                    LINES: 26->1|37->6|38->9|42->13|42->13|47->18|47->18|50->21|50->21|50->21|63->34|63->34|63->34|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|70->41|84->55|84->55|84->55|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|89->60|89->60|89->60|91->62|107->78|107->78|107->78|109->80|109->80|109->80|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|114->85|128->99|128->99|128->99|130->101|130->101|130->101|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|135->106|149->120|149->120|149->120|151->122|151->122|151->122|152->123|152->123|152->123|153->124|153->124|153->124|154->125|154->125|154->125|156->127|161->132
                    -- GENERATED --
                */
            