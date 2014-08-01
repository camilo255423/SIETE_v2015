
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
object listaprogramas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Programa],Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(programas:List[Programa], conScript:Integer=0):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.49*/("""

<select name='documento' id='listaProgramas' style="width:100%;max-width:99%;">
<option value=-1>- Seleccione un Programa</option>
"""),_display_(Seq[Any](/*5.2*/for(programa <- programas) yield /*5.28*/{_display_(Seq[Any](format.raw/*5.29*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/programa/*6.25*/.getCodPrograma())),format.raw/*6.42*/("""'>"""),_display_(Seq[Any](/*6.45*/programa/*6.53*/.getCodPrograma())),format.raw/*6.70*/(""" """),_display_(Seq[Any](/*6.72*/programa/*6.80*/.getNombre())),format.raw/*6.92*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
"""))}
    }
    
    def render(programas:List[Programa],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(programas,conScript)
    
    def f:((List[Programa],Integer) => play.api.templates.HtmlFormat.Appendable) = (programas,conScript) => apply(programas,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:37 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listaprogramas.scala.html
=======
                    DATE: Fri Jul 04 16:10:05 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listaprogramas.scala.html
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    HASH: 7dae5c4e0844dc8012a230630fc49460101dbdd2
                    MATRIX: 799->1|940->48|1109->183|1150->209|1188->210|1240->227|1256->235|1294->252|1332->255|1348->263|1386->280|1423->282|1439->290|1472->302|1513->313
=======
                    DATE: Sun Jul 27 17:20:16 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listaprogramas.scala.html
                    HASH: 085380d0f0eae67780ec0a9f7eff55afcbce4222
                    MATRIX: 799->1|940->48|1108->182|1149->208|1187->209|1239->226|1255->234|1293->251|1331->254|1347->262|1385->279|1422->281|1438->289|1471->301|1512->312
>>>>>>> 83ea5cc9add5bfe76dd8df164a8931789e2d0402
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7
                    -- GENERATED --
                */
            