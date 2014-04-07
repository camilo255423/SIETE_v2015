
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
object informeheteroevaluacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.131*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Heteroevaluación</a></li>
			<li><a href="#tabs-autoevaluacion">Autoevaluación</a></li>
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla">Heteroevaluación</div>
	<h2>Saber Pedagógico</h2>
	
	<table>
	<tbody>
        <tr>
        <td class="row_headers">Asignatura</td>
		<td class="row_headers" >Nivel<br></br>Inferior</td>
		<td class="row_headers" >Nivel<br></br>Bajo</td>
		<td class="row_headers" >Nivel<br></br>Medio</td>
		<td class="row_headers" >Nivel<br></br>Alto</td>
		<td class="row_headers" >Nivel<br></br>Superior</td>
	     </tr>
	     """),_display_(Seq[Any](/*25.8*/for(evaluacion <- evaluacionMateria) yield /*25.44*/{_display_(Seq[Any](format.raw/*25.45*/("""
	       """),_display_(Seq[Any](/*26.10*/defining(new DecimalFormat("##0.00"))/*26.47*/{formato=>_display_(Seq[Any](format.raw/*26.57*/("""
       	   """),_display_(Seq[Any](/*27.13*/defining((evaluacion.getPromedioRespuestas()(0)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.SUPERIOR))
       	   )/*32.13*/{total=>_display_(Seq[Any](format.raw/*32.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*34.4*/if(total>0)/*34.15*/ {_display_(Seq[Any](format.raw/*34.17*/("""
                <td>"""),_display_(Seq[Any](/*35.22*/evaluacion/*35.32*/.getMateria().getNombre())),format.raw/*35.57*/(""", grupo """),_display_(Seq[Any](/*35.66*/evaluacion/*35.76*/.getMateria().getGrupo())),format.raw/*35.100*/("""</td>
                <td>"""),_display_(Seq[Any](/*36.22*/formato/*36.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.INFERIOR)/total)))),format.raw/*36.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*37.22*/formato/*37.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.BAJO)/total)))),format.raw/*37.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*38.22*/formato/*38.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.MEDIO)/total)))),format.raw/*38.102*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*39.22*/formato/*39.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.ALTO)/total)))),format.raw/*39.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*40.22*/formato/*40.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.SUPERIOR)/total)))),format.raw/*40.105*/(""" %</td>
              
             """)))})),format.raw/*42.15*/("""
          </tr>
          """)))})),format.raw/*44.12*/("""
          """)))})),format.raw/*45.12*/("""
          """)))})),format.raw/*46.12*/("""
          </tbody>
          </table>
          	<h2>Saber Específico</h2>
   	
	<table>
	<tbody>
	   
        <tr>
        <td class="row_headers">Asignatura</td>
		<td class="row_headers">Nivel<br></br>Inferior</td>
		<td class="row_headers">Nivel<br></br>Bajo</td>
		<td class="row_headers">Nivel<br></br>Medio</td>
		<td class="row_headers">Nivel<br></br>Alto</td>
		<td class="row_headers">Nivel<br></br>Superior</td>
	     </tr>
	      """),_display_(Seq[Any](/*62.9*/for(evaluacion <- evaluacionMateria) yield /*62.45*/{_display_(Seq[Any](format.raw/*62.46*/("""   
	       """),_display_(Seq[Any](/*63.10*/defining(new DecimalFormat("##0.00"))/*63.47*/{formato=>_display_(Seq[Any](format.raw/*63.57*/("""
       	   """),_display_(Seq[Any](/*64.13*/defining((evaluacion.getPromedioRespuestas()(1)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.SUPERIOR))
       	   )/*69.13*/{total=>_display_(Seq[Any](format.raw/*69.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*71.4*/if(total>0)/*71.15*/ {_display_(Seq[Any](format.raw/*71.17*/("""
                <td>"""),_display_(Seq[Any](/*72.22*/evaluacion/*72.32*/.getMateria().getNombre())),format.raw/*72.57*/(""", grupo """),_display_(Seq[Any](/*72.66*/evaluacion/*72.76*/.getMateria().getGrupo())),format.raw/*72.100*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*73.22*/formato/*73.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.INFERIOR)/total)))),format.raw/*73.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*74.22*/formato/*74.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.BAJO)/total)))),format.raw/*74.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*75.22*/formato/*75.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.MEDIO)/total)))),format.raw/*75.102*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*76.22*/formato/*76.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.ALTO)/total)))),format.raw/*76.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*77.22*/formato/*77.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.SUPERIOR)/total)))),format.raw/*77.105*/(""" %</td>
              """)))})),format.raw/*78.16*/("""
             
          </tr>
          """)))})),format.raw/*81.12*/("""
          """)))})),format.raw/*82.12*/("""
          """)))})),format.raw/*83.12*/("""
          </tbody>
          </table>
          <h2>Saber Relacional</h2>
           <table>
	<tbody>
	  
        <tr>
        <td class="row_headers">Asignatura</td>
		<td class="row_headers">Nivel<br></br>Inferior</td>
		<td class="row_headers">Nivel<br></br>Bajo</td>
		<td class="row_headers">Nivel<br></br>Medio</td>
		<td class="row_headers">Nivel<br></br>Alto</td>
		<td class="row_headers">Nivel<br></br>Superior</td>
	     </tr>
	     """),_display_(Seq[Any](/*98.8*/for(evaluacion <- evaluacionMateria) yield /*98.44*/{_display_(Seq[Any](format.raw/*98.45*/(""" 
	       """),_display_(Seq[Any](/*99.10*/defining(new DecimalFormat("##0.00"))/*99.47*/{formato=>_display_(Seq[Any](format.raw/*99.57*/("""
       	   """),_display_(Seq[Any](/*100.13*/defining((evaluacion.getPromedioRespuestas()(2)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.SUPERIOR))
       	   )/*105.13*/{total=>_display_(Seq[Any](format.raw/*105.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*107.4*/if(total>0)/*107.15*/ {_display_(Seq[Any](format.raw/*107.17*/("""
                <td>"""),_display_(Seq[Any](/*108.22*/evaluacion/*108.32*/.getMateria().getNombre())),format.raw/*108.57*/(""", grupo """),_display_(Seq[Any](/*108.66*/evaluacion/*108.76*/.getMateria().getGrupo())),format.raw/*108.100*/("""</td>
                <td>"""),_display_(Seq[Any](/*109.22*/formato/*109.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.INFERIOR)/total)))),format.raw/*109.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*110.22*/formato/*110.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.BAJO)/total)))),format.raw/*110.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*111.22*/formato/*111.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.MEDIO)/total)))),format.raw/*111.102*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*112.22*/formato/*112.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.ALTO)/total)))),format.raw/*112.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*113.22*/formato/*113.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.SUPERIOR)/total)))),format.raw/*113.105*/(""" %</td>
              """)))})),format.raw/*114.16*/("""
             
          </tr>
          """)))})),format.raw/*117.12*/("""
          """)))})),format.raw/*118.12*/("""
          """)))})),format.raw/*119.12*/("""
          </tbody>
          </table>
          
          	<h2>Gestión</h2>
       	
	<table>
	<tbody>
	  
        <tr>
        <td class="row_headers"></td>
		<td class="row_headers">No Cumple</td>
		<td class="row_headers">Cumple Parcialmente</td>
		<td class="row_headers">Cumple Totalmente</td>
		<td class="row_headers">No Aplica</td>
	     </tr>
	  
	       """),_display_(Seq[Any](/*136.10*/defining(new DecimalFormat("##0.00"))/*136.47*/{formato=>_display_(Seq[Any](format.raw/*136.57*/("""
       	   """),_display_(Seq[Any](/*137.13*/defining((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)
       	   ))/*141.14*/{total=>_display_(Seq[Any](format.raw/*141.22*/("""
	     <tr>
		"""),_display_(Seq[Any](/*143.4*/if(total>0)/*143.15*/ {_display_(Seq[Any](format.raw/*143.17*/("""
                <td></td>
                <td>"""),_display_(Seq[Any](/*145.22*/formato/*145.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)/total)))),format.raw/*145.109*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*146.22*/formato/*146.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)/total)))),format.raw/*146.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*147.22*/formato/*147.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)/total)))),format.raw/*147.106*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*148.22*/formato/*148.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)/total)))),format.raw/*148.105*/(""" %</td>
               
              
            """)))})),format.raw/*151.14*/(""" 
          </tr>
          """)))})),format.raw/*153.12*/("""
          """)))})),format.raw/*154.12*/("""
          
          </tbody>
          </table>
          	<h2>Investigación</h2>
       	
	<table>
	<tbody>
	  
        <tr>
        <td class="row_headers"></td>
		<td class="row_headers">Nivel<br></br>Inferior</td>
		<td class="row_headers">Nivel<br></br>Bajo</td>
		<td class="row_headers">Nivel<br></br>Medio</td>
		<td class="row_headers">Nivel<br></br>Alto</td>
		<td class="row_headers">Nivel<br></br>Superior</td>
	     </tr>
	  
	       """),_display_(Seq[Any](/*172.10*/defining(new DecimalFormat("##0.00"))/*172.47*/{formato=>_display_(Seq[Any](format.raw/*172.57*/("""
       	   """),_display_(Seq[Any](/*173.13*/defining((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)
       	   ))/*178.14*/{total=>_display_(Seq[Any](format.raw/*178.22*/("""
	     <tr>
		"""),_display_(Seq[Any](/*180.4*/if(total>0)/*180.15*/ {_display_(Seq[Any](format.raw/*180.17*/("""
		
		
		
                <td></td>
                <td>"""),_display_(Seq[Any](/*185.22*/formato/*185.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)/total)))),format.raw/*185.115*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*186.22*/formato/*186.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)/total)))),format.raw/*186.111*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*187.22*/formato/*187.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)/total)))),format.raw/*187.112*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*188.22*/formato/*188.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)/total)))),format.raw/*188.111*/(""" %</td>
               	<td>"""),_display_(Seq[Any](/*189.22*/formato/*189.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)/total)))),format.raw/*189.115*/(""" %</td>
              
           """)))})),format.raw/*191.13*/(""" 
          </tr>
          """)))})),format.raw/*193.12*/("""
          """)))})),format.raw/*194.12*/("""
          
          </tbody>
          </table>
		 

	</div> <!--  docencia -->

