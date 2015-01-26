/**
 * @author Jesus Campos
 * JS para mantener iluminada la opción de manú actual.
 */
$(document).ready(function(){
  
   //ILUMINAR LA OPCIÓN DE MENÚ ACTUAL
  var url = window.location.href;
  var res = url.split("/");
  document.getElementById(res[res.length-1]).className = "dijitTitlePaneTitleSelected";
  
});