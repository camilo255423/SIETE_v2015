
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
object informedocencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[EvaluacionMateria],List[Profesor],List[String],List[Programa],List[Facultad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], profesores:List[Profesor],semestres:List[String],programas:List[Programa]=Nil, facultades:List[Facultad]=Nil):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Pregunta


Seq[Any](format.raw/*1.155*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main("informes")/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""

	<div id="informe">
	
	</div>
	"""),_display_(Seq[Any](/*10.3*/sidebar(profesores,semestres,programas,facultades))),format.raw/*10.53*/("""
	
""")))})),format.raw/*12.2*/("""
"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],profesores:List[Profesor],semestres:List[String],programas:List[Programa],facultades:List[Facultad]): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,profesores,semestres,programas,facultades)
    
    def f:((List[EvaluacionMateria],List[Profesor],List[String],List[Programa],List[Facultad]) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,profesores,semestres,programas,facultades) => apply(evaluacionMateria,profesores,semestres,programas,facultades)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 28 10:51:20 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/informes/informedocencia.scala.html
                    HASH: db815bd24449b3c429aa2d27e16579111a9f27a2
                    MATRIX: 868->1|1139->154|1166->179|1203->182|1227->198|1265->199|1334->233|1406->283|1441->287
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|38->10|38->10|40->12
                    -- GENERATED --
                */
            