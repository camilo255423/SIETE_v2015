
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
	     <input class='cajalogin' name="email" placeholder="Usuario" value=""""),_display_(Seq[Any](/*22.75*/form("email")/*22.88*/.value)),format.raw/*22.94*/("""">
	   </p>
	   <p>
	     <input class='cajalogin' type="password" name="password" placeholder="Contraseña">
	   </p>
	   <p>
	      <button type="submit" id="botonlogin">Aceptar</button>
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
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:37 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/login.scala.html
=======
                    DATE: Fri Jul 04 16:10:05 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/login.scala.html
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    HASH: bda96f85354821ff50d77abc70d21395ef24c8d9
                    MATRIX: 791->1|916->32|952->34|987->61|1025->62|1173->175|1187->181|1244->217|1403->340|1418->346|1465->384|1505->386|1568->414|1601->438|1641->440|1713->476|1726->480|1768->500|1814->515|1933->598|1955->611|1983->617|2226->829|2285->857
                    LINES: 26->1|29->1|30->2|30->2|30->2|36->8|36->8|36->8|42->14|42->14|42->14|42->14|44->16|44->16|44->16|46->18|46->18|46->18|48->20|50->22|50->22|50->22|60->32|65->37
                    -- GENERATED --
                */
            