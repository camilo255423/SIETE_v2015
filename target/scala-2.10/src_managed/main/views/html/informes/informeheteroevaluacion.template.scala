
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
object informeheteroevaluacion extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion):play.api.templates.Html = {
=======
object informeheteroevaluacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String):play.api.templates.HtmlFormat.Appendable = {
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.165*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<h2 style="text-align: center;">"""),_display_(Seq[Any](/*5.34*/profesor/*5.42*/.getApellidos())),format.raw/*5.57*/(""" """),_display_(Seq[Any](/*5.59*/profesor/*5.67*/.getNombres())),format.raw/*5.80*/(""" - Informe Heteroevaluación """),_display_(Seq[Any](/*5.109*/semestre)),format.raw/*5.117*/("""</h2>
<div class="tabs">
		<ul>
			<li><a href="#tabs-docencia">Heteroevaluación</a></li>
			
		</ul>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla"></div>
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
	     """),_display_(Seq[Any](/*26.8*/for(evaluacion <- evaluacionMateria) yield /*26.44*/{_display_(Seq[Any](format.raw/*26.45*/("""
	       """),_display_(Seq[Any](/*27.10*/defining(new DecimalFormat("##0.00"))/*27.47*/{formato=>_display_(Seq[Any](format.raw/*27.57*/("""
       	   """),_display_(Seq[Any](/*28.13*/defining((evaluacion.getPromedioRespuestas()(0)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.SUPERIOR))
       	   )/*33.13*/{total=>_display_(Seq[Any](format.raw/*33.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*35.4*/if(total>0)/*35.15*/ {_display_(Seq[Any](format.raw/*35.17*/("""
                <td>"""),_display_(Seq[Any](/*36.22*/evaluacion/*36.32*/.getMateria().getNombre())),format.raw/*36.57*/(""", grupo """),_display_(Seq[Any](/*36.66*/evaluacion/*36.76*/.getMateria().getGrupo())),format.raw/*36.100*/("""</td>
                <td>"""),_display_(Seq[Any](/*37.22*/formato/*37.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.INFERIOR)/total)))),format.raw/*37.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*38.22*/formato/*38.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.BAJO)/total)))),format.raw/*38.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*39.22*/formato/*39.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.MEDIO)/total)))),format.raw/*39.102*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*40.22*/formato/*40.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.ALTO)/total)))),format.raw/*40.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*41.22*/formato/*41.29*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.SUPERIOR)/total)))),format.raw/*41.105*/(""" %</td>
              
             """)))})),format.raw/*43.15*/("""
          </tr>
          """)))})),format.raw/*45.12*/("""
          """)))})),format.raw/*46.12*/("""
          """)))})),format.raw/*47.12*/("""
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
	      """),_display_(Seq[Any](/*63.9*/for(evaluacion <- evaluacionMateria) yield /*63.45*/{_display_(Seq[Any](format.raw/*63.46*/("""   
	       """),_display_(Seq[Any](/*64.10*/defining(new DecimalFormat("##0.00"))/*64.47*/{formato=>_display_(Seq[Any](format.raw/*64.57*/("""
       	   """),_display_(Seq[Any](/*65.13*/defining((evaluacion.getPromedioRespuestas()(1)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.SUPERIOR))
       	   )/*70.13*/{total=>_display_(Seq[Any](format.raw/*70.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*72.4*/if(total>0)/*72.15*/ {_display_(Seq[Any](format.raw/*72.17*/("""
                <td>"""),_display_(Seq[Any](/*73.22*/evaluacion/*73.32*/.getMateria().getNombre())),format.raw/*73.57*/(""", grupo """),_display_(Seq[Any](/*73.66*/evaluacion/*73.76*/.getMateria().getGrupo())),format.raw/*73.100*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*74.22*/formato/*74.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.INFERIOR)/total)))),format.raw/*74.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*75.22*/formato/*75.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.BAJO)/total)))),format.raw/*75.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*76.22*/formato/*76.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.MEDIO)/total)))),format.raw/*76.102*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*77.22*/formato/*77.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.ALTO)/total)))),format.raw/*77.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*78.22*/formato/*78.29*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.SUPERIOR)/total)))),format.raw/*78.105*/(""" %</td>
              """)))})),format.raw/*79.16*/("""
             
