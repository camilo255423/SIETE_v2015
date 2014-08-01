
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
object informeprograma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template10[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Programa,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel], programa:Programa, semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
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
	<div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><p><b>Evaluación del Desempeño Docente </b></p></div>
	<div style="text-align:center"><p><b>Informe Final Programa """),_display_(Seq[Any](/*19.63*/semestre)),format.raw/*19.71*/("""</b></p></div>
    <div style="text-align:center"><p><b>"""),_display_(Seq[Any](/*20.43*/programa/*20.51*/.getNombre())),format.raw/*20.63*/("""</b></p></div>
  
	  """),_display_(Seq[Any](/*22.5*/defining(new DecimalFormat("##0.00"))/*22.42*/{formato=>_display_(Seq[Any](format.raw/*22.52*/("""
<h4>Campo de la Docencia</h4>
	<p><b>Mayor porcentaje en el saber: """),_display_(Seq[Any](/*24.39*/mejorPeor/*24.48*/.get(0).getSaber())),format.raw/*24.66*/(""" Nivel: """),_display_(Seq[Any](/*24.75*/Nivel/*24.80*/.toString(mejorPeor.get(0).getNivel()))),format.raw/*24.118*/(""" """),_display_(Seq[Any](/*24.120*/formato/*24.127*/.format(mejorPeor.get(0).getPromedio()))),format.raw/*24.166*/(""" %</b></p>  
	 <p><b>Menor porcentaje en el saber: """),_display_(Seq[Any](/*25.40*/mejorPeor/*25.49*/.get(1).getSaber())),format.raw/*25.67*/(""" Nivel: """),_display_(Seq[Any](/*25.76*/Nivel/*25.81*/.toString(mejorPeor.get(1).getNivel()))),format.raw/*25.119*/(""" """),_display_(Seq[Any](/*25.121*/formato/*25.128*/.format(mejorPeor.get(1).getPromedio()))),format.raw/*25.167*/(""" %</b></p>

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
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*39.73*/formato/*39.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*39.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*40.73*/formato/*40.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*40.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*41.73*/formato/*41.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*41.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*45.73*/formato/*45.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*45.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*46.73*/formato/*46.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*46.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*47.73*/formato/*47.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*47.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*51.73*/formato/*51.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*51.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*52.73*/formato/*52.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*52.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*53.73*/formato/*53.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*53.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*57.73*/formato/*57.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*57.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*58.73*/formato/*58.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*58.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*59.73*/formato/*59.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*59.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*63.73*/formato/*63.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*63.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*64.73*/formato/*64.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*64.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*65.73*/formato/*65.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*65.228*/(""" %</td>
                </tr> 
                </tbody>
                </table>
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
				<td class="row_headers" rowspan='5'>Saber Específico</td>
				<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*82.73*/formato/*82.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*82.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*83.73*/formato/*83.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*83.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*84.73*/formato/*84.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*84.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*88.73*/formato/*88.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*88.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*89.73*/formato/*89.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*89.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*90.73*/formato/*90.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*90.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*94.73*/formato/*94.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*94.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*95.73*/formato/*95.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*95.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*96.73*/formato/*96.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*96.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*100.73*/formato/*100.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*100.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*101.73*/formato/*101.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*101.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*102.73*/formato/*102.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*102.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*106.73*/formato/*106.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*106.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*107.73*/formato/*107.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*107.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*108.73*/formato/*108.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*108.228*/(""" %</td>
                </tr>   
             </tbody>
             </table>    
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
				<td class="row_headers" rowspan='5'>Saber Relacional</td>
     			<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*126.73*/formato/*126.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*126.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*127.73*/formato/*127.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*127.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*128.73*/formato/*128.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*128.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*132.73*/formato/*132.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*132.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*133.73*/formato/*133.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*133.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*134.73*/formato/*134.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*134.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*138.73*/formato/*138.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*138.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*139.73*/formato/*139.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*139.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*140.73*/formato/*140.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*140.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*144.73*/formato/*144.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*144.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*145.73*/formato/*145.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*145.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*146.73*/formato/*146.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*146.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*150.73*/formato/*150.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*150.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*151.73*/formato/*151.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*151.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*152.73*/formato/*152.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*152.228*/(""" %</td>
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
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*172.73*/formato/*172.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*172.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*173.73*/formato/*173.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*173.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*174.73*/formato/*174.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*174.220*/(""" %</td>
                </tr>
              	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Cumple Parcialmente</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*178.73*/formato/*178.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*178.142*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*179.73*/formato/*179.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*179.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*180.73*/formato/*180.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*180.212*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Cumple Totalmente</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*184.73*/formato/*184.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*184.143*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*185.73*/formato/*185.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*185.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*186.73*/formato/*186.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*186.214*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">No Aplica</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*190.73*/formato/*190.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*190.142*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*191.73*/formato/*191.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*191.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*192.73*/formato/*192.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*192.212*/(""" %</td>
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
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*207.73*/formato/*207.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*207.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*208.73*/formato/*208.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*208.156*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*209.73*/formato/*209.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*209.232*/(""" %</td>
                </tr>
              	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*213.73*/formato/*213.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*213.148*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*214.73*/formato/*214.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*214.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*215.73*/formato/*215.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*215.224*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*219.73*/formato/*219.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*219.149*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*220.73*/formato/*220.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*220.153*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*221.73*/formato/*221.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*221.226*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*225.73*/formato/*225.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*225.148*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*226.73*/formato/*226.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*226.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*227.73*/formato/*227.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*227.224*/(""" %</td>
                </tr>
				   <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*231.73*/formato/*231.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*231.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*232.73*/formato/*232.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*232.156*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*233.73*/formato/*233.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*233.232*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*242.12*/("""
  </div> <!--  docencia -->
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
"""))}
    }
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],programa:Programa,semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Programa,String,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
<<<<<<< HEAD
                    DATE: Fri Jul 04 15:56:12 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeprograma.scala.html
                    HASH: a724db3028dfa39fa984433cefe6889e33055e7f
                    MATRIX: 942->1|1426->338|1453->392|1739->642|1767->648|1957->802|1987->810|2155->942|2172->950|2206->962|2263->984|2309->1021|2357->1031|2462->1100|2480->1109|2520->1127|2565->1136|2579->1141|2640->1179|2679->1181|2696->1188|2758->1227|2846->1279|2864->1288|2904->1306|2949->1315|2963->1320|3024->1358|3063->1360|3080->1367|3142->1406|4092->2320|4108->2327|4201->2397|4317->2477|4333->2484|4430->2558|4546->2638|4562->2645|4733->2793|4986->3010|5002->3017|5091->3083|5207->3163|5223->3170|5316->3240|5432->3320|5448->3327|5611->3467|5867->3687|5883->3694|5973->3761|6089->3841|6105->3848|6199->3919|6315->3999|6331->4006|6496->4148|6750->4366|6766->4373|6855->4439|6971->4519|6987->4526|7080->4596|7196->4676|7212->4683|7375->4823|7633->5045|7649->5052|7742->5122|7858->5202|7874->5209|7971->5283|8087->5363|8103->5370|8274->5518|8591->5799|8607->5806|8700->5876|8816->5956|8832->5963|8929->6037|9045->6117|9061->6124|9232->6272|9485->6489|9501->6496|9590->6562|9706->6642|9722->6649|9815->6719|9931->6799|9947->6806|10110->6946|10366->7166|10382->7173|10472->7240|10588->7320|10604->7327|10698->7398|10814->7478|10830->7485|10995->7627|11249->7845|11265->7852|11354->7918|11470->7998|11486->8005|11579->8075|11695->8155|11711->8162|11874->8302|12132->8524|12148->8531|12241->8601|12357->8681|12373->8688|12470->8762|12586->8842|12602->8849|12773->8997|13105->9292|13122->9299|13216->9369|13333->9449|13350->9456|13448->9530|13565->9610|13582->9617|13754->9765|14008->9982|14025->9989|14115->10055|14232->10135|14249->10142|14343->10212|14460->10292|14477->10299|14641->10439|14898->10659|14915->10666|15006->10733|15123->10813|15140->10820|15235->10891|15352->10971|15369->10978|15535->11120|15790->11338|15807->11345|15897->11411|16014->11491|16031->11498|16125->11568|16242->11648|16259->11655|16423->11795|16682->12017|16699->12024|16793->12094|16910->12174|16927->12181|17025->12255|17142->12335|17159->12342|17331->12490|18288->13410|18305->13417|18395->13483|18512->13563|18529->13570|18623->13640|18740->13720|18757->13727|18921->13867|19189->14098|19206->14105|19292->14167|19409->14247|19426->14254|19516->14320|19633->14400|19650->14407|19806->14539|20074->14770|20091->14777|20178->14840|20295->14920|20312->14927|20403->14994|20520->15074|20537->15081|20695->15215|20955->15438|20972->15445|21058->15507|21175->15587|21192->15594|21282->15660|21399->15740|21416->15747|21572->15879|22469->16739|22486->16746|22582->16818|22699->16898|22716->16905|22816->16981|22933->17061|22950->17068|23126->17220|23379->17436|23396->17443|23488->17511|23605->17591|23622->17598|23718->17670|23835->17750|23852->17757|24020->17901|24276->18120|24293->18127|24386->18196|24503->18276|24520->18283|24617->18356|24734->18436|24751->18443|24921->18589|25175->18806|25192->18813|25284->18881|25401->18961|25418->18968|25514->19040|25631->19120|25648->19127|25816->19271|26064->19482|26081->19489|26177->19561|26294->19641|26311->19648|26411->19724|26528->19804|26545->19811|26721->19963|26879->20088
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|98->69|98->69|98->69|99->70|99->70|99->70|100->71|100->71|100->71|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|149->120|149->120|149->120|150->121|150->121|150->121|151->122|151->122|151->122|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|183->154|183->154|183->154|184->155|184->155|184->155|185->156|185->156|185->156|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|195->166|195->166|195->166|196->167|196->167|196->167|197->168|197->168|197->168|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|236->207|236->207|236->207|237->208|237->208|237->208|238->209|238->209|238->209|247->218
=======
                    DATE: Fri Jul 04 16:10:07 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprograma.scala.html
                    HASH: a81f4cb3277629421ae45534d9ca09fabf888b9d
                    MATRIX: 942->1|1426->338|1453->392|1739->642|1767->648|1957->802|1987->810|2155->942|2172->950|2206->962|2263->984|2309->1021|2357->1031|2462->1100|2480->1109|2520->1127|2565->1136|2579->1141|2640->1179|2679->1181|2696->1188|2758->1227|2846->1279|2864->1288|2904->1306|2949->1315|2963->1320|3024->1358|3063->1360|3080->1367|3142->1406|4092->2320|4108->2327|4201->2397|4317->2477|4333->2484|4430->2558|4546->2638|4562->2645|4733->2793|4986->3010|5002->3017|5091->3083|5207->3163|5223->3170|5316->3240|5432->3320|5448->3327|5611->3467|5867->3687|5883->3694|5973->3761|6089->3841|6105->3848|6199->3919|6315->3999|6331->4006|6496->4148|6750->4366|6766->4373|6855->4439|6971->4519|6987->4526|7080->4596|7196->4676|7212->4683|7375->4823|7633->5045|7649->5052|7742->5122|7858->5202|7874->5209|7971->5283|8087->5363|8103->5370|8274->5518|9321->6529|9337->6536|9430->6606|9546->6686|9562->6693|9659->6767|9775->6847|9791->6854|9962->7002|10215->7219|10231->7226|10320->7292|10436->7372|10452->7379|10545->7449|10661->7529|10677->7536|10840->7676|11096->7896|11112->7903|11202->7970|11318->8050|11334->8057|11428->8128|11544->8208|11560->8215|11725->8357|11979->8575|11995->8582|12084->8648|12201->8728|12218->8735|12312->8805|12429->8885|12446->8892|12610->9032|12869->9254|12886->9261|12980->9331|13097->9411|13114->9418|13212->9492|13329->9572|13346->9579|13518->9727|14557->10729|14574->10736|14668->10806|14785->10886|14802->10893|14900->10967|15017->11047|15034->11054|15206->11202|15460->11419|15477->11426|15567->11492|15684->11572|15701->11579|15795->11649|15912->11729|15929->11736|16093->11876|16350->12096|16367->12103|16458->12170|16575->12250|16592->12257|16687->12328|16804->12408|16821->12415|16987->12557|17242->12775|17259->12782|17349->12848|17466->12928|17483->12935|17577->13005|17694->13085|17711->13092|17875->13232|18134->13454|18151->13461|18245->13531|18362->13611|18379->13618|18477->13692|18594->13772|18611->13779|18783->13927|19740->14847|19757->14854|19847->14920|19964->15000|19981->15007|20075->15077|20192->15157|20209->15164|20373->15304|20641->15535|20658->15542|20744->15604|20861->15684|20878->15691|20968->15757|21085->15837|21102->15844|21258->15976|21526->16207|21543->16214|21630->16277|21747->16357|21764->16364|21855->16431|21972->16511|21989->16518|22147->16652|22407->16875|22424->16882|22510->16944|22627->17024|22644->17031|22734->17097|22851->17177|22868->17184|23024->17316|23921->18176|23938->18183|24034->18255|24151->18335|24168->18342|24268->18418|24385->18498|24402->18505|24578->18657|24831->18873|24848->18880|24940->18948|25057->19028|25074->19035|25170->19107|25287->19187|25304->19194|25472->19338|25728->19557|25745->19564|25838->19633|25955->19713|25972->19720|26069->19793|26186->19873|26203->19880|26373->20026|26627->20243|26644->20250|26736->20318|26853->20398|26870->20405|26966->20477|27083->20557|27100->20564|27268->20708|27516->20919|27533->20926|27629->20998|27746->21078|27763->21085|27863->21161|27980->21241|27997->21248|28173->21400|28331->21525
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|154->125|154->125|154->125|155->126|155->126|155->126|156->127|156->127|156->127|160->131|160->131|160->131|161->132|161->132|161->132|162->133|162->133|162->133|166->137|166->137|166->137|167->138|167->138|167->138|168->139|168->139|168->139|172->143|172->143|172->143|173->144|173->144|173->144|174->145|174->145|174->145|178->149|178->149|178->149|179->150|179->150|179->150|180->151|180->151|180->151|200->171|200->171|200->171|201->172|201->172|201->172|202->173|202->173|202->173|206->177|206->177|206->177|207->178|207->178|207->178|208->179|208->179|208->179|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|235->206|235->206|235->206|236->207|236->207|236->207|237->208|237->208|237->208|241->212|241->212|241->212|242->213|242->213|242->213|243->214|243->214|243->214|247->218|247->218|247->218|248->219|248->219|248->219|249->220|249->220|249->220|253->224|253->224|253->224|254->225|254->225|254->225|255->226|255->226|255->226|259->230|259->230|259->230|260->231|260->231|260->231|261->232|261->232|261->232|270->241
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
=======
                    DATE: Thu Jul 31 17:41:39 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeprograma.scala.html
                    HASH: 301f18f532dd53fa951a1f19861b4bb2a2945e7d
                    MATRIX: 942->1|1426->338|1453->392|1739->642|1767->648|2124->969|2154->977|2247->1034|2264->1042|2298->1054|2355->1076|2401->1113|2449->1123|2554->1192|2572->1201|2612->1219|2657->1228|2671->1233|2732->1271|2771->1273|2788->1280|2850->1319|2938->1371|2956->1380|2996->1398|3041->1407|3055->1412|3116->1450|3155->1452|3172->1459|3234->1498|4184->2412|4200->2419|4293->2489|4409->2569|4425->2576|4522->2650|4638->2730|4654->2737|4825->2885|5078->3102|5094->3109|5183->3175|5299->3255|5315->3262|5408->3332|5524->3412|5540->3419|5703->3559|5959->3779|5975->3786|6065->3853|6181->3933|6197->3940|6291->4011|6407->4091|6423->4098|6588->4240|6842->4458|6858->4465|6947->4531|7063->4611|7079->4618|7172->4688|7288->4768|7304->4775|7467->4915|7725->5137|7741->5144|7834->5214|7950->5294|7966->5301|8063->5375|8179->5455|8195->5462|8366->5610|9413->6621|9429->6628|9522->6698|9638->6778|9654->6785|9751->6859|9867->6939|9883->6946|10054->7094|10307->7311|10323->7318|10412->7384|10528->7464|10544->7471|10637->7541|10753->7621|10769->7628|10932->7768|11188->7988|11204->7995|11294->8062|11410->8142|11426->8149|11520->8220|11636->8300|11652->8307|11817->8449|12072->8667|12089->8674|12179->8740|12296->8820|12313->8827|12407->8897|12524->8977|12541->8984|12705->9124|12964->9346|12981->9353|13075->9423|13192->9503|13209->9510|13307->9584|13424->9664|13441->9671|13613->9819|14652->10821|14669->10828|14763->10898|14880->10978|14897->10985|14995->11059|15112->11139|15129->11146|15301->11294|15555->11511|15572->11518|15662->11584|15779->11664|15796->11671|15890->11741|16007->11821|16024->11828|16188->11968|16445->12188|16462->12195|16553->12262|16670->12342|16687->12349|16782->12420|16899->12500|16916->12507|17082->12649|17337->12867|17354->12874|17444->12940|17561->13020|17578->13027|17672->13097|17789->13177|17806->13184|17970->13324|18229->13546|18246->13553|18340->13623|18457->13703|18474->13710|18572->13784|18689->13864|18706->13871|18878->14019|19835->14939|19852->14946|19942->15012|20059->15092|20076->15099|20170->15169|20287->15249|20304->15256|20468->15396|20736->15627|20753->15634|20839->15696|20956->15776|20973->15783|21063->15849|21180->15929|21197->15936|21353->16068|21621->16299|21638->16306|21725->16369|21842->16449|21859->16456|21950->16523|22067->16603|22084->16610|22242->16744|22502->16967|22519->16974|22605->17036|22722->17116|22739->17123|22829->17189|22946->17269|22963->17276|23119->17408|24016->18268|24033->18275|24129->18347|24246->18427|24263->18434|24363->18510|24480->18590|24497->18597|24673->18749|24926->18965|24943->18972|25035->19040|25152->19120|25169->19127|25265->19199|25382->19279|25399->19286|25567->19430|25823->19649|25840->19656|25933->19725|26050->19805|26067->19812|26164->19885|26281->19965|26298->19972|26468->20118|26722->20335|26739->20342|26831->20410|26948->20490|26965->20497|27061->20569|27178->20649|27195->20656|27363->20800|27611->21011|27628->21018|27724->21090|27841->21170|27858->21177|27958->21253|28075->21333|28092->21340|28268->21492|28426->21617
                    LINES: 26->1|32->1|33->4|42->13|42->13|48->19|48->19|49->20|49->20|49->20|51->22|51->22|51->22|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|54->25|54->25|54->25|54->25|54->25|54->25|54->25|54->25|54->25|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|74->45|74->45|74->45|75->46|75->46|75->46|76->47|76->47|76->47|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|92->63|92->63|92->63|93->64|93->64|93->64|94->65|94->65|94->65|111->82|111->82|111->82|112->83|112->83|112->83|113->84|113->84|113->84|117->88|117->88|117->88|118->89|118->89|118->89|119->90|119->90|119->90|123->94|123->94|123->94|124->95|124->95|124->95|125->96|125->96|125->96|129->100|129->100|129->100|130->101|130->101|130->101|131->102|131->102|131->102|135->106|135->106|135->106|136->107|136->107|136->107|137->108|137->108|137->108|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|161->132|161->132|161->132|162->133|162->133|162->133|163->134|163->134|163->134|167->138|167->138|167->138|168->139|168->139|168->139|169->140|169->140|169->140|173->144|173->144|173->144|174->145|174->145|174->145|175->146|175->146|175->146|179->150|179->150|179->150|180->151|180->151|180->151|181->152|181->152|181->152|201->172|201->172|201->172|202->173|202->173|202->173|203->174|203->174|203->174|207->178|207->178|207->178|208->179|208->179|208->179|209->180|209->180|209->180|213->184|213->184|213->184|214->185|214->185|214->185|215->186|215->186|215->186|219->190|219->190|219->190|220->191|220->191|220->191|221->192|221->192|221->192|236->207|236->207|236->207|237->208|237->208|237->208|238->209|238->209|238->209|242->213|242->213|242->213|243->214|243->214|243->214|244->215|244->215|244->215|248->219|248->219|248->219|249->220|249->220|249->220|250->221|250->221|250->221|254->225|254->225|254->225|255->226|255->226|255->226|256->227|256->227|256->227|260->231|260->231|260->231|261->232|261->232|261->232|262->233|262->233|262->233|271->242
>>>>>>> 83ea5cc9add5bfe76dd8df164a8931789e2d0402
                    -- GENERATED --
                */
            