
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
object informefacultad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template10[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Facultad,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],facultad:Facultad, semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.338*/("""
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
	<div style="text-align:center"><p><b>Evaluación del Desempeño Docente """),_display_(Seq[Any](/*18.73*/semestre)),format.raw/*18.81*/("""</b></p></div>
	<div style="text-align:center"><p><b>Informe Final de Facultad</b></p></div>
    <div style="text-align:center"><p><b>"""),_display_(Seq[Any](/*20.43*/facultad/*20.51*/.getNombre())),format.raw/*20.63*/("""</b></p></div>
  
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
                <br></br>
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
   				<br></br>
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
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],facultad:Facultad,semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Facultad,String,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:44 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informefacultad.scala.html
                    HASH: 03e25c5ca8b72393f655d07b8aec902fcb8599e2
                    MATRIX: 942->1|1425->337|1452->391|1738->641|1766->647|1956->801|1986->809|2099->886|2127->892|2220->949|2237->957|2271->969|2328->991|2374->1028|2422->1038|2510->1090|2528->1099|2568->1117|2613->1126|2627->1131|2688->1169|2727->1171|2744->1178|2806->1217|2876->1251|2894->1260|2934->1278|2979->1287|2993->1292|3054->1330|3093->1332|3110->1339|3172->1378|4122->2292|4138->2299|4231->2369|4347->2449|4363->2456|4460->2530|4576->2610|4592->2617|4763->2765|5016->2982|5032->2989|5121->3055|5237->3135|5253->3142|5346->3212|5462->3292|5478->3299|5641->3439|5897->3659|5913->3666|6003->3733|6119->3813|6135->3820|6229->3891|6345->3971|6361->3978|6526->4120|6780->4338|6796->4345|6885->4411|7001->4491|7017->4498|7110->4568|7226->4648|7242->4655|7405->4795|7663->5017|7679->5024|7772->5094|7888->5174|7904->5181|8001->5255|8117->5335|8133->5342|8304->5490|8621->5771|8637->5778|8730->5848|8846->5928|8862->5935|8959->6009|9075->6089|9091->6096|9262->6244|9515->6461|9531->6468|9620->6534|9736->6614|9752->6621|9845->6691|9961->6771|9977->6778|10140->6918|10396->7138|10412->7145|10502->7212|10618->7292|10634->7299|10728->7370|10844->7450|10860->7457|11025->7599|11279->7817|11295->7824|11384->7890|11500->7970|11516->7977|11609->8047|11725->8127|11741->8134|11904->8274|12162->8496|12178->8503|12271->8573|12387->8653|12403->8660|12500->8734|12616->8814|12632->8821|12803->8969|13135->9264|13152->9271|13246->9341|13363->9421|13380->9428|13478->9502|13595->9582|13612->9589|13784->9737|14038->9954|14055->9961|14145->10027|14262->10107|14279->10114|14373->10184|14490->10264|14507->10271|14671->10411|14928->10631|14945->10638|15036->10705|15153->10785|15170->10792|15265->10863|15382->10943|15399->10950|15565->11092|15820->11310|15837->11317|15927->11383|16044->11463|16061->11470|16155->11540|16272->11620|16289->11627|16453->11767|16712->11989|16729->11996|16823->12066|16940->12146|16957->12153|17055->12227|17172->12307|17189->12314|17361->12462|18318->13382|18335->13389|18425->13455|18542->13535|18559->13542|18653->13612|18770->13692|18787->13699|18951->13839|19219->14070|19236->14077|19322->14139|19439->14219|19456->14226|19546->14292|19663->14372|19680->14379|19836->14511|20104->14742|20121->14749|20208->14812|20325->14892|20342->14899|20433->14966|20550->15046|20567->15053|20725->15187|20985->15410|21002->15417|21088->15479|21205->15559|21222->15566|21312->15632|21429->15712|21446->15719|21602->15851|22499->16711|22516->16718|22612->16790|22729->16870|22746->16877|22846->16953|22963->17033|22980->17040|23156->17192|23409->17408|23426->17415|23518->17483|23635->17563|23652->17570|23748->17642|23865->17722|23882->17729|24050->17873|24306->18092|24323->18099|24416->18168|24533->18248|24550->18255|24647->18328|24764->18408|24781->18415|24951->18561|25205->18778|25222->18785|25314->18853|25431->18933|25448->18940|25544->19012|25661->19092|25678->19099|25846->19243|26094->19454|26111->19461|26207->19533|26324->19613|26341->19620|26441->19696|26558->19776|26575->19783|26751->19935|26909->20060
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|47->18|47->18|48->19|48->19|48->19|50->21|50->21|50->21|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|98->69|98->69|98->69|99->70|99->70|99->70|100->71|100->71|100->71|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|149->120|149->120|149->120|150->121|150->121|150->121|151->122|151->122|151->122|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|183->154|183->154|183->154|184->155|184->155|184->155|185->156|185->156|185->156|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|195->166|195->166|195->166|196->167|196->167|196->167|197->168|197->168|197->168|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|236->207|236->207|236->207|237->208|237->208|237->208|238->209|238->209|238->209|247->218
=======
                    DATE: Mon Jun 16 14:32:14 COT 2014
=======
                    DATE: Fri Jul 04 16:10:09 COT 2014
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informefacultad.scala.html
                    HASH: 17132fd30822332b97502d622fabc95983315665
                    MATRIX: 942->1|1425->337|1452->391|1738->641|1766->647|1956->801|1986->809|2154->941|2171->949|2205->961|2262->983|2308->1020|2356->1030|2461->1099|2479->1108|2519->1126|2564->1135|2578->1140|2639->1178|2678->1180|2695->1187|2757->1226|2845->1278|2863->1287|2903->1305|2948->1314|2962->1319|3023->1357|3062->1359|3079->1366|3141->1405|4091->2319|4107->2326|4200->2396|4316->2476|4332->2483|4429->2557|4545->2637|4561->2644|4732->2792|4985->3009|5001->3016|5090->3082|5206->3162|5222->3169|5315->3239|5431->3319|5447->3326|5610->3466|5866->3686|5882->3693|5972->3760|6088->3840|6104->3847|6198->3918|6314->3998|6330->4005|6495->4147|6749->4365|6765->4372|6854->4438|6970->4518|6986->4525|7079->4595|7195->4675|7211->4682|7374->4822|7632->5044|7648->5051|7741->5121|7857->5201|7873->5208|7970->5282|8086->5362|8102->5369|8273->5517|9355->6563|9371->6570|9464->6640|9580->6720|9596->6727|9693->6801|9809->6881|9825->6888|9996->7036|10249->7253|10265->7260|10354->7326|10470->7406|10486->7413|10579->7483|10695->7563|10711->7570|10874->7710|11130->7930|11146->7937|11236->8004|11352->8084|11368->8091|11462->8162|11578->8242|11594->8249|11759->8391|12013->8609|12029->8616|12118->8682|12235->8762|12252->8769|12346->8839|12463->8919|12480->8926|12644->9066|12903->9288|12920->9295|13014->9365|13131->9445|13148->9452|13246->9526|13363->9606|13380->9613|13552->9761|14628->10800|14645->10807|14739->10877|14856->10957|14873->10964|14971->11038|15088->11118|15105->11125|15277->11273|15531->11490|15548->11497|15638->11563|15755->11643|15772->11650|15866->11720|15983->11800|16000->11807|16164->11947|16421->12167|16438->12174|16529->12241|16646->12321|16663->12328|16758->12399|16875->12479|16892->12486|17058->12628|17313->12846|17330->12853|17420->12919|17537->12999|17554->13006|17648->13076|17765->13156|17782->13163|17946->13303|18205->13525|18222->13532|18316->13602|18433->13682|18450->13689|18548->13763|18665->13843|18682->13850|18854->13998|19811->14918|19828->14925|19918->14991|20035->15071|20052->15078|20146->15148|20263->15228|20280->15235|20444->15375|20712->15606|20729->15613|20815->15675|20932->15755|20949->15762|21039->15828|21156->15908|21173->15915|21329->16047|21597->16278|21614->16285|21701->16348|21818->16428|21835->16435|21926->16502|22043->16582|22060->16589|22218->16723|22478->16946|22495->16953|22581->17015|22698->17095|22715->17102|22805->17168|22922->17248|22939->17255|23095->17387|23992->18247|24009->18254|24105->18326|24222->18406|24239->18413|24339->18489|24456->18569|24473->18576|24649->18728|24902->18944|24919->18951|25011->19019|25128->19099|25145->19106|25241->19178|25358->19258|25375->19265|25543->19409|25799->19628|25816->19635|25909->19704|26026->19784|26043->19791|26140->19864|26257->19944|26274->19951|26444->20097|26698->20314|26715->20321|26807->20389|26924->20469|26941->20476|27037->20548|27154->20628|27171->20635|27339->20779|27587->20990|27604->20997|27700->21069|27817->21149|27834->21156|27934->21232|28051->21312|28068->21319|28244->21471|28402->21596
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|154->125|154->125|154->125|155->126|155->126|155->126|156->127|156->127|156->127|160->131|160->131|160->131|161->132|161->132|161->132|162->133|162->133|162->133|166->137|166->137|166->137|167->138|167->138|167->138|168->139|168->139|168->139|172->143|172->143|172->143|173->144|173->144|173->144|174->145|174->145|174->145|178->149|178->149|178->149|179->150|179->150|179->150|180->151|180->151|180->151|200->171|200->171|200->171|201->172|201->172|201->172|202->173|202->173|202->173|206->177|206->177|206->177|207->178|207->178|207->178|208->179|208->179|208->179|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|235->206|235->206|235->206|236->207|236->207|236->207|237->208|237->208|237->208|241->212|241->212|241->212|242->213|242->213|242->213|243->214|243->214|243->214|247->218|247->218|247->218|248->219|248->219|248->219|249->220|249->220|249->220|253->224|253->224|253->224|254->225|254->225|254->225|255->226|255->226|255->226|259->230|259->230|259->230|260->231|260->231|260->231|261->232|261->232|261->232|270->241
>>>>>>> 93429d7fbc474b9d33705b1aa2e201ce50fe2153
=======
                    DATE: Thu Jul 31 18:17:18 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informefacultad.scala.html
                    HASH: d068150108704c4603bf66746879a8e7d07d2b2f
                    MATRIX: 942->1|1425->337|1452->391|1738->641|1766->647|2047->892|2077->900|2248->1035|2265->1043|2299->1055|2356->1077|2402->1114|2450->1124|2555->1193|2573->1202|2613->1220|2658->1229|2672->1234|2733->1272|2772->1274|2789->1281|2851->1320|2939->1372|2957->1381|2997->1399|3042->1408|3056->1413|3117->1451|3156->1453|3173->1460|3235->1499|4185->2413|4201->2420|4294->2490|4410->2570|4426->2577|4523->2651|4639->2731|4655->2738|4826->2886|5079->3103|5095->3110|5184->3176|5300->3256|5316->3263|5409->3333|5525->3413|5541->3420|5704->3560|5960->3780|5976->3787|6066->3854|6182->3934|6198->3941|6292->4012|6408->4092|6424->4099|6589->4241|6843->4459|6859->4466|6948->4532|7064->4612|7080->4619|7173->4689|7289->4769|7305->4776|7468->4916|7726->5138|7742->5145|7835->5215|7951->5295|7967->5302|8064->5376|8180->5456|8196->5463|8367->5611|9449->6657|9465->6664|9558->6734|9674->6814|9690->6821|9787->6895|9903->6975|9919->6982|10090->7130|10343->7347|10359->7354|10448->7420|10564->7500|10580->7507|10673->7577|10789->7657|10805->7664|10968->7804|11224->8024|11240->8031|11330->8098|11446->8178|11462->8185|11556->8256|11672->8336|11688->8343|11853->8485|12108->8703|12125->8710|12215->8776|12332->8856|12349->8863|12443->8933|12560->9013|12577->9020|12741->9160|13000->9382|13017->9389|13111->9459|13228->9539|13245->9546|13343->9620|13460->9700|13477->9707|13649->9855|14725->10894|14742->10901|14836->10971|14953->11051|14970->11058|15068->11132|15185->11212|15202->11219|15374->11367|15628->11584|15645->11591|15735->11657|15852->11737|15869->11744|15963->11814|16080->11894|16097->11901|16261->12041|16518->12261|16535->12268|16626->12335|16743->12415|16760->12422|16855->12493|16972->12573|16989->12580|17155->12722|17410->12940|17427->12947|17517->13013|17634->13093|17651->13100|17745->13170|17862->13250|17879->13257|18043->13397|18302->13619|18319->13626|18413->13696|18530->13776|18547->13783|18645->13857|18762->13937|18779->13944|18951->14092|19908->15012|19925->15019|20015->15085|20132->15165|20149->15172|20243->15242|20360->15322|20377->15329|20541->15469|20809->15700|20826->15707|20912->15769|21029->15849|21046->15856|21136->15922|21253->16002|21270->16009|21426->16141|21694->16372|21711->16379|21798->16442|21915->16522|21932->16529|22023->16596|22140->16676|22157->16683|22315->16817|22575->17040|22592->17047|22678->17109|22795->17189|22812->17196|22902->17262|23019->17342|23036->17349|23192->17481|24089->18341|24106->18348|24202->18420|24319->18500|24336->18507|24436->18583|24553->18663|24570->18670|24746->18822|24999->19038|25016->19045|25108->19113|25225->19193|25242->19200|25338->19272|25455->19352|25472->19359|25640->19503|25896->19722|25913->19729|26006->19798|26123->19878|26140->19885|26237->19958|26354->20038|26371->20045|26541->20191|26795->20408|26812->20415|26904->20483|27021->20563|27038->20570|27134->20642|27251->20722|27268->20729|27436->20873|27684->21084|27701->21091|27797->21163|27914->21243|27931->21250|28031->21326|28148->21406|28165->21413|28341->21565|28499->21690
                    LINES: 26->1|32->1|33->4|42->13|42->13|47->18|47->18|49->20|49->20|49->20|51->22|51->22|51->22|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|54->25|54->25|54->25|54->25|54->25|54->25|54->25|54->25|54->25|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|74->45|74->45|74->45|75->46|75->46|75->46|76->47|76->47|76->47|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|92->63|92->63|92->63|93->64|93->64|93->64|94->65|94->65|94->65|111->82|111->82|111->82|112->83|112->83|112->83|113->84|113->84|113->84|117->88|117->88|117->88|118->89|118->89|118->89|119->90|119->90|119->90|123->94|123->94|123->94|124->95|124->95|124->95|125->96|125->96|125->96|129->100|129->100|129->100|130->101|130->101|130->101|131->102|131->102|131->102|135->106|135->106|135->106|136->107|136->107|136->107|137->108|137->108|137->108|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|161->132|161->132|161->132|162->133|162->133|162->133|163->134|163->134|163->134|167->138|167->138|167->138|168->139|168->139|168->139|169->140|169->140|169->140|173->144|173->144|173->144|174->145|174->145|174->145|175->146|175->146|175->146|179->150|179->150|179->150|180->151|180->151|180->151|181->152|181->152|181->152|201->172|201->172|201->172|202->173|202->173|202->173|203->174|203->174|203->174|207->178|207->178|207->178|208->179|208->179|208->179|209->180|209->180|209->180|213->184|213->184|213->184|214->185|214->185|214->185|215->186|215->186|215->186|219->190|219->190|219->190|220->191|220->191|220->191|221->192|221->192|221->192|236->207|236->207|236->207|237->208|237->208|237->208|238->209|238->209|238->209|242->213|242->213|242->213|243->214|243->214|243->214|244->215|244->215|244->215|248->219|248->219|248->219|249->220|249->220|249->220|250->221|250->221|250->221|254->225|254->225|254->225|255->226|255->226|255->226|256->227|256->227|256->227|260->231|260->231|260->231|261->232|261->232|261->232|262->233|262->233|262->233|271->242
>>>>>>> 83ea5cc9add5bfe76dd8df164a8931789e2d0402
                    -- GENERATED --
                */
            