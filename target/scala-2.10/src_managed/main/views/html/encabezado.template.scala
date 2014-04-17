
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
object encabezado extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
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
         """),_display_(Seq[Any](/*15.11*/content)),format.raw/*15.18*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/encabezado.scala.html
                    HASH: b5e6818846ae3846cf6fe371ce98eaf6195eb300
                    MATRIX: 733->1|840->31|928->84|954->89|1015->115|1029->121|1077->148|1168->204|1182->210|1261->268|1356->327|1371->333|1425->365|1510->414|1525->420|1590->463|1696->533|1725->540
=======
                    DATE: Fri Apr 04 16:48:45 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/encabezado.scala.html
                    HASH: f280299c038587c970c642650832a87b5b656b84
                    MATRIX: 784->1|908->31|996->84|1022->89|1083->115|1097->121|1145->148|1236->204|1250->210|1329->268|1424->327|1439->333|1493->365|1578->414|1593->420|1658->463|1764->533|1793->540
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15
                    -- GENERATED --
                */
            