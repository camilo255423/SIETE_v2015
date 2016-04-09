
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
object admin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Permiso],Rol,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(permisos:List[Permiso], rol:Rol):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.35*/("""
"""),_display_(Seq[Any](/*2.2*/main("")/*2.10*/{_display_(Seq[Any](format.raw/*2.11*/("""
<div class="tabs" style="position: absolute; left: 300px;">
		<ul>
			<li><a href="#tabs-admin">Administración de Permisos</a></li>
		</ul>
 	<div id="tabs-admin">      

<table id="tabla">
<tr>
<td><b>Usuario</b></td><td><b>Rol</b></td><td><b>Permiso</b></td><td><b>Operación</b></td>
</tr>
<tr>
<td width='220'><input id='inputusuario' name="location" class="autocomplete-relation" data-url='autocompleteLabel' size='40'/></td>
<td><select name="listaroles" id='listaroles'>
<option value='"""),_display_(Seq[Any](/*16.17*/rol/*16.20*/.getAdministradorId())),format.raw/*16.41*/("""'>ADMINISTRADOR</option>
<option value='"""),_display_(Seq[Any](/*17.17*/rol/*17.20*/.getCoordinadorId())),format.raw/*17.39*/("""'>DIRECTOR DE PROGRAMA</option>
<option value='"""),_display_(Seq[Any](/*18.17*/rol/*18.20*/.getCoordinadorDeAreaId())),format.raw/*18.45*/("""'>COORDINADOR DE AREA</option>
<option value='"""),_display_(Seq[Any](/*19.17*/rol/*19.20*/.getDecanoId())),format.raw/*19.34*/("""'>DECANO</option>
<option value='"""),_display_(Seq[Any](/*20.17*/rol/*20.20*/.getSecretariaFacultadId())),format.raw/*20.46*/("""'>SECRETARIA FACULTAD</option>
</select></td>
<td><b>
<div id="listaPermisos"></div></b></td>
<td><a href="javascript: void(0)" 
	 id="adicionar"
	 >Adicionar</a></td>
</tr>
"""),_display_(Seq[Any](/*28.2*/for(permiso <- permisos) yield /*28.26*/{_display_(Seq[Any](format.raw/*28.27*/("""
<tr>
	<td>"""),_display_(Seq[Any](/*30.7*/permiso/*30.14*/.getUsuario().getNombre())),format.raw/*30.39*/("""</td>
	<td>"""),_display_(Seq[Any](/*31.7*/permiso/*31.14*/.getUsuario().getNombreRol())),format.raw/*31.42*/("""</td>
	<td>"""),_display_(Seq[Any](/*32.7*/if(permiso.getCodigoPermiso()!=0)/*32.40*/{_display_(Seq[Any](format.raw/*32.41*/("""
	"""),_display_(Seq[Any](/*33.3*/permiso/*33.10*/.getCodigoPermiso())),format.raw/*33.29*/(""" """),_display_(Seq[Any](/*33.31*/permiso/*33.38*/.getNombrePermiso())),format.raw/*33.57*/("""
	""")))})),format.raw/*34.3*/("""
	</td>
	<td><a href="javascript: void(0)" data-documento='"""),_display_(Seq[Any](/*36.53*/permiso/*36.60*/.getUsuario().getDocumento())),format.raw/*36.88*/("""'
	"""),_display_(Seq[Any](/*37.3*/if(permiso.getCodigoPermiso!=0)/*37.34*/{_display_(Seq[Any](format.raw/*37.35*/("""
	 data-codigoPrograma='"""),_display_(Seq[Any](/*38.25*/permiso/*38.32*/.getCodigoPermiso())),format.raw/*38.51*/("""'
	 """)))}/*39.4*/else/*39.8*/{_display_(Seq[Any](format.raw/*39.9*/("""
	 	 data-codigoPrograma='0'
	 """)))})),format.raw/*41.4*/("""
	 class="eliminar"
	 >Eliminar</a></td>
</tr>
""")))})),format.raw/*45.2*/("""
</table>
</div><!-- tab admin -->
</div><!-- tabs -->
<div id="errorDialog" title="Error">
</div>
<div id="confirmDialog" title="Eliminar Permiso">
</div>

<div id="listaDeFacultades">"""),_display_(Seq[Any](/*54.30*/listafacultades(Facultad.findAll(),0))),format.raw/*54.67*/("""</div>
<div id="listaDeProgramas">"""),_display_(Seq[Any](/*55.29*/listaprogramas(Programa.findAll(),0))),format.raw/*55.65*/("""</div>
<div id="listaDeAreas">"""),_display_(Seq[Any](/*56.25*/listaareas(Area.findAll(),0))),format.raw/*56.53*/("""</div>

""")))})),format.raw/*58.2*/("""
<script src=""""),_display_(Seq[Any](/*59.15*/routes/*59.21*/.Assets.at("js/admin/autocomplete.js"))),format.raw/*59.59*/(""""></script>
<script src=""""),_display_(Seq[Any](/*60.15*/routes/*60.21*/.Assets.at("js/admin/adminCrud.js"))),format.raw/*60.56*/(""""></script>
<script src=""""),_display_(Seq[Any](/*61.15*/routes/*61.21*/.Assets.at("js/admin/adminGUI.js"))),format.raw/*61.55*/(""""></script>
<script>
$('#listaroles').on('change', function()"""),format.raw/*63.41*/("""{"""),format.raw/*63.42*/("""

	if($('#listaroles').val()=="""),_display_(Seq[Any](/*65.30*/rol/*65.33*/.getDecanoId())),format.raw/*65.47*/(""" || $('#listaroles').val()=="""),_display_(Seq[Any](/*65.76*/rol/*65.79*/.getSecretariaFacultadId())),format.raw/*65.105*/(""")
	"""),format.raw/*66.2*/("""{"""),format.raw/*66.3*/("""
		$('#listaPermisos').html($('#listaDeFacultades').html());
	"""),format.raw/*68.2*/("""}"""),format.raw/*68.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*69.35*/rol/*69.38*/.getCoordinadorId())),format.raw/*69.57*/(""")
	"""),format.raw/*70.2*/("""{"""),format.raw/*70.3*/("""
		$('#listaPermisos').html($('#listaDeProgramas').html());
	"""),format.raw/*72.2*/("""}"""),format.raw/*72.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*73.35*/rol/*73.38*/.getCoordinadorDeAreaId())),format.raw/*73.63*/(""")
	"""),format.raw/*74.2*/("""{"""),format.raw/*74.3*/("""
		$('#listaPermisos').html($('#listaDeAreas').html());
	"""),format.raw/*76.2*/("""}"""),format.raw/*76.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*77.35*/rol/*77.38*/.getAdministradorId())),format.raw/*77.59*/(""")
	"""),format.raw/*78.2*/("""{"""),format.raw/*78.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*80.2*/("""}"""),format.raw/*80.3*/("""
	
"""),format.raw/*82.1*/("""}"""),format.raw/*82.2*/("""
);


$( ".tabs" ).tabs();

</script>
"""))}
    }
    
    def render(permisos:List[Permiso],rol:Rol): play.api.templates.HtmlFormat.Appendable = apply(permisos,rol)
    
    def f:((List[Permiso],Rol) => play.api.templates.HtmlFormat.Appendable) = (permisos,rol) => apply(permisos,rol)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 09 12:16:51 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: f088b7a0477aa1e8e9d5d3f5a68ee1ea6f2fc469
                    MATRIX: 785->1|912->34|948->36|964->44|1002->45|1532->539|1544->542|1587->563|1664->604|1676->607|1717->626|1801->674|1813->677|1860->702|1943->749|1955->752|1991->766|2061->800|2073->803|2121->829|2331->1004|2371->1028|2410->1029|2457->1041|2473->1048|2520->1073|2567->1085|2583->1092|2633->1120|2680->1132|2722->1165|2761->1166|2799->1169|2815->1176|2856->1195|2894->1197|2910->1204|2951->1223|2985->1226|3081->1286|3097->1293|3147->1321|3186->1325|3226->1356|3265->1357|3326->1382|3342->1389|3383->1408|3406->1413|3418->1417|3456->1418|3519->1450|3598->1498|3820->1684|3879->1721|3950->1756|4008->1792|4075->1823|4125->1851|4165->1860|4216->1875|4231->1881|4291->1919|4353->1945|4368->1951|4425->1986|4487->2012|4502->2018|4558->2052|4647->2113|4676->2114|4743->2145|4755->2148|4791->2162|4856->2191|4868->2194|4917->2220|4947->2223|4975->2224|5064->2286|5092->2287|5163->2322|5175->2325|5216->2344|5246->2347|5274->2348|5362->2409|5390->2410|5461->2445|5473->2448|5520->2473|5550->2476|5578->2477|5662->2534|5690->2535|5761->2570|5773->2573|5816->2594|5846->2597|5874->2598|5935->2632|5963->2633|5993->2636|6021->2637
                    LINES: 26->1|29->1|30->2|30->2|30->2|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|73->45|82->54|82->54|83->55|83->55|84->56|84->56|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|91->63|91->63|93->65|93->65|93->65|93->65|93->65|93->65|94->66|94->66|96->68|96->68|97->69|97->69|97->69|98->70|98->70|100->72|100->72|101->73|101->73|101->73|102->74|102->74|104->76|104->76|105->77|105->77|105->77|106->78|106->78|108->80|108->80|110->82|110->82
                    -- GENERATED --
                */
            