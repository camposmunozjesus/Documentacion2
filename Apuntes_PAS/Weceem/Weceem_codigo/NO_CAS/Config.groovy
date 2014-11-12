// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
grails.resources.adhoc.excludes = ['/plugins/weceem-1.2']

grails.mime.file.extensions = false // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]
// The default codec used to encode data with ${}
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"

// Set JSON encoded dates to JS native ie. new Date(1194127343161)
grails {
    converters {
        encoding="UTF-8"
        json {
            date = 'javascript'
        }
    }
}

//navigation.'weceem.app.admin' = [
//    controller:'CMSUser',
//    action: 'list',
//    title: 'users'
//]

cache.headers.enabled = false

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true


//weceem.profile.url = [controller:'userProfile', action:'edit']
//weceem.logout.url = [controller:'logout']
weceem.content.prefix = ''
weceem.admin.prefix = 'admin'
weceem.tools.prefix="cms/tools"
weceem.space.templates = [
    default: "classpath:/org/weceem/resources/default-space-template.zip", 
    basic:"classpath:/org/weceem/resources/basic-space-template.zip"]

//weceem.springsecurity.details.mapper = { ->
//    [   // Stuff required by weceem spring sec
//        username: username,
//        password: passwd,
//        enabled: enabled,
//        authorities: authorities,
//        // optional stuff we add
//        email: email,
//        description: description,
//        firstName: firstName,
//        lastName: lastName,
//        id: id
//    ]
//}

// configure custom page for HTTP 404 response
// weceem.page404 = 'test404page'

grails.validateable.packages=['org.weceem']

// Configure Spring Security
grails {
    plugins {
//        springsecurity {
//            active = true
//            //registerLoggerListener = true
//
////            password.algorithm = "SHA-512"
////            dao.reflectionSaltSourceProperty = 'username'
////            //use Base64 text ( true or false )
////            password.encodeHashAsBase64 = false
////            adh.errorPage = "null"
//
//            // Turn of user caching, acegi plugin requires diskstore cache by default, which we don't want.
//            cacheUsers = false
//    
////            /** login user domain class name and fields */
////            userLookup.userDomainClassName = "Security.SecUser"
////            userLookup.userNamePropertyName = "username"
////            userLookup.passwordPropertyName = "passwd"
////            userLookup.enabledPropertyName = "enabled"
////            userLookup.authoritiesPropertyName = "authorities"
//
//            /**
//            * Authority domain class authority field name
//            * authorityFieldInList
//            */
////            authority.className = "Security.SecRole"
////            authority.nameField = "authority"
//
//            securityConfigType = 'InterceptUrlMap'
//            interceptUrlMap = [
////				'/admin/users/**': ['ROLE_ADMIN', 'IS_AUTHENTICATED_REMEMBERED'],
////				 '/admin/**':       ['IS_AUTHENTICATED_REMEMBERED'],
//				 // '/admin/users/**': ['ROLE_ADMIN', 'IS_AUTHENTICATED_REMEMBERED'],
////			   '/admin/**':       ['ROLE_ADMIN','IS_AUTHENTICATED_REMEMBERED'],
////			   '/Test/**':	['ROLE_ADMIN'],
//			   '/PAS/**':	['ROLE_ADMIN', 'IS_AUTHENTICATED_REMEMBERED'],
////			   '/Tempus/**':	['ROLE_GUEST','IS_AUTHENTICATED_REMEMBERED'],
////			   '/Tempus_v2/**':	['IS_AUTHENTICATED_REMEMBERED'],
////               '/ck/**':          ['IS_AUTHENTICATED_REMEMBERED'],
////               '/*':              ['IS_AUTHENTICATED_ANONYMOUSLY'],
////               '/login/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
////               '/logout/**':      ['IS_AUTHENTICATED_ANONYMOUSLY']
//			   
//            ]
//                
//            /** AJAX request header */
//            ajaxHeader = "X-Requested-With"
//
//            /** use basicProcessingFilter */
//            useBasicAuth = false
//            /** use switchUserProcessingFilter */
//            useSwitchUserFilter = false
//        }
    }
}

