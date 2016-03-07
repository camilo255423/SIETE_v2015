
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
	var codigoPrograma=-1;
	if($('#listasemestres').val()!=-1)
    """),format.raw/*41.5*/("""{"""),format.raw/*41.6*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	
	$("#listaProfesores").html("Cargando...");
	$("#progressbar").progressbar("""),format.raw/*45.32*/("""{"""),format.raw/*45.33*/("""
	value:false
	"""),format.raw/*47.2*/("""}"""),format.raw/*47.3*/(""");
	"""),_display_(Seq[Any](/*48.3*/if(session.get("rol")==Rol.COORDINADOR)/*48.42*/{_display_(Seq[Any](format.raw/*48.43*/("""
	codigoPrograma=$('#listaProgramas').val();
	""")))})),format.raw/*50.3*/("""
	if($('#listainformes').val()==1 || $('#listainformes').val()==2 || $('#listainformes').val()==3 ) entidad="profesores";
	if($('#listainformes').val()==4) entidad="facultades";
	if($('#listainformes').val()==5) """),format.raw/*53.35*/("""{"""),format.raw/*53.36*/(""" entidad="programas"; 
	"""),_display_(Seq[Any](/*54.3*/if(session.get("rol")==Rol.COORDINADOR)/*54.42*/{_display_(Seq[Any](format.raw/*54.43*/("""
	$.post("informeprograma","""),format.raw/*55.27*/("""{"""),format.raw/*55.28*/("""documento: codigoPrograma, semestre: $('#listasemestres').val()"""),format.raw/*55.91*/("""}"""),format.raw/*55.92*/(""",mostrar);
	""")))})),format.raw/*56.3*/("""
	 """),format.raw/*57.3*/("""}"""),format.raw/*57.4*/("""
	if($('#listainformes').val()==6) entidad="participantes";

	"""),_display_(Seq[Any](/*60.3*/if(session.get("rol")==Rol.COORDINADOR)/*60.42*/{_display_(Seq[Any](format.raw/*60.43*/("""
		if($('#listainformes').val()!=5)
		"""),format.raw/*62.3*/("""{"""),format.raw/*62.4*/("""	
		$.post("cambiosemestre","""),format.raw/*63.27*/("""{"""),format.raw/*63.28*/("""semestre: $('#listasemestres').val(), valor: entidad, codigoPrograma: codigoPrograma"""),format.raw/*63.112*/("""}"""),format.raw/*63.113*/(""",mostrarProfesores); // valor:0 profesores 1 facultades 2 programas
		$("#descargas").hide();
		"""),format.raw/*65.3*/("""}"""),format.raw/*65.4*/("""
	""")))}/*66.3*/else/*66.7*/{_display_(Seq[Any](format.raw/*66.8*/("""
		$.post("cambiosemestre","""),format.raw/*67.27*/("""{"""),format.raw/*67.28*/("""semestre: $('#listasemestres').val(), valor: entidad, codigoPrograma: codigoPrograma"""),format.raw/*67.112*/("""}"""),format.raw/*67.113*/(""",mostrarProfesores); // valor:0 profesores 1 facultades 2 programas
		$("#descargas").hide();
			
		""")))})),format.raw/*70.4*/("""
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/("""	
	""")))})),format.raw/*72.3*/("""
	function mostrarProfesores(data)
	"""),format.raw/*74.2*/("""{"""),format.raw/*74.3*/("""
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
	$("#progressbar").progressbar("""),format.raw/*76.32*/("""{"""),format.raw/*76.33*/("""
	value:false
	"""),format.raw/*78.2*/("""}"""),format.raw/*78.3*/(""");
		if(data=="participantes")
		"""),format.raw/*80.3*/("""{"""),format.raw/*80.4*/("""
		$.post("informeparticipantes","""),format.raw/*81.33*/("""{"""),format.raw/*81.34*/("""semestre: $('#listasemestres').val()"""),format.raw/*81.70*/("""}"""),format.raw/*81.71*/(""",mostrar);	
		enlaceDescargas(0,$('#listasemestres').val());
		$('#listaProfesores').hide();
		"""),format.raw/*84.3*/("""}"""),format.raw/*84.4*/("""
		else
		"""),format.raw/*86.3*/("""{"""),format.raw/*86.4*/("""
		$("#listaProfesores").html(data);
		$("#informe").html("");
		$('#listaProfesores').show();
		"""),format.raw/*90.3*/("""}"""),format.raw/*90.4*/("""
	
"""),format.raw/*92.1*/("""}"""),format.raw/*92.2*/(""" // fin-else """),_display_(Seq[Any](/*92.16*/session)),format.raw/*92.23*/("""
"""),format.raw/*93.1*/("""}"""),format.raw/*93.2*/("""

