
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
object tablainvestigacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionInvestigacion,String,Int,Int,Int,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionInvestigacion:EvaluacionInvestigacion, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.HtmlFormat.Appendable = {
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
    
    def render(evaluacionInvestigacion:EvaluacionInvestigacion,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.HtmlFormat.Appendable = apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def f:((EvaluacionInvestigacion,String,Int,Int,Int) => play.api.templates.HtmlFormat.Appendable) = (evaluacionInvestigacion,titulo,saber,inicio,fin) => apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 17 11:31:04 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/tablainvestigacion.scala.html
                    HASH: 3d42d601dafaa1a5dd701cac535985b1e47b0c35
                    MATRIX: 827->1|1093->97|1120->175|1181->201|1208->207|2281->1244|2327->1281|2375->1291|2423->1303|2497->1368|2547->1380|2596->1393|2633->1414|2673->1416|2722->1429|2876->1573|2926->1584|3031->1653|3048->1661|3085->1676|3149->1704|3166->1712|3202->1739|3240->1755|3304->1783|3320->1790|3397->1845|3459->1871|3476->1879|3512->1906|3546->1918|3610->1946|3626->1953|3699->2004|3764->2033|3781->2041|3817->2068|3852->2081|3916->2109|3932->2116|4006->2168|4071->2197|4088->2205|4124->2232|4158->2244|4222->2272|4238->2279|4311->2330|4376->2359|4393->2367|4429->2394|4467->2410|4531->2438|4547->2445|4624->2500|4695->2539|4741->2553|4787->2567|4947->2691|4963->2698|5058->2770|5122->2798|5138->2805|5233->2877|5298->2906|5314->2913|5404->2981|5468->3009|5484->3016|5574->3084|5639->3113|5655->3120|5746->3189|5810->3217|5826->3224|5917->3293|5982->3322|5998->3329|6088->3397|6152->3425|6168->3432|6258->3500|6323->3529|6339->3536|6434->3608|6498->3636|6514->3643|6609->3715|6682->3756
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|66->36|66->36|66->36|67->37|67->37|67->37|67->37|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|78->48|79->49|81->51|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|99->69
                    -- GENERATED --
                */
            