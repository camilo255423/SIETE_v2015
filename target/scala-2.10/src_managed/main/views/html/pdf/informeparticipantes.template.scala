
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
	<div style="text-align:center"><p><b>Evaluación del Desempeño Docente """),_display_(Seq[Any](/*17.73*/semestre)),format.raw/*17.81*/("""</b></p></div>
	<div style="text-align:center"><p><b>Informe Número de Participantes por Facultad</b></p></div>

 """),_display_(Seq[Any](/*20.3*/defining(new DecimalFormat("##0.00"))/*20.40*/{formato=>_display_(Seq[Any](format.raw/*20.50*/("""
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
		"""),_display_(Seq[Any](/*33.4*/for(facultad <- estudiantesEvaluadosPorFacultad) yield /*33.52*/{_display_(Seq[Any](format.raw/*33.53*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*35.52*/facultad/*35.60*/.getNombre())),format.raw/*35.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*36.67*/facultad/*36.75*/.getParticipantes())),format.raw/*36.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*37.67*/facultad/*37.75*/.getTotal())),format.raw/*37.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*38.67*/formato/*38.74*/.format(facultad.getPorcentaje()))),format.raw/*38.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*40.4*/("""
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
		"""),_display_(Seq[Any](/*54.4*/for(facultad <- docentesEvaluadosPorEstudiantesPorFacultad) yield /*54.63*/{_display_(Seq[Any](format.raw/*54.64*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*56.52*/facultad/*56.60*/.getNombre())),format.raw/*56.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*57.67*/facultad/*57.75*/.getParticipantes())),format.raw/*57.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*58.67*/facultad/*58.75*/.getTotal())),format.raw/*58.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*59.67*/formato/*59.74*/.format(facultad.getPorcentaje()))),format.raw/*59.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*61.4*/("""
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
		"""),_display_(Seq[Any](/*77.4*/for(facultad <- docentesConAutoevaluacionPorFacultad) yield /*77.57*/{_display_(Seq[Any](format.raw/*77.58*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*79.52*/facultad/*79.60*/.getNombre())),format.raw/*79.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*80.67*/facultad/*80.75*/.getParticipantes())),format.raw/*80.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*81.67*/facultad/*81.75*/.getTotal())),format.raw/*81.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*82.67*/formato/*82.74*/.format(facultad.getPorcentaje()))),format.raw/*82.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*84.4*/("""
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
		"""),_display_(Seq[Any](/*98.4*/for(facultad <- directivosGestionEvaluadosPorFacultad) yield /*98.58*/{_display_(Seq[Any](format.raw/*98.59*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*100.52*/facultad/*100.60*/.getNombre())),format.raw/*100.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*101.67*/facultad/*101.75*/.getParticipantes())),format.raw/*101.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*102.67*/facultad/*102.75*/.getTotal())),format.raw/*102.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*103.67*/formato/*103.74*/.format(facultad.getPorcentaje()))),format.raw/*103.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*105.4*/("""
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
		"""),_display_(Seq[Any](/*119.4*/for(facultad <- directivosInvestigacionEvaluadosPorFacultad) yield /*119.64*/{_display_(Seq[Any](format.raw/*119.65*/("""
		 <tr>
			<td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*121.52*/facultad/*121.60*/.getNombre())),format.raw/*121.72*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*122.67*/facultad/*122.75*/.getParticipantes())),format.raw/*122.94*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*123.67*/facultad/*123.75*/.getTotal())),format.raw/*123.86*/("""</td>
			<td style="font-size: 8pt; class="row_headers" align="center">"""),_display_(Seq[Any](/*124.67*/formato/*124.74*/.format(facultad.getPorcentaje()))),format.raw/*124.107*/(""" %</td>
		</tr>
		""")))})),format.raw/*126.4*/("""
		</tbody>
	    </table>
</div>
</div> <!-- tabs -->
""")))})),format.raw/*131.2*/("""
</div>  <!-- div informe -->
"""))}
    }
    
    def render(estudiantesEvaluadosPorFacultad:List[Facultad],docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],docentesConAutoevaluacionPorFacultad:List[Facultad],directivosGestionEvaluadosPorFacultad:List[Facultad],directivosInvestigacionEvaluadosPorFacultad:List[Facultad],semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen)
    
    def f:((List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String,String) => play.api.templates.HtmlFormat.Appendable) = (estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen) => apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon May 12 13:05:46 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeparticipantes.scala.html
                    HASH: e866343db8d97acb81e04f9b67245a6773b5a11f
                    MATRIX: 875->1|1363->343|1390->397|1672->643|1701->649|1891->803|1921->811|2071->926|2117->963|2165->973|2660->1433|2724->1481|2763->1482|2859->1542|2876->1550|2910->1562|3018->1634|3035->1642|3076->1661|3184->1733|3201->1741|3234->1752|3342->1824|3358->1831|3414->1864|3464->1883|3995->2379|4070->2438|4109->2439|4205->2499|4222->2507|4256->2519|4364->2591|4381->2599|4422->2618|4530->2690|4547->2698|4580->2709|4688->2781|4704->2788|4760->2821|4810->2840|5421->3416|5490->3469|5529->3470|5625->3530|5642->3538|5676->3550|5784->3622|5801->3630|5842->3649|5950->3721|5967->3729|6000->3740|6108->3812|6124->3819|6180->3852|6230->3871|6824->4430|6894->4484|6933->4485|7030->4545|7048->4553|7083->4565|7192->4637|7210->4645|7252->4664|7361->4736|7379->4744|7413->4755|7522->4827|7539->4834|7596->4867|7647->4886|8235->5438|8312->5498|8352->5499|8449->5559|8467->5567|8502->5579|8611->5651|8629->5659|8671->5678|8780->5750|8798->5758|8832->5769|8941->5841|8958->5848|9015->5881|9066->5900|9153->5955
                    LINES: 26->1|37->6|38->9|42->13|42->13|46->17|46->17|49->20|49->20|49->20|62->33|62->33|62->33|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|69->40|83->54|83->54|83->54|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|90->61|106->77|106->77|106->77|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|111->82|111->82|111->82|113->84|127->98|127->98|127->98|129->100|129->100|129->100|130->101|130->101|130->101|131->102|131->102|131->102|132->103|132->103|132->103|134->105|148->119|148->119|148->119|150->121|150->121|150->121|151->122|151->122|151->122|152->123|152->123|152->123|153->124|153->124|153->124|155->126|160->131
                    -- GENERATED --
                */
            