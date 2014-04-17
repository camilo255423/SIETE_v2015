
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
object informefacultad extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion ):play.api.templates.Html = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.262*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Informe Final Facultad</a></li>
		
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla">Informe Final Facultad</div>
	  """),_display_(Seq[Any](/*14.5*/defining(new DecimalFormat("##0.00"))/*14.42*/{formato=>_display_(Seq[Any](format.raw/*14.52*/("""
	<h2>Campo de La Docencia</h2>
	<h3>Saber Pedagógico</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Porcentaje Promedio Estudiantes 80%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*31.42*/formato/*31.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*31.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*32.42*/formato/*32.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*32.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*33.42*/formato/*33.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*33.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*37.42*/formato/*37.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*37.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*38.42*/formato/*38.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*38.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*39.42*/formato/*39.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*39.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*43.42*/formato/*43.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*43.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*44.42*/formato/*44.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*44.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*45.42*/formato/*45.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*45.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*49.42*/formato/*49.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*49.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*50.42*/formato/*50.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*50.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*51.42*/formato/*51.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*51.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*55.42*/formato/*55.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*55.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*56.42*/formato/*56.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*56.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*57.42*/formato/*57.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*57.197*/(""" %</td>
                </tr>    
              
       
          </tbody>
          </table>
          <h3>Saber Específico</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Porcentaje Promedio Estudiantes 80%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*78.42*/formato/*78.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*78.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*79.42*/formato/*79.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*79.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*80.42*/formato/*80.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*80.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*84.42*/formato/*84.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*84.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*85.42*/formato/*85.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*85.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*86.42*/formato/*86.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*86.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*90.42*/formato/*90.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*90.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*91.42*/formato/*91.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*91.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*92.42*/formato/*92.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*92.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*96.42*/formato/*96.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*96.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*97.42*/formato/*97.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*97.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*98.42*/formato/*98.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*98.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*102.42*/formato/*102.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*102.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*103.42*/formato/*103.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*103.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*104.42*/formato/*104.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*104.197*/(""" %</td>
                </tr>    
          
          </tbody>
          </table>
    <h3>Saber Relacional</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Porcentaje Promedio Estudiantes 80%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*124.42*/formato/*124.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*124.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*125.42*/formato/*125.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*125.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*126.42*/formato/*126.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*126.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*130.42*/formato/*130.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*130.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*131.42*/formato/*131.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*131.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*132.42*/formato/*132.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*132.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*136.42*/formato/*136.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*136.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*137.42*/formato/*137.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*137.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*138.42*/formato/*138.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*138.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*142.42*/formato/*142.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*142.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*143.42*/formato/*143.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*143.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*144.42*/formato/*144.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*144.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*148.42*/formato/*148.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*148.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*149.42*/formato/*149.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*149.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*150.42*/formato/*150.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*150.197*/(""" %</td>
                </tr>    
              
             
      
        
          
          </tbody>
          </table>
              <h3>Gestión</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Porcentaje Promedio Directivos 60%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 40%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">No Cumple</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*174.42*/formato/*174.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*174.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*175.42*/formato/*175.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*175.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*176.42*/formato/*176.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*176.189*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Cumple Parcialmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*180.42*/formato/*180.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*180.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*181.42*/formato/*181.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*181.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*182.42*/formato/*182.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*182.181*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Cumple Totalmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*186.42*/formato/*186.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*186.112*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*187.42*/formato/*187.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*187.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*188.42*/formato/*188.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*188.183*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">No Aplica</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*192.42*/formato/*192.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*192.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*193.42*/formato/*193.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*193.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*194.42*/formato/*194.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*194.181*/(""" %</td>
                </tr>
				
             
      
        
          
          </tbody>
          </table>
                <h3>Investigación</h3>
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Nivel de Desempeño</td>
		<td class="row_headers" >Porcentaje Promedio Directivos 60%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 40%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*218.42*/formato/*218.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*218.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*219.42*/formato/*219.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*219.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*220.42*/formato/*220.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*220.201*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*224.42*/formato/*224.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*224.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*225.42*/formato/*225.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*225.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*226.42*/formato/*226.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*226.193*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*230.42*/formato/*230.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*230.118*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*231.42*/formato/*231.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*231.122*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*232.42*/formato/*232.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*232.195*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*236.42*/formato/*236.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*236.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*237.42*/formato/*237.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*237.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*238.42*/formato/*238.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*238.193*/(""" %</td>
                </tr>
				  <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*242.42*/formato/*242.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*242.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*243.42*/formato/*243.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*243.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*244.42*/formato/*244.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*244.201*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*253.12*/("""
  </div> <!--  docencia -->
=</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.Html = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.Html) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informefacultad.scala.html
                    HASH: 1aef01d209f9b6f9ef70b8963c9515c421a6cba6
                    MATRIX: 855->1|1245->261|1272->315|1526->534|1572->571|1620->581|2116->1041|2132->1048|2225->1118|2310->1167|2326->1174|2423->1248|2508->1297|2524->1304|2695->1452|2861->1582|2877->1589|2966->1655|3051->1704|3067->1711|3160->1781|3245->1830|3261->1837|3424->1977|3593->2110|3609->2117|3699->2184|3784->2233|3800->2240|3894->2311|3979->2360|3995->2367|4160->2509|4327->2640|4343->2647|4432->2713|4517->2762|4533->2769|4626->2839|4711->2888|4727->2895|4890->3035|5061->3170|5077->3177|5170->3247|5255->3296|5271->3303|5368->3377|5453->3426|5469->3433|5640->3581|6208->4113|6224->4120|6317->4190|6402->4239|6418->4246|6515->4320|6600->4369|6616->4376|6787->4524|6953->4654|6969->4661|7058->4727|7143->4776|7159->4783|7252->4853|7337->4902|7353->4909|7516->5049|7685->5182|7701->5189|7791->5256|7876->5305|7892->5312|7986->5383|8071->5432|8087->5439|8252->5581|8419->5712|8435->5719|8524->5785|8609->5834|8625->5841|8718->5911|8803->5960|8819->5967|8982->6107|9154->6242|9171->6249|9265->6319|9351->6368|9368->6375|9466->6449|9552->6498|9569->6505|9741->6653|10292->7167|10309->7174|10403->7244|10489->7293|10506->7300|10604->7374|10690->7423|10707->7430|10879->7578|11046->7708|11063->7715|11153->7781|11239->7830|11256->7837|11350->7907|11436->7956|11453->7963|11617->8103|11787->8236|11804->8243|11895->8310|11981->8359|11998->8366|12093->8437|12179->8486|12196->8493|12362->8635|12530->8766|12547->8773|12637->8839|12723->8888|12740->8895|12834->8965|12920->9014|12937->9021|13101->9161|13273->9296|13290->9303|13384->9373|13470->9422|13487->9429|13585->9503|13671->9552|13688->9559|13860->9707|14457->10267|14474->10274|14564->10340|14650->10389|14667->10396|14761->10466|14847->10515|14864->10522|15028->10662|15209->10806|15226->10813|15312->10875|15398->10924|15415->10931|15505->10997|15591->11046|15608->11053|15764->11185|15945->11329|15962->11336|16049->11399|16135->11448|16152->11455|16243->11522|16329->11571|16346->11578|16504->11712|16677->11848|16694->11855|16780->11917|16866->11966|16883->11973|16973->12039|17059->12088|17076->12095|17232->12227|17822->12780|17839->12787|17935->12859|18021->12908|18038->12915|18138->12991|18224->13040|18241->13047|18417->13199|18583->13328|18600->13335|18692->13403|18778->13452|18795->13459|18891->13531|18977->13580|18994->13587|19162->13731|19331->13863|19348->13870|19441->13939|19527->13988|19544->13995|19641->14068|19727->14117|19744->14124|19914->14270|20081->14400|20098->14407|20190->14475|20276->14524|20293->14531|20389->14603|20475->14652|20492->14659|20660->14803|20821->14927|20838->14934|20934->15006|21020->15055|21037->15062|21137->15138|21223->15187|21240->15194|21416->15346|21574->15471
                    LINES: 26->1|32->1|33->4|43->14|43->14|43->14|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|72->43|72->43|72->43|73->44|73->44|73->44|74->45|74->45|74->45|78->49|78->49|78->49|79->50|79->50|79->50|80->51|80->51|80->51|84->55|84->55|84->55|85->56|85->56|85->56|86->57|86->57|86->57|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|125->96|125->96|125->96|126->97|126->97|126->97|127->98|127->98|127->98|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|153->124|153->124|153->124|154->125|154->125|154->125|155->126|155->126|155->126|159->130|159->130|159->130|160->131|160->131|160->131|161->132|161->132|161->132|165->136|165->136|165->136|166->137|166->137|166->137|167->138|167->138|167->138|171->142|171->142|171->142|172->143|172->143|172->143|173->144|173->144|173->144|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|247->218|247->218|247->218|248->219|248->219|248->219|249->220|249->220|249->220|253->224|253->224|253->224|254->225|254->225|254->225|255->226|255->226|255->226|259->230|259->230|259->230|260->231|260->231|260->231|261->232|261->232|261->232|265->236|265->236|265->236|266->237|266->237|266->237|267->238|267->238|267->238|271->242|271->242|271->242|272->243|272->243|272->243|273->244|273->244|273->244|282->253
                    -- GENERATED --
                */
            