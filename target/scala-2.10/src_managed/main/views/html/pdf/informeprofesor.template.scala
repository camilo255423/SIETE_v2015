
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
	           <td width='650' style="font-size: 8pt;"></td>  
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
                    DATE: Sun Aug 03 10:49:41 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/pdf/informeprofesor.scala.html
                    HASH: e4a6cff59bdd9a82b94080204d1cad7831612a2e
                    MATRIX: 912->1|1280->274|1391->351|1442->387|1480->388|1517->391|1589->455|1627->456|1808->601|1836->607|2095->830|2112->838|2149->853|2187->855|2204->863|2239->876|2288->888|2319->896|2420->961|2439->971|2486->996|2531->1005|2551->1015|2598->1039|2755->1160|2774->1170|2811->1185|2852->1190|2871->1200|2921->1228|2972->1243|3072->1321|3119->1333|3210->1402|3250->1407|3340->1475|3380->1480|3471->1549|3509->1552|3598->1632|3637->1633|3847->1808|3914->1859|3953->1860|4057->1928|4092->1941|4161->1978|4223->2009|4478->2228|4506->2234|4763->2455|4780->2463|4817->2478|4855->2480|4872->2488|4907->2501|4955->2512|4986->2520|5102->2600|5121->2610|5169->2635|5215->2644|5235->2654|5282->2678|5334->2695|5466->2817|5514->2826|5553->2830|5575->2843|5614->2844|5653->2848|5701->2887|5756->2904|5795->2908|5890->2981|5932->2988|6026->3060|6068->3067|6163->3140|6198->3144|6222->3150|6234->3154|6272->3155|6327->3179|6363->3184|6462->3252|6496->3255|6811->3534|6839->3540|7095->3760|7112->3768|7149->3783|7187->3785|7204->3793|7239->3806|7287->3817|7318->3825|7367->3839|7463->3913|7717->4130|7746->4136|8003->4356|8021->4364|8059->4379|8098->4381|8116->4389|8152->4402|8201->4413|8233->4421|8284->4436|8389->4518|8744->4836|8773->4842|9031->5063|9049->5071|9087->5086|9126->5088|9144->5096|9180->5109|9229->5120|9261->5128|9314->5145|9436->5243|9697->5467|9726->5473|9982->5692|10000->5700|10038->5715|10077->5717|10095->5725|10131->5738|10180->5749|10212->5757|10262->5771|10392->5877
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|54->26|54->26|56->28|56->28|58->30|58->30|59->31|59->31|59->31|67->39|67->39|67->39|69->41|69->41|71->43|74->46|80->52|80->52|85->57|85->57|85->57|85->57|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|92->64|92->64|94->66|94->66|95->67|97->69|97->69|97->69|99->71|101->73|107->79|108->80|117->89|117->89|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|123->95|123->95|129->101|129->101|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|135->107|135->107|147->119|147->119|152->124|152->124|152->124|152->124|152->124|152->124|152->124|152->124|153->125|153->125|159->131|159->131|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|165->137|165->137
                    -- GENERATED --
                */
            