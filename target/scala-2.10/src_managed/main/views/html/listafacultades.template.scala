
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
object listafacultades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Facultad],Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(facultades:List[Facultad], conScript:Integer=0):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.50*/("""

<select name='documento' id='listaProgramas' style='width:100%;max-width:99%;'>
<option value=-1>- Seleccione una Facultad</option>
"""),_display_(Seq[Any](/*5.2*/for(facultad <- facultades) yield /*5.29*/{_display_(Seq[Any](format.raw/*5.30*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/facultad/*6.25*/.getCodFacultad())),format.raw/*6.42*/("""'>"""),_display_(Seq[Any](/*6.45*/facultad/*6.53*/.getNombre())),format.raw/*6.65*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
"""))}
    }
    
    def render(facultades:List[Facultad],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(facultades,conScript)
    
    def f:((List[Facultad],Integer) => play.api.templates.HtmlFormat.Appendable) = (facultades,conScript) => apply(facultades,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 28 11:16:07 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listafacultades.scala.html
                    HASH: 4c5413b5082b8b7e430a1ce45f2e61c424702c81
                    MATRIX: 800->1|942->49|1111->184|1153->211|1191->212|1243->229|1259->237|1297->254|1335->257|1351->265|1384->277|1425->288
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            