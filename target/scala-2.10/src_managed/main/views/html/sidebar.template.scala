
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
          <p>"""),_display_(Seq[Any](/*6.15*/lista(profesores,1))),format.raw/*6.34*/("""</p>
          <div id='descargas'>
          
          </div>
       
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
                    DATE: Fri Mar 28 08:45:15 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 7d0745b38fbc1c6d50c5182f362181c83acab7c6
                    MATRIX: 746->1|874->52|984->127|1030->152|1084->171|1120->186|1174->205|1214->224
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6
                    -- GENERATED --
                */
            