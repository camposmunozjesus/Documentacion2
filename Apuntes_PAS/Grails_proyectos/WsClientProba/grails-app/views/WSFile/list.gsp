<html>
<head>
	<!-- <meta name="layout" content="main" /> -->
	
	<title>Fitxer</title>
	
		
</head>

<body>	
	<div class="nav">
		<div class="leftNav">
			<span class="menuButton">
				<a class="home" href="${createLink(uri: '/')}">
					Inici
				</a>
			</span>
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
		<h2>
			Fitxer
		</h2>
		<div class="marginTop">
			<g:form action="visualitzarFitxer" method="POST">
				<g:if test="${flash.message}">
					<div class="message">
						<p>${flash.message}</p>
					</div>
				</g:if>
			
				<fieldset class="border padding">
				<legend align="left" style="margin-left:15px">Selecció</legend>				
				<div>
					<div class="floatLeft padding cercaDates" style="height: 30px; vertical-align: text-top;">
						<label for="anyMes">Data &nbsp;</label><g:select name="anyMes" id="anyMes" keys="${['201409','201410']}" from="${['201409','201410']}" value="${params.anyMes}"/>														
						
					</div>					
				</div>
				</fieldset>	
				<div class="buttons">
					<span class="button">
						<g:actionSubmit name="visualitzarFitxer" class="preview" action="visualitzarFitxer" value="Visualitzar fitxer" onclick="this.form.target='_blank';return true;"/> 
					</span>
					<span class="button">
						<g:actionSubmit name="descarregarFitxer" class="save" action="descarregarFitxer" value="Descarregar fitxer" onclick="this.form.target='';return true;"/>
					</span>
				</div>
			</g:form>
		</div>
		
	</div>
</body>
</html>
