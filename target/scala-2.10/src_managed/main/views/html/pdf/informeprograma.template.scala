
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
<<<<<<< HEAD
object informeprograma extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template9[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Programa,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,programa:Programa, semestre:String, imagen:String):play.api.templates.Html = {
=======
object informeprograma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template10[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Programa,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel], programa:Programa, semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.339*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<div class="tabs">
	
 	<div id="tabs-docencia">       
	
	<div class="titulotabla"></div>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*13.56*/imagen)),format.raw/*13.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
	<div style="text-align:center"><p><b>Evaluación del Desempeño Docente """),_display_(Seq[Any](/*17.73*/semestre)),format.raw/*17.81*/("""</b></p></div>
	<div style="text-align:center"><p><b>Informe Final Programa</b></p></div>
    <div style="text-align:center"><p><b>"""),_display_(Seq[Any](/*19.43*/programa/*19.51*/.getNombre())),format.raw/*19.63*/("""</b></p></div>
  
	  """),_display_(Seq[Any](/*21.5*/defining(new DecimalFormat("##0.00"))/*21.42*/{formato=>_display_(Seq[Any](format.raw/*21.52*/("""
<h4>Campo de la Docencia</h4>
	<p><b>Mejor Saber: """),_display_(Seq[Any](/*23.22*/mejorPeor/*23.31*/.get(0).getSaber())),format.raw/*23.49*/(""" Nivel: """),_display_(Seq[Any](/*23.58*/Nivel/*23.63*/.toString(mejorPeor.get(0).getNivel()))),format.raw/*23.101*/(""" """),_display_(Seq[Any](/*23.103*/formato/*23.110*/.format(mejorPeor.get(0).getPromedio()))),format.raw/*23.149*/(""" %</b></p>  
	 <p><b>Peor Saber: """),_display_(Seq[Any](/*24.22*/mejorPeor/*24.31*/.get(1).getSaber())),format.raw/*24.49*/(""" Nivel: """),_display_(Seq[Any](/*24.58*/Nivel/*24.63*/.toString(mejorPeor.get(1).getNivel()))),format.raw/*24.101*/(""" """),_display_(Seq[Any](/*24.103*/formato/*24.110*/.format(mejorPeor.get(1).getPromedio()))),format.raw/*24.149*/(""" %</b></p>

	<table border='1'>
	<tbody>
         <tr style="font-size: 8pt;">
        <td class="row_headers" align="center" valign="middle"><b>Saber Evaluado</b></td>
        <td class="row_headers" align="center" valign="middle"><b>Nivel de Desempeño</b></td>
		<td class="row_headers" align="center" valign="middle" width='5cm'><b>Porcentaje Promedio de Respuestas Estudiantes, ponderación 80%</b></td>
		<td class="row_headers" align="center" valign="middle" width='5cm'><b>Porcentaje Promedio de Respuestas Autoevaluación, ponderación 20%</b></td>
		<td class="row_headers" align="center" valign="middle" width='2cm'><b>Evaluación Resultante</b></td>
	     </tr>
	     		 <tr style="font-size: 8pt;">
				<td class="row_headers" rowspan='5'>Saber Pedagógico</td>
				<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*38.73*/formato/*38.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*38.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*39.73*/formato/*39.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*39.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*40.73*/formato/*40.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*40.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*44.73*/formato/*44.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*44.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*45.73*/formato/*45.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*45.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*46.73*/formato/*46.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*46.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*50.73*/formato/*50.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*50.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*51.73*/formato/*51.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*51.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*52.73*/formato/*52.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*52.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*56.73*/formato/*56.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*56.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*57.73*/formato/*57.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*57.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*58.73*/formato/*58.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*58.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*62.73*/formato/*62.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*62.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*63.73*/formato/*63.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*63.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*64.73*/formato/*64.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*64.228*/(""" %</td>
                </tr>    
       			 <tr style="font-size: 8pt;">
				<td class="row_headers" rowspan='5'>Saber Específico</td>
				<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*69.73*/formato/*69.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*69.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*70.73*/formato/*70.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*70.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*71.73*/formato/*71.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*71.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*75.73*/formato/*75.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*75.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*76.73*/formato/*76.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*76.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*77.73*/formato/*77.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*77.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*81.73*/formato/*81.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*81.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*82.73*/formato/*82.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*82.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*83.73*/formato/*83.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*83.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*87.73*/formato/*87.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*87.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*88.73*/formato/*88.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*88.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*89.73*/formato/*89.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*89.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*93.73*/formato/*93.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*93.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*94.73*/formato/*94.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*94.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*95.73*/formato/*95.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*95.228*/(""" %</td>
                </tr>    
          
   
	 			 <tr style="font-size: 8pt;">
				<td class="row_headers" rowspan='5'>Saber Relacional</td>
     			<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*102.73*/formato/*102.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*102.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*103.73*/formato/*103.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*103.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*104.73*/formato/*104.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*104.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*108.73*/formato/*108.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*108.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*109.73*/formato/*109.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*109.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*110.73*/formato/*110.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*110.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*114.73*/formato/*114.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*114.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*115.73*/formato/*115.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*115.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*116.73*/formato/*116.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*116.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*120.73*/formato/*120.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*120.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*121.73*/formato/*121.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*121.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*122.73*/formato/*122.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*122.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*126.73*/formato/*126.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*126.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*127.73*/formato/*127.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*127.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*128.73*/formato/*128.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*128.228*/(""" %</td>
                </tr>    
              
             
      
        
          
          </tbody>
          </table>
              <h4>Campo de la Gestión</h4>
	<table border='1'>
	<tbody>
         <tr style="font-size: 8pt;">
        <td class="row_headers" align="center" valign="middle"><b>Nivel de Desempeño</b></td>
		<td class="row_headers" align="center" valign="middle" width='5cm'><b>Porcentaje Promedio de Respuestas Directivo, Ponderación 60%</b></td>
		<td class="row_headers" align="center" valign="middle" width='5cm'><b>Porcentaje Promedio de Respuestas Autoevaluación, Ponderación 40%</b></td>
		<td class="row_headers" align="center" valign="middle" width='4cm'><b>Evaluación Resultante</b></td>
	     </tr>
	     		 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">No Cumple</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*148.73*/formato/*148.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*148.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*149.73*/formato/*149.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*149.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*150.73*/formato/*150.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*150.220*/(""" %</td>
                </tr>
              	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Cumple Parcialmente</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*154.73*/formato/*154.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*154.142*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*155.73*/formato/*155.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*155.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*156.73*/formato/*156.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*156.212*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Cumple Totalmente</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*160.73*/formato/*160.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*160.143*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*161.73*/formato/*161.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*161.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*162.73*/formato/*162.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*162.214*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">No Aplica</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*166.73*/formato/*166.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*166.142*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*167.73*/formato/*167.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*167.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*168.73*/formato/*168.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*168.212*/(""" %</td>
                </tr>
          </tbody>
          </table>
                <h4>Campo de la Investigación</h4>
	<table border='1'>
	<tbody>
         <tr style="font-size: 8pt;">
        <td class="row_headers" align="center" valign="middle"><b>Nivel de Desempeño</b></td>
		<td class="row_headers" align="center" valign="middle" width='5cm'><b>Porcentaje Promedio de Respuestas Directivo, Ponderación 60%</b></td>
		<td class="row_headers" align="center" valign="middle" width='5cm'><b>Porcentaje Promedio de Respuestas Autoevaluación, Ponderación 40%</b></td>
		<td class="row_headers" align="center" valign="middle" width='4cm'><b>Evaluación Resultante</b></td> 
		</tr>
				 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*183.73*/formato/*183.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*183.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*184.73*/formato/*184.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*184.156*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*185.73*/formato/*185.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*185.232*/(""" %</td>
                </tr>
              	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*189.73*/formato/*189.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*189.148*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*190.73*/formato/*190.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*190.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*191.73*/formato/*191.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*191.224*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*195.73*/formato/*195.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*195.149*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*196.73*/formato/*196.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*196.153*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*197.73*/formato/*197.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*197.226*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*201.73*/formato/*201.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*201.148*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*202.73*/formato/*202.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*202.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*203.73*/formato/*203.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*203.224*/(""" %</td>
                </tr>
				   <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*207.73*/formato/*207.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*207.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*208.73*/formato/*208.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*208.156*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*209.73*/formato/*209.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*209.232*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*218.12*/("""
  </div> <!--  docencia -->
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
"""))}
    }
    
<<<<<<< HEAD
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,programa:Programa,semestre:String,imagen:String): play.api.templates.Html = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,programa,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Programa,String,String) => play.api.templates.Html) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,programa,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,programa,semestre,imagen)
=======
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],programa:Programa,semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Programa,String,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre,imagen)
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:03 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeprograma.scala.html
                    HASH: f38089c63a6b432af9496f2c450574868ac7542a
                    MATRIX: 873->1|1312->310|1339->364|1625->614|1653->620|1843->774|1873->782|2041->914|2058->922|2092->934|2149->956|2195->993|2243->1003|3212->1936|3228->1943|3321->2013|3437->2093|3453->2100|3550->2174|3666->2254|3682->2261|3853->2409|4106->2626|4122->2633|4211->2699|4327->2779|4343->2786|4436->2856|4552->2936|4568->2943|4731->3083|4987->3303|5003->3310|5093->3377|5209->3457|5225->3464|5319->3535|5435->3615|5451->3622|5616->3764|5870->3982|5886->3989|5975->4055|6091->4135|6107->4142|6200->4212|6316->4292|6332->4299|6495->4439|6753->4661|6769->4668|6862->4738|6978->4818|6994->4825|7091->4899|7207->4979|7223->4986|7394->5134|7711->5415|7727->5422|7820->5492|7936->5572|7952->5579|8049->5653|8165->5733|8181->5740|8352->5888|8605->6105|8621->6112|8710->6178|8826->6258|8842->6265|8935->6335|9051->6415|9067->6422|9230->6562|9486->6782|9502->6789|9592->6856|9708->6936|9724->6943|9818->7014|9934->7094|9950->7101|10115->7243|10369->7461|10385->7468|10474->7534|10590->7614|10606->7621|10699->7691|10815->7771|10831->7778|10994->7918|11252->8140|11268->8147|11361->8217|11477->8297|11493->8304|11590->8378|11706->8458|11722->8465|11893->8613|12224->8908|12240->8915|12333->8985|12450->9065|12467->9072|12565->9146|12682->9226|12699->9233|12871->9381|13125->9598|13142->9605|13232->9671|13349->9751|13366->9758|13460->9828|13577->9908|13594->9915|13758->10055|14015->10275|14032->10282|14123->10349|14240->10429|14257->10436|14352->10507|14469->10587|14486->10594|14652->10736|14907->10954|14924->10961|15014->11027|15131->11107|15148->11114|15242->11184|15359->11264|15376->11271|15540->11411|15799->11633|15816->11640|15910->11710|16027->11790|16044->11797|16142->11871|16259->11951|16276->11958|16448->12106|17405->13026|17422->13033|17512->13099|17629->13179|17646->13186|17740->13256|17857->13336|17874->13343|18038->13483|18306->13714|18323->13721|18409->13783|18526->13863|18543->13870|18633->13936|18750->14016|18767->14023|18923->14155|19191->14386|19208->14393|19295->14456|19412->14536|19429->14543|19520->14610|19637->14690|19654->14697|19812->14831|20072->15054|20089->15061|20175->15123|20292->15203|20309->15210|20399->15276|20516->15356|20533->15363|20689->15495|21586->16355|21603->16362|21699->16434|21816->16514|21833->16521|21933->16597|22050->16677|22067->16684|22243->16836|22496->17052|22513->17059|22605->17127|22722->17207|22739->17214|22835->17286|22952->17366|22969->17373|23137->17517|23393->17736|23410->17743|23503->17812|23620->17892|23637->17899|23734->17972|23851->18052|23868->18059|24038->18205|24292->18422|24309->18429|24401->18497|24518->18577|24535->18584|24631->18656|24748->18736|24765->18743|24933->18887|25181->19098|25198->19105|25294->19177|25411->19257|25428->19264|25528->19340|25645->19420|25662->19427|25838->19579|25996->19704
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|76->47|76->47|76->47|77->48|77->48|77->48|78->49|78->49|78->49|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|95->66|95->66|95->66|96->67|96->67|96->67|97->68|97->68|97->68|101->72|101->72|101->72|102->73|102->73|102->73|103->74|103->74|103->74|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|146->117|146->117|146->117|147->118|147->118|147->118|148->119|148->119|148->119|152->123|152->123|152->123|153->124|153->124|153->124|154->125|154->125|154->125|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|180->151|180->151|180->151|181->152|181->152|181->152|182->153|182->153|182->153|186->157|186->157|186->157|187->158|187->158|187->158|188->159|188->159|188->159|192->163|192->163|192->163|193->164|193->164|193->164|194->165|194->165|194->165|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|227->198|227->198|227->198|228->199|228->199|228->199|229->200|229->200|229->200|233->204|233->204|233->204|234->205|234->205|234->205|235->206|235->206|235->206|244->215
=======
                    DATE: Mon Apr 14 20:00:14 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprograma.scala.html
                    HASH: 64a2d00024b1545f1b2b3eda71d52cfa2e556dc5
                    MATRIX: 942->1|1426->338|1453->392|1739->642|1767->648|1957->802|1987->810|2155->942|2172->950|2206->962|2263->984|2309->1021|2357->1031|2445->1083|2463->1092|2503->1110|2548->1119|2562->1124|2623->1162|2662->1164|2679->1171|2741->1210|2811->1244|2829->1253|2869->1271|2914->1280|2928->1285|2989->1323|3028->1325|3045->1332|3107->1371|4057->2285|4073->2292|4166->2362|4282->2442|4298->2449|4395->2523|4511->2603|4527->2610|4698->2758|4951->2975|4967->2982|5056->3048|5172->3128|5188->3135|5281->3205|5397->3285|5413->3292|5576->3432|5832->3652|5848->3659|5938->3726|6054->3806|6070->3813|6164->3884|6280->3964|6296->3971|6461->4113|6715->4331|6731->4338|6820->4404|6936->4484|6952->4491|7045->4561|7161->4641|7177->4648|7340->4788|7598->5010|7614->5017|7707->5087|7823->5167|7839->5174|7936->5248|8052->5328|8068->5335|8239->5483|8556->5764|8572->5771|8665->5841|8781->5921|8797->5928|8894->6002|9010->6082|9026->6089|9197->6237|9450->6454|9466->6461|9555->6527|9671->6607|9687->6614|9780->6684|9896->6764|9912->6771|10075->6911|10331->7131|10347->7138|10437->7205|10553->7285|10569->7292|10663->7363|10779->7443|10795->7450|10960->7592|11214->7810|11230->7817|11319->7883|11435->7963|11451->7970|11544->8040|11660->8120|11676->8127|11839->8267|12097->8489|12113->8496|12206->8566|12322->8646|12338->8653|12435->8727|12551->8807|12567->8814|12738->8962|13070->9257|13087->9264|13181->9334|13298->9414|13315->9421|13413->9495|13530->9575|13547->9582|13719->9730|13973->9947|13990->9954|14080->10020|14197->10100|14214->10107|14308->10177|14425->10257|14442->10264|14606->10404|14863->10624|14880->10631|14971->10698|15088->10778|15105->10785|15200->10856|15317->10936|15334->10943|15500->11085|15755->11303|15772->11310|15862->11376|15979->11456|15996->11463|16090->11533|16207->11613|16224->11620|16388->11760|16647->11982|16664->11989|16758->12059|16875->12139|16892->12146|16990->12220|17107->12300|17124->12307|17296->12455|18253->13375|18270->13382|18360->13448|18477->13528|18494->13535|18588->13605|18705->13685|18722->13692|18886->13832|19154->14063|19171->14070|19257->14132|19374->14212|19391->14219|19481->14285|19598->14365|19615->14372|19771->14504|20039->14735|20056->14742|20143->14805|20260->14885|20277->14892|20368->14959|20485->15039|20502->15046|20660->15180|20920->15403|20937->15410|21023->15472|21140->15552|21157->15559|21247->15625|21364->15705|21381->15712|21537->15844|22434->16704|22451->16711|22547->16783|22664->16863|22681->16870|22781->16946|22898->17026|22915->17033|23091->17185|23344->17401|23361->17408|23453->17476|23570->17556|23587->17563|23683->17635|23800->17715|23817->17722|23985->17866|24241->18085|24258->18092|24351->18161|24468->18241|24485->18248|24582->18321|24699->18401|24716->18408|24886->18554|25140->18771|25157->18778|25249->18846|25366->18926|25383->18933|25479->19005|25596->19085|25613->19092|25781->19236|26029->19447|26046->19454|26142->19526|26259->19606|26276->19613|26376->19689|26493->19769|26510->19776|26686->19928|26844->20053
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|98->69|98->69|98->69|99->70|99->70|99->70|100->71|100->71|100->71|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|149->120|149->120|149->120|150->121|150->121|150->121|151->122|151->122|151->122|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|183->154|183->154|183->154|184->155|184->155|184->155|185->156|185->156|185->156|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|195->166|195->166|195->166|196->167|196->167|196->167|197->168|197->168|197->168|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|236->207|236->207|236->207|237->208|237->208|237->208|238->209|238->209|238->209|247->218
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            