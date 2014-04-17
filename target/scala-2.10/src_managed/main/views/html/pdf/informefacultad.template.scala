
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
object informefacultad extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template9[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Facultad,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,facultad:Facultad, semestre:String, imagen:String):play.api.templates.Html = {
=======
object informefacultad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template10[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Facultad,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],facultad:Facultad, semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
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
	<div style="text-align:center"><p><b>Evaluación del Desempeño Docente """),_display_(Seq[Any](/*17.73*/semestre)),format.raw/*17.81*/("""</b></p></div>
	<div style="text-align:center"><p><b>Informe Final Facultad</b></p></div>
    <div style="text-align:center"><p><b>"""),_display_(Seq[Any](/*19.43*/facultad/*19.51*/.getNombre())),format.raw/*19.63*/("""</b></p></div>
  
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
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,facultad:Facultad,semestre:String,imagen:String): play.api.templates.Html = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,facultad,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Facultad,String,String) => play.api.templates.Html) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,facultad,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,facultad,semestre,imagen)
=======
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],facultad:Facultad,semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre,imagen)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Facultad,String,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre,imagen) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre,imagen)
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:04 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informefacultad.scala.html
                    HASH: ce04c7c4ab2342896d2e807c0d2f7fff36c41e56
                    MATRIX: 873->1|1312->310|1339->364|1625->614|1653->620|1843->774|1873->782|2041->914|2058->922|2092->934|2149->956|2195->993|2243->1003|3212->1936|3228->1943|3321->2013|3437->2093|3453->2100|3550->2174|3666->2254|3682->2261|3853->2409|4106->2626|4122->2633|4211->2699|4327->2779|4343->2786|4436->2856|4552->2936|4568->2943|4731->3083|4987->3303|5003->3310|5093->3377|5209->3457|5225->3464|5319->3535|5435->3615|5451->3622|5616->3764|5870->3982|5886->3989|5975->4055|6091->4135|6107->4142|6200->4212|6316->4292|6332->4299|6495->4439|6753->4661|6769->4668|6862->4738|6978->4818|6994->4825|7091->4899|7207->4979|7223->4986|7394->5134|7711->5415|7727->5422|7820->5492|7936->5572|7952->5579|8049->5653|8165->5733|8181->5740|8352->5888|8605->6105|8621->6112|8710->6178|8826->6258|8842->6265|8935->6335|9051->6415|9067->6422|9230->6562|9486->6782|9502->6789|9592->6856|9708->6936|9724->6943|9818->7014|9934->7094|9950->7101|10115->7243|10369->7461|10385->7468|10474->7534|10590->7614|10606->7621|10699->7691|10815->7771|10831->7778|10994->7918|11252->8140|11268->8147|11361->8217|11477->8297|11493->8304|11590->8378|11706->8458|11722->8465|11893->8613|12224->8908|12240->8915|12333->8985|12450->9065|12467->9072|12565->9146|12682->9226|12699->9233|12871->9381|13125->9598|13142->9605|13232->9671|13349->9751|13366->9758|13460->9828|13577->9908|13594->9915|13758->10055|14015->10275|14032->10282|14123->10349|14240->10429|14257->10436|14352->10507|14469->10587|14486->10594|14652->10736|14907->10954|14924->10961|15014->11027|15131->11107|15148->11114|15242->11184|15359->11264|15376->11271|15540->11411|15799->11633|15816->11640|15910->11710|16027->11790|16044->11797|16142->11871|16259->11951|16276->11958|16448->12106|17405->13026|17422->13033|17512->13099|17629->13179|17646->13186|17740->13256|17857->13336|17874->13343|18038->13483|18306->13714|18323->13721|18409->13783|18526->13863|18543->13870|18633->13936|18750->14016|18767->14023|18923->14155|19191->14386|19208->14393|19295->14456|19412->14536|19429->14543|19520->14610|19637->14690|19654->14697|19812->14831|20072->15054|20089->15061|20175->15123|20292->15203|20309->15210|20399->15276|20516->15356|20533->15363|20689->15495|21586->16355|21603->16362|21699->16434|21816->16514|21833->16521|21933->16597|22050->16677|22067->16684|22243->16836|22496->17052|22513->17059|22605->17127|22722->17207|22739->17214|22835->17286|22952->17366|22969->17373|23137->17517|23393->17736|23410->17743|23503->17812|23620->17892|23637->17899|23734->17972|23851->18052|23868->18059|24038->18205|24292->18422|24309->18429|24401->18497|24518->18577|24535->18584|24631->18656|24748->18736|24765->18743|24933->18887|25181->19098|25198->19105|25294->19177|25411->19257|25428->19264|25528->19340|25645->19420|25662->19427|25838->19579|25996->19704
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|76->47|76->47|76->47|77->48|77->48|77->48|78->49|78->49|78->49|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|95->66|95->66|95->66|96->67|96->67|96->67|97->68|97->68|97->68|101->72|101->72|101->72|102->73|102->73|102->73|103->74|103->74|103->74|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|146->117|146->117|146->117|147->118|147->118|147->118|148->119|148->119|148->119|152->123|152->123|152->123|153->124|153->124|153->124|154->125|154->125|154->125|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|180->151|180->151|180->151|181->152|181->152|181->152|182->153|182->153|182->153|186->157|186->157|186->157|187->158|187->158|187->158|188->159|188->159|188->159|192->163|192->163|192->163|193->164|193->164|193->164|194->165|194->165|194->165|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|227->198|227->198|227->198|228->199|228->199|228->199|229->200|229->200|229->200|233->204|233->204|233->204|234->205|234->205|234->205|235->206|235->206|235->206|244->215
=======
                    DATE: Mon Apr 14 19:59:01 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informefacultad.scala.html
                    HASH: a1e6e4a1d03993b7516f2561855faff28be995a3
                    MATRIX: 942->1|1425->337|1452->391|1738->641|1766->647|1956->801|1986->809|2154->941|2171->949|2205->961|2262->983|2308->1020|2356->1030|2444->1082|2462->1091|2502->1109|2547->1118|2561->1123|2622->1161|2661->1163|2678->1170|2740->1209|2810->1243|2828->1252|2868->1270|2913->1279|2927->1284|2988->1322|3027->1324|3044->1331|3106->1370|4056->2284|4072->2291|4165->2361|4281->2441|4297->2448|4394->2522|4510->2602|4526->2609|4697->2757|4950->2974|4966->2981|5055->3047|5171->3127|5187->3134|5280->3204|5396->3284|5412->3291|5575->3431|5831->3651|5847->3658|5937->3725|6053->3805|6069->3812|6163->3883|6279->3963|6295->3970|6460->4112|6714->4330|6730->4337|6819->4403|6935->4483|6951->4490|7044->4560|7160->4640|7176->4647|7339->4787|7597->5009|7613->5016|7706->5086|7822->5166|7838->5173|7935->5247|8051->5327|8067->5334|8238->5482|8555->5763|8571->5770|8664->5840|8780->5920|8796->5927|8893->6001|9009->6081|9025->6088|9196->6236|9449->6453|9465->6460|9554->6526|9670->6606|9686->6613|9779->6683|9895->6763|9911->6770|10074->6910|10330->7130|10346->7137|10436->7204|10552->7284|10568->7291|10662->7362|10778->7442|10794->7449|10959->7591|11213->7809|11229->7816|11318->7882|11434->7962|11450->7969|11543->8039|11659->8119|11675->8126|11838->8266|12096->8488|12112->8495|12205->8565|12321->8645|12337->8652|12434->8726|12550->8806|12566->8813|12737->8961|13069->9256|13086->9263|13180->9333|13297->9413|13314->9420|13412->9494|13529->9574|13546->9581|13718->9729|13972->9946|13989->9953|14079->10019|14196->10099|14213->10106|14307->10176|14424->10256|14441->10263|14605->10403|14862->10623|14879->10630|14970->10697|15087->10777|15104->10784|15199->10855|15316->10935|15333->10942|15499->11084|15754->11302|15771->11309|15861->11375|15978->11455|15995->11462|16089->11532|16206->11612|16223->11619|16387->11759|16646->11981|16663->11988|16757->12058|16874->12138|16891->12145|16989->12219|17106->12299|17123->12306|17295->12454|18252->13374|18269->13381|18359->13447|18476->13527|18493->13534|18587->13604|18704->13684|18721->13691|18885->13831|19153->14062|19170->14069|19256->14131|19373->14211|19390->14218|19480->14284|19597->14364|19614->14371|19770->14503|20038->14734|20055->14741|20142->14804|20259->14884|20276->14891|20367->14958|20484->15038|20501->15045|20659->15179|20919->15402|20936->15409|21022->15471|21139->15551|21156->15558|21246->15624|21363->15704|21380->15711|21536->15843|22433->16703|22450->16710|22546->16782|22663->16862|22680->16869|22780->16945|22897->17025|22914->17032|23090->17184|23343->17400|23360->17407|23452->17475|23569->17555|23586->17562|23682->17634|23799->17714|23816->17721|23984->17865|24240->18084|24257->18091|24350->18160|24467->18240|24484->18247|24581->18320|24698->18400|24715->18407|24885->18553|25139->18770|25156->18777|25248->18845|25365->18925|25382->18932|25478->19004|25595->19084|25612->19091|25780->19235|26028->19446|26045->19453|26141->19525|26258->19605|26275->19612|26375->19688|26492->19768|26509->19775|26685->19927|26843->20052
                    LINES: 26->1|32->1|33->4|42->13|42->13|46->17|46->17|48->19|48->19|48->19|50->21|50->21|50->21|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|53->24|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|98->69|98->69|98->69|99->70|99->70|99->70|100->71|100->71|100->71|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|149->120|149->120|149->120|150->121|150->121|150->121|151->122|151->122|151->122|155->126|155->126|155->126|156->127|156->127|156->127|157->128|157->128|157->128|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|183->154|183->154|183->154|184->155|184->155|184->155|185->156|185->156|185->156|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|195->166|195->166|195->166|196->167|196->167|196->167|197->168|197->168|197->168|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|236->207|236->207|236->207|237->208|237->208|237->208|238->209|238->209|238->209|247->218
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            