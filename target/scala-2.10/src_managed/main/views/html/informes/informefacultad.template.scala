
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
object informefacultad extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion ):play.api.templates.Html = {
=======
object informefacultad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template9[EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Facultad,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionDocencia:EvaluacionMateria, autoEvaluacionDocencia:EvaluacionMateria, evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion, autoEvaluacionInvestigacion:EvaluacionInvestigacion, mejorPeor:List[SaberNivel], facultad:Facultad,semestre:String ):play.api.templates.HtmlFormat.Appendable = {
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.325*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<h2 style="text-align: center;">Informe Final """),_display_(Seq[Any](/*5.48*/facultad/*5.56*/.getNombre())),format.raw/*5.68*/(""" - """),_display_(Seq[Any](/*5.72*/semestre)),format.raw/*5.80*/("""</h2>
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Informe Final Facultad </a></li>
		
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla"></div>
	  """),_display_(Seq[Any](/*15.5*/defining(new DecimalFormat("##0.00"))/*15.42*/{formato=>_display_(Seq[Any](format.raw/*15.52*/("""
	<h2>Campo de La Docencia</h2>
	<h3>Mejor Saber: """),_display_(Seq[Any](/*17.20*/mejorPeor/*17.29*/.get(0).getSaber())),format.raw/*17.47*/(""" Nivel: """),_display_(Seq[Any](/*17.56*/Nivel/*17.61*/.toString(mejorPeor.get(0).getNivel()))),format.raw/*17.99*/(""" """),_display_(Seq[Any](/*17.101*/formato/*17.108*/.format(mejorPeor.get(0).getPromedio()))),format.raw/*17.147*/(""" %  
	 , Peor Saber: """),_display_(Seq[Any](/*18.18*/mejorPeor/*18.27*/.get(1).getSaber())),format.raw/*18.45*/(""" Nivel: """),_display_(Seq[Any](/*18.54*/Nivel/*18.59*/.toString(mejorPeor.get(1).getNivel()))),format.raw/*18.97*/(""" """),_display_(Seq[Any](/*18.99*/formato/*18.106*/.format(mejorPeor.get(1).getPromedio()))),format.raw/*18.145*/(""" %</h3>
	
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
                <td class="row_headers">"""),_display_(Seq[Any](/*84.42*/formato/*84.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*84.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*88.42*/formato/*88.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*88.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*89.42*/formato/*89.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)))),format.raw/*89.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*90.42*/formato/*90.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*90.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*94.42*/formato/*94.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*94.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*95.42*/formato/*95.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)))),format.raw/*95.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*96.42*/formato/*96.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*96.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*100.42*/formato/*100.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*100.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*101.42*/formato/*101.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)))),format.raw/*101.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*102.42*/formato/*102.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*102.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*106.42*/formato/*106.49*/.format(evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*106.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*107.42*/formato/*107.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)))),format.raw/*107.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*108.42*/formato/*108.49*/.format((evaluacionDocencia.getPromedioRespuestas()(1)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*108.197*/(""" %</td>
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
                <td class="row_headers">"""),_display_(Seq[Any](/*130.42*/formato/*130.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.INFERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.INFERIOR)*0.2)))),format.raw/*130.197*/(""" %</td>
                </tr>
                <tr>
				<td class="row_headers">Bajo</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*134.42*/formato/*134.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*134.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*135.42*/formato/*135.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)))),format.raw/*135.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*136.42*/formato/*136.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.BAJO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.BAJO)*0.2)))),format.raw/*136.189*/(""" %</td>
                </tr>  
                <tr>
				<td class="row_headers">Medio</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*140.42*/formato/*140.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*140.116*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*141.42*/formato/*141.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)))),format.raw/*141.120*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*142.42*/formato/*142.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.MEDIO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.MEDIO)*0.2)))),format.raw/*142.191*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Alto</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*146.42*/formato/*146.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*146.115*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*147.42*/formato/*147.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)))),format.raw/*147.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*148.42*/formato/*148.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.ALTO)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.ALTO)*0.2)))),format.raw/*148.189*/(""" %</td>
                </tr> 
                <tr>
				<td class="row_headers">Superior</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*152.42*/formato/*152.49*/.format(evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*152.119*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*153.42*/formato/*153.49*/.format(autoEvaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)))),format.raw/*153.123*/(""" %</td>
                <td class="row_headers">"""),_display_(Seq[Any](/*154.42*/formato/*154.49*/.format((evaluacionDocencia.getPromedioRespuestas()(2)(Nivel.SUPERIOR)*0.8 + autoEvaluacionDocencia.getPromedioRespuestas()(0)(Nivel.SUPERIOR)*0.2)))),format.raw/*154.197*/(""" %</td>
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
    
<<<<<<< HEAD
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.Html = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.Html) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion)
=======
    def render(evaluacionDocencia:EvaluacionMateria,autoEvaluacionDocencia:EvaluacionMateria,evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,autoEvaluacionGestion:EvaluacionGestion,autoEvaluacionInvestigacion:EvaluacionInvestigacion,mejorPeor:List[SaberNivel],facultad:Facultad,semestre:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre)
    
    def f:((EvaluacionMateria,EvaluacionMateria,EvaluacionGestion,EvaluacionInvestigacion,EvaluacionGestion,EvaluacionInvestigacion,List[SaberNivel],Facultad,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre) => apply(evaluacionDocencia,autoEvaluacionDocencia,evaluacionGestion,evaluacionInvestigacion,autoEvaluacionGestion,autoEvaluacionInvestigacion,mejorPeor,facultad,semestre)
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informefacultad.scala.html
                    HASH: 1aef01d209f9b6f9ef70b8963c9515c421a6cba6
                    MATRIX: 855->1|1245->261|1272->315|1526->534|1572->571|1620->581|2116->1041|2132->1048|2225->1118|2310->1167|2326->1174|2423->1248|2508->1297|2524->1304|2695->1452|2861->1582|2877->1589|2966->1655|3051->1704|3067->1711|3160->1781|3245->1830|3261->1837|3424->1977|3593->2110|3609->2117|3699->2184|3784->2233|3800->2240|3894->2311|3979->2360|3995->2367|4160->2509|4327->2640|4343->2647|4432->2713|4517->2762|4533->2769|4626->2839|4711->2888|4727->2895|4890->3035|5061->3170|5077->3177|5170->3247|5255->3296|5271->3303|5368->3377|5453->3426|5469->3433|5640->3581|6208->4113|6224->4120|6317->4190|6402->4239|6418->4246|6515->4320|6600->4369|6616->4376|6787->4524|6953->4654|6969->4661|7058->4727|7143->4776|7159->4783|7252->4853|7337->4902|7353->4909|7516->5049|7685->5182|7701->5189|7791->5256|7876->5305|7892->5312|7986->5383|8071->5432|8087->5439|8252->5581|8419->5712|8435->5719|8524->5785|8609->5834|8625->5841|8718->5911|8803->5960|8819->5967|8982->6107|9154->6242|9171->6249|9265->6319|9351->6368|9368->6375|9466->6449|9552->6498|9569->6505|9741->6653|10292->7167|10309->7174|10403->7244|10489->7293|10506->7300|10604->7374|10690->7423|10707->7430|10879->7578|11046->7708|11063->7715|11153->7781|11239->7830|11256->7837|11350->7907|11436->7956|11453->7963|11617->8103|11787->8236|11804->8243|11895->8310|11981->8359|11998->8366|12093->8437|12179->8486|12196->8493|12362->8635|12530->8766|12547->8773|12637->8839|12723->8888|12740->8895|12834->8965|12920->9014|12937->9021|13101->9161|13273->9296|13290->9303|13384->9373|13470->9422|13487->9429|13585->9503|13671->9552|13688->9559|13860->9707|14457->10267|14474->10274|14564->10340|14650->10389|14667->10396|14761->10466|14847->10515|14864->10522|15028->10662|15209->10806|15226->10813|15312->10875|15398->10924|15415->10931|15505->10997|15591->11046|15608->11053|15764->11185|15945->11329|15962->11336|16049->11399|16135->11448|16152->11455|16243->11522|16329->11571|16346->11578|16504->11712|16677->11848|16694->11855|16780->11917|16866->11966|16883->11973|16973->12039|17059->12088|17076->12095|17232->12227|17822->12780|17839->12787|17935->12859|18021->12908|18038->12915|18138->12991|18224->13040|18241->13047|18417->13199|18583->13328|18600->13335|18692->13403|18778->13452|18795->13459|18891->13531|18977->13580|18994->13587|19162->13731|19331->13863|19348->13870|19441->13939|19527->13988|19544->13995|19641->14068|19727->14117|19744->14124|19914->14270|20081->14400|20098->14407|20190->14475|20276->14524|20293->14531|20389->14603|20475->14652|20492->14659|20660->14803|20821->14927|20838->14934|20934->15006|21020->15055|21037->15062|21137->15138|21223->15187|21240->15194|21416->15346|21574->15471
                    LINES: 26->1|32->1|33->4|43->14|43->14|43->14|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|72->43|72->43|72->43|73->44|73->44|73->44|74->45|74->45|74->45|78->49|78->49|78->49|79->50|79->50|79->50|80->51|80->51|80->51|84->55|84->55|84->55|85->56|85->56|85->56|86->57|86->57|86->57|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|125->96|125->96|125->96|126->97|126->97|126->97|127->98|127->98|127->98|131->102|131->102|131->102|132->103|132->103|132->103|133->104|133->104|133->104|153->124|153->124|153->124|154->125|154->125|154->125|155->126|155->126|155->126|159->130|159->130|159->130|160->131|160->131|160->131|161->132|161->132|161->132|165->136|165->136|165->136|166->137|166->137|166->137|167->138|167->138|167->138|171->142|171->142|171->142|172->143|172->143|172->143|173->144|173->144|173->144|177->148|177->148|177->148|178->149|178->149|178->149|179->150|179->150|179->150|203->174|203->174|203->174|204->175|204->175|204->175|205->176|205->176|205->176|209->180|209->180|209->180|210->181|210->181|210->181|211->182|211->182|211->182|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|221->192|221->192|221->192|222->193|222->193|222->193|223->194|223->194|223->194|247->218|247->218|247->218|248->219|248->219|248->219|249->220|249->220|249->220|253->224|253->224|253->224|254->225|254->225|254->225|255->226|255->226|255->226|259->230|259->230|259->230|260->231|260->231|260->231|261->232|261->232|261->232|265->236|265->236|265->236|266->237|266->237|266->237|267->238|267->238|267->238|271->242|271->242|271->242|272->243|272->243|272->243|273->244|273->244|273->244|282->253
=======
                    DATE: Tue Apr 15 15:13:27 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informefacultad.scala.html
                    HASH: d3f327407ce3f6942022ac1f6ffbacd0afbfd95f
                    MATRIX: 939->1|1409->324|1436->378|1537->444|1553->452|1586->464|1625->468|1654->476|1874->661|1920->698|1968->708|2055->759|2073->768|2113->786|2158->795|2172->800|2232->838|2271->840|2288->847|2350->886|2408->908|2426->917|2466->935|2511->944|2525->949|2585->987|2623->989|2640->996|2702->1035|3176->1473|3192->1480|3285->1550|3370->1599|3386->1606|3483->1680|3568->1729|3584->1736|3755->1884|3921->2014|3937->2021|4026->2087|4111->2136|4127->2143|4220->2213|4305->2262|4321->2269|4484->2409|4653->2542|4669->2549|4759->2616|4844->2665|4860->2672|4954->2743|5039->2792|5055->2799|5220->2941|5387->3072|5403->3079|5492->3145|5577->3194|5593->3201|5686->3271|5771->3320|5787->3327|5950->3467|6121->3602|6137->3609|6230->3679|6315->3728|6331->3735|6428->3809|6513->3858|6529->3865|6700->4013|7268->4545|7284->4552|7377->4622|7462->4671|7478->4678|7575->4752|7660->4801|7676->4808|7847->4956|8013->5086|8029->5093|8118->5159|8203->5208|8219->5215|8312->5285|8397->5334|8413->5341|8576->5481|8745->5614|8761->5621|8851->5688|8936->5737|8952->5744|9046->5815|9131->5864|9147->5871|9312->6013|9480->6144|9497->6151|9587->6217|9673->6266|9690->6273|9784->6343|9870->6392|9887->6399|10051->6539|10223->6674|10240->6681|10334->6751|10420->6800|10437->6807|10535->6881|10621->6930|10638->6937|10810->7085|11361->7599|11378->7606|11472->7676|11558->7725|11575->7732|11673->7806|11759->7855|11776->7862|11948->8010|12115->8140|12132->8147|12222->8213|12308->8262|12325->8269|12419->8339|12505->8388|12522->8395|12686->8535|12856->8668|12873->8675|12964->8742|13050->8791|13067->8798|13162->8869|13248->8918|13265->8925|13431->9067|13599->9198|13616->9205|13706->9271|13792->9320|13809->9327|13903->9397|13989->9446|14006->9453|14170->9593|14342->9728|14359->9735|14453->9805|14539->9854|14556->9861|14654->9935|14740->9984|14757->9991|14929->10139|15526->10699|15543->10706|15633->10772|15719->10821|15736->10828|15830->10898|15916->10947|15933->10954|16097->11094|16278->11238|16295->11245|16381->11307|16467->11356|16484->11363|16574->11429|16660->11478|16677->11485|16833->11617|17014->11761|17031->11768|17118->11831|17204->11880|17221->11887|17312->11954|17398->12003|17415->12010|17573->12144|17746->12280|17763->12287|17849->12349|17935->12398|17952->12405|18042->12471|18128->12520|18145->12527|18301->12659|18891->13212|18908->13219|19004->13291|19090->13340|19107->13347|19207->13423|19293->13472|19310->13479|19486->13631|19652->13760|19669->13767|19761->13835|19847->13884|19864->13891|19960->13963|20046->14012|20063->14019|20231->14163|20400->14295|20417->14302|20510->14371|20596->14420|20613->14427|20710->14500|20796->14549|20813->14556|20983->14702|21150->14832|21167->14839|21259->14907|21345->14956|21362->14963|21458->15035|21544->15084|21561->15091|21729->15235|21890->15359|21907->15366|22003->15438|22089->15487|22106->15494|22206->15570|22292->15619|22309->15626|22485->15778|22643->15903
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|34->5|34->5|44->15|44->15|44->15|46->17|46->17|46->17|46->17|46->17|46->17|46->17|46->17|46->17|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|76->47|76->47|76->47|77->48|77->48|77->48|78->49|78->49|78->49|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|111->82|111->82|111->82|112->83|112->83|112->83|113->84|113->84|113->84|117->88|117->88|117->88|118->89|118->89|118->89|119->90|119->90|119->90|123->94|123->94|123->94|124->95|124->95|124->95|125->96|125->96|125->96|129->100|129->100|129->100|130->101|130->101|130->101|131->102|131->102|131->102|135->106|135->106|135->106|136->107|136->107|136->107|137->108|137->108|137->108|157->128|157->128|157->128|158->129|158->129|158->129|159->130|159->130|159->130|163->134|163->134|163->134|164->135|164->135|164->135|165->136|165->136|165->136|169->140|169->140|169->140|170->141|170->141|170->141|171->142|171->142|171->142|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|181->152|181->152|181->152|182->153|182->153|182->153|183->154|183->154|183->154|207->178|207->178|207->178|208->179|208->179|208->179|209->180|209->180|209->180|213->184|213->184|213->184|214->185|214->185|214->185|215->186|215->186|215->186|219->190|219->190|219->190|220->191|220->191|220->191|221->192|221->192|221->192|225->196|225->196|225->196|226->197|226->197|226->197|227->198|227->198|227->198|251->222|251->222|251->222|252->223|252->223|252->223|253->224|253->224|253->224|257->228|257->228|257->228|258->229|258->229|258->229|259->230|259->230|259->230|263->234|263->234|263->234|264->235|264->235|264->235|265->236|265->236|265->236|269->240|269->240|269->240|270->241|270->241|270->241|271->242|271->242|271->242|275->246|275->246|275->246|276->247|276->247|276->247|277->248|277->248|277->248|286->257
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            