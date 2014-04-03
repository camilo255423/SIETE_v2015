
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
<table border="1" id="tabla">
<tr>
<td><b>Usuario</b></td><td><b>Rol</b></td><td><b>Programa</b></td><td><b>Operacion</b></td>
</tr>
<tr>
<td width='220'><input id='inputusuario' name="location" class="autocomplete-relation" data-url='autocompleteLabel' size='40'/></td>
<td><select name="listaroles" id='listaroles'><option value='1'>ADMINISTRADOR</option><option value='2'>COORDINADOR</option></select></td>
<td><b>"""),_display_(Seq[Any](/*10.9*/listaprogramas(Programa.findAll(),0))),format.raw/*10.45*/("""</b></td>
<td><a href="javascript: void(0)" 
	 id="adicionar"
	 >Adicionar</a></td>
</tr>
"""),_display_(Seq[Any](/*15.2*/for(permiso <- permisos) yield /*15.26*/{_display_(Seq[Any](format.raw/*15.27*/("""
<tr>
	<td>"""),_display_(Seq[Any](/*17.7*/permiso/*17.14*/.getUsuario().getNombre())),format.raw/*17.39*/("""</td>
	<td>"""),_display_(Seq[Any](/*18.7*/permiso/*18.14*/.getUsuario().getNombreRol())),format.raw/*18.42*/("""</td>
	<td>"""),_display_(Seq[Any](/*19.7*/if(permiso.getPrograma()!=null)/*19.38*/{_display_(Seq[Any](format.raw/*19.39*/("""
	"""),_display_(Seq[Any](/*20.3*/permiso/*20.10*/.getPrograma().getCodPrograma())),format.raw/*20.41*/(""" """),_display_(Seq[Any](/*20.43*/permiso/*20.50*/.getPrograma().getNombre())),format.raw/*20.76*/("""
	""")))})),format.raw/*21.3*/("""
	</td>
	<td><a href="javascript: void(0)" data-documento='"""),_display_(Seq[Any](/*23.53*/permiso/*23.60*/.getUsuario().getDocumento())),format.raw/*23.88*/("""'
	 class="eliminar"
	 >Eliminar</a></td>
</tr>
""")))})),format.raw/*27.2*/("""
</table>

