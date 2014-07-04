
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
	<td>"""),_display_(Seq[Any](/*27.7*/if(permiso.getPrograma()!=null)/*27.38*/{_display_(Seq[Any](format.raw/*27.39*/("""
	"""),_display_(Seq[Any](/*28.3*/permiso/*28.10*/.getPrograma().getCodPrograma())),format.raw/*28.41*/(""" """),_display_(Seq[Any](/*28.43*/permiso/*28.50*/.getPrograma().getNombre())),format.raw/*28.76*/("""
	""")))})),format.raw/*29.3*/("""
	</td>
	<td><a href="javascript: void(0)" data-documento='"""),_display_(Seq[Any](/*31.53*/permiso/*31.60*/.getUsuario().getDocumento())),format.raw/*31.88*/("""'
	 class="eliminar"
	 >Eliminar</a></td>
</tr>
""")))})),format.raw/*35.2*/("""
</table>
</div><!-- tab admin -->
</div><!-- tabs -->
<div id="errorDialog" title="Error">
</div>
<div id="confirmDialog" title="Eliminar Permiso">
</div>

""")))})),format.raw/*44.2*/("""
<script>
var fila;
var nuevaFila; 


$('input.autocomplete-relation').each( function() """),format.raw/*50.51*/("""{"""),format.raw/*50.52*/("""
   var $input = $(this);

   
   var controlName = $input.attr('name');
   var $hidden = $('<input type="hidden" id="nuevodocumento" />').attr('name', controlName);
   $input.after($hidden).attr('name', controlName + '_label');

   // autocomplete
   var serverUrl = $input.data('url');
   $(this).autocomplete("""),format.raw/*60.25*/("""{"""),format.raw/*60.26*/("""
      source: serverUrl,
      focus: function(event, ui) """),format.raw/*62.34*/("""{"""),format.raw/*62.35*/("""
         // Set the text input value to the focused item's label, instead of the value.
         $input.val(ui.item.label);
         return false;
      """),format.raw/*66.7*/("""}"""),format.raw/*66.8*/(""",
      select: function(event, ui) """),format.raw/*67.35*/("""{"""),format.raw/*67.36*/("""
         // Save the selection item and value in the two inputs.
         $input.val(ui.item.label);
         $hidden.val(ui.item.value);
         
         return false;
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/("""
   """),format.raw/*74.4*/("""}"""),format.raw/*74.5*/(""");
"""),format.raw/*75.1*/("""}"""),format.raw/*75.2*/(""");
$('#inputusuario').on('keydown',function(e)
"""),format.raw/*77.1*/("""{"""),format.raw/*77.2*/("""
var code = e.which; 
    if(code==13) e.preventDefault();
    if(code!=32 && code!=13 && code!=188 && code!=186)"""),format.raw/*80.55*/("""{"""),format.raw/*80.56*/("""
      $('#nuevodocumento').val("-1");  
    """),format.raw/*82.5*/("""}"""),format.raw/*82.6*/(""" 

"""),format.raw/*84.1*/("""}"""),format.raw/*84.2*/("""	
);
$('form').submit(function() """),format.raw/*86.29*/("""{"""),format.raw/*86.30*/("""
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/(""");
$('#adicionar').on("click",function()
"""),format.raw/*90.1*/("""{"""),format.raw/*90.2*/("""
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	"""),format.raw/*100.2*/("""{"""),format.raw/*100.3*/("""
	documento=$('#nuevodocumento').val();
		if($('#listaProfesores').css('display')!='none')
		"""),format.raw/*103.3*/("""{"""),format.raw/*103.4*/("""
			
			if($('#listaProfesores').val()=='-1')
			"""),format.raw/*106.4*/("""{"""),format.raw/*106.5*/("""
		
		    $("#errorDialog").dialog("""),format.raw/*108.32*/("""{"""),format.raw/*108.33*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*111.18*/("""{"""),format.raw/*111.19*/("""
		        Aceptar: function() """),format.raw/*112.31*/("""{"""),format.raw/*112.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*114.11*/("""}"""),format.raw/*114.12*/("""
		      """),format.raw/*115.9*/("""}"""),format.raw/*115.10*/("""
		    """),format.raw/*116.7*/("""}"""),format.raw/*116.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un programa.</p>");
			error=1;
			"""),format.raw/*119.4*/("""}"""),format.raw/*119.5*/("""
			else
			"""),format.raw/*121.4*/("""{"""),format.raw/*121.5*/("""
			codigoPrograma = $('#listaProfesores').val();
			nombrePrograma = $('#listaProfesores option:selected').text();
			"""),format.raw/*124.4*/("""}"""),format.raw/*124.5*/("""
		"""),format.raw/*125.3*/("""}"""),format.raw/*125.4*/("""
	"""),format.raw/*126.2*/("""}"""),format.raw/*126.3*/("""
	else
	"""),format.raw/*128.2*/("""{"""),format.raw/*128.3*/("""
		$("#errorDialog").dialog("""),format.raw/*129.28*/("""{"""),format.raw/*129.29*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*132.18*/("""{"""),format.raw/*132.19*/("""
		        Aceptar: function() """),format.raw/*133.31*/("""{"""),format.raw/*133.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*135.11*/("""}"""),format.raw/*135.12*/("""
		      """),format.raw/*136.9*/("""}"""),format.raw/*136.10*/("""
		    """),format.raw/*137.7*/("""}"""),format.raw/*137.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un usuario.</p>");
		error=1;
	"""),format.raw/*140.2*/("""}"""),format.raw/*140.3*/("""
	if(error==0)
	"""),format.raw/*142.2*/("""{"""),format.raw/*142.3*/("""
	nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$.post("insertarpermiso","""),format.raw/*146.27*/("""{"""),format.raw/*146.28*/("""documento: documento, idRol: idRol, codigoPrograma: codigoPrograma"""),format.raw/*146.94*/("""}"""),format.raw/*146.95*/(""", adicionar);
	"""),format.raw/*147.2*/("""}"""),format.raw/*147.3*/("""
"""),format.raw/*148.1*/("""}"""),format.raw/*148.2*/("""
);
$('#listaProfesores').hide();
$('#nuevodocumento').val('-1');
$('#listaroles').on('change', function()"""),format.raw/*152.41*/("""{"""),format.raw/*152.42*/("""
	if($('#listaroles').val()==1)
	"""),format.raw/*154.2*/("""{"""),format.raw/*154.3*/("""
	$('#listaProfesores').hide();
	"""),format.raw/*156.2*/("""}"""),format.raw/*156.3*/("""
	else
	"""),format.raw/*158.2*/("""{"""),format.raw/*158.3*/("""
	$('#listaProfesores').show();
	"""),format.raw/*160.2*/("""}"""),format.raw/*160.3*/("""

"""),format.raw/*162.1*/("""}"""),format.raw/*162.2*/("""
);
$('.eliminar').on("click",eliminar);

function eliminar()"""),format.raw/*166.20*/("""{"""),format.raw/*166.21*/("""
  var documento = $(this).attr('data-documento');
	fila = $(this);


	$( "#confirmDialog" ).dialog("""),format.raw/*171.31*/("""{"""),format.raw/*171.32*/("""
      resizable: false,
      height:240,
      modal: true,
      buttons: """),format.raw/*175.16*/("""{"""),format.raw/*175.17*/("""
        Eliminar: function() """),format.raw/*176.30*/("""{"""),format.raw/*176.31*/("""
        
        $.post("borrarpermiso","""),format.raw/*178.32*/("""{"""),format.raw/*178.33*/("""documento: documento"""),format.raw/*178.53*/("""}"""),format.raw/*178.54*/(""", borrar); 
          $( this ).dialog( "close" );
        """),format.raw/*180.9*/("""}"""),format.raw/*180.10*/(""",
        Cancelar: function() """),format.raw/*181.30*/("""{"""),format.raw/*181.31*/("""
          $( this ).dialog( "close" );
        """),format.raw/*183.9*/("""}"""),format.raw/*183.10*/("""
      """),format.raw/*184.7*/("""}"""),format.raw/*184.8*/("""
    """),format.raw/*185.5*/("""}"""),format.raw/*185.6*/(""");
    $("#confirmDialog").html("<p>Va a Eliminar este permiso.</p>");
  

"""),format.raw/*189.1*/("""}"""),format.raw/*189.2*/("""

function borrar(data)
"""),format.raw/*192.1*/("""{"""),format.raw/*192.2*/("""
if(data=="ok")
"""),format.raw/*194.1*/("""{"""),format.raw/*194.2*/("""
fila.parent().parent().remove();
"""),format.raw/*196.1*/("""}"""),format.raw/*196.2*/("""
else
"""),format.raw/*198.1*/("""{"""),format.raw/*198.2*/("""
alert("No se pudo eliminar el registro de la base de datos. ");
"""),format.raw/*200.1*/("""}"""),format.raw/*200.2*/("""
"""),format.raw/*201.1*/("""}"""),format.raw/*201.2*/("""

function adicionar(data)
"""),format.raw/*204.1*/("""{"""),format.raw/*204.2*/("""
if(data=="ok")
"""),format.raw/*206.1*/("""{"""),format.raw/*206.2*/("""
var $x=$(nuevaFila); 
$("#tabla").append($x);
$x.find("a").on("click",eliminar);
"""),format.raw/*210.1*/("""}"""),format.raw/*210.2*/("""
else if (data=="duplicado")
"""),format.raw/*212.1*/("""{"""),format.raw/*212.2*/("""
alert("El usuario ya tiene un permiso asignado. Por favor elimínelo antes de asignarle uno nuevo.");
"""),format.raw/*214.1*/("""}"""),format.raw/*214.2*/("""
else
"""),format.raw/*216.1*/("""{"""),format.raw/*216.2*/("""
alert("No se pudo insertar el registro en la base de datos. ");
"""),format.raw/*218.1*/("""}"""),format.raw/*218.2*/("""
$('#listaroles').val('1');
$('#inputusuario').val('');
$('#listaProfesores').val('1');
$('#listaProfesores').hide();
"""),format.raw/*223.1*/("""}"""),format.raw/*223.2*/("""

$( ".tabs" ).tabs();

</script>"""))}
    }
    
    def render(permisos:List[Permiso]): play.api.templates.HtmlFormat.Appendable = apply(permisos)
    
    def f:((List[Permiso]) => play.api.templates.HtmlFormat.Appendable) = (permisos) => apply(permisos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon May 12 13:05:38 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/admin.scala.html
                    HASH: ac25680c16f3b51baec81e950f4c942275316684
                    MATRIX: 781->1|899->25|935->27|951->35|989->36|1619->631|1677->667|1803->758|1843->782|1882->783|1929->795|1945->802|1992->827|2039->839|2055->846|2105->874|2152->886|2192->917|2231->918|2269->921|2285->928|2338->959|2376->961|2392->968|2440->994|2474->997|2570->1057|2586->1064|2636->1092|2716->1141|2905->1299|3021->1387|3050->1388|3390->1700|3419->1701|3506->1760|3535->1761|3716->1915|3744->1916|3808->1952|3837->1953|4042->2131|4070->2132|4101->2136|4129->2137|4159->2140|4187->2141|4261->2188|4289->2189|4430->2302|4459->2303|4531->2348|4559->2349|4589->2352|4617->2353|4678->2386|4707->2387|4812->2465|4840->2466|4908->2507|4936->2508|5207->2751|5236->2752|5357->2845|5386->2846|5463->2895|5492->2896|5556->2931|5586->2932|5690->3007|5720->3008|5780->3039|5810->3040|5891->3092|5921->3093|5958->3102|5988->3103|6023->3110|6052->3111|6168->3199|6197->3200|6237->3212|6266->3213|6413->3332|6442->3333|6473->3336|6502->3337|6532->3339|6561->3340|6597->3348|6626->3349|6683->3377|6713->3378|6817->3453|6847->3454|6907->3485|6937->3486|7018->3538|7048->3539|7085->3548|7115->3549|7150->3556|7179->3557|7291->3641|7320->3642|7364->3658|7393->3659|7649->3886|7679->3887|7774->3953|7804->3954|7847->3969|7876->3970|7905->3971|7934->3972|8069->4078|8099->4079|8160->4112|8189->4113|8250->4146|8279->4147|8315->4155|8344->4156|8405->4189|8434->4190|8464->4192|8493->4193|8583->4254|8613->4255|8742->4355|8772->4356|8878->4433|8908->4434|8967->4464|8997->4465|9067->4506|9097->4507|9146->4527|9176->4528|9263->4587|9293->4588|9353->4619|9383->4620|9459->4668|9489->4669|9524->4676|9553->4677|9586->4682|9615->4683|9718->4758|9747->4759|9799->4783|9828->4784|9872->4800|9901->4801|9963->4835|9992->4836|10026->4842|10055->4843|10148->4908|10177->4909|10206->4910|10235->4911|10290->4938|10319->4939|10363->4955|10392->4956|10502->5038|10531->5039|10588->5068|10617->5069|10747->5171|10776->5172|10810->5178|10839->5179|10932->5244|10961->5245|11107->5363|11136->5364
                    LINES: 26->1|29->1|30->2|30->2|30->2|46->18|46->18|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|56->28|57->29|59->31|59->31|59->31|63->35|72->44|78->50|78->50|88->60|88->60|90->62|90->62|94->66|94->66|95->67|95->67|101->73|101->73|102->74|102->74|103->75|103->75|105->77|105->77|108->80|108->80|110->82|110->82|112->84|112->84|114->86|114->86|116->88|116->88|118->90|118->90|128->100|128->100|131->103|131->103|134->106|134->106|136->108|136->108|139->111|139->111|140->112|140->112|142->114|142->114|143->115|143->115|144->116|144->116|147->119|147->119|149->121|149->121|152->124|152->124|153->125|153->125|154->126|154->126|156->128|156->128|157->129|157->129|160->132|160->132|161->133|161->133|163->135|163->135|164->136|164->136|165->137|165->137|168->140|168->140|170->142|170->142|174->146|174->146|174->146|174->146|175->147|175->147|176->148|176->148|180->152|180->152|182->154|182->154|184->156|184->156|186->158|186->158|188->160|188->160|190->162|190->162|194->166|194->166|199->171|199->171|203->175|203->175|204->176|204->176|206->178|206->178|206->178|206->178|208->180|208->180|209->181|209->181|211->183|211->183|212->184|212->184|213->185|213->185|217->189|217->189|220->192|220->192|222->194|222->194|224->196|224->196|226->198|226->198|228->200|228->200|229->201|229->201|232->204|232->204|234->206|234->206|238->210|238->210|240->212|240->212|242->214|242->214|244->216|244->216|246->218|246->218|251->223|251->223
                    -- GENERATED --
                */
            