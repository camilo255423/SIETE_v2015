
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
	    <link href="""),_display_(Seq[Any](/*8.18*/routes/*8.24*/.Assets.at("css/style.css"))),format.raw/*8.51*/(""" type="text/css" rel="stylesheet"></link>
		<link href="""),_display_(Seq[Any](/*9.15*/routes/*9.21*/.Assets.at("css/custom-theme/jquery-ui-1.10.3.custom.css"))),format.raw/*9.79*/("""  type="text/css"  rel="stylesheet"></link>
		<script src="""),_display_(Seq[Any](/*10.16*/routes/*10.22*/.Assets.at("js/jquery-1.9.1.js"))),format.raw/*10.54*/(""" type="text/javascript"></script>
		<script src="""),_display_(Seq[Any](/*11.16*/routes/*11.22*/.Assets.at("js/jquery-ui-1.10.3.custom.js"))),format.raw/*11.65*/(""" type="text/javascript"></script>
		
    </head>
    <body>
    <div id="topLine">
      <div id="header">
      <div id="linea"></div>
    	"""),_display_(Seq[Any](/*18.7*/mainmenu())),format.raw/*18.17*/("""
    
        <h1><span><img src="""),_display_(Seq[Any](/*20.29*/routes/*20.35*/.Assets.at("images/logo-inpahu.png"))),format.raw/*20.71*/(""" alt="Logo" title="Logo" /></span></h1>
      </div>
    </div>

  <div id="outerwrapper">
       <div id="wrapper">
       <div id="content">
       """),_display_(Seq[Any](/*27.9*/content)),format.raw/*27.16*/("""
       </div>
       </div>
  </div>     
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 27 21:27:42 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/main.scala.html
                    HASH: 5512e434a0a42c547ad6e7d9c0a6e9ecb0f08813
                    MATRIX: 778->1|902->31|990->84|1016->89|1077->115|1091->121|1139->148|1230->204|1244->210|1323->268|1418->327|1433->333|1487->365|1572->414|1587->420|1652->463|1829->605|1861->615|1931->649|1946->655|2004->691|2190->842|2219->849
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|46->18|46->18|48->20|48->20|48->20|55->27|55->27
                    -- GENERATED --
                */
            