
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
object informeparticipantes extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(estudiantesEvaluadosPorFacultad:List[Facultad],
    			docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],
    			docentesConAutoevaluacionPorFacultad:List[Facultad],
    			directivosGestionEvaluadosPorFacultad:List[Facultad],
    			directivosInvestigacionEvaluadosPorFacultad:List[Facultad]):play.api.templates.Html = {
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
    
    def render(estudiantesEvaluadosPorFacultad:List[Facultad],docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],docentesConAutoevaluacionPorFacultad:List[Facultad],directivosGestionEvaluadosPorFacultad:List[Facultad],directivosInvestigacionEvaluadosPorFacultad:List[Facultad]): play.api.templates.Html = apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad)
    
    def f:((List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad]) => play.api.templates.Html) = (estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad) => apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 24 19:20:31 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeparticipantes.scala.html
                    HASH: 99a78f643ebfea14ed08b7c44ac779b83ba49b8e
                    MATRIX: 815->1|1246->303|1273->357|1328->378|1373->415|1420->425|1997->967|2061->1015|2100->1016|2152->1033|2169->1041|2203->1053|2252->1067|2269->1075|2310->1094|2359->1108|2376->1116|2409->1127|2458->1141|2474->1148|2529->1181|2579->1200|2899->1485|2974->1544|3013->1545|3065->1562|3082->1570|3116->1582|3165->1596|3182->1604|3223->1623|3272->1637|3289->1645|3322->1656|3371->1670|3387->1677|3442->1710|3492->1729|3838->2040|3907->2093|3946->2094|3998->2111|4015->2119|4049->2131|4098->2145|4115->2153|4156->2172|4205->2186|4222->2194|4255->2205|4304->2219|4320->2226|4375->2259|4425->2278|4757->2575|4827->2629|4866->2630|4918->2647|4935->2655|4969->2667|5018->2681|5035->2689|5076->2708|5125->2722|5142->2730|5175->2741|5224->2755|5240->2762|5295->2795|5346->2814|5672->3104|5749->3164|5789->3165|5842->3182|5860->3190|5895->3202|5945->3216|5963->3224|6005->3243|6055->3257|6073->3265|6107->3276|6157->3290|6174->3297|6230->3330|6281->3349|6368->3404
                    LINES: 26->1|36->5|37->8|38->9|38->9|38->9|57->28|57->28|57->28|59->30|59->30|59->30|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|64->35|78->49|78->49|78->49|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|85->56|101->72|101->72|101->72|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|108->79|122->93|122->93|122->93|124->95|124->95|124->95|125->96|125->96|125->96|126->97|126->97|126->97|127->98|127->98|127->98|129->100|143->114|143->114|143->114|145->116|145->116|145->116|146->117|146->117|146->117|147->118|147->118|147->118|148->119|148->119|148->119|150->121|155->126
                    -- GENERATED --
                */
            