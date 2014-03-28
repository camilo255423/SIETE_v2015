
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
object informeprofesor extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template8[List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,Profesor,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, autoEvaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion, profesor:Profesor, semestre:String, imagen:String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.275*/("""
<div id="informe">
<div class="tabs">
	
 	<div id="tabs-docencia">       
	"""),_display_(Seq[Any](/*6.3*/for(evaluacion <- evaluacionMateria) yield /*6.39*/{_display_(Seq[Any](format.raw/*6.40*/("""
	"""),_display_(Seq[Any](/*7.3*/if(evaluacion.getTipoEvaluacion()==EvaluacionMateria.EVALUACION)/*7.67*/{_display_(Seq[Any](format.raw/*7.68*/("""
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*11.56*/imagen)),format.raw/*11.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*15.47*/profesor/*15.55*/.getApellidos())),format.raw/*15.70*/(""" """),_display_(Seq[Any](/*15.72*/profesor/*15.80*/.getNombres())),format.raw/*15.93*/(""", Periodo: """),_display_(Seq[Any](/*15.105*/semestre)),format.raw/*15.113*/("""</h4></div>
	<div style="text-align:center"><h4>Asignatura:"""),_display_(Seq[Any](/*16.49*/evaluacion/*16.59*/.getMateria().getNombre())),format.raw/*16.84*/(""", grupo """),_display_(Seq[Any](/*16.93*/evaluacion/*16.103*/.getMateria().getGrupo())),format.raw/*16.127*/("""</h4></div>
	<div class="tabs">
	
	<div id="tabs-estudiantes" style='page-break-after:always;'>	

	<h4> Encuestados: """),_display_(Seq[Any](/*21.21*/evaluacion/*21.31*/.getEvaluados())),format.raw/*21.46*/(""" de """),_display_(Seq[Any](/*21.51*/evaluacion/*21.61*/.getMateria().getInscritos())),format.raw/*21.89*/(""", 
porcentaje """),_display_(Seq[Any](/*22.13*/(10000*evaluacion.getEvaluados()/evaluacion.getMateria().getInscritos()/100.0))),format.raw/*22.91*/("""% </h4>
	
	"""),_display_(Seq[Any](/*24.3*/tabladocencia(evaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*24.72*/("""
	
	"""),_display_(Seq[Any](/*26.3*/tabladocencia(evaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*26.71*/("""
	
	"""),_display_(Seq[Any](/*28.3*/tabladocencia(evaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*28.72*/("""
	
	<div class="titulotabla">Observaciones</div>
		<table border='1'>
		<tbody>
	 			<tr>
	           <td width='650' style="font-size: 8pt;">OBSERVACIONES</td>  
	          </tr>
		     """),_display_(Seq[Any](/*36.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*36.60*/{_display_(Seq[Any](format.raw/*36.61*/("""
		     <tr>
	           <td width='650' style="font-size: 8pt;">- """),_display_(Seq[Any](/*38.56*/observaciones)),format.raw/*38.69*/("""</td>  
	          </tr>
	          """)))})),format.raw/*40.13*/("""
	    </tbody>
	    </table>
		   
	</div>
	<div id="tabs-autoevaluacion" style='page-break-after:always;'>	
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*49.56*/imagen)),format.raw/*49.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*53.47*/profesor/*53.55*/.getApellidos())),format.raw/*53.70*/(""" """),_display_(Seq[Any](/*53.72*/profesor/*53.80*/.getNombres())),format.raw/*53.93*/(""" Periodo: """),_display_(Seq[Any](/*53.104*/semestre)),format.raw/*53.112*/("""</h4></div>
	<div style="text-align:center"><h4>Autoevaluación Asignatura:"""),_display_(Seq[Any](/*54.64*/evaluacion/*54.74*/.getMateria().getNombre())),format.raw/*54.99*/(""", grupo """),_display_(Seq[Any](/*54.108*/evaluacion/*54.118*/.getMateria().getGrupo())),format.raw/*54.142*/("""</h4></div>
	"""),_display_(Seq[Any](/*55.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*55.125*/{indice=>_display_(Seq[Any](format.raw/*55.134*/("""
		"""),_display_(Seq[Any](/*56.4*/if(indice>=0)/*56.17*/{_display_(Seq[Any](format.raw/*56.18*/("""
		"""),_display_(Seq[Any](/*57.4*/defining(evaluacionMateria.get(indice))/*57.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*57.60*/("""
		"""),_display_(Seq[Any](/*58.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*58.77*/("""
		
		"""),_display_(Seq[Any](/*60.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*60.76*/("""
		
		"""),_display_(Seq[Any](/*62.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*62.77*/("""
		""")))})),format.raw/*63.4*/("""
		
	""")))}/*65.3*/else/*65.7*/{_display_(Seq[Any](format.raw/*65.8*/("""
	<h2>sin autoevaluación </h2>
	""")))})),format.raw/*67.3*/("""
	
	""")))})),format.raw/*69.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*75.2*/(""" 
""")))})),format.raw/*76.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
	
	<div id="tabs-evalgestion" style='page-break-after:always;'>
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*85.56*/imagen)),format.raw/*85.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*89.47*/profesor/*89.55*/.getApellidos())),format.raw/*89.70*/(""" """),_display_(Seq[Any](/*89.72*/profesor/*89.80*/.getNombres())),format.raw/*89.93*/(""" Periodo: """),_display_(Seq[Any](/*89.104*/semestre)),format.raw/*89.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*90.3*/tablagestion(evaluacionGestion,"Gestión",Pregunta.GESTION, 0,6))),format.raw/*90.66*/("""	
	</div>
	<div id="tabs-autoevalgestion" style='page-break-after:always;'>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*96.56*/imagen)),format.raw/*96.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>	
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*100.47*/profesor/*100.55*/.getApellidos())),format.raw/*100.70*/(""" """),_display_(Seq[Any](/*100.72*/profesor/*100.80*/.getNombres())),format.raw/*100.93*/(""" Periodo: """),_display_(Seq[Any](/*100.104*/semestre)),format.raw/*100.112*/("""</h4></div>	
	"""),_display_(Seq[Any](/*101.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*101.85*/("""
	</div>
</div>
</div>
<div id="tabs-investigacion" style='page-break-after:always;'>

<div class="tabs">
		
	<div id="tabs-evalinvestigacion" style='page-break-after:always;'>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*113.56*/imagen)),format.raw/*113.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*118.47*/profesor/*118.55*/.getApellidos())),format.raw/*118.70*/(""" """),_display_(Seq[Any](/*118.72*/profesor/*118.80*/.getNombres())),format.raw/*118.93*/(""" Periodo: """),_display_(Seq[Any](/*118.104*/semestre)),format.raw/*118.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*119.3*/tablainvestigacion(evaluacionInvestigacion,"Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*119.90*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion" style='page-break-after:always;'>	
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*125.56*/imagen)),format.raw/*125.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*130.47*/profesor/*130.55*/.getApellidos())),format.raw/*130.70*/(""" """),_display_(Seq[Any](/*130.72*/profesor/*130.80*/.getNombres())),format.raw/*130.93*/(""" Periodo: """),_display_(Seq[Any](/*130.104*/semestre)),format.raw/*130.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*131.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*131.109*/("""
	</div>
</div>
</div>
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,autoEvaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String,imagen:String): play.api.templates.Html = apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre,imagen)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,Profesor,String,String) => play.api.templates.Html) = (evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre,imagen) => apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 08:45:18 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeprofesor.scala.html
                    HASH: 1da5c3a95218a638b48dbfdc7d46f0c7465ec787
                    MATRIX: 861->1|1212->274|1323->351|1374->387|1412->388|1449->391|1521->455|1559->456|1740->601|1768->607|1932->735|1949->743|1986->758|2024->760|2041->768|2076->781|2125->793|2156->801|2252->861|2271->871|2318->896|2363->905|2383->915|2430->939|2584->1057|2603->1067|2640->1082|2681->1087|2700->1097|2750->1125|2801->1140|2901->1218|2948->1230|3039->1299|3079->1304|3169->1372|3209->1377|3300->1446|3523->1634|3590->1685|3629->1686|3733->1754|3768->1767|3837->1804|4126->2057|4154->2063|4318->2191|4335->2199|4372->2214|4410->2216|4427->2224|4462->2237|4510->2248|4541->2256|4652->2331|4671->2341|4718->2366|4764->2375|4784->2385|4831->2409|4880->2423|5012->2545|5060->2554|5099->2558|5121->2571|5160->2572|5199->2576|5247->2615|5302->2632|5341->2636|5436->2709|5478->2716|5572->2788|5614->2795|5709->2868|5744->2872|5768->2878|5780->2882|5818->2883|5882->2916|5918->2921|6017->2989|6051->2992|6366->3271|6394->3277|6558->3405|6575->3413|6612->3428|6650->3430|6667->3438|6702->3451|6750->3462|6781->3470|6830->3484|6915->3547|7168->3764|7196->3770|7362->3899|7380->3907|7418->3922|7457->3924|7475->3932|7511->3945|7560->3956|7592->3964|7643->3979|7748->4061|8103->4379|8132->4385|8299->4515|8317->4523|8355->4538|8394->4540|8412->4548|8448->4561|8497->4572|8529->4580|8579->4594|8689->4681|8950->4905|8979->4911|9146->5041|9164->5049|9202->5064|9241->5066|9259->5074|9295->5087|9344->5098|9376->5106|9426->5120|9556->5226
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|64->36|64->36|64->36|66->38|66->38|68->40|77->49|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|88->60|88->60|90->62|90->62|91->63|93->65|93->65|93->65|95->67|97->69|103->75|104->76|113->85|113->85|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|118->90|118->90|124->96|124->96|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|129->101|141->113|141->113|146->118|146->118|146->118|146->118|146->118|146->118|146->118|146->118|147->119|147->119|153->125|153->125|158->130|158->130|158->130|158->130|158->130|158->130|158->130|158->130|159->131|159->131
                    -- GENERATED --
                */
            