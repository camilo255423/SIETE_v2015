
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
          """)))}/*8.12*/else/*8.16*/{_display_(Seq[Any](format.raw/*8.17*/("""
          <script>
          $(
			function()
			"""),format.raw/*12.4*/("""{"""),format.raw/*12.5*/("""
			$('#listainformes').on("change", cambioInforme);
			"""),format.raw/*14.4*/("""}"""),format.raw/*14.5*/("""
			);
          function cambioInforme()
			"""),format.raw/*17.4*/("""{"""),format.raw/*17.5*/("""
			
			cambioSemestre();

			"""),format.raw/*21.4*/("""}"""),format.raw/*21.5*/("""
		  </script>
          """)))})),format.raw/*23.12*/("""
          
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
    
    def render(profesores:List[Profesor],semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(profesores,semestres)
    
    def f:((List[Profesor],List[String]) => play.api.templates.HtmlFormat.Appendable) = (profesores,semestres) => apply(profesores,semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 01 10:58:25 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 76440ad5df9b696af33ea0b912616d2c1a665298
                    MATRIX: 797->1|942->52|1052->127|1098->152|1152->171|1188->186|1239->202|1327->282|1365->283|1415->298|1455->317|1489->333|1501->337|1539->338|1616->388|1644->389|1727->445|1755->446|1827->491|1855->492|1912->522|1940->523|1998->549
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|36->8|36->8|40->12|40->12|42->14|42->14|45->17|45->17|49->21|49->21|51->23
                    -- GENERATED --
                */
            