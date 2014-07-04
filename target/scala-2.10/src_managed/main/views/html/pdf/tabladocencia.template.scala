
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
object tabladocencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionMateria,String,Int,Int,Int,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:EvaluacionMateria, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta

import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.1*/("""<div class="titulotabla">"""),_display_(Seq[Any](/*5.27*/titulo)),format.raw/*5.33*/("""</div>
	
<table border='1'>
<tbody>
        <tr style="font-size: 8pt;">
        <td class="row_headers" rowspan='2' width='7cm'>Enunciado</td>
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
          """),_display_(Seq[Any](/*32.12*/defining(Pregunta.getPreguntasEvaluacion(Pregunta.DOCENCIA))/*32.72*/{preguntas=>_display_(Seq[Any](format.raw/*32.84*/("""
	          """),_display_(Seq[Any](/*33.13*/for(i<-inicio to fin) yield /*33.34*/ {_display_(Seq[Any](format.raw/*33.36*/("""
	          """),_display_(Seq[Any](/*34.13*/defining(evaluacionMateria.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo())))/*34.107*/{indice=>_display_(Seq[Any](format.raw/*34.116*/("""
	          """),_display_(Seq[Any](/*35.13*/if(indice>=0)/*35.26*/{_display_(Seq[Any](format.raw/*35.27*/("""
		          """),_display_(Seq[Any](/*36.14*/defining(evaluacionMateria.getPreguntas().get(indice))/*36.68*/{pregunta=>_display_(Seq[Any](format.raw/*36.79*/("""
		       	        <tr>
		       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*38.48*/pregunta/*38.56*/.getEnunciado())),format.raw/*38.71*/("""</td>
		       	        <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*39.48*/pregunta/*39.56*/.getNumeroRespuestasNivel()/*39.83*/(Nivel.INFERIOR))),format.raw/*39.99*/("""</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*40.48*/formato/*40.55*/.format(pregunta.getPorecentajeNivel()(Nivel.INFERIOR)))),format.raw/*40.110*/("""%</td>
		            	<td style="font-size: 8pt;">"""),_display_(Seq[Any](/*41.45*/pregunta/*41.53*/.getNumeroRespuestasNivel()/*41.80*/(Nivel.BAJO))),format.raw/*41.92*/("""</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*42.48*/formato/*42.55*/.format(pregunta.getPorecentajeNivel()(Nivel.BAJO)))),format.raw/*42.106*/("""%</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*43.48*/pregunta/*43.56*/.getNumeroRespuestasNivel()/*43.83*/(Nivel.MEDIO))),format.raw/*43.96*/("""</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*44.48*/formato/*44.55*/.format(pregunta.getPorecentajeNivel()(Nivel.MEDIO)))),format.raw/*44.107*/("""%</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*45.48*/pregunta/*45.56*/.getNumeroRespuestasNivel()/*45.83*/(Nivel.ALTO))),format.raw/*45.95*/("""</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*46.48*/formato/*46.55*/.format(pregunta.getPorecentajeNivel()(Nivel.ALTO)))),format.raw/*46.106*/("""%</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*47.48*/pregunta/*47.56*/.getNumeroRespuestasNivel()/*47.83*/(Nivel.SUPERIOR))),format.raw/*47.99*/("""</td>
		                <td style="font-size: 8pt;">"""),_display_(Seq[Any](/*48.48*/formato/*48.55*/.format(pregunta.getPorecentajeNivel()(Nivel.SUPERIOR)))),format.raw/*48.110*/("""%</td>
		                </tr>
		    			""")))})),format.raw/*50.11*/("""
		       
	               """)))})),format.raw/*52.18*/("""
	           """)))})),format.raw/*53.14*/("""
	      
	        """)))})),format.raw/*55.11*/("""
	               	<tr style="font-size: 8pt;">
	       	        <td>Promedio</td>
	       	        <td>"""),_display_(Seq[Any](/*58.23*/formato/*58.30*/.format(evaluacionMateria.getPromedioRespuestas()(saber)(Nivel.INFERIOR)))),format.raw/*58.103*/("""</td>
	                <td>"""),_display_(Seq[Any](/*59.23*/formato/*59.30*/.format(evaluacionMateria.getPromedioPorcentaje()(saber)(Nivel.INFERIOR)))),format.raw/*59.103*/("""%</td>
	               	<td>"""),_display_(Seq[Any](/*60.23*/formato/*60.30*/.format(evaluacionMateria.getPromedioRespuestas()(saber)(Nivel.BAJO)))),format.raw/*60.99*/("""</td>
	                <td>"""),_display_(Seq[Any](/*61.23*/formato/*61.30*/.format(evaluacionMateria.getPromedioPorcentaje()(saber)(Nivel.BAJO)))),format.raw/*61.99*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*62.23*/formato/*62.30*/.format(evaluacionMateria.getPromedioRespuestas()(saber)(Nivel.MEDIO)))),format.raw/*62.100*/("""</td>
	                <td>"""),_display_(Seq[Any](/*63.23*/formato/*63.30*/.format(evaluacionMateria.getPromedioPorcentaje()(saber)(Nivel.MEDIO)))),format.raw/*63.100*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*64.23*/formato/*64.30*/.format(evaluacionMateria.getPromedioRespuestas()(saber)(Nivel.ALTO)))),format.raw/*64.99*/("""</td>
	                <td>"""),_display_(Seq[Any](/*65.23*/formato/*65.30*/.format(evaluacionMateria.getPromedioPorcentaje()(saber)(Nivel.ALTO)))),format.raw/*65.99*/("""%</td>
	                <td>"""),_display_(Seq[Any](/*66.23*/formato/*66.30*/.format(evaluacionMateria.getPromedioRespuestas()(saber)(Nivel.SUPERIOR)))),format.raw/*66.103*/("""</td>
	                <td>"""),_display_(Seq[Any](/*67.23*/formato/*67.30*/.format(evaluacionMateria.getPromedioPorcentaje()(saber)(Nivel.SUPERIOR)))),format.raw/*67.103*/("""%</td>

	                </tr>
	        """)))})),format.raw/*70.11*/("""
	        
        """)))})),format.raw/*72.10*/("""
            </tbody>
</table>"""))}
    }
    
    def render(evaluacionMateria:EvaluacionMateria,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,titulo,saber,inicio,fin)
    
    def f:((EvaluacionMateria,String,Int,Int,Int) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,titulo,saber,inicio,fin) => apply(evaluacionMateria,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon May 12 13:05:43 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/tabladocencia.scala.html
                    HASH: bd06cbd1330ea664551ff81cc25892afaf3bb008
                    MATRIX: 816->1|1070->85|1097->163|1158->189|1185->195|2263->1237|2309->1274|2357->1284|2405->1296|2474->1356|2524->1368|2573->1381|2610->1402|2650->1404|2699->1417|2803->1511|2851->1520|2900->1533|2922->1546|2961->1547|3011->1561|3074->1615|3123->1626|3230->1697|3247->1705|3284->1720|3373->1773|3390->1781|3426->1808|3464->1824|3553->1877|3569->1884|3647->1939|3734->1990|3751->1998|3787->2025|3821->2037|3910->2090|3926->2097|4000->2148|4090->2202|4107->2210|4143->2237|4178->2250|4267->2303|4283->2310|4358->2362|4448->2416|4465->2424|4501->2451|4535->2463|4624->2516|4640->2523|4714->2574|4804->2628|4821->2636|4857->2663|4895->2679|4984->2732|5000->2739|5078->2794|5151->2835|5211->2863|5257->2877|5308->2896|5448->3000|5464->3007|5560->3080|5624->3108|5640->3115|5736->3188|5801->3217|5817->3224|5908->3293|5972->3321|5988->3328|6079->3397|6144->3426|6160->3433|6253->3503|6317->3531|6333->3538|6426->3608|6491->3637|6507->3644|6598->3713|6662->3741|6678->3748|6769->3817|6834->3846|6850->3853|6946->3926|7010->3954|7026->3961|7122->4034|7195->4075|7247->4095
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|65->35|66->36|66->36|66->36|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|77->47|77->47|77->47|77->47|78->48|78->48|78->48|80->50|82->52|83->53|85->55|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|97->67|97->67|100->70|102->72
                    -- GENERATED --
                */
            