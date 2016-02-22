$('#listaFacultades').hide();
$('#listaProgramas').hide();
$('#nuevodocumento').val('-1');

$('.eliminar').on("click",eliminar);


$('form').submit(function() {
   $(this).find('input.autocomplete-relation').attr('disabled', 'disabled');
});

$('#adicionar').on("click",function()
{
var codigoPrograma=0;
var nombreRol=$('#listaroles option:selected').text();
var idRol=$('#listaroles').val();
var usuario=$('#inputusuario').val();
var nombrePrograma="";
var documento=0;
var error=0;

	if($('#nuevodocumento').val()!='-1')
	{
	documento=$('#nuevodocumento').val();
		if($('#listaProgramas').css('display')!='none')
		{
			
			if($('#listaProgramas').val()=='-1')
			{
		
		    $("#errorDialog").dialog({
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		$("#errorDialog").html("<p>Por favor seleccione un programa.</p>");
			error=1;
			}
			else
			{
			codigoPrograma = $('#listaProgramas').val();
			nombrePrograma = $('#listaProgramas option:selected').text();
			}
		}
	}
	else
	{
		$("#errorDialog").dialog({
		      modal: true,
		      title: "Adicionar permiso",
		      buttons: {
		        Aceptar: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		$("#errorDialog").html("<p>Por favor seleccione un usuario.</p>");
		error=1;
	}
	if(error==0)
	{
	nuevaFila = "<tr><td>"+usuario+"</td><td>"+nombreRol+"</td><td>"+nombrePrograma+"</td><td>"+
	"<a href='javascript: void(0)' data-documento='"+documento+"' data-codigoPrograma='"+codigoPrograma+"' class='eliminar'"+
	 ">Eliminar</a></td>";
	$.post("insertarpermiso",{documento: documento, idRol: idRol, codigoPrograma: codigoPrograma}, adicionar);
	}
}
);





