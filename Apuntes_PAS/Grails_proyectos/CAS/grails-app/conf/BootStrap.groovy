import com.jesuscampos.security.*

class BootStrap {

	def springSecurityService
	
	def init = {
		def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
		def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
		
		def adminUser = SecUser.findByUsername('admin2') ?: new SecUser(
			username: 'admin2',
			password: 'admin2',
			enabled: true).save(failOnError: true)

		if (!adminUser.authorities.contains(adminRole)) {
			SecUserSecRole.create adminUser, adminRole
		}
	}
	
    def destroy = {
    }
}
