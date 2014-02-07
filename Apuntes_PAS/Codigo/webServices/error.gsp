<html>
<head>
	<!-- <meta name="layout" content="mainAdministrador" /> -->

	<title>Funcions</title>
	
	<script type="text/javascript" src="${resource(dir:'js',file:'crossbrowser.js')}"></script>	
	<script type="text/javascript">
    
    	function loadIframes(nom, cog1, cog2)
		{    		
    		//alert(nom+" "+ cog1+" "+ cog2)
			document.getElementById('iframe').src = "iframeList/?idNom="+nom+"&idCognom1="+cog1+"&idCognom2="+cog2;
		}   
   	 </script>	
</head>

<body>
	<div class="nav">
		<div class="leftNav">
			<span class="menuButton">
				<a class="home" href="${createLink(uri: '/llocsRiscAdmin')}">
					Inici
				</a>
			</span>	
			<sec:access expression="hasRole('ROLE_USER')">
				<span class="menuButton">
					<a class="jump_user" href="${createLink(uri: '/')}">
						Racó personal
					</a>
				</span>	
			</sec:access>	
			<sec:access expression="hasRole('ROLE_GESTOR')">
				<span class="menuButton">
					<a class="jump_gestor" href="${createLink(uri: '/llocsRiscGestio')}">
						Gestió
					</a>
				</span>	
			</sec:access>	
		</div>
		<div class="menuButton logout floatRight"> 
			<g:if test="${session.user!=null}">
				<span class="login"> 
					${session.user}
				</span>
			</g:if> 
			<g:link class="exit" controller="logout">Desconnecta</g:link>
		</div>
	</div>
	<div class="body">
	
		<h2>ERROR</h2>
        <g:if test="${flash.message}">
        	<div class="message">Detall de l'error: ${flash.message}</div>
        </g:if>
		<div class="dialog">
<!-- aqui va el buscador -->
		<br/>			
		<div class="list" style="overflow-y:hidden; overflow-x:auto;">
		</div>		


	</div>
	</div>
</body>
</html>
