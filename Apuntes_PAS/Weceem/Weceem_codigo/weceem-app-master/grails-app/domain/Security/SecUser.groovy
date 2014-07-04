package Security

import java.util.Set;

class SecUser {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	static hasMany = [secUserSecRole: SecUserSecRole]

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}
	

	static mapping = {
		table 'SIG_SEC_USER'
		password column: '`password`'		
		secUserSecRole lazy: false
	}
	
	SecUser () {
		super();
	}
	
	SecUser(username, password) {
		this.username = username
		this.password = password
	}

	Set<SecRole> getAuthorities() {
		SecUserSecRole.findAllBySecUser(this).collect { it.secRole } as Set
	}
	
	def addRoles(roleList) {
		for(l in roleList){
			def secUserSecRole = new SecUserSecRole()
			
			def secRole = (SecRole) SecRole.get(l.toInteger())
						
			secUserSecRole.secRole = secRole
			
			this.addToSecUserSecRole(secUserSecRole)
		}
		
	}

	def beforeInsert() {
		//encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
