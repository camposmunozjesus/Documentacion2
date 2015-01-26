<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<title><g:layoutTitle default="Grails" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    
	    <link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/bootstrap.css" type="text/css">
	    <script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/jquery/jquery-1.11.1.min.js"></script>
	    <script type="text/javascript" src="/${grails.util.Metadata.current.'app.name'}/js/bootstrap.min.js"></script>
	    
	    <link rel="shortcut icon" href="/${grails.util.Metadata.current.'app.name'}/PAS/images/favicon.ico" type="image/x-icon">
	    
	    <link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/main.css" type="text/css">
	    <link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/bootstrapUPC.css" type="text/css">
	    <link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/estilsUPC.css" type="text/css">
	    <link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/sticky-footer.css" type="text/css">
	    <link rel="stylesheet" href="/${grails.util.Metadata.current.'app.name'}/css/tmp.css" type="text/css">
	    
	    <g:layoutHead />
	    
	</head>
   <div class="container">
      <div class="container-UPC">
       <!-- ************ INI top-nav ************ -->
        <div id="spinner" class="spinner" style="display: none;">
          <img alt="Carregant..." src="/${grails.util.Metadata.current.'app.name'}/PAS/images/spinner.gif">
        </div>
        
        <div class="row no-scroll-bar">
          <div class="col-xs-12 col-vxs-12 col-sm-7 col-md-7 col-lg-8 row-margin-bottom-header">
            <h1 class="pull-left logo-portal">
              <img usemap="#upc_link" class="img-responsive" alt="Universitat Politècnica de Catalunya" src="/${grails.util.Metadata.current.'app.name'}/PAS/images/logo_upc_portal_pas_2.png" style="border:0;">
              <map name="upc_link">
                <area shape="Rect" coords="0,0,50,60" href="http://www.upc.edu" target="_blank">
              </map>
            </h1>  
          </div>
          <div class="col-xs-12 col-vxs-12 col-sm-5 col-md-5 col-lg-4 row-margin-bottom-header">
            <div class="navbar navbar-default navbar-Info" > <!--  role="navigation"  -->
              <div class="navbar-container-UPC">
                <div class="navbar-header">
                  <div class="columna-centrada-header">
                    
                    
                    <button class="navbar-toggle collapsed navbar-toggle-header btn-header" data-target="#navbar-collapse-search" data-toggle="collapse" type="button">
                      <span class="sr-only">Cercar</span>
                      <span class="glyphicon glyphicon-search"></span>
                    </button>
                    <button class="navbar-toggle collapsed navbar-toggle-header btn-header" data-target="#navbar-collapse-info" data-toggle="collapse" type="button">
                      <span class="sr-only">Contacte i directori</span>
                      <span class="glyphicon glyphicon-info-sign"></span>
                    </button>
                    <button class="navbar-toggle collapsed navbar-toggle-header btn-header" data-target="#navbar-collapse-portal" data-toggle="collapse" type="button">
                      <span class="sr-only">Altres portals</span>
                      <span class="glyphicon glyphicon-new-window"></span>
                    </button>      
                    
                    
                  </div>      
                </div>
                <div class="columna-centrada">
                  <div id="navbar-collapse-search" class="navbar-collapse collapse">        
                    <ul class="nav navbar-nav navbar-right search-position">          
                      <li>
                        <div class="clearfix pull-right buscador">
                          
                          <form action="/${grails.util.Metadata.current.'app.name'}/searcher/index" method="post"><input name="query" class="customSearchField" placeholder="Cercar..." onfocus="" value="" id="query" type="text"><input name="_action_index" class="customSearchButton" value="Cerca" type="submit"></form>
                          
                        </div>
                      </li>
                    </ul>        
                  </div>
                </div>
                
                <div id="navbar-collapse-info" class="navbar-collapse collapse navbar-info format-lletra-upc">        
                  <ul class="nav navbar-nav navbar-right info-position">          
                    <li>
                      <span class="contacte">
                        <a href="/${grails.util.Metadata.current.'app.name'}/PAS/contacte" target="_blank" onclick="window.open(this.href,this.target,'width=750,height=950,resizable=yes,scrollbars=yes');return false">Contacte</a>
                      </span>
                    </li>
                    <li>
                      <span class="enllacPortal">
                        <a href="http://directori.upc.edu/directori/" target="_blank" onclick="window.open(this.href,this.target,'width=750,height=550,resizable=yes');return false">Directori UPC</a>
                      </span>
                    </li>
                  </ul>    
                </div>        
                <!-- /.nav-collapse -->
              </div>
              <!-- /.container-fluid -->
            </div>
          </div>
        </div>
        
        <div class="row no-scroll-bar">
          <div class="col-vxs-12 col-sm-7 col-md-7 col-lg-8">
            <div id="navbar-collapse-portal" class="navbar-collapse collapse navbar-portal format-lletra-upc">        
              <ul class="nav navbar-nav">
                <li>
                  <span class="enllacPortalFirst portal-UPC">
                    <a href="/${grails.util.Metadata.current.'app.name'}/PDI/">Portal PDI</a>
                  </span>
                  
                </li>
                <li>
                  <span class="enllacPortal">  
                    <a href="/${grails.util.Metadata.current.'app.name'}/Gestor/">Portal gestor/a</a>
                  </span>
                </li>  
                <li>
                  <span class="enllacPortal enllacPortalLast">
                    <a href="/${grails.util.Metadata.current.'app.name'}/BEC/">Portal beques grau/màster</a>
                  </span>
                </li>
              </ul>
            </div>
          </div>  
        </div>
        
        <!-- STATUS BAR ESTÁTICA -->
        <div class="navbar navbar-default navbar-UPC" > <!--  role="navigation"  -->
          <div class="container-fluid">
            <div class="navbar-header">
              <button class="navbar-toggle collapsed navbar-toggle-home" data-target="#navbar-collapse-menu" data-toggle="collapse" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand home" href="/${grails.util.Metadata.current.'app.name'}/PAS/index">Inici</a>
            </div>
            <div id="navbar-collapse-menu" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li>                    
                  <a class="Informacio_General" href="/${grails.util.Metadata.current.'app.name'}/PAS/index/Informacio_General">Informació General</a>
                </li>
                <li>                    
                  <a class="Raco_Personal" href="/${grails.util.Metadata.current.'app.name'}/PAS/index/Raco_Personal">Racó Personal</a>
                </li>
              </ul>   
              <!-- Part dreta: usuari, desconnexió -->
              <ul class="nav navbar-nav navbar-right format-lletra-upc">
                <li class="active">
                  <g:if test="">            
                    <span class="login-UPC">  </span>
                  </g:if>
                </li>
                <li>
                  <span class="logout-UPC"> <g:link controller="logout">Desconnecta</g:link></span>
                </li>
              </ul>
            </div>
            <!-- /.nav-collapse -->
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- ************ FIN top-nav ************ -->
        <!-- ************ INI breadCrumb-slider-bar ************ -->      
        <div class="breadCrumb">
          <!-- Título página -->
          <h1 class="firstHeading"><span></span>
            <g:layoutTitle default="Grails" />
          </h1>
        </div>
        <!-- ************ FIN breadCrumb-slider-bar ************ -->      
      </div>
      
        <!-- Rejilla con el contenido principal -->
  

        <g:layoutBody/>
     
        
      </div>
    <!-- Pie de página -->
    <!-- ************ INI bottom-nav ************ -->
    <div class="footer">
      <div class="container">
        <div class="fit2container">      
          <div class="row no-scroll-bar">          
            <div class="col-xs-12 col-footer-9 col-vxs-9 col-sm-9 col-md-9 col-lg-9">
              <p class="footer-text">Vicegerència de Personal i Organització</p>
              <p class="footer-text">© <a href="http://www.upc.edu">UPC</a>. Universitat Politècnica de Catalunya <span>●</span> BarcelonaTech</p>           
            </div>        
            <div class="col-xs-12 col-footer-3 col-vxs-3 col-sm-3 col-md-3 col-lg-3 row-margin-top-peu">
              <div class="accessibilitat-container">
                <a class="footer-text" href="/${grails.util.Metadata.current.'app.name'}/PAS/accessibilitat" target="_blank" onclick="window.open(this.href,this.target,'width=1100,height=950,resizable=yes,scrollbars=yes');return false">Accessibilitat</a>
                <a class="footer-text" href="#top"><img alt="Amunt" src="/${grails.util.Metadata.current.'app.name'}/PAS/images/icons/amunt.gif"></a>                        
              </div>
            </div>
          </div>     
        </div>    
      </div>
    </div>    
    <!-- ************ FIN bottom-nav ************ -->
  </body>
</html>
