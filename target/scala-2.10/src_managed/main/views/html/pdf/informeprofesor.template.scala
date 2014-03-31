
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
object informeprofesor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,Profesor,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, autoEvaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion, profesor:Profesor, semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
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
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,autoEvaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre,imagen)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionInvestigacion,Profesor,String,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre,imagen) => apply(evaluacionMateria,evaluacionGestion,autoEvaluacionGestion,evaluacionInvestigacion,autoEvaluacionInvestigacion,profesor,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 20:33:25 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprofesor.scala.html
                    HASH: f7e95bc51fe1eee75de255b6ef6542dc8a295add
                    MATRIX: 912->1|1280->274|1391->351|1442->387|1480->388|1517->391|1589->455|1627->456|1808->601|1836->607|2000->735|2017->743|2054->758|2092->760|2109->768|2144->781|2193->793|2224->801|2320->861|2339->871|2386->896|2431->905|2451->915|2498->939|2652->1057|2671->1067|2708->1082|2749->1087|2768->1097|2818->1125|2869->1140|2969->1218|3016->1230|3107->1299|3147->1304|3237->1372|3277->1377|3368->1446|3591->1634|3658->1685|3697->1686|3801->1754|3836->1767|3905->1804|4194->2057|4222->2063|4386->2191|4403->2199|4440->2214|4478->2216|4495->2224|4530->2237|4578->2248|4609->2256|4720->2331|4739->2341|4786->2366|4832->2375|4852->2385|4899->2409|4948->2423|5080->2545|5128->2554|5167->2558|5189->2571|5228->2572|5267->2576|5315->2615|5370->2632|5409->2636|5504->2709|5546->2716|5640->2788|5682->2795|5777->2868|5812->2872|5836->2878|5848->2882|5886->2883|5950->2916|5986->2921|6085->2989|6119->2992|6434->3271|6462->3277|6626->3405|6643->3413|6680->3428|6718->3430|6735->3438|6770->3451|6818->3462|6849->3470|6898->3484|6983->3547|7236->3764|7264->3770|7430->3899|7448->3907|7486->3922|7525->3924|7543->3932|7579->3945|7628->3956|7660->3964|7711->3979|7816->4061|8171->4379|8200->4385|8367->4515|8385->4523|8423->4538|8462->4540|8480->4548|8516->4561|8565->4572|8597->4580|8647->4594|8757->4681|9018->4905|9047->4911|9214->5041|9232->5049|9270->5064|9309->5066|9327->5074|9363->5087|9412->5098|9444->5106|9494->5120|9624->5226
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|64->36|64->36|64->36|66->38|66->38|68->40|77->49|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|88->60|88->60|90->62|90->62|91->63|93->65|93->65|93->65|95->67|97->69|103->75|104->76|113->85|113->85|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|118->90|118->90|124->96|124->96|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|129->101|141->113|141->113|146->118|146->118|146->118|146->118|146->118|146->118|146->118|146->118|147->119|147->119|153->125|153->125|158->130|158->130|158->130|158->130|158->130|158->130|158->130|158->130|159->131|159->131
                    -- GENERATED --
                */
            