import grails.plugins.springsecurity.Secured;

class LogoutController {

	/**
	 * Index action. Redirects to the Spring security logout uri.
	 */
	def index = {
		// TODO put any pre-logout code here
		session.user = "";
		redirect uri: '/j_spring_security_logout' // '/j_spring_security_logout'
	}
}

//import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
//
//class LogoutController {
//
//	/**
//	 * Index action. Redirects to the Spring security logout uri.
//	 */
//	def index = {
//		println "----------------->"+"[LogoutController::index]"
//		// TODO  put any pre-logout code here
//		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
//	}
//}
