
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[Application.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""
"""),_display_(Seq[Any](/*2.2*/encabezado("Autenticación")/*2.29*/{_display_(Seq[Any](format.raw/*2.30*/("""
 <div id="topLine">
      <div id="header">
      <div id="linea"></div>
    	
    
        <h1><span><img src="""),_display_(Seq[Any](/*8.29*/routes/*8.35*/.Assets.at("images/logo-inpahu.png"))),format.raw/*8.71*/(""" alt="Logo" title="Logo" /></span></h1>
      </div>
    </div>
      <div id="emptyouterwrapper">
       
       
        """),_display_(Seq[Any](/*14.10*/helper/*14.16*/.form(routes.Application.authenticate)/*14.54*/ {_display_(Seq[Any](format.raw/*14.56*/("""
	   <div id="login">
	   	"""),_display_(Seq[Any](/*16.7*/if(form.hasGlobalErrors)/*16.31*/ {_display_(Seq[Any](format.raw/*16.33*/("""
		    <p class="error">
		        """),_display_(Seq[Any](/*18.12*/form/*18.16*/.globalError.message)),format.raw/*18.36*/("""
		    </p>
		""")))})),format.raw/*20.4*/("""
	   <p>
	     <b> Correo: </b> <input name="email" placeholder="correo" value=""""),_display_(Seq[Any](/*22.73*/form("email")/*22.86*/.value)),format.raw/*22.92*/("""">
	   </p>
	   <p>
	      <b> Clave: </b> <input name="password" placeholder="clave">
	   </p>
	   <p>
	      <button type="submit">Aceptar</button>
	   </p>
		
		</div>
		""")))})),format.raw/*32.4*/("""

       </div>
   
		    
""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(form:Form[Application.Login]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[Application.Login]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 29 17:05:46 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/login.scala.html
                    HASH: 4312c39c0dd956e37a10f461cff73c789b9adcb8
                    MATRIX: 791->1|916->32|952->34|987->61|1025->62|1173->175|1187->181|1244->217|1404->341|1419->347|1466->385|1506->387|1569->415|1602->439|1642->441|1714->477|1727->481|1769->501|1815->516|1932->597|1954->610|1982->616|2187->790|2246->818
                    LINES: 26->1|29->1|30->2|30->2|30->2|36->8|36->8|36->8|42->14|42->14|42->14|42->14|44->16|44->16|44->16|46->18|46->18|46->18|48->20|50->22|50->22|50->22|60->32|65->37
                    -- GENERATED --
                */
            