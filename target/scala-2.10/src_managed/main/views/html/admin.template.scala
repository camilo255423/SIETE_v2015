
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
object admin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
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
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 12:37:34 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: d98ea366ec250d1e394463e027177af504633758
                    MATRIX: 864->2|880->10|918->11|1026->89|1104->140|1132->141|1247->229|1275->230|1320->248|1348->249|1378->252|1406->253
                    LINES: 29->2|29->2|29->2|31->4|33->6|33->6|36->9|36->9|36->9|36->9|37->10|37->10
                    -- GENERATED --
                */
            