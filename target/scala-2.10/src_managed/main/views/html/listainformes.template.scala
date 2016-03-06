
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
object listainformes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<select id='listainformes'>
<option value='1'>Informe 1 - Detallado</option>
<option value='2'>Informe 2 - Heteroevaluación</option>
<option value='3'>Informe 3 - Final</option>

"""),_display_(Seq[Any](/*7.2*/if(session.get("rol")==Rol.ADMINISTRADOR)/*7.43*/{_display_(Seq[Any](format.raw/*7.44*/("""
<option value='4'>Informe 4 - por Facultad</option>
""")))})),format.raw/*9.2*/("""
"""),_display_(Seq[Any](/*10.2*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*10.82*/{_display_(Seq[Any](format.raw/*10.83*/("""
<option value='5'>Informe 5 - por Programa</option>
""")))})),format.raw/*12.2*/("""
"""),_display_(Seq[Any](/*13.2*/if(session.get("rol")==Rol.ADMINISTRADOR)/*13.43*/{_display_(Seq[Any](format.raw/*13.44*/("""
<option value='6'>Informe 6 - Participantes</option>
""")))})),format.raw/*15.2*/("""
</select>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 06 11:27:27 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listainformes.scala.html
                    HASH: 0f3aab1f87ff6471e36e5d5dc46032402e94d03e
                    MATRIX: 863->1|1077->181|1126->222|1164->223|1248->277|1285->279|1374->359|1413->360|1498->414|1535->416|1585->457|1624->458|1710->513
                    LINES: 29->2|34->7|34->7|34->7|36->9|37->10|37->10|37->10|39->12|40->13|40->13|40->13|42->15
                    -- GENERATED --
                */
            