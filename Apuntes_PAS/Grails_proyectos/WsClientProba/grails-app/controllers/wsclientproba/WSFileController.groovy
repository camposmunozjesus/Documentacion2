package wsclientproba

import sig3.WSFileServiceService;
import sig3.WSFileService; 
import sig3.ContenidorPDF;
import javax.xml.ws.soap.MTOMFeature;

class WSFileController {

    def index() {
		redirect(action: "list", params: params)
	}
	
	def list(){
	
	    [params:params]
	}
	
	def visualitzarFitxer(){
		
		this.generarFitxer("inline")
	}
	
	def descarregarFitxer(){
				
		this.generarFitxer("attachment")
	}
	
	def generarFitxer(mode){
	
		
		WSFileServiceService wsFileservice = new WSFileServiceService()
	    WSFileService wsFileclient = wsFileservice.getWSFileServicePort(new MTOMFeature())		
		 
		String anyMes = params.anyMes;
		String pernr = "24417"		
				
		//byte[] fileBytes = wsFileclient.download(fileName);
		ContenidorPDF contenidorPDF = wsFileclient.obtenirPDF(anyMes,pernr);
		
		if(contenidorPDF.error == 1)
		{	
			flash.message = "S'ha produit un error"
			redirect(action: "list", params: [anyMes: params.anyMes])
		}
		else
		{
			if(!contenidorPDF.documentPDF)
			{
				flash.message = "Fitxer no trobat a la xarxa"
				redirect(action: "list", params: [anyMes: params.anyMes])			
			}
			else
			{
		 
				try {
						
					def os = response.outputStream
					response.setHeader("Content-disposition", mode+";filename=\""+anyMes+"_"+pernr+".pdf\"")
					response.setContentType("application/pdf");			
					os << contenidorPDF.documentPDF
					os.flush();
					os.close();			
			
					return true;	
			 
			
				} catch (Exception e) {		
					flash.message = "S'ha produit un error"
					redirect(action: "list", params: [anyMes: params.anyMes])	
				}
			}
		}
	}
	
}
