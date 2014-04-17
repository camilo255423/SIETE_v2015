
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
                    DATE: Sun Mar 30 16:04:02 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/lista.scala.html
                    HASH: bfe1c7ef0ad052e2498a2ccfdcf33be4f3eebd6f
                    MATRIX: 739->1|864->49|1032->183|1074->210|1112->211|1164->228|1180->236|1216->251|1254->254|1270->262|1306->277|1343->279|1359->287|1393->300|1434->311|1482->324|1507->340|1546->341|1597->365|1625->366|1762->475|1791->476|1851->509|1879->510|2011->615|2039->616|2095->645|2123->646|2188->684|2216->685|2270->712|2298->713|2361->749|2389->750|2586->919|2615->920|2661->939|2689->940|2768->992|2796->993|2941->1110|2970->1111|3027->1140|3056->1141|3150->1207|3179->1208|3220->1222|3248->1223|3312->1259|3341->1260|3399->1290|3428->1291|3522->1357|3551->1358|3592->1372|3620->1373|3684->1409|3713->1410|3767->1436|3796->1437|3890->1503|3919->1504|3960->1518|3988->1519|4052->1555|4081->1556|4138->1585|4167->1586|4261->1652|4290->1653|4331->1667|4359->1668|4424->1705|4453->1706|4510->1735|4539->1736|4633->1802|4662->1803|4703->1817|4731->1818|4795->1854|4824->1855|4886->1889|4915->1890|4979->1926|5008->1927|5049->1941|5077->1942|5133->1971|5161->1972|5196->1980|5224->1981|5314->2044|5342->2045|5370->2046|5398->2047|5426->2048|5454->2049|5529->2097|5557->2098|5636->2149|5665->2150|5713->2171|5741->2172|5802->2205|5831->2206|5879->2227|5907->2228|5968->2261|5997->2262|6045->2283|6073->2284|6134->2317|6163->2318|6211->2339|6239->2340|6300->2373|6329->2374|6377->2395|6405->2396|6466->2429|6495->2430|6567->2475|6595->2476|6947->2800|6976->2801
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|48->20|48->20|50->22|50->22|55->27|55->27|58->30|58->30|62->34|62->34|64->36|64->36|66->38|66->38|69->41|69->41|71->43|71->43|73->45|73->45|77->49|77->49|78->50|78->50|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|96->68|96->68|98->70|98->70|101->73|101->73|102->74|102->74|103->75|103->75|106->78|106->78|108->80|108->80|110->82|110->82|111->83|111->83|113->85|113->85|114->86|114->86|116->88|116->88|117->89|117->89|119->91|119->91|120->92|120->92|122->94|122->94|123->95|123->95|126->98|126->98|138->110|138->110
                    -- GENERATED --
                */
            