
package views.html.informes

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
object informefinal extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion ):play.api.templates.Html = {
=======
object informefinal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion, profesor:Profesor,semestre:String ):play.api.templates.HtmlFormat.Appendable = {
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.297*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<h2 style="text-align: center;">"""),_display_(Seq[Any](/*5.34*/profesor/*5.42*/.getApellidos())),format.raw/*5.57*/(""" """),_display_(Seq[Any](/*5.59*/profesor/*5.67*/.getNombres())),format.raw/*5.80*/(""" - Informe Final """),_display_(Seq[Any](/*5.98*/semestre)),format.raw/*5.106*/("""</h2>
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Informe Final</a></li>
		
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla"></div>
	  """),_display_(Seq[Any](/*15.5*/defining(new DecimalFormat("##0.00"))/*15.42*/{formato=>_display_(Seq[Any](format.raw/*15.52*/("""
	<h2>Campo de La Docencia</h2>
	<h3>Saber Pedagógico</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Estudiantes 80%</td>
		<td class="row_headers" >Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*32.42*/formato/*32.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*32.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*33.42*/formato/*33.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*33.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*34.42*/formato/*34.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*34.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*38.42*/formato/*38.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*38.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*39.42*/formato/*39.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*39.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*40.42*/formato/*40.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*40.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*44.42*/formato/*44.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*44.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*45.42*/formato/*45.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*45.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*46.42*/formato/*46.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*46.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*50.42*/formato/*50.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*50.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*51.42*/formato/*51.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*51.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*52.42*/formato/*52.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*52.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*56.42*/formato/*56.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*56.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*57.42*/formato/*57.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*57.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*58.42*/formato/*58.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*58.197*/(""" %</td>
                </tr>    
              
       
          </tbody>
          </table>
          <h3>Saber Específico</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Estudiantes 80%</td>
		<td class="row_headers" >Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*79.42*/formato/*79.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*79.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*80.42*/formato/*80.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*80.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*81.42*/formato/*81.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*81.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*85.42*/formato/*85.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*85.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*86.42*/formato/*86.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*86.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*87.42*/formato/*87.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*87.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*91.42*/formato/*91.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*91.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*92.42*/formato/*92.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*92.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*93.42*/formato/*93.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*93.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*97.42*/formato/*97.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*97.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*98.42*/formato/*98.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*98.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*99.42*/formato/*99.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*99.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*103.42*/formato/*103.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*103.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*104.42*/formato/*104.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*104.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*105.42*/formato/*105.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*105.197*/(""" %</td>
                </tr>    
          
          </tbody>
          </table>
    <h3>Saber Relacional</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Estudiantes 80%</td>
		<td class="row_headers" >Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*125.42*/formato/*125.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*125.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*126.42*/formato/*126.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*126.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*127.42*/formato/*127.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*127.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*131.42*/formato/*131.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*131.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*132.42*/formato/*132.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*132.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*133.42*/formato/*133.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*133.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*137.42*/formato/*137.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*137.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*138.42*/formato/*138.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*138.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*139.42*/formato/*139.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*139.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*143.42*/formato/*143.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*143.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*144.42*/formato/*144.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*144.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*145.42*/formato/*145.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*145.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*149.42*/formato/*149.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*149.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*150.42*/formato/*150.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*150.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*151.42*/formato/*151.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*151.197*/(""" %</td>
                </tr>    
              
             
      
        
          
          </tbody>
          </table>
              <h3>Gestión</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Directivo 60%</td>
		<td class="row_headers" >Autoevaluación 40%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">No Cumple</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*175.42*/formato/*175.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*175.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*176.42*/formato/*176.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*176.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*177.42*/formato/*177.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*177.189*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Cumple Parcialmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*181.42*/formato/*181.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*181.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*182.42*/formato/*182.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*182.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*183.42*/formato/*183.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*183.181*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Cumple Totalmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*187.42*/formato/*187.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*187.112*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*188.42*/formato/*188.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*188.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*189.42*/formato/*189.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*189.183*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">No Aplica</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*193.42*/formato/*193.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*193.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*194.42*/formato/*194.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*194.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*195.42*/formato/*195.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*195.181*/(""" %</td>
                </tr>
				
             
      
        
          
          </tbody>
          </table>
                <h3>Investigación</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Directivo 60%</td>
		<td class="row_headers" >Autoevaluación 40%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*219.42*/formato/*219.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*219.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*220.42*/formato/*220.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*220.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*221.42*/formato/*221.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*221.201*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*225.42*/formato/*225.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*225.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*226.42*/formato/*226.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*226.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*227.42*/formato/*227.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*227.193*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*231.42*/formato/*231.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*231.118*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*232.42*/formato/*232.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*232.122*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*233.42*/formato/*233.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*233.195*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*237.42*/formato/*237.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*237.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*238.42*/formato/*238.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*238.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*239.42*/formato/*239.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*239.193*/(""" %</td>
                </tr>
				  <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*243.42*/formato/*243.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*243.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*244.42*/formato/*244.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*244.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*245.42*/formato/*245.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*245.201*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*254.12*/("""
  </div> <!--  docencia -->
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
<<<<<<< HEAD
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.Html = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.Html) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
=======
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,profesor,semestre)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Profesor,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,profesor,semestre) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,profesor,semestre)
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informefinal.scala.html
                    HASH: 274d3f80e867a2e382696678b65fd6d3a3314b13
                    MATRIX: 852->1|1242->261|1269->315|1505->516|1551->553|1599->563|2055->983|2071->990|2164->1060|2249->1109|2265->1116|2362->1190|2447->1239|2463->1246|2634->1394|2800->1524|2816->1531|2905->1597|2990->1646|3006->1653|3099->1723|3184->1772|3200->1779|3363->1919|3532->2052|3548->2059|3638->2126|3723->2175|3739->2182|3833->2253|3918->2302|3934->2309|4099->2451|4266->2582|4282->2589|4371->2655|4456->2704|4472->2711|4565->2781|4650->2830|4666->2837|4829->2977|5000->3112|5016->3119|5109->3189|5194->3238|5210->3245|5307->3319|5392->3368|5408->3375|5579->3523|6107->4015|6123->4022|6216->4092|6301->4141|6317->4148|6414->4222|6499->4271|6515->4278|6686->4426|6852->4556|6868->4563|6957->4629|7042->4678|7058->4685|7151->4755|7236->4804|7252->4811|7415->4951|7584->5084|7600->5091|7690->5158|7775->5207|7791->5214|7885->5285|7970->5334|7986->5341|8151->5483|8318->5614|8334->5621|8423->5687|8508->5736|8524->5743|8617->5813|8702->5862|8718->5869|8881->6009|9053->6144|9070->6151|9164->6221|9250->6270|9267->6277|9365->6351|9451->6400|9468->6407|9640->6555|10151->7029|10168->7036|10262->7106|10348->7155|10365->7162|10463->7236|10549->7285|10566->7292|10738->7440|10905->7570|10922->7577|11012->7643|11098->7692|11115->7699|11209->7769|11295->7818|11312->7825|11476->7965|11646->8098|11663->8105|11754->8172|11840->8221|11857->8228|11952->8299|12038->8348|12055->8355|12221->8497|12389->8628|12406->8635|12496->8701|12582->8750|12599->8757|12693->8827|12779->8876|12796->8883|12960->9023|13132->9158|13149->9165|13243->9235|13329->9284|13346->9291|13444->9365|13530->9414|13547->9421|13719->9569|14275->10088|14292->10095|14382->10161|14468->10210|14485->10217|14579->10287|14665->10336|14682->10343|14846->10483|15027->10627|15044->10634|15130->10696|15216->10745|15233->10752|15323->10818|15409->10867|15426->10874|15582->11006|15763->11150|15780->11157|15867->11220|15953->11269|15970->11276|16061->11343|16147->11392|16164->11399|16322->11533|16495->11669|16512->11676|16598->11738|16684->11787|16701->11794|16791->11860|16877->11909|16894->11916|17050->12048|17599->12560|17616->12567|17712->12639|17798->12688|17815->12695|17915->12771|18001->12820|18018->12827|18194->12979|18360->13108|18377->13115|18469->13183|18555->13232|18572->13239|18668->13311|18754->13360|18771->13367|18939->13511|19108->13643|19125->13650|19218->13719|19304->13768|19321->13775|19418->13848|19504->13897|19521->13904|19691->14050|19858->14180|19875->14187|19967->14255|20053->14304|20070->14311|20166->14383|20252->14432|20269->14439|20437->14583|20598->14707|20615->14714|20711->14786|20797->14835|20814->14842|20914->14918|21000->14967|21017->14974|21193->15126|21351->15251
                    LINES: 26->1|32->1|33->4|43->14|43->14|43->14|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|72->43|72->43|72->43|73->44|73->44|73->44|74->45|74->45|74->45|78->49|78->49|78->49|79->50|79->50|79->50|80->51|80->51|80->51|84->55|84->55|84->55|85->56|85->56|85->56|86->57|86->57|86->57|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|125->96|125->96|125->96|126->97|126->97|126->97|127->98|127->98|127->98|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|153->124|153->124|153->124|154->125|154->125|154->125|155->126|155->126|155->126|159->130|159->130|159->130|160->131|160->131|160->131|161->132|161->132|161->132|165->136|165->136|165->136|166->137|166->137|166->137|167->138|167->138|167->138|171->142|171->142|171->142|172->143|172->143|172->143|173->144|173->144|173->144|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|247->218|247->218|247->218|248->219|248->219|248->219|249->220|249->220|249->220|253->224|253->224|253->224|254->225|254->225|254->225|255->226|255->226|255->226|259->230|259->230|259->230|260->231|260->231|260->231|261->232|261->232|261->232|265->236|265->236|265->236|266->237|266->237|266->237|267->238|267->238|267->238|271->242|271->242|271->242|272->243|272->243|272->243|273->244|273->244|273->244|282->253
