<html>
  <head>
	<!-- <meta name="layout" content="void" />  -->
	<title>Dades Personal</title>
	
	 </head>
  <body>
	<div>
 		<g:if test="${flash.message}">
			<div class="message">
				<p>${flash.message}</p>
			</div>
		</g:if>
		<g:if test="${persList}">
			<h4>Dades</h4>	
			<div class="list">
				<fieldset class="padding border">
				<table id="tableList">
					<thead>
						<tr>
							<th class="sortable text">Nom</th>
							<th class="sortable text">Cognom 1</th>
							<th class="sortable text">Cognom 2</th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${persList}" status="i" var="persInstance">
						<tr id="tr${i}" class="${(i % 2) == 0 ? 'odd' : 'even'}">
							<td class="padding width05p">								
								${persInstance.nom}
							</td>
							<td class="padding width05p">								
								${persInstance.cognom1}
							</td>
							<td class="padding width05p">								
								${persInstance.cognom2}
							</td>
						</tr>				
					</g:each>
					</tbody>
				</table>

				</fieldset>
	   		</div>
	   	
		</g:if>
	</div>
  </body>
</html>
