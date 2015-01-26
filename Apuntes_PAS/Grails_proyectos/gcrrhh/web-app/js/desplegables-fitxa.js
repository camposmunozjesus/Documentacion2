$(document).ready(function(){
  
  //ABRE/CIERRA LOS ELEMENTOS DESPLEGABLES
  $('.selectedTitol').click(function(event) {
       
    var id = $(this).attr("id");
    
    //Mostrar elemento: hace un toggle con slideUp y slideDown.
    if ($("#dsplContent_"+id).is(':visible')){
      $("#dsplContent_"+id).slideUp("fast");
      document.getElementById(id).className = "dsplTitol";      
      document.getElementById("title_"+id).className = "plus";
    }
    else{
      $("#dsplContent_"+id).slideDown("fast");
      document.getElementById(id).className = "selectedTitol";      
      document.getElementById("title_"+id).className = "minus";
    }    
  });
  
  //OPCIÓN DE MENÚ SELECCIONADA
  $('.menuPosicio').click(function(event) {    
    var id = $(this).attr("id");
    
    //Mostrar el menú con las opciones: hace un toggle con slideUp y slideDown.
    if ($("#quadreMenu_"+id).is(':visible')){
      $("#quadreMenu_"+id).slideUp("fast");     
      document.getElementById(id).className = "menuPosicio";
    }
    else{
      $("#quadreMenu_"+id).slideDown("fast");    
      document.getElementById(id).className = "menuPosicio open";
    }  
    
  });
  
  //ILUMINAR LA OPCIÓN DE MENÚ ACTUAL
  var url = window.location.href;
  var res = url.split("/");
  document.getElementById(res[res.length-1]).className = "dijitTitlePaneTitleSelected";
 

});