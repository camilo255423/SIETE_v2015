
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
object sidebar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[List[Profesor],List[String],List[Programa],List[Facultad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], semestres:List[String], programas:List[Programa]=Nil,facultades:List[Facultad]=Nil):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.113*/("""
      <div id="sidebar">
          <h3> Menú </h3>
          <p>Semestre: """),_display_(Seq[Any](/*4.25*/listasemestres(semestres))),format.raw/*4.50*/("""</p>
          <p>"""),_display_(Seq[Any](/*5.15*/listainformes())),format.raw/*5.30*/("""</p>
          """),_display_(Seq[Any](/*6.12*/if(session.get("rol")!=Rol.PROFESOR)/*6.48*/{_display_(Seq[Any](format.raw/*6.49*/("""
            """),_display_(Seq[Any](/*7.14*/if(session.get("rol")==Rol.COORDINADOR)/*7.53*/ {_display_(Seq[Any](format.raw/*7.55*/("""
            <p>"""),_display_(Seq[Any](/*8.17*/listaprogramas(programas,1))),format.raw/*8.44*/("""</p>
            """)))})),format.raw/*9.14*/("""
            """),_display_(Seq[Any](/*10.14*/if(session.get("rol")==Rol.DECANO)/*10.48*/ {_display_(Seq[Any](format.raw/*10.50*/("""
            <p>"""),_display_(Seq[Any](/*11.17*/listafacultades(facultades,1))),format.raw/*11.46*/("""</p>
            """)))})),format.raw/*12.14*/("""
          <p>"""),_display_(Seq[Any](/*13.15*/lista(profesores,1))),format.raw/*13.34*/("""</p>
          """)))}/*14.12*/else/*14.16*/{_display_(Seq[Any](format.raw/*14.17*/("""
          <script>
          $(
			function()
			"""),format.raw/*18.4*/("""{"""),format.raw/*18.5*/("""
			$('#listainformes').on("change", cambioInforme);
			"""),format.raw/*20.4*/("""}"""),format.raw/*20.5*/("""
			);
          function cambioInforme()
			"""),format.raw/*23.4*/("""{"""),format.raw/*23.5*/("""
			
			cambioSemestre();

			"""),format.raw/*27.4*/("""}"""),format.raw/*27.5*/("""
		  </script>
          """)))})),format.raw/*29.12*/("""
          
          <div id='descargas'>
          
          </div>
  
      </div>"""))}
    }
    
    def render(profesores:List[Profesor],semestres:List[String],programas:List[Programa],facultades:List[Facultad]): play.api.templates.HtmlFormat.Appendable = apply(profesores,semestres,programas,facultades)
    
    def f:((List[Profesor],List[String],List[Programa],List[Facultad]) => play.api.templates.HtmlFormat.Appendable) = (profesores,semestres,programas,facultades) => apply(profesores,semestres,programas,facultades)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 28 11:13:02 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/sidebar.scala.html
                    HASH: 7228dfa34561c437c6009a43b62308ff1c51529f
                    MATRIX: 827->1|1033->112|1144->188|1190->213|1244->232|1280->247|1331->263|1375->299|1413->300|1462->314|1509->353|1548->355|1600->372|1648->399|1697->417|1747->431|1790->465|1830->467|1883->484|1934->513|1984->531|2035->546|2076->565|2111->581|2124->585|2163->586|2240->636|2268->637|2351->693|2379->694|2451->739|2479->740|2536->770|2564->771|2622->797
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|38->10|38->10|38->10|39->11|39->11|40->12|41->13|41->13|42->14|42->14|42->14|46->18|46->18|48->20|48->20|51->23|51->23|55->27|55->27|57->29
                    -- GENERATED --
                */
            