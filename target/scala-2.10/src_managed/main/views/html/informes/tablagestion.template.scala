
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
object tablagestion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionGestion,String,Int,Int,Int,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionGestion:EvaluacionGestion, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta

import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.1*/("""<div class="titulotabla">"""),_display_(Seq[Any](/*5.27*/titulo)),format.raw/*5.33*/("""</div>
	
<table>
<tbody>
        <tr>
        <td class="row_headers" rowspan=2>Enunciado</td>
		<td class="row_headers" colspan=2>No Cumple</td>
		<td class="row_headers" colspan=2>Cumple Parcialmente</td>
		<td class="row_headers" colspan=2>Cumple Totalmente</td>
		<td class="row_headers" colspan=2>No Aplica</td>
		
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
              
             
          </tr>
     	  """),_display_(Seq[Any](/*30.10*/defining(new DecimalFormat("##0.00"))/*30.47*/{formato=>_display_(Seq[Any](format.raw/*30.57*/("""
          """),_display_(Seq[Any](/*31.12*/defining(Pregunta.getPreguntasEvaluacion(Pregunta.GESTION))/*31.71*/{preguntas=>_display_(Seq[Any](format.raw/*31.83*/("""
	          """),_display_(Seq[Any](/*32.13*/for(i<-inicio to fin) yield /*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
	          """),_display_(Seq[Any](/*33.13*/defining(evaluacionGestion.getPreguntas().get(evaluacionGestion.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo()))))/*33.145*/{pregunta=>_display_(Seq[Any](format.raw/*33.156*/("""
	       	        <tr>
	       	        <td>"""),_display_(Seq[Any](/*35.23*/pregunta/*35.31*/.getEnunciado())),format.raw/*35.46*/("""</td>
	       	        <td>"""),_display_(Seq[Any](/*36.23*/pregunta/*36.31*/.getNumeroRespuestasNivel()/*36.58*/(Nivel.INFERIOR))),format.raw/*36.74*/("""</td>
	                <td>"""),_display_(Seq[Any](/*37.23*/formato/*37.30*/.format(pregunta.getPorecentajeNivel()(Nivel.INFERIOR)))),format.raw/*37.85*/("""%</td>
	            	<td>"""),_display_(Seq[Any](/*38.20*/pregunta/*38.28*/.getNumeroRespuestasNivel()/*38.55*/(Nivel.BAJO))),format.raw/*38.67*/("""</td>
	                <td>"""),_display_(Seq[Any](/*39.23*/formato/*39.30*/.format(pregunta.getPorecentajeNivel()(Nivel.BAJO)))),format.raw/*39.81*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*40.23*/pregunta/*40.31*/.getNumeroRespuestasNivel()/*40.58*/(Nivel.MEDIO))),format.raw/*40.71*/("""</td>
	                <td>"""),_display_(Seq[Any](/*41.23*/formato/*41.30*/.format(pregunta.getPorecentajeNivel()(Nivel.MEDIO)))),format.raw/*41.82*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*42.23*/pregunta/*42.31*/.getNumeroRespuestasNivel()/*42.58*/(Nivel.ALTO))),format.raw/*42.70*/("""</td>
	                <td>"""),_display_(Seq[Any](/*43.23*/formato/*43.30*/.format(pregunta.getPorecentajeNivel()(Nivel.ALTO)))),format.raw/*43.81*/("""%</td>
	             
	                </tr>
	    			""")))})),format.raw/*46.10*/("""
	           """)))})),format.raw/*47.14*/("""
		
	        """)))})),format.raw/*49.11*/("""
	        
       
        <tr>
	       	        <td>Promedio</td>
	       	        <td>"""),_display_(Seq[Any](/*54.23*/formato/*54.30*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*54.96*/("""</td>
	                <td>"""),_display_(Seq[Any](/*55.23*/formato/*55.30*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.INFERIOR)))),format.raw/*55.96*/("""%</td>
	               	<td>"""),_display_(Seq[Any](/*56.23*/formato/*56.30*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*56.92*/("""</td>
	                <td>"""),_display_(Seq[Any](/*57.23*/formato/*57.30*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.BAJO)))),format.raw/*57.92*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*58.23*/formato/*58.30*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*58.93*/("""</td>
	                <td>"""),_display_(Seq[Any](/*59.23*/formato/*59.30*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.MEDIO)))),format.raw/*59.93*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*60.23*/formato/*60.30*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*60.92*/("""</td>
	                <td>"""),_display_(Seq[Any](/*61.23*/formato/*61.30*/.format(evaluacionGestion.getPromedioPorcentaje()(Nivel.ALTO)))),format.raw/*61.92*/("""%</td>
	   

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
                    DATE: Thu Mar 27 21:27:49 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/tablagestion.scala.html
                    HASH: 0370bc6c6889d623e94c06987393802acec54bb5
                    MATRIX: 820->1|1074->85|1101->163|1162->189|1189->195|2017->987|2063->1024|2111->1034|2159->1046|2227->1105|2277->1117|2326->1130|2363->1151|2403->1153|2452->1166|2594->1298|2644->1309|2725->1354|2742->1362|2779->1377|2843->1405|2860->1413|2896->1440|2934->1456|2998->1484|3014->1491|3091->1546|3153->1572|3170->1580|3206->1607|3240->1619|3304->1647|3320->1654|3393->1705|3458->1734|3475->1742|3511->1769|3546->1782|3610->1810|3626->1817|3700->1869|3765->1898|3782->1906|3818->1933|3852->1945|3916->1973|3932->1980|4005->2031|4091->2085|4137->2099|4183->2113|4308->2202|4324->2209|4412->2275|4476->2303|4492->2310|4580->2376|4645->2405|4661->2412|4745->2474|4809->2502|4825->2509|4909->2571|4974->2600|4990->2607|5075->2670|5139->2698|5155->2705|5240->2768|5305->2797|5321->2804|5405->2866|5469->2894|5485->2901|5569->2963|5648->3010
                    LINES: 26->1|34->1|35->5|35->5|35->5|60->30|60->30|60->30|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|65->35|65->35|65->35|66->36|66->36|66->36|66->36|67->37|67->37|67->37|68->38|68->38|68->38|68->38|69->39|69->39|69->39|70->40|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|72->42|72->42|73->43|73->43|73->43|76->46|77->47|79->49|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|95->65
                    -- GENERATED --
                */
            