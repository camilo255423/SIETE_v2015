
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
    """),format.raw/*25.5*/("""{"""),format.raw/*25.6*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	$("#progressbar").progressbar("""),format.raw/*27.32*/("""{"""),format.raw/*27.33*/("""
	value:false
	"""),format.raw/*29.2*/("""}"""),format.raw/*29.3*/(""");
	if($('#listainformes').val()==1) $.post("informeprofesor","""),format.raw/*30.60*/("""{"""),format.raw/*30.61*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*30.127*/("""}"""),format.raw/*30.128*/(""",mostrar);
	if($('#listainformes').val()==2) $.post("heteroevaluacion","""),format.raw/*31.61*/("""{"""),format.raw/*31.62*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*31.128*/("""}"""),format.raw/*31.129*/(""",mostrar);
	if($('#listainformes').val()==3) $.post("informefinal","""),format.raw/*32.57*/("""{"""),format.raw/*32.58*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*32.124*/("""}"""),format.raw/*32.125*/(""",mostrar);
	
	enlaceDescargas(documentoProfesor,$('#listasemestres').val());
	"""),format.raw/*35.2*/("""}"""),format.raw/*35.3*/("""

""")))}/*37.2*/else/*37.6*/{_display_(Seq[Any](format.raw/*37.7*/("""
	var entidad;
	if($('#listasemestres').val()!=-1)
    """),format.raw/*40.5*/("""{"""),format.raw/*40.6*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	
	$("#listaProfesores").html("Cargando...");
	$("#progressbar").progressbar("""),format.raw/*44.32*/("""{"""),format.raw/*44.33*/("""
	value:false
	"""),format.raw/*46.2*/("""}"""),format.raw/*46.3*/(""");
	if($('#listainformes').val()==1 || $('#listainformes').val()==2 || $('#listainformes').val()==3 ) entidad="profesores";
	if($('#listainformes').val()==4) entidad="facultades";
	if($('#listainformes').val()==5) entidad="programas";
	if($('#listainformes').val()==6) entidad="participantes";
	$.post("cambiosemestre","""),format.raw/*51.26*/("""{"""),format.raw/*51.27*/("""semestre: $('#listasemestres').val(), valor: entidad"""),format.raw/*51.79*/("""}"""),format.raw/*51.80*/(""",mostrarProfesores); // 0 profesores 1 facultades 2 programas
	$("#descargas").hide();
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/("""
	""")))})),format.raw/*54.3*/("""
	function mostrarProfesores(data)
	"""),format.raw/*56.2*/("""{"""),format.raw/*56.3*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	$("#progressbar").progressbar("""),format.raw/*58.32*/("""{"""),format.raw/*58.33*/("""
	value:false
	"""),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
		if(data=="participantes")
		"""),format.raw/*62.3*/("""{"""),format.raw/*62.4*/("""
		$.post("informeparticipantes","""),format.raw/*63.33*/("""{"""),format.raw/*63.34*/("""semestre: $('#listasemestres').val()"""),format.raw/*63.70*/("""}"""),format.raw/*63.71*/(""",mostrar);	
		enlaceDescargas(0,$('#listasemestres').val());
		$('#listaProfesores').hide();
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/("""
		else
		"""),format.raw/*68.3*/("""{"""),format.raw/*68.4*/("""
		$("#listaProfesores").html(data);
		$("#informe").html("");
		$('#listaProfesores').show();
		"""),format.raw/*72.3*/("""}"""),format.raw/*72.4*/("""
	
"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/(""" // fin-else """),_display_(Seq[Any](/*74.16*/session)),format.raw/*74.23*/("""
"""),format.raw/*75.1*/("""}"""),format.raw/*75.2*/("""

function mostrar(data)
"""),format.raw/*78.1*/("""{"""),format.raw/*78.2*/("""
$("#informe").html(data);

"""),format.raw/*81.1*/("""}"""),format.raw/*81.2*/("""
function enlaceDescargas(documento, semestre)
"""),format.raw/*83.1*/("""{"""),format.raw/*83.2*/("""
var informe = "";
if($('#listainformes').val()==1)"""),format.raw/*85.33*/("""{"""),format.raw/*85.34*/("""
informe="informe1";
"""),format.raw/*87.1*/("""}"""),format.raw/*87.2*/("""
if($('#listainformes').val()==2)"""),format.raw/*88.33*/("""{"""),format.raw/*88.34*/("""
informe="informe2";
"""),format.raw/*90.1*/("""}"""),format.raw/*90.2*/("""
if($('#listainformes').val()==3)"""),format.raw/*91.33*/("""{"""),format.raw/*91.34*/("""
informe="informe3";
"""),format.raw/*93.1*/("""}"""),format.raw/*93.2*/("""
if($('#listainformes').val()==4)"""),format.raw/*94.33*/("""{"""),format.raw/*94.34*/("""
informe="informe4";
"""),format.raw/*96.1*/("""}"""),format.raw/*96.2*/("""
if($('#listainformes').val()==5)"""),format.raw/*97.33*/("""{"""),format.raw/*97.34*/("""
informe="informe5";
"""),format.raw/*99.1*/("""}"""),format.raw/*99.2*/("""
if($('#listainformes').val()==6)"""),format.raw/*100.33*/("""{"""),format.raw/*100.34*/("""
informe="informe6";
$("#descargas").show();
"""),format.raw/*103.1*/("""}"""),format.raw/*103.2*/("""

var enlace = '';
var s =  '';

	enlace=informe+'/pdf/'+documento+'/'+semestre;
	s =  "<ul class='side'>";
	s= s+ "<li><a href='"+enlace+"'>Descargar PDF</a></li>";
	"""),_display_(Seq[Any](/*111.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*111.83*/{_display_(Seq[Any](format.raw/*111.84*/("""
	enlace = informe+'/excel/'+documento+'/'+semestre;
	s = s +  "<li><a href='"+enlace+"'>Descargar Excel</a></li>";
	s = s + "</ul>";
	""")))})),format.raw/*115.3*/("""
$("#descargas").html(s);
"""),format.raw/*117.1*/("""}"""),format.raw/*117.2*/("""
</script>"""))}
    }
    
    def render(semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(semestres)
    
    def f:((List[String]) => play.api.templates.HtmlFormat.Appendable) = (semestres) => apply(semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 04 16:10:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: 7193a6f4d7e841817cb9b119ad32823c80bbb48c
                    MATRIX: 789->1|907->25|1032->116|1073->142|1111->143|1163->160|1192->168|1230->171|1259->179|1300->190|1361->224|1389->225|1470->279|1498->280|1555->310|1583->311|1621->314|1666->350|1705->351|1768->378|1784->385|1823->402|1897->449|1925->450|2067->564|2096->565|2138->580|2166->581|2256->643|2285->644|2380->710|2410->711|2509->782|2538->783|2633->849|2663->850|2758->917|2787->918|2882->984|2912->985|3017->1063|3045->1064|3066->1067|3078->1071|3116->1072|3198->1127|3226->1128|3414->1288|3443->1289|3485->1304|3513->1305|3860->1624|3889->1625|3969->1677|3998->1678|4113->1766|4141->1767|4175->1770|4238->1806|4266->1807|4408->1921|4437->1922|4479->1937|4507->1938|4567->1971|4595->1972|4656->2005|4685->2006|4749->2042|4778->2043|4900->2138|4928->2139|4965->2149|4993->2150|5117->2247|5145->2248|5175->2251|5203->2252|5253->2266|5282->2273|5310->2274|5338->2275|5390->2300|5418->2301|5473->2329|5501->2330|5575->2377|5603->2378|5682->2429|5711->2430|5759->2451|5787->2452|5848->2485|5877->2486|5925->2507|5953->2508|6014->2541|6043->2542|6091->2563|6119->2564|6180->2597|6209->2598|6257->2619|6285->2620|6346->2653|6375->2654|6423->2675|6451->2676|6513->2709|6543->2710|6616->2755|6645->2756|6849->2924|6939->3004|6979->3005|7147->3141|7201->3167|7230->3168
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|40->12|40->12|44->16|44->16|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|53->25|53->25|55->27|55->27|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|63->35|63->35|65->37|65->37|65->37|68->40|68->40|72->44|72->44|74->46|74->46|79->51|79->51|79->51|79->51|81->53|81->53|82->54|84->56|84->56|86->58|86->58|88->60|88->60|90->62|90->62|91->63|91->63|91->63|91->63|94->66|94->66|96->68|96->68|100->72|100->72|102->74|102->74|102->74|102->74|103->75|103->75|106->78|106->78|109->81|109->81|111->83|111->83|113->85|113->85|115->87|115->87|116->88|116->88|118->90|118->90|119->91|119->91|121->93|121->93|122->94|122->94|124->96|124->96|125->97|125->97|127->99|127->99|128->100|128->100|131->103|131->103|139->111|139->111|139->111|143->115|145->117|145->117
                    -- GENERATED --
                */
            