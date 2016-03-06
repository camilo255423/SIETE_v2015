
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
object error extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Throwable,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ex: Throwable, s:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""


    <p>"""),_display_(Seq[Any](/*4.9*/ex/*4.11*/.getMessage())),format.raw/*4.24*/("""</p>
	<p>trace</p>
<p>"""),_display_(Seq[Any](/*6.5*/s)),format.raw/*6.6*/("""</p>


"""))}
    }
    
    def render(ex:Throwable,s:String): play.api.templates.HtmlFormat.Appendable = apply(ex,s)
    
    def f:((Throwable,String) => play.api.templates.HtmlFormat.Appendable) = (ex,s) => apply(ex,s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 06 11:27:26 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/error.scala.html
                    HASH: ddc7876d73e4ade0854e4c39bbb5738558d7684d
                    MATRIX: 784->1|903->26|948->37|958->39|992->52|1049->75|1070->76
                    LINES: 26->1|29->1|32->4|32->4|32->4|34->6|34->6
                    -- GENERATED --
                */
            