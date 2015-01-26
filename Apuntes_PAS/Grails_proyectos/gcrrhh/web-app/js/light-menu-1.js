/**
 * 
 */
$(document).ready(function(){
  
   //ILUMINAR LA OPCIÓN DE MENÚ ACTUAL
  var url = window.location.href;
  var res = url.split("/");
  document.getElementById(res[res.length-2]).className = "dijitTitlePaneTitleSelected";
  
});