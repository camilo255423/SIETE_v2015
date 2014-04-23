
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
object mainmenu extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.6*/("""<ul class="nav">
    	
          <li><a href="/">Informes</a></li>
          """),_display_(Seq[Any](/*5.12*/if(session.get("rol")==Rol.ADMINISTRADOR)/*5.53*/{_display_(Seq[Any](format.raw/*5.54*/("""
          <li><a href="""),_display_(Seq[Any](/*6.24*/routes/*6.30*/.Admin.index())),format.raw/*6.44*/(""">Administración</a></li>
          """)))})),format.raw/*7.12*/("""
          <li class="active"><a href="""),_display_(Seq[Any](/*8.39*/routes/*8.45*/.Application.logout())),format.raw/*8.66*/(""">Log out</a></li>
   
        </ul>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 23 15:42:35 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/mainmenu.scala.html
                    HASH: ea846162b668a6ac74785de805f1b96d855d92a1
                    MATRIX: 858->10|971->88|1020->129|1058->130|1117->154|1131->160|1166->174|1233->210|1307->249|1321->255|1363->276
                    LINES: 29->2|32->5|32->5|32->5|33->6|33->6|33->6|34->7|35->8|35->8|35->8
                    -- GENERATED --
                */
            