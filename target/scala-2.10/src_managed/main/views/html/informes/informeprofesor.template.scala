
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

	<h4> Encuestados: """),_display_(Seq[Any](/*24.21*/evaluacion/*24.31*/.getEvaluados())),format.raw/*24.46*/(""" de """),_display_(Seq[Any](/*24.51*/evaluacion/*24.61*/.getMateria().getInscritos())),format.raw/*24.89*/(""", 
porcentaje """),_display_(Seq[Any](/*25.13*/(10000*evaluacion.getEvaluados()/evaluacion.getMateria().getInscritos()/100.0))),format.raw/*25.91*/("""% </h4>
	 	
	
	"""),_display_(Seq[Any](/*28.3*/tabladocencia(evaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*28.72*/("""
	
	"""),_display_(Seq[Any](/*30.3*/tabladocencia(evaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*30.71*/("""
	
	"""),_display_(Seq[Any](/*32.3*/tabladocencia(evaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*32.72*/("""
	"""),_display_(Seq[Any](/*33.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*33.83*/{_display_(Seq[Any](format.raw/*33.84*/("""
	<div class="titulotabla">Observaciones</div>
		<table>
		<tbody>
	
		     """),_display_(Seq[Any](/*38.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*38.60*/{_display_(Seq[Any](format.raw/*38.61*/("""
		     <tr>
	           <td>- """),_display_(Seq[Any](/*40.20*/observaciones)),format.raw/*40.33*/("""</td>  
	          </tr>
	          """)))})),format.raw/*42.13*/("""
	    </tbody>
	    </table>
	""")))})),format.raw/*45.3*/("""	
  
	</div>
	
	<div id="tabs-autoevaluacion">	
	"""),_display_(Seq[Any](/*50.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*50.125*/{indice=>_display_(Seq[Any](format.raw/*50.134*/("""
		"""),_display_(Seq[Any](/*51.4*/if(indice>=0)/*51.17*/{_display_(Seq[Any](format.raw/*51.18*/("""
		"""),_display_(Seq[Any](/*52.4*/defining(evaluacionMateria.get(indice))/*52.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*52.60*/("""
		"""),_display_(Seq[Any](/*53.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*53.77*/("""
		
		"""),_display_(Seq[Any](/*55.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*55.76*/("""
		
		"""),_display_(Seq[Any](/*57.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*57.77*/("""
		""")))})),format.raw/*58.4*/("""
		
	""")))}/*60.3*/else/*60.7*/{_display_(Seq[Any](format.raw/*60.8*/("""
	<h1>Sin autoevaluación</h1>
		""")))})),format.raw/*62.4*/("""
	""")))})),format.raw/*63.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*69.2*/(""" 
""")))})),format.raw/*70.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
		<ul>
			<li><a href="#tabs-evalgestion">Directivos</a></li>
			<li><a href="#tabs-autoevalgestion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-evalgestion">
	"""),_display_(Seq[Any](/*80.3*/tablagestion(evaluacionGestion,"Gestión",Pregunta.GESTION, 0,6))),format.raw/*80.66*/("""	
	</div>
	<div id="tabs-autoevalgestion">	
	"""),_display_(Seq[Any](/*83.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*83.85*/("""
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
	"""),_display_(Seq[Any](/*95.3*/tablainvestigacion(evaluacionInvestigacion,"Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*95.90*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion">	
	"""),_display_(Seq[Any](/*98.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*98.109*/("""
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
                    DATE: Sat Jun 20 11:21:46 COT 2015
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprofesor.scala.html
                    HASH: e10694e2d5b2ee5beae7d40b689d7f4ff02d7e8f
                    MATRIX: 910->1|1261->257|1349->310|1365->318|1401->333|1438->335|1454->343|1488->356|1546->378|1576->386|1849->624|1901->660|1940->661|1978->664|2051->728|2090->729|2132->736|2151->746|2198->771|2243->780|2262->790|2308->814|2559->1029|2578->1039|2615->1054|2656->1059|2675->1069|2725->1097|2776->1112|2876->1190|2927->1206|3018->1275|3058->1280|3148->1348|3188->1353|3279->1422|3317->1425|3406->1505|3445->1506|3557->1583|3624->1634|3663->1635|3731->1667|3766->1680|3835->1717|3897->1748|3982->1798|4114->1920|4162->1929|4201->1933|4223->1946|4262->1947|4301->1951|4349->1990|4404->2007|4443->2011|4538->2084|4580->2091|4674->2163|4716->2170|4811->2243|4846->2247|4870->2253|4882->2257|4920->2258|4984->2291|5018->2294|5117->2362|5151->2365|5425->2604|5510->2667|5591->2713|5695->2795|5988->3053|6097->3140|6184->3192|6313->3298
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|56->28|56->28|58->30|58->30|60->32|60->32|61->33|61->33|61->33|66->38|66->38|66->38|68->40|68->40|70->42|73->45|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|83->55|83->55|85->57|85->57|86->58|88->60|88->60|88->60|90->62|91->63|97->69|98->70|108->80|108->80|111->83|111->83|123->95|123->95|126->98|126->98
                    -- GENERATED --
                */
            