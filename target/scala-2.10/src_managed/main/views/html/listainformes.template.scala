
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

Seq[Any](format.raw/*1.1*/("""<select id='listainformes'>
<option value='1'>Informe 1 - Detallado</option>
<option value='2'>Informe 2 - Heteroevaluación</option>
<option value='3'>Informe 3 - Final</option>
<option value='4'>Informe 4 - por Facultad</option>
<option value='5'>Informe 5 - por Programa</option>
<option value='6'>Informe 6 - Participantes</option>
</select>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 08:45:15 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listainformes.scala.html
                    HASH: 1855e0a839e399094487d5e6400589d8ec0fa8e7
                    MATRIX: 795->0
                    LINES: 29->1
                    -- GENERATED --
                */
            