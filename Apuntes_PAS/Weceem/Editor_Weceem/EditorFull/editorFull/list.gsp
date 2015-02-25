<html>
	<head>
		
		<meta name="layout" content="main" />
		<title>Edició de continguts</title>

		<link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/code/codemirror.css">
		<script src="/${grails.util.Metadata.current.'app.name'}/js/code/codemirror.js"></script>
		<script src="/${grails.util.Metadata.current.'app.name'}/js/code/runmode.js"></script>
		<script src="/${grails.util.Metadata.current.'app.name'}/js/code/xml.js"></script>
		
		<link href="/${grails.util.Metadata.current.'app.name'}/css/treeTable/jquery.treetable.css" rel="stylesheet" type="text/css" />
		<link href="/${grails.util.Metadata.current.'app.name'}/css/treeTable/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
    		
		<script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/jquery/jquery.js"></script>
		<script src="/${grails.util.Metadata.current.'app.name'}/js/treeTable/jquery.treetable.js"></script>
		<link href="/${grails.util.Metadata.current.'app.name'}/css/desplegables-fitxa.css" rel="stylesheet" type="text/css" />
		
		<!-- Colores del calendario -->
		<link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'cupertino/CSSjquery.css')}" />
		<script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/jquery/jquery-ui-1.10.4.js"></script>
		<!-- Traducción del calendario al catalán -->
		<script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/calendar.js"></script>

		<g:if test="${arxiu?.permetreGSP==0 || arxiu?.permetreGSP==null}">
			<ckeditor:resources/>
		</g:if>
		
        <script type="text/javascript">
	        $(document).ready(function(){
	        	

				$( "#arxiuDataIniciPublicacio, #arxiuDataFiPublicacio, #arxiuDataActualitzacio").datepicker({ 
			    	 showOn: "button",
					 buttonImage: "../images/calendar.png",
					 buttonImageOnly: true
			    });
			    
				
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
	        });
        </script>
        
	</head>
	<body>
		<g:if test="${flash.message}">
			<div class="message">
				<p>${flash.message}</p>
			</div>
		</g:if>
		<form id="ckeditor" action="saveAndContinue" method="post" enctype="multipart/form-data">
			<g:hiddenField name="identity" value="${params?.identity?:arxiu?.id}" />
	    	<g:hiddenField id="arxiuEspai" name="arxiuEspai" value="${params?.espai?:arxiu?.espai}" />
	    	<g:hiddenField id="arxiuPare" name="arxiuPare" value="${params?.pare}" />
	    	
			<!--  Edición del título de la página -->
			<div class="input-group">
			  <span class="input-group-addon">Títol</span>
			  <input id="arxiuTitol" name="arxiuTitol" type="text" class="form-control" value="${params?.arxiuTitol?:arxiu?.titol}">
			</div>
			<br>
			
			<!--  Edición del contenido  -->
			<ckeditor:editor id="arxiuContingut" name="arxiuContingut" height="400px" width="100%" userSpace="${space}">
				${params?.arxiuContingut?:arxiu?.contingut}
			</ckeditor:editor>
			<br>
			
			<div class="row no-scroll-bar">
		 	    <div class="col-xs-12 col-sm-6 col-md-7 col-lg-7">
					<!-- Botones -->
					<g:actionSubmit action="save" method="post" value="Desar" class="btn btn-primary btn-sm"/>
					<g:actionSubmit action="saveAndContinue" method="post" value="Desar contingut i continuar" class="btn btn-primary btn-sm"/>
					<g:actionSubmit action="cancel" method="post" value="Cancel·lar" class="btn btn-primary btn-sm"/>
				</div>
	        	<div class="col-xs-12 col-sm-6 col-md-5 col-lg-5">
	        		Editar codi GSP
	        		<g:if test="${arxiu?.permetreGSP==1}">
	        			<input type="checkbox" id="arxiuPermetreGSP" name="arxiuPermetreGSP"  value="1" checked>	
	        		</g:if>
	        		<g:else>
	        			<input type="checkbox" id="arxiuPermetreGSP" name="arxiuPermetreGSP"  value="0">	
	        		</g:else>
					
				</div>
			</div>
	        
			<!-- Propiedades del documento -->
			<div class="selectedTitol" id="box_101">
			  <div class="minus" id="title_box_101">
			    Propietats del document</div>
			</div>
			<!-- Contenido de Propiedades del documento -->
			<div class="dsplContent" id="dsplContent_box_101">
			
			 	<div class="row no-scroll-bar">
			 		<!-- aliesUri -->
			 	    <div class="col-xs-12 col-sm-3 col-md-2 col-lg-2  text-propietats">
						URL
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<input name="arxiuAliesUri" id="arxiuAliesUri" type="text" class="form-control row-margin-bottom-propietats" value="${params?.arxiuAliesUri?:arxiu?.aliesUri}">
					</div>
					
					<!-- template -->
			 	    <div class="col-xs-12 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Template
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<g:select name="arxiuTemplate" id="arxiuTemplate" class="form-control row-margin-bottom-propietats" from="${templateList?.titol}" keys="${templateList?.id}" value="${params?.arxiuTemplate?:arxiu?.template}"  noSelection="['':'-Escollir un template-']"/>
					</div>
					
					<!-- tipusContingut -->
			 	    <div class="col-xs-12 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Tipus de contingut
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<g:select name="arxiuTipusContingut" id="arxiuTipusContingut" class="form-control row-margin-bottom-propietats" from="${['HTML cercable', 'HTML no cercable', 'Carpeta']}" keys="${['SHTML', 'NHTML', 'FOLD']}" value="${params?.arxiuTipusContingut?:arxiu?.tipusContingut}"/>
					</div>
					
					<!-- dataActualitzacio -->
			 	    <div class="col-xs-5 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Actualitzat
					</div>
          			<div class="col-xs-7 col-sm-9 col-md-10 col-lg-10">
						<g:textField readonly="readonly" name="arxiuDataActualitzacio" id="arxiuDataActualitzacio" class="form-control row-margin-bottom-propietats" value="${params?.arxiuDataActualitzacio?:arxiu?.dataActualitzacio?.format("dd/MM/yyyy")}" title="Data de la darrera d'actualització del document"/>
					</div>
					
					<!-- dataIniciPublicacio -->
			 	    <div class="col-xs-5 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Publicar des de
					</div>
          			<div class="col-xs-7 col-sm-9 col-md-10 col-lg-10">
						<g:textField readonly="readonly" name="arxiuDataIniciPublicacio" id="arxiuDataIniciPublicacio" class="form-control row-margin-bottom-propietats" value="${params?.arxiuDataIniciPublicacio?:arxiu?.dataIniciPublicacio?.format("dd/MM/yyyy")}" title="Data a partir de la qual serà vàlid el contingut"/>
					</div>
					
					<!-- dataFiPublicacio -->
			 	    <div class="col-xs-5 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Publicar fins
					</div>
          			<div class="col-xs-7 col-sm-9 col-md-10 col-lg-10">
						<g:textField readonly="readonly" name="arxiuDataFiPublicacio" id="arxiuDataFiPublicacio" class="form-control row-margin-bottom-propietats" value="${params?.arxiuDataFiPublicacio?:arxiu?.dataFiPublicacio?.format("dd/MM/yyyy")}" title="Data a partir de la qual ja no serà vàlid el contingut"/>
					</div>
					
					<!-- estat -->
			 	    <div class="col-xs-12 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Publicar
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<g:select name="arxiuEstat" id="arxiuEstat" class="form-control row-margin-bottom-propietats" from="${['Sí', 'No']}" keys="${[1,0]}" value="${params?.arxiuEstat?:arxiu?.estat}"/>
					</div>
					
					<!-- paraulesClau -->
					<div class="col-xs-12 col-sm-3 col-md-2 col-lg-2  text-propietats">
						Paraules clau
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<input name="arxiuParaulesClau" id="arxiuParaulesClau" type="text" class="form-control row-margin-bottom-propietats" value="${params?.arxiuParaulesClau?:arxiu?.paraulesClau}">
					</div>
					
					<!-- descripcio -->
			 	    <div class="col-xs-12 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Descripció
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<textarea name="arxiuDescripcio" id="arxiuDescripcio" class="form-control row-margin-bottom-propietats">${params?.arxiuDescripcio?:arxiu?.descripcio}</textarea>
					</div>

			 		<!-- usuariDarrerCanvi -->
			 	    <div class="col-xs-12 col-sm-3 col-md-2 col-lg-2  text-propietats">
						Modificat per
					</div>
          			<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
						<g:textField disabled="true" name="arxiuUsuariDarrerCanvi" id="arxiuUsuariDarrerCanvi" type="text" class="form-control row-margin-bottom-propietats" value="${arxiu?.usuariDarrerCanvi}" />
					</div>
					
					<!-- dataDarrerCanvi -->
			 	    <div class="col-xs-5 col-sm-3 col-md-2 col-lg-2 text-propietats">
						Darrer canvi
					</div>
          			<div class="col-xs-7 col-sm-9 col-md-10 col-lg-10">
						<g:textField disabled="true" name="arxiuDataDarrerCanvi" id="arxiuDataDarrerCanvi" class="form-control row-margin-bottom-propietats" value="${arxiu?.dataDarrerCanvi?.format("dd/MM/yyyy")}" title="Data de l'últim canvi"/>
					</div>
				</div>
	
			</div>
			<br><br><br>
		  </form>
		  
		  <g:if test="${!(arxiu?.permetreGSP==0 || arxiu?.permetreGSP==null)}">
			<script>
				 CodeMirror.fromTextArea(document.getElementById('arxiuContingut'), {
				
				});
			</script>
		  </g:if>	
	</body>

</html>