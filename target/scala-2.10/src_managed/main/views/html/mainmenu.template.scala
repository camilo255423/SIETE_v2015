
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
object mainmenu extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.5*/("""<ul class="nav">
          <li><a href="">Home</a></li>
          <li class="active"><a href="/logout">Log out</a></li>
   
        </ul>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:01 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/mainmenu.scala.html
                    HASH: 3a791f233a9ebcdbce3fcbf568c402eb2f58b2a1
                    MATRIX: 790->9
                    LINES: 29->2
                    -- GENERATED --
                */
            