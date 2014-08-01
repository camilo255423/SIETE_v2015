
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
object admin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Permiso],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(permisos:List[Permiso]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""
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
<td><select name="listaroles" id='listaroles'><option value='1'>ADMINISTRADOR</option><option value='2'>DIRECTOR DE PROGRAMA</option></select></td>
<td><b>"""),_display_(Seq[Any](/*18.9*/listaprogramas(Programa.findAll(),0))),format.raw/*18.45*/("""</b></td>
<td><a href="javascript: void(0)" 
	 id="adicionar"
	 >Adicionar</a></td>
</tr>
"""),_display_(Seq[Any](/*23.2*/for(permiso <- permisos) yield /*23.26*/{_display_(Seq[Any](format.raw/*23.27*/("""
<tr>
	<td>"""),_display_(Seq[Any](/*25.7*/permiso/*25.14*/.getUsuario().getNombre())),format.raw/*25.39*/("""</td>
	<td>"""),_display_(Seq[Any](/*26.7*/permiso/*26.14*/.getUsuario().getNombreRol())),format.raw/*26.42*/("""</td>
	<td>"""),_display_(Seq[Any](/*27.7*/if(permiso.getPrograma().getCodPrograma()!=null)/*27.55*/{_display_(Seq[Any](format.raw/*27.56*/("""
	"""),_display_(Seq[Any](/*28.3*/permiso/*28.10*/.getPrograma().getCodPrograma())),format.raw/*28.41*/(""" """),_display_(Seq[Any](/*28.43*/permiso/*28.50*/.getPrograma().getNombre())),format.raw/*28.76*/("""
	""")))})),format.raw/*29.3*/("""
	</td>
	<td><a href="javascript: void(0)" data-documento='"""),_display_(Seq[Any](/*31.53*/permiso/*31.60*/.getUsuario().getDocumento())),format.raw/*31.88*/("""'
	"""),_display_(Seq[Any](/*32.3*/if(permiso.getPrograma().getCodPrograma()!=null)/*32.51*/{_display_(Seq[Any](format.raw/*32.52*/("""
	 data-codigoPrograma='"""),_display_(Seq[Any](/*33.25*/permiso/*33.32*/.getPrograma().getCodPrograma())),format.raw/*33.63*/("""'
	 """)))}/*34.4*/else/*34.8*/{_display_(Seq[Any](format.raw/*34.9*/("""
	 	 data-codigoPrograma='0'
	 """)))})),format.raw/*36.4*/("""
	 class="eliminar"
	 >Eliminar</a></td>
</tr>
""")))})),format.raw/*40.2*/("""
</table>
</div><!-- tab admin -->
</div><!-- tabs -->
<div id="errorDialog" title="Error">
</div>
<div id="confirmDialog" title="Eliminar Permiso">
</div>

""")))})),format.raw/*49.2*/("""
<script>
var fila;
var nuevaFila; 


$('input.autocomplete-relation').each( function() """),format.raw/*55.51*/("""{"""),format.raw/*55.52*/("""
   var $input = $(this);

   
   var controlName = $input.attr('name');
   var $hidden = $('<input type="hidden" id="nuevodocumento" />').attr('name', controlName);
   $input.after($hidden).attr('name', controlName + '_label');

   // autocomplete
   var serverUrl = $input.data('url');
   $(this).autocomplete("""),format.raw/*65.25*/("""{"""),format.raw/*65.26*/("""
      source: serverUrl,
      focus: function(event, ui) """),format.raw/*67.34*/("""{"""),format.raw/*67.35*/("""
         // Set the text input value to the focused item's label, instead of the value.
         $input.val(ui.item.label);
         return false;
      """),format.raw/*71.7*/("""}"""),format.raw/*71.8*/(""",
      select: function(event, ui) """),format.raw/*72.35*/("""{"""),format.raw/*72.36*/("""
         // Save the selection item and value in the two inputs.
         $input.val(ui.item.label);
         $hidden.val(ui.item.value);
         
         return false;
      """),format.raw/*78.7*/("""}"""),format.raw/*78.8*/("""
   """),format.raw/*79.4*/("""}"""),format.raw/*79.5*/(""");
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/(""");
$('#inputusuario').on('keydown',function(e)
"""),format.raw/*82.1*/("""{"""),format.raw/*82.2*/("""
var code = e.which; 
    if(code==13) e.preventDefault();
    if(code!=32 && code!=13 && code!=188 && code!=186)"""),format.raw/*85.55*/("""{"""),format.raw/*85.56*/("""
      $('#nuevodocumento').val("-1");  
    """),format.raw/*87.5*/("""}"""),format.raw/*87.6*/(""" 

"""),format.raw/*89.1*/("""}"""),format.raw/*89.2*/("""	
);
$('form').submit(function() """),format.raw/*91.29*/("""{"""),format.raw/*91.30*/("""
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
"""),format.raw/*93.1*/("""}"""),format.raw/*93.2*/(""");
$('#adicionar').on("click",function()
"""),format.raw/*95.1*/("""{"""),format.raw/*95.2*/("""
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	"""),format.raw/*105.2*/("""{"""),format.raw/*105.3*/("""
	documento=$('#nuevodocumento').val();
		if($('#listaProgramas').css('display')!='none')
		"""),format.raw/*108.3*/("""{"""),format.raw/*108.4*/("""
			
			if($('#listaProgramas').val()=='-1')
			"""),format.raw/*111.4*/("""{"""),format.raw/*111.5*/("""
		
		    $("#errorDialog").dialog("""),format.raw/*113.32*/("""{"""),format.raw/*113.33*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*116.18*/("""{"""),format.raw/*116.19*/("""
		        Aceptar: function() """),format.raw/*117.31*/("""{"""),format.raw/*117.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*119.11*/("""}"""),format.raw/*119.12*/("""
		      """),format.raw/*120.9*/("""}"""),format.raw/*120.10*/("""
		    """),format.raw/*121.7*/("""}"""),format.raw/*121.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un programa.</p>");
			error=1;
			"""),format.raw/*124.4*/("""}"""),format.raw/*124.5*/("""
			else
			"""),format.raw/*126.4*/("""{"""),format.raw/*126.5*/("""
			codigoPrograma = $('#listaProgramas').val();
			nombrePrograma = $('#listaProgramas option:selected').text();
			"""),format.raw/*129.4*/("""}"""),format.raw/*129.5*/("""
		"""),format.raw/*130.3*/("""}"""),format.raw/*130.4*/("""
	"""),format.raw/*131.2*/("""}"""),format.raw/*131.3*/("""
	else
	"""),format.raw/*133.2*/("""{"""),format.raw/*133.3*/("""
		$("#errorDialog").dialog("""),format.raw/*134.28*/("""{"""),format.raw/*134.29*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*137.18*/("""{"""),format.raw/*137.19*/("""
		        Aceptar: function() """),format.raw/*138.31*/("""{"""),format.raw/*138.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*140.11*/("""}"""),format.raw/*140.12*/("""
		      """),format.raw/*141.9*/("""}"""),format.raw/*141.10*/("""
		    """),format.raw/*142.7*/("""}"""),format.raw/*142.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un usuario.</p>");
		error=1;
	"""),format.raw/*145.2*/("""}"""),format.raw/*145.3*/("""
	if(error==0)
	"""),format.raw/*147.2*/("""{"""),format.raw/*147.3*/("""
	nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' data-codigoPrograma='"+codigoPrograma+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$.post("insertarpermiso","""),format.raw/*151.27*/("""{"""),format.raw/*151.28*/("""documento: documento, idRol: idRol, codigoPrograma: codigoPrograma"""),format.raw/*151.94*/("""}"""),format.raw/*151.95*/(""", adicionar);
	"""),format.raw/*152.2*/("""}"""),format.raw/*152.3*/("""
"""),format.raw/*153.1*/("""}"""),format.raw/*153.2*/("""
);
$('#listaProgramas').hide();
$('#nuevodocumento').val('-1');
$('#listaroles').on('change', function()"""),format.raw/*157.41*/("""{"""),format.raw/*157.42*/("""
	if($('#listaroles').val()==1)
	"""),format.raw/*159.2*/("""{"""),format.raw/*159.3*/("""
	$('#listaProgramas').hide();
	"""),format.raw/*161.2*/("""}"""),format.raw/*161.3*/("""
	else
	"""),format.raw/*163.2*/("""{"""),format.raw/*163.3*/("""
	$('#listaProgramas').show();
	"""),format.raw/*165.2*/("""}"""),format.raw/*165.3*/("""

"""),format.raw/*167.1*/("""}"""),format.raw/*167.2*/("""
);
$('.eliminar').on("click",eliminar);

function eliminar()"""),format.raw/*171.20*/("""{"""),format.raw/*171.21*/("""
  var documento = $(this).attr('data-documento');
  var codPrograma = $(this).attr('data-codigoPrograma');
	fila = $(this);


	$( "#confirmDialog" ).dialog("""),format.raw/*177.31*/("""{"""),format.raw/*177.32*/("""
      resizable: false,
      height:240,
      modal: true,
      buttons: """),format.raw/*181.16*/("""{"""),format.raw/*181.17*/("""
        Eliminar: function() """),format.raw/*182.30*/("""{"""),format.raw/*182.31*/("""
        
        $.post("borrarpermiso","""),format.raw/*184.32*/("""{"""),format.raw/*184.33*/("""documento: documento, codPrograma: codPrograma"""),format.raw/*184.79*/("""}"""),format.raw/*184.80*/(""", borrar); 
          $( this ).dialog( "close" );
        """),format.raw/*186.9*/("""}"""),format.raw/*186.10*/(""",
        Cancelar: function() """),format.raw/*187.30*/("""{"""),format.raw/*187.31*/("""
          $( this ).dialog( "close" );
        """),format.raw/*189.9*/("""}"""),format.raw/*189.10*/("""
      """),format.raw/*190.7*/("""}"""),format.raw/*190.8*/("""
    """),format.raw/*191.5*/("""}"""),format.raw/*191.6*/(""");
    $("#confirmDialog").html("<p>Va a Eliminar este permiso.</p>");
  

"""),format.raw/*195.1*/("""}"""),format.raw/*195.2*/("""

function borrar(data)
"""),format.raw/*198.1*/("""{"""),format.raw/*198.2*/("""
if(data=="ok")
"""),format.raw/*200.1*/("""{"""),format.raw/*200.2*/("""
fila.parent().parent().remove();
"""),format.raw/*202.1*/("""}"""),format.raw/*202.2*/("""

else
"""),format.raw/*205.1*/("""{"""),format.raw/*205.2*/("""
alert("No se pudo eliminar el registro de la base de datos. ");
"""),format.raw/*207.1*/("""}"""),format.raw/*207.2*/("""
"""),format.raw/*208.1*/("""}"""),format.raw/*208.2*/("""

function adicionar(data)
"""),format.raw/*211.1*/("""{"""),format.raw/*211.2*/("""
if(data=="ok")
"""),format.raw/*213.1*/("""{"""),format.raw/*213.2*/("""
var $x=$(nuevaFila); 
$("#tabla").append($x);
$x.find("a").on("click",eliminar);
"""),format.raw/*217.1*/("""}"""),format.raw/*217.2*/("""
else if (data=="duplicado")
"""),format.raw/*219.1*/("""{"""),format.raw/*219.2*/("""
alert("El usuario ya tiene un permiso asignado para este programa o ya está como administrador del sistema. ");
"""),format.raw/*221.1*/("""}"""),format.raw/*221.2*/("""
else
"""),format.raw/*223.1*/("""{"""),format.raw/*223.2*/("""
alert("No se pudo insertar el registro en la base de datos. ");
"""),format.raw/*225.1*/("""}"""),format.raw/*225.2*/("""
$('#listaroles').val('1');
$('#inputusuario').val('');
$('#listaProgramas').val('1');
$('#listaProgramas').hide();
"""),format.raw/*230.1*/("""}"""),format.raw/*230.2*/("""

$( ".tabs" ).tabs();

</script>"""))}
    }
    
    def render(permisos:List[Permiso]): play.api.templates.HtmlFormat.Appendable = apply(permisos)
    
    def f:((List[Permiso]) => play.api.templates.HtmlFormat.Appendable) = (permisos) => apply(permisos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
<<<<<<< HEAD
                    DATE: Mon May 12 13:05:38 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/admin.scala.html
=======
                    DATE: Fri Jul 04 16:10:06 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
>>>>>>> 372fc1744ef1390cc0f6719f5a95e33da34749d9
                    HASH: ac25680c16f3b51baec81e950f4c942275316684
                    MATRIX: 781->1|899->25|935->27|951->35|989->36|1619->631|1677->667|1803->758|1843->782|1882->783|1929->795|1945->802|1992->827|2039->839|2055->846|2105->874|2152->886|2192->917|2231->918|2269->921|2285->928|2338->959|2376->961|2392->968|2440->994|2474->997|2570->1057|2586->1064|2636->1092|2716->1141|2905->1299|3021->1387|3050->1388|3390->1700|3419->1701|3506->1760|3535->1761|3716->1915|3744->1916|3808->1952|3837->1953|4042->2131|4070->2132|4101->2136|4129->2137|4159->2140|4187->2141|4261->2188|4289->2189|4430->2302|4459->2303|4531->2348|4559->2349|4589->2352|4617->2353|4678->2386|4707->2387|4812->2465|4840->2466|4908->2507|4936->2508|5207->2751|5236->2752|5357->2845|5386->2846|5463->2895|5492->2896|5556->2931|5586->2932|5690->3007|5720->3008|5780->3039|5810->3040|5891->3092|5921->3093|5958->3102|5988->3103|6023->3110|6052->3111|6168->3199|6197->3200|6237->3212|6266->3213|6413->3332|6442->3333|6473->3336|6502->3337|6532->3339|6561->3340|6597->3348|6626->3349|6683->3377|6713->3378|6817->3453|6847->3454|6907->3485|6937->3486|7018->3538|7048->3539|7085->3548|7115->3549|7150->3556|7179->3557|7291->3641|7320->3642|7364->3658|7393->3659|7649->3886|7679->3887|7774->3953|7804->3954|7847->3969|7876->3970|7905->3971|7934->3972|8069->4078|8099->4079|8160->4112|8189->4113|8250->4146|8279->4147|8315->4155|8344->4156|8405->4189|8434->4190|8464->4192|8493->4193|8583->4254|8613->4255|8742->4355|8772->4356|8878->4433|8908->4434|8967->4464|8997->4465|9067->4506|9097->4507|9146->4527|9176->4528|9263->4587|9293->4588|9353->4619|9383->4620|9459->4668|9489->4669|9524->4676|9553->4677|9586->4682|9615->4683|9718->4758|9747->4759|9799->4783|9828->4784|9872->4800|9901->4801|9963->4835|9992->4836|10026->4842|10055->4843|10148->4908|10177->4909|10206->4910|10235->4911|10290->4938|10319->4939|10363->4955|10392->4956|10502->5038|10531->5039|10588->5068|10617->5069|10747->5171|10776->5172|10810->5178|10839->5179|10932->5244|10961->5245|11107->5363|11136->5364
                    LINES: 26->1|29->1|30->2|30->2|30->2|46->18|46->18|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|56->28|57->29|59->31|59->31|59->31|63->35|72->44|78->50|78->50|88->60|88->60|90->62|90->62|94->66|94->66|95->67|95->67|101->73|101->73|102->74|102->74|103->75|103->75|105->77|105->77|108->80|108->80|110->82|110->82|112->84|112->84|114->86|114->86|116->88|116->88|118->90|118->90|128->100|128->100|131->103|131->103|134->106|134->106|136->108|136->108|139->111|139->111|140->112|140->112|142->114|142->114|143->115|143->115|144->116|144->116|147->119|147->119|149->121|149->121|152->124|152->124|153->125|153->125|154->126|154->126|156->128|156->128|157->129|157->129|160->132|160->132|161->133|161->133|163->135|163->135|164->136|164->136|165->137|165->137|168->140|168->140|170->142|170->142|174->146|174->146|174->146|174->146|175->147|175->147|176->148|176->148|180->152|180->152|182->154|182->154|184->156|184->156|186->158|186->158|188->160|188->160|190->162|190->162|194->166|194->166|199->171|199->171|203->175|203->175|204->176|204->176|206->178|206->178|206->178|206->178|208->180|208->180|209->181|209->181|211->183|211->183|212->184|212->184|213->185|213->185|217->189|217->189|220->192|220->192|222->194|222->194|224->196|224->196|226->198|226->198|228->200|228->200|229->201|229->201|232->204|232->204|234->206|234->206|238->210|238->210|240->212|240->212|242->214|242->214|244->216|244->216|246->218|246->218|251->223|251->223
=======
                    DATE: Thu Jul 31 18:11:39 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: 6b88364df0a57a19746d85ac14ef88979596cace
                    MATRIX: 781->1|899->25|935->27|951->35|989->36|1619->631|1677->667|1803->758|1843->782|1882->783|1929->795|1945->802|1992->827|2039->839|2055->846|2105->874|2152->886|2209->934|2248->935|2286->938|2302->945|2355->976|2393->978|2409->985|2457->1011|2491->1014|2587->1074|2603->1081|2653->1109|2692->1113|2749->1161|2788->1162|2849->1187|2865->1194|2918->1225|2941->1230|2953->1234|2991->1235|3054->1267|3133->1315|3322->1473|3438->1561|3467->1562|3807->1874|3836->1875|3923->1934|3952->1935|4133->2089|4161->2090|4225->2126|4254->2127|4459->2305|4487->2306|4518->2310|4546->2311|4576->2314|4604->2315|4678->2362|4706->2363|4847->2476|4876->2477|4948->2522|4976->2523|5006->2526|5034->2527|5095->2560|5124->2561|5229->2639|5257->2640|5325->2681|5353->2682|5624->2925|5653->2926|5773->3018|5802->3019|5878->3067|5907->3068|5971->3103|6001->3104|6105->3179|6135->3180|6195->3211|6225->3212|6306->3264|6336->3265|6373->3274|6403->3275|6438->3282|6467->3283|6583->3371|6612->3372|6652->3384|6681->3385|6826->3502|6855->3503|6886->3506|6915->3507|6945->3509|6974->3510|7010->3518|7039->3519|7096->3547|7126->3548|7230->3623|7260->3624|7320->3655|7350->3656|7431->3708|7461->3709|7498->3718|7528->3719|7563->3726|7592->3727|7704->3811|7733->3812|7777->3828|7806->3829|8103->4097|8133->4098|8228->4164|8258->4165|8301->4180|8330->4181|8359->4182|8388->4183|8522->4288|8552->4289|8613->4322|8642->4323|8702->4355|8731->4356|8767->4364|8796->4365|8856->4397|8885->4398|8915->4400|8944->4401|9034->4462|9064->4463|9250->4620|9280->4621|9386->4698|9416->4699|9475->4729|9505->4730|9575->4771|9605->4772|9680->4818|9710->4819|9797->4878|9827->4879|9887->4910|9917->4911|9993->4959|10023->4960|10058->4967|10087->4968|10120->4973|10149->4974|10252->5049|10281->5050|10333->5074|10362->5075|10406->5091|10435->5092|10497->5126|10526->5127|10561->5134|10590->5135|10683->5200|10712->5201|10741->5202|10770->5203|10825->5230|10854->5231|10898->5247|10927->5248|11037->5330|11066->5331|11123->5360|11152->5361|11293->5474|11322->5475|11356->5481|11385->5482|11478->5547|11507->5548|11651->5664|11680->5665
                    LINES: 26->1|29->1|30->2|30->2|30->2|46->18|46->18|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|56->28|57->29|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|64->36|68->40|77->49|83->55|83->55|93->65|93->65|95->67|95->67|99->71|99->71|100->72|100->72|106->78|106->78|107->79|107->79|108->80|108->80|110->82|110->82|113->85|113->85|115->87|115->87|117->89|117->89|119->91|119->91|121->93|121->93|123->95|123->95|133->105|133->105|136->108|136->108|139->111|139->111|141->113|141->113|144->116|144->116|145->117|145->117|147->119|147->119|148->120|148->120|149->121|149->121|152->124|152->124|154->126|154->126|157->129|157->129|158->130|158->130|159->131|159->131|161->133|161->133|162->134|162->134|165->137|165->137|166->138|166->138|168->140|168->140|169->141|169->141|170->142|170->142|173->145|173->145|175->147|175->147|179->151|179->151|179->151|179->151|180->152|180->152|181->153|181->153|185->157|185->157|187->159|187->159|189->161|189->161|191->163|191->163|193->165|193->165|195->167|195->167|199->171|199->171|205->177|205->177|209->181|209->181|210->182|210->182|212->184|212->184|212->184|212->184|214->186|214->186|215->187|215->187|217->189|217->189|218->190|218->190|219->191|219->191|223->195|223->195|226->198|226->198|228->200|228->200|230->202|230->202|233->205|233->205|235->207|235->207|236->208|236->208|239->211|239->211|241->213|241->213|245->217|245->217|247->219|247->219|249->221|249->221|251->223|251->223|253->225|253->225|258->230|258->230
>>>>>>> 83ea5cc9add5bfe76dd8df164a8931789e2d0402
                    -- GENERATED --
                */
            