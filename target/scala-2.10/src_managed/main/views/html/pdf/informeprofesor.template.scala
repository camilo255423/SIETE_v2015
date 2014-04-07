
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
		"""),_display_(Seq[Any](/*29.4*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*29.84*/{_display_(Seq[Any](format.raw/*29.85*/("""
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
		   """)))})),format.raw/*43.7*/("""
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
                    DATE: Mon Apr 07 16:12:50 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprofesor.scala.html
                    HASH: 1f10993b5a2483db0b3bbea6dd95afcbf55ffbfe
                    MATRIX: 912->1|1280->274|1391->351|1442->387|1480->388|1517->391|1589->455|1627->456|1808->601|1836->607|2000->735|2017->743|2054->758|2092->760|2109->768|2144->781|2193->793|2224->801|2320->861|2339->871|2386->896|2431->905|2451->915|2498->939|2652->1057|2671->1067|2708->1082|2749->1087|2768->1097|2818->1125|2869->1140|2969->1218|3016->1230|3107->1299|3147->1304|3237->1372|3277->1377|3368->1446|3407->1450|3496->1530|3535->1531|3756->1717|3823->1768|3862->1769|3966->1837|4001->1850|4070->1887|4136->1922|4391->2141|4419->2147|4583->2275|4600->2283|4637->2298|4675->2300|4692->2308|4727->2321|4775->2332|4806->2340|4917->2415|4936->2425|4983->2450|5029->2459|5049->2469|5096->2493|5145->2507|5277->2629|5325->2638|5364->2642|5386->2655|5425->2656|5464->2660|5512->2699|5567->2716|5606->2720|5701->2793|5743->2800|5837->2872|5879->2879|5974->2952|6009->2956|6033->2962|6045->2966|6083->2967|6147->3000|6183->3005|6282->3073|6316->3076|6631->3355|6659->3361|6823->3489|6840->3497|6877->3512|6915->3514|6932->3522|6967->3535|7015->3546|7046->3554|7095->3568|7180->3631|7433->3848|7461->3854|7627->3983|7645->3991|7683->4006|7722->4008|7740->4016|7776->4029|7825->4040|7857->4048|7908->4063|8013->4145|8368->4463|8397->4469|8564->4599|8582->4607|8620->4622|8659->4624|8677->4632|8713->4645|8762->4656|8794->4664|8844->4678|8954->4765|9215->4989|9244->4995|9411->5125|9429->5133|9467->5148|9506->5150|9524->5158|9560->5171|9609->5182|9641->5190|9691->5204|9821->5310
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|57->29|57->29|57->29|64->36|64->36|64->36|66->38|66->38|68->40|71->43|77->49|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|88->60|88->60|90->62|90->62|91->63|93->65|93->65|93->65|95->67|97->69|103->75|104->76|113->85|113->85|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|118->90|118->90|124->96|124->96|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|129->101|141->113|141->113|146->118|146->118|146->118|146->118|146->118|146->118|146->118|146->118|147->119|147->119|153->125|153->125|158->130|158->130|158->130|158->130|158->130|158->130|158->130|158->130|159->131|159->131
                    -- GENERATED --
                */
            