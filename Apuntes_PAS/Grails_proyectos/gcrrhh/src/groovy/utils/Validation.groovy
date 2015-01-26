package utils

class Validation {
	
	public static boolean ValidateHour(def l_hour) // Format HH:mm
	{
		try
		{
			String hour = new String(l_hour)
			String hours
			String minutes
			
			//Si conté 
			if(	hour.indexOf(":") != -1 ) {
				String[]pieces = hour.split(":")
			
				hours = pieces[0]				
				
				//Si és format HH:
				if(hour.substring(hour.length()-1) == ":") {
					 minutes = "00"
				}
				//Si és format HH:mm
				else
				{
					minutes = pieces[1]					
				}							
			}
			//No conté ':', només hores
			else
			{
				hours = l_hour
				minutes = "00"				
			}
			
			int hores = Integer.parseInt(hours)
			int minuts = Integer.parseInt(minutes)
						
			if(hores >= 0 && hores <= 23)
			{
				if(minuts >= 0 && minuts <= 59)
				{
					return true
				}				
			}
			
			return false
			
		}
		catch(Exception e)
		{
			return false;
		}
	}	
	
	// Assegura que qualsevol hora te el format HH:mm
	public static String transformaHores(String hora)
	{
		//No té ':', no conté minuts
		if(hora.indexOf(":") == -1 ) {
			//Les HH només tenen una posició
			if(hora.length() == 1 ) {
				hora = "0"+hora
			}
			hora = hora+":00"
		} else {
			//Si té format HH:, afegir minuts
			if(hora.substring(hora.length()-1) == ":") {
				hora= hora+"00"
			}
		}
		
		return hora
	}

}
