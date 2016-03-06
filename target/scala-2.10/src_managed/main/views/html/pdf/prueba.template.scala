
package views.html.pdf

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
object prueba extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(imagen:String,imagen2:String,imagen3:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*4.1*/("""<div id="informe">
<div class="tabs">
	"""),_display_(Seq[Any](/*6.3*/imagen)),format.raw/*6.9*/("""
<img width='219' height='63' src='"""),_display_(Seq[Any](/*7.36*/imagen)),format.raw/*7.42*/("""' alt='Logo title='Logo'  align='left' hspace='12'></img>
<img width='219' height='63' src='"""),_display_(Seq[Any](/*8.36*/imagen2)),format.raw/*8.43*/("""' alt='Logo title='Logo'  align='left' hspace='12'></img>
<img width='219' height='63' src='"""),_display_(Seq[Any](/*9.36*/imagen3)),format.raw/*9.43*/("""' alt='Logo title='Logo'  align='left' hspace='12'></img>
 	<div id="tabs-docencia">       
	
	<div class="titulotabla"></div>
	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*16.56*/imagen)),format.raw/*16.62*/("""' alt='Logo title='Logo'  align='left' hspace='12'></img></td>
  	</tr>
  	
	</table>	
  </div> <!--  docencia -->
</div> <!-- tabs docencia-gestión-invest --> 
</div>  <!-- div informe -->
"""))}
    }
    
    def render(imagen:String,imagen2:String,imagen3:String): play.api.templates.HtmlFormat.Appendable = apply(imagen,imagen2,imagen3)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (imagen,imagen2,imagen3) => apply(imagen,imagen2,imagen3)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 06 11:27:30 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/prueba.scala.html
                    HASH: 7f7ea7f8e56d46bc8a6a66b75ddb431dddc6df4c
                    MATRIX: 793->1|984->46|1011->100|1085->140|1111->146|1182->182|1209->188|1337->281|1365->288|1493->381|1521->388|1825->656|1853->662
                    LINES: 26->1|32->1|33->4|35->6|35->6|36->7|36->7|37->8|37->8|38->9|38->9|45->16|45->16
                    -- GENERATED --
                */
            