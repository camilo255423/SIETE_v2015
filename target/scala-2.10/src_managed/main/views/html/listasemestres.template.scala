
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
object listasemestres extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(semestres:List[String]):play.api.templates.Html = {
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
	enlaceDescargas(documentoProfesor,$('#listasemestres').val());
	"""),format.raw/*31.2*/("""}"""),format.raw/*31.3*/("""

""")))}/*33.2*/else/*33.6*/{_display_(Seq[Any](format.raw/*33.7*/("""
	var entidad;
	if($('#listasemestres').val()!=-1)
    """),format.raw/*36.5*/("""{"""),format.raw/*36.6*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	
	$("#listaProfesores").html("Cargando...");
	$("#progressbar").progressbar("""),format.raw/*40.32*/("""{"""),format.raw/*40.33*/("""
	value:false
	"""),format.raw/*42.2*/("""}"""),format.raw/*42.3*/(""");
	if($('#listainformes').val()==1 || $('#listainformes').val()==2 || $('#listainformes').val()==3 ) entidad="profesores";
	if($('#listainformes').val()==4) entidad="facultades";
	if($('#listainformes').val()==5) entidad="programas";
	if($('#listainformes').val()==6) entidad="participantes";
	$.post("cambiosemestre","""),format.raw/*47.26*/("""{"""),format.raw/*47.27*/("""semestre: $('#listasemestres').val(), valor: entidad"""),format.raw/*47.79*/("""}"""),format.raw/*47.80*/(""",mostrarProfesores); // 0 profesores 1 facultades 2 programas
	$("#descargas").hide();
	"""),format.raw/*49.2*/("""}"""),format.raw/*49.3*/("""
	""")))})),format.raw/*50.3*/("""
	function mostrarProfesores(data)
	"""),format.raw/*52.2*/("""{"""),format.raw/*52.3*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	$("#progressbar").progressbar("""),format.raw/*54.32*/("""{"""),format.raw/*54.33*/("""
	value:false
	"""),format.raw/*56.2*/("""}"""),format.raw/*56.3*/(""");
		if(data=="participantes")
		"""),format.raw/*58.3*/("""{"""),format.raw/*58.4*/("""
		$.post("informeparticipantes","""),format.raw/*59.33*/("""{"""),format.raw/*59.34*/("""semestre: $('#listasemestres').val()"""),format.raw/*59.70*/("""}"""),format.raw/*59.71*/(""",mostrar);	
		enlaceDescargas(0,$('#listasemestres').val());
		$('#listaProfesores').hide();
		"""),format.raw/*62.3*/("""}"""),format.raw/*62.4*/("""
		else
		"""),format.raw/*64.3*/("""{"""),format.raw/*64.4*/("""
		$("#listaProfesores").html(data);
		$("#informe").html("");
		$('#listaProfesores').show();
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/("""
	
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/(""" // fin-else """),_display_(Seq[Any](/*70.16*/session)),format.raw/*70.23*/("""
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/("""

function mostrar(data)
"""),format.raw/*74.1*/("""{"""),format.raw/*74.2*/("""
$("#informe").html(data);

"""),format.raw/*77.1*/("""}"""),format.raw/*77.2*/("""
function enlaceDescargas(documento, semestre)
"""),format.raw/*79.1*/("""{"""),format.raw/*79.2*/("""
var informe = "";
if($('#listainformes').val()==1)"""),format.raw/*81.33*/("""{"""),format.raw/*81.34*/("""
informe="informe1";
"""),format.raw/*83.1*/("""}"""),format.raw/*83.2*/("""
if($('#listainformes').val()==2)"""),format.raw/*84.33*/("""{"""),format.raw/*84.34*/("""
informe="informe2";
"""),format.raw/*86.1*/("""}"""),format.raw/*86.2*/("""
if($('#listainformes').val()==3)"""),format.raw/*87.33*/("""{"""),format.raw/*87.34*/("""
informe="informe3";
"""),format.raw/*89.1*/("""}"""),format.raw/*89.2*/("""
if($('#listainformes').val()==4)"""),format.raw/*90.33*/("""{"""),format.raw/*90.34*/("""
informe="informe4";
"""),format.raw/*92.1*/("""}"""),format.raw/*92.2*/("""
if($('#listainformes').val()==5)"""),format.raw/*93.33*/("""{"""),format.raw/*93.34*/("""
informe="informe5";
"""),format.raw/*95.1*/("""}"""),format.raw/*95.2*/("""
if($('#listainformes').val()==6)"""),format.raw/*96.33*/("""{"""),format.raw/*96.34*/("""
informe="informe6";
$("#descargas").show();
"""),format.raw/*99.1*/("""}"""),format.raw/*99.2*/("""

var enlace = '';
var s =  '';

	enlace=informe+'/pdf/'+documento+'/'+semestre;
	s =  "<ul class='side'>";
	s= s+ "<li><a href='"+enlace+"'>Descargar PDF</a></li>";
	"""),_display_(Seq[Any](/*107.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*107.83*/{_display_(Seq[Any](format.raw/*107.84*/("""
	enlace = informe+'/excel/'+documento+'/'+semestre;
	s = s +  "<li><a href='"+enlace+"'>Descargar Excel</a></li>";
	s = s + "</ul>";
	""")))})),format.raw/*111.3*/("""
$("#descargas").html(s);
"""),format.raw/*113.1*/("""}"""),format.raw/*113.2*/("""
</script>"""))}
    }
    
    def render(semestres:List[String]): play.api.templates.Html = apply(semestres)
    
    def f:((List[String]) => play.api.templates.Html) = (semestres) => apply(semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: f369a67c78184557f46c4bc54f887ea342c38dba
                    MATRIX: 738->1|839->25|964->116|1005->142|1043->143|1095->160|1124->168|1162->171|1191->179|1232->190|1293->224|1321->225|1402->279|1430->280|1487->310|1515->311|1553->314|1598->350|1637->351|1700->378|1716->385|1755->402|1828->448|1856->449|1998->563|2027->564|2069->579|2097->580|2154->609|2183->610|2277->676|2306->677|2345->689|2373->690|2394->693|2406->697|2444->698|2526->753|2554->754|2742->914|2771->915|2813->930|2841->931|3188->1250|3217->1251|3297->1303|3326->1304|3441->1392|3469->1393|3503->1396|3566->1432|3594->1433|3736->1547|3765->1548|3807->1563|3835->1564|3895->1597|3923->1598|3984->1631|4013->1632|4077->1668|4106->1669|4228->1764|4256->1765|4293->1775|4321->1776|4445->1873|4473->1874|4503->1877|4531->1878|4581->1892|4610->1899|4638->1900|4666->1901|4718->1926|4746->1927|4801->1955|4829->1956
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|40->12|40->12|44->16|44->16|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|60->32|60->32|60->32|63->35|63->35|67->39|67->39|69->41|69->41|74->46|74->46|74->46|74->46|76->48|76->48|77->49|79->51|79->51|81->53|81->53|83->55|83->55|85->57|85->57|86->58|86->58|86->58|86->58|89->61|89->61|91->63|91->63|95->67|95->67|97->69|97->69|97->69|97->69|98->70|98->70|101->73|101->73|104->76|104->76
=======
                    DATE: Mon Apr 07 16:38:35 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: f678d95069957dfc63380d6501a3cc9d203b8d30
                    MATRIX: 789->1|907->25|1032->116|1073->142|1111->143|1163->160|1192->168|1230->171|1259->179|1300->190|1361->224|1389->225|1470->279|1498->280|1555->310|1583->311|1621->314|1666->350|1705->351|1768->378|1784->385|1823->402|1896->448|1924->449|2066->563|2095->564|2137->579|2165->580|2222->609|2251->610|2345->676|2374->677|2477->753|2505->754|2526->757|2538->761|2576->762|2658->817|2686->818|2874->978|2903->979|2945->994|2973->995|3320->1314|3349->1315|3429->1367|3458->1368|3573->1456|3601->1457|3635->1460|3698->1496|3726->1497|3868->1611|3897->1612|3939->1627|3967->1628|4027->1661|4055->1662|4116->1695|4145->1696|4209->1732|4238->1733|4360->1828|4388->1829|4425->1839|4453->1840|4577->1937|4605->1938|4635->1941|4663->1942|4713->1956|4742->1963|4770->1964|4798->1965|4850->1990|4878->1991|4933->2019|4961->2020|5035->2067|5063->2068|5142->2119|5171->2120|5219->2141|5247->2142|5308->2175|5337->2176|5385->2197|5413->2198|5474->2231|5503->2232|5551->2253|5579->2254|5640->2287|5669->2288|5717->2309|5745->2310|5806->2343|5835->2344|5883->2365|5911->2366|5972->2399|6001->2400|6073->2445|6101->2446|6305->2614|6395->2694|6435->2695|6603->2831|6657->2857|6686->2858
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|40->12|40->12|44->16|44->16|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|54->26|54->26|56->28|56->28|57->29|57->29|57->29|57->29|59->31|59->31|61->33|61->33|61->33|64->36|64->36|68->40|68->40|70->42|70->42|75->47|75->47|75->47|75->47|77->49|77->49|78->50|80->52|80->52|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|87->59|87->59|90->62|90->62|92->64|92->64|96->68|96->68|98->70|98->70|98->70|98->70|99->71|99->71|102->74|102->74|105->77|105->77|107->79|107->79|109->81|109->81|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|127->99|127->99|135->107|135->107|135->107|139->111|141->113|141->113
>>>>>>> 4d44da7d489b48f84b12a1a6b3ad9e4d2caf1200
                    -- GENERATED --
                */
            