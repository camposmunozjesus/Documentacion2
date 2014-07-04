////dataSource {
////	pooled = true
////	driverClassName = "org.postgresql.Driver"
////	}
////	hibernate {
////	cache.use_second_level_cache=true
////	cache.use_query_cache=false
////	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
////	}
////	
////	environments {
////	development {
////		dataSource {
////			dbCreate = "update" // one of 'create', 'create-drop','update'
////			url = "jdbc:postgresql://localhost:5432/Pruebas"
////						username = "jesus"
////						password = "jesus"
////		}
////	}
////	test {
////			dataSource {
////			dbCreate = "update"
////			url = "jdbc:postgresql://localhost:5432/Pruebas"
////						username = "jesus"
////						password = "jesus"
////		}
////	}
////	production {
////		dataSource {
////			dbCreate = "update"
////			url = "jdbc:postgresql://localhost:5432/weceem"
////						username = "jesus"
////						password = "jesus"
////		}
////	}
////}

	
//dataSource {
//	pooled = true
//	driverClassName = "org.postgresql.Driver"
//	}
//	hibernate {
//	cache.use_second_level_cache=true
//	cache.use_query_cache=false
//	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
//	}
//	
//	environments {
//	development {
//		dataSource {
//			dbCreate = "update" // one of 'create', 'create-drop','update'
//			url = "jdbc:postgresql://localhost:5432/Pruebas"
//						username = "jesus"
//						password = "jesus"
//		}
//	}
//	test {
//			dataSource {
//			dbCreate = "update"
//			url = "jdbc:postgresql://localhost:5432/Pruebas"
//						username = "jesus"
//						password = "jesus"
//		}
//	}
//	production {
//		dataSource {
//			dbCreate = "update"
//			url = "jdbc:postgresql://192.168.56.101:5432/Pruebas"
//						username = "jesus"
//						password = "jesus"
//		}
//	}
//}

dataSource {
	pooled = true
	autoReconnect = true
	driverClassName = 'oracle.jdbc.driver.OracleDriver'
	dialect='org.hibernate.dialect.Oracle10gDialect'
	logSql = false
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 60000
		timeBetweenEvictionRunsMillis = 60000
		maxWait = 10000
		testOnBorrow=true
		testWhileIdle=true
		testOnReturn=true
		validationQuery = "SELECT * FROM DUAL"
	}
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop','update'
			 url = "jdbc:oracle:thin:@ribier.upc.edu:1521:rh"
			 username = 'CS'
			 password = 'hola'
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:oracle:thin:@ribier.upc.edu:1521:rh"
			username = 'CS'
			password = 'hola'
		}
	}
	production {
		dataSource {
			//dbCreate = "update"
			url = "jdbc:oracle:thin:@malbec.upc.edu:1521:rh"
			username = 'aplica01'
			password = '01aplica'
		}
	}
}
