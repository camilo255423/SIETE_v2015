
package views.html.informes

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
object informeparticipantes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(estudiantesEvaluadosPorFacultad:List[Facultad],
    			docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],
    			docentesConAutoevaluacionPorFacultad:List[Facultad],
    			directivosGestionEvaluadosPorFacultad:List[Facultad],
    			directivosInvestigacionEvaluadosPorFacultad:List[Facultad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*5.67*/("""
"""),format.raw/*8.1*/("""<div id="informe">
 """),_display_(Seq[Any](/*9.3*/defining(new DecimalFormat("##0.00"))/*9.40*/{formato=>_display_(Seq[Any](format.raw/*9.50*/("""
<div class="tabs">
		<ul>
			<li><a href="#tabs-estudiantes">Estudiantes</a></li>
			<li><a href="#tabs-docentes">Docentes Evaluados</a></li>
			<li><a href="#tabs-autoeval">Autoevaluación</a></li>
			<li><a href="#tabs-gestion">Gestión</a></li>
			<li><a href="#tabs-investigacion">Investigación</a></li>
		</ul>
 	<div id="tabs-estudiantes">       
	<h3>Número de Estudiantes Evaluados</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Número de Participantes</td>
			<td>Total Estudiantes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*28.4*/for(facultad <- estudiantesEvaluadosPorFacultad) yield /*28.52*/{_display_(Seq[Any](format.raw/*28.53*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*30.9*/facultad/*30.17*/.getNombre())),format.raw/*30.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*31.9*/facultad/*31.17*/.getParticipantes())),format.raw/*31.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*32.9*/facultad/*32.17*/.getTotal())),format.raw/*32.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*33.9*/formato/*33.16*/.format(facultad.getPorcentaje()))),format.raw/*33.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*35.4*/("""
		</tbody>
	    </table>
	</div>	   
	<div id="tabs-docentes">	
		<h3>Número de Docentes Evaluados por los Estudiantes</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Número de Docentes Evaluados</td>
			<td>Número Total de Docentes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*49.4*/for(facultad <- docentesEvaluadosPorEstudiantesPorFacultad) yield /*49.63*/{_display_(Seq[Any](format.raw/*49.64*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*51.9*/facultad/*51.17*/.getNombre())),format.raw/*51.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*52.9*/facultad/*52.17*/.getParticipantes())),format.raw/*52.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*53.9*/facultad/*53.17*/.getTotal())),format.raw/*53.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*54.9*/formato/*54.16*/.format(facultad.getPorcentaje()))),format.raw/*54.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*56.4*/("""
		</tbody>
	    </table>
	</div> <!-- div docentes -->


<div id="tabs-autoeval">
	<h3>Número de Docentes que realizaron Autoevaluación</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Número de Docentes con Autoevaluación</td>
			<td>Número Total de Docentes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*72.4*/for(facultad <- docentesConAutoevaluacionPorFacultad) yield /*72.57*/{_display_(Seq[Any](format.raw/*72.58*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*74.9*/facultad/*74.17*/.getNombre())),format.raw/*74.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*75.9*/facultad/*75.17*/.getParticipantes())),format.raw/*75.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*76.9*/facultad/*76.17*/.getTotal())),format.raw/*76.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*77.9*/formato/*77.16*/.format(facultad.getPorcentaje()))),format.raw/*77.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*79.4*/("""
		</tbody>
	    </table>
</div>
<div id="tabs-gestion">
<h3>Número de Directivos que evaluaron la gestión de sus docentes</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Número de Docentes con Autoevaluación</td>
			<td>Número Total de Docentes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*93.4*/for(facultad <- directivosGestionEvaluadosPorFacultad) yield /*93.58*/{_display_(Seq[Any](format.raw/*93.59*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*95.9*/facultad/*95.17*/.getNombre())),format.raw/*95.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*96.9*/facultad/*96.17*/.getParticipantes())),format.raw/*96.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*97.9*/facultad/*97.17*/.getTotal())),format.raw/*97.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*98.9*/formato/*98.16*/.format(facultad.getPorcentaje()))),format.raw/*98.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*100.4*/("""
		</tbody>
	    </table>
</div>
<div id="tabs-investigacion">
<h3>Número de Directivos que evaluaron investigación</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Número de Docentes con Autoevaluación</td>
			<td>Número Total de Docentes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*114.4*/for(facultad <- directivosInvestigacionEvaluadosPorFacultad) yield /*114.64*/{_display_(Seq[Any](format.raw/*114.65*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*116.9*/facultad/*116.17*/.getNombre())),format.raw/*116.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*117.9*/facultad/*117.17*/.getParticipantes())),format.raw/*117.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*118.9*/facultad/*118.17*/.getTotal())),format.raw/*118.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*119.9*/formato/*119.16*/.format(facultad.getPorcentaje()))),format.raw/*119.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*121.4*/("""
		</tbody>
	    </table>
</div>
</div> <!-- tabs -->
""")))})),format.raw/*126.2*/("""
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(estudiantesEvaluadosPorFacultad:List[Facultad],docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],docentesConAutoevaluacionPorFacultad:List[Facultad],directivosGestionEvaluadosPorFacultad:List[Facultad],directivosInvestigacionEvaluadosPorFacultad:List[Facultad]): play.api.templates.HtmlFormat.Appendable = apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad)
    
    def f:((List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad]) => play.api.templates.HtmlFormat.Appendable) = (estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad) => apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 27 21:27:50 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeparticipantes.scala.html
                    HASH: 40100902e2a9696f7bc33e178423e0295c8fbae4
                    MATRIX: 866->1|1314->303|1341->357|1396->378|1441->415|1488->425|2065->967|2129->1015|2168->1016|2220->1033|2237->1041|2271->1053|2320->1067|2337->1075|2378->1094|2427->1108|2444->1116|2477->1127|2526->1141|2542->1148|2597->1181|2647->1200|2967->1485|3042->1544|3081->1545|3133->1562|3150->1570|3184->1582|3233->1596|3250->1604|3291->1623|3340->1637|3357->1645|3390->1656|3439->1670|3455->1677|3510->1710|3560->1729|3906->2040|3975->2093|4014->2094|4066->2111|4083->2119|4117->2131|4166->2145|4183->2153|4224->2172|4273->2186|4290->2194|4323->2205|4372->2219|4388->2226|4443->2259|4493->2278|4825->2575|4895->2629|4934->2630|4986->2647|5003->2655|5037->2667|5086->2681|5103->2689|5144->2708|5193->2722|5210->2730|5243->2741|5292->2755|5308->2762|5363->2795|5414->2814|5740->3104|5817->3164|5857->3165|5910->3182|5928->3190|5963->3202|6013->3216|6031->3224|6073->3243|6123->3257|6141->3265|6175->3276|6225->3290|6242->3297|6298->3330|6349->3349|6436->3404
                    LINES: 26->1|36->5|37->8|38->9|38->9|38->9|57->28|57->28|57->28|59->30|59->30|59->30|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|64->35|78->49|78->49|78->49|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|85->56|101->72|101->72|101->72|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|108->79|122->93|122->93|122->93|124->95|124->95|124->95|125->96|125->96|125->96|126->97|126->97|126->97|127->98|127->98|127->98|129->100|143->114|143->114|143->114|145->116|145->116|145->116|146->117|146->117|146->117|147->118|147->118|147->118|148->119|148->119|148->119|150->121|155->126
                    -- GENERATED --
                */
            