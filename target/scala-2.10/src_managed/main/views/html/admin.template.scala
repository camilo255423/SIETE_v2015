
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
<script>
$('#listaFacultades').hide();
$('#listaProgramas').hide();


$('form').submit(function() """),format.raw/*64.29*/("""{"""),format.raw/*64.30*/("""
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
"""),format.raw/*66.1*/("""}"""),format.raw/*66.2*/(""");
$('#adicionar').on("click",function()
"""),format.raw/*68.1*/("""{"""),format.raw/*68.2*/("""
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	"""),format.raw/*78.2*/("""{"""),format.raw/*78.3*/("""
	documento=$('#nuevodocumento').val();
		if($('#listaProgramas').css('display')!='none')
		"""),format.raw/*81.3*/("""{"""),format.raw/*81.4*/("""
			
			if($('#listaProgramas').val()=='-1')
			"""),format.raw/*84.4*/("""{"""),format.raw/*84.5*/("""
		
		    $("#errorDialog").dialog("""),format.raw/*86.32*/("""{"""),format.raw/*86.33*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*89.18*/("""{"""),format.raw/*89.19*/("""
		        Aceptar: function() """),format.raw/*90.31*/("""{"""),format.raw/*90.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*92.11*/("""}"""),format.raw/*92.12*/("""
		      """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/("""
		    """),format.raw/*94.7*/("""}"""),format.raw/*94.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un programa.</p>");
			error=1;
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/("""
			else
			"""),format.raw/*99.4*/("""{"""),format.raw/*99.5*/("""
			codigoPrograma = $('#listaProgramas').val();
			nombrePrograma = $('#listaProgramas option:selected').text();
			"""),format.raw/*102.4*/("""}"""),format.raw/*102.5*/("""
		"""),format.raw/*103.3*/("""}"""),format.raw/*103.4*/("""
	"""),format.raw/*104.2*/("""}"""),format.raw/*104.3*/("""
	else
	"""),format.raw/*106.2*/("""{"""),format.raw/*106.3*/("""
		$("#errorDialog").dialog("""),format.raw/*107.28*/("""{"""),format.raw/*107.29*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*110.18*/("""{"""),format.raw/*110.19*/("""
		        Aceptar: function() """),format.raw/*111.31*/("""{"""),format.raw/*111.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*113.11*/("""}"""),format.raw/*113.12*/("""
		      """),format.raw/*114.9*/("""}"""),format.raw/*114.10*/("""
		    """),format.raw/*115.7*/("""}"""),format.raw/*115.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un usuario.</p>");
		error=1;
	"""),format.raw/*118.2*/("""}"""),format.raw/*118.3*/("""
	if(error==0)
	"""),format.raw/*120.2*/("""{"""),format.raw/*120.3*/("""
	nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' data-codigoPrograma='"+codigoPrograma+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$.post("insertarpermiso","""),format.raw/*124.27*/("""{"""),format.raw/*124.28*/("""documento: documento, idRol: idRol, codigoPrograma: codigoPrograma"""),format.raw/*124.94*/("""}"""),format.raw/*124.95*/(""", adicionar);
	"""),format.raw/*125.2*/("""}"""),format.raw/*125.3*/("""
"""),format.raw/*126.1*/("""}"""),format.raw/*126.2*/("""
);
$('#listaProgramas').hide();

$('#nuevodocumento').val('-1');

$('#listaroles').on('change', function()"""),format.raw/*132.41*/("""{"""),format.raw/*132.42*/("""

	if($('#listaroles').val()=="""),_display_(Seq[Any](/*134.30*/rol/*134.33*/.getDecanoId())),format.raw/*134.47*/(""" || $('#listaroles').val()=="""),_display_(Seq[Any](/*134.76*/rol/*134.79*/.getSecretariaFacultadId())),format.raw/*134.105*/(""")
	"""),format.raw/*135.2*/("""{"""),format.raw/*135.3*/("""
		$('#listaPermisos').html($('#listaFacultades').html());
	"""),format.raw/*137.2*/("""}"""),format.raw/*137.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*138.35*/rol/*138.38*/.getCoordinadorId())),format.raw/*138.57*/(""")
	"""),format.raw/*139.2*/("""{"""),format.raw/*139.3*/("""
		$('#listaPermisos').html($('#listaProgramas').html());
	"""),format.raw/*141.2*/("""}"""),format.raw/*141.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*142.35*/rol/*142.38*/.getCoordinadorDeAreaId())),format.raw/*142.63*/(""")
	"""),format.raw/*143.2*/("""{"""),format.raw/*143.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*145.2*/("""}"""),format.raw/*145.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*146.35*/rol/*146.38*/.getAdministradorId())),format.raw/*146.59*/(""")
	"""),format.raw/*147.2*/("""{"""),format.raw/*147.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*149.2*/("""}"""),format.raw/*149.3*/("""
	
"""),format.raw/*151.1*/("""}"""),format.raw/*151.2*/("""
);
$('.eliminar').on("click",eliminar);

function eliminar()"""),format.raw/*155.20*/("""{"""),format.raw/*155.21*/("""
  var documento = $(this).attr('data-documento');
  var codPrograma = $(this).attr('data-codigoPrograma');
	fila = $(this);


	$( "#confirmDialog" ).dialog("""),format.raw/*161.31*/("""{"""),format.raw/*161.32*/("""
      resizable: false,
      height:240,
      modal: true,
      buttons: """),format.raw/*165.16*/("""{"""),format.raw/*165.17*/("""
        Eliminar: function() """),format.raw/*166.30*/("""{"""),format.raw/*166.31*/("""
        
        $.post("borrarpermiso","""),format.raw/*168.32*/("""{"""),format.raw/*168.33*/("""documento: documento, codPrograma: codPrograma"""),format.raw/*168.79*/("""}"""),format.raw/*168.80*/(""", borrar); 
          $( this ).dialog( "close" );
        """),format.raw/*170.9*/("""}"""),format.raw/*170.10*/(""",
        Cancelar: function() """),format.raw/*171.30*/("""{"""),format.raw/*171.31*/("""
          $( this ).dialog( "close" );
        """),format.raw/*173.9*/("""}"""),format.raw/*173.10*/("""
      """),format.raw/*174.7*/("""}"""),format.raw/*174.8*/("""
    """),format.raw/*175.5*/("""}"""),format.raw/*175.6*/(""");
    $("#confirmDialog").html("<p>Va a Eliminar este permiso.</p>");
  

"""),format.raw/*179.1*/("""}"""),format.raw/*179.2*/("""

function borrar(data)
"""),format.raw/*182.1*/("""{"""),format.raw/*182.2*/("""
if(data=="ok")
"""),format.raw/*184.1*/("""{"""),format.raw/*184.2*/("""
fila.parent().parent().remove();
"""),format.raw/*186.1*/("""}"""),format.raw/*186.2*/("""

else
"""),format.raw/*189.1*/("""{"""),format.raw/*189.2*/("""
alert("No se pudo eliminar el registro de la base de datos. ");
"""),format.raw/*191.1*/("""}"""),format.raw/*191.2*/("""
"""),format.raw/*192.1*/("""}"""),format.raw/*192.2*/("""

function adicionar(data)
"""),format.raw/*195.1*/("""{"""),format.raw/*195.2*/("""
if(data=="ok")
"""),format.raw/*197.1*/("""{"""),format.raw/*197.2*/("""
var $x=$(nuevaFila); 
$("#tabla").append($x);
$x.find("a").on("click",eliminar);
"""),format.raw/*201.1*/("""}"""),format.raw/*201.2*/("""
else if (data=="duplicado")
"""),format.raw/*203.1*/("""{"""),format.raw/*203.2*/("""
alert("El usuario ya tiene un permiso asignado para este programa o ya está como administrador del sistema. ");
"""),format.raw/*205.1*/("""}"""),format.raw/*205.2*/("""
else
"""),format.raw/*207.1*/("""{"""),format.raw/*207.2*/("""
alert("No se pudo insertar el registro en la base de datos. ");
"""),format.raw/*209.1*/("""}"""),format.raw/*209.2*/("""
$('#listaroles').val('1');
$('#inputusuario').val('');
$('#listaProgramas').val('1');
$('#listaProgramas').hide();
"""),format.raw/*214.1*/("""}"""),format.raw/*214.2*/("""

$( ".tabs" ).tabs();

</script>"""))}
    }
    
    def render(permisos:List[Permiso],rol:Rol): play.api.templates.HtmlFormat.Appendable = apply(permisos,rol)
    
    def f:((List[Permiso],Rol) => play.api.templates.HtmlFormat.Appendable) = (permisos,rol) => apply(permisos,rol)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Feb 21 18:44:05 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: e9bf5cc53585c2a07d2e9e7b5a1a518c2abf37f4
                    MATRIX: 785->1|912->34|948->36|964->44|1002->45|1532->539|1544->542|1587->563|1664->604|1676->607|1717->626|1801->674|1813->677|1860->702|1943->749|1955->752|1991->766|2061->800|2073->803|2121->829|2331->1004|2371->1028|2410->1029|2457->1041|2473->1048|2520->1073|2567->1085|2583->1092|2633->1120|2680->1132|2737->1180|2776->1181|2814->1184|2830->1191|2883->1222|2921->1224|2937->1231|2985->1257|3019->1260|3115->1320|3131->1327|3181->1355|3220->1359|3277->1407|3316->1408|3377->1433|3393->1440|3446->1471|3469->1476|3481->1480|3519->1481|3582->1513|3661->1561|3881->1745|3940->1782|4009->1815|4067->1851|4107->1860|4158->1875|4173->1881|4233->1919|4371->2029|4400->2030|4505->2108|4533->2109|4601->2150|4629->2151|4899->2394|4927->2395|5046->2487|5074->2488|5149->2536|5177->2537|5240->2572|5269->2573|5372->2648|5401->2649|5460->2680|5489->2681|5569->2733|5598->2734|5634->2743|5663->2744|5697->2751|5725->2752|5840->2840|5868->2841|5907->2853|5935->2854|6080->2971|6109->2972|6140->2975|6169->2976|6199->2978|6228->2979|6264->2987|6293->2988|6350->3016|6380->3017|6484->3092|6514->3093|6574->3124|6604->3125|6685->3177|6715->3178|6752->3187|6782->3188|6817->3195|6846->3196|6958->3280|6987->3281|7031->3297|7060->3298|7357->3566|7387->3567|7482->3633|7512->3634|7555->3649|7584->3650|7613->3651|7642->3652|7778->3759|7808->3760|7876->3791|7889->3794|7926->3808|7992->3837|8005->3840|8055->3866|8086->3869|8115->3870|8203->3930|8232->3931|8304->3966|8317->3969|8359->3988|8390->3991|8419->3992|8506->4051|8535->4052|8607->4087|8620->4090|8668->4115|8699->4118|8728->4119|8790->4153|8819->4154|8891->4189|8904->4192|8948->4213|8979->4216|9008->4217|9070->4251|9099->4252|9130->4255|9159->4256|9249->4317|9279->4318|9465->4475|9495->4476|9601->4553|9631->4554|9690->4584|9720->4585|9790->4626|9820->4627|9895->4673|9925->4674|10012->4733|10042->4734|10102->4765|10132->4766|10208->4814|10238->4815|10273->4822|10302->4823|10335->4828|10364->4829|10467->4904|10496->4905|10548->4929|10577->4930|10621->4946|10650->4947|10712->4981|10741->4982|10776->4989|10805->4990|10898->5055|10927->5056|10956->5057|10985->5058|11040->5085|11069->5086|11113->5102|11142->5103|11252->5185|11281->5186|11338->5215|11367->5216|11508->5329|11537->5330|11571->5336|11600->5337|11693->5402|11722->5403|11866->5519|11895->5520
                    LINES: 26->1|29->1|30->2|30->2|30->2|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|73->45|82->54|82->54|83->55|83->55|85->57|86->58|86->58|86->58|92->64|92->64|94->66|94->66|96->68|96->68|106->78|106->78|109->81|109->81|112->84|112->84|114->86|114->86|117->89|117->89|118->90|118->90|120->92|120->92|121->93|121->93|122->94|122->94|125->97|125->97|127->99|127->99|130->102|130->102|131->103|131->103|132->104|132->104|134->106|134->106|135->107|135->107|138->110|138->110|139->111|139->111|141->113|141->113|142->114|142->114|143->115|143->115|146->118|146->118|148->120|148->120|152->124|152->124|152->124|152->124|153->125|153->125|154->126|154->126|160->132|160->132|162->134|162->134|162->134|162->134|162->134|162->134|163->135|163->135|165->137|165->137|166->138|166->138|166->138|167->139|167->139|169->141|169->141|170->142|170->142|170->142|171->143|171->143|173->145|173->145|174->146|174->146|174->146|175->147|175->147|177->149|177->149|179->151|179->151|183->155|183->155|189->161|189->161|193->165|193->165|194->166|194->166|196->168|196->168|196->168|196->168|198->170|198->170|199->171|199->171|201->173|201->173|202->174|202->174|203->175|203->175|207->179|207->179|210->182|210->182|212->184|212->184|214->186|214->186|217->189|217->189|219->191|219->191|220->192|220->192|223->195|223->195|225->197|225->197|229->201|229->201|231->203|231->203|233->205|233->205|235->207|235->207|237->209|237->209|242->214|242->214
                    -- GENERATED --
                */
            