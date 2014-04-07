
package views.html.pdf

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
object informedocencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[EvaluacionMateria],List[Profesor],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], profesores:List[Profesor],semestres:List[String]):play.api.templates.HtmlFormat.Appendable = {
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
    
    def render(evaluacionMateria:List[EvaluacionMateria],profesores:List[Profesor],semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,profesores,semestres)
    
    def f:((List[EvaluacionMateria],List[Profesor],List[String]) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,profesores,semestres) => apply(evaluacionMateria,profesores,semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 04 16:48:45 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informedocencia.scala.html
                    HASH: ceaae20854a50d4ce397ee02c1d2eff314c32fc7
                    MATRIX: 833->1|1043->94|1070->119|1107->122|1131->138|1169->139|1238->173|1289->202|1324->206
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|38->10|38->10|40->12
                    -- GENERATED --
                */
            