
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
object listasemestres extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(semestres:List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""

<select name='semestre' id="listasemestres">
"""),_display_(Seq[Any](/*4.2*/for(semestre <- semestres) yield /*4.28*/{_display_(Seq[Any](format.raw/*4.29*/("""
<option value='"""),_display_(Seq[Any](/*5.17*/semestre)),format.raw/*5.25*/("""'>"""),_display_(Seq[Any](/*5.28*/semestre)),format.raw/*5.36*/("""</option>
""")))})),format.raw/*6.2*/("""
</select>
<script>
$(
function()
"""),format.raw/*11.1*/("""{"""),format.raw/*11.2*/("""

$('#listasemestres').on("change", cambioSemestre);

"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""
);
function cambioSemestre()
"""),format.raw/*18.1*/("""{"""),format.raw/*18.2*/("""
var entidad;
$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");

$("#listaProfesores").html("Cargando...");
$("#progressbar").progressbar("""),format.raw/*23.31*/("""{"""),format.raw/*23.32*/("""
value:false
"""),format.raw/*25.1*/("""}"""),format.raw/*25.2*/(""");
if($('#listainformes').val()==1 || $('#listainformes').val()==2 || $('#listainformes').val()==3 ) entidad="profesores";
if($('#listainformes').val()==4) entidad="facultades";
if($('#listainformes').val()==5) entidad="programas";
if($('#listainformes').val()==6) entidad="participantes";
$.post("cambiosemestre","""),format.raw/*30.25*/("""{"""),format.raw/*30.26*/("""semestre: $('#listasemestres').val(), valor: entidad"""),format.raw/*30.78*/("""}"""),format.raw/*30.79*/(""",mostrarProfesores); // 0 profesores 1 facultades 2 programas
$("#descargas").hide();
"""),format.raw/*32.1*/("""}"""),format.raw/*32.2*/("""
function mostrarProfesores(data)
"""),format.raw/*34.1*/("""{"""),format.raw/*34.2*/("""
$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
$("#progressbar").progressbar("""),format.raw/*36.31*/("""{"""),format.raw/*36.32*/("""
value:false
"""),format.raw/*38.1*/("""}"""),format.raw/*38.2*/(""");
	if(data=="participantes")
	"""),format.raw/*40.2*/("""{"""),format.raw/*40.3*/("""
	$.post("informeparticipantes","""),format.raw/*41.32*/("""{"""),format.raw/*41.33*/("""semestre: $('#listasemestres').val()"""),format.raw/*41.69*/("""}"""),format.raw/*41.70*/(""",mostrar);	
	enlaceDescargas(0,$('#listasemestres').val());
	$('#listaProfesores').hide();
	"""),format.raw/*44.2*/("""}"""),format.raw/*44.3*/("""
	else
	"""),format.raw/*46.2*/("""{"""),format.raw/*46.3*/("""
	$("#listaProfesores").html(data);
	$("#informe").html("");
	$('#listaProfesores').show();
	"""),format.raw/*50.2*/("""}"""),format.raw/*50.3*/("""

"""),format.raw/*52.1*/("""}"""),format.raw/*52.2*/("""
</script>"""))}
    }
    
    def render(semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(semestres)
    
    def f:((List[String]) => play.api.templates.HtmlFormat.Appendable) = (semestres) => apply(semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 27 21:27:43 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: dc30fef5d34fed92a97744b47e0ced73eb768eb9
                    MATRIX: 789->1|907->25|989->73|1030->99|1068->100|1120->117|1149->125|1187->128|1216->136|1257->147|1318->181|1346->182|1427->236|1455->237|1512->267|1540->268|1737->437|1766->438|1806->451|1834->452|2176->766|2205->767|2285->819|2314->820|2427->906|2455->907|2516->941|2544->942|2684->1054|2713->1055|2753->1068|2781->1069|2839->1100|2867->1101|2927->1133|2956->1134|3020->1170|3049->1171|3168->1263|3196->1264|3231->1272|3259->1273|3379->1366|3407->1367|3436->1369|3464->1370
                    LINES: 26->1|29->1|32->4|32->4|32->4|33->5|33->5|33->5|33->5|34->6|39->11|39->11|43->15|43->15|46->18|46->18|51->23|51->23|53->25|53->25|58->30|58->30|58->30|58->30|60->32|60->32|62->34|62->34|64->36|64->36|66->38|66->38|68->40|68->40|69->41|69->41|69->41|69->41|72->44|72->44|74->46|74->46|78->50|78->50|80->52|80->52
                    -- GENERATED --
                */
            