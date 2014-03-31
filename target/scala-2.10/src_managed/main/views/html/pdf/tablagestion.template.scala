
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
	
<table border='1'>
<tbody>
        <tr>
        <td class="row_headers" rowspan='2' style="font-size: 8pt; width='4cm'">Enunciado</td>
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
     	  """),_display_(Seq[Any](/*30.10*/defining(new DecimalFormat("##0.00"))/*30.47*/{formato=>_display_(Seq[Any](format.raw/*30.57*/("""
          """),_display_(Seq[Any](/*31.12*/defining(Pregunta.getPreguntasEvaluacion(Pregunta.GESTION))/*31.71*/{preguntas=>_display_(Seq[Any](format.raw/*31.83*/("""
	          """),_display_(Seq[Any](/*32.13*/for(i<-inicio to fin) yield /*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
	          """),_display_(Seq[Any](/*33.13*/defining(evaluacionGestion.getPreguntas().get(evaluacionGestion.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()))))/*33.145*/{pregunta=>_display_(Seq[Any](format.raw/*33.156*/("""
	       	        <tr>
	       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*35.47*/pregunta/*35.55*/.getEnunciado())),format.raw/*35.70*/("""</td>
	       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*36.47*/pregunta/*36.55*/.getNumeroRespuestasNivel()/*36.82*/(Nivel.INFERIOR))),format.raw/*36.98*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*37.47*/formato/*37.54*/.format(pregunta.getPorecentajeNivel()(Nivel.INFERIOR)))),format.raw/*37.109*/("""%</td>
	            	<td style="font-size: 8pt;">"""),_display_(Seq[Any](/*38.44*/pregunta/*38.52*/.getNumeroRespuestasNivel()/*38.79*/(Nivel.BAJO))),format.raw/*38.91*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*39.47*/formato/*39.54*/.format(pregunta.getPorecentajeNivel()(Nivel.BAJO)))),format.raw/*39.105*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*40.47*/pregunta/*40.55*/.getNumeroRespuestasNivel()/*40.82*/(Nivel.MEDIO))),format.raw/*40.95*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*41.47*/formato/*41.54*/.format(pregunta.getPorecentajeNivel()(Nivel.MEDIO)))),format.raw/*41.106*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*42.47*/pregunta/*42.55*/.getNumeroRespuestasNivel()/*42.82*/(Nivel.ALTO))),format.raw/*42.94*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*43.47*/formato/*43.54*/.format(pregunta.getPorecentajeNivel()(Nivel.ALTO)))),format.raw/*43.105*/("""%</td>
	             
	                </tr>
	    			""")))})),format.raw/*46.10*/("""
	           """)))})),format.raw/*47.14*/("""
		
	        """)))})),format.raw/*49.11*/("""
	        
       
        <tr>
	       	        <td style="font-size: 8pt;">Promedio</td>
	       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*54.47*/formato/*54.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*54.120*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*55.47*/formato/*55.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.INFERIOR)))),format.raw/*55.120*/("""%</td>
	               	<td style="font-size: 8pt;">"""),_display_(Seq[Any](/*56.47*/formato/*56.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*56.116*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*57.47*/formato/*57.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.BAJO)))),format.raw/*57.116*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*58.47*/formato/*58.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*58.117*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*59.47*/formato/*59.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.MEDIO)))),format.raw/*59.117*/("""%</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*60.47*/formato/*60.54*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*60.116*/("""</td>
	                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*61.47*/formato/*61.54*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.ALTO)))),format.raw/*61.116*/("""%</td>
	   

	                </tr>
	         """)))})),format.raw/*65.12*/("""        
            </tbody>
</table>
"""))}
    }
    
    def render(evaluacionGestion:EvaluacionGestion,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.HtmlFormat.Appendable = apply(evaluacionGestion,titulo,saber,inicio,fin)
    
    def f:((EvaluacionGestion,String,Int,Int,Int) => play.api.templates.HtmlFormat.Appendable) = (evaluacionGestion,titulo,saber,inicio,fin) => apply(evaluacionGestion,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 20:33:24 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/tablagestion.scala.html
                    HASH: 556fac22aba60fd73e0e9f864527a10f8c354c28
                    MATRIX: 815->1|1069->85|1096->163|1157->189|1184->195|2357->1332|2403->1369|2451->1379|2499->1391|2567->1450|2617->1462|2666->1475|2703->1496|2743->1498|2792->1511|2934->1643|2984->1654|3089->1723|3106->1731|3143->1746|3231->1798|3248->1806|3284->1833|3322->1849|3410->1901|3426->1908|3504->1963|3590->2013|3607->2021|3643->2048|3677->2060|3765->2112|3781->2119|3855->2170|3944->2223|3961->2231|3997->2258|4032->2271|4120->2323|4136->2330|4211->2382|4300->2435|4317->2443|4353->2470|4387->2482|4475->2534|4491->2541|4565->2592|4651->2646|4697->2660|4743->2674|4916->2811|4932->2818|5021->2884|5109->2936|5125->2943|5214->3009|5303->3062|5319->3069|5404->3131|5492->3183|5508->3190|5593->3252|5682->3305|5698->3312|5784->3375|5872->3427|5888->3434|5974->3497|6063->3550|6079->3557|6164->3619|6252->3671|6268->3678|6353->3740|6432->3787
                    LINES: 26->1|34->1|35->5|35->5|35->5|60->30|60->30|60->30|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|65->35|65->35|65->35|66->36|66->36|66->36|66->36|67->37|67->37|67->37|68->38|68->38|68->38|68->38|69->39|69->39|69->39|70->40|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|72->42|72->42|73->43|73->43|73->43|76->46|77->47|79->49|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|95->65
                    -- GENERATED --
                */
            