
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
object tabladocencia extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[EvaluacionMateria,String,Int,Int,Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:EvaluacionMateria, titulo:String, saber:Int, inicio:Int, fin:Int):play.api.templates.Html = {
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
    
    def render(evaluacionMateria:EvaluacionMateria,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.Html = apply(evaluacionMateria,titulo,saber,inicio,fin)
    
    def f:((EvaluacionMateria,String,Int,Int,Int) => play.api.templates.Html) = (evaluacionMateria,titulo,saber,inicio,fin) => apply(evaluacionMateria,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:05 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/tabladocencia.scala.html
                    HASH: 65b4335ecad6eb70893f39930721044d93ac9851
                    MATRIX: 770->1|1007->85|1034->163|1095->189|1122->195|2129->1166|2175->1203|2223->1213|2271->1225|2340->1285|2390->1297|2439->1310|2476->1331|2516->1333|2565->1346|2669->1440|2717->1449|2766->1462|2788->1475|2827->1476|2877->1490|2940->1544|2989->1555|3073->1603|3090->1611|3127->1626|3192->1655|3209->1663|3245->1690|3283->1706|3348->1735|3364->1742|3441->1797|3504->1824|3521->1832|3557->1859|3591->1871|3656->1900|3672->1907|3745->1958|3811->1988|3828->1996|3864->2023|3899->2036|3964->2065|3980->2072|4054->2124|4120->2154|4137->2162|4173->2189|4207->2201|4272->2230|4288->2237|4361->2288|4427->2318|4444->2326|4480->2353|4518->2369|4583->2398|4599->2405|4676->2460|4749->2501|4809->2529|4855->2543|4906->2562|5022->2642|5038->2649|5134->2722|5198->2750|5214->2757|5310->2830|5375->2859|5391->2866|5482->2935|5546->2963|5562->2970|5653->3039|5718->3068|5734->3075|5827->3145|5891->3173|5907->3180|6000->3250|6065->3279|6081->3286|6172->3355|6236->3383|6252->3390|6343->3459|6408->3488|6424->3495|6520->3568|6584->3596|6600->3603|6696->3676|6769->3717|6821->3737
                    LINES: 26->1|34->1|35->5|35->5|35->5|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|65->35|66->36|66->36|66->36|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|77->47|77->47|77->47|77->47|78->48|78->48|78->48|80->50|82->52|83->53|85->55|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|97->67|97->67|100->70|102->72
                    -- GENERATED --
                */
            