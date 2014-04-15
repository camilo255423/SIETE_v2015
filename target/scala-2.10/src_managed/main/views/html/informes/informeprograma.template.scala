
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
object informeprograma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion, mejorPeor:List[SaberNivel] ):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.290*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Informe Final Programa</a></li>
		
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla">Informe Final Programa</div>
	  """),_display_(Seq[Any](/*14.5*/defining(new DecimalFormat("##0.00"))/*14.42*/{formato=>_display_(Seq[Any](format.raw/*14.52*/("""
	<h2>Campo de La Docencia</h2>
	<h3>Mejor Saber: """),_display_(Seq[Any](/*16.20*/mejorPeor/*16.29*/.get(0).getSaber())),format.raw/*16.47*/(""" Nivel: """),_display_(Seq[Any](/*16.56*/Nivel/*16.61*/.toString(mejorPeor.get(0).getNivel()))),format.raw/*16.99*/(""" """),_display_(Seq[Any](/*16.101*/formato/*16.108*/.format(mejorPeor.get(0).getPromedio()))),format.raw/*16.147*/(""" %  
	 , Peor Saber: """),_display_(Seq[Any](/*17.18*/mejorPeor/*17.27*/.get(1).getSaber())),format.raw/*17.45*/(""" Nivel: """),_display_(Seq[Any](/*17.54*/Nivel/*17.59*/.toString(mejorPeor.get(1).getNivel()))),format.raw/*17.97*/(""" """),_display_(Seq[Any](/*17.99*/formato/*17.106*/.format(mejorPeor.get(1).getPromedio()))),format.raw/*17.145*/(""" %</h3>
	
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
		<td class="row_headers" >Porcentaje Promedio Estudiantes 80%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 20%</td>
		<td class="row_headers" >Resultado</td>
	     </tr>
	     
	     
       	   
	 
				<tr>
				<td class="row_headers">Inferior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*81.42*/formato/*81.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*81.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*82.42*/formato/*82.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*82.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*83.42*/formato/*83.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.2)))),format.raw/*83.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*87.42*/formato/*87.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*87.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*88.42*/formato/*88.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*88.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*89.42*/formato/*89.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.2)))),format.raw/*89.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*93.42*/formato/*93.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*93.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*94.42*/formato/*94.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*94.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*95.42*/formato/*95.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.2)))),format.raw/*95.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*99.42*/formato/*99.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*99.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*100.42*/formato/*100.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*100.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*101.42*/formato/*101.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.2)))),format.raw/*101.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*105.42*/formato/*105.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*105.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*106.42*/formato/*106.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*106.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*107.42*/formato/*107.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.2)))),format.raw/*107.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*127.42*/formato/*127.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*127.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*128.42*/formato/*128.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*128.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*129.42*/formato/*129.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.2)))),format.raw/*129.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*133.42*/formato/*133.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*133.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*134.42*/formato/*134.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*134.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*135.42*/formato/*135.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.2)))),format.raw/*135.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*139.42*/formato/*139.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*139.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*140.42*/formato/*140.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*140.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*141.42*/formato/*141.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.2)))),format.raw/*141.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*145.42*/formato/*145.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*145.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*146.42*/formato/*146.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*146.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*147.42*/formato/*147.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.2)))),format.raw/*147.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*151.42*/formato/*151.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*151.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*152.42*/formato/*152.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*152.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*153.42*/formato/*153.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.2)))),format.raw/*153.197*/(""" %</td>
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
		<td class="row_headers" >Porcentaje Promedio Directivos 60%</td>
		<td class="row_headers" >Porcentaje Promedio Autoevaluación 40%</td>
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
=</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel]): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel]) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 14 13:37:14 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprograma.scala.html
                    HASH: 9795df7523640df4194701ec4d398786026c0bb0
                    MATRIX: 923->1|1358->289|1385->343|1639->562|1685->599|1733->609|1820->660|1838->669|1878->687|1923->696|1937->701|1997->739|2036->741|2053->748|2115->787|2173->809|2191->818|2231->836|2276->845|2290->850|2350->888|2388->890|2405->897|2467->936|2941->1374|2957->1381|3050->1451|3135->1500|3151->1507|3248->1581|3333->1630|3349->1637|3520->1785|3686->1915|3702->1922|3791->1988|3876->2037|3892->2044|3985->2114|4070->2163|4086->2170|4249->2310|4418->2443|4434->2450|4524->2517|4609->2566|4625->2573|4719->2644|4804->2693|4820->2700|4985->2842|5152->2973|5168->2980|5257->3046|5342->3095|5358->3102|5451->3172|5536->3221|5552->3228|5715->3368|5886->3503|5902->3510|5995->3580|6080->3629|6096->3636|6193->3710|6278->3759|6294->3766|6465->3914|7033->4446|7049->4453|7142->4523|7227->4572|7243->4579|7340->4653|7425->4702|7441->4709|7612->4857|7778->4987|7794->4994|7883->5060|7968->5109|7984->5116|8077->5186|8162->5235|8178->5242|8341->5382|8510->5515|8526->5522|8616->5589|8701->5638|8717->5645|8811->5716|8896->5765|8912->5772|9077->5914|9244->6045|9260->6052|9349->6118|9435->6167|9452->6174|9546->6244|9632->6293|9649->6300|9813->6440|9985->6575|10002->6582|10096->6652|10182->6701|10199->6708|10297->6782|10383->6831|10400->6838|10572->6986|11123->7500|11140->7507|11234->7577|11320->7626|11337->7633|11435->7707|11521->7756|11538->7763|11710->7911|11877->8041|11894->8048|11984->8114|12070->8163|12087->8170|12181->8240|12267->8289|12284->8296|12448->8436|12618->8569|12635->8576|12726->8643|12812->8692|12829->8699|12924->8770|13010->8819|13027->8826|13193->8968|13361->9099|13378->9106|13468->9172|13554->9221|13571->9228|13665->9298|13751->9347|13768->9354|13932->9494|14104->9629|14121->9636|14215->9706|14301->9755|14318->9762|14416->9836|14502->9885|14519->9892|14691->10040|15288->10600|15305->10607|15395->10673|15481->10722|15498->10729|15592->10799|15678->10848|15695->10855|15859->10995|16040->11139|16057->11146|16143->11208|16229->11257|16246->11264|16336->11330|16422->11379|16439->11386|16595->11518|16776->11662|16793->11669|16880->11732|16966->11781|16983->11788|17074->11855|17160->11904|17177->11911|17335->12045|17508->12181|17525->12188|17611->12250|17697->12299|17714->12306|17804->12372|17890->12421|17907->12428|18063->12560|18653->13113|18670->13120|18766->13192|18852->13241|18869->13248|18969->13324|19055->13373|19072->13380|19248->13532|19414->13661|19431->13668|19523->13736|19609->13785|19626->13792|19722->13864|19808->13913|19825->13920|19993->14064|20162->14196|20179->14203|20272->14272|20358->14321|20375->14328|20472->14401|20558->14450|20575->14457|20745->14603|20912->14733|20929->14740|21021->14808|21107->14857|21124->14864|21220->14936|21306->14985|21323->14992|21491->15136|21652->15260|21669->15267|21765->15339|21851->15388|21868->15395|21968->15471|22054->15520|22071->15527|22247->15679|22405->15804
                    LINES: 26->1|32->1|33->4|43->14|43->14|43->14|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|46->17|46->17|46->17|46->17|46->17|46->17|46->17|46->17|46->17|63->34|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|69->40|69->40|69->40|70->41|70->41|70->41|71->42|71->42|71->42|75->46|75->46|75->46|76->47|76->47|76->47|77->48|77->48|77->48|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|87->58|87->58|87->58|88->59|88->59|88->59|89->60|89->60|89->60|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|122->93|122->93|122->93|123->94|123->94|123->94|124->95|124->95|124->95|128->99|128->99|128->99|129->100|129->100|129->100|130->101|130->101|130->101|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|136->107|156->127|156->127|156->127|157->128|157->128|157->128|158->129|158->129|158->129|162->133|162->133|162->133|163->134|163->134|163->134|164->135|164->135|164->135|168->139|168->139|168->139|169->140|169->140|169->140|170->141|170->141|170->141|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|180->151|180->151|180->151|181->152|181->152|181->152|182->153|182->153|182->153|206->177|206->177|206->177|207->178|207->178|207->178|208->179|208->179|208->179|212->183|212->183|212->183|213->184|213->184|213->184|214->185|214->185|214->185|218->189|218->189|218->189|219->190|219->190|219->190|220->191|220->191|220->191|224->195|224->195|224->195|225->196|225->196|225->196|226->197|226->197|226->197|250->221|250->221|250->221|251->222|251->222|251->222|252->223|252->223|252->223|256->227|256->227|256->227|257->228|257->228|257->228|258->229|258->229|258->229|262->233|262->233|262->233|263->234|263->234|263->234|264->235|264->235|264->235|268->239|268->239|268->239|269->240|269->240|269->240|270->241|270->241|270->241|274->245|274->245|274->245|275->246|275->246|275->246|276->247|276->247|276->247|285->256
                    -- GENERATED --
                */
            