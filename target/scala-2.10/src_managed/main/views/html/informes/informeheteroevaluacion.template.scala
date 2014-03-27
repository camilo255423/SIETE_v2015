
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
object informeheteroevaluacion extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion):play.api.templates.Html = {
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
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.Html = apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.Html) = (evaluacionMateria,evaluacionGestion,evaluacionInvestigacion) => apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 24 19:20:31 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeheteroevaluacion.scala.html
                    HASH: df08d06d393531892d94601cdda9c76824ce94c3
                    MATRIX: 809->1|1068->130|1095->184|1779->833|1831->869|1870->870|1916->880|1962->917|2010->927|2059->940|2398->1270|2444->1278|2494->1293|2514->1304|2554->1306|2612->1328|2631->1338|2678->1363|2723->1372|2742->1382|2789->1406|2852->1433|2868->1440|2967->1516|3032->1545|3048->1552|3143->1624|3208->1653|3224->1660|3320->1733|3385->1762|3401->1769|3496->1841|3561->1870|3577->1877|3676->1953|3745->1990|3805->2018|3849->2030|3893->2042|4372->2486|4424->2522|4463->2523|4512->2536|4558->2573|4606->2583|4655->2596|4994->2926|5040->2934|5090->2949|5110->2960|5150->2962|5208->2984|5227->2994|5274->3019|5319->3028|5338->3038|5385->3062|5450->3091|5466->3098|5565->3174|5630->3203|5646->3210|5741->3282|5806->3311|5822->3318|5918->3391|5983->3420|5999->3427|6094->3499|6159->3528|6175->3535|6274->3611|6329->3634|6403->3676|6447->3688|6491->3700|6972->4146|7024->4182|7063->4183|7110->4194|7156->4231|7204->4241|7254->4254|7594->4584|7641->4592|7692->4607|7713->4618|7754->4620|7813->4642|7833->4652|7881->4677|7927->4686|7947->4696|7995->4720|8059->4747|8076->4754|8176->4830|8242->4859|8259->4866|8355->4938|8421->4967|8438->4974|8535->5047|8601->5076|8618->5083|8714->5155|8780->5184|8797->5191|8897->5267|8953->5290|9028->5332|9073->5344|9118->5356|9522->5723|9569->5760|9618->5770|9668->5783|9958->6063|10005->6071|10056->6086|10077->6097|10118->6099|10203->6147|10220->6154|10324->6234|10390->6263|10407->6270|10507->6346|10573->6375|10590->6382|10691->6459|10757->6488|10774->6495|10874->6571|10959->6623|11021->6652|11066->6664|11553->7114|11600->7151|11649->7161|11699->7174|12083->7548|12130->7556|12181->7571|12202->7582|12243->7584|12337->7641|12354->7648|12464->7734|12530->7763|12547->7770|12653->7852|12719->7881|12736->7888|12843->7971|12909->8000|12926->8007|13032->8089|13098->8118|13115->8125|13225->8211|13293->8246|13355->8275|13400->8287
                    LINES: 26->1|32->1|33->4|54->25|54->25|54->25|55->26|55->26|55->26|56->27|61->32|61->32|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|71->42|73->44|74->45|75->46|91->62|91->62|91->62|92->63|92->63|92->63|93->64|98->69|98->69|100->71|100->71|100->71|101->72|101->72|101->72|101->72|101->72|101->72|102->73|102->73|102->73|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|107->78|110->81|111->82|112->83|127->98|127->98|127->98|128->99|128->99|128->99|129->100|134->105|134->105|136->107|136->107|136->107|137->108|137->108|137->108|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|143->114|146->117|147->118|148->119|165->136|165->136|165->136|166->137|170->141|170->141|172->143|172->143|172->143|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|180->151|182->153|183->154|201->172|201->172|201->172|202->173|207->178|207->178|209->180|209->180|209->180|214->185|214->185|214->185|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|218->189|218->189|218->189|220->191|222->193|223->194
                    -- GENERATED --
                */
            