
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
var documentoProfesor = $('#listaProfesores').val();
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
			$("#progressbar").progressbar("""),format.raw/*39.34*/("""{"""),format.raw/*39.35*/("""
			value:false
			"""),format.raw/*41.4*/("""}"""),format.raw/*41.5*/(""");
	if(documentoProfesor!=-1 && documentoProfesor)
	"""),format.raw/*43.2*/("""{"""),format.raw/*43.3*/("""
	
		
			enlaceDescargas($('#listaProfesores').val(),$('#listasemestres').val());
			if($('#listainformes').val()==1)"""),format.raw/*47.36*/("""{"""),format.raw/*47.37*/("""
			$.post("informeprofesor","""),format.raw/*48.29*/("""{"""),format.raw/*48.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*48.96*/("""}"""),format.raw/*48.97*/(""",mostrar);
			"""),format.raw/*49.4*/("""}"""),format.raw/*49.5*/("""
			if($('#listainformes').val()==2)"""),format.raw/*50.36*/("""{"""),format.raw/*50.37*/("""
			$.post("heteroevaluacion","""),format.raw/*51.30*/("""{"""),format.raw/*51.31*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*51.97*/("""}"""),format.raw/*51.98*/(""",mostrar);
			"""),format.raw/*52.4*/("""}"""),format.raw/*52.5*/("""
			if($('#listainformes').val()==3)"""),format.raw/*53.36*/("""{"""),format.raw/*53.37*/("""
			$.post("informefinal","""),format.raw/*54.26*/("""{"""),format.raw/*54.27*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*54.93*/("""}"""),format.raw/*54.94*/(""",mostrar);
			"""),format.raw/*55.4*/("""}"""),format.raw/*55.5*/("""
			if($('#listainformes').val()==4)"""),format.raw/*56.36*/("""{"""),format.raw/*56.37*/("""
			$.post("informefacultad","""),format.raw/*57.29*/("""{"""),format.raw/*57.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*57.96*/("""}"""),format.raw/*57.97*/(""",mostrar);
			"""),format.raw/*58.4*/("""}"""),format.raw/*58.5*/("""
				if($('#listainformes').val()==5)"""),format.raw/*59.37*/("""{"""),format.raw/*59.38*/("""
			$.post("informeprograma","""),format.raw/*60.29*/("""{"""),format.raw/*60.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*60.96*/("""}"""),format.raw/*60.97*/(""",mostrar);
			"""),format.raw/*61.4*/("""}"""),format.raw/*61.5*/("""
			if($('#listainformes').val()==6)"""),format.raw/*62.36*/("""{"""),format.raw/*62.37*/("""
			$.post("informeparticipantes","""),format.raw/*63.34*/("""{"""),format.raw/*63.35*/("""semestre: $('#listasemestres').val()"""),format.raw/*63.71*/("""}"""),format.raw/*63.72*/(""",mostrar);
			"""),format.raw/*64.4*/("""}"""),format.raw/*64.5*/("""
			$("#descargas").show();
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/("""
	else
	"""),format.raw/*68.2*/("""{"""),format.raw/*68.3*/("""
	$("#descargas").hide();
	$("#informe").html("<div></div>");
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/("""
"""),format.raw/*72.1*/("""}"""),format.raw/*72.2*/("""
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
	enlace = informe+'/excel/'+documento+'/'+semestre;
	s = s +  "<li><a href='"+enlace+"'>Descargar Excel</a></li>";
	s = s + "</ul>";

$("#descargas").html(s);
"""),format.raw/*111.1*/("""}"""),format.raw/*111.2*/("""
</script>
""")))})))}
    }
    
    def render(profesores:List[Profesor],conScript:Integer): play.api.templates.Html = apply(profesores,conScript)
    
    def f:((List[Profesor],Integer) => play.api.templates.Html) = (profesores,conScript) => apply(profesores,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 24 19:20:25 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/lista.scala.html
                    HASH: 595fb2ec9d043660357dadc79b3cbb37418a3682
                    MATRIX: 739->1|864->49|1032->183|1074->210|1112->211|1164->228|1180->236|1216->251|1254->254|1270->262|1306->277|1343->279|1359->287|1393->300|1434->311|1482->324|1507->340|1546->341|1597->365|1625->366|1762->475|1791->476|1851->509|1879->510|2011->615|2039->616|2095->645|2123->646|2188->684|2216->685|2270->712|2298->713|2495->882|2524->883|2570->902|2598->903|2677->955|2705->956|2850->1073|2879->1074|2936->1103|2965->1104|3059->1170|3088->1171|3129->1185|3157->1186|3221->1222|3250->1223|3308->1253|3337->1254|3431->1320|3460->1321|3501->1335|3529->1336|3593->1372|3622->1373|3676->1399|3705->1400|3799->1466|3828->1467|3869->1481|3897->1482|3961->1518|3990->1519|4047->1548|4076->1549|4170->1615|4199->1616|4240->1630|4268->1631|4333->1668|4362->1669|4419->1698|4448->1699|4542->1765|4571->1766|4612->1780|4640->1781|4704->1817|4733->1818|4795->1852|4824->1853|4888->1889|4917->1890|4958->1904|4986->1905|5042->1934|5070->1935|5105->1943|5133->1944|5223->2007|5251->2008|5279->2009|5307->2010|5358->2034|5386->2035|5441->2063|5469->2064|5543->2111|5571->2112|5650->2163|5679->2164|5727->2185|5755->2186|5816->2219|5845->2220|5893->2241|5921->2242|5982->2275|6011->2276|6059->2297|6087->2298|6148->2331|6177->2332|6225->2353|6253->2354|6314->2387|6343->2388|6391->2409|6419->2410|6480->2443|6509->2444|6581->2489|6609->2490|6961->2814|6990->2815
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|48->20|48->20|50->22|50->22|55->27|55->27|58->30|58->30|62->34|62->34|64->36|64->36|67->39|67->39|69->41|69->41|71->43|71->43|75->47|75->47|76->48|76->48|76->48|76->48|77->49|77->49|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|94->66|94->66|96->68|96->68|99->71|99->71|100->72|100->72|102->74|102->74|105->77|105->77|107->79|107->79|109->81|109->81|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|127->99|127->99|139->111|139->111
                    -- GENERATED --
                */
            