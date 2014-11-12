
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
		
	
	"""),_display_(Seq[Any](/*27.3*/tabladocencia(evaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*27.72*/("""
	
	"""),_display_(Seq[Any](/*29.3*/tabladocencia(evaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*29.71*/("""
	
	"""),_display_(Seq[Any](/*31.3*/tabladocencia(evaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*31.72*/("""
	"""),_display_(Seq[Any](/*32.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*32.83*/{_display_(Seq[Any](format.raw/*32.84*/("""
	<div class="titulotabla">Observaciones</div>
		<table>
		<tbody>
	
		     """),_display_(Seq[Any](/*37.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*37.60*/{_display_(Seq[Any](format.raw/*37.61*/("""
		     <tr>
	           <td>- """),_display_(Seq[Any](/*39.20*/observaciones)),format.raw/*39.33*/("""</td>  
	          </tr>
	          """)))})),format.raw/*41.13*/("""
	    </tbody>
	    </table>
	""")))})),format.raw/*44.3*/("""	
  
	</div>
	
	<div id="tabs-autoevaluacion">	
	"""),_display_(Seq[Any](/*49.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*49.125*/{indice=>_display_(Seq[Any](format.raw/*49.134*/("""
		"""),_display_(Seq[Any](/*50.4*/if(indice>=0)/*50.17*/{_display_(Seq[Any](format.raw/*50.18*/("""
		"""),_display_(Seq[Any](/*51.4*/defining(evaluacionMateria.get(indice))/*51.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*51.60*/("""
		"""),_display_(Seq[Any](/*52.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*52.77*/("""
		
		"""),_display_(Seq[Any](/*54.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*54.76*/("""
		
		"""),_display_(Seq[Any](/*56.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*56.77*/("""
		""")))})),format.raw/*57.4*/("""
		
	""")))}/*59.3*/else/*59.7*/{_display_(Seq[Any](format.raw/*59.8*/("""
	<h1>Sin autoevaluación</h1>
		""")))})),format.raw/*61.4*/("""
	""")))})),format.raw/*62.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*68.2*/(""" 
""")))})),format.raw/*69.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
		<ul>
			<li><a href="#tabs-evalgestion">Directivos</a></li>
			<li><a href="#tabs-autoevalgestion">Autoevaluación</a></li>
			
		</ul>
	<div id="tabs-evalgestion">
	"""),_display_(Seq[Any](/*79.3*/tablagestion(evaluacionGestion,"Gestión",Pregunta.GESTION, 0,6))),format.raw/*79.66*/("""	
	</div>
	<div id="tabs-autoevalgestion">	
	"""),_display_(Seq[Any](/*82.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*82.85*/("""
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
	"""),_display_(Seq[Any](/*94.3*/tablainvestigacion(evaluacionInvestigacion,"Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*94.90*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion">	
	"""),_display_(Seq[Any](/*97.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*97.109*/("""
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
                    DATE: Mon Nov 10 19:11:41 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprofesor.scala.html
                    HASH: 05819b7ed55a570dd83eb3cc668a3dbe3e3d61eb
                    MATRIX: 910->1|1261->257|1349->310|1365->318|1401->333|1438->335|1454->343|1488->356|1546->378|1576->386|1849->624|1901->660|1940->661|1978->664|2051->728|2090->729|2132->736|2151->746|2198->771|2243->780|2262->790|2308->814|2558->1028|2577->1038|2614->1053|2655->1058|2674->1068|2724->1096|2775->1111|2875->1189|2925->1204|3016->1273|3056->1278|3146->1346|3186->1351|3277->1420|3315->1423|3404->1503|3443->1504|3555->1581|3622->1632|3661->1633|3729->1665|3764->1678|3833->1715|3895->1746|3980->1796|4112->1918|4160->1927|4199->1931|4221->1944|4260->1945|4299->1949|4347->1988|4402->2005|4441->2009|4536->2082|4578->2089|4672->2161|4714->2168|4809->2241|4844->2245|4868->2251|4880->2255|4918->2256|4982->2289|5016->2292|5115->2360|5149->2363|5423->2602|5508->2665|5589->2711|5693->2793|5986->3051|6095->3138|6182->3190|6311->3296
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|55->27|55->27|57->29|57->29|59->31|59->31|60->32|60->32|60->32|65->37|65->37|65->37|67->39|67->39|69->41|72->44|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|82->54|82->54|84->56|84->56|85->57|87->59|87->59|87->59|89->61|90->62|96->68|97->69|107->79|107->79|110->82|110->82|122->94|122->94|125->97|125->97
                    -- GENERATED --
                */
            