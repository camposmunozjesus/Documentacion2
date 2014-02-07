<html>
<head>
	<!-- <meta name="layout" content="mainAdministrador" /> -->

	<title>Funcions</title>
	
	<script type="text/javascript" src="${resource(dir:'js',file:'crossbrowser.js')}"></script>	
	<script type="text/javascript">
		function loadIframes()
		{   
			var idioma =document.getElementById('filtreIdioma').value;
			var subIdioma
			if(document.getElementById('filtreSubIdioma')!=null){
				subIdioma=document.getElementById('filtreSubIdioma').value;
			}
			var dia =document.getElementById('filtreDia').value;
			var mes =document.getElementById('filtreMes').value;

			document.getElementById('iframe').src = "iframeDetall/?idIdioma="+idioma+"&idSubIdioma="+subIdioma+"&idDia="+dia+"&idMes="+mes;
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
	
		<h2>SERVEI WEB DE DADES DE LA LLIGA DE FUTBOL UCRANÏANA</h2>
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
		
		<g:form>
			<g:hiddenField name="idIdioma" value="" />
			<g:hiddenField name="idSubIdioma" value="" />
			<g:hiddenField name="idDia" value="" />
			<g:hiddenField name="idMes" value="" />
			<fieldset class="border" style="margin-top:10px">
			<legend align="left" style="margin-left:15px">Paràmetres de la cerca:</legend>
				<table class="noborder">
					<tbody>							
						<tr class="prop noBackground">
							<td valign="top" align="center" class="name">
							    <g:select class="width200px" name="filtreEstadi" from="${estadisList}"  keys="${estadisList}"  value="" noSelection="['':'-Tria un idioma-']"/>							   
							</td>
						</tr>							
	 				</tbody>
				</table>
			</fieldset>			

		</g:form>
		
		<div class="buttons">
			<span class="button">
				<g:submitButton name="update" class="update" value="Aceptar" onclick="loadIframes()"/>
			</span> 
		</div>
		</div>	
	</div>
	
	<div id="iframeDetallFutbol">
		<iframe id="iframe" name="iframe" title="Detall risc" src="" height="800px" width="100%" frameborder="0" scrolling="no"></iframe>
	</div>
		
	</div>
</body>
</html>