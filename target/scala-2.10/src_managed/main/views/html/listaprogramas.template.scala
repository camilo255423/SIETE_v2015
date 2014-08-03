
package views.html

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
object listaprogramas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Programa],Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(programas:List[Programa], conScript:Integer=0):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.49*/("""

<select name='documento' id='listaProgramas' style="width:100%;max-width:99%;">
<option value=-1>- Seleccione un Programa</option>
"""),_display_(Seq[Any](/*5.2*/for(programa <- programas) yield /*5.28*/{_display_(Seq[Any](format.raw/*5.29*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/programa/*6.25*/.getCodPrograma())),format.raw/*6.42*/("""'>"""),_display_(Seq[Any](/*6.45*/programa/*6.53*/.getCodPrograma())),format.raw/*6.70*/(""" """),_display_(Seq[Any](/*6.72*/programa/*6.80*/.getNombre())),format.raw/*6.92*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
"""))}
    }
    
    def render(programas:List[Programa],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(programas,conScript)
    
    def f:((List[Programa],Integer) => play.api.templates.HtmlFormat.Appendable) = (programas,conScript) => apply(programas,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 03 10:49:35 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/listaprogramas.scala.html
                    HASH: 085380d0f0eae67780ec0a9f7eff55afcbce4222
                    MATRIX: 799->1|940->48|1108->182|1149->208|1187->209|1239->226|1255->234|1293->251|1331->254|1347->262|1385->279|1422->281|1438->289|1471->301|1512->312
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            