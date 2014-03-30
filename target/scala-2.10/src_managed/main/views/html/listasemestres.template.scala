
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
<option value='-1'>- Seleccione -</option>
"""),_display_(Seq[Any](/*5.2*/for(semestre <- semestres) yield /*5.28*/{_display_(Seq[Any](format.raw/*5.29*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/semestre)),format.raw/*6.25*/("""'>"""),_display_(Seq[Any](/*6.28*/semestre)),format.raw/*6.36*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>
<script>
$(
function()
"""),format.raw/*12.1*/("""{"""),format.raw/*12.2*/("""

$('#listasemestres').on("change", cambioSemestre);

"""),format.raw/*16.1*/("""}"""),format.raw/*16.2*/("""
);
function cambioSemestre()
"""),format.raw/*19.1*/("""{"""),format.raw/*19.2*/("""

"""),_display_(Seq[Any](/*21.2*/if(session.get("rol")==Rol.PROFESOR)/*21.38*/{_display_(Seq[Any](format.raw/*21.39*/("""
var documentoProfesor = '"""),_display_(Seq[Any](/*22.27*/session/*22.34*/.get("documento"))),format.raw/*22.51*/("""';
    if($('#listasemestres').val()!=-1)
    """),format.raw/*24.5*/("""{"""),format.raw/*24.6*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	$("#progressbar").progressbar("""),format.raw/*26.32*/("""{"""),format.raw/*26.33*/("""
	value:false
	"""),format.raw/*28.2*/("""}"""),format.raw/*28.3*/(""");
	$.post("informeprofesor","""),format.raw/*29.27*/("""{"""),format.raw/*29.28*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*29.94*/("""}"""),format.raw/*29.95*/(""",mostrar);
	"""),format.raw/*30.2*/("""}"""),format.raw/*30.3*/("""

""")))}/*32.2*/else/*32.6*/{_display_(Seq[Any](format.raw/*32.7*/("""
	var entidad;
	if($('#listasemestres').val()!=-1)
    """),format.raw/*35.5*/("""{"""),format.raw/*35.6*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	
	$("#listaProfesores").html("Cargando...");
	$("#progressbar").progressbar("""),format.raw/*39.32*/("""{"""),format.raw/*39.33*/("""
	value:false
	"""),format.raw/*41.2*/("""}"""),format.raw/*41.3*/(""");
	if($('#listainformes').val()==1 || $('#listainformes').val()==2 || $('#listainformes').val()==3 ) entidad="profesores";
	if($('#listainformes').val()==4) entidad="facultades";
	if($('#listainformes').val()==5) entidad="programas";
	if($('#listainformes').val()==6) entidad="participantes";
	$.post("cambiosemestre","""),format.raw/*46.26*/("""{"""),format.raw/*46.27*/("""semestre: $('#listasemestres').val(), valor: entidad"""),format.raw/*46.79*/("""}"""),format.raw/*46.80*/(""",mostrarProfesores); // 0 profesores 1 facultades 2 programas
	$("#descargas").hide();
	"""),format.raw/*48.2*/("""}"""),format.raw/*48.3*/("""
	""")))})),format.raw/*49.3*/("""
	function mostrarProfesores(data)
	"""),format.raw/*51.2*/("""{"""),format.raw/*51.3*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	$("#progressbar").progressbar("""),format.raw/*53.32*/("""{"""),format.raw/*53.33*/("""
	value:false
	"""),format.raw/*55.2*/("""}"""),format.raw/*55.3*/(""");
		if(data=="participantes")
		"""),format.raw/*57.3*/("""{"""),format.raw/*57.4*/("""
		$.post("informeparticipantes","""),format.raw/*58.33*/("""{"""),format.raw/*58.34*/("""semestre: $('#listasemestres').val()"""),format.raw/*58.70*/("""}"""),format.raw/*58.71*/(""",mostrar);	
		enlaceDescargas(0,$('#listasemestres').val());
		$('#listaProfesores').hide();
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/("""
		else
		"""),format.raw/*63.3*/("""{"""),format.raw/*63.4*/("""
		$("#listaProfesores").html(data);
		$("#informe").html("");
		$('#listaProfesores').show();
		"""),format.raw/*67.3*/("""}"""),format.raw/*67.4*/("""
	
"""),format.raw/*69.1*/("""}"""),format.raw/*69.2*/(""" // fin-else """),_display_(Seq[Any](/*69.16*/session)),format.raw/*69.23*/("""
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/("""

function mostrar(data)
"""),format.raw/*73.1*/("""{"""),format.raw/*73.2*/("""
$("#informe").html(data);

"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/("""
</script>"""))}
    }
    
    def render(semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(semestres)
    
    def f:((List[String]) => play.api.templates.HtmlFormat.Appendable) = (semestres) => apply(semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 09:20:57 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: f10f2a4510ac67214a6e96bae0f0c7e9af658414
                    MATRIX: 789->1|907->25|1032->116|1073->142|1111->143|1163->160|1192->168|1230->171|1259->179|1300->190|1361->224|1389->225|1470->279|1498->280|1555->310|1583->311|1621->314|1666->350|1705->351|1768->378|1784->385|1823->402|1896->448|1924->449|2066->563|2095->564|2137->579|2165->580|2222->609|2251->610|2345->676|2374->677|2413->689|2441->690|2462->693|2474->697|2512->698|2594->753|2622->754|2810->914|2839->915|2881->930|2909->931|3256->1250|3285->1251|3365->1303|3394->1304|3509->1392|3537->1393|3571->1396|3634->1432|3662->1433|3804->1547|3833->1548|3875->1563|3903->1564|3963->1597|3991->1598|4052->1631|4081->1632|4145->1668|4174->1669|4296->1764|4324->1765|4361->1775|4389->1776|4513->1873|4541->1874|4571->1877|4599->1878|4649->1892|4678->1899|4706->1900|4734->1901|4786->1926|4814->1927|4869->1955|4897->1956
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|40->12|40->12|44->16|44->16|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|60->32|60->32|60->32|63->35|63->35|67->39|67->39|69->41|69->41|74->46|74->46|74->46|74->46|76->48|76->48|77->49|79->51|79->51|81->53|81->53|83->55|83->55|85->57|85->57|86->58|86->58|86->58|86->58|89->61|89->61|91->63|91->63|95->67|95->67|97->69|97->69|97->69|97->69|98->70|98->70|101->73|101->73|104->76|104->76
                    -- GENERATED --
                */
            