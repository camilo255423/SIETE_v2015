
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
<td><b>Usuario</b></td><td><b>Rol</b></td><td><b>Programa</b></td><td><b>Operación</b></td>
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
<script>
$('#listaFacultades').hide();
$('#listaProgramas').hide();

$('input.autocomplete-relation').each( function() """),format.raw/*62.51*/("""{"""),format.raw/*62.52*/("""
   var $input = $(this);

   
   var controlName = $input.attr('name');
   var $hidden = $('<input type="hidden" id="nuevodocumento" />').attr('name', controlName);
   $input.after($hidden).attr('name', controlName + '_label');

   // autocomplete
   var serverUrl = $input.data('url');
   $(this).autocomplete("""),format.raw/*72.25*/("""{"""),format.raw/*72.26*/("""
      source: serverUrl,
      focus: function(event, ui) """),format.raw/*74.34*/("""{"""),format.raw/*74.35*/("""
         // Set the text input value to the focused item's label, instead of the value.
         $input.val(ui.item.label);
         return false;
      """),format.raw/*78.7*/("""}"""),format.raw/*78.8*/(""",
      select: function(event, ui) """),format.raw/*79.35*/("""{"""),format.raw/*79.36*/("""
         // Save the selection item and value in the two inputs.
         $input.val(ui.item.label);
         $hidden.val(ui.item.value);
         
         return false;
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/("""
   """),format.raw/*86.4*/("""}"""),format.raw/*86.5*/(""");
"""),format.raw/*87.1*/("""}"""),format.raw/*87.2*/(""");
$('#inputusuario').on('keydown',function(e)
"""),format.raw/*89.1*/("""{"""),format.raw/*89.2*/("""
var code = e.which; 
    if(code==13) e.preventDefault();
    if(code!=32 && code!=13 && code!=188 && code!=186)"""),format.raw/*92.55*/("""{"""),format.raw/*92.56*/("""
      $('#nuevodocumento').val("-1");  
    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""" 

"""),format.raw/*96.1*/("""}"""),format.raw/*96.2*/("""	
);
$('form').submit(function() """),format.raw/*98.29*/("""{"""),format.raw/*98.30*/("""
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
"""),format.raw/*100.1*/("""}"""),format.raw/*100.2*/(""");
$('#adicionar').on("click",function()
"""),format.raw/*102.1*/("""{"""),format.raw/*102.2*/("""
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	"""),format.raw/*112.2*/("""{"""),format.raw/*112.3*/("""
	documento=$('#nuevodocumento').val();
		if($('#listaProgramas').css('display')!='none')
		"""),format.raw/*115.3*/("""{"""),format.raw/*115.4*/("""
			
			if($('#listaProgramas').val()=='-1')
			"""),format.raw/*118.4*/("""{"""),format.raw/*118.5*/("""
		
		    $("#errorDialog").dialog("""),format.raw/*120.32*/("""{"""),format.raw/*120.33*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*123.18*/("""{"""),format.raw/*123.19*/("""
		        Aceptar: function() """),format.raw/*124.31*/("""{"""),format.raw/*124.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*126.11*/("""}"""),format.raw/*126.12*/("""
		      """),format.raw/*127.9*/("""}"""),format.raw/*127.10*/("""
		    """),format.raw/*128.7*/("""}"""),format.raw/*128.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un programa.</p>");
			error=1;
			"""),format.raw/*131.4*/("""}"""),format.raw/*131.5*/("""
			else
			"""),format.raw/*133.4*/("""{"""),format.raw/*133.5*/("""
			codigoPrograma = $('#listaProgramas').val();
			nombrePrograma = $('#listaProgramas option:selected').text();
			"""),format.raw/*136.4*/("""}"""),format.raw/*136.5*/("""
		"""),format.raw/*137.3*/("""}"""),format.raw/*137.4*/("""
	"""),format.raw/*138.2*/("""}"""),format.raw/*138.3*/("""
	else
	"""),format.raw/*140.2*/("""{"""),format.raw/*140.3*/("""
		$("#errorDialog").dialog("""),format.raw/*141.28*/("""{"""),format.raw/*141.29*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*144.18*/("""{"""),format.raw/*144.19*/("""
		        Aceptar: function() """),format.raw/*145.31*/("""{"""),format.raw/*145.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*147.11*/("""}"""),format.raw/*147.12*/("""
		      """),format.raw/*148.9*/("""}"""),format.raw/*148.10*/("""
		    """),format.raw/*149.7*/("""}"""),format.raw/*149.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un usuario.</p>");
		error=1;
	"""),format.raw/*152.2*/("""}"""),format.raw/*152.3*/("""
	if(error==0)
	"""),format.raw/*154.2*/("""{"""),format.raw/*154.3*/("""
	nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' data-codigoPrograma='"+codigoPrograma+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$.post("insertarpermiso","""),format.raw/*158.27*/("""{"""),format.raw/*158.28*/("""documento: documento, idRol: idRol, codigoPrograma: codigoPrograma"""),format.raw/*158.94*/("""}"""),format.raw/*158.95*/(""", adicionar);
	"""),format.raw/*159.2*/("""}"""),format.raw/*159.3*/("""
"""),format.raw/*160.1*/("""}"""),format.raw/*160.2*/("""
);
$('#listaProgramas').hide();

$('#nuevodocumento').val('-1');

$('#listaroles').on('change', function()"""),format.raw/*166.41*/("""{"""),format.raw/*166.42*/("""

	if($('#listaroles').val()=="""),_display_(Seq[Any](/*168.30*/rol/*168.33*/.getDecanoId())),format.raw/*168.47*/(""" || $('#listaroles').val()=="""),_display_(Seq[Any](/*168.76*/rol/*168.79*/.getSecretariaFacultadId())),format.raw/*168.105*/(""")
	"""),format.raw/*169.2*/("""{"""),format.raw/*169.3*/("""
		$('#listaPermisos').html($('#listaFacultades').html());
	"""),format.raw/*171.2*/("""}"""),format.raw/*171.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*172.35*/rol/*172.38*/.getCoordinadorId())),format.raw/*172.57*/(""")
	"""),format.raw/*173.2*/("""{"""),format.raw/*173.3*/("""
		$('#listaPermisos').html($('#listaProgramas').html());
	"""),format.raw/*175.2*/("""}"""),format.raw/*175.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*176.35*/rol/*176.38*/.getCoordinadorDeAreaId())),format.raw/*176.63*/(""")
	"""),format.raw/*177.2*/("""{"""),format.raw/*177.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*179.2*/("""}"""),format.raw/*179.3*/("""
	else if($('#listaroles').val()=="""),_display_(Seq[Any](/*180.35*/rol/*180.38*/.getAdministradorId())),format.raw/*180.59*/(""")
	"""),format.raw/*181.2*/("""{"""),format.raw/*181.3*/("""
		$('#listaPermisos').html('');
	"""),format.raw/*183.2*/("""}"""),format.raw/*183.3*/("""
	
"""),format.raw/*185.1*/("""}"""),format.raw/*185.2*/("""
);
$('.eliminar').on("click",eliminar);

function eliminar()"""),format.raw/*189.20*/("""{"""),format.raw/*189.21*/("""
  var documento = $(this).attr('data-documento');
  var codPrograma = $(this).attr('data-codigoPrograma');
	fila = $(this);


	$( "#confirmDialog" ).dialog("""),format.raw/*195.31*/("""{"""),format.raw/*195.32*/("""
      resizable: false,
      height:240,
      modal: true,
      buttons: """),format.raw/*199.16*/("""{"""),format.raw/*199.17*/("""
        Eliminar: function() """),format.raw/*200.30*/("""{"""),format.raw/*200.31*/("""
        
        $.post("borrarpermiso","""),format.raw/*202.32*/("""{"""),format.raw/*202.33*/("""documento: documento, codPrograma: codPrograma"""),format.raw/*202.79*/("""}"""),format.raw/*202.80*/(""", borrar); 
          $( this ).dialog( "close" );
        """),format.raw/*204.9*/("""}"""),format.raw/*204.10*/(""",
        Cancelar: function() """),format.raw/*205.30*/("""{"""),format.raw/*205.31*/("""
          $( this ).dialog( "close" );
        """),format.raw/*207.9*/("""}"""),format.raw/*207.10*/("""
      """),format.raw/*208.7*/("""}"""),format.raw/*208.8*/("""
    """),format.raw/*209.5*/("""}"""),format.raw/*209.6*/(""");
    $("#confirmDialog").html("<p>Va a Eliminar este permiso.</p>");
  

"""),format.raw/*213.1*/("""}"""),format.raw/*213.2*/("""

function borrar(data)
"""),format.raw/*216.1*/("""{"""),format.raw/*216.2*/("""
if(data=="ok")
"""),format.raw/*218.1*/("""{"""),format.raw/*218.2*/("""
fila.parent().parent().remove();
"""),format.raw/*220.1*/("""}"""),format.raw/*220.2*/("""

else
"""),format.raw/*223.1*/("""{"""),format.raw/*223.2*/("""
alert("No se pudo eliminar el registro de la base de datos. ");
"""),format.raw/*225.1*/("""}"""),format.raw/*225.2*/("""
"""),format.raw/*226.1*/("""}"""),format.raw/*226.2*/("""

function adicionar(data)
"""),format.raw/*229.1*/("""{"""),format.raw/*229.2*/("""
if(data=="ok")
"""),format.raw/*231.1*/("""{"""),format.raw/*231.2*/("""
var $x=$(nuevaFila); 
$("#tabla").append($x);
$x.find("a").on("click",eliminar);
"""),format.raw/*235.1*/("""}"""),format.raw/*235.2*/("""
else if (data=="duplicado")
"""),format.raw/*237.1*/("""{"""),format.raw/*237.2*/("""
alert("El usuario ya tiene un permiso asignado para este programa o ya está como administrador del sistema. ");
"""),format.raw/*239.1*/("""}"""),format.raw/*239.2*/("""
else
"""),format.raw/*241.1*/("""{"""),format.raw/*241.2*/("""
alert("No se pudo insertar el registro en la base de datos. ");
"""),format.raw/*243.1*/("""}"""),format.raw/*243.2*/("""
$('#listaroles').val('1');
$('#inputusuario').val('');
$('#listaProgramas').val('1');
$('#listaProgramas').hide();
"""),format.raw/*248.1*/("""}"""),format.raw/*248.2*/("""

$( ".tabs" ).tabs();

</script>"""))}
    }
    
    def render(permisos:List[Permiso],rol:Rol): play.api.templates.HtmlFormat.Appendable = apply(permisos,rol)
    
    def f:((List[Permiso],Rol) => play.api.templates.HtmlFormat.Appendable) = (permisos,rol) => apply(permisos,rol)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Feb 21 18:14:40 COT 2016
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: 2209422e01a306cdb132d73b8506777ccadff0b5
                    MATRIX: 785->1|912->34|948->36|964->44|1002->45|1533->540|1545->543|1588->564|1665->605|1677->608|1718->627|1802->675|1814->678|1861->703|1944->750|1956->753|1992->767|2062->801|2074->804|2122->830|2332->1005|2372->1029|2411->1030|2458->1042|2474->1049|2521->1074|2568->1086|2584->1093|2634->1121|2681->1133|2738->1181|2777->1182|2815->1185|2831->1192|2884->1223|2922->1225|2938->1232|2986->1258|3020->1261|3116->1321|3132->1328|3182->1356|3221->1360|3278->1408|3317->1409|3378->1434|3394->1441|3447->1472|3470->1477|3482->1481|3520->1482|3583->1514|3662->1562|3882->1746|3941->1783|4010->1816|4068->1852|4108->1861|4256->1981|4285->1982|4625->2294|4654->2295|4741->2354|4770->2355|4951->2509|4979->2510|5043->2546|5072->2547|5277->2725|5305->2726|5336->2730|5364->2731|5394->2734|5422->2735|5496->2782|5524->2783|5665->2896|5694->2897|5766->2942|5794->2943|5824->2946|5852->2947|5913->2980|5942->2981|6048->3059|6077->3060|6146->3101|6175->3102|6446->3345|6475->3346|6595->3438|6624->3439|6700->3487|6729->3488|6793->3523|6823->3524|6927->3599|6957->3600|7017->3631|7047->3632|7128->3684|7158->3685|7195->3694|7225->3695|7260->3702|7289->3703|7405->3791|7434->3792|7474->3804|7503->3805|7648->3922|7677->3923|7708->3926|7737->3927|7767->3929|7796->3930|7832->3938|7861->3939|7918->3967|7948->3968|8052->4043|8082->4044|8142->4075|8172->4076|8253->4128|8283->4129|8320->4138|8350->4139|8385->4146|8414->4147|8526->4231|8555->4232|8599->4248|8628->4249|8925->4517|8955->4518|9050->4584|9080->4585|9123->4600|9152->4601|9181->4602|9210->4603|9346->4710|9376->4711|9444->4742|9457->4745|9494->4759|9560->4788|9573->4791|9623->4817|9654->4820|9683->4821|9771->4881|9800->4882|9872->4917|9885->4920|9927->4939|9958->4942|9987->4943|10074->5002|10103->5003|10175->5038|10188->5041|10236->5066|10267->5069|10296->5070|10358->5104|10387->5105|10459->5140|10472->5143|10516->5164|10547->5167|10576->5168|10638->5202|10667->5203|10698->5206|10727->5207|10817->5268|10847->5269|11033->5426|11063->5427|11169->5504|11199->5505|11258->5535|11288->5536|11358->5577|11388->5578|11463->5624|11493->5625|11580->5684|11610->5685|11670->5716|11700->5717|11776->5765|11806->5766|11841->5773|11870->5774|11903->5779|11932->5780|12035->5855|12064->5856|12116->5880|12145->5881|12189->5897|12218->5898|12280->5932|12309->5933|12344->5940|12373->5941|12466->6006|12495->6007|12524->6008|12553->6009|12608->6036|12637->6037|12681->6053|12710->6054|12820->6136|12849->6137|12906->6166|12935->6167|13076->6280|13105->6281|13139->6287|13168->6288|13261->6353|13290->6354|13434->6470|13463->6471
                    LINES: 26->1|29->1|30->2|30->2|30->2|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|73->45|82->54|82->54|83->55|83->55|85->57|90->62|90->62|100->72|100->72|102->74|102->74|106->78|106->78|107->79|107->79|113->85|113->85|114->86|114->86|115->87|115->87|117->89|117->89|120->92|120->92|122->94|122->94|124->96|124->96|126->98|126->98|128->100|128->100|130->102|130->102|140->112|140->112|143->115|143->115|146->118|146->118|148->120|148->120|151->123|151->123|152->124|152->124|154->126|154->126|155->127|155->127|156->128|156->128|159->131|159->131|161->133|161->133|164->136|164->136|165->137|165->137|166->138|166->138|168->140|168->140|169->141|169->141|172->144|172->144|173->145|173->145|175->147|175->147|176->148|176->148|177->149|177->149|180->152|180->152|182->154|182->154|186->158|186->158|186->158|186->158|187->159|187->159|188->160|188->160|194->166|194->166|196->168|196->168|196->168|196->168|196->168|196->168|197->169|197->169|199->171|199->171|200->172|200->172|200->172|201->173|201->173|203->175|203->175|204->176|204->176|204->176|205->177|205->177|207->179|207->179|208->180|208->180|208->180|209->181|209->181|211->183|211->183|213->185|213->185|217->189|217->189|223->195|223->195|227->199|227->199|228->200|228->200|230->202|230->202|230->202|230->202|232->204|232->204|233->205|233->205|235->207|235->207|236->208|236->208|237->209|237->209|241->213|241->213|244->216|244->216|246->218|246->218|248->220|248->220|251->223|251->223|253->225|253->225|254->226|254->226|257->229|257->229|259->231|259->231|263->235|263->235|265->237|265->237|267->239|267->239|269->241|269->241|271->243|271->243|276->248|276->248
                    -- GENERATED --
                */
            