
package views.html.informes

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
object informedocencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[EvaluacionMateria],List[Profesor],List[String],List[Programa],List[Facultad],List[Area],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], profesores:List[Profesor],semestres:List[String],programas:List[Programa]=Nil, facultades:List[Facultad]=Nil,areas:List[Area]=Nil):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta


Seq[Any](format.raw/*1.176*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main("informes")/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""

	<div id="informe">
	
	</div>
	"""),_display_(Seq[Any](/*10.3*/sidebar(profesores,semestres,programas,facultades,areas))),format.raw/*10.59*/("""
	
""")))})),format.raw/*12.2*/("""
"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],profesores:List[Profesor],semestres:List[String],programas:List[Programa],facultades:List[Facultad],areas:List[Area]): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,profesores,semestres,programas,facultades,areas)
    
    def f:((List[EvaluacionMateria],List[Profesor],List[String],List[Programa],List[Facultad],List[Area]) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,profesores,semestres,programas,facultades,areas) => apply(evaluacionMateria,profesores,semestres,programas,facultades,areas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 09 15:03:38 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informedocencia.scala.html
                    HASH: 259f97090584894373e2591b2214b908d7a2d925
                    MATRIX: 879->1|1171->175|1198->200|1235->203|1259->219|1297->220|1366->254|1444->310|1479->314
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|38->10|38->10|40->12
                    -- GENERATED --
                */
            