          </tr>
          """)))})),format.raw/*82.12*/("""
          """)))})),format.raw/*83.12*/("""
          """)))})),format.raw/*84.12*/("""
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
	     """),_display_(Seq[Any](/*99.8*/for(evaluacion <- evaluacionMateria) yield /*99.44*/{_display_(Seq[Any](format.raw/*99.45*/(""" 
	       """),_display_(Seq[Any](/*100.10*/defining(new DecimalFormat("##0.00"))/*100.47*/{formato=>_display_(Seq[Any](format.raw/*100.57*/("""
       	   """),_display_(Seq[Any](/*101.13*/defining((evaluacion.getPromedioRespuestas()(2)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.SUPERIOR))
       	   )/*106.13*/{total=>_display_(Seq[Any](format.raw/*106.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*108.4*/if(total>0)/*108.15*/ {_display_(Seq[Any](format.raw/*108.17*/("""
                <td>"""),_display_(Seq[Any](/*109.22*/evaluacion/*109.32*/.getMateria().getNombre())),format.raw/*109.57*/(""", grupo """),_display_(Seq[Any](/*109.66*/evaluacion/*109.76*/.getMateria().getGrupo())),format.raw/*109.100*/("""</td>
                <td>"""),_display_(Seq[Any](/*110.22*/formato/*110.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.INFERIOR)/total)))),format.raw/*110.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*111.22*/formato/*111.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.BAJO)/total)))),format.raw/*111.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*112.22*/formato/*112.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.MEDIO)/total)))),format.raw/*112.102*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*113.22*/formato/*113.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.ALTO)/total)))),format.raw/*113.101*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*114.22*/formato/*114.29*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.SUPERIOR)/total)))),format.raw/*114.105*/(""" %</td>
              """)))})),format.raw/*115.16*/("""
             
          </tr>
          """)))})),format.raw/*118.12*/("""
          """)))})),format.raw/*119.12*/("""
          """)))})),format.raw/*120.12*/("""
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
	  
	       """),_display_(Seq[Any](/*137.10*/defining(new DecimalFormat("##0.00"))/*137.47*/{formato=>_display_(Seq[Any](format.raw/*137.57*/("""
       	   """),_display_(Seq[Any](/*138.13*/defining((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)
       	   ))/*142.14*/{total=>_display_(Seq[Any](format.raw/*142.22*/("""
	     <tr>
		"""),_display_(Seq[Any](/*144.4*/if(total>0)/*144.15*/ {_display_(Seq[Any](format.raw/*144.17*/("""
                <td></td>
                <td>"""),_display_(Seq[Any](/*146.22*/formato/*146.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)/total)))),format.raw/*146.109*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*147.22*/formato/*147.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)/total)))),format.raw/*147.105*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*148.22*/formato/*148.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)/total)))),format.raw/*148.106*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*149.22*/formato/*149.29*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)/total)))),format.raw/*149.105*/(""" %</td>
               
              
            """)))})),format.raw/*152.14*/(""" 
          </tr>
          """)))})),format.raw/*154.12*/("""
          """)))})),format.raw/*155.12*/("""
          
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
	  
	       """),_display_(Seq[Any](/*173.10*/defining(new DecimalFormat("##0.00"))/*173.47*/{formato=>_display_(Seq[Any](format.raw/*173.57*/("""
       	   """),_display_(Seq[Any](/*174.13*/defining((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)
       	   ))/*179.14*/{total=>_display_(Seq[Any](format.raw/*179.22*/("""
	     <tr>
		"""),_display_(Seq[Any](/*181.4*/if(total>0)/*181.15*/ {_display_(Seq[Any](format.raw/*181.17*/("""
		
		
		
                <td></td>
                <td>"""),_display_(Seq[Any](/*186.22*/formato/*186.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)/total)))),format.raw/*186.115*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*187.22*/formato/*187.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)/total)))),format.raw/*187.111*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*188.22*/formato/*188.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)/total)))),format.raw/*188.112*/(""" %</td>
                <td>"""),_display_(Seq[Any](/*189.22*/formato/*189.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)/total)))),format.raw/*189.111*/(""" %</td>
               	<td>"""),_display_(Seq[Any](/*190.22*/formato/*190.29*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)/total)))),format.raw/*190.115*/(""" %</td>
              
