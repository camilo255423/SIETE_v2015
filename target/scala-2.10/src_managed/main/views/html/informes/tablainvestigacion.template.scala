
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
object tablainvestigacion extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionInvestigacion,String,Int,Int,Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionInvestigacion:EvaluacionInvestigacion, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.Html = {
        _display_ {import models.Pregunta

import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.1*/("""<div class="titulotabla">"""),_display_(Seq[Any](/*5.27*/titulo)),format.raw/*5.33*/("""</div>
	
<table>
<tbody>
   <tr>
        <td class="row_headers" rowspan=2>Enunciado</td>
		<td class="row_headers" colspan=2>Nivel<br>Inferior</td>
		<td class="row_headers" colspan=2>Nivel<br>Bajo</td>
		<td class="row_headers" colspan=2>Nivel<br>Medio</td>
		<td class="row_headers" colspan=2>Nivel<br>Alto</td>
		<td class="row_headers" colspan=2>Nivel<br>Superior</td>
	     </tr>
	     <tr>
		
                <td class="row_headers">Resp.</td>
                <td class="row_headers">%</td>
                <td class="row_headers">Resp.</td>
                <td class="row_headers">%</td>
                <td class="row_headers">Resp.</td>
                <td class="row_headers">%</td>
                <td class="row_headers">Resp.</td>
                <td class="row_headers">%</td>
                <td class="row_headers">Resp.</td>
                <td class="row_headers">%</td>
             
          </tr>
     	  """),_display_(Seq[Any](/*31.10*/defining(new DecimalFormat("##0.00"))/*31.47*/{formato=>_display_(Seq[Any](format.raw/*31.57*/("""
          """),_display_(Seq[Any](/*32.12*/defining(Pregunta.getPreguntasEvaluacion(Pregunta.INVESTIGACION))/*32.77*/{preguntas=>_display_(Seq[Any](format.raw/*32.89*/("""
	          """),_display_(Seq[Any](/*33.13*/for(i<-inicio to fin) yield /*33.34*/ {_display_(Seq[Any](format.raw/*33.36*/("""
	          """),_display_(Seq[Any](/*34.13*/defining(evaluacionInvestigacion.getPreguntas().get(evaluacionInvestigacion.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()))))/*34.157*/{pregunta=>_display_(Seq[Any](format.raw/*34.168*/("""
	       	        <tr>
	       	        <td>"""),_display_(Seq[Any](/*36.23*/pregunta/*36.31*/.getEnunciado())),format.raw/*36.46*/("""</td>
	       	        <td>"""),_display_(Seq[Any](/*37.23*/pregunta/*37.31*/.getNumeroRespuestasNivel()/*37.58*/(Nivel.INFERIOR))),format.raw/*37.74*/("""</td>
	                <td>"""),_display_(Seq[Any](/*38.23*/formato/*38.30*/.format(pregunta.getPorecentajeNivel()(Nivel.INFERIOR)))),format.raw/*38.85*/("""%</td>
	            	<td>"""),_display_(Seq[Any](/*39.20*/pregunta/*39.28*/.getNumeroRespuestasNivel()/*39.55*/(Nivel.BAJO))),format.raw/*39.67*/("""</td>
	                <td>"""),_display_(Seq[Any](/*40.23*/formato/*40.30*/.format(pregunta.getPorecentajeNivel()(Nivel.BAJO)))),format.raw/*40.81*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*41.23*/pregunta/*41.31*/.getNumeroRespuestasNivel()/*41.58*/(Nivel.MEDIO))),format.raw/*41.71*/("""</td>
	                <td>"""),_display_(Seq[Any](/*42.23*/formato/*42.30*/.format(pregunta.getPorecentajeNivel()(Nivel.MEDIO)))),format.raw/*42.82*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*43.23*/pregunta/*43.31*/.getNumeroRespuestasNivel()/*43.58*/(Nivel.ALTO))),format.raw/*43.70*/("""</td>
	                <td>"""),_display_(Seq[Any](/*44.23*/formato/*44.30*/.format(pregunta.getPorecentajeNivel()(Nivel.ALTO)))),format.raw/*44.81*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*45.23*/pregunta/*45.31*/.getNumeroRespuestasNivel()/*45.58*/(Nivel.SUPERIOR))),format.raw/*45.74*/("""</td>
	                <td>"""),_display_(Seq[Any](/*46.23*/formato/*46.30*/.format(pregunta.getPorecentajeNivel()(Nivel.SUPERIOR)))),format.raw/*46.85*/("""%</td>
	                </tr>
	    			""")))})),format.raw/*48.10*/("""
	           """)))})),format.raw/*49.14*/("""
		
	        """)))})),format.raw/*51.11*/("""
	        
        
        
        <tr>
	       	        <td>Promedio</td>
	       	        <td>"""),_display_(Seq[Any](/*57.23*/formato/*57.30*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*57.102*/("""</td>
	                <td>"""),_display_(Seq[Any](/*58.23*/formato/*58.30*/.format(evaluacionInvestigacion.getPromedioPorcentaje()(Nivel.INFERIOR)))),format.raw/*58.102*/("""%</td>
	               	<td>"""),_display_(Seq[Any](/*59.23*/formato/*59.30*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*59.98*/("""</td>
	                <td>"""),_display_(Seq[Any](/*60.23*/formato/*60.30*/.format(evaluacionInvestigacion.getPromedioPorcentaje()(Nivel.BAJO)))),format.raw/*60.98*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*61.23*/formato/*61.30*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*61.99*/("""</td>
	                <td>"""),_display_(Seq[Any](/*62.23*/formato/*62.30*/.format(evaluacionInvestigacion.getPromedioPorcentaje()(Nivel.MEDIO)))),format.raw/*62.99*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*63.23*/formato/*63.30*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*63.98*/("""</td>
	                <td>"""),_display_(Seq[Any](/*64.23*/formato/*64.30*/.format(evaluacionInvestigacion.getPromedioPorcentaje()(Nivel.ALTO)))),format.raw/*64.98*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*65.23*/formato/*65.30*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*65.102*/("""</td>
	                <td>"""),_display_(Seq[Any](/*66.23*/formato/*66.30*/.format(evaluacionInvestigacion.getPromedioPorcentaje()(Nivel.SUPERIOR)))),format.raw/*66.102*/("""%</td>

	                </tr>
	        """)))})),format.raw/*69.11*/("""        
            </tbody>
</table>
"""))}
    }
    
    def render(evaluacionInvestigacion:EvaluacionInvestigacion,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.Html = apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def f:((EvaluacionInvestigacion,String,Int,Int,Int) => play.api.templates.Html) = (evaluacionInvestigacion,titulo,saber,inicio,fin) => apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:05 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/tablainvestigacion.scala.html
                    HASH: 56d51d37958e97b0415238c49ead5d7c12b15aec
                    MATRIX: 781->1|1030->97|1057->175|1118->201|1145->207|2110->1136|2156->1173|2204->1183|2252->1195|2326->1260|2376->1272|2425->1285|2462->1306|2502->1308|2551->1321|2705->1465|2755->1476|2836->1521|2853->1529|2890->1544|2954->1572|2971->1580|3007->1607|3045->1623|3109->1651|3125->1658|3202->1713|3264->1739|3281->1747|3317->1774|3351->1786|3415->1814|3431->1821|3504->1872|3569->1901|3586->1909|3622->1936|3657->1949|3721->1977|3737->1984|3811->2036|3876->2065|3893->2073|3929->2100|3963->2112|4027->2140|4043->2147|4116->2198|4181->2227|4198->2235|4234->2262|4272->2278|4336->2306|4352->2313|4429->2368|4500->2407|4546->2421|4592->2435|4727->2534|4743->2541|4838->2613|4902->2641|4918->2648|5013->2720|5078->2749|5094->2756|5184->2824|5248->2852|5264->2859|5354->2927|5419->2956|5435->2963|5526->3032|5590->3060|5606->3067|5697->3136|5762->3165|5778->3172|5868->3240|5932->3268|5948->3275|6038->3343|6103->3372|6119->3379|6214->3451|6278->3479|6294->3486|6389->3558|6462->3599
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|66->36|66->36|66->36|67->37|67->37|67->37|67->37|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|78->48|79->49|81->51|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|99->69
                    -- GENERATED --
                */
            