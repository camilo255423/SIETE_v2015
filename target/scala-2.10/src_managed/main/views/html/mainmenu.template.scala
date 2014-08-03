
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
          <li><a href="""),_display_(Seq[Any](/*3.24*/routes/*3.30*/.Application.index())),format.raw/*3.50*/(""">Informes</a></li>
          """),_display_(Seq[Any](/*4.12*/if(session.get("rol")==Rol.ADMINISTRADOR)/*4.53*/{_display_(Seq[Any](format.raw/*4.54*/("""
          <li><a href="""),_display_(Seq[Any](/*5.24*/routes/*5.30*/.Admin.index())),format.raw/*5.44*/(""">Administración</a></li>
          """)))})),format.raw/*6.12*/("""
          <li class="active"><a href="""),_display_(Seq[Any](/*7.39*/routes/*7.45*/.Application.logout())),format.raw/*7.66*/(""">Log out</a></li>
    
        </ul>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 03 10:49:35 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/mainmenu.scala.html
                    HASH: 5b5e8ccc492bd345efc21b301c0b60a9ae1d78f0
                    MATRIX: 858->11|933->51|947->57|988->77|1053->107|1102->148|1140->149|1199->173|1213->179|1248->193|1315->229|1389->268|1403->274|1445->295
                    LINES: 29->2|30->3|30->3|30->3|31->4|31->4|31->4|32->5|32->5|32->5|33->6|34->7|34->7|34->7
                    -- GENERATED --
                */
            