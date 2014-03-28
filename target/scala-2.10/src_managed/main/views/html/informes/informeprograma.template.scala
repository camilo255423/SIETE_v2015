
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
object informeprograma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion ):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.262*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Informe Final Programa</a></li>
		
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla">Informe Final Programa</div>
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
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 27 21:27:48 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprograma.scala.html
                    HASH: 9e702473f5d66d2e14a6b5b22b60754d1d8c63c5
                    MATRIX: 906->1|1313->261|1340->315|1594->534|1640->571|1688->581|2184->1041|2200->1048|2293->1118|2378->1167|2394->1174|2491->1248|2576->1297|2592->1304|2763->1452|2929->1582|2945->1589|3034->1655|3119->1704|3135->1711|3228->1781|3313->1830|3329->1837|3492->1977|3661->2110|3677->2117|3767->2184|3852->2233|3868->2240|3962->2311|4047->2360|4063->2367|4228->2509|4395->2640|4411->2647|4500->2713|4585->2762|4601->2769|4694->2839|4779->2888|4795->2895|4958->3035|5129->3170|5145->3177|5238->3247|5323->3296|5339->3303|5436->3377|5521->3426|5537->3433|5708->3581|6276->4113|6292->4120|6385->4190|6470->4239|6486->4246|6583->4320|6668->4369|6684->4376|6855->4524|7021->4654|7037->4661|7126->4727|7211->4776|7227->4783|7320->4853|7405->4902|7421->4909|7584->5049|7753->5182|7769->5189|7859->5256|7944->5305|7960->5312|8054->5383|8139->5432|8155->5439|8320->5581|8487->5712|8503->5719|8592->5785|8677->5834|8693->5841|8786->5911|8871->5960|8887->5967|9050->6107|9222->6242|9239->6249|9333->6319|9419->6368|9436->6375|9534->6449|9620->6498|9637->6505|9809->6653|10360->7167|10377->7174|10471->7244|10557->7293|10574->7300|10672->7374|10758->7423|10775->7430|10947->7578|11114->7708|11131->7715|11221->7781|11307->7830|11324->7837|11418->7907|11504->7956|11521->7963|11685->8103|11855->8236|11872->8243|11963->8310|12049->8359|12066->8366|12161->8437|12247->8486|12264->8493|12430->8635|12598->8766|12615->8773|12705->8839|12791->8888|12808->8895|12902->8965|12988->9014|13005->9021|13169->9161|13341->9296|13358->9303|13452->9373|13538->9422|13555->9429|13653->9503|13739->9552|13756->9559|13928->9707|14525->10267|14542->10274|14632->10340|14718->10389|14735->10396|14829->10466|14915->10515|14932->10522|15096->10662|15277->10806|15294->10813|15380->10875|15466->10924|15483->10931|15573->10997|15659->11046|15676->11053|15832->11185|16013->11329|16030->11336|16117->11399|16203->11448|16220->11455|16311->11522|16397->11571|16414->11578|16572->11712|16745->11848|16762->11855|16848->11917|16934->11966|16951->11973|17041->12039|17127->12088|17144->12095|17300->12227|17890->12780|17907->12787|18003->12859|18089->12908|18106->12915|18206->12991|18292->13040|18309->13047|18485->13199|18651->13328|18668->13335|18760->13403|18846->13452|18863->13459|18959->13531|19045->13580|19062->13587|19230->13731|19399->13863|19416->13870|19509->13939|19595->13988|19612->13995|19709->14068|19795->14117|19812->14124|19982->14270|20149->14400|20166->14407|20258->14475|20344->14524|20361->14531|20457->14603|20543->14652|20560->14659|20728->14803|20889->14927|20906->14934|21002->15006|21088->15055|21105->15062|21205->15138|21291->15187|21308->15194|21484->15346|21642->15471
                    LINES: 26->1|32->1|33->4|43->14|43->14|43->14|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|72->43|72->43|72->43|73->44|73->44|73->44|74->45|74->45|74->45|78->49|78->49|78->49|79->50|79->50|79->50|80->51|80->51|80->51|84->55|84->55|84->55|85->56|85->56|85->56|86->57|86->57|86->57|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|125->96|125->96|125->96|126->97|126->97|126->97|127->98|127->98|127->98|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|153->124|153->124|153->124|154->125|154->125|154->125|155->126|155->126|155->126|159->130|159->130|159->130|160->131|160->131|160->131|161->132|161->132|161->132|165->136|165->136|165->136|166->137|166->137|166->137|167->138|167->138|167->138|171->142|171->142|171->142|172->143|172->143|172->143|173->144|173->144|173->144|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|247->218|247->218|247->218|248->219|248->219|248->219|249->220|249->220|249->220|253->224|253->224|253->224|254->225|254->225|254->225|255->226|255->226|255->226|259->230|259->230|259->230|260->231|260->231|260->231|261->232|261->232|261->232|265->236|265->236|265->236|266->237|266->237|266->237|267->238|267->238|267->238|271->242|271->242|271->242|272->243|272->243|272->243|273->244|273->244|273->244|282->253
                    -- GENERATED --
                */
            