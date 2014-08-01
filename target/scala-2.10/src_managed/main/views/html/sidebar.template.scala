
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
object sidebar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Profesor],List[String],List[Programa],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], semestres:List[String], programas:List[Programa]=Nil):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.83*/("""
      <div id="sidebar">
          <h3> Menú</h3>
          <p>Semestre: """),_display_(Seq[Any](/*4.25*/listasemestres(semestres))),format.raw/*4.50*/("""</p>
          <p>"""),_display_(Seq[Any](/*5.15*/listainformes())),format.raw/*5.30*/("""</p>
          """),_display_(Seq[Any](/*6.12*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*6.92*/{_display_(Seq[Any](format.raw/*6.93*/("""
            """),_display_(Seq[Any](/*7.14*/if(session.get("rol")==Rol.COORDINADOR)/*7.53*/ {_display_(Seq[Any](format.raw/*7.55*/("""
            <p>"""),_display_(Seq[Any](/*8.17*/listaprogramas(programas,1))),format.raw/*8.44*/("""</p>
            """)))})),format.raw/*9.14*/("""
          <p>"""),_display_(Seq[Any](/*10.15*/lista(profesores,1))),format.raw/*10.34*/("""</p>
          """)))}/*11.12*/else/*11.16*/{_display_(Seq[Any](format.raw/*11.17*/("""
          <script>
          $(
			function()
			"""),format.raw/*15.4*/("""{"""),format.raw/*15.5*/("""
			$('#listainformes').on("change", cambioInforme);
			"""),format.raw/*17.4*/("""}"""),format.raw/*17.5*/("""
			);
          function cambioInforme()
			"""),format.raw/*20.4*/("""{"""),format.raw/*20.5*/("""
			
			cambioSemestre();

			"""),format.raw/*24.4*/("""}"""),format.raw/*24.5*/("""
		  </script>
          """)))})),format.raw/*26.12*/("""
          
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
    
    def render(profesores:List[Profesor],semestres:List[String],programas:List[Programa]): play.api.templates.HtmlFormat.Appendable = apply(profesores,semestres,programas)
    
    def f:((List[Profesor],List[String],List[Programa]) => play.api.templates.HtmlFormat.Appendable) = (profesores,semestres,programas) => apply(profesores,semestres,programas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:38 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 47907d986dc60b073151467b6ff65eb23415ffb0
                    MATRIX: 797->1|942->52|1052->127|1098->152|1152->171|1188->186|1239->202|1327->282|1365->283|1415->298|1455->317|1502->333
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8
=======
                    DATE: Tue Jul 01 10:58:25 COT 2014
=======
                    DATE: Fri Jul 04 16:10:06 COT 2014
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 76440ad5df9b696af33ea0b912616d2c1a665298
                    MATRIX: 797->1|942->52|1052->127|1098->152|1152->171|1188->186|1239->202|1327->282|1365->283|1415->298|1455->317|1489->333|1501->337|1539->338|1616->388|1644->389|1727->445|1755->446|1827->491|1855->492|1912->522|1940->523|1998->549
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|36->8|36->8|40->12|40->12|42->14|42->14|45->17|45->17|49->21|49->21|51->23
>>>>>>> 93429d7fbc474b9d33705b1aa2e201ce50fe2153
=======
                    DATE: Sun Jul 27 17:00:39 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 20479e3dfcbd9d06f18e5e8224f7e9674543d618
                    MATRIX: 812->1|987->82|1097->157|1143->182|1197->201|1233->216|1284->232|1372->312|1410->313|1459->327|1506->366|1545->368|1597->385|1645->412|1694->430|1745->445|1786->464|1821->480|1834->484|1873->485|1950->535|1978->536|2061->592|2089->593|2161->638|2189->639|2246->669|2274->670|2332->696
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|38->10|38->10|39->11|39->11|39->11|43->15|43->15|45->17|45->17|48->20|48->20|52->24|52->24|54->26
>>>>>>> 83ea5cc9add5bfe76dd8df164a8931789e2d0402
                    -- GENERATED --
                */
            