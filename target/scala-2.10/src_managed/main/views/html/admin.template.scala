
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
<td><select name="listaroles" id='listaroles'><option value='1'>ADMINISTRADOR</option><option value='2'>COORDINADOR</option></select></td>
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

$('input.autocomplete-relation').each( function() """),format.raw/*49.51*/("""{"""),format.raw/*49.52*/("""
   var $input = $(this);

   // Create a hidden input with the same form control name to submit the value.
   var controlName = $input.attr('name');
   var $hidden = $('<input type="hidden" id="nuevodocumento" />').attr('name', controlName);
   $input.after($hidden).attr('name', controlName + '_label');

   // Set-up the autocomplete widget.
   var serverUrl = $input.data('url');
   $(this).autocomplete("""),format.raw/*59.25*/("""{"""),format.raw/*59.26*/("""
      source: serverUrl,
      focus: function(event, ui) """),format.raw/*61.34*/("""{"""),format.raw/*61.35*/("""
         // Set the text input value to the focused item's label, instead of the value.
         $input.val(ui.item.label);
         return false;
      """),format.raw/*65.7*/("""}"""),format.raw/*65.8*/(""",
      select: function(event, ui) """),format.raw/*66.35*/("""{"""),format.raw/*66.36*/("""
         // Save the selection item and value in the two inputs.
         $input.val(ui.item.label);
         $hidden.val(ui.item.value);
         alert(ui.item.value);
         return false;
      """),format.raw/*72.7*/("""}"""),format.raw/*72.8*/("""
   """),format.raw/*73.4*/("""}"""),format.raw/*73.5*/(""");
"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/(""");
$('#inputusuario').on('keydown',function(e)
"""),format.raw/*76.1*/("""{"""),format.raw/*76.2*/("""
var code = e.which; 
    if(code==13) e.preventDefault();
    if(code!=32 && code!=13 && code!=188 && code!=186)"""),format.raw/*79.55*/("""{"""),format.raw/*79.56*/("""
      $('#nuevodocumento').val("-1");  
    """),format.raw/*81.5*/("""}"""),format.raw/*81.6*/(""" 

"""),format.raw/*83.1*/("""}"""),format.raw/*83.2*/("""	
);
$('form').submit(function() """),format.raw/*85.29*/("""{"""),format.raw/*85.30*/("""
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
"""),format.raw/*87.1*/("""}"""),format.raw/*87.2*/(""");
$('#adicionar').on("click",function()
"""),format.raw/*89.1*/("""{"""),format.raw/*89.2*/("""
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	"""),format.raw/*99.2*/("""{"""),format.raw/*99.3*/("""
	documento=$('#nuevodocumento').val();
		if($('#listaProfesores').css('display')!='none')
		"""),format.raw/*102.3*/("""{"""),format.raw/*102.4*/("""
			
			if($('#listaProfesores').val()=='-1')
			"""),format.raw/*105.4*/("""{"""),format.raw/*105.5*/("""
		
		    $("#errorDialog").dialog("""),format.raw/*107.32*/("""{"""),format.raw/*107.33*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*110.18*/("""{"""),format.raw/*110.19*/("""
		        Aceptar: function() """),format.raw/*111.31*/("""{"""),format.raw/*111.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*113.11*/("""}"""),format.raw/*113.12*/("""
		      """),format.raw/*114.9*/("""}"""),format.raw/*114.10*/("""
		    """),format.raw/*115.7*/("""}"""),format.raw/*115.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un programa.</p>");
			error=1;
			"""),format.raw/*118.4*/("""}"""),format.raw/*118.5*/("""
			else
			"""),format.raw/*120.4*/("""{"""),format.raw/*120.5*/("""
			codigoPrograma = $('#listaProfesores').val();
			nombrePrograma = $('#listaProfesores option:selected').text();
			"""),format.raw/*123.4*/("""}"""),format.raw/*123.5*/("""
		"""),format.raw/*124.3*/("""}"""),format.raw/*124.4*/("""
	"""),format.raw/*125.2*/("""}"""),format.raw/*125.3*/("""
	else
	"""),format.raw/*127.2*/("""{"""),format.raw/*127.3*/("""
		$("#errorDialog").dialog("""),format.raw/*128.28*/("""{"""),format.raw/*128.29*/("""
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: """),format.raw/*131.18*/("""{"""),format.raw/*131.19*/("""
		        Aceptar: function() """),format.raw/*132.31*/("""{"""),format.raw/*132.32*/("""
		          $( this ).dialog( "close" );
		        """),format.raw/*134.11*/("""}"""),format.raw/*134.12*/("""
		      """),format.raw/*135.9*/("""}"""),format.raw/*135.10*/("""
		    """),format.raw/*136.7*/("""}"""),format.raw/*136.8*/(""");
		$("#errorDialog").html("<p>Por favor seleccione un usuario.</p>");
		error=1;
	"""),format.raw/*139.2*/("""}"""),format.raw/*139.3*/("""
	if(error==0)
	"""),format.raw/*141.2*/("""{"""),format.raw/*141.3*/("""
	nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$.post("insertarpermiso","""),format.raw/*145.27*/("""{"""),format.raw/*145.28*/("""documento: documento, idRol: idRol, codigoPrograma: codigoPrograma"""),format.raw/*145.94*/("""}"""),format.raw/*145.95*/(""", adicionar);
	"""),format.raw/*146.2*/("""}"""),format.raw/*146.3*/("""
"""),format.raw/*147.1*/("""}"""),format.raw/*147.2*/("""
);
$('#listaProfesores').hide();
$('#nuevodocumento').val('-1');
$('#listaroles').on('change', function()"""),format.raw/*151.41*/("""{"""),format.raw/*151.42*/("""
	if($('#listaroles').val()==1)
	"""),format.raw/*153.2*/("""{"""),format.raw/*153.3*/("""
	$('#listaProfesores').hide();
	"""),format.raw/*155.2*/("""}"""),format.raw/*155.3*/("""
	else
	"""),format.raw/*157.2*/("""{"""),format.raw/*157.3*/("""
	$('#listaProfesores').show();
	"""),format.raw/*159.2*/("""}"""),format.raw/*159.3*/("""

"""),format.raw/*161.1*/("""}"""),format.raw/*161.2*/("""
);
$('.eliminar').on("click",function()"""),format.raw/*163.37*/("""{"""),format.raw/*163.38*/("""
  var documento = $(this).attr('data-documento');
	fila = $(this);


	$( "#confirmDialog" ).dialog("""),format.raw/*168.31*/("""{"""),format.raw/*168.32*/("""
      resizable: false,
      height:240,
      modal: true,
      buttons: """),format.raw/*172.16*/("""{"""),format.raw/*172.17*/("""
        Eliminar: function() """),format.raw/*173.30*/("""{"""),format.raw/*173.31*/("""
        
        $.post("borrarpermiso","""),format.raw/*175.32*/("""{"""),format.raw/*175.33*/("""documento: documento"""),format.raw/*175.53*/("""}"""),format.raw/*175.54*/(""", borrar); 
          $( this ).dialog( "close" );
        """),format.raw/*177.9*/("""}"""),format.raw/*177.10*/(""",
        Cancelar: function() """),format.raw/*178.30*/("""{"""),format.raw/*178.31*/("""
          $( this ).dialog( "close" );
        """),format.raw/*180.9*/("""}"""),format.raw/*180.10*/("""
      """),format.raw/*181.7*/("""}"""),format.raw/*181.8*/("""
    """),format.raw/*182.5*/("""}"""),format.raw/*182.6*/(""");
    $("#confirmDialog").html("<p>Va a Eliminar este permiso.</p>");
  

"""),format.raw/*186.1*/("""}"""),format.raw/*186.2*/("""
);

function borrar(data)
"""),format.raw/*190.1*/("""{"""),format.raw/*190.2*/("""
if(data=="ok")
"""),format.raw/*192.1*/("""{"""),format.raw/*192.2*/("""
fila.parent().parent().remove();
"""),format.raw/*194.1*/("""}"""),format.raw/*194.2*/("""
else
"""),format.raw/*196.1*/("""{"""),format.raw/*196.2*/("""
alert("No se pudo eliminar el registro de la base de datos. ");
"""),format.raw/*198.1*/("""}"""),format.raw/*198.2*/("""
"""),format.raw/*199.1*/("""}"""),format.raw/*199.2*/("""

function adicionar(data)
"""),format.raw/*202.1*/("""{"""),format.raw/*202.2*/("""
if(data=="ok")
"""),format.raw/*204.1*/("""{"""),format.raw/*204.2*/("""
$("#tabla").append(nuevaFila);
"""),format.raw/*206.1*/("""}"""),format.raw/*206.2*/("""
else
"""),format.raw/*208.1*/("""{"""),format.raw/*208.2*/("""
alert("No se pudo insertar el registro en la base de datos. ");
"""),format.raw/*210.1*/("""}"""),format.raw/*210.2*/("""
"""),format.raw/*211.1*/("""}"""),format.raw/*211.2*/("""

$( ".tabs" ).tabs();

</script>"""))}
    }
    
    def render(permisos:List[Permiso]): play.api.templates.HtmlFormat.Appendable = apply(permisos)
    
    def f:((List[Permiso]) => play.api.templates.HtmlFormat.Appendable) = (permisos) => apply(permisos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 03 13:31:35 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: 452636c7081b81991ccf2ee2466e7edb22987ec5
                    MATRIX: 781->1|899->25|935->27|951->35|989->36|1610->622|1668->658|1794->749|1834->773|1873->774|1920->786|1936->793|1983->818|2030->830|2046->837|2096->865|2143->877|2183->908|2222->909|2260->912|2276->919|2329->950|2367->952|2383->959|2431->985|2465->988|2561->1048|2577->1055|2627->1083|2707->1132|2896->1290|3011->1377|3040->1378|3476->1786|3505->1787|3592->1846|3621->1847|3802->2001|3830->2002|3894->2038|3923->2039|4149->2238|4177->2239|4208->2243|4236->2244|4266->2247|4294->2248|4368->2295|4396->2296|4537->2409|4566->2410|4638->2455|4666->2456|4696->2459|4724->2460|4785->2493|4814->2494|4919->2572|4947->2573|5015->2614|5043->2615|5313->2858|5341->2859|5462->2952|5491->2953|5568->3002|5597->3003|5661->3038|5691->3039|5795->3114|5825->3115|5885->3146|5915->3147|5996->3199|6026->3200|6063->3209|6093->3210|6128->3217|6157->3218|6273->3306|6302->3307|6342->3319|6371->3320|6518->3439|6547->3440|6578->3443|6607->3444|6637->3446|6666->3447|6702->3455|6731->3456|6788->3484|6818->3485|6922->3560|6952->3561|7012->3592|7042->3593|7123->3645|7153->3646|7190->3655|7220->3656|7255->3663|7284->3664|7396->3748|7425->3749|7469->3765|7498->3766|7754->3993|7784->3994|7879->4060|7909->4061|7952->4076|7981->4077|8010->4078|8039->4079|8174->4185|8204->4186|8265->4219|8294->4220|8355->4253|8384->4254|8420->4262|8449->4263|8510->4296|8539->4297|8569->4299|8598->4300|8667->4340|8697->4341|8826->4441|8856->4442|8962->4519|8992->4520|9051->4550|9081->4551|9151->4592|9181->4593|9230->4613|9260->4614|9347->4673|9377->4674|9437->4705|9467->4706|9543->4754|9573->4755|9608->4762|9637->4763|9670->4768|9699->4769|9802->4844|9831->4845|9886->4872|9915->4873|9959->4889|9988->4890|10050->4924|10079->4925|10113->4931|10142->4932|10235->4997|10264->4998|10293->4999|10322->5000|10377->5027|10406->5028|10450->5044|10479->5045|10539->5077|10568->5078|10602->5084|10631->5085|10724->5150|10753->5151|10782->5152|10811->5153
                    LINES: 26->1|29->1|30->2|30->2|30->2|46->18|46->18|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|56->28|57->29|59->31|59->31|59->31|63->35|72->44|77->49|77->49|87->59|87->59|89->61|89->61|93->65|93->65|94->66|94->66|100->72|100->72|101->73|101->73|102->74|102->74|104->76|104->76|107->79|107->79|109->81|109->81|111->83|111->83|113->85|113->85|115->87|115->87|117->89|117->89|127->99|127->99|130->102|130->102|133->105|133->105|135->107|135->107|138->110|138->110|139->111|139->111|141->113|141->113|142->114|142->114|143->115|143->115|146->118|146->118|148->120|148->120|151->123|151->123|152->124|152->124|153->125|153->125|155->127|155->127|156->128|156->128|159->131|159->131|160->132|160->132|162->134|162->134|163->135|163->135|164->136|164->136|167->139|167->139|169->141|169->141|173->145|173->145|173->145|173->145|174->146|174->146|175->147|175->147|179->151|179->151|181->153|181->153|183->155|183->155|185->157|185->157|187->159|187->159|189->161|189->161|191->163|191->163|196->168|196->168|200->172|200->172|201->173|201->173|203->175|203->175|203->175|203->175|205->177|205->177|206->178|206->178|208->180|208->180|209->181|209->181|210->182|210->182|214->186|214->186|218->190|218->190|220->192|220->192|222->194|222->194|224->196|224->196|226->198|226->198|227->199|227->199|230->202|230->202|232->204|232->204|234->206|234->206|236->208|236->208|238->210|238->210|239->211|239->211
                    -- GENERATED --
                */
            