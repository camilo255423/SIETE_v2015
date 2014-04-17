
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/encabezado("Informes")/*3.24*/{_display_(Seq[Any](format.raw/*3.25*/("""
    <div id="topLine">
      <div id="header">
      <div id="linea"></div>
    	"""),_display_(Seq[Any](/*7.7*/mainmenu())),format.raw/*7.17*/("""
    
        <h1><span><img src="""),_display_(Seq[Any](/*9.29*/routes/*9.35*/.Assets.at("images/logo-inpahu.png"))),format.raw/*9.71*/(""" alt="Logo" title="Logo" /></span></h1>
      </div>
    </div>

  <div id="outerwrapper">
       <div id="wrapper">
       <div id="content">
       """),_display_(Seq[Any](/*16.9*/content)),format.raw/*16.16*/("""
       </div>
       </div>
  </div>     
""")))})),format.raw/*20.2*/("""    
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:01 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/main.scala.html
                    HASH: fbfec3cbb45834d90ae5726fe4524a870ef436bc
                    MATRIX: 727->1|834->31|871->34|901->56|939->57|1056->140|1087->150|1156->184|1170->190|1227->226|1413->377|1442->384|1517->428
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|37->9|37->9|37->9|44->16|44->16|48->20
                    -- GENERATED --
                */
            