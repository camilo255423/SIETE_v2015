
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
	<h3>Número de estudiantes que realizaron la evaluación</h3>
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
		<h3>Número de docentes evaluados por al menos un estudiante</h3>
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
                    DATE: Mon Nov 16 12:30:43 COT 2015
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeparticipantes.scala.html
                    HASH: 28c4807e847995468e157dd4b6f88fe260cb6fac
                    MATRIX: 875->1|1363->343|1390->397|1672->643|1701->649|1982->894|2012->902|2162->1017|2208->1054|2256->1064|2770->1543|2834->1591|2873->1592|2969->1652|2986->1660|3020->1672|3128->1744|3145->1752|3186->1771|3294->1843|3311->1851|3344->1862|3452->1934|3468->1941|3524->1974|3574->1993|4112->2496|4187->2555|4226->2556|4322->2616|4339->2624|4373->2636|4481->2708|4498->2716|4539->2735|4647->2807|4664->2815|4697->2826|4805->2898|4821->2905|4877->2938|4927->2957|5538->3533|5607->3586|5646->3587|5742->3647|5759->3655|5793->3667|5901->3739|5918->3747|5959->3766|6067->3838|6084->3846|6117->3857|6225->3929|6241->3936|6297->3969|6347->3988|6941->4547|7011->4601|7050->4602|7147->4662|7165->4670|7200->4682|7309->4754|7327->4762|7369->4781|7478->4853|7496->4861|7530->4872|7639->4944|7656->4951|7713->4984|7764->5003|8352->5555|8429->5615|8469->5616|8566->5676|8584->5684|8619->5696|8728->5768|8746->5776|8788->5795|8897->5867|8915->5875|8949->5886|9058->5958|9075->5965|9132->5998|9183->6017|9270->6072
                    LINES: 26->1|37->6|38->9|42->13|42->13|47->18|47->18|50->21|50->21|50->21|63->34|63->34|63->34|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|70->41|84->55|84->55|84->55|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|89->60|89->60|89->60|91->62|107->78|107->78|107->78|109->80|109->80|109->80|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|114->85|128->99|128->99|128->99|130->101|130->101|130->101|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|135->106|149->120|149->120|149->120|151->122|151->122|151->122|152->123|152->123|152->123|153->124|153->124|153->124|154->125|154->125|154->125|156->127|161->132
                    -- GENERATED --
                */
            