package wsclientproba

import sig3.WS2ServiceService;
import sig3.WS2Service;
import sig3.Person;

class Ws2Controller {
	
	def index() {
		redirect(action: "list", params: params)
	}
	
	def list(){
	
		[params:params]
	}
	
    def iframeResult() { 
		List <Person> persList
		try{
			def cognom = params.cognom
			WS2ServiceService ws2service = new WS2ServiceService()
			WS2Service ws2client = ws2service.getWS2ServicePort()
			persList = ws2client.getTotes()
		} catch (Exception e){
			e.printStackTrace();
		}
		[persList:persList]
	}
	
	
}
