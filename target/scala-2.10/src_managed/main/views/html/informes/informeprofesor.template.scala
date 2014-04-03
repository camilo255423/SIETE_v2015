
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
object informeprofesor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, autoEvaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.224*/("""
<div id="informe">
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Docencia</a></li>
			<li><a href="#tabs-gestion">Gestión</a></li>
			<li><a href="#tabs-investigacion">Investigación</a></li>
			
		</ul>
 	<div id="tabs-docencia">       
	"""),_display_(Seq[Any](/*11.3*/for(evaluacion <- evaluacionMateria) yield /*11.39*/{_display_(Seq[Any](format.raw/*11.40*/("""
	"""),_display_(Seq[Any](/*12.3*/if(evaluacion.getTipoEvaluacion()==EvaluacionMateria.EVALUACION)/*12.67*/{_display_(Seq[Any](format.raw/*12.68*/("""
	<h2>"""),_display_(Seq[Any](/*13.7*/evaluacion/*13.17*/.getMateria().getNombre())),format.raw/*13.42*/(""", grupo """),_display_(Seq[Any](/*13.51*/evaluacion/*13.61*/.getMateria().getGrupo())),format.raw/*13.85*/("""</h2>
	<div class="tabs">
		<ul>
			<li><a href="#tabs-estudiantes">Estudiantes</a></li>
			<li><a href="#tabs-autoevaluacion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-estudiantes">	

	<h4> Encuestados: """),_display_(Seq[Any](/*22.21*/evaluacion/*22.31*/.getEvaluados())),format.raw/*22.46*/(""" de """),_display_(Seq[Any](/*22.51*/evaluacion/*22.61*/.getMateria().getInscritos())),format.raw/*22.89*/(""", 
porcentaje """),_display_(Seq[Any](/*23.13*/(10000*evaluacion.getEvaluados()/evaluacion.getMateria().getInscritos()/100.0))),format.raw/*23.91*/("""% </h4>
	
	"""),_display_(Seq[Any](/*25.3*/tabladocencia(evaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*25.72*/("""
	
	"""),_display_(Seq[Any](/*27.3*/tabladocencia(evaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*27.71*/("""
	
	"""),_display_(Seq[Any](/*29.3*/tabladocencia(evaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*29.72*/("""
	"""),_display_(Seq[Any](/*30.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*30.83*/{_display_(Seq[Any](format.raw/*30.84*/("""
	<div class="titulotabla">Observaciones</div>
		<table>
		<tbody>
	
		     """),_display_(Seq[Any](/*35.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*35.60*/{_display_(Seq[Any](format.raw/*35.61*/("""
		     <tr>
	           <td>- """),_display_(Seq[Any](/*37.20*/observaciones)),format.raw/*37.33*/("""</td>  
	          </tr>
	          """)))})),format.raw/*39.13*/("""
	    </tbody>
	    </table>
		   
	</div>
	""")))})),format.raw/*44.3*/("""
	<div id="tabs-autoevaluacion">	
	"""),_display_(Seq[Any](/*46.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*46.125*/{indice=>_display_(Seq[Any](format.raw/*46.134*/("""
		"""),_display_(Seq[Any](/*47.4*/if(indice>=0)/*47.17*/{_display_(Seq[Any](format.raw/*47.18*/("""
		"""),_display_(Seq[Any](/*48.4*/defining(evaluacionMateria.get(indice))/*48.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*48.60*/("""
		"""),_display_(Seq[Any](/*49.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*49.77*/("""
		
		"""),_display_(Seq[Any](/*51.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*51.76*/("""
		
		"""),_display_(Seq[Any](/*53.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*53.77*/("""
		""")))})),format.raw/*54.4*/("""
		
	""")))}/*56.3*/else/*56.7*/{_display_(Seq[Any](format.raw/*56.8*/("""
	<h1>Sin autoevaluación</h1>
		""")))})),format.raw/*58.4*/("""
	""")))})),format.raw/*59.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*65.2*/(""" 
""")))})),format.raw/*66.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
		<ul>
			<li><a href="#tabs-evalgestion">Directivos</a></li>
			<li><a href="#tabs-autoevalgestion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-evalgestion">
	"""),_display_(Seq[Any](/*76.3*/tablagestion(evaluacionGestion,"Gestión",Pregunta.GESTION, 0,6))),format.raw/*76.66*/("""	
	</div>
	<div id="tabs-autoevalgestion">	
	"""),_display_(Seq[Any](/*79.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*79.85*/("""
	</div>
</div>
</div>
<div id="tabs-investigacion">
<div class="tabs">
		<ul>
			<li><a href="#tabs-evalinvestigacion">Directivos</a></li>
			<li><a href="#tabs-autoevalinvestigacion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-evalinvestigacion">
	"""),_display_(Seq[Any](/*91.3*/tablainvestigacion(evaluacionInvestigacion,"Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*91.90*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion">	
	"""),_display_(Seq[Any](/*94.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*94.109*/("""
	</div>
</div>
</div>
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,autoEvaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion) => apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 02 13:48:45 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprofesor.scala.html
                    HASH: 95092790b80785dd0aa0dc1430082fae0ddd80ae
                    MATRIX: 894->1|1211->223|1498->475|1550->511|1589->512|1627->515|1700->579|1739->580|1781->587|1800->597|1847->622|1892->631|1911->641|1957->665|2207->879|2226->889|2263->904|2304->909|2323->919|2373->947|2424->962|2524->1040|2571->1052|2662->1121|2702->1126|2792->1194|2832->1199|2923->1268|2961->1271|3050->1351|3089->1352|3201->1429|3268->1480|3307->1481|3375->1513|3410->1526|3479->1563|3555->1608|3626->1644|3758->1766|3806->1775|3845->1779|3867->1792|3906->1793|3945->1797|3993->1836|4048->1853|4087->1857|4182->1930|4224->1937|4318->2009|4360->2016|4455->2089|4490->2093|4514->2099|4526->2103|4564->2104|4628->2137|4662->2140|4761->2208|4795->2211|5069->2450|5154->2513|5235->2559|5339->2641|5632->2899|5741->2986|5828->3038|5957->3144
                    LINES: 26->1|29->1|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|53->25|53->25|55->27|55->27|57->29|57->29|58->30|58->30|58->30|63->35|63->35|63->35|65->37|65->37|67->39|72->44|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|79->51|79->51|81->53|81->53|82->54|84->56|84->56|84->56|86->58|87->59|93->65|94->66|104->76|104->76|107->79|107->79|119->91|119->91|122->94|122->94
                    -- GENERATED --
                */
            