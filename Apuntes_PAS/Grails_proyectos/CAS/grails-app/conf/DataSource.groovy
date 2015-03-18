//POSTGRESQL EN W7
dataSource {
	pooled = true
	driverClassName = "org.postgresql.Driver"
}
hibernate {
cache.use_second_level_cache=true
cache.use_query_cache=false //cache.use_query_cache=true
cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}

environments {
development {
	dataSource {
		dbCreate = "update" // one of 'create', 'create-drop','update'
		url = "jdbc:postgresql:Pruebas" // o bien url = "jdbc:postgresql://localhost:5432/Pruebas"
					username = "jesus"
					password = "jesus"
	}
}
test {
		dataSource {
		dbCreate = "update"
		url = "jdbc:postgresql:Pruebas"
					username = "jesus"
					password = "jesus"
	}
}
production {
	dataSource {
		dbCreate = "update"
		url = "jdbc:postgresql:Pruebas"
					username = "jesus"
					password = "jesus"
	}
}
}