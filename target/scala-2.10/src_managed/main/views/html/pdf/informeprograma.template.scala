
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
object informeprograma extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template9[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Programa,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,programa:Programa, semestre:String, imagen:String):play.api.templates.Html = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.311*/("""
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
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*35.73*/formato/*35.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*35.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*36.73*/formato/*36.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*36.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*37.73*/formato/*37.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*37.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*41.73*/formato/*41.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*41.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*42.73*/formato/*42.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*42.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*43.73*/formato/*43.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*43.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*47.73*/formato/*47.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*47.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*48.73*/formato/*48.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*48.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*49.73*/formato/*49.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*49.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*53.73*/formato/*53.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*53.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*54.73*/formato/*54.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*54.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*55.73*/formato/*55.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*55.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*59.73*/formato/*59.80*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*59.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*60.73*/formato/*60.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*60.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*61.73*/formato/*61.80*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*61.228*/(""" %</td>
                </tr>    
       			 <tr style="font-size: 8pt;">
				<td class="row_headers" rowspan='5'>Saber Específico</td>
				<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*66.73*/formato/*66.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*66.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*67.73*/formato/*67.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*67.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*68.73*/formato/*68.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*68.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*72.73*/formato/*72.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*72.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*73.73*/formato/*73.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*73.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*74.73*/formato/*74.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*74.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*78.73*/formato/*78.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*78.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*79.73*/formato/*79.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*79.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*80.73*/formato/*80.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*80.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*84.73*/formato/*84.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*84.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*85.73*/formato/*85.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*85.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*86.73*/formato/*86.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*86.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*90.73*/formato/*90.80*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*90.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*91.73*/formato/*91.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*91.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*92.73*/formato/*92.80*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*92.228*/(""" %</td>
                </tr>    
          
   
	 			 <tr style="font-size: 8pt;">
				<td class="row_headers" rowspan='5'>Saber Relacional</td>
     			<td class="row_headers" align="center" valign="middle">Inferior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*99.73*/formato/*99.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*99.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*100.73*/formato/*100.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*100.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*101.73*/formato/*101.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*101.228*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*105.73*/formato/*105.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*105.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*106.73*/formato/*106.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*106.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*107.73*/formato/*107.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*107.220*/(""" %</td>
                </tr>  
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*111.73*/formato/*111.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*111.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*112.73*/formato/*112.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*112.151*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*113.73*/formato/*113.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*113.222*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*117.73*/formato/*117.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*117.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*118.73*/formato/*118.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*118.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*119.73*/formato/*119.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*119.220*/(""" %</td>
                </tr> 
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*123.73*/formato/*123.80*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*123.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*124.73*/formato/*124.80*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*124.154*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*125.73*/formato/*125.80*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*125.228*/(""" %</td>
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
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*145.73*/formato/*145.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*145.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*146.73*/formato/*146.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*146.150*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*147.73*/formato/*147.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*147.220*/(""" %</td>
                </tr>
              	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Cumple Parcialmente</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*151.73*/formato/*151.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*151.142*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*152.73*/formato/*152.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*152.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*153.73*/formato/*153.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*153.212*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Cumple Totalmente</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*157.73*/formato/*157.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*157.143*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*158.73*/formato/*158.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*158.147*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*159.73*/formato/*159.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*159.214*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">No Aplica</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*163.73*/formato/*163.80*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*163.142*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*164.73*/formato/*164.80*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*164.146*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*165.73*/formato/*165.80*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*165.212*/(""" %</td>
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
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*180.73*/formato/*180.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*180.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*181.73*/formato/*181.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*181.156*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*182.73*/formato/*182.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*182.232*/(""" %</td>
                </tr>
              	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Bajo</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*186.73*/formato/*186.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*186.148*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*187.73*/formato/*187.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*187.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*188.73*/formato/*188.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*188.224*/(""" %</td>
                </tr>
                	 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Medio</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*192.73*/formato/*192.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*192.149*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*193.73*/formato/*193.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*193.153*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*194.73*/formato/*194.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*194.226*/(""" %</td>
                </tr>
                 <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Alto</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*198.73*/formato/*198.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*198.148*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*199.73*/formato/*199.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*199.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*200.73*/formato/*200.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*200.224*/(""" %</td>
                </tr>
				   <tr style="font-size: 8pt;">
				<td class="row_headers" align="center" valign="middle">Superior</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*204.73*/formato/*204.80*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*204.152*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*205.73*/formato/*205.80*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*205.156*/(""" %</td>
                <td class="row_headers" align="center" valign="middle">"""),_display_(Seq[Any](/*206.73*/formato/*206.80*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*206.232*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*215.12*/("""
  </div> <!--  docencia -->
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
"""))}
    }
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,programa:Programa,semestre:String,imagen:String): play.api.templates.Html = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,programa,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Programa,String,String) => play.api.templates.Html) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,programa,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,programa,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:03 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeprograma.scala.html
                    HASH: f38089c63a6b432af9496f2c450574868ac7542a
                    MATRIX: 873->1|1312->310|1339->364|1625->614|1653->620|1843->774|1873->782|2041->914|2058->922|2092->934|2149->956|2195->993|2243->1003|3212->1936|3228->1943|3321->2013|3437->2093|3453->2100|3550->2174|3666->2254|3682->2261|3853->2409|4106->2626|4122->2633|4211->2699|4327->2779|4343->2786|4436->2856|4552->2936|4568->2943|4731->3083|4987->3303|5003->3310|5093->3377|5209->3457|5225->3464|5319->3535|5435->3615|5451->3622|5616->3764|5870->3982|5886->3989|5975->4055|6091->4135|6107->4142|6200->4212|6316->4292|6332->4299|6495->4439|6753->4661|6769->4668|6862->4738|6978->4818|6994->4825|7091->4899|7207->4979|7223->4986|7394->5134|7711->5415|7727->5422|7820->5492|7936->5572|7952->5579|8049->5653|8165->5733|8181->5740|8352->5888|8605->6105|8621->6112|8710->6178|8826->6258|8842->6265|8935->6335|9051->6415|9067->6422|9230->6562|9486->6782|9502->6789|9592->6856|9708->6936|9724->6943|9818->7014|9934->7094|9950->7101|10115->7243|10369->7461|10385->7468|10474->7534|10590->7614|10606->7621|10699->7691|10815->7771|10831->7778|10994->7918|11252->8140|11268->8147|11361->8217|11477->8297|11493->8304|11590->8378|11706->8458|11722->8465|11893->8613|12224->8908|12240->8915|12333->8985|12450->9065|12467->9072|12565->9146|12682->9226|12699->9233|12871->9381|13125->9598|13142->9605|13232->9671|13349->9751|13366->9758|13460->9828|13577->9908|13594->9915|13758->10055|14015->10275|14032->10282|14123->10349|14240->10429|14257->10436|14352->10507|14469->10587|14486->10594|14652->10736|14907->10954|14924->10961|15014->11027|15131->11107|15148->11114|15242->11184|15359->11264|15376->11271|15540->11411|15799->11633|15816->11640|15910->11710|16027->11790|16044->11797|16142->11871|16259->11951|16276->11958|16448->12106|17405->13026|17422->13033|17512->13099|17629->13179|17646->13186|17740->13256|17857->13336|17874->13343|18038->13483|18306->13714|18323->13721|18409->13783|18526->13863|18543->13870|18633->13936|18750->14016|18767->14023|18923->14155|19191->14386|19208->14393|19295->14456|19412->14536|19429->14543|19520->14610|19637->14690|19654->14697|19812->14831|20072->15054|20089->15061|20175->15123|20292->15203|20309->15210|20399->15276|20516->15356|20533->15363|20689->15495|21586->16355|21603->16362|21699->16434|21816->16514|21833->16521|21933->16597|22050->16677|22067->16684|22243->16836|22496->17052|22513->17059|22605->17127|22722->17207|22739->17214|22835->17286|22952->17366|22969->17373|23137->17517|23393->17736|23410->17743|23503->17812|23620->17892|23637->17899|23734->17972|23851->18052|23868->18059|24038->18205|24292->18422|24309->18429|24401->18497|24518->18577|24535->18584|24631->18656|24748->18736|24765->18743|24933->18887|25181->19098|25198->19105|25294->19177|25411->19257|25428->19264|25528->19340|25645->19420|25662->19427|25838->19579|25996->19704
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|76->47|76->47|76->47|77->48|77->48|77->48|78->49|78->49|78->49|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|95->66|95->66|95->66|96->67|96->67|96->67|97->68|97->68|97->68|101->72|101->72|101->72|102->73|102->73|102->73|103->74|103->74|103->74|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|146->117|146->117|146->117|147->118|147->118|147->118|148->119|148->119|148->119|152->123|152->123|152->123|153->124|153->124|153->124|154->125|154->125|154->125|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|180->151|180->151|180->151|181->152|181->152|181->152|182->153|182->153|182->153|186->157|186->157|186->157|187->158|187->158|187->158|188->159|188->159|188->159|192->163|192->163|192->163|193->164|193->164|193->164|194->165|194->165|194->165|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|227->198|227->198|227->198|228->199|228->199|228->199|229->200|229->200|229->200|233->204|233->204|233->204|234->205|234->205|234->205|235->206|235->206|235->206|244->215
                    -- GENERATED --
                */
            