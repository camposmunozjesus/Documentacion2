/**
 * 
 */
$(document).ready(function(){
  
   //ILUMINAR LA OPCI�N DE MEN� ACTUAL
  var url = window.location.href;
  var res = url.split("/");
  document.getElementById(res[res.length-2]).className = "dijitTitlePaneTitleSelected";
  
});