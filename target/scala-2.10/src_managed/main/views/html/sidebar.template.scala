
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
object sidebar extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Profesor],List[String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], semestres:List[String]):play.api.templates.Html = {
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
    
    def render(profesores:List[Profesor],semestres:List[String]): play.api.templates.Html = apply(profesores,semestres)
    
    def f:((List[Profesor],List[String]) => play.api.templates.Html) = (profesores,semestres) => apply(profesores,semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 4e35a227d434128f3d079fad663451de48297dbe
                    MATRIX: 746->1|874->52|984->127|1030->152|1084->171|1120->186|1171->202|1259->282|1297->283|1347->298|1387->317|1434->333|1481->345|1569->425|1607->426|1710->497
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|37->9|37->9|37->9|41->13
                    -- GENERATED --
                */
            