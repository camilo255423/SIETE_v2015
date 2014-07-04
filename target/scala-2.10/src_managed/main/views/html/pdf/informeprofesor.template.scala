
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
	
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Docente: """),_display_(Seq[Any](/*17.49*/profesor/*17.57*/.getApellidos())),format.raw/*17.72*/(""" """),_display_(Seq[Any](/*17.74*/profesor/*17.82*/.getNombres())),format.raw/*17.95*/(""", Periodo: """),_display_(Seq[Any](/*17.107*/semestre)),format.raw/*17.115*/("""</b></p></div>
	<div style="text-align:center"><p><b>Asignatura:"""),_display_(Seq[Any](/*18.51*/evaluacion/*18.61*/.getMateria().getNombre())),format.raw/*18.86*/(""", Grupo """),_display_(Seq[Any](/*18.95*/evaluacion/*18.105*/.getMateria().getGrupo())),format.raw/*18.129*/("""</b></p></div>
	<div class="tabs">
	
	<div id="tabs-estudiantes" style='page-break-after:always;'>	

	<h4> Encuestados: """),_display_(Seq[Any](/*23.21*/evaluacion/*23.31*/.getEvaluados())),format.raw/*23.46*/(""" de """),_display_(Seq[Any](/*23.51*/evaluacion/*23.61*/.getMateria().getInscritos())),format.raw/*23.89*/(""", 
