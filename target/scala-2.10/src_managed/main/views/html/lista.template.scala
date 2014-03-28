
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
object lista extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Profesor],Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(profesores:List[Profesor], conScript:Integer=0):play.api.templates.HtmlFormat.Appendable = {
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
    
    def render(profesores:List[Profesor],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(profesores,conScript)
    
    def f:((List[Profesor],Integer) => play.api.templates.HtmlFormat.Appendable) = (profesores,conScript) => apply(profesores,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 27 21:27:43 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/lista.scala.html
                    HASH: 79d776f7831c741e3c9de53f8f6650bf7b5477fe
                    MATRIX: 790->1|932->49|1100->183|1142->210|1180->211|1232->228|1248->236|1284->251|1322->254|1338->262|1374->277|1411->279|1427->287|1461->300|1502->311|1550->324|1575->340|1614->341|1665->365|1693->366|1830->475|1859->476|1919->509|1947->510|2079->615|2107->616|2163->645|2191->646|2256->684|2284->685|2338->712|2366->713|2563->882|2592->883|2638->902|2666->903|2745->955|2773->956|2918->1073|2947->1074|3004->1103|3033->1104|3127->1170|3156->1171|3197->1185|3225->1186|3289->1222|3318->1223|3376->1253|3405->1254|3499->1320|3528->1321|3569->1335|3597->1336|3661->1372|3690->1373|3744->1399|3773->1400|3867->1466|3896->1467|3937->1481|3965->1482|4029->1518|4058->1519|4115->1548|4144->1549|4238->1615|4267->1616|4308->1630|4336->1631|4401->1668|4430->1669|4487->1698|4516->1699|4610->1765|4639->1766|4680->1780|4708->1781|4772->1817|4801->1818|4863->1852|4892->1853|4956->1889|4985->1890|5026->1904|5054->1905|5110->1934|5138->1935|5173->1943|5201->1944|5291->2007|5319->2008|5347->2009|5375->2010|5426->2034|5454->2035|5509->2063|5537->2064|5611->2111|5639->2112|5718->2163|5747->2164|5795->2185|5823->2186|5884->2219|5913->2220|5961->2241|5989->2242|6050->2275|6079->2276|6127->2297|6155->2298|6216->2331|6245->2332|6293->2353|6321->2354|6382->2387|6411->2388|6459->2409|6487->2410|6548->2443|6577->2444|6649->2489|6677->2490|7029->2814|7058->2815
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|48->20|48->20|50->22|50->22|55->27|55->27|58->30|58->30|62->34|62->34|64->36|64->36|67->39|67->39|69->41|69->41|71->43|71->43|75->47|75->47|76->48|76->48|76->48|76->48|77->49|77->49|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|94->66|94->66|96->68|96->68|99->71|99->71|100->72|100->72|102->74|102->74|105->77|105->77|107->79|107->79|109->81|109->81|111->83|111->83|112->84|112->84|114->86|114->86|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|121->93|121->93|123->95|123->95|124->96|124->96|127->99|127->99|139->111|139->111
                    -- GENERATED --
                */
            