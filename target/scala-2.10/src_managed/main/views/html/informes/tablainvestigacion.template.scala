
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
object tablainvestigacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionInvestigacion,String,Int,Int,Int,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionInvestigacion:EvaluacionInvestigacion, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.HtmlFormat.Appendable = {
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
    
    def render(evaluacionInvestigacion:EvaluacionInvestigacion,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.HtmlFormat.Appendable = apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def f:((EvaluacionInvestigacion,String,Int,Int,Int) => play.api.templates.HtmlFormat.Appendable) = (evaluacionInvestigacion,titulo,saber,inicio,fin) => apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 03 10:49:41 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/informes/tablainvestigacion.scala.html
                    HASH: c296f930956c485dde325dccb213c147778e3abe
                    MATRIX: 832->1|1098->97|1125->175|1186->201|1213->207|2178->1136|2224->1173|2272->1183|2320->1195|2394->1260|2444->1272|2493->1285|2530->1306|2570->1308|2619->1321|2773->1465|2823->1476|2904->1521|2921->1529|2958->1544|3022->1572|3039->1580|3075->1607|3113->1623|3177->1651|3193->1658|3270->1713|3332->1739|3349->1747|3385->1774|3419->1786|3483->1814|3499->1821|3572->1872|3637->1901|3654->1909|3690->1936|3725->1949|3789->1977|3805->1984|3879->2036|3944->2065|3961->2073|3997->2100|4031->2112|4095->2140|4111->2147|4184->2198|4249->2227|4266->2235|4302->2262|4340->2278|4404->2306|4420->2313|4497->2368|4568->2407|4614->2421|4660->2435|4795->2534|4811->2541|4906->2613|4970->2641|4986->2648|5081->2720|5146->2749|5162->2756|5252->2824|5316->2852|5332->2859|5422->2927|5487->2956|5503->2963|5594->3032|5658->3060|5674->3067|5765->3136|5830->3165|5846->3172|5936->3240|6000->3268|6016->3275|6106->3343|6171->3372|6187->3379|6282->3451|6346->3479|6362->3486|6457->3558|6530->3599
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|66->36|66->36|66->36|67->37|67->37|67->37|67->37|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|78->48|79->49|81->51|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|99->69
                    -- GENERATED --
                */
            