/**
 * @author Jesus Campos
 * JS para mantener iluminada la opci�n de man� actual.
 */
$(document).ready(function(){
  
   //ILUMINAR LA OPCI�N DE MEN� ACTUAL
  var url = window.location.href;
  var res = url.split("/");
  document.getElementById(res[res.length-1]).className = "dijitTitlePaneTitleSelected";
  
});