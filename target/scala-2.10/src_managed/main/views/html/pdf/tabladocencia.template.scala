
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
object tabladocencia extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionMateria,String,Int,Int,Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:EvaluacionMateria, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.Html = {
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
    
    def render(evaluacionMateria:EvaluacionMateria,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.Html = apply(evaluacionMateria,titulo,saber,inicio,fin)
    
    def f:((EvaluacionMateria,String,Int,Int,Int) => play.api.templates.Html) = (evaluacionMateria,titulo,saber,inicio,fin) => apply(evaluacionMateria,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 10:07:50 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/tabladocencia.scala.html
                    HASH: 8360566861a82498500c7901991b3fbfc5b2967d
                    MATRIX: 765->1|1002->85|1029->163|1090->189|1117->195|2195->1237|2241->1274|2289->1284|2337->1296|2406->1356|2456->1368|2505->1381|2542->1402|2582->1404|2631->1417|2735->1511|2783->1520|2832->1533|2854->1546|2893->1547|2943->1561|3006->1615|3055->1626|3162->1697|3179->1705|3216->1720|3305->1773|3322->1781|3358->1808|3396->1824|3485->1877|3501->1884|3579->1939|3666->1990|3683->1998|3719->2025|3753->2037|3842->2090|3858->2097|3932->2148|4022->2202|4039->2210|4075->2237|4110->2250|4199->2303|4215->2310|4290->2362|4380->2416|4397->2424|4433->2451|4467->2463|4556->2516|4572->2523|4646->2574|4736->2628|4753->2636|4789->2663|4827->2679|4916->2732|4932->2739|5010->2794|5083->2835|5143->2863|5189->2877|5240->2896|5380->3000|5396->3007|5492->3080|5556->3108|5572->3115|5668->3188|5733->3217|5749->3224|5840->3293|5904->3321|5920->3328|6011->3397|6076->3426|6092->3433|6185->3503|6249->3531|6265->3538|6358->3608|6423->3637|6439->3644|6530->3713|6594->3741|6610->3748|6701->3817|6766->3846|6782->3853|6878->3926|6942->3954|6958->3961|7054->4034|7127->4075|7179->4095
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|65->35|66->36|66->36|66->36|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|77->47|77->47|77->47|77->47|78->48|78->48|78->48|80->50|82->52|83->53|85->55|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|97->67|97->67|100->70|102->72
                    -- GENERATED --
                */
            