
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
object sidebar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Profesor],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], semestres:List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.53*/("""
      <div id="sidebar">
          <h3> Menú</h3>
          <p>Semestre: """),_display_(Seq[Any](/*4.25*/listasemestres(semestres))),format.raw/*4.50*/("""</p>
          <p>"""),_display_(Seq[Any](/*5.15*/listainformes())),format.raw/*5.30*/("""</p>
          """),_display_(Seq[Any](/*6.12*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*6.92*/{_display_(Seq[Any](format.raw/*6.93*/("""
          <p>"""),_display_(Seq[Any](/*7.15*/lista(profesores,1))),format.raw/*7.34*/("""</p>
          """)))})),format.raw/*8.12*/("""
          """),_display_(Seq[Any](/*9.12*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*9.92*/{_display_(Seq[Any](format.raw/*9.93*/("""
          <div id='descargas'>
          
          </div>
       	  """)))})),format.raw/*13.12*/("""
  <!--        
	<div class="ui-widget">
	  <label for="tags">Tags: </label>
	  <input id="tags">
	</div>
 -->    
      </div>"""))}
    }
    
    def render(profesores:List[Profesor],semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(profesores,semestres)
    
    def f:((List[Profesor],List[String]) => play.api.templates.HtmlFormat.Appendable) = (profesores,semestres) => apply(profesores,semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 29 17:25:09 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 4819c51dd981e94c2d0787770621a66e6a38e735
                    MATRIX: 797->1|942->52|1052->127|1098->152|1152->171|1188->186|1239->202|1327->282|1365->283|1415->298|1455->317|1502->333|1549->345|1637->425|1675->426|1778->497
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|37->9|37->9|37->9|41->13
                    -- GENERATED --
                */
            