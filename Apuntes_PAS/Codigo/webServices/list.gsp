<html>
<head>
	<!-- <meta name="layout" content="mainAdministrador" /> -->

	<title>Funcions</title>
	
	<script type="text/javascript" src="${resource(dir:'js',file:'crossbrowser.js')}"></script>	
	<script type="text/javascript">
    
    	function loadIframes(nom, cog1, cog2)
		{    		
    		//alert(nom+" "+ cog1+" "+ cog2)
			document.getElementById('iframe').src = "iframeDatalanguage/?idNom="+nom+"&idCognom1="+cog1+"&idCognom2="+cog2;
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
	
		<h2>RESULATADOS DEL WS</h2>
        <g:if test="${params.hora}">
        	<div class="message">Data actual: ${params.fecha}
        	<br><br><br>
        	Hora: ${params.hora}</div>
        </g:if>
        
        <g:if test="${params.prueba}">
        	<div class="message">Resultado: ${params.prueba}</div>
        	
        </g:if>
		<div class="dialog">
		
		<!-- aqui va el buscador -->
		<br/>			
			<div class="list" style="overflow-y:hidden; overflow-x:auto;">
			
			
		
		</div>	
			<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.nl/maps?f=q&amp;source=s_q&amp;hl=nl&amp;geocode=&amp;q=Donbas_Arena&amp;aq=&amp;sll=50.423133,30.522142&amp;sspn=0.113305,0.256462&amp;ie=UTF8&amp;hq=Donbas_Arena&amp;hnear=&amp;radius=15000&amp;t=m&amp;ll=48.021003,37.810167&amp;spn=0.096084,0.071946&amp;output=embed"></iframe><br /><small><a href="http://maps.google.nl/maps?f=q&amp;source=embed&amp;hl=nl&amp;geocode=&amp;q=Donbas_Arena&amp;aq=&amp;sll=50.423133,30.522142&amp;sspn=0.113305,0.256462&amp;ie=UTF8&amp;hq=Donbas_Arena&amp;hnear=&amp;radius=15000&amp;t=m&amp;ll=48.021003,37.810167&amp;spn=0.096084,0.071946" style="color:#0000FF;text-align:left">Larger Map</a></small>

			<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.nl/maps?f=q&amp;source=s_q&amp;hl=nl&amp;geocode=&amp;q=Arena,+Tov,+Lviv,+L'vivs'ka,+Ukraine&amp;aq=0&amp;oq=Arena+Lvi&amp;sll=48.021003,37.810167&amp;sspn=0.11895,0.256462&amp;ie=UTF8&amp;hq=Arena,+Tov,&amp;hnear=Lviv,+Oblast+Lviv,+Oekra%C3%AFne&amp;t=m&amp;ll=49.816566,24.076408&amp;spn=0.050857,0.10272&amp;output=embed"></iframe><br /><small><a href="http://maps.google.nl/maps?f=q&amp;source=embed&amp;hl=nl&amp;geocode=&amp;q=Arena,+Tov,+Lviv,+L'vivs'ka,+Ukraine&amp;aq=0&amp;oq=Arena+Lvi&amp;sll=48.021003,37.810167&amp;sspn=0.11895,0.256462&amp;ie=UTF8&amp;hq=Arena,+Tov,&amp;hnear=Lviv,+Oblast+Lviv,+Oekra%C3%AFne&amp;t=m&amp;ll=49.816566,24.076408&amp;spn=0.050857,0.10272" style="color:#0000FF;text-align:left">Larger Map</a></small>

	</div>
	</div>
</body>
</html>