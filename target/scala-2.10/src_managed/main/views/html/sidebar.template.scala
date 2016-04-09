
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
object sidebar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[Profesor],List[String],List[Programa],List[Facultad],List[Area],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], semestres:List[String], programas:List[Programa]=Nil,facultades:List[Facultad]=Nil,areas:List[Area]=Nil):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.134*/("""
      <div id="sidebar">
          <h3> Menú </h3>
          <p>Semestre: """),_display_(Seq[Any](/*4.25*/listasemestres(semestres))),format.raw/*4.50*/("""</p>
          <p>"""),_display_(Seq[Any](/*5.15*/listainformes())),format.raw/*5.30*/("""</p>
          """),_display_(Seq[Any](/*6.12*/if(session.get("rol")!=Rol.PROFESOR)/*6.48*/{_display_(Seq[Any](format.raw/*6.49*/("""
            """),_display_(Seq[Any](/*7.14*/if(session.get("rol")==Rol.COORDINADOR)/*7.53*/ {_display_(Seq[Any](format.raw/*7.55*/("""
            <p>"""),_display_(Seq[Any](/*8.17*/listaprogramas(programas,1))),format.raw/*8.44*/("""</p>
            """)))})),format.raw/*9.14*/("""
            """),_display_(Seq[Any](/*10.14*/if(session.get("rol")==Rol.DECANO || session.get("rol")==Rol.SECRETARIA_FACULTAD)/*10.95*/ {_display_(Seq[Any](format.raw/*10.97*/("""
            <p>"""),_display_(Seq[Any](/*11.17*/listafacultades(facultades,1))),format.raw/*11.46*/("""</p>
            """)))})),format.raw/*12.14*/("""
            """),_display_(Seq[Any](/*13.14*/if(session.get("rol")==Rol.COORDINADOR_DE_AREA)/*13.61*/ {_display_(Seq[Any](format.raw/*13.63*/("""
            <p>"""),_display_(Seq[Any](/*14.17*/listaareas(areas,1))),format.raw/*14.36*/("""</p>
            """)))})),format.raw/*15.14*/("""
          <p>"""),_display_(Seq[Any](/*16.15*/lista(profesores,1))),format.raw/*16.34*/("""</p>
          """)))}/*17.12*/else/*17.16*/{_display_(Seq[Any](format.raw/*17.17*/("""
          <script>
          $(
			function()
			"""),format.raw/*21.4*/("""{"""),format.raw/*21.5*/("""
			$('#listainformes').on("change", cambioInforme);
			"""),format.raw/*23.4*/("""}"""),format.raw/*23.5*/("""
			);
          function cambioInforme()
			"""),format.raw/*26.4*/("""{"""),format.raw/*26.5*/("""
			
			cambioSemestre();

			"""),format.raw/*30.4*/("""}"""),format.raw/*30.5*/("""
		  </script>
          """)))})),format.raw/*32.12*/("""
          
          <div id='descargas'>
          
          </div>
  
      </div>"""))}
    }
    
    def render(profesores:List[Profesor],semestres:List[String],programas:List[Programa],facultades:List[Facultad],areas:List[Area]): play.api.templates.HtmlFormat.Appendable = apply(profesores,semestres,programas,facultades,areas)
    
    def f:((List[Profesor],List[String],List[Programa],List[Facultad],List[Area]) => play.api.templates.HtmlFormat.Appendable) = (profesores,semestres,programas,facultades,areas) => apply(profesores,semestres,programas,facultades,areas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 09 14:50:32 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/sidebar.scala.html
                    HASH: f04e05856cb0b1aad92f8afd2609ada7c0c5dfb5
                    MATRIX: 838->1|1065->133|1176->209|1222->234|1276->253|1312->268|1363->284|1407->320|1445->321|1494->335|1541->374|1580->376|1632->393|1680->420|1729->438|1779->452|1869->533|1909->535|1962->552|2013->581|2063->599|2113->613|2169->660|2209->662|2262->679|2303->698|2353->716|2404->731|2445->750|2480->766|2493->770|2532->771|2609->821|2637->822|2720->878|2748->879|2820->924|2848->925|2905->955|2933->956|2991->982
                    LINES: 26->1|29->1|32->4|32->4|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|38->10|38->10|38->10|39->11|39->11|40->12|41->13|41->13|41->13|42->14|42->14|43->15|44->16|44->16|45->17|45->17|45->17|49->21|49->21|51->23|51->23|54->26|54->26|58->30|58->30|60->32
                    -- GENERATED --
                */
            