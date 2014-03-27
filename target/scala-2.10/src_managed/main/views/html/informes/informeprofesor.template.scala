
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
object informeprofesor extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, autoEvaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion):play.api.templates.Html = {
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
	<div id="tabs-autoevaluacion">	
	"""),_display_(Seq[Any](/*45.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*45.125*/{indice=>_display_(Seq[Any](format.raw/*45.134*/("""
		"""),_display_(Seq[Any](/*46.4*/if(indice>=0)/*46.17*/{_display_(Seq[Any](format.raw/*46.18*/("""
		"""),_display_(Seq[Any](/*47.4*/defining(evaluacionMateria.get(indice))/*47.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*47.60*/("""
		"""),_display_(Seq[Any](/*48.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*48.77*/("""
		
		"""),_display_(Seq[Any](/*50.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*50.76*/("""
		
		"""),_display_(Seq[Any](/*52.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*52.77*/("""
		""")))})),format.raw/*53.4*/("""
		
	""")))}/*55.3*/else/*55.7*/{_display_(Seq[Any](format.raw/*55.8*/("""
	<h1>Sin autoevaluación</h1>
		""")))})),format.raw/*57.4*/("""
	""")))})),format.raw/*58.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*64.2*/(""" 
""")))})),format.raw/*65.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
		<ul>
			<li><a href="#tabs-evalgestion">Directivos</a></li>
			<li><a href="#tabs-autoevalgestion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-evalgestion">
	"""),_display_(Seq[Any](/*75.3*/tablagestion(evaluacionGestion,"Gestión",Pregunta.GESTION, 0,6))),format.raw/*75.66*/("""	
	</div>
	<div id="tabs-autoevalgestion">	
	"""),_display_(Seq[Any](/*78.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*78.85*/("""
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
	"""),_display_(Seq[Any](/*90.3*/tablainvestigacion(evaluacionInvestigacion,"Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*90.90*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion">	
	"""),_display_(Seq[Any](/*93.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*93.109*/("""
	</div>
</div>
</div>
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,autoEvaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.Html = apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion) => play.api.templates.Html) = (evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion) => apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 24 19:20:31 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprofesor.scala.html
                    HASH: 05a366cf7ccf917ac315f8eaafd77830c36e95f0
                    MATRIX: 843->1|1143->223|1430->475|1482->511|1521->512|1559->515|1632->579|1671->580|1713->587|1732->597|1779->622|1824->631|1843->641|1889->665|2139->879|2158->889|2195->904|2236->909|2255->919|2305->947|2356->962|2456->1040|2503->1052|2594->1121|2634->1126|2724->1194|2764->1199|2855->1268|2969->1347|3036->1398|3075->1399|3143->1431|3178->1444|3247->1481|3360->1559|3492->1681|3540->1690|3579->1694|3601->1707|3640->1708|3679->1712|3727->1751|3782->1768|3821->1772|3916->1845|3958->1852|4052->1924|4094->1931|4189->2004|4224->2008|4248->2014|4260->2018|4298->2019|4362->2052|4396->2055|4495->2123|4529->2126|4803->2365|4888->2428|4969->2474|5073->2556|5366->2814|5475->2901|5562->2953|5691->3059
                    LINES: 26->1|29->1|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|53->25|53->25|55->27|55->27|57->29|57->29|63->35|63->35|63->35|65->37|65->37|67->39|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|78->50|78->50|80->52|80->52|81->53|83->55|83->55|83->55|85->57|86->58|92->64|93->65|103->75|103->75|106->78|106->78|118->90|118->90|121->93|121->93
                    -- GENERATED --
                */
            