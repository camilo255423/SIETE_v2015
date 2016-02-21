
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

$('#listaProfesores').on("change", cambioProfesor);
$('#listainformes').on("change", cambioInforme);
$('#listaProgramas').on("change", cambioPrograma);

"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""
);
function cambioInforme()
"""),format.raw/*23.1*/("""{"""),format.raw/*23.2*/("""
	if($('#listainformes').val()==5)"""),format.raw/*24.34*/("""{"""),format.raw/*24.35*/("""
			  $('#listaProfesores').hide();
			   cambioSemestre();
			  cambioProfesor();
			  """),format.raw/*28.6*/("""}"""),format.raw/*28.7*/("""
			  else
			  """),format.raw/*30.6*/("""{"""),format.raw/*30.7*/("""
			  $('#listaProfesores').show();
			  cambioSemestre();
			  cambioProfesor();
		      $("#informe").html("<div></div>");
			  """),format.raw/*35.6*/("""}"""),format.raw/*35.7*/("""


"""),format.raw/*38.1*/("""}"""),format.raw/*38.2*/("""
function cambioPrograma()
"""),format.raw/*40.1*/("""{"""),format.raw/*40.2*/("""
cambioSemestre();
cambioProfesor();
"""),format.raw/*43.1*/("""}"""),format.raw/*43.2*/("""
function cambioProfesor()
"""),format.raw/*45.1*/("""{"""),format.raw/*45.2*/("""

if($('#listasemestres').val()!=-1)
"""),format.raw/*48.1*/("""{"""),format.raw/*48.2*/("""
var documentoProfesor = $('#listaProfesores').val();
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
			$("#progressbar").progressbar("""),format.raw/*51.34*/("""{"""),format.raw/*51.35*/("""
			value:false
			"""),format.raw/*53.4*/("""}"""),format.raw/*53.5*/(""");
	if(documentoProfesor!=-1 && documentoProfesor)
	"""),format.raw/*55.2*/("""{"""),format.raw/*55.3*/("""
	
		
			enlaceDescargas($('#listaProfesores').val(),$('#listasemestres').val());
			if($('#listainformes').val()==1)"""),format.raw/*59.36*/("""{"""),format.raw/*59.37*/("""
			$.post("informeprofesor","""),format.raw/*60.29*/("""{"""),format.raw/*60.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*60.96*/("""}"""),format.raw/*60.97*/(""",mostrar);
			"""),format.raw/*61.4*/("""}"""),format.raw/*61.5*/("""
			if($('#listainformes').val()==2)"""),format.raw/*62.36*/("""{"""),format.raw/*62.37*/("""
			$.post("heteroevaluacion","""),format.raw/*63.30*/("""{"""),format.raw/*63.31*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*63.97*/("""}"""),format.raw/*63.98*/(""",mostrar);
			"""),format.raw/*64.4*/("""}"""),format.raw/*64.5*/("""
			if($('#listainformes').val()==3)"""),format.raw/*65.36*/("""{"""),format.raw/*65.37*/("""
			$.post("informefinal","""),format.raw/*66.26*/("""{"""),format.raw/*66.27*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*66.93*/("""}"""),format.raw/*66.94*/(""",mostrar);
			"""),format.raw/*67.4*/("""}"""),format.raw/*67.5*/("""
			if($('#listainformes').val()==4)"""),format.raw/*68.36*/("""{"""),format.raw/*68.37*/("""
			$.post("informefacultad","""),format.raw/*69.29*/("""{"""),format.raw/*69.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*69.96*/("""}"""),format.raw/*69.97*/(""",mostrar);
			"""),format.raw/*70.4*/("""}"""),format.raw/*70.5*/("""
	
			if($('#listainformes').val()==5)"""),format.raw/*72.36*/("""{"""),format.raw/*72.37*/("""
			 	"""),_display_(Seq[Any](/*73.7*/if(session.get("rol")==Rol.COORDINADOR)/*73.46*/{_display_(Seq[Any](format.raw/*73.47*/("""
			codigoPrograma=$('#listaProgramas').val();
			""")))}/*75.5*/else/*75.9*/{_display_(Seq[Any](format.raw/*75.10*/("""
			codigoPrograma = documentoProfesor;
			""")))})),format.raw/*77.5*/("""
			$.post("informeprograma","""),format.raw/*78.29*/("""{"""),format.raw/*78.30*/("""documento: codigoPrograma, semestre: $('#listasemestres').val()"""),format.raw/*78.93*/("""}"""),format.raw/*78.94*/(""",mostrar);
			"""),format.raw/*79.4*/("""}"""),format.raw/*79.5*/("""
			
			if($('#listainformes').val()==6)"""),format.raw/*81.36*/("""{"""),format.raw/*81.37*/("""
			$.post("informeparticipantes","""),format.raw/*82.34*/("""{"""),format.raw/*82.35*/("""semestre: $('#listasemestres').val()"""),format.raw/*82.71*/("""}"""),format.raw/*82.72*/(""",mostrar);
			"""),format.raw/*83.4*/("""}"""),format.raw/*83.5*/("""
			$("#descargas").show();
	"""),format.raw/*85.2*/("""}"""),format.raw/*85.3*/("""
	else
	"""),format.raw/*87.2*/("""{"""),format.raw/*87.3*/("""
	"""),_display_(Seq[Any](/*88.3*/if(session.get("rol")==Rol.COORDINADOR)/*88.42*/{_display_(Seq[Any](format.raw/*88.43*/("""
	documentoProfesor = $('#listaProgramas').val();
			if($('#listainformes').val()==5 && documentoProfesor!=-1 )"""),format.raw/*90.62*/("""{"""),format.raw/*90.63*/("""
				 $.post("informeprograma","""),format.raw/*91.31*/("""{"""),format.raw/*91.32*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*91.98*/("""}"""),format.raw/*91.99*/(""",mostrar);
				$("#descargas").show();
				enlaceDescargas(documentoProfesor,$('#listasemestres').val());
	            $('#listaProfesores').hide();
			
			"""),format.raw/*96.4*/("""}"""),format.raw/*96.5*/("""else"""),format.raw/*96.9*/("""{"""),format.raw/*96.10*/("""			 			 
			$("#descargas").hide();
			$("#informe").html("<div></div>");
			"""),format.raw/*99.4*/("""}"""),format.raw/*99.5*/("""
	""")))}/*100.3*/else/*100.7*/{_display_(Seq[Any](format.raw/*100.8*/("""			 			 
	$("#descargas").hide();
	$("#informe").html("<div></div>");
	""")))})),format.raw/*103.3*/("""
	
	"""),format.raw/*105.2*/("""}"""),format.raw/*105.3*/("""
"""),format.raw/*106.1*/("""}"""),format.raw/*106.2*/("""
"""),format.raw/*107.1*/("""}"""),format.raw/*107.2*/("""


