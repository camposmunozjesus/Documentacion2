package wsclientproba

import sig3.DummyResponse;
import sig3.Person;
import sig3.WSPruebaService;
import sig3.WSPruebaServicePortType;


class PersonesController {

    def index() { 

		String pernr = params.pernr?:"42691"
        
		def result
		
		if (!pernr.equals("")){
			try{
				
				WSPruebaService wsPruebaService = new WSPruebaService()
				WSPruebaServicePortType wsPruebaClient = wsPruebaService.getWSPruebaServicePort()
				result= wsPruebaClient.getTotsPernrByCognom("SANCHEZ")
				//result = wsPruebaClient.getDadesPersona(pernr)
				
			} catch (Exception e){
				e.printStackTrace();
			}
	[personaInstance:result]
					
		}

		
	}
}
