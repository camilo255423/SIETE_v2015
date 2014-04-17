
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
object informedocencia extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[EvaluacionMateria],List[Profesor],List[String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], profesores:List[Profesor],semestres:List[String]):play.api.templates.Html = {
        _display_ {import models.Pregunta


Seq[Any](format.raw/*1.95*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main("informes")/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""

	<div id="informe">
	
	</div>
	"""),_display_(Seq[Any](/*10.3*/sidebar(profesores,semestres))),format.raw/*10.32*/("""
	
""")))})),format.raw/*12.2*/("""
"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],profesores:List[Profesor],semestres:List[String]): play.api.templates.Html = apply(evaluacionMateria,profesores,semestres)
    
    def f:((List[EvaluacionMateria],List[Profesor],List[String]) => play.api.templates.Html) = (evaluacionMateria,profesores,semestres) => apply(evaluacionMateria,profesores,semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:05 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/informes/informedocencia.scala.html
                    HASH: 1d216360ad85296d982d16eb9355c1bf1ad982cc
                    MATRIX: 787->1|980->94|1007->119|1044->122|1068->138|1106->139|1175->173|1226->202|1261->206
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|38->10|38->10|40->12
                    -- GENERATED --
                */
            