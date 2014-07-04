
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

"""),format.raw/*19.1*/("""}"""),format.raw/*19.2*/("""
);
function cambioInforme()
"""),format.raw/*22.1*/("""{"""),format.raw/*22.2*/("""
cambioSemestre();
cambioProfesor();
"""),format.raw/*25.1*/("""}"""),format.raw/*25.2*/("""
function cambioProfesor()
"""),format.raw/*27.1*/("""{"""),format.raw/*27.2*/("""
if($('#listasemestres').val()!=-1)
"""),format.raw/*29.1*/("""{"""),format.raw/*29.2*/("""
var documentoProfesor = $('#listaProfesores').val();
	$("#informe").html("<div id='progressbar'>Cargando, por favor espere...</div>");
			$("#progressbar").progressbar("""),format.raw/*32.34*/("""{"""),format.raw/*32.35*/("""
			value:false
			"""),format.raw/*34.4*/("""}"""),format.raw/*34.5*/(""");
	if(documentoProfesor!=-1 && documentoProfesor)
	"""),format.raw/*36.2*/("""{"""),format.raw/*36.3*/("""
	
		
			enlaceDescargas($('#listaProfesores').val(),$('#listasemestres').val());
			if($('#listainformes').val()==1)"""),format.raw/*40.36*/("""{"""),format.raw/*40.37*/("""
			$.post("informeprofesor","""),format.raw/*41.29*/("""{"""),format.raw/*41.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*41.96*/("""}"""),format.raw/*41.97*/(""",mostrar);
			"""),format.raw/*42.4*/("""}"""),format.raw/*42.5*/("""
			if($('#listainformes').val()==2)"""),format.raw/*43.36*/("""{"""),format.raw/*43.37*/("""
			$.post("heteroevaluacion","""),format.raw/*44.30*/("""{"""),format.raw/*44.31*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*44.97*/("""}"""),format.raw/*44.98*/(""",mostrar);
			"""),format.raw/*45.4*/("""}"""),format.raw/*45.5*/("""
			if($('#listainformes').val()==3)"""),format.raw/*46.36*/("""{"""),format.raw/*46.37*/("""
			$.post("informefinal","""),format.raw/*47.26*/("""{"""),format.raw/*47.27*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*47.93*/("""}"""),format.raw/*47.94*/(""",mostrar);
			"""),format.raw/*48.4*/("""}"""),format.raw/*48.5*/("""
			if($('#listainformes').val()==4)"""),format.raw/*49.36*/("""{"""),format.raw/*49.37*/("""
			$.post("informefacultad","""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*50.96*/("""}"""),format.raw/*50.97*/(""",mostrar);
			"""),format.raw/*51.4*/("""}"""),format.raw/*51.5*/("""
				if($('#listainformes').val()==5)"""),format.raw/*52.37*/("""{"""),format.raw/*52.38*/("""
			$.post("informeprograma","""),format.raw/*53.29*/("""{"""),format.raw/*53.30*/("""documento: documentoProfesor, semestre: $('#listasemestres').val()"""),format.raw/*53.96*/("""}"""),format.raw/*53.97*/(""",mostrar);
			"""),format.raw/*54.4*/("""}"""),format.raw/*54.5*/("""
			if($('#listainformes').val()==6)"""),format.raw/*55.36*/("""{"""),format.raw/*55.37*/("""
			$.post("informeparticipantes","""),format.raw/*56.34*/("""{"""),format.raw/*56.35*/("""semestre: $('#listasemestres').val()"""),format.raw/*56.71*/("""}"""),format.raw/*56.72*/(""",mostrar);
			"""),format.raw/*57.4*/("""}"""),format.raw/*57.5*/("""
			$("#descargas").show();
	"""),format.raw/*59.2*/("""}"""),format.raw/*59.3*/("""
	else
	"""),format.raw/*61.2*/("""{"""),format.raw/*61.3*/("""
	$("#descargas").hide();
	$("#informe").html("<div></div>");
	"""),format.raw/*64.2*/("""}"""),format.raw/*64.3*/("""
"""),format.raw/*65.1*/("""}"""),format.raw/*65.2*/("""
"""),format.raw/*66.1*/("""}"""),format.raw/*66.2*/("""


</script>
""")))})))}
    }
    
    def render(profesores:List[Profesor],conScript:Integer): play.api.templates.HtmlFormat.Appendable = apply(profesores,conScript)
    
    def f:((List[Profesor],Integer) => play.api.templates.HtmlFormat.Appendable) = (profesores,conScript) => apply(profesores,conScript)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 04 16:10:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/lista.scala.html
                    HASH: 605538d68a461a7ed837cfd0a07507bdd29f0074
                    MATRIX: 790->1|932->49|1100->183|1142->210|1180->211|1232->228|1248->236|1284->251|1322->254|1338->262|1374->277|1411->279|1427->287|1461->300|1502->311|1550->324|1575->340|1614->341|1665->365|1693->366|1824->470|1852->471|1908->500|1936->501|2000->538|2028->539|2082->566|2110->567|2173->603|2201->604|2398->773|2427->774|2473->793|2501->794|2580->846|2608->847|2753->964|2782->965|2839->994|2868->995|2962->1061|2991->1062|3032->1076|3060->1077|3124->1113|3153->1114|3211->1144|3240->1145|3334->1211|3363->1212|3404->1226|3432->1227|3496->1263|3525->1264|3579->1290|3608->1291|3702->1357|3731->1358|3772->1372|3800->1373|3864->1409|3893->1410|3950->1439|3979->1440|4073->1506|4102->1507|4143->1521|4171->1522|4236->1559|4265->1560|4322->1589|4351->1590|4445->1656|4474->1657|4515->1671|4543->1672|4607->1708|4636->1709|4698->1743|4727->1744|4791->1780|4820->1781|4861->1795|4889->1796|4945->1825|4973->1826|5008->1834|5036->1835|5126->1898|5154->1899|5182->1900|5210->1901|5238->1902|5266->1903
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|38->10|38->10|38->10|42->14|42->14|47->19|47->19|50->22|50->22|53->25|53->25|55->27|55->27|57->29|57->29|60->32|60->32|62->34|62->34|64->36|64->36|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|71->43|71->43|72->44|72->44|72->44|72->44|73->45|73->45|74->46|74->46|75->47|75->47|75->47|75->47|76->48|76->48|77->49|77->49|78->50|78->50|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|87->59|87->59|89->61|89->61|92->64|92->64|93->65|93->65|94->66|94->66
                    -- GENERATED --
                */
            