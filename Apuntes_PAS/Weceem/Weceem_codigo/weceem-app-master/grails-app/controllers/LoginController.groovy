//package Security

import grails.converters.JSON

import javax.servlet.http.HttpServletResponse

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.context.SecurityContextHolder as SCH
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import grails.plugins.springsecurity.Secured;



class LoginController {

	/**
	 * Dependency injection for the authenticationTrustResolver.
	 */
	def authenticationTrustResolver

	/**
	 * Dependency injection for the springSecurityService.
	 */
	def springSecurityService

	/**
	 * Default action; redirects to 'defaultTargetUrl' if logged in, /login/auth otherwise.
	 */
	def index = {
		println "[LoginController]::index "+new Date()
		if (springSecurityService.isLoggedIn()) {
			redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
		}
		else {
			redirect action: 'auth', params: params
		}
	}

	/**
	 * Show the login page.
	 */
	def auth = {
		println "[LoginController]::auth "+new Date()
		def config = SpringSecurityUtils.securityConfig

		if (springSecurityService.isLoggedIn()) {
			println "dentro del IF"
			redirect uri: config.successHandler.defaultTargetUrl
			return
		}
println "------------------"
		String view = 'auth'
		String postUrl = "${request.contextPath}${config.apf.filterProcessesUrl}"
		render view: view, model: [postUrl: postUrl,
								   rememberMeParameter: config.rememberMe.parameter]
	}

	/**
	 * The redirect action for Ajax requests.
	 */
	def authAjax = {
		println "[LoginController]::authAjax "+new Date()
		response.setHeader 'Location', SpringSecurityUtils.securityConfig.auth.ajaxLoginFormUrl
		response.sendError HttpServletResponse.SC_UNAUTHORIZED
	}

	/**
	 * Show denied page.
	 */
	def denied = {
		println "[LoginController]::denied "+new Date()
		if (springSecurityService.isLoggedIn() &&
				authenticationTrustResolver.isRememberMe(SCH.context?.authentication)) {
			// have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
			redirect action: 'full', params: params
		}
	}

	/**
	 * Login page for users with a remember-me cookie but accessing a IS_AUTHENTICATED_FULLY page.
	 */
	def full = {
		println "[LoginController]::denied "+new Date()
		def config = SpringSecurityUtils.securityConfig
		render view: 'auth', params: params,
			model: [hasCookie: authenticationTrustResolver.isRememberMe(SCH.context?.authentication),
					postUrl: "${request.contextPath}${config.apf.filterProcessesUrl}"]
	}

	/**
	 * Callback after a failed login. Redirects to the auth page with a warning message.
	 */
	def authfail = {
		println "[LoginController]::authfail "+new Date()
		def username = session[UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY]
		def auth = springSecurityService.getAuthentication()
		def user = springSecurityService.authentication.name
		
		/*
		def persona = Persones.findByUsuari(user)
		if(persona)
		{
			//Tenim la persona a la taula
			def usuari = new SecUser()
			usuari.username = username
			usuari.password = "0"
			usuari.enabled = true
			usuari.accountExpired = false
			usuari.accountLocked = false
			usuari.passwordExpired = false
			if(usuari.save())
			{
				redirect(action: "index")
			}
			
		}
		*/
		
		String msg = ''
		def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
		println "[LoginController]::authfail"+exception
		println "[LoginController]::auth"+auth
		println "[LoginController]::user"+user
		if (exception) {
			if (exception instanceof AccountExpiredException) {
				msg = "El teu login ha expirat."
			}
			else if (exception instanceof CredentialsExpiredException) {
				msg = "El teu password ha caducat."
			}
			else if (exception instanceof DisabledException) {
				msg = "La teva compta està deshabilitada."
			}
			else if (exception instanceof LockedException) {
				msg = "La teva compta està bloquejada."
			}
			else {
				msg = "Hi ha hagut un error."
			}
		}

		if (springSecurityService.isAjax(request)) {
			render([error: msg] as JSON)
		}
		else {
			flash.message = msg
			redirect action: 'auth', params: params
		}
	}

	/**
	 * The Ajax success redirect url.
	 */
	def ajaxSuccess = {
		println "[LoginController]::ajaxSuccess "+new Date()
		render([success: true, username: springSecurityService.authentication.name] as JSON)
	}