</script>
""")))})))}
    }
    
    def render(profesores:List[Profesor],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(profesores,conScript)
    
    def f:((List[Profesor],Integer) => play.api.templates.HtmlFormat.Appendable) = (profesores,conScript) => apply(profesores,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Feb 21 17:17:22 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/lista.scala.html
                    HASH: f5f8753261fc938f03dc64f5014d09bb6efd5161
                    MATRIX: 790->1|932->49|1100->183|1142->210|1180->211|1232->228|1248->236|1284->251|1322->254|1338->262|1374->277|1411->279|1427->287|1461->300|1502->311|1550->324|1575->340|1614->341|1665->365|1693->366|1875->521|1903->522|1959->551|1987->552|2049->586|2078->587|2193->675|2221->676|2264->692|2292->693|2449->823|2477->824|2507->827|2535->828|2589->855|2617->856|2681->893|2709->894|2763->921|2791->922|2855->959|2883->960|3080->1129|3109->1130|3155->1149|3183->1150|3262->1202|3290->1203|3435->1320|3464->1321|3521->1350|3550->1351|3644->1417|3673->1418|3714->1432|3742->1433|3806->1469|3835->1470|3893->1500|3922->1501|4016->1567|4045->1568|4086->1582|4114->1583|4178->1619|4207->1620|4261->1646|4290->1647|4384->1713|4413->1714|4454->1728|4482->1729|4546->1765|4575->1766|4632->1795|4661->1796|4755->1862|4784->1863|4825->1877|4853->1878|4919->1916|4948->1917|4990->1924|5038->1963|5077->1964|5146->2015|5158->2019|5197->2020|5272->2064|5329->2093|5358->2094|5449->2157|5478->2158|5519->2172|5547->2173|5615->2213|5644->2214|5706->2248|5735->2249|5799->2285|5828->2286|5869->2300|5897->2301|5953->2330|5981->2331|6016->2339|6044->2340|6082->2343|6130->2382|6169->2383|6308->2494|6337->2495|6396->2526|6425->2527|6519->2593|6548->2594|6731->2750|6759->2751|6790->2755|6819->2756|6923->2833|6951->2834|6973->2837|6986->2841|7025->2842|7129->2914|7161->2918|7190->2919|7219->2920|7248->2921|7277->2922|7306->2923
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|48->20|48->20|51->23|51->23|52->24|52->24|56->28|56->28|58->30|58->30|63->35|63->35|66->38|66->38|68->40|68->40|71->43|71->43|73->45|73->45|76->48|76->48|79->51|79->51|81->53|81->53|83->55|83->55|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|93->65|93->65|94->66|94->66|94->66|94->66|95->67|95->67|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|100->72|100->72|101->73|101->73|101->73|103->75|103->75|103->75|105->77|106->78|106->78|106->78|106->78|107->79|107->79|109->81|109->81|110->82|110->82|110->82|110->82|111->83|111->83|113->85|113->85|115->87|115->87|116->88|116->88|116->88|118->90|118->90|119->91|119->91|119->91|119->91|124->96|124->96|124->96|124->96|127->99|127->99|128->100|128->100|128->100|131->103|133->105|133->105|134->106|134->106|135->107|135->107
                    -- GENERATED --
                */
            