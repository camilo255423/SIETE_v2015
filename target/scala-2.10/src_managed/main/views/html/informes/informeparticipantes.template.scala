
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
object informeparticipantes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(estudiantesEvaluadosPorFacultad:List[Facultad],
    			docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],
    			docentesConAutoevaluacionPorFacultad:List[Facultad],
    			directivosGestionEvaluadosPorFacultad:List[Facultad],
    			directivosInvestigacionEvaluadosPorFacultad:List[Facultad], semestre:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*5.84*/("""
"""),format.raw/*8.1*/("""<div id="informe">
<h2 style="text-align: center;">Informe de Participantes """),_display_(Seq[Any](/*9.59*/semestre)),format.raw/*9.67*/("""</h2>

 """),_display_(Seq[Any](/*11.3*/defining(new DecimalFormat("##0.00"))/*11.40*/{formato=>_display_(Seq[Any](format.raw/*11.50*/("""
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
		"""),_display_(Seq[Any](/*30.4*/for(facultad <- estudiantesEvaluadosPorFacultad) yield /*30.52*/{_display_(Seq[Any](format.raw/*30.53*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*32.9*/facultad/*32.17*/.getNombre())),format.raw/*32.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*33.9*/facultad/*33.17*/.getParticipantes())),format.raw/*33.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*34.9*/facultad/*34.17*/.getTotal())),format.raw/*34.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*35.9*/formato/*35.16*/.format(facultad.getPorcentaje()))),format.raw/*35.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*37.4*/("""
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
		"""),_display_(Seq[Any](/*51.4*/for(facultad <- docentesEvaluadosPorEstudiantesPorFacultad) yield /*51.63*/{_display_(Seq[Any](format.raw/*51.64*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*53.9*/facultad/*53.17*/.getNombre())),format.raw/*53.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*54.9*/facultad/*54.17*/.getParticipantes())),format.raw/*54.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*55.9*/facultad/*55.17*/.getTotal())),format.raw/*55.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*56.9*/formato/*56.16*/.format(facultad.getPorcentaje()))),format.raw/*56.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*58.4*/("""
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
		"""),_display_(Seq[Any](/*74.4*/for(facultad <- docentesConAutoevaluacionPorFacultad) yield /*74.57*/{_display_(Seq[Any](format.raw/*74.58*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*76.9*/facultad/*76.17*/.getNombre())),format.raw/*76.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*77.9*/facultad/*77.17*/.getParticipantes())),format.raw/*77.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*78.9*/facultad/*78.17*/.getTotal())),format.raw/*78.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*79.9*/formato/*79.16*/.format(facultad.getPorcentaje()))),format.raw/*79.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*81.4*/("""
		</tbody>
	    </table>
</div>
<div id="tabs-gestion">
<h3>Número de Directivos que evaluaron la gestión de sus docentes</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Directivos que realizaron evaluación de la gestión</td>
			<td>Número Total de Docentes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*95.4*/for(facultad <- directivosGestionEvaluadosPorFacultad) yield /*95.58*/{_display_(Seq[Any](format.raw/*95.59*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*97.9*/facultad/*97.17*/.getNombre())),format.raw/*97.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*98.9*/facultad/*98.17*/.getParticipantes())),format.raw/*98.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*99.9*/facultad/*99.17*/.getTotal())),format.raw/*99.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*100.9*/formato/*100.16*/.format(facultad.getPorcentaje()))),format.raw/*100.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*102.4*/("""
		</tbody>
	    </table>
</div>
<div id="tabs-investigacion">
<h3>Número de Directivos que evaluaron investigación</h3>
		<table>
		<tbody>
		<tr>
			<td>Facultad</td>
			<td>Directivos que realizaron evaluación de investigación</td>
			<td>Número Total de Docentes</td>
			<td>Porcentaje</td>
		</tr>
		"""),_display_(Seq[Any](/*116.4*/for(facultad <- directivosInvestigacionEvaluadosPorFacultad) yield /*116.64*/{_display_(Seq[Any](format.raw/*116.65*/("""
		 <tr>
			<td>"""),_display_(Seq[Any](/*118.9*/facultad/*118.17*/.getNombre())),format.raw/*118.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*119.9*/facultad/*119.17*/.getParticipantes())),format.raw/*119.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*120.9*/facultad/*120.17*/.getTotal())),format.raw/*120.28*/("""</td>
			<td>"""),_display_(Seq[Any](/*121.9*/formato/*121.16*/.format(facultad.getPorcentaje()))),format.raw/*121.49*/(""" %</td>
		</tr>
		""")))})),format.raw/*123.4*/("""
		</tbody>
	    </table>
</div>
</div> <!-- tabs -->
""")))})),format.raw/*128.2*/("""
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(estudiantesEvaluadosPorFacultad:List[Facultad],docentesEvaluadosPorEstudiantesPorFacultad:List[Facultad],docentesConAutoevaluacionPorFacultad:List[Facultad],directivosGestionEvaluadosPorFacultad:List[Facultad],directivosInvestigacionEvaluadosPorFacultad:List[Facultad],semestre:String): play.api.templates.HtmlFormat.Appendable = apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre)
    
    def f:((List[Facultad],List[Facultad],List[Facultad],List[Facultad],List[Facultad],String) => play.api.templates.HtmlFormat.Appendable) = (estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre) => apply(estudiantesEvaluadosPorFacultad,docentesEvaluadosPorEstudiantesPorFacultad,docentesConAutoevaluacionPorFacultad,directivosGestionEvaluadosPorFacultad,directivosInvestigacionEvaluadosPorFacultad,semestre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:49 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informeparticipantes.scala.html
=======
                    DATE: Fri Jul 04 16:10:12 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeparticipantes.scala.html
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    HASH: d16e1452736fa763892a3e3bd089fec856c69fd0
                    MATRIX: 873->1|1338->320|1365->374|1477->451|1506->459|1550->468|1596->505|1644->515|2221->1057|2285->1105|2324->1106|2376->1123|2393->1131|2427->1143|2476->1157|2493->1165|2534->1184|2583->1198|2600->1206|2633->1217|2682->1231|2698->1238|2753->1271|2803->1290|3123->1575|3198->1634|3237->1635|3289->1652|3306->1660|3340->1672|3389->1686|3406->1694|3447->1713|3496->1727|3513->1735|3546->1746|3595->1760|3611->1767|3666->1800|3716->1819|4062->2130|4131->2183|4170->2184|4222->2201|4239->2209|4273->2221|4322->2235|4339->2243|4380->2262|4429->2276|4446->2284|4479->2295|4528->2309|4544->2316|4599->2349|4649->2368|4994->2678|5064->2732|5103->2733|5155->2750|5172->2758|5206->2770|5255->2784|5272->2792|5313->2811|5362->2825|5379->2833|5412->2844|5462->2858|5479->2865|5535->2898|5586->2917|5928->3223|6005->3283|6045->3284|6098->3301|6116->3309|6151->3321|6201->3335|6219->3343|6261->3362|6311->3376|6329->3384|6363->3395|6413->3409|6430->3416|6486->3449|6537->3468|6624->3523
                    LINES: 26->1|36->5|37->8|38->9|38->9|40->11|40->11|40->11|59->30|59->30|59->30|61->32|61->32|61->32|62->33|62->33|62->33|63->34|63->34|63->34|64->35|64->35|64->35|66->37|80->51|80->51|80->51|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|85->56|85->56|85->56|87->58|103->74|103->74|103->74|105->76|105->76|105->76|106->77|106->77|106->77|107->78|107->78|107->78|108->79|108->79|108->79|110->81|124->95|124->95|124->95|126->97|126->97|126->97|127->98|127->98|127->98|128->99|128->99|128->99|129->100|129->100|129->100|131->102|145->116|145->116|145->116|147->118|147->118|147->118|148->119|148->119|148->119|149->120|149->120|149->120|150->121|150->121|150->121|152->123|157->128
                    -- GENERATED --
                */
            