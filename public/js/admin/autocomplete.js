$('input.autocomplete-relation').each( function() {
   var $input = $(this);

   
   var controlName = $input.attr('name');
   var $hidden = $('<input type="hidden" id="nuevodocumento" />').attr('name', controlName);
   $input.after($hidden).attr('name', controlName + '_label');

   // autocomplete
   var serverUrl = $input.data('url');
   $(this).autocomplete({
      source: serverUrl,
      focus: function(event, ui) {
         // Set the text input value to the focused item's label, instead of the value.
         $input.val(ui.item.label);
         return false;
      },
      select: function(event, ui) {
         // Save the selection item and value in the two inputs.
         $input.val(ui.item.label);
         $hidden.val(ui.item.value);
         
         return false;
      }
   });
});
$('#inputusuario').on('keydown',function(e)
{
var code = e.which; 
    if(code==13) e.preventDefault();
    if(code!=32 && code!=13 && code!=188 && code!=186){
      $('#nuevodocumento').val("-1");  
    } 

}	
);