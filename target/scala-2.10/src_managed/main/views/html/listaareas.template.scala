
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
object listaareas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Area],Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(areas:List[Area], conScript:Integer=0):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""

<select name='documento' id='listaProgramas' style="width:100%;max-width:99%;">
<option value=-1>- Seleccione un Área</option>
"""),_display_(Seq[Any](/*5.2*/for(area <- areas) yield /*5.20*/{_display_(Seq[Any](format.raw/*5.21*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/area/*6.21*/.getCodArea())),format.raw/*6.34*/("""'>"""),_display_(Seq[Any](/*6.37*/area/*6.41*/.getCodArea())),format.raw/*6.54*/(""" """),_display_(Seq[Any](/*6.56*/area/*6.60*/.getNombre())),format.raw/*6.72*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
"""))}
    }
    
    def render(areas:List[Area],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(areas,conScript)
    
    def f:((List[Area],Integer) => play.api.templates.HtmlFormat.Appendable) = (areas,conScript) => apply(areas,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 09 12:16:51 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listaareas.scala.html
                    HASH: 267457047ebf0c08124f66f491bdfdb812a887d7
                    MATRIX: 791->1|924->40|1088->170|1121->188|1159->189|1211->206|1223->210|1257->223|1295->226|1307->230|1341->243|1378->245|1390->249|1423->261|1464->272
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            