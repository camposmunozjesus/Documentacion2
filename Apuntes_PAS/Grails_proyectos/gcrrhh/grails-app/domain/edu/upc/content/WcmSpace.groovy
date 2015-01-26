package edu.upc.content

class WcmSpace {

	int identity
	String aliasuri
	String name
	
	
	static mapping = {
		table name: "wcm_space2"
		id name:'identity'
		id generator:'assigned'
		version false
		
		identity column: 'id'
	}
			
	static constraints = {
	}
}