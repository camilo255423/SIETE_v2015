
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
<<<<<<< HEAD
                    DATE: Fri Mar 28 10:07:47 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listainformes.scala.html
                    HASH: 1855e0a839e399094487d5e6400589d8ec0fa8e7
                    MATRIX: 795->0
                    LINES: 29->1
=======
                    DATE: Sun Mar 30 09:29:22 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listainformes.scala.html
                    HASH: 49b3e642072fc08840c4f9e54c2ce71bbc152718
                    MATRIX: 863->1|975->79|1063->159|1101->160|1234->263|1270->265|1319->306|1357->307|1547->466
                    LINES: 29->2|31->4|31->4|31->4|34->7|35->8|35->8|35->8|39->12
>>>>>>> cb77d0927cd8f261a2ae957c054b26b84cb8d3a1
                    -- GENERATED --
                */
            