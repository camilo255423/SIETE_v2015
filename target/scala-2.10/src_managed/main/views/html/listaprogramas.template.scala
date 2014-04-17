
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
object listaprogramas extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Programa],Integer,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(programas:List[Programa], conScript:Integer=0):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.49*/("""

<select name='documento' id='listaProfesores' style="width:100%;max-width:99%;">
<option value=-1>- Seleccione un Programa</option>
"""),_display_(Seq[Any](/*5.2*/for(programa <- programas) yield /*5.28*/{_display_(Seq[Any](format.raw/*5.29*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/programa/*6.25*/.getCodPrograma())),format.raw/*6.42*/("""'>"""),_display_(Seq[Any](/*6.45*/programa/*6.53*/.getCodPrograma())),format.raw/*6.70*/(""" """),_display_(Seq[Any](/*6.72*/programa/*6.80*/.getNombre())),format.raw/*6.92*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
"""))}
    }
    
    def render(programas:List[Programa],conScript:Integer): play.api.templates.Html = apply(programas,conScript)
    
    def f:((List[Programa],Integer) => play.api.templates.Html) = (programas,conScript) => apply(programas,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:01 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listaprogramas.scala.html
                    HASH: 1a6e1603955d84c95a154d284c417abb891cdb17
                    MATRIX: 748->1|872->48|1041->183|1082->209|1120->210|1172->227|1188->235|1226->252|1264->255|1280->263|1318->280|1355->282|1371->290|1404->302|1445->313
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            