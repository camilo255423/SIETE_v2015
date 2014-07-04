
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
object informefinal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion, profesor:Profesor,semestre:String ):play.api.templates.HtmlFormat.Appendable = {
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
	<h4> Estudiantes encuestados: """),_display_(Seq[Any](/*17.33*/evaluacionDocencia/*17.51*/.getEvaluados())),format.raw/*17.66*/(""" de """),_display_(Seq[Any](/*17.71*/evaluacionDocencia/*17.89*/.getMateria().getInscritos())),format.raw/*17.117*/(""", 
porcentaje """),_display_(Seq[Any](/*18.13*/(10000*evaluacionDocencia.getEvaluados()/evaluacionDocencia.getMateria().getInscritos()/100.0))),format.raw/*18.107*/("""% </h4>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*34.42*/formato/*34.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*34.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*35.42*/formato/*35.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*35.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*36.42*/formato/*36.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*36.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*40.42*/formato/*40.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*40.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*41.42*/formato/*41.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*41.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*42.42*/formato/*42.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*42.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*46.42*/formato/*46.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*46.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*47.42*/formato/*47.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*47.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*48.42*/formato/*48.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*48.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*52.42*/formato/*52.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*52.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*53.42*/formato/*53.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*53.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*54.42*/formato/*54.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*54.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*58.42*/formato/*58.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*58.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*59.42*/formato/*59.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*59.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*60.42*/formato/*60.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*60.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*81.42*/formato/*81.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*81.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*82.42*/formato/*82.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*82.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*83.42*/formato/*83.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*83.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*87.42*/formato/*87.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*87.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*88.42*/formato/*88.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*88.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*89.42*/formato/*89.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*89.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*93.42*/formato/*93.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*93.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*94.42*/formato/*94.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*94.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*95.42*/formato/*95.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*95.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*99.42*/formato/*99.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*99.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*100.42*/formato/*100.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*100.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*101.42*/formato/*101.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*101.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*105.42*/formato/*105.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*105.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*106.42*/formato/*106.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*106.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*107.42*/formato/*107.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*107.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*127.42*/formato/*127.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*127.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*128.42*/formato/*128.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*128.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*129.42*/formato/*129.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*129.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*133.42*/formato/*133.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*133.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*134.42*/formato/*134.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*134.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*135.42*/formato/*135.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*135.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*139.42*/formato/*139.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*139.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*140.42*/formato/*140.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*140.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*141.42*/formato/*141.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*141.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*145.42*/formato/*145.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*145.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*146.42*/formato/*146.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*146.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*147.42*/formato/*147.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*147.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*151.42*/formato/*151.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*151.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*152.42*/formato/*152.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*152.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*153.42*/formato/*153.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*153.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*177.42*/formato/*177.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*177.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*178.42*/formato/*178.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*178.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*179.42*/formato/*179.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*179.189*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Cumple Parcialmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*183.42*/formato/*183.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*183.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*184.42*/formato/*184.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*184.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*185.42*/formato/*185.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*185.181*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Cumple Totalmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*189.42*/formato/*189.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*189.112*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*190.42*/formato/*190.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*190.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*191.42*/formato/*191.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*191.183*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">No Aplica</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*195.42*/formato/*195.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*195.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*196.42*/formato/*196.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*196.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*197.42*/formato/*197.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*197.181*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*221.42*/formato/*221.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*221.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*222.42*/formato/*222.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*222.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*223.42*/formato/*223.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*223.201*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*227.42*/formato/*227.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*227.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*228.42*/formato/*228.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*228.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*229.42*/formato/*229.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*229.193*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*233.42*/formato/*233.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*233.118*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*234.42*/formato/*234.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*234.122*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*235.42*/formato/*235.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*235.195*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*239.42*/formato/*239.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*239.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*240.42*/formato/*240.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*240.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*241.42*/formato/*241.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*241.193*/(""" %</td>
                </tr>
				  <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*245.42*/formato/*245.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*245.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*246.42*/formato/*246.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*246.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*247.42*/formato/*247.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*247.201*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*256.12*/("""
  </div> <!--  docencia -->
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,profesor,semestre)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,Profesor,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,profesor,semestre) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,profesor,semestre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 04 16:10:11 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informefinal.scala.html
                    HASH: 492bbe8ce3291df354afefc8f22d11bbde4c2bf2
                    MATRIX: 919->1|1361->296|1388->350|1475->402|1491->410|1527->425|1564->427|1580->435|1614->448|1667->466|1697->474|1907->649|1953->686|2001->696|2101->760|2128->778|2165->793|2206->798|2233->816|2284->844|2335->859|2452->953|2884->1349|2900->1356|2993->1426|3078->1475|3094->1482|3191->1556|3276->1605|3292->1612|3463->1760|3629->1890|3645->1897|3734->1963|3819->2012|3835->2019|3928->2089|4013->2138|4029->2145|4192->2285|4361->2418|4377->2425|4467->2492|4552->2541|4568->2548|4662->2619|4747->2668|4763->2675|4928->2817|5095->2948|5111->2955|5200->3021|5285->3070|5301->3077|5394->3147|5479->3196|5495->3203|5658->3343|5829->3478|5845->3485|5938->3555|6023->3604|6039->3611|6136->3685|6221->3734|6237->3741|6408->3889|6936->4381|6952->4388|7045->4458|7130->4507|7146->4514|7243->4588|7328->4637|7344->4644|7515->4792|7681->4922|7697->4929|7786->4995|7871->5044|7887->5051|7980->5121|8065->5170|8081->5177|8244->5317|8413->5450|8429->5457|8519->5524|8604->5573|8620->5580|8714->5651|8799->5700|8815->5707|8980->5849|9147->5980|9163->5987|9252->6053|9338->6102|9355->6109|9449->6179|9535->6228|9552->6235|9716->6375|9888->6510|9905->6517|9999->6587|10085->6636|10102->6643|10200->6717|10286->6766|10303->6773|10475->6921|10986->7395|11003->7402|11097->7472|11183->7521|11200->7528|11298->7602|11384->7651|11401->7658|11573->7806|11740->7936|11757->7943|11847->8009|11933->8058|11950->8065|12044->8135|12130->8184|12147->8191|12311->8331|12481->8464|12498->8471|12589->8538|12675->8587|12692->8594|12787->8665|12873->8714|12890->8721|13056->8863|13224->8994|13241->9001|13331->9067|13417->9116|13434->9123|13528->9193|13614->9242|13631->9249|13795->9389|13967->9524|13984->9531|14078->9601|14164->9650|14181->9657|14279->9731|14365->9780|14382->9787|14554->9935|15110->10454|15127->10461|15217->10527|15303->10576|15320->10583|15414->10653|15500->10702|15517->10709|15681->10849|15862->10993|15879->11000|15965->11062|16051->11111|16068->11118|16158->11184|16244->11233|16261->11240|16417->11372|16598->11516|16615->11523|16702->11586|16788->11635|16805->11642|16896->11709|16982->11758|16999->11765|17157->11899|17330->12035|17347->12042|17433->12104|17519->12153|17536->12160|17626->12226|17712->12275|17729->12282|17885->12414|18434->12926|18451->12933|18547->13005|18633->13054|18650->13061|18750->13137|18836->13186|18853->13193|19029->13345|19195->13474|19212->13481|19304->13549|19390->13598|19407->13605|19503->13677|19589->13726|19606->13733|19774->13877|19943->14009|19960->14016|20053->14085|20139->14134|20156->14141|20253->14214|20339->14263|20356->14270|20526->14416|20693->14546|20710->14553|20802->14621|20888->14670|20905->14677|21001->14749|21087->14798|21104->14805|21272->14949|21433->15073|21450->15080|21546->15152|21632->15201|21649->15208|21749->15284|21835->15333|21852->15340|22028->15492|22186->15617
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|34->5|34->5|34->5|34->5|34->5|44->15|44->15|44->15|46->17|46->17|46->17|46->17|46->17|46->17|47->18|47->18|63->34|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|69->40|69->40|69->40|70->41|70->41|70->41|71->42|71->42|71->42|75->46|75->46|75->46|76->47|76->47|76->47|77->48|77->48|77->48|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|87->58|87->58|87->58|88->59|88->59|88->59|89->60|89->60|89->60|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|156->127|156->127|156->127|157->128|157->128|157->128|158->129|158->129|158->129|162->133|162->133|162->133|163->134|163->134|163->134|164->135|164->135|164->135|168->139|168->139|168->139|169->140|169->140|169->140|170->141|170->141|170->141|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|180->151|180->151|180->151|181->152|181->152|181->152|182->153|182->153|182->153|206->177|206->177|206->177|207->178|207->178|207->178|208->179|208->179|208->179|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|250->221|250->221|250->221|251->222|251->222|251->222|252->223|252->223|252->223|256->227|256->227|256->227|257->228|257->228|257->228|258->229|258->229|258->229|262->233|262->233|262->233|263->234|263->234|263->234|264->235|264->235|264->235|268->239|268->239|268->239|269->240|269->240|269->240|270->241|270->241|270->241|274->245|274->245|274->245|275->246|275->246|275->246|276->247|276->247|276->247|285->256
                    -- GENERATED --
                */
            