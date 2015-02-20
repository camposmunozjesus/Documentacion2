//Simular efecto hover en IE
function actionsPage()
{
	// Loader : HideLoader
	$('#preloader').fadeOut('medium');
	
	// CrossBrowser : HoveredList
	if(document.getElementsByTagName) {
  	    var classNameTR = 'hovered',
	 		classNameTH = 'hoveredGradient',
	 		patternTR   = new RegExp('(^|\\s+)' + classNameTR + '(\\s+|$)'),
	     	patternTH   = new RegExp('(^|\\s+)' + classNameTH + '(\\s+|$)'),
	     	rowsTR    = document.getElementsByTagName('tr'),
	 		rowsTH    = document.getElementsByTagName('th');
  	        
		//rowsTH
	    for(var i = 0, n = rowsTH.length; i < n; ++i) {
	      rowsTH[i].onmouseover = function() {
	        this.className += ' ' + classNameTH;
	      };
	      rowsTH[i].onmouseout = function() {
	        this.className = this.className.replace(patternTH, ' ');
	      };
	    }
		//rowsTR
	    for(var i = 0, n = rowsTR.length; i < n; ++i) {
	      rowsTR[i].onmouseover = function() {
	        this.className += ' ' + classNameTR;
	      };
	      rowsTR[i].onmouseout = function() {
	        this.className = this.className.replace(patternTR, ' ');
	      };
	    }
	    rowsTH = null;
	    rowsTR = null;
	    
	}
}
window.onload = actionsPage;