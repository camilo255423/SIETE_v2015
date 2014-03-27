
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
object listafacultades extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Facultad],Integer,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(facultades:List[Facultad], conScript:Integer=0):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.50*/("""

<select name='documento' id='listaProfesores' style="width:100%;max-width:99%;">
<option value=-1>- Seleccione una Facultad</option>
"""),_display_(Seq[Any](/*5.2*/for(facultad <- facultades) yield /*5.29*/{_display_(Seq[Any](format.raw/*5.30*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/facultad/*6.25*/.getCodFacultad())),format.raw/*6.42*/("""'>"""),_display_(Seq[Any](/*6.45*/facultad/*6.53*/.getNombre())),format.raw/*6.65*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
"""))}
    }
    
    def render(facultades:List[Facultad],conScript:Integer): play.api.templates.Html = apply(facultades,conScript)
    
    def f:((List[Facultad],Integer) => play.api.templates.Html) = (facultades,conScript) => apply(facultades,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 24 19:20:25 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listafacultades.scala.html
                    HASH: 77167e2ff0641c1174128d2729733de87ad3a813
                    MATRIX: 749->1|874->49|1044->185|1086->212|1124->213|1176->230|1192->238|1230->255|1268->258|1284->266|1317->278|1358->289
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            