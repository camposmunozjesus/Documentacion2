package testing

import grails.plugin.springsecurity.annotation.Secured


@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
	
class Test01Controller {

    def index() {
		println "index"+new Date()
		render "index"
	}
}
