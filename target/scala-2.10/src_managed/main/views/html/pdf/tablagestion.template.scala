
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
object tablagestion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionGestion,String,Int,Int,Int,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionGestion:EvaluacionGestion, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta

import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.1*/("""<div class="titulotabla">"""),_display_(Seq[Any](/*5.27*/titulo)),format.raw/*5.33*/("""</div>
"""),_display_(Seq[Any](/*6.2*/if(!evaluacionGestion.getPreguntas().get(0).getEnunciado().equals(""))/*6.72*/{_display_(Seq[Any](format.raw/*6.73*/("""
          
<table border='1'>
<tbody>
        <tr>
        <td class="row_headers" rowspan='2' style="font-size: 8pt;" width='7cm'>Enunciado</td>
		<td class="row_headers" colspan='2' style="font-size: 8pt;">No Cumple</td>
		<td class="row_headers" colspan='2' style="font-size: 8pt;">Cumple Parcialmente</td>
		<td class="row_headers" colspan='2' style="font-size: 8pt;">Cumple Totalmente</td>
		<td class="row_headers" colspan='2' style="font-size: 8pt;">No Aplica</td>
		
	     </tr>
	     <tr>
		
                <td class="row_headers" style="font-size: 8pt;">Resp.</td>
                <td class="row_headers" style="font-size: 8pt;">%</td>
                <td class="row_headers" style="font-size: 8pt;">Resp.</td>
                <td class="row_headers" style="font-size: 8pt;">%</td>
                <td class="row_headers" style="font-size: 8pt;">Resp.</td>
                <td class="row_headers" style="font-size: 8pt;">%</td>
                <td class="row_headers" style="font-size: 8pt;">Resp.</td>
                <td class="row_headers" style="font-size: 8pt;">%</td>
              
             
          </tr>
          
     	  """),_display_(Seq[Any](/*32.10*/defining(new DecimalFormat("##0.00"))/*32.47*/{formato=>_display_(Seq[Any](format.raw/*32.57*/("""
          """),_display_(Seq[Any](/*33.12*/defining(Pregunta.getPreguntasEvaluacion(Pregunta.GESTION))/*33.71*/{preguntas=>_display_(Seq[Any](format.raw/*33.83*/("""
	          """),_display_(Seq[Any](/*34.13*/for(i<-inicio to fin) yield /*34.34*/ {_display_(Seq[Any](format.raw/*34.36*/("""
	          """),_display_(Seq[Any](/*35.13*/defining(evaluacionGestion.getPreguntas().get(evaluacionGestion.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()))))/*35.145*/{pregunta=>_display_(Seq[Any](format.raw/*35.156*/("""
	       	        <tr>
	       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*37.47*/pregunta/*37.55*/.getEnunciado())),format.raw/*37.70*/("""</td>
	       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*38.47*/pregunta/*38.55*/.getNumeroRespuestasNivel()/*38.82*/(Nivel.INFERIOR))),format.raw/*38.98*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*39.47*/formato/*39.54*/.format(pregunta.getPorecentajeNivel()(Nivel.INFERIOR)))),format.raw/*39.109*/("""%</td>
	            	<td style="font-size: 8pt;">"""),_display_(Seq[Any](/*40.44*/pregunta/*40.52*/.getNumeroRespuestasNivel()/*40.79*/(Nivel.BAJO))),format.raw/*40.91*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*41.47*/formato/*41.54*/.format(pregunta.getPorecentajeNivel()(Nivel.BAJO)))),format.raw/*41.105*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*42.47*/pregunta/*42.55*/.getNumeroRespuestasNivel()/*42.82*/(Nivel.MEDIO))),format.raw/*42.95*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*43.47*/formato/*43.54*/.format(pregunta.getPorecentajeNivel()(Nivel.MEDIO)))),format.raw/*43.106*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*44.47*/pregunta/*44.55*/.getNumeroRespuestasNivel()/*44.82*/(Nivel.ALTO))),format.raw/*44.94*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*45.47*/formato/*45.54*/.format(pregunta.getPorecentajeNivel()(Nivel.ALTO)))),format.raw/*45.105*/("""%</td>
	             
	                </tr>
	    			""")))})),format.raw/*48.10*/("""
	           """)))})),format.raw/*49.14*/("""
		
	        """)))})),format.raw/*51.11*/("""
	        
       
        <tr>
	       	        <td style="font-size: 8pt;">Promedio</td>
	       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*56.47*/formato/*56.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*56.120*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*57.47*/formato/*57.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.INFERIOR)))),format.raw/*57.120*/("""%</td>
	               	<td style="font-size: 8pt;">"""),_display_(Seq[Any](/*58.47*/formato/*58.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*58.116*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*59.47*/formato/*59.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.BAJO)))),format.raw/*59.116*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*60.47*/formato/*60.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*60.117*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*61.47*/formato/*61.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.MEDIO)))),format.raw/*61.117*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*62.47*/formato/*62.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*62.116*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*63.47*/formato/*63.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.ALTO)))),format.raw/*63.116*/("""%</td>
	   

	                </tr>
	         """)))})),format.raw/*67.12*/("""        
            </tbody>
</table>
""")))}/*70.2*/else/*70.6*/{_display_(Seq[Any](format.raw/*70.7*/("""
Sin Evaluación 
""")))})))}
    }
    
    def render(evaluacionGestion:EvaluacionGestion,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.HtmlFormat.Appendable = apply(evaluacionGestion,titulo,saber,inicio,fin)
    
    def f:((EvaluacionGestion,String,Int,Int,Int) => play.api.templates.HtmlFormat.Appendable) = (evaluacionGestion,titulo,saber,inicio,fin) => apply(evaluacionGestion,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 03 10:49:40 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/pdf/tablagestion.scala.html
                    HASH: a5b12623ad8041a0308471893f9c591dc28b02e0
                    MATRIX: 815->1|1069->85|1096->163|1157->189|1184->195|1226->203|1304->273|1342->274|2529->1425|2575->1462|2623->1472|2671->1484|2739->1543|2789->1555|2838->1568|2875->1589|2915->1591|2964->1604|3106->1736|3156->1747|3261->1816|3278->1824|3315->1839|3403->1891|3420->1899|3456->1926|3494->1942|3582->1994|3598->2001|3676->2056|3762->2106|3779->2114|3815->2141|3849->2153|3937->2205|3953->2212|4027->2263|4116->2316|4133->2324|4169->2351|4204->2364|4292->2416|4308->2423|4383->2475|4472->2528|4489->2536|4525->2563|4559->2575|4647->2627|4663->2634|4737->2685|4823->2739|4869->2753|4915->2767|5088->2904|5104->2911|5193->2977|5281->3029|5297->3036|5386->3102|5475->3155|5491->3162|5576->3224|5664->3276|5680->3283|5765->3345|5854->3398|5870->3405|5956->3468|6044->3520|6060->3527|6146->3590|6235->3643|6251->3650|6336->3712|6424->3764|6440->3771|6525->3833|6604->3880|6662->3920|6674->3924|6712->3925
                    LINES: 26->1|34->1|35->5|35->5|35->5|36->6|36->6|36->6|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|65->35|67->37|67->37|67->37|68->38|68->38|68->38|68->38|69->39|69->39|69->39|70->40|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|74->44|75->45|75->45|75->45|78->48|79->49|81->51|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|97->67|100->70|100->70|100->70
                    -- GENERATED --
                */
            