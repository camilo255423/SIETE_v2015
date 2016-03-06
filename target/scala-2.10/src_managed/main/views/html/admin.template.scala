
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
	<td>"""),_display_(Seq[Any](/*32.7*/if(permiso.getPrograma().getCodPrograma()!=null)/*32.55*/{_display_(Seq[Any](format.raw/*32.56*/("""
	"""),_display_(Seq[Any](/*33.3*/permiso/*33.10*/.getPrograma().getCodPrograma())),format.raw/*33.41*/(""" """),_display_(Seq[Any](/*33.43*/permiso/*33.50*/.getPrograma().getNombre())),format.raw/*33.76*/("""
	""")))})),format.raw/*34.3*/("""
	</td>
	<td><a href="javascript: void(0)" data-documento='"""),_display_(Seq[Any](/*36.53*/permiso/*36.60*/.getUsuario().getDocumento())),format.raw/*36.88*/("""'
	"""),_display_(Seq[Any](/*37.3*/if(permiso.getPrograma().getCodPrograma()!=null)/*37.51*/{_display_(Seq[Any](format.raw/*37.52*/("""
	 data-codigoPrograma='"""),_display_(Seq[Any](/*38.25*/permiso/*38.32*/.getPrograma().getCodPrograma())),format.raw/*38.63*/("""'
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
                    DATE: Sun Mar 06 11:27:27 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: 0f4b2e644f5db7fbadac84cbdbafd1adce083e3b
                    MATRIX: 785->1|912->34|948->36|964->44|1002->45|1532->539|1544->542|1587->563|1664->604|1676->607|1717->626|1801->674|1813->677|1860->702|1943->749|1955->752|1991->766|2061->800|2073->803|2121->829|2331->1004|2371->1028|2410->1029|2457->1041|2473->1048|2520->1073|2567->1085|2583->1092|2633->1120|2680->1132|2737->1180|2776->1181|2814->1184|2830->1191|2883->1222|2921->1224|2937->1231|2985->1257|3019->1260|3115->1320|3131->1327|3181->1355|3220->1359|3277->1407|3316->1408|3377->1433|3393->1440|3446->1471|3469->1476|3481->1480|3519->1481|3582->1513|3661->1561|3881->1745|3940->1782|4009->1815|4067->1851|4107->1860|4158->1875|4173->1881|4233->1919|4295->1945|4310->1951|4367->1986|4429->2012|4444->2018|4500->2052|4589->2113|4618->2114|4685->2145|4697->2148|4733->2162|4798->2191|4810->2194|4859->2220|4889->2223|4917->2224|5004->2284|5032->2285|5103->2320|5115->2323|5156->2342|5186->2345|5214->2346|5300->2405|5328->2406|5399->2441|5411->2444|5458->2469|5488->2472|5516->2473|5577->2507|5605->2508|5676->2543|5688->2546|5731->2567|5761->2570|5789->2571|5850->2605|5878->2606|5908->2609|5936->2610
                    LINES: 26->1|29->1|30->2|30->2|30->2|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|73->45|82->54|82->54|83->55|83->55|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|90->62|90->62|92->64|92->64|92->64|92->64|92->64|92->64|93->65|93->65|95->67|95->67|96->68|96->68|96->68|97->69|97->69|99->71|99->71|100->72|100->72|100->72|101->73|101->73|103->75|103->75|104->76|104->76|104->76|105->77|105->77|107->79|107->79|109->81|109->81
                    -- GENERATED --
                */
            