porcentaje """),_display_(Seq[Any](/*24.13*/(10000*evaluacion.getEvaluados()/evaluacion.getMateria().getInscritos()/100.0))),format.raw/*24.91*/("""% </h4>
	
	"""),_display_(Seq[Any](/*26.3*/tabladocencia(evaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*26.72*/("""
	
	"""),_display_(Seq[Any](/*28.3*/tabladocencia(evaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*28.71*/("""
	
	"""),_display_(Seq[Any](/*30.3*/tabladocencia(evaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*30.72*/("""
	"""),_display_(Seq[Any](/*31.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*31.83*/{_display_(Seq[Any](format.raw/*31.84*/("""
	
	<div class="titulotabla">Observaciones</div>
		<table border='1'>
		<tbody>
	 			<tr>
	           <td width='650' style="font-size: 8pt;">OBSERVACIONES</td>  
	          </tr>
		     """),_display_(Seq[Any](/*39.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*39.60*/{_display_(Seq[Any](format.raw/*39.61*/("""
		     <tr>
	           <td width='650' style="font-size: 8pt;">- """),_display_(Seq[Any](/*41.56*/observaciones)),format.raw/*41.69*/("""</td>  
	          </tr>
	          """)))})),format.raw/*43.13*/("""
	    </tbody>
	    </table>
	""")))})),format.raw/*46.3*/("""
	</div>
	<div id="tabs-autoevaluacion" style='page-break-after:always;'>	
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*52.56*/imagen)),format.raw/*52.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Docente: """),_display_(Seq[Any](/*57.49*/profesor/*57.57*/.getApellidos())),format.raw/*57.72*/(""" """),_display_(Seq[Any](/*57.74*/profesor/*57.82*/.getNombres())),format.raw/*57.95*/(""" Periodo: """),_display_(Seq[Any](/*57.106*/semestre)),format.raw/*57.114*/("""</b></p></div>
	<div style="text-align:center"><p><b>Autoevaluación Asignatura:"""),_display_(Seq[Any](/*58.66*/evaluacion/*58.76*/.getMateria().getNombre())),format.raw/*58.101*/(""", Grupo """),_display_(Seq[Any](/*58.110*/evaluacion/*58.120*/.getMateria().getGrupo())),format.raw/*58.144*/("""</b></p></div>
	"""),_display_(Seq[Any](/*59.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*59.125*/{indice=>_display_(Seq[Any](format.raw/*59.134*/("""
		"""),_display_(Seq[Any](/*60.4*/if(indice>=0)/*60.17*/{_display_(Seq[Any](format.raw/*60.18*/("""
		"""),_display_(Seq[Any](/*61.4*/defining(evaluacionMateria.get(indice))/*61.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*61.60*/("""
		"""),_display_(Seq[Any](/*62.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*62.77*/("""
		
		"""),_display_(Seq[Any](/*64.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*64.76*/("""
		
		"""),_display_(Seq[Any](/*66.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*66.77*/("""
		""")))})),format.raw/*67.4*/("""
		
	""")))}/*69.3*/else/*69.7*/{_display_(Seq[Any](format.raw/*69.8*/("""
	Sin autoevaluación 
	""")))})),format.raw/*71.3*/("""
	
	""")))})),format.raw/*73.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*79.2*/(""" 
""")))})),format.raw/*80.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
	
	<div id="tabs-evalgestion" style='page-break-after:always;'>
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*89.56*/imagen)),format.raw/*89.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>	
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*94.47*/profesor/*94.55*/.getApellidos())),format.raw/*94.70*/(""" """),_display_(Seq[Any](/*94.72*/profesor/*94.80*/.getNombres())),format.raw/*94.93*/(""" Periodo: """),_display_(Seq[Any](/*94.104*/semestre)),format.raw/*94.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*95.3*/tablagestion(evaluacionGestion,"Evaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*95.77*/("""	
	</div>
	<div id="tabs-autoevalgestion" style='page-break-after:always;'>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*101.56*/imagen)),format.raw/*101.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>	
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*106.47*/profesor/*106.55*/.getApellidos())),format.raw/*106.70*/(""" """),_display_(Seq[Any](/*106.72*/profesor/*106.80*/.getNombres())),format.raw/*106.93*/(""" Periodo: """),_display_(Seq[Any](/*106.104*/semestre)),format.raw/*106.112*/("""</h4></div>	
	"""),_display_(Seq[Any](/*107.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*107.85*/("""
	</div>
</div>
</div>
<div id="tabs-investigacion" style='page-break-after:always;'>

<div class="tabs">
		
	<div id="tabs-evalinvestigacion" style='page-break-after:always;'>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*119.56*/imagen)),format.raw/*119.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Docente: """),_display_(Seq[Any](/*124.49*/profesor/*124.57*/.getApellidos())),format.raw/*124.72*/(""" """),_display_(Seq[Any](/*124.74*/profesor/*124.82*/.getNombres())),format.raw/*124.95*/(""" Periodo: """),_display_(Seq[Any](/*124.106*/semestre)),format.raw/*124.114*/("""</b></p></div>
	"""),_display_(Seq[Any](/*125.3*/tablainvestigacion(evaluacionInvestigacion,"Evaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*125.101*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion" style='page-break-after:always;'>	
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*131.56*/imagen)),format.raw/*131.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*136.47*/profesor/*136.55*/.getApellidos())),format.raw/*136.70*/(""" """),_display_(Seq[Any](/*136.72*/profesor/*136.80*/.getNombres())),format.raw/*136.93*/(""" Periodo: """),_display_(Seq[Any](/*136.104*/semestre)),format.raw/*136.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*137.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*137.109*/("""
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
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:45 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeprofesor.scala.html
                    HASH: 1f10993b5a2483db0b3bbea6dd95afcbf55ffbfe
                    MATRIX: 912->1|1280->274|1391->351|1442->387|1480->388|1517->391|1589->455|1627->456|1808->601|1836->607|2000->735|2017->743|2054->758|2092->760|2109->768|2144->781|2193->793|2224->801|2320->861|2339->871|2386->896|2431->905|2451->915|2498->939|2652->1057|2671->1067|2708->1082|2749->1087|2768->1097|2818->1125|2869->1140|2969->1218|3016->1230|3107->1299|3147->1304|3237->1372|3277->1377|3368->1446|3407->1450|3496->1530|3535->1531|3756->1717|3823->1768|3862->1769|3966->1837|4001->1850|4070->1887|4136->1922|4391->2141|4419->2147|4583->2275|4600->2283|4637->2298|4675->2300|4692->2308|4727->2321|4775->2332|4806->2340|4917->2415|4936->2425|4983->2450|5029->2459|5049->2469|5096->2493|5145->2507|5277->2629|5325->2638|5364->2642|5386->2655|5425->2656|5464->2660|5512->2699|5567->2716|5606->2720|5701->2793|5743->2800|5837->2872|5879->2879|5974->2952|6009->2956|6033->2962|6045->2966|6083->2967|6147->3000|6183->3005|6282->3073|6316->3076|6631->3355|6659->3361|6823->3489|6840->3497|6877->3512|6915->3514|6932->3522|6967->3535|7015->3546|7046->3554|7095->3568|7180->3631|7433->3848|7461->3854|7627->3983|7645->3991|7683->4006|7722->4008|7740->4016|7776->4029|7825->4040|7857->4048|7908->4063|8013->4145|8368->4463|8397->4469|8564->4599|8582->4607|8620->4622|8659->4624|8677->4632|8713->4645|8762->4656|8794->4664|8844->4678|8954->4765|9215->4989|9244->4995|9411->5125|9429->5133|9467->5148|9506->5150|9524->5158|9560->5171|9609->5182|9641->5190|9691->5204|9821->5310
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|57->29|57->29|57->29|64->36|64->36|64->36|66->38|66->38|68->40|71->43|77->49|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|88->60|88->60|90->62|90->62|91->63|93->65|93->65|93->65|95->67|97->69|103->75|104->76|113->85|113->85|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|118->90|118->90|124->96|124->96|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|129->101|141->113|141->113|146->118|146->118|146->118|146->118|146->118|146->118|146->118|146->118|147->119|147->119|153->125|153->125|158->130|158->130|158->130|158->130|158->130|158->130|158->130|158->130|159->131|159->131
=======
                    DATE: Tue Jul 01 10:24:04 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprofesor.scala.html
                    HASH: 0aca114610a87ca416e4965c4d34c7339eafc0cf
                    MATRIX: 912->1|1280->274|1391->351|1442->387|1480->388|1517->391|1589->455|1627->456|1808->601|1836->607|2095->830|2112->838|2149->853|2187->855|2204->863|2239->876|2288->888|2319->896|2420->961|2439->971|2486->996|2531->1005|2551->1015|2598->1039|2755->1160|2774->1170|2811->1185|2852->1190|2871->1200|2921->1228|2972->1243|3072->1321|3119->1333|3210->1402|3250->1407|3340->1475|3380->1480|3471->1549|3509->1552|3598->1632|3637->1633|3860->1821|3927->1872|3966->1873|4070->1941|4105->1954|4174->1991|4236->2022|4491->2241|4519->2247|4776->2468|4793->2476|4830->2491|4868->2493|4885->2501|4920->2514|4968->2525|4999->2533|5115->2613|5134->2623|5182->2648|5228->2657|5248->2667|5295->2691|5347->2708|5479->2830|5527->2839|5566->2843|5588->2856|5627->2857|5666->2861|5714->2900|5769->2917|5808->2921|5903->2994|5945->3001|6039->3073|6081->3080|6176->3153|6211->3157|6235->3163|6247->3167|6285->3168|6340->3192|6376->3197|6475->3265|6509->3268|6824->3547|6852->3553|7108->3773|7125->3781|7162->3796|7200->3798|7217->3806|7252->3819|7300->3830|7331->3838|7380->3852|7476->3926|7730->4143|7759->4149|8016->4369|8034->4377|8072->4392|8111->4394|8129->4402|8165->4415|8214->4426|8246->4434|8297->4449|8402->4531|8757->4849|8786->4855|9044->5076|9062->5084|9100->5099|9139->5101|9157->5109|9193->5122|9242->5133|9274->5141|9327->5158|9449->5256|9710->5480|9739->5486|9995->5705|10013->5713|10051->5728|10090->5730|10108->5738|10144->5751|10193->5762|10225->5770|10275->5784|10405->5890
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|54->26|54->26|56->28|56->28|58->30|58->30|59->31|59->31|59->31|67->39|67->39|67->39|69->41|69->41|71->43|74->46|80->52|80->52|85->57|85->57|85->57|85->57|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|92->64|92->64|94->66|94->66|95->67|97->69|97->69|97->69|99->71|101->73|107->79|108->80|117->89|117->89|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|123->95|123->95|129->101|129->101|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|135->107|135->107|147->119|147->119|152->124|152->124|152->124|152->124|152->124|152->124|152->124|152->124|153->125|153->125|159->131|159->131|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|165->137|165->137
>>>>>>> 93429d7fbc474b9d33705b1aa2e201ce50fe2153
                    -- GENERATED --
                */
            