	/**
	 * The Ajax denied redirect url.
	 */
	def ajaxDenied = {
		println "[LoginController]::ajaxDenied "+new Date()
		render([error: 'access denied'] as JSON)
	}
}

//import grails.converters.JSON
//
//import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
//
//import org.springframework.security.authentication.AccountExpiredException
//import org.springframework.security.authentication.CredentialsExpiredException
//import org.springframework.security.authentication.DisabledException
//import org.springframework.security.authentication.LockedException
//import org.springframework.security.core.context.SecurityContextHolder as SCH
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
//
//class LoginController {
//
//	/**
//	 * Dependency injection for the authenticationTrustResolver.
//	 */
//	def authenticationTrustResolver
//
//	/**
//	 * Dependency injection for the springSecurityService.
//	 */
//	def springSecurityService
//
//	/**
//	 * Default action; redirects to 'defaultTargetUrl' if logged in, /login/auth otherwise.
//	 */
//	def index = {
//		println "----------------->"+"[LoginController::index]"
//		if (springSecurityService.isLoggedIn()) {
//			redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
//		}
//		else {
//			redirect action: auth, params: params
//		}
//	}
//
//	/**
//	 * Show the login page.
//	 */
//	def auth = {
//		println "----------------->"+"[LoginController::auth]"
//		def config = SpringSecurityUtils.securityConfig
//
//		if (springSecurityService.isLoggedIn()) {
//			redirect uri: config.successHandler.defaultTargetUrl
//			return
//		}
//
//		String view = 'auth'
//		String postUrl = "${request.contextPath}${config.apf.filterProcessesUrl}"
//		render view: view, model: [postUrl: postUrl,
//		                           rememberMeParameter: config.rememberMe.parameter]
//	}
//
//	/**
//	 * Show denied page.
//	 */
//	def denied = {
//		println "----------------->"+"[LoginController::denied]"
//		if (springSecurityService.isLoggedIn() &&
//				authenticationTrustResolver.isRememberMe(SCH.context?.authentication)) {
//			// have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
//			redirect action: full, params: params
//		}
//	}
//
//	/**
//	 * Login page for users with a remember-me cookie but accessing a IS_AUTHENTICATED_FULLY page.
//	 */
//	def full = {
//		println "----------------->"+"[LoginController::full]"
//		def config = SpringSecurityUtils.securityConfig
//		render view: 'auth', params: params,
//			model: [hasCookie: authenticationTrustResolver.isRememberMe(SCH.context?.authentication),
//			        postUrl: "${request.contextPath}${config.apf.filterProcessesUrl}"]
//	}
//
//	/**
//	 * Callback after a failed login. Redirects to the auth page with a warning message.
//	 */
//	def authfail = {
//		println "----------------->"+"[LoginController::authfail]"
//		def username = session[UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY]
//		String msg = ''
//		def exception = session[AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY]
//		if (exception) {
//			if (exception instanceof AccountExpiredException) {
//				msg = SpringSecurityUtils.securityConfig.errors.login.expired
//			}
//			else if (exception instanceof CredentialsExpiredException) {
//				msg = SpringSecurityUtils.securityConfig.errors.login.passwordExpired
//			}
//			else if (exception instanceof DisabledException) {
//				msg = SpringSecurityUtils.securityConfig.errors.login.disabled
//			}
//			else if (exception instanceof LockedException) {
//				msg = SpringSecurityUtils.securityConfig.errors.login.locked
//			}
//			else {
//				msg = SpringSecurityUtils.securityConfig.errors.login.fail
//			}
//		}
//
//		if (springSecurityService.isAjax(request)) {
//			render([error: msg] as JSON)
//		}
//		else {
//			flash.message = msg
//			redirect action: auth, params: params
//		}
//	}
//
//	/**
//	 * The Ajax success redirect url.
//	 */
//	def ajaxSuccess = {
//		println "----------------->"+"[LoginController::ajaxSuccess]"
//		render([success: true, username: springSecurityService.authentication.name] as JSON)
//	}
//
//	/**
//	 * The Ajax denied redirect url.
//	 */
//	def ajaxDenied = {
//		println "----------------->"+"[LoginController::ajaxDenied]"
//		render([error: 'access denied'] as JSON)
//	}
//}
