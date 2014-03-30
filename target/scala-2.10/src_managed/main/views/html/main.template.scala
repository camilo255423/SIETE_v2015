
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
<<<<<<< HEAD
                    DATE: Fri Mar 28 10:07:46 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/main.scala.html
                    HASH: 2f004ec23719528688515c7378beab953978d6b4
                    MATRIX: 727->1|834->31|922->84|948->89|1009->115|1023->121|1071->148|1162->204|1176->210|1255->268|1350->327|1365->333|1419->365|1504->414|1519->420|1584->463|1761->605|1793->615|1863->649|1878->655|1936->691|2122->842|2151->849
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|46->18|46->18|48->20|48->20|48->20|55->27|55->27
=======
                    DATE: Sat Mar 29 11:12:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/main.scala.html
                    HASH: 2023409a40a7eeae7953ee7a06c24fcfaecfe825
                    MATRIX: 778->1|902->31|939->34|969->56|1007->57|1124->140|1155->150|1224->184|1238->190|1295->226|1481->377|1510->384|1585->428
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|37->9|37->9|37->9|44->16|44->16|48->20
>>>>>>> cb77d0927cd8f261a2ae957c054b26b84cb8d3a1
                    -- GENERATED --
                */
            