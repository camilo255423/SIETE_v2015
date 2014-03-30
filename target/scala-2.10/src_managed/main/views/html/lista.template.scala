
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
object lista extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Profesor],Integer,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], conScript:Integer=0):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.50*/("""

<select name='documento' id='listaProfesores' style="width:100%;max-width:99%;">
<option value=-1>- Seleccione un docente</option>
"""),_display_(Seq[Any](/*5.2*/for(profesor <- profesores) yield /*5.29*/{_display_(Seq[Any](format.raw/*5.30*/("""
<option value='"""),_display_(Seq[Any](/*6.17*/profesor/*6.25*/.getDocumento())),format.raw/*6.40*/("""'>"""),_display_(Seq[Any](/*6.43*/profesor/*6.51*/.getApellidos())),format.raw/*6.66*/(""" """),_display_(Seq[Any](/*6.68*/profesor/*6.76*/.getNombres())),format.raw/*6.89*/("""</option>
""")))})),format.raw/*7.2*/("""
</select>

"""),_display_(Seq[Any](/*10.2*/if(conScript==1)/*10.18*/{_display_(Seq[Any](format.raw/*10.19*/("""
<script>
$(
function()
"""),format.raw/*14.1*/("""{"""),format.raw/*14.2*/("""
var availableTags = [
      "azul",
      "blanco",
      "rojo",
      "verde"];
$( "#tags" ).autocomplete("""),format.raw/*20.27*/("""{"""),format.raw/*20.28*/("""
      source: availableTags
    """),format.raw/*22.5*/("""}"""),format.raw/*22.6*/(""")

$('#listaProfesores').on("change", cambioProfesor);
$('#listainformes').on("change", cambioInforme);

"""),format.raw/*27.1*/("""}"""),format.raw/*27.2*/("""
);
function cambioInforme()
"""),format.raw/*30.1*/("""{"""),format.raw/*30.2*/("""

cambioSemestre();
cambioProfesor();
"""),format.raw/*34.1*/("""}"""),format.raw/*34.2*/("""
function cambioProfesor()
"""),format.raw/*36.1*/("""{"""),format.raw/*36.2*/("""
if($('#listasemestres').val()!=-1)
"""),format.raw/*38.1*/("""{"""),format.raw/*38.2*/("""
var documentoProfesor = $('#listaProfesores').val();
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
			$("#progressbar").progressbar("""),format.raw/*41.34*/("""{"""),format.raw/*41.35*/("""
			value:false
			"""),format.raw/*43.4*/("""}"""),format.raw/*43.5*/(""");
	if(documentoProfesor!=-1 && documentoProfesor)
	"""),format.raw/*45.2*/("""{"""),format.raw/*45.3*/("""
	
		
			enlaceDescargas($('#listaProfesores').val(),$('#listasemestres').val());
			if($('#listainformes').val()==1)"""),format.raw/*49.36*/("""{"""),format.raw/*49.37*/("""
			$.post("informeprofesor","""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*50.96*/("""}"""),format.raw/*50.97*/(""",mostrar);
			"""),format.raw/*51.4*/("""}"""),format.raw/*51.5*/("""
			if($('#listainformes').val()==2)"""),format.raw/*52.36*/("""{"""),format.raw/*52.37*/("""
			$.post("heteroevaluacion","""),format.raw/*53.30*/("""{"""),format.raw/*53.31*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*53.97*/("""}"""),format.raw/*53.98*/(""",mostrar);
			"""),format.raw/*54.4*/("""}"""),format.raw/*54.5*/("""
			if($('#listainformes').val()==3)"""),format.raw/*55.36*/("""{"""),format.raw/*55.37*/("""
			$.post("informefinal","""),format.raw/*56.26*/("""{"""),format.raw/*56.27*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*56.93*/("""}"""),format.raw/*56.94*/(""",mostrar);
			"""),format.raw/*57.4*/("""}"""),format.raw/*57.5*/("""
			if($('#listainformes').val()==4)"""),format.raw/*58.36*/("""{"""),format.raw/*58.37*/("""
			$.post("informefacultad","""),format.raw/*59.29*/("""{"""),format.raw/*59.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*59.96*/("""}"""),format.raw/*59.97*/(""",mostrar);
			"""),format.raw/*60.4*/("""}"""),format.raw/*60.5*/("""
				if($('#listainformes').val()==5)"""),format.raw/*61.37*/("""{"""),format.raw/*61.38*/("""
			$.post("informeprograma","""),format.raw/*62.29*/("""{"""),format.raw/*62.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*62.96*/("""}"""),format.raw/*62.97*/(""",mostrar);
			"""),format.raw/*63.4*/("""}"""),format.raw/*63.5*/("""
			if($('#listainformes').val()==6)"""),format.raw/*64.36*/("""{"""),format.raw/*64.37*/("""
			$.post("informeparticipantes","""),format.raw/*65.34*/("""{"""),format.raw/*65.35*/("""semestre: $('#listasemestres').val()"""),format.raw/*65.71*/("""}"""),format.raw/*65.72*/(""",mostrar);
			"""),format.raw/*66.4*/("""}"""),format.raw/*66.5*/("""
			$("#descargas").show();
	"""),format.raw/*68.2*/("""}"""),format.raw/*68.3*/("""
	else
	"""),format.raw/*70.2*/("""{"""),format.raw/*70.3*/("""
	$("#descargas").hide();
	$("#informe").html("<div></div>");
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/("""
"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/("""
"""),format.raw/*75.1*/("""}"""),format.raw/*75.2*/("""

function enlaceDescargas(documento, semestre)
"""),format.raw/*78.1*/("""{"""),format.raw/*78.2*/("""
var informe = "";
if($('#listainformes').val()==1)"""),format.raw/*80.33*/("""{"""),format.raw/*80.34*/("""
informe="informe1";
"""),format.raw/*82.1*/("""}"""),format.raw/*82.2*/("""
if($('#listainformes').val()==2)"""),format.raw/*83.33*/("""{"""),format.raw/*83.34*/("""
informe="informe2";
"""),format.raw/*85.1*/("""}"""),format.raw/*85.2*/("""
if($('#listainformes').val()==3)"""),format.raw/*86.33*/("""{"""),format.raw/*86.34*/("""
informe="informe3";
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/("""
if($('#listainformes').val()==4)"""),format.raw/*89.33*/("""{"""),format.raw/*89.34*/("""
informe="informe4";
"""),format.raw/*91.1*/("""}"""),format.raw/*91.2*/("""
if($('#listainformes').val()==5)"""),format.raw/*92.33*/("""{"""),format.raw/*92.34*/("""
informe="informe5";
"""),format.raw/*94.1*/("""}"""),format.raw/*94.2*/("""
if($('#listainformes').val()==6)"""),format.raw/*95.33*/("""{"""),format.raw/*95.34*/("""
informe="informe6";
$("#descargas").show();
"""),format.raw/*98.1*/("""}"""),format.raw/*98.2*/("""

var enlace = '';
var s =  '';
	enlace=informe+'/pdf/'+documento+'/'+semestre;
	s =  "<ul class='side'>";
	s= s+ "<li><a href='"+enlace+"'>Descargar PDF</a></li>";
	enlace = informe+'/excel/'+documento+'/'+semestre;
	s = s +  "<li><a href='"+enlace+"'>Descargar Excel</a></li>";
	s = s + "</ul>";

$("#descargas").html(s);
"""),format.raw/*110.1*/("""}"""),format.raw/*110.2*/("""
</script>
""")))})))}
    }
    
    def render(profesores:List[Profesor],conScript:Integer): play.api.templates.Html = apply(profesores,conScript)
    
    def f:((List[Profesor],Integer) => play.api.templates.Html) = (profesores,conScript) => apply(profesores,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Fri Mar 28 10:07:47 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/lista.scala.html
                    HASH: 595fb2ec9d043660357dadc79b3cbb37418a3682
                    MATRIX: 739->1|864->49|1032->183|1074->210|1112->211|1164->228|1180->236|1216->251|1254->254|1270->262|1306->277|1343->279|1359->287|1393->300|1434->311|1482->324|1507->340|1546->341|1597->365|1625->366|1762->475|1791->476|1851->509|1879->510|2011->615|2039->616|2095->645|2123->646|2188->684|2216->685|2270->712|2298->713|2495->882|2524->883|2570->902|2598->903|2677->955|2705->956|2850->1073|2879->1074|2936->1103|2965->1104|3059->1170|3088->1171|3129->1185|3157->1186|3221->1222|3250->1223|3308->1253|3337->1254|3431->1320|3460->1321|3501->1335|3529->1336|3593->1372|3622->1373|3676->1399|3705->1400|3799->1466|3828->1467|3869->1481|3897->1482|3961->1518|3990->1519|4047->1548|4076->1549|4170->1615|4199->1616|4240->1630|4268->1631|4333->1668|4362->1669|4419->1698|4448->1699|4542->1765|4571->1766|4612->1780|4640->1781|4704->1817|4733->1818|4795->1852|4824->1853|4888->1889|4917->1890|4958->1904|4986->1905|5042->1934|5070->1935|5105->1943|5133->1944|5223->2007|5251->2008|5279->2009|5307->2010|5358->2034|5386->2035|5441->2063|5469->2064|5543->2111|5571->2112|5650->2163|5679->2164|5727->2185|5755->2186|5816->2219|5845->2220|5893->2241|5921->2242|5982->2275|6011->2276|6059->2297|6087->2298|6148->2331|6177->2332|6225->2353|6253->2354|6314->2387|6343->2388|6391->2409|6419->2410|6480->2443|6509->2444|6581->2489|6609->2490|6961->2814|6990->2815
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|48->20|48->20|50->22|50->22|55->27|55->27|58->30|58->30|62->34|62->34|64->36|64->36|67->39|67->39|69->41|69->41|71->43|71->43|75->47|75->47|76->48|76->48|76->48|76->48|77->49|77->49|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|94->66|94->66|96->68|96->68|99->71|99->71|100->72|100->72|102->74|102->74|105->77|105->77|107->79|107->79|109->81|109->81|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|127->99|127->99|139->111|139->111
=======
                    DATE: Sun Mar 30 09:24:01 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/lista.scala.html
                    HASH: 045f22f67d76749925914f0352358d26398a7fbb
                    MATRIX: 790->1|932->49|1100->183|1142->210|1180->211|1232->228|1248->236|1284->251|1322->254|1338->262|1374->277|1411->279|1427->287|1461->300|1502->311|1550->324|1575->340|1614->341|1665->365|1693->366|1830->475|1859->476|1919->509|1947->510|2079->615|2107->616|2163->645|2191->646|2256->684|2284->685|2338->712|2366->713|2429->749|2457->750|2654->919|2683->920|2729->939|2757->940|2836->992|2864->993|3009->1110|3038->1111|3095->1140|3124->1141|3218->1207|3247->1208|3288->1222|3316->1223|3380->1259|3409->1260|3467->1290|3496->1291|3590->1357|3619->1358|3660->1372|3688->1373|3752->1409|3781->1410|3835->1436|3864->1437|3958->1503|3987->1504|4028->1518|4056->1519|4120->1555|4149->1556|4206->1585|4235->1586|4329->1652|4358->1653|4399->1667|4427->1668|4492->1705|4521->1706|4578->1735|4607->1736|4701->1802|4730->1803|4771->1817|4799->1818|4863->1854|4892->1855|4954->1889|4983->1890|5047->1926|5076->1927|5117->1941|5145->1942|5201->1971|5229->1972|5264->1980|5292->1981|5382->2044|5410->2045|5438->2046|5466->2047|5494->2048|5522->2049|5597->2097|5625->2098|5704->2149|5733->2150|5781->2171|5809->2172|5870->2205|5899->2206|5947->2227|5975->2228|6036->2261|6065->2262|6113->2283|6141->2284|6202->2317|6231->2318|6279->2339|6307->2340|6368->2373|6397->2374|6445->2395|6473->2396|6534->2429|6563->2430|6635->2475|6663->2476|7015->2800|7044->2801
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|48->20|48->20|50->22|50->22|55->27|55->27|58->30|58->30|62->34|62->34|64->36|64->36|66->38|66->38|69->41|69->41|71->43|71->43|73->45|73->45|77->49|77->49|78->50|78->50|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|96->68|96->68|98->70|98->70|101->73|101->73|102->74|102->74|103->75|103->75|106->78|106->78|108->80|108->80|110->82|110->82|111->83|111->83|113->85|113->85|114->86|114->86|116->88|116->88|117->89|117->89|119->91|119->91|120->92|120->92|122->94|122->94|123->95|123->95|126->98|126->98|138->110|138->110
>>>>>>> cb77d0927cd8f261a2ae957c054b26b84cb8d3a1
                    -- GENERATED --
                */
            