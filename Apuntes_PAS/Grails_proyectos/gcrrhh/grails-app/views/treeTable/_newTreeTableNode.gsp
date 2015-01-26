<g:each in="${c}" var="child">
	<tr class="branch order-${level}" data-tt-id="${child.identity}" data-tt-parent-id="${child.parent}">
		<td>
			<span class="file">
				<g:link controller="editor" action="edit" id="${child.identity}">${child.title.encodeAsHTML()}</g:link>
			</span>
		</td>
		
		<td>${child.changed_by}</td>
			
		<td>${child.changed_on}</td>
		<td>
			<g:form url="[action:'delete',controller:'editor']">
				<g:hiddenField name="id" value="${child.identity}" />										
				<g:actionSubmitImage value="s" action="delete" src="${resource(dir:'images/icons',file:'papelera.png')}" onclick="return confirm('Està segur?');" title="Esborrar" />
			</g:form>
		</td>
	</tr>
	<g:if test="${child.children.size()}">
		<g:render template="newtreeTableNode" model="[c:child.children, level:level+1]"/>
	</g:if>
</g:each>


