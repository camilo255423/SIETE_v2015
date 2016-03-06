
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
"""),_display_(Seq[Any](/*6.2*/if(!evaluacionInvestigacion.getPreguntas().get(0).getEnunciado().equals(""))/*6.78*/{_display_(Seq[Any](format.raw/*6.79*/("""	
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
""")))}/*72.2*/else/*72.6*/{_display_(Seq[Any](format.raw/*72.7*/("""
Sin Evaluación 
""")))})))}
    }
    
    def render(evaluacionInvestigacion:EvaluacionInvestigacion,titulo:String,saber:Int,inicio:Int,fin:Int): play.api.templates.HtmlFormat.Appendable = apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def f:((EvaluacionInvestigacion,String,Int,Int,Int) => play.api.templates.HtmlFormat.Appendable) = (evaluacionInvestigacion,titulo,saber,inicio,fin) => apply(evaluacionInvestigacion,titulo,saber,inicio,fin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 06 11:27:28 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/tablainvestigacion.scala.html
                    HASH: 5771783173a0c8b7b6dbc0ee9e0cb3a21a31a462
                    MATRIX: 827->1|1093->97|1120->175|1181->201|1208->207|1250->215|1334->291|1372->292|2438->1322|2484->1359|2532->1369|2580->1381|2654->1446|2704->1458|2753->1471|2790->1492|2830->1494|2879->1507|3033->1651|3083->1662|3188->1731|3205->1739|3242->1754|3306->1782|3323->1790|3359->1817|3397->1833|3461->1861|3477->1868|3554->1923|3616->1949|3633->1957|3669->1984|3703->1996|3767->2024|3783->2031|3856->2082|3921->2111|3938->2119|3974->2146|4009->2159|4073->2187|4089->2194|4163->2246|4228->2275|4245->2283|4281->2310|4315->2322|4379->2350|4395->2357|4468->2408|4533->2437|4550->2445|4586->2472|4624->2488|4688->2516|4704->2523|4781->2578|4852->2617|4898->2631|4944->2645|5104->2769|5120->2776|5215->2848|5279->2876|5295->2883|5390->2955|5455->2984|5471->2991|5561->3059|5625->3087|5641->3094|5731->3162|5796->3191|5812->3198|5903->3267|5967->3295|5983->3302|6074->3371|6139->3400|6155->3407|6245->3475|6309->3503|6325->3510|6415->3578|6480->3607|6496->3614|6591->3686|6655->3714|6671->3721|6766->3793|6839->3834|6897->3874|6909->3878|6947->3879
                    LINES: 26->1|34->1|35->5|35->5|35->5|36->6|36->6|36->6|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|66->36|66->36|66->36|67->37|67->37|67->37|67->37|68->38|68->38|68->38|69->39|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|73->43|74->44|74->44|74->44|75->45|75->45|75->45|75->45|76->46|76->46|76->46|78->48|79->49|81->51|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|99->69|102->72|102->72|102->72
                    -- GENERATED --
                */
            