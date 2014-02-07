<html>
<head>
	<!-- <meta name="layout" content="void" />  -->
	
	<title>Funcions</title>
	
	<script type="text/javascript" src="${resource(dir:'js',file:'crossbrowser.js')}"></script>	
	 
</head>
	  	
<body>
<br/><br/><br/><br/><br/>
	<div class="bodyIframe">
	
		<h2>TRADUCCIONS A L'IDIOMA ${idioma}</h2>
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
			<g:if test="${dia}">
	        	La traducció del dia de la setmana escollit a l'idioma desitjat és: ${dia}<br><br>
	        </g:if>
	        
	       	<g:if test="${llistaDies}">
				<table id="tableList">
					<thead>
						<tr>
							<th class="sortable text">Català</th>
							<th class="sortable text">Traducció</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${llistaDies}" status="i" var="dia">
							<tr>
								<td>
									${llistaDiesCat	[i]}
								</td>
								<td>
									${dia}
								</td>
							</tr>						
						</g:each>
					</tbody>
				</table>
	        </g:if>
	        <br><br>
			<g:if test="${mes}">
	        	La traducció del mes de l'any escollit a l'idioma desitjat és: ${mes}<br><br>
	        </g:if>
	        
	        <g:if test="${llistaMesos}">
				<table id="tableList">
					<thead>
						<tr>
							<th class="sortable text">Català</th>
							<th class="sortable text">Traducció</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${llistaMesos}" status="i" var="mes">
							<tr>
								<td>
									${llistaMesosCat[i]}
								</td>
								<td>
									${mes}
								</td>
							</tr>						
						</g:each>
					</tbody>
				</table>
	        </g:if>
		</div>	
	</div>
	</div>
</body>
</html>