           """)))})),format.raw/*192.13*/(""" 
          </tr>
          """)))})),format.raw/*194.12*/("""
          """)))})),format.raw/*195.12*/("""
          
          </tbody>
          </table>
		 

	</div> <!--  docencia -->

</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
<script>
$( ".tabs" ).tabs();
</script>"""))}
    }
    
<<<<<<< HEAD
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion): play.api.templates.Html = apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion) => play.api.templates.Html) = (evaluacionMateria,evaluacionGestion,evaluacionInvestigacion) => apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion)
=======
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,Profesor,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre) => apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre)
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informeheteroevaluacion.scala.html
                    HASH: df08d06d393531892d94601cdda9c76824ce94c3
                    MATRIX: 809->1|1068->130|1095->184|1779->833|1831->869|1870->870|1916->880|1962->917|2010->927|2059->940|2398->1270|2444->1278|2494->1293|2514->1304|2554->1306|2612->1328|2631->1338|2678->1363|2723->1372|2742->1382|2789->1406|2852->1433|2868->1440|2967->1516|3032->1545|3048->1552|3143->1624|3208->1653|3224->1660|3320->1733|3385->1762|3401->1769|3496->1841|3561->1870|3577->1877|3676->1953|3745->1990|3805->2018|3849->2030|3893->2042|4372->2486|4424->2522|4463->2523|4512->2536|4558->2573|4606->2583|4655->2596|4994->2926|5040->2934|5090->2949|5110->2960|5150->2962|5208->2984|5227->2994|5274->3019|5319->3028|5338->3038|5385->3062|5450->3091|5466->3098|5565->3174|5630->3203|5646->3210|5741->3282|5806->3311|5822->3318|5918->3391|5983->3420|5999->3427|6094->3499|6159->3528|6175->3535|6274->3611|6329->3634|6403->3676|6447->3688|6491->3700|6972->4146|7024->4182|7063->4183|7110->4194|7156->4231|7204->4241|7254->4254|7594->4584|7641->4592|7692->4607|7713->4618|7754->4620|7813->4642|7833->4652|7881->4677|7927->4686|7947->4696|7995->4720|8059->4747|8076->4754|8176->4830|8242->4859|8259->4866|8355->4938|8421->4967|8438->4974|8535->5047|8601->5076|8618->5083|8714->5155|8780->5184|8797->5191|8897->5267|8953->5290|9028->5332|9073->5344|9118->5356|9522->5723|9569->5760|9618->5770|9668->5783|9958->6063|10005->6071|10056->6086|10077->6097|10118->6099|10203->6147|10220->6154|10324->6234|10390->6263|10407->6270|10507->6346|10573->6375|10590->6382|10691->6459|10757->6488|10774->6495|10874->6571|10959->6623|11021->6652|11066->6664|11553->7114|11600->7151|11649->7161|11699->7174|12083->7548|12130->7556|12181->7571|12202->7582|12243->7584|12337->7641|12354->7648|12464->7734|12530->7763|12547->7770|12653->7852|12719->7881|12736->7888|12843->7971|12909->8000|12926->8007|13032->8089|13098->8118|13115->8125|13225->8211|13293->8246|13355->8275|13400->8287
                    LINES: 26->1|32->1|33->4|54->25|54->25|54->25|55->26|55->26|55->26|56->27|61->32|61->32|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|71->42|73->44|74->45|75->46|91->62|91->62|91->62|92->63|92->63|92->63|93->64|98->69|98->69|100->71|100->71|100->71|101->72|101->72|101->72|101->72|101->72|101->72|102->73|102->73|102->73|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|107->78|110->81|111->82|112->83|127->98|127->98|127->98|128->99|128->99|128->99|129->100|134->105|134->105|136->107|136->107|136->107|137->108|137->108|137->108|137->108|137->108|137->108|138->109|138->109|138->109|139->110|139->110|139->110|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|143->114|146->117|147->118|148->119|165->136|165->136|165->136|166->137|170->141|170->141|172->143|172->143|172->143|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|180->151|182->153|183->154|201->172|201->172|201->172|202->173|207->178|207->178|209->180|209->180|209->180|214->185|214->185|214->185|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|218->189|218->189|218->189|220->191|222->193|223->194
=======
                    DATE: Tue Apr 15 15:10:10 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informeheteroevaluacion.scala.html
                    HASH: b9b4d245b3978461096f6fb8fc7e1ccaf264b587
                    MATRIX: 876->1|1186->164|1213->218|1300->270|1316->278|1352->293|1389->295|1405->303|1439->316|1504->345|1534->353|2131->915|2183->951|2222->952|2268->962|2314->999|2362->1009|2411->1022|2750->1352|2796->1360|2846->1375|2866->1386|2906->1388|2964->1410|2983->1420|3030->1445|3075->1454|3094->1464|3141->1488|3204->1515|3220->1522|3319->1598|3384->1627|3400->1634|3495->1706|3560->1735|3576->1742|3672->1815|3737->1844|3753->1851|3848->1923|3913->1952|3929->1959|4028->2035|4097->2072|4157->2100|4201->2112|4245->2124|4724->2568|4776->2604|4815->2605|4864->2618|4910->2655|4958->2665|5007->2678|5346->3008|5392->3016|5442->3031|5462->3042|5502->3044|5560->3066|5579->3076|5626->3101|5671->3110|5690->3120|5737->3144|5802->3173|5818->3180|5917->3256|5982->3285|5998->3292|6093->3364|6158->3393|6174->3400|6270->3473|6335->3502|6351->3509|6446->3581|6511->3610|6527->3617|6626->3693|6681->3716|6755->3758|6799->3770|6843->3782|7324->4228|7376->4264|7415->4265|7463->4276|7510->4313|7559->4323|7609->4336|7949->4666|7996->4674|8047->4689|8068->4700|8109->4702|8168->4724|8188->4734|8236->4759|8282->4768|8302->4778|8350->4802|8414->4829|8431->4836|8531->4912|8597->4941|8614->4948|8710->5020|8776->5049|8793->5056|8890->5129|8956->5158|8973->5165|9069->5237|9135->5266|9152->5273|9252->5349|9308->5372|9383->5414|9428->5426|9473->5438|9877->5805|9924->5842|9973->5852|10023->5865|10313->6145|10360->6153|10411->6168|10432->6179|10473->6181|10558->6229|10575->6236|10679->6316|10745->6345|10762->6352|10862->6428|10928->6457|10945->6464|11046->6541|11112->6570|11129->6577|11229->6653|11314->6705|11376->6734|11421->6746|11908->7196|11955->7233|12004->7243|12054->7256|12438->7630|12485->7638|12536->7653|12557->7664|12598->7666|12692->7723|12709->7730|12819->7816|12885->7845|12902->7852|13008->7934|13074->7963|13091->7970|13198->8053|13264->8082|13281->8089|13387->8171|13453->8200|13470->8207|13580->8293|13648->8328|13710->8357|13755->8369
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|34->5|34->5|34->5|34->5|34->5|55->26|55->26|55->26|56->27|56->27|56->27|57->28|62->33|62->33|64->35|64->35|64->35|65->36|65->36|65->36|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|72->43|74->45|75->46|76->47|92->63|92->63|92->63|93->64|93->64|93->64|94->65|99->70|99->70|101->72|101->72|101->72|102->73|102->73|102->73|102->73|102->73|102->73|103->74|103->74|103->74|104->75|104->75|104->75|105->76|105->76|105->76|106->77|106->77|106->77|107->78|107->78|107->78|108->79|111->82|112->83|113->84|128->99|128->99|128->99|129->100|129->100|129->100|130->101|135->106|135->106|137->108|137->108|137->108|138->109|138->109|138->109|138->109|138->109|138->109|139->110|139->110|139->110|140->111|140->111|140->111|141->112|141->112|141->112|142->113|142->113|142->113|143->114|143->114|143->114|144->115|147->118|148->119|149->120|166->137|166->137|166->137|167->138|171->142|171->142|173->144|173->144|173->144|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|178->149|178->149|178->149|181->152|183->154|184->155|202->173|202->173|202->173|203->174|208->179|208->179|210->181|210->181|210->181|215->186|215->186|215->186|216->187|216->187|216->187|217->188|217->188|217->188|218->189|218->189|218->189|219->190|219->190|219->190|221->192|223->194|224->195
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            