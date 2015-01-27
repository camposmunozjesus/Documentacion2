<html>
	<head>
		
		<meta name="layout" content="main" />
		<title>Edició de continguts</title>

		<link href="/${grails.util.Metadata.current.'app.name'}/css/treeTable/jquery.treetable.css" rel="stylesheet" type="text/css" />
		<link href="/${grails.util.Metadata.current.'app.name'}/css/treeTable/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
    
    		
		<script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/jquery/jquery.js"></script>
		
		<script src="/${grails.util.Metadata.current.'app.name'}/js/treeTable/jquery.treetable.js"></script>
        <ckeditor:resources/>
	</head>
	<body>${params.id}
	    <form controller="editor" action="save">
	    	<g:hiddenField name="identifier" value="${params.id}" />
			<ckeditor:editor name="myeditor" height="400px" width="100%">
				${initialValue}
			</ckeditor:editor>
			<g:actionSubmit value="Guardar" action="save"/>
	    </form>
	        
	
	</body>

</html>