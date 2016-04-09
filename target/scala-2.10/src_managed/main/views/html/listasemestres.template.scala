
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
	"""),_display_(Seq[Any](/*48.3*/if(session.get("rol")!=Rol.ADMINISTRADOR)/*48.44*/{_display_(Seq[Any](format.raw/*48.45*/("""
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
	"""),_display_(Seq[Any](/*129.3*/if(session.get("rol")!=Rol.PROFESOR)/*129.39*/{_display_(Seq[Any](format.raw/*129.40*/("""
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
                    DATE: Sat Apr 09 15:22:15 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/listasemestres.scala.html
                    HASH: e0cf3b329028b3fc2fd7435f092ba72da582fab6
                    MATRIX: 789->1|907->25|1032->116|1073->142|1111->143|1163->160|1192->168|1230->171|1259->179|1300->190|1361->224|1389->225|1470->279|1498->280|1555->310|1583->311|1621->314|1666->350|1705->351|1768->378|1784->385|1823->402|1897->449|1925->450|2067->564|2096->565|2138->580|2166->581|2256->643|2285->644|2380->710|2410->711|2509->782|2538->783|2633->849|2663->850|2758->917|2787->918|2882->984|2912->985|3017->1063|3045->1064|3066->1067|3078->1071|3116->1072|3222->1151|3250->1152|3438->1312|3467->1313|3509->1328|3537->1329|3577->1334|3627->1375|3666->1376|3744->1423|3984->1635|4013->1636|4073->1661|4121->1700|4160->1701|4215->1728|4244->1729|4335->1792|4364->1793|4408->1806|4438->1809|4466->1810|4564->1873|4612->1912|4651->1913|4716->1951|4744->1952|4800->1980|4829->1981|4942->2065|4972->2066|5095->2162|5123->2163|5144->2166|5156->2170|5194->2171|5249->2198|5278->2199|5391->2283|5421->2284|5553->2385|5582->2387|5610->2388|5645->2392|5708->2428|5736->2429|5878->2543|5907->2544|5949->2559|5977->2560|6037->2593|6065->2594|6126->2627|6155->2628|6219->2664|6248->2665|6370->2760|6398->2761|6435->2771|6463->2772|6587->2869|6615->2870|6645->2873|6673->2874|6723->2888|6752->2895|6780->2896|6808->2897|6860->2922|6888->2923|6943->2951|6971->2952|7046->2999|7075->3000|7155->3051|7185->3052|7234->3073|7263->3074|7325->3107|7355->3108|7404->3129|7433->3130|7495->3163|7525->3164|7574->3185|7603->3186|7665->3219|7695->3220|7744->3241|7773->3242|7835->3275|7865->3276|7914->3297|7943->3298|8005->3331|8035->3332|8108->3377|8137->3378|8341->3546|8387->3582|8427->3583|8595->3719|8649->3745|8678->3746
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|40->12|40->12|44->16|44->16|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|53->25|53->25|55->27|55->27|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|63->35|63->35|65->37|65->37|65->37|69->41|69->41|73->45|73->45|75->47|75->47|76->48|76->48|76->48|78->50|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|83->55|84->56|85->57|85->57|88->60|88->60|88->60|90->62|90->62|91->63|91->63|91->63|91->63|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|95->67|98->70|99->71|99->71|100->72|102->74|102->74|104->76|104->76|106->78|106->78|108->80|108->80|109->81|109->81|109->81|109->81|112->84|112->84|114->86|114->86|118->90|118->90|120->92|120->92|120->92|120->92|121->93|121->93|124->96|124->96|127->99|127->99|129->101|129->101|131->103|131->103|133->105|133->105|134->106|134->106|136->108|136->108|137->109|137->109|139->111|139->111|140->112|140->112|142->114|142->114|143->115|143->115|145->117|145->117|146->118|146->118|149->121|149->121|157->129|157->129|157->129|161->133|163->135|163->135
                    -- GENERATED --
                */
            