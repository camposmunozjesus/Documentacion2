<sec:ifNotLoggedIn>
  <g:link controller="login" action="auth">Login</g:link>
</sec:ifNotLoggedIn>
<sec:ifAllGranted roles="ROLE_USER">
  <g:link class="create" controller="post" action="timeline">My Timeline</g:link>
</sec:ifAllGranted>
<sec:username /> (<g:link controller="logout">sign out</g:link>)