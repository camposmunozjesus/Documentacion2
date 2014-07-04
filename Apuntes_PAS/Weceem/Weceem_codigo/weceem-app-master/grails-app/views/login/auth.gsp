<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<link rel="shortcut icon" href="${resource(dir:'_weceem/images',file:'favicon.ico')}" type="image/x-icon" />
	
	<link rel="stylesheet" href="${resource(dir:'_weceem/css',file:'main.css')}" />
	<!--[if IE]> 
		<link rel="stylesheet" href="${resource(dir:'_weceem/css',file:'mainIE.css')}" /> 
	<![endif]-->
	<link rel="stylesheet" href="${resource(dir:'_weceem/css',file:'estilos.css')}" />
	<link rel="stylesheet" href="${resource(dir:'_weceem/css',file:'styleHelper.css')}" />
	<script type="text/javascript" src="${resource(dir:'_weceem/js',file:'library.js')}"></script>
    <title><g:message code="title.login"/></title>
    <script type="application/javascript">
     $( function() {
        $('#loginName')[0].focus(); 
     })
    </script>

  </head>

  
 
	<body id="cas">
${params }
        <div class="container" style="margin-top:200px">
        <div class="prepend-8 span-8 append-8 last">
            <div class="container span-8 last box ui-corner-all">

                <div class="span-8 prepend-top last">
                    <g:if test="${flash.message}">
                         <div class="append-bottom ui-state-highlight">
                               ${flash.message}
                         </div>
                    </g:if>

                    <form action="${createLinkTo(dir: 'j_spring_security_check')}" method="post">
                        <div class="span-3">
                            <label for="loginName"><g:message code="label.userName"/></label>
                        </div>
                        <div class="span-5 last">
                            <input type="text" name="j_username" id="loginName"/>
                        </div>

                        <div class="span-3">
                            <label for="loginPassword"><g:message code="label.userPassword"/></label>
                        </div>
                        <div class="span-5 last">
                            <input type="password" name="j_password" id="loginPassword"/>
                        </div>

                        <div class="prepend-3 span-5 last">
                            <input type="checkbox" name="_spring_security_remember_me" id="rememberMe"><label for="rememberMe"><g:message code="label.rememberMe"/></label>
                        </div>
                
                        <div class="prepend-3 prepend-top span-5 last">
                            <input type="submit" id="loginSubmit" class="button ui-corner-all ui-state-default ui-priority-primary ui-widget" value="${message(code: 'command.login', encodeAs:'HTML')}"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>



     

</html>