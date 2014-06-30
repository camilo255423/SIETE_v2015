
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
	<div class="titulotabla">Observaciones</div>
		<table border='1'>
		<tbody>
	 			<tr>
	           <td width='650' style="font-size: 8pt;">OBSERVACIONES</td>  
	          </tr>
		     """),_display_(Seq[Any](/*37.9*/for(observaciones <- evaluacion.getObservaciones()) yield /*37.60*/{_display_(Seq[Any](format.raw/*37.61*/("""
		     <tr>
	           <td width='650' style="font-size: 8pt;">- """),_display_(Seq[Any](/*39.56*/observaciones)),format.raw/*39.69*/("""</td>  
	          </tr>
	          """)))})),format.raw/*41.13*/("""
	    </tbody>
	    </table>

	</div>
	<div id="tabs-autoevaluacion" style='page-break-after:always;'>	
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*50.56*/imagen)),format.raw/*50.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Docente: """),_display_(Seq[Any](/*55.49*/profesor/*55.57*/.getApellidos())),format.raw/*55.72*/(""" """),_display_(Seq[Any](/*55.74*/profesor/*55.82*/.getNombres())),format.raw/*55.95*/(""" Periodo: """),_display_(Seq[Any](/*55.106*/semestre)),format.raw/*55.114*/("""</b></p></div>
	<div style="text-align:center"><p><b>Autoevaluación Asignatura:"""),_display_(Seq[Any](/*56.66*/evaluacion/*56.76*/.getMateria().getNombre())),format.raw/*56.101*/(""", Grupo """),_display_(Seq[Any](/*56.110*/evaluacion/*56.120*/.getMateria().getGrupo())),format.raw/*56.144*/("""</b></p></div>
	"""),_display_(Seq[Any](/*57.3*/defining(evaluacionMateria.indexOf(new EvaluacionMateria(EvaluacionMateria.AUTOEVALUACION,evaluacion.getMateria(),false)))/*57.125*/{indice=>_display_(Seq[Any](format.raw/*57.134*/("""
		"""),_display_(Seq[Any](/*58.4*/if(indice>=0)/*58.17*/{_display_(Seq[Any](format.raw/*58.18*/("""
		"""),_display_(Seq[Any](/*59.4*/defining(evaluacionMateria.get(indice))/*59.43*/{autoevaluacion=>_display_(Seq[Any](format.raw/*59.60*/("""
		"""),_display_(Seq[Any](/*60.4*/tabladocencia(autoevaluacion,"Saber Pedagógico",Pregunta.PEDAGOGICO, 0,5))),format.raw/*60.77*/("""
		
		"""),_display_(Seq[Any](/*62.4*/tabladocencia(autoevaluacion,"Saber Específico",Pregunta.ESPECIFICO,6,8))),format.raw/*62.76*/("""
		
		"""),_display_(Seq[Any](/*64.4*/tabladocencia(autoevaluacion,"Saber Relacional",Pregunta.RELACIONAL,9,11))),format.raw/*64.77*/("""
		""")))})),format.raw/*65.4*/("""
		
	""")))}/*67.3*/else/*67.7*/{_display_(Seq[Any](format.raw/*67.8*/("""
	Sin autoevaluación 
	""")))})),format.raw/*69.3*/("""
	
	""")))})),format.raw/*71.3*/("""
	</div> <!-- div autoevaluacion -->

	</div> <!-- div tabs -->

	
""")))})),format.raw/*77.2*/(""" 
""")))})),format.raw/*78.2*/("""
	</div> <!--  docencia -->
<div id="tabs-gestion">
<div class="tabs">
	
	<div id="tabs-evalgestion" style='page-break-after:always;'>
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*87.56*/imagen)),format.raw/*87.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>	
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*92.47*/profesor/*92.55*/.getApellidos())),format.raw/*92.70*/(""" """),_display_(Seq[Any](/*92.72*/profesor/*92.80*/.getNombres())),format.raw/*92.93*/(""" Periodo: """),_display_(Seq[Any](/*92.104*/semestre)),format.raw/*92.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*93.3*/tablagestion(evaluacionGestion,"Evaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*93.77*/("""	
	</div>
	<div id="tabs-autoevalgestion" style='page-break-after:always;'>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*99.56*/imagen)),format.raw/*99.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>	
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*104.47*/profesor/*104.55*/.getApellidos())),format.raw/*104.70*/(""" """),_display_(Seq[Any](/*104.72*/profesor/*104.80*/.getNombres())),format.raw/*104.93*/(""" Periodo: """),_display_(Seq[Any](/*104.104*/semestre)),format.raw/*104.112*/("""</h4></div>	
	"""),_display_(Seq[Any](/*105.3*/tablagestion(autoEvaluacionGestion,"Autoevaluación Gestión",Pregunta.GESTION, 0,6))),format.raw/*105.85*/("""
	</div>
</div>
</div>
<div id="tabs-investigacion" style='page-break-after:always;'>

<div class="tabs">
		
	<div id="tabs-evalinvestigacion" style='page-break-after:always;'>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*117.56*/imagen)),format.raw/*117.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Docente: """),_display_(Seq[Any](/*122.49*/profesor/*122.57*/.getApellidos())),format.raw/*122.72*/(""" """),_display_(Seq[Any](/*122.74*/profesor/*122.82*/.getNombres())),format.raw/*122.95*/(""" Periodo: """),_display_(Seq[Any](/*122.106*/semestre)),format.raw/*122.114*/("""</b></p></div>
	"""),_display_(Seq[Any](/*123.3*/tablainvestigacion(evaluacionInvestigacion,"Evaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*123.101*/("""	
	</div>
	<div id="tabs-autoevalinvestigacion" style='page-break-after:always;'>	
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*129.56*/imagen)),format.raw/*129.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*134.47*/profesor/*134.55*/.getApellidos())),format.raw/*134.70*/(""" """),_display_(Seq[Any](/*134.72*/profesor/*134.80*/.getNombres())),format.raw/*134.93*/(""" Periodo: """),_display_(Seq[Any](/*134.104*/semestre)),format.raw/*134.112*/("""</h4></div>
	"""),_display_(Seq[Any](/*135.3*/tablainvestigacion(autoEvaluacionInvestigacion,"Autoevaluación Investigación",Pregunta.INVESTIGACION, 0,5))),format.raw/*135.109*/("""
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
                    DATE: Tue Jun 03 17:41:10 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprofesor.scala.html
                    HASH: 29d2b5808bc1d82d2aec15268651b327df47e491
                    MATRIX: 912->1|1280->274|1391->351|1442->387|1480->388|1517->391|1589->455|1627->456|1808->601|1836->607|2095->830|2112->838|2149->853|2187->855|2204->863|2239->876|2288->888|2319->896|2420->961|2439->971|2486->996|2531->1005|2551->1015|2598->1039|2755->1160|2774->1170|2811->1185|2852->1190|2871->1200|2921->1228|2972->1243|3072->1321|3119->1333|3210->1402|3250->1407|3340->1475|3380->1480|3471->1549|3692->1735|3759->1786|3798->1787|3902->1855|3937->1868|4006->1905|4290->2153|4318->2159|4575->2380|4592->2388|4629->2403|4667->2405|4684->2413|4719->2426|4767->2437|4798->2445|4914->2525|4933->2535|4981->2560|5027->2569|5047->2579|5094->2603|5146->2620|5278->2742|5326->2751|5365->2755|5387->2768|5426->2769|5465->2773|5513->2812|5568->2829|5607->2833|5702->2906|5744->2913|5838->2985|5880->2992|5975->3065|6010->3069|6034->3075|6046->3079|6084->3080|6139->3104|6175->3109|6274->3177|6308->3180|6623->3459|6651->3465|6907->3685|6924->3693|6961->3708|6999->3710|7016->3718|7051->3731|7099->3742|7130->3750|7179->3764|7275->3838|7528->4055|7556->4061|7813->4281|7831->4289|7869->4304|7908->4306|7926->4314|7962->4327|8011->4338|8043->4346|8094->4361|8199->4443|8554->4761|8583->4767|8841->4988|8859->4996|8897->5011|8936->5013|8954->5021|8990->5034|9039->5045|9071->5053|9124->5070|9246->5168|9507->5392|9536->5398|9792->5617|9810->5625|9848->5640|9887->5642|9905->5650|9941->5663|9990->5674|10022->5682|10072->5696|10202->5802
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|54->26|54->26|56->28|56->28|58->30|58->30|65->37|65->37|65->37|67->39|67->39|69->41|78->50|78->50|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|90->62|90->62|92->64|92->64|93->65|95->67|95->67|95->67|97->69|99->71|105->77|106->78|115->87|115->87|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|121->93|121->93|127->99|127->99|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|133->105|133->105|145->117|145->117|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|151->123|151->123|157->129|157->129|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|163->135|163->135
                    -- GENERATED --
                */
            