environments {
   development {

	   grails.serverURL = "http://localhost:8090/Portal"
	   grails.path = "D:\\gpr\\users\\fich\\"
		/* */
//	   grails.plugins.springsecurity.cas.loginUri = '/login'
//	   grails.plugins.springsecurity.cas.serviceUrl = 'http://localhost:8090/Portal/j_spring_cas_security_check'
//	   grails.plugins.springsecurity.cas.serverUrlPrefix = 'https://cas.upc.edu/'
//	   grails.plugins.springsecurity.cas.proxyCallbackUrl = 'http://localhost:8090/Portal/secure/receptor'
//	   grails.plugins.springsecurity.cas.proxyReceptorUrl = '/secure/receptor'
//	   grails.plugins.springsecurity.cas.useSingleSignOut = 'true'
//	   grails.plugins.springsecurity.logout.afterLogoutUrl ='https://cas.upc.edu/logout?url=http://localhost:8090/Portal/admin'
//
//	   grails.plugins.springsecurity.cas.active = true
//	   grails.plugins.springsecurity.cas.sendRenew = false
//	   grails.plugins.springsecurity.cas.serverUrlEncoding = 'UTF-8'
//	   grails.plugins.springsecurity.cas.key = 'grails-spring-security-cas'
//	   grails.plugins.springsecurity.cas.artifactParameter = 'ticket'
//	   grails.plugins.springsecurity.cas.serviceParameter = 'service'
//	   grails.plugins.springsecurity.cas.filterProcessesUrl = '/j_spring_cas_security_check'
	   /* */
//	   grails.plugins.springsecurity.securityConfigType = 'InterceptUrlMap'
//	   grails.plugins.springsecurity.interceptUrlMap = [
//		'/admin/users/**': ['ROLE_ADMIN', 'IS_AUTHENTICATED_REMEMBERED'],
//		 '/admin/**':       ['IS_AUTHENTICATED_REMEMBERED'],
//		 // '/admin/users/**': ['ROLE_ADMIN', 'IS_AUTHENTICATED_REMEMBERED'],
//		   //			   '/admin/**':       ['ROLE_ADMIN','IS_AUTHENTICATED_REMEMBERED'],
//		   '/Test/**':	['ROLE_ADMIN','IS_AUTHENTICATED_ANONYMOUSLY'],
//		   '/PAS/**':	['ROLE_ADMIN','IS_AUTHENTICATED_ANONYMOUSLY'],
//		   '/Tempus/**':	['ROLE_GUEST','IS_AUTHENTICATED_REMEMBERED'],
//		   '/Tempus_v2/**':	['IS_AUTHENTICATED_REMEMBERED'],
//		  '/ck/**':          ['IS_AUTHENTICATED_REMEMBERED'],
//		  '/*':              ['IS_AUTHENTICATED_ANONYMOUSLY'],
//		  '/login/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
//		  '/logout/**':      ['IS_AUTHENTICATED_ANONYMOUSLY']
//		   
//	   ]
		   
	   
       weceem.upload.dir = 'file:/var/www/weceem.org/uploads/'

       // log4j configuration
       log4j = {
           root {
               info()
               additivity = true
           }

/*
           debug   'org.weceem',
                   'grails.app.controller',
                   'grails.app.service',
                   'grails.app.filters',
                   'grails.app.task'
*/
           info    'org.weceem',
                   'grails.app'

           error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
                   'org.codehaus.groovy.grails.plugins', // plugins
                   'org.codehaus.groovy.grails.web.pages', //  GSP
                   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.commons', // core / classloading
                   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
                   'org.springframework',
                   'org.hibernate'
       }
   }
   test {
	
	   //MELNIK   
	   grails.serverURL = "http://melnik.upc.edu/Portal"
	   grails.path = "/app/sig/users/fich/"
					   
//	   grails.plugins.springsecurity.cas.loginUri = '/login'
//	   grails.plugins.springsecurity.cas.serviceUrl = 'http://melnik.upc.edu/Portal/j_spring_cas_security_check'
//	   grails.plugins.springsecurity.cas.serverUrlPrefix = 'https://cas.upc.edu/'
//	   grails.plugins.springsecurity.cas.proxyCallbackUrl = 'http://melnik.upc.edu/Portal/secure/receptor'
//	   grails.plugins.springsecurity.cas.proxyReceptorUrl = '/secure/receptor'
//	   grails.plugins.springsecurity.cas.useSingleSignOut = 'true'
//	   grails.plugins.springsecurity.logout.afterLogoutUrl ='https://cas.upc.edu/logout?url=http://melnik.upc.edu/Portal/admin'
//	   
//	   grails.plugins.springsecurity.cas.active = true
//	   grails.plugins.springsecurity.cas.sendRenew = false
//	   grails.plugins.springsecurity.cas.serverUrlEncoding = 'UTF-8'
//	   grails.plugins.springsecurity.cas.key = 'grails-spring-security-cas'
//	   grails.plugins.springsecurity.cas.artifactParameter = 'ticket'
//	   grails.plugins.springsecurity.cas.serviceParameter = 'service'
//	   grails.plugins.springsecurity.cas.filterProcessesUrl = '/j_spring_cas_security_check'
	   
	   
	   //MERLOT
//	   grails.serverURL = "https://merlot.upc.edu/Portal"
//	   grails.path = "/app/portal/users/fich/"
//					   
//	   grails.plugins.springsecurity.cas.loginUri = '/login'
//	   grails.plugins.springsecurity.cas.serviceUrl = 'https://merlot.upc.edu/Portal/j_spring_cas_security_check'
//	   grails.plugins.springsecurity.cas.serverUrlPrefix = 'https://cas.upc.edu/'
//	   grails.plugins.springsecurity.cas.proxyCallbackUrl = 'https://merlot.upc.edu/Portal/secure/receptor'
//	   grails.plugins.springsecurity.cas.proxyReceptorUrl = '/secure/receptor'
//	   grails.plugins.springsecurity.cas.useSingleSignOut = 'true'
//	   grails.plugins.springsecurity.logout.afterLogoutUrl ='https://cas.upc.edu/logout?url=https://merlot.upc.edu/Portal/admin'
//	   
//	   grails.plugins.springsecurity.cas.active = true
//	   grails.plugins.springsecurity.cas.sendRenew = false
//	   grails.plugins.springsecurity.cas.serverUrlEncoding = 'UTF-8'
//	   grails.plugins.springsecurity.cas.key = 'grails-spring-security-cas'
//	   grails.plugins.springsecurity.cas.artifactParameter = 'ticket'
//	   grails.plugins.springsecurity.cas.serviceParameter = 'service'
//	   grails.plugins.springsecurity.cas.filterProcessesUrl = '/j_spring_cas_security_check'
	   
	   //otros
//	   grails.serverURL = "http://localhost:8080/Portal"
//	   grails.path = "/app/sal/users/fich/"
//					   
//	   grails.plugins.springsecurity.cas.loginUri = '/login'
//	   grails.plugins.springsecurity.cas.serviceUrl = 'http://localhost:8080/Portal/j_spring_cas_security_check'
//	   grails.plugins.springsecurity.cas.serverUrlPrefix = 'https://cas.upc.edu/'
//	   grails.plugins.springsecurity.cas.proxyCallbackUrl = 'http://localhost:8080/Portal/secure/receptor'
//	   grails.plugins.springsecurity.cas.proxyReceptorUrl = '/secure/receptor'
//	   grails.plugins.springsecurity.cas.useSingleSignOut = 'true'
//	   grails.plugins.springsecurity.logout.afterLogoutUrl ='https://cas.upc.edu/logout?url=http://localhost:8080/Portal/admin'
//	   
//	   grails.plugins.springsecurity.cas.active = true
//	   grails.plugins.springsecurity.cas.sendRenew = false
//	   grails.plugins.springsecurity.cas.serverUrlEncoding = 'UTF-8'
//	   grails.plugins.springsecurity.cas.key = 'grails-spring-security-cas'
//	   grails.plugins.springsecurity.cas.artifactParameter = 'ticket'
//	   grails.plugins.springsecurity.cas.serviceParameter = 'service'
//	   grails.plugins.springsecurity.cas.filterProcessesUrl = '/j_spring_cas_security_check'

	   
	   // log4j configuration
	   log4j = {
		   
			// Logging warnings and higher for all of the app
			error 'grails.app'
			error 'grails.util.GrailsUtil'
			
			// Logging infos and higher for all controllers
			info 'grails.app.controller'
	   
			appenders
			{
			   // Use if we want to prevent creation of a stacktrace.log file.
			   'null' name:'stacktrace'
		
			   // Use this if we want to modify the default appender called 'stdout'.
			   console name:'stdout', layout:pattern(conversionPattern: '[%t] %-5p %c{2} %x - %m%n')
		
			   // Custom log file.
			   rollingFile name:"logError",
							   file: "/app/portal/users/log/Portal_Error.log",
							   maxFileSize:'1000kB',
							   threshold: org.apache.log4j.Level.ERROR,
							   maxBackupIndex:100,
							   layout:pattern(conversionPattern: '%d{[EEE, dd-MMM-yyyy @ HH:mm:ss.SSS]} [%t] %-5p %c %x - %m%n\n')
			   
			   rollingFile name:"logWaring",
							   file: "/app/portal/users/log/Portal_Error.log",
							   maxFileSize:'1000kB',
							   threshold: org.apache.log4j.Level.WARN,
							   maxBackupIndex:100,
							   layout:pattern(conversionPattern: '%d{[EEE, dd-MMM-yyyy @ HH:mm:ss.SSS]} [%t] %-5p %c %x - %m%n\n')
		   
			   rollingFile name:"logInfo",
							   file: "/app/portal/users/log/Portal_Error.log",
							   maxFileSize:'1000kB',
							   threshold: org.apache.log4j.Level.INFO,
							   maxBackupIndex:100,
							   layout:pattern(conversionPattern: '%d{[EEE, dd-MMM-yyyy @ HH:mm:ss.SSS]} [%t] %-5p %c %x - %m%n\n')
			}
			
			root
			{
				info 'logError','logWaring','logInfo', stdout
			   additivity = true
			}
		   
		   
			error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
				   'org.codehaus.groovy.grails.web.pages', //  GSP
				   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
				   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
				   'org.codehaus.groovy.grails.web.mapping', // URL mapping
				   'org.codehaus.groovy.grails.commons', // core / classloading
				   'org.codehaus.groovy.grails.plugins', // plugins
				   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
				   'org.springframework',
				   'org.hibernate',
				   'net.sf.ehcache.hibernate'
			warn   'org.mortbay.log'
	   }
	   
	   
   }
   production {

       log4j = {
           appenders {
               rollingFile name: 'fileLog',
               fileName: 'application.log',
               maxFileSize: 26214400,
               maxBackupIndex: 10,
               layout: pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS} %p %c{2} %m%n')
           }
           root {
                info()
                additivity = true
           }
           info 'org.weceem',
                'grails.app'

           error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
                   'org.codehaus.groovy.grails.plugins', // plugins
                   'org.codehaus.groovy.grails.web.pages', //  GSP
                   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.commons', // core / classloading
                   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
                   'org.springframework',
                   'org.hibernate'

       }

   }
}


//// Added by the Spring Security Core plugin:
//grails.plugins.springsecurity.userLookup.userDomainClassName = 'Security.SecUser'
//grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'Security.SecUserSecRole'
//grails.plugins.springsecurity.authority.className = 'Security.SecRole'
//grails.plugins.springsecurity.securityConfigType = 'Annotation'
//grails.plugins.springsecurity.rejectIfNoRule = false