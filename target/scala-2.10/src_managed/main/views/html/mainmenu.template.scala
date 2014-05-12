
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
    	
          <li><a href="""),_display_(Seq[Any](/*4.24*/routes/*4.30*/.Application.index())),format.raw/*4.50*/(""">Informes</a></li>
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
                    DATE: Fri Apr 25 15:13:55 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/mainmenu.scala.html
                    HASH: 4de22c0f493627600efc71ecc94bbbe395adb79a
                    MATRIX: 858->10|939->56|953->62|994->82|1059->112|1108->153|1146->154|1205->178|1219->184|1254->198|1321->234|1395->273|1409->279|1451->300
                    LINES: 29->2|31->4|31->4|31->4|32->5|32->5|32->5|33->6|33->6|33->6|34->7|35->8|35->8|35->8
                    -- GENERATED --
                */
            