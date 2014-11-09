
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
object tabladocencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionMateria,String,Int,Int,Int,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:EvaluacionMateria, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta

import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.1*/("""<div class="titulotabla">"""),_display_(Seq[Any](/*5.27*/titulo)),format.raw/*5.33*/("""</div>
	
<table>
<tbody>
        <tr>
        <td class="row_headers" rowspan='2'>Enunciado</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Inferior</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Bajo</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Medio</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Alto</td>
		<td class="row_headers" colspan='2'>Nivel<br></br>Superior</td>
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
          """),_display_(Seq[Any](/*32.12*/defining(Pregunta.getPreguntasEvaluacion(Pregunta.DOCENCIA))/*32.72*/{preguntas=>_display_(Seq[Any](format.raw/*32.84*/("""
	          """),_display_(Seq[Any](/*33.13*/for(i<-inicio to fin) yield /*33.34*/ {_display_(Seq[Any](format.raw/*33.36*/("""
	          """),_display_(Seq[Any](/*34.13*/defining(evaluacionMateria.getPreguntas().indexOf(new Pregunta(preguntas.get(i).getTitulo())))/*34.107*/{indice=>_display_(Seq[Any](format.raw/*34.116*/("""
	          """),_display_(Seq[Any](/*35.13*/if(indice>=0)/*35.26*/{_display_(Seq[Any](format.raw/*35.27*/("""
		          """),_display_(Seq[Any](/*36.14*/defining(evaluacionMateria.getPreguntas().get(indice))/*36.68*/{pregunta=>_display_(Seq[Any](format.raw/*36.79*/("""
		       	        <tr>
		       	        <td >"""),_display_(Seq[Any](/*38.25*/pregunta/*38.33*/.getEnunciado())),format.raw/*38.48*/("""</td>
		       	        <td>"""),_display_(Seq[Any](/*39.24*/pregunta/*39.32*/.getNumeroRespuestasNivel()/*39.59*/(Nivel.INFERIOR))),format.raw/*39.75*/("""</td>
		                <td>"""),_display_(Seq[Any](/*40.24*/formato/*40.31*/.format(pregunta.getPorecentajeNivel()(Nivel.INFERIOR)))),format.raw/*40.86*/("""%</td>
		            	<td>"""),_display_(Seq[Any](/*41.21*/pregunta/*41.29*/.getNumeroRespuestasNivel()/*41.56*/(Nivel.BAJO))),format.raw/*41.68*/("""</td>
		                <td>"""),_display_(Seq[Any](/*42.24*/formato/*42.31*/.format(pregunta.getPorecentajeNivel()(Nivel.BAJO)))),format.raw/*42.82*/("""%</td>
		                <td>"""),_display_(Seq[Any](/*43.24*/pregunta/*43.32*/.getNumeroRespuestasNivel()/*43.59*/(Nivel.MEDIO))),format.raw/*43.72*/("""</td>
		                <td>"""),_display_(Seq[Any](/*44.24*/formato/*44.31*/.format(pregunta.getPorecentajeNivel()(Nivel.MEDIO)))),format.raw/*44.83*/("""%</td>
		                <td>"""),_display_(Seq[Any](/*45.24*/pregunta/*45.32*/.getNumeroRespuestasNivel()/*45.59*/(Nivel.ALTO))),format.raw/*45.71*/("""</td>
		                <td>"""),_display_(Seq[Any](/*46.24*/formato/*46.31*/.format(pregunta.getPorecentajeNivel()(Nivel.ALTO)))),format.raw/*46.82*/("""%</td>
		                <td>"""),_display_(Seq[Any](/*47.24*/pregunta/*47.32*/.getNumeroRespuestasNivel()/*47.59*/(Nivel.SUPERIOR))),format.raw/*47.75*/("""</td>
		                <td>"""),_display_(Seq[Any](/*48.24*/formato/*48.31*/.format(pregunta.getPorecentajeNivel()(Nivel.SUPERIOR)))),format.raw/*48.86*/("""%</td>
		                </tr>
		    			""")))})),format.raw/*50.11*/("""
		       
	               """)))})),format.raw/*52.18*/("""
	           """)))})),format.raw/*53.14*/("""
	      
	        """)))})),format.raw/*55.11*/("""
	               	<tr>
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
<<<<<<< HEAD
                    DATE: Sun Aug 03 10:49:42 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/informes/tabladocencia.scala.html
=======
                    DATE: Sun Oct 19 18:18:40 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/tabladocencia.scala.html
>>>>>>> 6244fb43d76038bddb46480d133358e1ff9c6a6c
                    HASH: 9d0bc739a9ddbfc2332dfe1f928667bc556ea720
                    MATRIX: 821->1|1075->85|1102->163|1163->189|1190->195|2197->1166|2243->1203|2291->1213|2339->1225|2408->1285|2458->1297|2507->1310|2544->1331|2584->1333|2633->1346|2737->1440|2785->1449|2834->1462|2856->1475|2895->1476|2945->1490|3008->1544|3057->1555|3141->1603|3158->1611|3195->1626|3260->1655|3277->1663|3313->1690|3351->1706|3416->1735|3432->1742|3509->1797|3572->1824|3589->1832|3625->1859|3659->1871|3724->1900|3740->1907|3813->1958|3879->1988|3896->1996|3932->2023|3967->2036|4032->2065|4048->2072|4122->2124|4188->2154|4205->2162|4241->2189|4275->2201|4340->2230|4356->2237|4429->2288|4495->2318|4512->2326|4548->2353|4586->2369|4651->2398|4667->2405|4744->2460|4817->2501|4877->2529|4923->2543|4974->2562|5090->2642|5106->2649|5202->2722|5266->2750|5282->2757|5378->2830|5443->2859|5459->2866|5550->2935|5614->2963|5630->2970|5721->3039|5786->3068|5802->3075|5895->3145|5959->3173|5975->3180|6068->3250|6133->3279|6149->3286|6240->3355|6304->3383|6320->3390|6411->3459|6476->3488|6492->3495|6588->3568|6652->3596|6668->3603|6764->3676|6837->3717|6889->3737
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|65->35|66->36|66->36|66->36|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|77->47|77->47|77->47|77->47|78->48|78->48|78->48|80->50|82->52|83->53|85->55|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|97->67|97->67|100->70|102->72
                    -- GENERATED --
                */
            