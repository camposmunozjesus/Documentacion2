<html>
	<head>
		
		<meta name="layout" content="main" />
		<title>Arbre de continguts</title>

		<link href="/${grails.util.Metadata.current.'app.name'}/css/treeTable/jquery.treetable.css" rel="stylesheet" type="text/css" />
		<link href="/${grails.util.Metadata.current.'app.name'}/css/treeTable/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
    
    		
		<script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/jquery/jquery.js"></script>
		
		<script src="/${grails.util.Metadata.current.'app.name'}/js/treeTable/jquery.treetable.js"></script>
    
		<style>
			.message {
			    background: #f3f8fc url(../images/icons/information.png) 8px 50% no-repeat;
			    border: 1px solid #b2d1ff;
			    color: #006dba;
			    margin: 10px 0 5px 0;
			    padding: 5px 5px 5px 30px
			}
			.delete{
				background-image: url("../images/icons/papelera.png");
				background-repeat: no-repeat;
			}
			.order-2 > td:first-child
			{
			   padding-left: 35px;
			}
			
			.order-3 > td:first-child
			{
			   padding-left: 65px;
			}
			
			.order-4 > td:first-child
			{
			   padding-left: 95px;
			}
		</style>
	</head>
	<body>

		<g:if test="${flash.message}">
			<div class="message">
				<p>${flash.message}</p>
			</div>
		</g:if>

		<table id="expandable-tree-table" class="table table-hover">
			<thead>
				<tr>
					<th width="60%">Pàgina</th>
					<th width="16%">Modificat per</th>
					<th width="16%">Últim canvi</th>
					<th width="8%">Accions</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${content}" var="c">

						<g:render template="newtreeTableNode" model="[c:c, level:1]"/>

 				</g:each>	
			</tbody>
		</table>
		
		<script>
	  		$("#expandable-tree-table").treetable({ expandable: true });
    	</script>
    
	</body>
</html>