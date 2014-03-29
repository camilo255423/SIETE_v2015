
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
object tablainvestigacion extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionInvestigacion,String,Int,Int,Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionInvestigacion:EvaluacionInvestigacion, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.Html = {
        _display_ {import models.Pregunta

import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.1*/("""<div class="titulotabla">"""),_display_(Seq[Any](/*5.27*/titulo)),format.raw/*5.33*/("""</div>
	
<table border='1'>
<tbody>
   <tr style="font-size: 8pt;">
        <td class="row_headers" rowspan='2' width='4cm'>Enunciado</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Inferior</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Bajo</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Medio</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Alto</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Superior</td>
	     </tr>
	     <tr style="font-size: 8pt;">
		
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
	       	        <tr style="font-size: 8pt;">
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
	        
        
        
        <tr style="font-size: 8pt;">
	       	        <td >Promedio</td>
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
                    DATE: Fri Mar 28 10:07:48 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/tablainvestigacion.scala.html
                    HASH: 9eb74f83eb064428547e5ac9228bf4f2eb598f4a
                    MATRIX: 776->1|1025->97|1052->175|1113->201|1140->207|2213->1244|2259->1281|2307->1291|2355->1303|2429->1368|2479->1380|2528->1393|2565->1414|2605->1416|2654->1429|2808->1573|2858->1584|2963->1653|2980->1661|3017->1676|3081->1704|3098->1712|3134->1739|3172->1755|3236->1783|3252->1790|3329->1845|3391->1871|3408->1879|3444->1906|3478->1918|3542->1946|3558->1953|3631->2004|3696->2033|3713->2041|3749->2068|3784->2081|3848->2109|3864->2116|3938->2168|4003->2197|4020->2205|4056->2232|4090->2244|4154->2272|4170->2279|4243->2330|4308->2359|4325->2367|4361->2394|4399->2410|4463->2438|4479->2445|4556->2500|4627->2539|4673->2553|4719->2567|4879->2691|4895->2698|4990->2770|5054->2798|5070->2805|5165->2877|5230->2906|5246->2913|5336->2981|5400->3009|5416->3016|5506->3084|5571->3113|5587->3120|5678->3189|5742->3217|5758->3224|5849->3293|5914->3322|5930->3329|6020->3397|6084->3425|6100->3432|6190->3500|6255->3529|6271->3536|6366->3608|6430->3636|6446->3643|6541->3715|6614->3756
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|66->36|66->36|66->36|67->37|67->37|67->37|67->37|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|78->48|79->49|81->51|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|99->69
                    -- GENERATED --
                */
            