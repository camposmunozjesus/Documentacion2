Avisa cuando un elemento está activo o no:
var flag= new Array();




//Desplega correctamente el elemento y además modifica el icono clickable.
function desplegableFuncSimple(id){

  if (!$("#dsplContent"+id).is(':visible')){
        alert("yes");
  }
  else{
    alert("NO");
  }
  
  
  
  alert($("#dsplContent"+id).attr("id"));

  if(flag[id]){
    alert($("#dsplContent"+id).attr("id"));
    flag[id]=false;
    $("#dsplContent"+id).slideUp("slow");
    //$("#imgShowHidePanel"+id).attr("src", "graphics/hide_start.png");
    
  }
  else{
    //alert(flag);
    flag[id]=true;
    $("#dsplContent"+id).slideDown("slow");
    //$("#imgShowHidePanel"+id).attr("src", "graphics/hide_end.png");
    
  }

}
  
**************************************************************************
Se cambia la clase del elemento seleccionado (de su desplegble):
var flag= new Array();

//Desplega correctamente el elemento y además modifica el icono clickable.
function desplegableFuncSimple(id){

  var x = document.getElementById("dsplContent102").className;
  
  document.getElementById("dsplContent"+id).className = "KKK";
  
  alert(x);
  
  if (!$("#dsplContent"+id).is(':visible')){
    $("#dsplContent"+id).slideDown("slow");
  }
  else{
    $("#dsplContent"+id).slideUp("slow");
  }
  
  
  $(".dsplContent").slideUp("slow");


}

*****************************************************************************
Versión que funciona de manera aceptable:
$(document).ready(function(){
  $('.dsplTitol').click({id: 'op'},function(event) {
    //alert($(this).attr("id"));
    var id = $(this).attr("id");
    
    //Mostrar elemento: con toggle.
    //$("#dsplContent_"+id).toggle("slow");
    
    //Mostrar elemento: hace un toggle con slideUp y slideDown.
    if ($("#dsplContent_"+id).is(':visible')){
      $("#dsplContent_"+id).slideUp("slow");
    }
    else{
      $("#dsplContent_"+id).slideDown("slow");
    }
    

    //Oculta el resto de elementos
    //dsplContent inicial
    document.getElementById("dsplContent_"+id).className = "kjlkjlk";
    $(".dsplContent").slideUp("fast");
    document.getElementById("dsplContent_"+id).className = "dsplContent";
    
  });

});

******************************************************************************
Versión bastante mejorada:
$(document).ready(function(){
  
  //Variable que guarda el último título sobre el que se hizo click para devolverle su forma original.
  var titolAnterior;
  
  $('.dsplTitol').click(function(event) {
    if(titolAnterior){
      document.getElementById(titolAnterior).className = "dsplTitol";
    }
       
    //alert($(this).attr("id"));
    var id = $(this).attr("id");
    
    //Mostrar elemento: con toggle.
    //$("#dsplContent_"+id).toggle("slow");
    
    //Mostrar elemento: hace un toggle con slideUp y slideDown.
    if ($("#dsplContent_"+id).is(':visible')){
      $("#dsplContent_"+id).slideUp("fast");
      document.getElementById(id).className = "dsplTitol";
    }
    else{
      $("#dsplContent_"+id).slideDown("fast");
      document.getElementById(id).className = "selectedTitol";
    }    

    //Oculta el resto de elementos
    //dsplContent inicial
    document.getElementById("dsplContent_"+id).className = "";    
    $(".dsplContent").slideUp("fast");
    document.getElementById("dsplContent_"+id).className = "dsplContent";
    
    titolAnterior=id;
  });

});