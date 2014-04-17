
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
object informeprofesor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,Profesor,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, autoEvaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.258*/("""
<div id="informe">
<h2 style="text-align: center;">"""),_display_(Seq[Any](/*3.34*/profesor/*3.42*/.getApellidos())),format.raw/*3.57*/(""" """),_display_(Seq[Any](/*3.59*/profesor/*3.67*/.getNombres())),format.raw/*3.80*/(""" - Informe Detallado """),_display_(Seq[Any](/*3.102*/semestre)),format.raw/*3.110*/("""</h2>
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Docencia</a></li>
			<li><a href="#tabs-gestion">Gestión</a></li>
			<li><a href="#tabs-investigacion">Investigación</a></li>
			
		</ul>
 	<div id="tabs-docencia">       
	"""),_display_(Seq[Any](/*12.3*/for(evaluacion <- evaluacionMateria) yield /*12.39*/{_display_(Seq[Any](format.raw/*12.40*/("""
	"""),_display_(Seq[Any](/*13.3*/if(evaluacion.getTipoEvaluacion()==EvaluacionMateria.EVALUACION)/*13.67*/{_display_(Seq[Any](format.raw/*13.68*/("""
	<h2>"""),_display_(Seq[Any](/*14.7*/evaluacion/*14.17*/.getMateria().getNombre())),format.raw/*14.42*/(""", grupo """),_display_(Seq[Any](/*14.51*/evaluacion/*14.61*/.getMateria().getGrupo())),format.raw/*14.85*/("""</h2>
	<div class="tabs">
		<ul>
			<li><a href="#tabs-estudiantes">Estudiantes</a></li>
			<li><a href="#tabs-autoevaluacion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-estudiantes">	

	<h4> Encuestados: """),_display_(Seq[Any](/*23.21*/evaluacion/*23.31*/.getEvaluados())),format.raw/*23.46*/(""" de """),_display_(Seq[Any](/*23.51*/evaluacion/*23.61*/.getMateria().getInscritos())),format.raw/*23.89*/(""", 
porcentaje """),_display_(Seq[Any](/*24.13*/(10000*evaluacion.getEvaluados()/evaluacion.getMateria().getInscritos()/100.0))),format.raw/*24.91*/("""% </h4>
	
	"""),_display_(Seq[Any](/*26.3*/tabladocencia(evaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*26.72*/("""
	
	"""),_display_(Seq[Any](/*28.3*/tabladocencia(evaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*28.71*/("""
	
	"""),_display_(Seq[Any](/*30.3*/tabladocencia(evaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*30.72*/("""
	"""),_display_(Seq[Any](/*31.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*31.83*/{_display_(Seq[Any](format.raw/*31.84*/("""
	<div class="titulotabla">Observaciones</div>
		<table>
		<tbody>
	
		     """),_display_(Seq[Any](/*36.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*36.60*/{_display_(Seq[Any](format.raw/*36.61*/("""
		     <tr>
	           <td>- """),_display_(Seq[Any](/*38.20*/observaciones)),format.raw/*38.33*/("""</td>  
	          </tr>
	          """)))})),format.raw/*40.13*/("""
	    </tbody>
	    </table>
	""")))})),format.raw/*43.3*/("""	   
	</div>
	
	<div id="tabs-autoevaluacion">	
	"""),_display_(Seq[Any](/*47.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*47.125*/{indice=>_display_(Seq[Any](format.raw/*47.134*/("""
		"""),_display_(Seq[Any](/*48.4*/if(indice>=0)/*48.17*/{_display_(Seq[Any](format.raw/*48.18*/("""
		"""),_display_(Seq[Any](/*49.4*/defining(evaluacionMateria.get(indice))/*49.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*49.60*/("""
		"""),_display_(Seq[Any](/*50.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*50.77*/("""
		
		"""),_display_(Seq[Any](/*52.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*52.76*/("""
		
		"""),_display_(Seq[Any](/*54.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*54.77*/("""
		""")))})),format.raw/*55.4*/("""
		
	""")))}/*57.3*/else/*57.7*/{_display_(Seq[Any](format.raw/*57.8*/("""
	<h1>Sin autoevaluación</h1>
		""")))})),format.raw/*59.4*/("""
	""")))})),format.raw/*60.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*66.2*/(""" 
""")))})),format.raw/*67.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
		<ul>
			<li><a href="#tabs-evalgestion">Directivos</a></li>
			<li><a href="#tabs-autoevalgestion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-evalgestion">
	"""),_display_(Seq[Any](/*77.3*/tablagestion(evaluacionGestion,"Gestión",Pregunta.GESTION, 0,6))),format.raw/*77.66*/("""	
	</div>
	<div id="tabs-autoevalgestion">	
	"""),_display_(Seq[Any](/*80.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*80.85*/("""
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
	"""),_display_(Seq[Any](/*92.3*/tablainvestigacion(evaluacionInvestigacion,"Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*92.90*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion">	
	"""),_display_(Seq[Any](/*95.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*95.109*/("""
	</div>
</div>
</div>
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,autoEvaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,Profesor,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre) => apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 15 15:03:45 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprofesor.scala.html
                    HASH: d56df9d7f4d94037a995845db7909618866a36fb
                    MATRIX: 910->1|1261->257|1349->310|1365->318|1401->333|1438->335|1454->343|1488->356|1546->378|1576->386|1849->624|1901->660|1940->661|1978->664|2051->728|2090->729|2132->736|2151->746|2198->771|2243->780|2262->790|2308->814|2558->1028|2577->1038|2614->1053|2655->1058|2674->1068|2724->1096|2775->1111|2875->1189|2922->1201|3013->1270|3053->1275|3143->1343|3183->1348|3274->1417|3312->1420|3401->1500|3440->1501|3552->1578|3619->1629|3658->1630|3726->1662|3761->1675|3830->1712|3892->1743|3977->1793|4109->1915|4157->1924|4196->1928|4218->1941|4257->1942|4296->1946|4344->1985|4399->2002|4438->2006|4533->2079|4575->2086|4669->2158|4711->2165|4806->2238|4841->2242|4865->2248|4877->2252|4915->2253|4979->2286|5013->2289|5112->2357|5146->2360|5420->2599|5505->2662|5586->2708|5690->2790|5983->3048|6092->3135|6179->3187|6308->3293
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|54->26|54->26|56->28|56->28|58->30|58->30|59->31|59->31|59->31|64->36|64->36|64->36|66->38|66->38|68->40|71->43|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|78->50|78->50|80->52|80->52|82->54|82->54|83->55|85->57|85->57|85->57|87->59|88->60|94->66|95->67|105->77|105->77|108->80|108->80|120->92|120->92|123->95|123->95
                    -- GENERATED --
                */
            