</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,evaluacionGestion,evaluacionInvestigacion) => apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 04 16:48:50 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeheteroevaluacion.scala.html
                    HASH: 495ca978352d1054d8b1a00e5cdb958d9a74bf35
                    MATRIX: 860->1|1136->130|1163->184|1847->833|1899->869|1938->870|1984->880|2030->917|2078->927|2127->940|2466->1270|2512->1278|2562->1293|2582->1304|2622->1306|2680->1328|2699->1338|2746->1363|2791->1372|2810->1382|2857->1406|2920->1433|2936->1440|3035->1516|3100->1545|3116->1552|3211->1624|3276->1653|3292->1660|3388->1733|3453->1762|3469->1769|3564->1841|3629->1870|3645->1877|3744->1953|3813->1990|3873->2018|3917->2030|3961->2042|4440->2486|4492->2522|4531->2523|4580->2536|4626->2573|4674->2583|4723->2596|5062->2926|5108->2934|5158->2949|5178->2960|5218->2962|5276->2984|5295->2994|5342->3019|5387->3028|5406->3038|5453->3062|5518->3091|5534->3098|5633->3174|5698->3203|5714->3210|5809->3282|5874->3311|5890->3318|5986->3391|6051->3420|6067->3427|6162->3499|6227->3528|6243->3535|6342->3611|6397->3634|6471->3676|6515->3688|6559->3700|7040->4146|7092->4182|7131->4183|7178->4194|7224->4231|7272->4241|7322->4254|7662->4584|7709->4592|7760->4607|7781->4618|7822->4620|7881->4642|7901->4652|7949->4677|7995->4686|8015->4696|8063->4720|8127->4747|8144->4754|8244->4830|8310->4859|8327->4866|8423->4938|8489->4967|8506->4974|8603->5047|8669->5076|8686->5083|8782->5155|8848->5184|8865->5191|8965->5267|9021->5290|9096->5332|9141->5344|9186->5356|9590->5723|9637->5760|9686->5770|9736->5783|10026->6063|10073->6071|10124->6086|10145->6097|10186->6099|10271->6147|10288->6154|10392->6234|10458->6263|10475->6270|10575->6346|10641->6375|10658->6382|10759->6459|10825->6488|10842->6495|10942->6571|11027->6623|11089->6652|11134->6664|11621->7114|11668->7151|11717->7161|11767->7174|12151->7548|12198->7556|12249->7571|12270->7582|12311->7584|12405->7641|12422->7648|12532->7734|12598->7763|12615->7770|12721->7852|12787->7881|12804->7888|12911->7971|12977->8000|12994->8007|13100->8089|13166->8118|13183->8125|13293->8211|13361->8246|13423->8275|13468->8287
                    LINES: 26->1|32->1|33->4|54->25|54->25|54->25|55->26|55->26|55->26|56->27|61->32|61->32|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|71->42|73->44|74->45|75->46|91->62|91->62|91->62|92->63|92->63|92->63|93->64|98->69|98->69|100->71|100->71|100->71|101->72|101->72|101->72|101->72|101->72|101->72|102->73|102->73|102->73|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|107->78|110->81|111->82|112->83|127->98|127->98|127->98|128->99|128->99|128->99|129->100|134->105|134->105|136->107|136->107|136->107|137->108|137->108|137->108|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|143->114|146->117|147->118|148->119|165->136|165->136|165->136|166->137|170->141|170->141|172->143|172->143|172->143|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|180->151|182->153|183->154|201->172|201->172|201->172|202->173|207->178|207->178|209->180|209->180|209->180|214->185|214->185|214->185|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|218->189|218->189|218->189|220->191|222->193|223->194
                    -- GENERATED --
                */
            