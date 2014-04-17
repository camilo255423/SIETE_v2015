
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

Seq[Any](format.raw/*2.6*/("""<ul class="nav">
    	
          <li><a href="/">Informes</a></li>
          """),_display_(Seq[Any](/*5.12*/if(session.get("rol")==Rol.ADMINISTRADOR)/*5.53*/{_display_(Seq[Any](format.raw/*5.54*/("""
          <li><a href="/admin">Administración</a></li>
          """)))})),format.raw/*7.12*/("""
          <li class="active"><a href="/logout">Log out</a></li>
   
        </ul>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:01 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/mainmenu.scala.html
                    HASH: 3a791f233a9ebcdbce3fcbf568c402eb2f58b2a1
                    MATRIX: 790->9
                    LINES: 29->2
=======
                    DATE: Fri Apr 04 16:48:44 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/mainmenu.scala.html
                    HASH: 090e7f79e45ea4b99d885ccd987a2c473a53ce9d
                    MATRIX: 858->10|971->88|1020->129|1058->130|1156->197
                    LINES: 29->2|32->5|32->5|32->5|34->7
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            