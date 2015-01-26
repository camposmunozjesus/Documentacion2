package utils
import org.apache.commons.logging.LogFactory;
import sig.*;


abstract class BaseControler {
	def springSecurityService	
	def timecalc	
	
	long realId = 0;
		
	private static final log = LogFactory.getLog(this)
		
	def populateUserName()
	{
		//En comptes d'agafar l'usuari a partir de l'id l'agafem directament
		//de l'usuari que vam ficar a l'autentificaciÃ³ 
		/*def user = springSecurityService?.currentUser
		def username = user?.username	*/		
		
		def username = springSecurityService.authentication.name
		
		if(username!=null)
		{
			session["user"] = username
			log.info("Usuari " + username + " autenticat.")			
		}
	}
		
	def paramsMaxSet(numeroRegistresTaula,maximRegistresTaula)
	{
		try
		{
			long max = params.max.toLong()
			if(max<0) params.max=numeroRegistresTaula;
			params.max = Math.min(params.max ? params.int('max') : numeroRegistresTaula, maximRegistresTaula)
		}
		catch (Exception e)
		{
			params.max = numeroRegistresTaula;
		}
	}
	
	def getRealId()
	{
		if(realId==0)
		{
			try
			{
				def query = {
					and {
						eq("usuari",session.user, [ignoreCase: true])
					}
				}
				
				def resultList = Persona.createCriteria().list(query)
				def results = resultList.size()
				realId = resultList[0].pernr
			}
			catch(Exception e)
			{
				log.error(e.toString())
			}
			return realId
		}
		else
		{
			return realId
		}
	}
			
	def startTimer()
	{
		timecalc = new Date()
	}
	
	def stopTimer(String missatge)
	{
		Date data = new Date()
		def time = data.getTime() - timecalc.getTime()
		System.out.println("Ha trigat: " + time + " milisegons a " + missatge)
	}	
	
	def doSecurityCheck()
	{
		// Comprobem que el usuari, existeix, és únic i correspon amb el de la consulta.
		// Loggejem les incidencies i corregim les manipulacions.
		if(session.user)
		{
			def query = {
				and {
					eq("usuari",session.user, [ignoreCase: true])
				}
			}
			
			def resultList = Persona.createCriteria().list(query)
			def results = resultList.size()
			
			if(results > 1)
			{
				log.error("L'usuari " + session.user + " apareix " + results.toString() + " cops a la base de dades.")
			}
		
			this.getRealId()
		}
		else
		{
			log.error("La variable d'usuari està buida")
			//redirect uri: '/j_spring_security_logout' // '/j_spring_security_logout'
		}
		
		
		
	}
		
}