""")))})),format.raw/*30.2*/("""
<script>
var fila;
$('input.autocomplete-relation').each( function() """),format.raw/*33.51*/("""{"""),format.raw/*33.52*/("""
   var $input = $(this);

   // Create a hidden input with the same form control name to submit the value.
   var controlName = $input.attr('name');
   var $hidden = $('<input type="hidden" id="nuevodocumento" />').attr('name', controlName);
   $input.after($hidden).attr('name', controlName + '_label');

   // Set-up the autocomplete widget.
   var serverUrl = $input.data('url');
   $(this).autocomplete("""),format.raw/*43.25*/("""{"""),format.raw/*43.26*/("""
      source: serverUrl,
      focus: function(event, ui) """),format.raw/*45.34*/("""{"""),format.raw/*45.35*/("""
         // Set the text input value to the focused item's label, instead of the value.
         $input.val(ui.item.label);
         return false;
      """),format.raw/*49.7*/("""}"""),format.raw/*49.8*/(""",
      select: function(event, ui) """),format.raw/*50.35*/("""{"""),format.raw/*50.36*/("""
         // Save the selection item and value in the two inputs.
         $input.val(ui.item.label);
         $hidden.val(ui.item.value);
         alert(ui.item.value);
         return false;
      """),format.raw/*56.7*/("""}"""),format.raw/*56.8*/("""
   """),format.raw/*57.4*/("""}"""),format.raw/*57.5*/(""");
"""),format.raw/*58.1*/("""}"""),format.raw/*58.2*/(""");
$('#inputusuario').on('keydown',function(e)
"""),format.raw/*60.1*/("""{"""),format.raw/*60.2*/("""
var code = e.which; 
    if(code==13) e.preventDefault();
    if(code!=32 && code!=13 && code!=188 && code!=186)"""),format.raw/*63.55*/("""{"""),format.raw/*63.56*/("""
      $('#nuevodocumento').val("-1");  
    """),format.raw/*65.5*/("""}"""),format.raw/*65.6*/(""" 

"""),format.raw/*67.1*/("""}"""),format.raw/*67.2*/("""	
);
$('form').submit(function() """),format.raw/*69.29*/("""{"""),format.raw/*69.30*/("""
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
$('#adicionar').on("click",function()
"""),format.raw/*73.1*/("""{"""),format.raw/*73.2*/("""
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	"""),format.raw/*83.2*/("""{"""),format.raw/*83.3*/("""
	
		if($('#listaProfesores').css('display')!='none')
		"""),format.raw/*86.3*/("""{"""),format.raw/*86.4*/("""
			documento=$('#nuevodocumento').val();
			if($('#listaProfesores').val()=='-1')
			"""),format.raw/*89.4*/("""{"""),format.raw/*89.5*/("""
			alert('Por favor seleccione un programa');
			error=1;
			"""),format.raw/*92.4*/("""}"""),format.raw/*92.5*/("""
			else
			"""),format.raw/*94.4*/("""{"""),format.raw/*94.5*/("""
			programa = $('#listaProfesores').val();
			nombrePrograma = $('#listaProfesores option:selected').text();
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/("""
		"""),format.raw/*98.3*/("""}"""),format.raw/*98.4*/("""
	"""),format.raw/*99.2*/("""}"""),format.raw/*99.3*/("""
	else
	"""),format.raw/*101.2*/("""{"""),format.raw/*101.3*/("""
		alert('Por favor seleccione un usuario');
		error=1;
	"""),format.raw/*104.2*/("""}"""),format.raw/*104.3*/("""
	if(error==0)
	"""),format.raw/*106.2*/("""{"""),format.raw/*106.3*/("""
	var nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$("#tabla").append(nuevaFila);
	"""),format.raw/*111.2*/("""}"""),format.raw/*111.3*/("""
"""),format.raw/*112.1*/("""}"""),format.raw/*112.2*/("""
);
$('#listaProfesores').hide();
$('#nuevodocumento').val('-1');
$('#listaroles').on('change', function()"""),format.raw/*116.41*/("""{"""),format.raw/*116.42*/("""
	if($('#listaroles').val()==1)
	"""),format.raw/*118.2*/("""{"""),format.raw/*118.3*/("""
	$('#listaProfesores').hide();
	"""),format.raw/*120.2*/("""}"""),format.raw/*120.3*/("""
	else
	"""),format.raw/*122.2*/("""{"""),format.raw/*122.3*/("""
	$('#listaProfesores').show();
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/("""

"""),format.raw/*126.1*/("""}"""),format.raw/*126.2*/("""
);
$('.eliminar').on("click",function()"""),format.raw/*128.37*/("""{"""),format.raw/*128.38*/("""
var documento = $(this).attr('data-documento');
fila = $(this);
$.post("borrarpermiso","""),format.raw/*131.24*/("""{"""),format.raw/*131.25*/("""documento: documento"""),format.raw/*131.45*/("""}"""),format.raw/*131.46*/(""", borrar); 
	

"""),format.raw/*134.1*/("""}"""),format.raw/*134.2*/("""
);

function borrar(data)
"""),format.raw/*138.1*/("""{"""),format.raw/*138.2*/("""
if(data=="ok")
"""),format.raw/*140.1*/("""{"""),format.raw/*140.2*/("""
fila.parent().parent().remove();
"""),format.raw/*142.1*/("""}"""),format.raw/*142.2*/("""
else
"""),format.raw/*144.1*/("""{"""),format.raw/*144.2*/("""
alert("No se pudo eliminar el registro de la base de datos. ");
"""),format.raw/*146.1*/("""}"""),format.raw/*146.2*/("""
"""),format.raw/*147.1*/("""}"""),format.raw/*147.2*/("""

</script>"""))}
    }
    
    def render(permisos:List[Permiso]): play.api.templates.HtmlFormat.Appendable = apply(permisos)
    
    def f:((List[Permiso]) => play.api.templates.HtmlFormat.Appendable) = (permisos) => apply(permisos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 02 18:50:51 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/admin.scala.html
                    HASH: 5c43adf66d2b7a3ccb35d0c9bcd909264ba0897e
                    MATRIX: 781->1|899->25|935->27|951->35|989->36|1443->455|1501->491|1627->582|1667->606|1706->607|1753->619|1769->626|1816->651|1863->663|1879->670|1929->698|1976->710|2016->741|2055->742|2093->745|2109->752|2162->783|2200->785|2216->792|2264->818|2298->821|2394->881|2410->888|2460->916|2540->965|2583->977|2681->1047|2710->1048|3146->1456|3175->1457|3262->1516|3291->1517|3472->1671|3500->1672|3564->1708|3593->1709|3819->1908|3847->1909|3878->1913|3906->1914|3936->1917|3964->1918|4038->1965|4066->1966|4207->2079|4236->2080|4308->2125|4336->2126|4366->2129|4394->2130|4455->2163|4484->2164|4589->2242|4617->2243|4685->2284|4713->2285|4983->2528|5011->2529|5094->2585|5122->2586|5235->2672|5263->2673|5352->2735|5380->2736|5419->2748|5447->2749|5587->2862|5615->2863|5645->2866|5673->2867|5702->2869|5730->2870|5766->2878|5795->2879|5880->2936|5909->2937|5953->2953|5982->2954|6248->3192|6277->3193|6306->3194|6335->3195|6470->3301|6500->3302|6561->3335|6590->3336|6651->3369|6680->3370|6716->3378|6745->3379|6806->3412|6835->3413|6865->3415|6894->3416|6963->3456|6993->3457|7110->3545|7140->3546|7189->3566|7219->3567|7262->3582|7291->3583|7346->3610|7375->3611|7419->3627|7448->3628|7510->3662|7539->3663|7573->3669|7602->3670|7695->3735|7724->3736|7753->3737|7782->3738
                    LINES: 26->1|29->1|30->2|30->2|30->2|38->10|38->10|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|49->21|51->23|51->23|51->23|55->27|58->30|61->33|61->33|71->43|71->43|73->45|73->45|77->49|77->49|78->50|78->50|84->56|84->56|85->57|85->57|86->58|86->58|88->60|88->60|91->63|91->63|93->65|93->65|95->67|95->67|97->69|97->69|99->71|99->71|101->73|101->73|111->83|111->83|114->86|114->86|117->89|117->89|120->92|120->92|122->94|122->94|125->97|125->97|126->98|126->98|127->99|127->99|129->101|129->101|132->104|132->104|134->106|134->106|139->111|139->111|140->112|140->112|144->116|144->116|146->118|146->118|148->120|148->120|150->122|150->122|152->124|152->124|154->126|154->126|156->128|156->128|159->131|159->131|159->131|159->131|162->134|162->134|166->138|166->138|168->140|168->140|170->142|170->142|172->144|172->144|174->146|174->146|175->147|175->147
                    -- GENERATED --
                */
            