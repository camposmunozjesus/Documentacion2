<html>
<head>
	<!-- <meta name="layout" content="void" />  -->
	
	<title>Funcions</title>
	
	<script type="text/javascript" src="${resource(dir:'js',file:'crossbrowser.js')}"></script>	
	 
</head>
	  	
<body>
<br/><br/><br/><br/><br/>
	<div class="bodyIframe">
	
		<h2>DADES CERCADES</h2>
		<!-- aqui va el buscador -->
		<br/>			
		<div class="list" style="overflow-y:hidden; overflow-x:auto;">
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
	        
		</div>	
	</div>
	</div>
</body>
</html>