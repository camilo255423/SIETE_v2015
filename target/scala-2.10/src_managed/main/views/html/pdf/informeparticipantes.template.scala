
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
object informeparticipantes extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template7[List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(estudiantesEvaluadosPorFacultad:List[Facultad],
    			docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],
    			docentesConAutoevaluacionPorFacultad:List[Facultad],
    			directivosGestionEvaluadosPorFacultad:List[Facultad],
    			directivosInvestigacionEvaluadosPorFacultad:List[Facultad],
    			 semestre:String, imagen:String):play.api.templates.Html = {
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
    
    def render(estudiantesEvaluadosPorFacultad:List[Facultad],docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],docentesConAutoevaluacionPorFacultad:List[Facultad],directivosGestionEvaluadosPorFacultad:List[Facultad],directivosInvestigacionEvaluadosPorFacultad:List[Facultad],semestre:String,imagen:String): play.api.templates.Html = apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen)
    
    def f:((List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String,String) => play.api.templates.Html) = (estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen) => apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 10:07:52 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeparticipantes.scala.html
                    HASH: 686d67441b22696082a1ef819adb245487f9090a
                    MATRIX: 824->1|1295->343|1322->397|1604->643|1633->649|1823->803|1853->811|2003->926|2049->963|2097->973|2592->1433|2656->1481|2695->1482|2791->1542|2808->1550|2842->1562|2950->1634|2967->1642|3008->1661|3116->1733|3133->1741|3166->1752|3274->1824|3290->1831|3346->1864|3396->1883|3927->2379|4002->2438|4041->2439|4137->2499|4154->2507|4188->2519|4296->2591|4313->2599|4354->2618|4462->2690|4479->2698|4512->2709|4620->2781|4636->2788|4692->2821|4742->2840|5353->3416|5422->3469|5461->3470|5557->3530|5574->3538|5608->3550|5716->3622|5733->3630|5774->3649|5882->3721|5899->3729|5932->3740|6040->3812|6056->3819|6112->3852|6162->3871|6756->4430|6826->4484|6865->4485|6962->4545|6980->4553|7015->4565|7124->4637|7142->4645|7184->4664|7293->4736|7311->4744|7345->4755|7454->4827|7471->4834|7528->4867|7579->4886|8167->5438|8244->5498|8284->5499|8381->5559|8399->5567|8434->5579|8543->5651|8561->5659|8603->5678|8712->5750|8730->5758|8764->5769|8873->5841|8890->5848|8947->5881|8998->5900|9085->5955
                    LINES: 26->1|37->6|38->9|42->13|42->13|46->17|46->17|49->20|49->20|49->20|62->33|62->33|62->33|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|69->40|83->54|83->54|83->54|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|90->61|106->77|106->77|106->77|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|111->82|111->82|111->82|113->84|127->98|127->98|127->98|129->100|129->100|129->100|130->101|130->101|130->101|131->102|131->102|131->102|132->103|132->103|132->103|134->105|148->119|148->119|148->119|150->121|150->121|150->121|151->122|151->122|151->122|152->123|152->123|152->123|153->124|153->124|153->124|155->126|160->131
                    -- GENERATED --
                */
            