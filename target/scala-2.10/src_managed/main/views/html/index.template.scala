
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

    <p>"""),_display_(Seq[Any](/*5.9*/message)),format.raw/*5.16*/("""</p>

""")))})),format.raw/*7.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.Html = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/index.scala.html
                    HASH: a260f52f2583230aa4f2cca43f0eca83df3dabc0
                    MATRIX: 723->1|817->18|854->21|885->44|924->46|968->56|996->63|1033->70
=======
                    DATE: Fri Apr 04 16:48:45 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/index.scala.html
                    HASH: 55819fc74474f80196e3bcfc1db2d837a215d1a1
                    MATRIX: 774->1|885->18|922->21|953->44|992->46|1036->56|1064->63|1101->70
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|35->7
                    -- GENERATED --
                */
            