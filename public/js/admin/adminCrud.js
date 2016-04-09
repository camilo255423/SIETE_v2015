


function borrar(data)
{
	if(data=="ok")
	{
	fila.parent().parent().remove();
	}
	
	else
	{
	alert("No se pudo eliminar el registro de la base de datos. ");
	}
}

function adicionar(data)
{
	if(data=="ok")
	{
		var $x=$(nuevaFila); 
		$("#tabla").append($x);
		$x.find("a").on("click",eliminar);
	}
	else if (data=="duplicado")
	{
		alert("El usuario ya tiene este permiso asignado. ");
	}
	else if (data=="rol_diferente")
	{
		alert("El usuario ya está en el sistema con un ROL diferente. ");
	}
	else
	{
		alert("No se pudo insertar el registro en la base de datos. ");
	}
	$('#listaroles').val('1');
	$('#inputusuario').val('');
	$('#listaPermisos').val('1');
	$('#listaPermisos').html('');
}

function eliminar(){
	  var documento = $(this).attr('data-documento');
	  var codPrograma = $(this).attr('data-codigoPrograma');
		fila = $(this);


		$( "#confirmDialog" ).dialog({
	      resizable: false,
	      height:240,
	      modal: true,
	      buttons: {
	        Eliminar: function() {
	        
	        $.post("borrarpermiso",{documento: documento, codPrograma: codPrograma}, borrar); 
	          $( this ).dialog( "close" );
	        },
	        Cancelar: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
	    $("#confirmDialog").html("<p>Va a Eliminar este permiso.</p>");
	  

	}
