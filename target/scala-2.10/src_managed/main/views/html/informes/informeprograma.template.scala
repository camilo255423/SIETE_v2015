
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
object informeprograma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template9[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Programa,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion, mejorPeor:List[SaberNivel],programa:Programa,semestre:String ):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.324*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<h2 style="text-align: center;">Informe Final Programa """),_display_(Seq[Any](/*5.57*/programa/*5.65*/.getNombre())),format.raw/*5.77*/(""" - """),_display_(Seq[Any](/*5.81*/semestre)),format.raw/*5.89*/("""</h2>
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Informe Final Programa</a></li>
		
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla"></div>
	  """),_display_(Seq[Any](/*15.5*/defining(new DecimalFormat("##0.00"))/*15.42*/{formato=>_display_(Seq[Any](format.raw/*15.52*/("""
	<h2>Campo de La Docencia</h2>
	<h3>Mayor porcentaje en el saber: """),_display_(Seq[Any](/*17.37*/mejorPeor/*17.46*/.get(0).getSaber())),format.raw/*17.64*/(""" Nivel: """),_display_(Seq[Any](/*17.73*/Nivel/*17.78*/.toString(mejorPeor.get(0).getNivel()))),format.raw/*17.116*/(""" """),_display_(Seq[Any](/*17.118*/formato/*17.125*/.format(mejorPeor.get(0).getPromedio()))),format.raw/*17.164*/(""" %  
	 , Menor porcentaje en el saber: """),_display_(Seq[Any](/*18.36*/mejorPeor/*18.45*/.get(1).getSaber())),format.raw/*18.63*/(""" Nivel: """),_display_(Seq[Any](/*18.72*/Nivel/*18.77*/.toString(mejorPeor.get(1).getNivel()))),format.raw/*18.115*/(""" """),_display_(Seq[Any](/*18.117*/formato/*18.124*/.format(mejorPeor.get(1).getPromedio()))),format.raw/*18.163*/(""" %</h3>
	
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
                <td class="row_headers">"""),_display_(Seq[Any](/*35.42*/formato/*35.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*35.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*36.42*/formato/*36.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)))),format.raw/*36.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*37.42*/formato/*37.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*37.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*41.42*/formato/*41.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*41.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*42.42*/formato/*42.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)))),format.raw/*42.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*43.42*/formato/*43.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*43.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*47.42*/formato/*47.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*47.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*48.42*/formato/*48.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)))),format.raw/*48.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*49.42*/formato/*49.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*49.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*53.42*/formato/*53.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*53.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*54.42*/formato/*54.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)))),format.raw/*54.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*55.42*/formato/*55.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*55.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*59.42*/formato/*59.49*/.format(evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*59.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*60.42*/formato/*60.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)))),format.raw/*60.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*61.42*/formato/*61.49*/.format((evaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*61.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*82.42*/formato/*82.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*82.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*83.42*/formato/*83.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)))),format.raw/*83.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*84.42*/formato/*84.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.2)))),format.raw/*84.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*88.42*/formato/*88.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*88.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*89.42*/formato/*89.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*89.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*90.42*/formato/*90.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.2)))),format.raw/*90.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*94.42*/formato/*94.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*94.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*95.42*/formato/*95.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*95.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*96.42*/formato/*96.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.2)))),format.raw/*96.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*100.42*/formato/*100.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*100.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*101.42*/formato/*101.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*101.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*102.42*/formato/*102.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.2)))),format.raw/*102.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*106.42*/formato/*106.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*106.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*107.42*/formato/*107.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*107.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*108.42*/formato/*108.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.2)))),format.raw/*108.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*128.42*/formato/*128.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*128.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*129.42*/formato/*129.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)))),format.raw/*129.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*130.42*/formato/*130.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.2)))),format.raw/*130.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*134.42*/formato/*134.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*134.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*135.42*/formato/*135.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*135.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*136.42*/formato/*136.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.2)))),format.raw/*136.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*140.42*/formato/*140.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*140.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*141.42*/formato/*141.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*141.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*142.42*/formato/*142.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.2)))),format.raw/*142.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*146.42*/formato/*146.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*146.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*147.42*/formato/*147.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*147.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*148.42*/formato/*148.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.2)))),format.raw/*148.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*152.42*/formato/*152.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*152.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*153.42*/formato/*153.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*153.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*154.42*/formato/*154.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.2)))),format.raw/*154.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*178.42*/formato/*178.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*178.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*179.42*/formato/*179.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*179.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*180.42*/formato/*180.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*180.189*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Cumple Parcialmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*184.42*/formato/*184.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*184.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*185.42*/formato/*185.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*185.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*186.42*/formato/*186.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*186.181*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Cumple Totalmente</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*190.42*/formato/*190.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*190.112*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*191.42*/formato/*191.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*191.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*192.42*/formato/*192.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*192.183*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">No Aplica</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*196.42*/formato/*196.49*/.format(evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*196.111*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*197.42*/formato/*197.49*/.format(autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*197.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*198.42*/formato/*198.49*/.format((evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*198.181*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*222.42*/formato/*222.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*222.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*223.42*/formato/*223.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)))),format.raw/*223.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*224.42*/formato/*224.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)*0.4)))),format.raw/*224.201*/(""" %</td>
                </tr>
              	<tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*228.42*/formato/*228.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*228.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*229.42*/formato/*229.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)))),format.raw/*229.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*230.42*/formato/*230.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)*0.4)))),format.raw/*230.193*/(""" %</td>
                </tr>
                	<tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*234.42*/formato/*234.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*234.118*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*235.42*/formato/*235.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)))),format.raw/*235.122*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*236.42*/formato/*236.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)*0.4)))),format.raw/*236.195*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*240.42*/formato/*240.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*240.117*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*241.42*/formato/*241.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)))),format.raw/*241.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*242.42*/formato/*242.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)*0.4)))),format.raw/*242.193*/(""" %</td>
                </tr>
				  <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*246.42*/formato/*246.49*/.format(evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*246.121*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*247.42*/formato/*247.49*/.format(autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)))),format.raw/*247.125*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*248.42*/formato/*248.49*/.format((evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.6 + autoEvaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)*0.4)))),format.raw/*248.201*/(""" %</td>
                </tr>
             
      
        
          
          </tbody>
          </table>
    
          """)))})),format.raw/*257.12*/("""
  </div> <!--  docencia -->
=</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],programa:Programa,semestre:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Programa,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,programa,semestre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:46 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informeprograma.scala.html
                    HASH: f7158a00f63a4525854332d127e8bd4053c82eb2
                    MATRIX: 939->1|1408->323|1435->377|1545->452|1561->460|1594->472|1633->476|1662->484|1881->668|1927->705|1975->715|2062->766|2080->775|2120->793|2165->802|2179->807|2239->845|2278->847|2295->854|2357->893|2415->915|2433->924|2473->942|2518->951|2532->956|2592->994|2630->996|2647->1003|2709->1042|3183->1480|3199->1487|3292->1557|3377->1606|3393->1613|3490->1687|3575->1736|3591->1743|3762->1891|3928->2021|3944->2028|4033->2094|4118->2143|4134->2150|4227->2220|4312->2269|4328->2276|4491->2416|4660->2549|4676->2556|4766->2623|4851->2672|4867->2679|4961->2750|5046->2799|5062->2806|5227->2948|5394->3079|5410->3086|5499->3152|5584->3201|5600->3208|5693->3278|5778->3327|5794->3334|5957->3474|6128->3609|6144->3616|6237->3686|6322->3735|6338->3742|6435->3816|6520->3865|6536->3872|6707->4020|7275->4552|7291->4559|7384->4629|7469->4678|7485->4685|7582->4759|7667->4808|7683->4815|7854->4963|8020->5093|8036->5100|8125->5166|8210->5215|8226->5222|8319->5292|8404->5341|8420->5348|8583->5488|8752->5621|8768->5628|8858->5695|8943->5744|8959->5751|9053->5822|9138->5871|9154->5878|9319->6020|9487->6151|9504->6158|9594->6224|9680->6273|9697->6280|9791->6350|9877->6399|9894->6406|10058->6546|10230->6681|10247->6688|10341->6758|10427->6807|10444->6814|10542->6888|10628->6937|10645->6944|10817->7092|11368->7606|11385->7613|11479->7683|11565->7732|11582->7739|11680->7813|11766->7862|11783->7869|11955->8017|12122->8147|12139->8154|12229->8220|12315->8269|12332->8276|12426->8346|12512->8395|12529->8402|12693->8542|12863->8675|12880->8682|12971->8749|13057->8798|13074->8805|13169->8876|13255->8925|13272->8932|13438->9074|13606->9205|13623->9212|13713->9278|13799->9327|13816->9334|13910->9404|13996->9453|14013->9460|14177->9600|14349->9735|14366->9742|14460->9812|14546->9861|14563->9868|14661->9942|14747->9991|14764->9998|14936->10146|15533->10706|15550->10713|15640->10779|15726->10828|15743->10835|15837->10905|15923->10954|15940->10961|16104->11101|16285->11245|16302->11252|16388->11314|16474->11363|16491->11370|16581->11436|16667->11485|16684->11492|16840->11624|17021->11768|17038->11775|17125->11838|17211->11887|17228->11894|17319->11961|17405->12010|17422->12017|17580->12151|17753->12287|17770->12294|17856->12356|17942->12405|17959->12412|18049->12478|18135->12527|18152->12534|18308->12666|18898->13219|18915->13226|19011->13298|19097->13347|19114->13354|19214->13430|19300->13479|19317->13486|19493->13638|19659->13767|19676->13774|19768->13842|19854->13891|19871->13898|19967->13970|20053->14019|20070->14026|20238->14170|20407->14302|20424->14309|20517->14378|20603->14427|20620->14434|20717->14507|20803->14556|20820->14563|20990->14709|21157->14839|21174->14846|21266->14914|21352->14963|21369->14970|21465->15042|21551->15091|21568->15098|21736->15242|21897->15366|21914->15373|22010->15445|22096->15494|22113->15501|22213->15577|22299->15626|22316->15633|22492->15785|22650->15910
=======
                    DATE: Mon Jun 16 14:32:15 COT 2014
=======
                    DATE: Fri Jul 04 16:10:10 COT 2014
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeprograma.scala.html
                    HASH: 87c4af6b8d6bf98f5eca0379c785b388a0fb99ff
                    MATRIX: 939->1|1408->323|1435->377|1545->452|1561->460|1594->472|1633->476|1662->484|1881->668|1927->705|1975->715|2079->783|2097->792|2137->810|2182->819|2196->824|2257->862|2296->864|2313->871|2375->910|2451->950|2469->959|2509->977|2554->986|2568->991|2629->1029|2668->1031|2685->1038|2747->1077|3221->1515|3237->1522|3330->1592|3415->1641|3431->1648|3528->1722|3613->1771|3629->1778|3800->1926|3966->2056|3982->2063|4071->2129|4156->2178|4172->2185|4265->2255|4350->2304|4366->2311|4529->2451|4698->2584|4714->2591|4804->2658|4889->2707|4905->2714|4999->2785|5084->2834|5100->2841|5265->2983|5432->3114|5448->3121|5537->3187|5622->3236|5638->3243|5731->3313|5816->3362|5832->3369|5995->3509|6166->3644|6182->3651|6275->3721|6360->3770|6376->3777|6473->3851|6558->3900|6574->3907|6745->4055|7313->4587|7329->4594|7422->4664|7507->4713|7523->4720|7620->4794|7705->4843|7721->4850|7892->4998|8058->5128|8074->5135|8163->5201|8248->5250|8264->5257|8357->5327|8442->5376|8458->5383|8621->5523|8790->5656|8806->5663|8896->5730|8981->5779|8997->5786|9091->5857|9176->5906|9192->5913|9357->6055|9525->6186|9542->6193|9632->6259|9718->6308|9735->6315|9829->6385|9915->6434|9932->6441|10096->6581|10268->6716|10285->6723|10379->6793|10465->6842|10482->6849|10580->6923|10666->6972|10683->6979|10855->7127|11406->7641|11423->7648|11517->7718|11603->7767|11620->7774|11718->7848|11804->7897|11821->7904|11993->8052|12160->8182|12177->8189|12267->8255|12353->8304|12370->8311|12464->8381|12550->8430|12567->8437|12731->8577|12901->8710|12918->8717|13009->8784|13095->8833|13112->8840|13207->8911|13293->8960|13310->8967|13476->9109|13644->9240|13661->9247|13751->9313|13837->9362|13854->9369|13948->9439|14034->9488|14051->9495|14215->9635|14387->9770|14404->9777|14498->9847|14584->9896|14601->9903|14699->9977|14785->10026|14802->10033|14974->10181|15571->10741|15588->10748|15678->10814|15764->10863|15781->10870|15875->10940|15961->10989|15978->10996|16142->11136|16323->11280|16340->11287|16426->11349|16512->11398|16529->11405|16619->11471|16705->11520|16722->11527|16878->11659|17059->11803|17076->11810|17163->11873|17249->11922|17266->11929|17357->11996|17443->12045|17460->12052|17618->12186|17791->12322|17808->12329|17894->12391|17980->12440|17997->12447|18087->12513|18173->12562|18190->12569|18346->12701|18936->13254|18953->13261|19049->13333|19135->13382|19152->13389|19252->13465|19338->13514|19355->13521|19531->13673|19697->13802|19714->13809|19806->13877|19892->13926|19909->13933|20005->14005|20091->14054|20108->14061|20276->14205|20445->14337|20462->14344|20555->14413|20641->14462|20658->14469|20755->14542|20841->14591|20858->14598|21028->14744|21195->14874|21212->14881|21304->14949|21390->14998|21407->15005|21503->15077|21589->15126|21606->15133|21774->15277|21935->15401|21952->15408|22048->15480|22134->15529|22151->15536|22251->15612|22337->15661|22354->15668|22530->15820|22688->15945
>>>>>>> 93429d7fbc474b9d33705b1aa2e201ce50fe2153
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|34->5|34->5|44->15|44->15|44->15|46->17|46->17|46->17|46->17|46->17|46->17|46->17|46->17|46->17|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|76->47|76->47|76->47|77->48|77->48|77->48|78->49|78->49|78->49|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|111->82|111->82|111->82|112->83|112->83|112->83|113->84|113->84|113->84|117->88|117->88|117->88|118->89|118->89|118->89|119->90|119->90|119->90|123->94|123->94|123->94|124->95|124->95|124->95|125->96|125->96|125->96|129->100|129->100|129->100|130->101|130->101|130->101|131->102|131->102|131->102|135->106|135->106|135->106|136->107|136->107|136->107|137->108|137->108|137->108|157->128|157->128|157->128|158->129|158->129|158->129|159->130|159->130|159->130|163->134|163->134|163->134|164->135|164->135|164->135|165->136|165->136|165->136|169->140|169->140|169->140|170->141|170->141|170->141|171->142|171->142|171->142|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|181->152|181->152|181->152|182->153|182->153|182->153|183->154|183->154|183->154|207->178|207->178|207->178|208->179|208->179|208->179|209->180|209->180|209->180|213->184|213->184|213->184|214->185|214->185|214->185|215->186|215->186|215->186|219->190|219->190|219->190|220->191|220->191|220->191|221->192|221->192|221->192|225->196|225->196|225->196|226->197|226->197|226->197|227->198|227->198|227->198|251->222|251->222|251->222|252->223|252->223|252->223|253->224|253->224|253->224|257->228|257->228|257->228|258->229|258->229|258->229|259->230|259->230|259->230|263->234|263->234|263->234|264->235|264->235|264->235|265->236|265->236|265->236|269->240|269->240|269->240|270->241|270->241|270->241|271->242|271->242|271->242|275->246|275->246|275->246|276->247|276->247|276->247|277->248|277->248|277->248|286->257
                    -- GENERATED --
                */
            