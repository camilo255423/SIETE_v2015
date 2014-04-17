
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
object admin extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*2.2*/main("")/*2.10*/{_display_(Seq[Any](format.raw/*2.11*/("""
<input name="location" class="autocomplete" data-url='autocompleteLabel' />
""")))})),format.raw/*4.2*/("""
<script>
$('input.autocomplete').each( function() """),format.raw/*6.42*/("""{"""),format.raw/*6.43*/("""
   var $input = $(this);
   var serverUrl = $input.data('url');
   $input.autocomplete("""),format.raw/*9.24*/("""{"""),format.raw/*9.25*/(""" source:serverUrl """),format.raw/*9.43*/("""}"""),format.raw/*9.44*/(""");
"""),format.raw/*10.1*/("""}"""),format.raw/*10.2*/(""");

</script>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/admin.scala.html
                    HASH: a1bcc22badda884f551e1d983a6a77623bc29830
                    MATRIX: 796->2|812->10|850->11|958->89|1036->140|1064->141|1179->229|1207->230|1252->248|1280->249|1310->252|1338->253
                    LINES: 29->2|29->2|29->2|31->4|33->6|33->6|36->9|36->9|36->9|36->9|37->10|37->10
                    -- GENERATED --
                */
            