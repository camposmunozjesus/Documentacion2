package Security

class SecRole {

	String authority

	static mapping = {
		cache true
		table 'SIG_SEC_ROLE'
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
