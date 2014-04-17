
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
object listainformes extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<select id='listainformes'>
<option value='1'>Informe 1 - Detallado</option>
"""),_display_(Seq[Any](/*4.2*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*4.82*/{_display_(Seq[Any](format.raw/*4.83*/("""
<option value='2'>Informe 2 - Heteroevaluación</option>
<option value='3'>Informe 3 - Final</option>
""")))})),format.raw/*7.2*/("""
"""),_display_(Seq[Any](/*8.2*/if(session.get("rol")==Rol.ADMINISTRADOR)/*8.43*/{_display_(Seq[Any](format.raw/*8.44*/("""
<option value='4'>Informe 4 - por Facultad</option>
<option value='5'>Informe 5 - por Programa</option>
<option value='6'>Informe 6 - Participantes</option>
""")))})),format.raw/*12.2*/("""
</select>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listainformes.scala.html
                    HASH: 05720ba8b8321a13b3f5e0cb7594542acc02c5b9
                    MATRIX: 795->1|907->79|995->159|1033->160|1166->263|1202->265|1251->306|1289->307|1479->466
                    LINES: 29->2|31->4|31->4|31->4|34->7|35->8|35->8|35->8|39->12
                    -- GENERATED --
                */
            