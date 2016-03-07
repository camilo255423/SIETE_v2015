
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

<div id="listaFacultades">"""),_display_(Seq[Any](/*54.28*/listafacultades(Facultad.findAll(),0))),format.raw/*54.65*/("""</div>
<div id="listaProgramas">"""),_display_(Seq[Any](/*55.27*/listaprogramas(Programa.findAll(),0))),format.raw/*55.63*/("""</div>

""")))})),format.raw/*57.2*/("""
<script src=""""),_display_(Seq[Any](/*58.15*/routes/*58.21*/.Assets.at("js/admin/autocomplete.js"))),format.raw/*58.59*/(""""></script>
<script src=""""),_display_(Seq[Any](/*59.15*/routes/*59.21*/.Assets.at("js/admin/adminCrud.js"))),format.raw/*59.56*/(""""></script>
<script src=""""),_display_(Seq[Any](/*60.15*/routes/*60.21*/.Assets.at("js/admin/adminGUI.js"))),format.raw/*60.55*/(""""></script>
<script>
$('#listaroles').on('change', function()"""),format.raw/*62.41*/("""{"""),format.raw/*62.42*/("""

	if($('#listaroles').val()=="""),_display_(Seq[Any](/*64.30*/rol/*64.33*/.getDecanoId())),format.raw/*64.47*/(""" || $('#listaroles').val()=="""),_display_(Seq[Any](/*64.76*/rol/*64.79*/.getSecretariaFacultadId())),format.raw/*64.105*/(""")
	"""),format.raw/*65.2*/("""{"""),format.raw/*65.3*/("""
		$('#listaPermisos').html($('#listaFacultades').html());
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*68.35*/rol/*68.38*/.getCoordinadorId())),format.raw/*68.57*/(""")
	"""),format.raw/*69.2*/("""{"""),format.raw/*69.3*/("""
		$('#listaPermisos').html($('#listaProgramas').html());
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*72.35*/rol/*72.38*/.getCoordinadorDeAreaId())),format.raw/*72.63*/(""")
	"""),format.raw/*73.2*/("""{"""),format.raw/*73.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*75.2*/("""}"""),format.raw/*75.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*76.35*/rol/*76.38*/.getAdministradorId())),format.raw/*76.59*/(""")
	"""),format.raw/*77.2*/("""{"""),format.raw/*77.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*79.2*/("""}"""),format.raw/*79.3*/("""
	
"""),format.raw/*81.1*/("""}"""),format.raw/*81.2*/("""
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
                    DATE: Sun Mar 06 19:01:17 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: 78142edace31adeb6b4e24d57793d6f90da642ce
                    MATRIX: 785->1|912->34|948->36|964->44|1002->45|1532->539|1544->542|1587->563|1664->604|1676->607|1717->626|1801->674|1813->677|1860->702|1943->749|1955->752|1991->766|2061->800|2073->803|2121->829|2331->1004|2371->1028|2410->1029|2457->1041|2473->1048|2520->1073|2567->1085|2583->1092|2633->1120|2680->1132|2722->1165|2761->1166|2799->1169|2815->1176|2856->1195|2894->1197|2910->1204|2951->1223|2985->1226|3081->1286|3097->1293|3147->1321|3186->1325|3226->1356|3265->1357|3326->1382|3342->1389|3383->1408|3406->1413|3418->1417|3456->1418|3519->1450|3598->1498|3818->1682|3877->1719|3946->1752|4004->1788|4044->1797|4095->1812|4110->1818|4170->1856|4232->1882|4247->1888|4304->1923|4366->1949|4381->1955|4437->1989|4526->2050|4555->2051|4622->2082|4634->2085|4670->2099|4735->2128|4747->2131|4796->2157|4826->2160|4854->2161|4941->2221|4969->2222|5040->2257|5052->2260|5093->2279|5123->2282|5151->2283|5237->2342|5265->2343|5336->2378|5348->2381|5395->2406|5425->2409|5453->2410|5514->2444|5542->2445|5613->2480|5625->2483|5668->2504|5698->2507|5726->2508|5787->2542|5815->2543|5845->2546|5873->2547
                    LINES: 26->1|29->1|30->2|30->2|30->2|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|73->45|82->54|82->54|83->55|83->55|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|90->62|90->62|92->64|92->64|92->64|92->64|92->64|92->64|93->65|93->65|95->67|95->67|96->68|96->68|96->68|97->69|97->69|99->71|99->71|100->72|100->72|100->72|101->73|101->73|103->75|103->75|104->76|104->76|104->76|105->77|105->77|107->79|107->79|109->81|109->81
                    -- GENERATED --
                */
            