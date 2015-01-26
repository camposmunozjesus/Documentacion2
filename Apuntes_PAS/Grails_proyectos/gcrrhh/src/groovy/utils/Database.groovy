package utils

import org.apache.commons.logging.LogFactory;
import groovy.sql.Sql
//import org.codehaus.groovy.grails.commons.ConfigurationHolder
import grails.util.Holders;

class Database {
	
	private static final log = LogFactory.getLog(this)

	public static executeSQL(String sentencia)
	{
		def sql
		
		try
		{
			def url      = Holders.config.dataSource.url
			def username = Holders.config.dataSource.username
			def password = Holders.config.dataSource.password
			def driver   = Holders.config.dataSource.driverClassName
			
			sql = Sql.newInstance(url, username, password, driver)
	
			sql.execute(sentencia)
			
		}
		catch(Exception e)
		{
			log.error("Error execució sentència SQL: " + sentencia + ", " + e.toString())
		}
		finally
		{
			if(sql)
			{
				sql.close()
			}
		}
	}
	
	public static executePLFunction(String nomCompletProgramaAmbParametres)
	{
		def sql
		
		try
		{
			def url      = Holders.config.dataSource.url
			def username = Holders.config.dataSource.username
			def password = Holders.config.dataSource.password
			def driver   = Holders.config.dataSource.driverClassName
			
			sql = Sql.newInstance(url, username, password, driver)
	
			def query = "{ ? = call " + nomCompletProgramaAmbParametres + "}";			
			sql.call(query,[Sql.VARCHAR])
			{
				result -> System.out.println(result);
			}
			sql.call("{call " + nomCompletProgramaAmbParametres + "}") 
			
		}
		catch(Exception e)		{
			
			log.error("Error execució funció PL/SQL: " + nomCompletProgramaAmbParametres + ", " + e.toString())
		}
		finally
		{
			if(sql)
			{
				sql.close()
			}
		}
	}
	
	public static boolean executePLProcedure(String nomCompletProgramaAmbParametres)
	{
		def sql
		def ok = true
					
		try
		{
			def url      = Holders.config.dataSource.url
			def username = Holders.config.dataSource.username
			def password = Holders.config.dataSource.password
			def driver   = Holders.config.dataSource.driverClassName
			
			sql = Sql.newInstance(url, username, password, driver)
				
			sql.call("{call " + nomCompletProgramaAmbParametres + "}")
			
		}
		catch(Exception e)		{
			
			log.error("Error execució procediment PL/SQL: " + nomCompletProgramaAmbParametres + ", " + e.toString())
			ok= false
		}
		finally
		{
			if(sql)
			{
				sql.close()
			}
		}
		
		return ok
	}
	
	
}