function mostrar(data)
"""),format.raw/*96.1*/("""{"""),format.raw/*96.2*/("""
$("#informe").html(data);

"""),format.raw/*99.1*/("""}"""),format.raw/*99.2*/("""
function enlaceDescargas(documento, semestre)
"""),format.raw/*101.1*/("""{"""),format.raw/*101.2*/("""
var informe = "";
if($('#listainformes').val()==1)"""),format.raw/*103.33*/("""{"""),format.raw/*103.34*/("""
informe="informe1";
"""),format.raw/*105.1*/("""}"""),format.raw/*105.2*/("""
if($('#listainformes').val()==2)"""),format.raw/*106.33*/("""{"""),format.raw/*106.34*/("""
informe="informe2";
"""),format.raw/*108.1*/("""}"""),format.raw/*108.2*/("""
if($('#listainformes').val()==3)"""),format.raw/*109.33*/("""{"""),format.raw/*109.34*/("""
informe="informe3";
"""),format.raw/*111.1*/("""}"""),format.raw/*111.2*/("""
if($('#listainformes').val()==4)"""),format.raw/*112.33*/("""{"""),format.raw/*112.34*/("""
informe="informe4";
"""),format.raw/*114.1*/("""}"""),format.raw/*114.2*/("""
if($('#listainformes').val()==5)"""),format.raw/*115.33*/("""{"""),format.raw/*115.34*/("""
informe="informe5";
"""),format.raw/*117.1*/("""}"""),format.raw/*117.2*/("""
if($('#listainformes').val()==6)"""),format.raw/*118.33*/("""{"""),format.raw/*118.34*/("""
informe="informe6";
$("#descargas").show();
"""),format.raw/*121.1*/("""}"""),format.raw/*121.2*/("""

var enlace = '';
var s =  '';

	enlace=informe+'/pdf/'+documento+'/'+semestre;
	s =  "<ul class='side'>";
	s= s+ "<li><a href='"+enlace+"'>Descargar PDF</a></li>";
	"""),_display_(Seq[Any](/*129.3*/if(session.get("rol")==Rol.COORDINADOR || session.get("rol")==Rol.ADMINISTRADOR)/*129.83*/{_display_(Seq[Any](format.raw/*129.84*/("""
	enlace = informe+'/excel/'+documento+'/'+semestre;
	s = s +  "<li><a href='"+enlace+"'>Descargar Excel</a></li>";
	s = s + "</ul>";
	""")))})),format.raw/*133.3*/("""
$("#descargas").html(s);
"""),format.raw/*135.1*/("""}"""),format.raw/*135.2*/("""
</script>"""))}
    }
    
    def render(semestres:List[String]): play.api.templates.HtmlFormat.Appendable = apply(semestres)
    
    def f:((List[String]) => play.api.templates.HtmlFormat.Appendable) = (semestres) => apply(semestres)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 06 18:39:34 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: 50d262eea133a7eaa7cbdba0da4cb4fb5b6d810e
                    MATRIX: 789->1|907->25|1032->116|1073->142|1111->143|1163->160|1192->168|1230->171|1259->179|1300->190|1361->224|1389->225|1470->279|1498->280|1555->310|1583->311|1621->314|1666->350|1705->351|1768->378|1784->385|1823->402|1897->449|1925->450|2067->564|2096->565|2138->580|2166->581|2256->643|2285->644|2380->710|2410->711|2509->782|2538->783|2633->849|2663->850|2758->917|2787->918|2882->984|2912->985|3017->1063|3045->1064|3066->1067|3078->1071|3116->1072|3222->1151|3250->1152|3438->1312|3467->1313|3509->1328|3537->1329|3577->1334|3625->1373|3664->1374|3742->1421|3982->1633|4011->1634|4071->1659|4119->1698|4158->1699|4213->1726|4242->1727|4333->1790|4362->1791|4406->1804|4436->1807|4464->1808|4562->1871|4610->1910|4649->1911|4714->1949|4742->1950|4798->1978|4827->1979|4940->2063|4970->2064|5093->2160|5121->2161|5142->2164|5154->2168|5192->2169|5247->2196|5276->2197|5389->2281|5419->2282|5551->2383|5580->2385|5608->2386|5643->2390|5706->2426|5734->2427|5876->2541|5905->2542|5947->2557|5975->2558|6035->2591|6063->2592|6124->2625|6153->2626|6217->2662|6246->2663|6368->2758|6396->2759|6433->2769|6461->2770|6585->2867|6613->2868|6643->2871|6671->2872|6721->2886|6750->2893|6778->2894|6806->2895|6858->2920|6886->2921|6941->2949|6969->2950|7044->2997|7073->2998|7153->3049|7183->3050|7232->3071|7261->3072|7323->3105|7353->3106|7402->3127|7431->3128|7493->3161|7523->3162|7572->3183|7601->3184|7663->3217|7693->3218|7742->3239|7771->3240|7833->3273|7863->3274|7912->3295|7941->3296|8003->3329|8033->3330|8106->3375|8135->3376|8339->3544|8429->3624|8469->3625|8637->3761|8691->3787|8720->3788
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|40->12|40->12|44->16|44->16|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|53->25|53->25|55->27|55->27|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|63->35|63->35|65->37|65->37|65->37|69->41|69->41|73->45|73->45|75->47|75->47|76->48|76->48|76->48|78->50|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|83->55|84->56|85->57|85->57|88->60|88->60|88->60|90->62|90->62|91->63|91->63|91->63|91->63|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|95->67|98->70|99->71|99->71|100->72|102->74|102->74|104->76|104->76|106->78|106->78|108->80|108->80|109->81|109->81|109->81|109->81|112->84|112->84|114->86|114->86|118->90|118->90|120->92|120->92|120->92|120->92|121->93|121->93|124->96|124->96|127->99|127->99|129->101|129->101|131->103|131->103|133->105|133->105|134->106|134->106|136->108|136->108|137->109|137->109|139->111|139->111|140->112|140->112|142->114|142->114|143->115|143->115|145->117|145->117|146->118|146->118|149->121|149->121|157->129|157->129|157->129|161->133|163->135|163->135
                    -- GENERATED --
                */
            