
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
object informedocencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[List[EvaluacionMateria],List[Profesor],List[String],List[Programa],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], profesores:List[Profesor],semestres:List[String],programas:List[Programa]=Nil):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta


Seq[Any](format.raw/*1.124*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main("informes")/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""

	<div id="informe">
	
	</div>
	"""),_display_(Seq[Any](/*10.3*/sidebar(profesores,semestres,programas))),format.raw/*10.42*/("""
	
""")))})),format.raw/*12.2*/("""
"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],profesores:List[Profesor],semestres:List[String],programas:List[Programa]): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,profesores,semestres,programas)
    
    def f:((List[EvaluacionMateria],List[Profesor],List[String],List[Programa]) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,profesores,semestres,programas) => apply(evaluacionMateria,profesores,semestres,programas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 06 11:27:31 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informedocencia.scala.html
                    HASH: 4839d8f48c1ec69d0cdc916afe590b7b5590419a
                    MATRIX: 853->1|1093->123|1120->148|1157->151|1181->167|1219->168|1288->202|1349->241|1384->245
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|38->10|38->10|40->12
                    -- GENERATED --
                */
            