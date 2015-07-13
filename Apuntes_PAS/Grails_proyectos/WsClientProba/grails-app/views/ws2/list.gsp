<html>
<head>
	<!-- <meta name="layout" content="mainUser" /> -->
	
	<title>Dades personals</title>
	
	<script type="text/javascript">
    
    	function loadIframes()
		{
			document.getElementById('iframe').src = "iframeResult/?cognom="+document.getElementById('cognom').value;
		}     	
   	 </script>	
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
			dades personals
		</h2>
		<g:if test="${flash.message}">
			<div class="message">
				<p>${flash.message}</p>
			</div>
		</g:if>
		<div class="bodyIframe">
		<g:form>
			<fieldset class="padding border">
			<legend>dades personals</legend>
			<div class="scrollYframeLloc">				
	  			<div class="marginRight marginTopIE floatLeft">
					<div class="padding">			

						<g:form>
							
							<br/>
							Introduïu cognom: <g:textField name="cognom" id="cognom" value="${cognom}"/>
							
						</g:form>
					  </div>
					</div>
				</div>
				</fieldset>  				
		</g:form>
		<g:submitButton class="buttons buttonsTableIE" name="shakesButton"  value="Obtenir" onclick="loadIframes()"/>
	</div>
		<div id="iframeResultat">
			<iframe id="iframe" name="iframe" src="" title="Dades Personals" height="510px" width="100%" frameborder="0" scrolling="no"></iframe>
		</div>
	</div>
</body>
</html>