=======
                    DATE: Tue Apr 15 15:10:10 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informefinal.scala.html
                    HASH: cfdb97b7bfb6a39944bd3f9c8a5a06e8f7aff4d4
                    MATRIX: 919->1|1361->296|1388->350|1475->402|1491->410|1527->425|1564->427|1580->435|1614->448|1667->466|1697->474|1907->649|1953->686|2001->696|2457->1116|2473->1123|2566->1193|2651->1242|2667->1249|2764->1323|2849->1372|2865->1379|3036->1527|3202->1657|3218->1664|3307->1730|3392->1779|3408->1786|3501->1856|3586->1905|3602->1912|3765->2052|3934->2185|3950->2192|4040->2259|4125->2308|4141->2315|4235->2386|4320->2435|4336->2442|4501->2584|4668->2715|4684->2722|4773->2788|4858->2837|4874->2844|4967->2914|5052->2963|5068->2970|5231->3110|5402->3245|5418->3252|5511->3322|5596->3371|5612->3378|5709->3452|5794->3501|5810->3508|5981->3656|6509->4148|6525->4155|6618->4225|6703->4274|6719->4281|6816->4355|6901->4404|6917->4411|7088->4559|7254->4689|7270->4696|7359->4762|7444->4811|7460->4818|7553->4888|7638->4937|7654->4944|7817->5084|7986->5217|8002->5224|8092->5291|8177->5340|8193->5347|8287->5418|8372->5467|8388->5474|8553->5616|8720->5747|8736->5754|8825->5820|8910->5869|8926->5876|9019->5946|9104->5995|9120->6002|9283->6142|9455->6277|9472->6284|9566->6354|9652->6403|9669->6410|9767->6484|9853->6533|9870->6540|10042->6688|10553->7162|10570->7169|10664->7239|10750->7288|10767->7295|10865->7369|10951->7418|10968->7425|11140->7573|11307->7703|11324->7710|11414->7776|11500->7825|11517->7832|11611->7902|11697->7951|11714->7958|11878->8098|12048->8231|12065->8238|12156->8305|12242->8354|12259->8361|12354->8432|12440->8481|12457->8488|12623->8630|12791->8761|12808->8768|12898->8834|12984->8883|13001->8890|13095->8960|13181->9009|13198->9016|13362->9156|13534->9291|13551->9298|13645->9368|13731->9417|13748->9424|13846->9498|13932->9547|13949->9554|14121->9702|14677->10221|14694->10228|14784->10294|14870->10343|14887->10350|14981->10420|15067->10469|15084->10476|15248->10616|15429->10760|15446->10767|15532->10829|15618->10878|15635->10885|15725->10951|15811->11000|15828->11007|15984->11139|16165->11283|16182->11290|16269->11353|16355->11402|16372->11409|16463->11476|16549->11525|16566->11532|16724->11666|16897->11802|16914->11809|17000->11871|17086->11920|17103->11927|17193->11993|17279->12042|17296->12049|17452->12181|18001->12693|18018->12700|18114->12772|18200->12821|18217->12828|18317->12904|18403->12953|18420->12960|18596->13112|18762->13241|18779->13248|18871->13316|18957->13365|18974->13372|19070->13444|19156->13493|19173->13500|19341->13644|19510->13776|19527->13783|19620->13852|19706->13901|19723->13908|19820->13981|19906->14030|19923->14037|20093->14183|20260->14313|20277->14320|20369->14388|20455->14437|20472->14444|20568->14516|20654->14565|20671->14572|20839->14716|21000->14840|21017->14847|21113->14919|21199->14968|21216->14975|21316->15051|21402->15100|21419->15107|21595->15259|21753->15384
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|34->5|34->5|34->5|34->5|34->5|44->15|44->15|44->15|61->32|61->32|61->32|62->33|62->33|62->33|63->34|63->34|63->34|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|73->44|73->44|73->44|74->45|74->45|74->45|75->46|75->46|75->46|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|114->85|114->85|114->85|115->86|115->86|115->86|116->87|116->87|116->87|120->91|120->91|120->91|121->92|121->92|121->92|122->93|122->93|122->93|126->97|126->97|126->97|127->98|127->98|127->98|128->99|128->99|128->99|132->103|132->103|132->103|133->104|133->104|133->104|134->105|134->105|134->105|154->125|154->125|154->125|155->126|155->126|155->126|156->127|156->127|156->127|160->131|160->131|160->131|161->132|161->132|161->132|162->133|162->133|162->133|166->137|166->137|166->137|167->138|167->138|167->138|168->139|168->139|168->139|172->143|172->143|172->143|173->144|173->144|173->144|174->145|174->145|174->145|178->149|178->149|178->149|179->150|179->150|179->150|180->151|180->151|180->151|204->175|204->175|204->175|205->176|205->176|205->176|206->177|206->177|206->177|210->181|210->181|210->181|211->182|211->182|211->182|212->183|212->183|212->183|216->187|216->187|216->187|217->188|217->188|217->188|218->189|218->189|218->189|222->193|222->193|222->193|223->194|223->194|223->194|224->195|224->195|224->195|248->219|248->219|248->219|249->220|249->220|249->220|250->221|250->221|250->221|254->225|254->225|254->225|255->226|255->226|255->226|256->227|256->227|256->227|260->231|260->231|260->231|261->232|261->232|261->232|262->233|262->233|262->233|266->237|266->237|266->237|267->238|267->238|267->238|268->239|268->239|268->239|272->243|272->243|272->243|273->244|273->244|273->244|274->245|274->245|274->245|283->254
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            