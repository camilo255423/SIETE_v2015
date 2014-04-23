
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

<select name='documento' id='listaProfesores' style="width:100%;max-width:99%;">
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
                    DATE: Thu Apr 17 11:31:03 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listafacultades.scala.html
                    HASH: c4dade4afbbffd5290a4ff60a772ad696ac1900d
                    MATRIX: 800->1|942->49|1112->185|1154->212|1192->213|1244->230|1260->238|1298->255|1336->258|1352->266|1385->278|1426->289
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            