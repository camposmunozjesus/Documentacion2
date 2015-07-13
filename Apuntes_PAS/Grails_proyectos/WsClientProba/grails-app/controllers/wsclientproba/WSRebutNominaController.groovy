package wsclientproba

import edu.upc.spa.rebutnomina.ZHRPORTALREBUTNOMINAV1;
import edu.upc.spa.rebutnomina.ZHRWSREBUTNOMINA; 
import edu.upc.spa.rebutnomina.ZhrPortalNouErrorsTable;
import edu.upc.spa.rebutnomina.ZhrPortalNouRebutNominaResponse;
import edu.upc.spa.utils.WSSUtilities;

import javax.xml.ws.Holder;
import javax.xml.ws.soap.MTOMFeature;

import utils.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;


class WSRebutNominaController {
	
	private static final QName SERVICE_NAME = new QName(
			"urn:sap-com:document:sap:soap:functions:mc-style",
			"ZHRPORTALREBUTNOMINAV1");

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
	
		URL wsdlURL = ZHRPORTALREBUTNOMINAV1.WSDL_LOCATION;
		System.out.println("URL: "+wsdlURL)
		//if (args.length > 0 && args[0] != null && !"".equals(args[0])) {*/
			File wsdlFile = new File("C:\\prueba_recibo.pdf");
			/*try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL("C:\\prueba_recibo.pdf");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}*/
		//}

		ZHRPORTALREBUTNOMINAV1 ss = new ZHRPORTALREBUTNOMINAV1(wsdlURL,
				SERVICE_NAME);
			System.out.println("SS: "+ss)
		ZHRWSREBUTNOMINA port = ss.getZHRPORTALREBUTNOMINAV1();
		System.out.println("PORT: "+port)

		try {
			WSSUtilities.afegirUsernameTokenPeticioSOAP(port, "intranet.servei.personal", "laura1laura1");
		} catch (Exception e) {
			// Tratamiento de la excepciÃ³n
			System.out.println("EXCEPCION: "+e.toString())
		}

		//{
			System.out.println("Invoking zhrPortalNouRebutNomina...");
			java.lang.String _zhrPortalNouRebutNomina_period = "201305";
			java.lang.String _zhrPortalNouRebutNomina_pernr = "00000015";
			javax.xml.ws.Holder<edu.upc.spa.rebutnomina.ZhrPortalNouErrorsTable> _zhrPortalNouRebutNomina_missatges = new javax.xml.ws.Holder<edu.upc.spa.rebutnomina.ZhrPortalNouErrorsTable>();
			javax.xml.ws.Holder<byte[]> _zhrPortalNouRebutNomina_pdf = new javax.xml.ws.Holder<byte[]>();
			port.zhrPortalNouRebutNomina(_zhrPortalNouRebutNomina_period,
					_zhrPortalNouRebutNomina_pernr,
					_zhrPortalNouRebutNomina_missatges,
					_zhrPortalNouRebutNomina_pdf);

			System.out
					.println("zhrPortalNouRebutNomina._zhrPortalNouRebutNomina_missatges="
							+ _zhrPortalNouRebutNomina_missatges.value);
			System.out
					.println("zhrPortalNouRebutNomina._zhrPortalNouRebutNomina_pdf="
							+ _zhrPortalNouRebutNomina_pdf.value);

		//}

		//System.exit(0);
	//}

		
	
		
		
		
		
		
		
		/********************/
		
/*		try{		
			
			ZHRPORTALREBUTNOMINAV1 wsRebutNominaservice = new ZHRPORTALREBUTNOMINAV1()
			ZHRWSREBUTNOMINA wsRebutNominaClient = wsRebutNominaservice.getZHRPORTALREBUTNOMINAV1(new MTOMFeature())
			
			
			//WSSUtilities.afegirUsernameTokenPeticioSOAP(wsRebutNominaClient, "intranet.servei.personal", "laura1laura1");
			
			String anyMes = params.anyMes;
			String pernr = "24417";
			
			final  javax.xml.ws.Holder<ZhrPortalNouErrorsTable> missatges = new  javax.xml.ws.Holder<ZhrPortalNouErrorsTable>();
			javax.xml.ws.Holder<byte[]> pdf = new javax.xml.ws.Holder<byte[]>();
			
			System.out.println("hola1")
			
			wsRebutNominaClient.zhrPortalNouRebutNomina(anyMes,pernr,missatges,pdf)
			
			System.out.println("hola2")*/
			/*
			System.out.println("M: "+missatges);
			System.out.println("DOC: "+pdf)*/
			
/*		}catch (Exception e) {
			//Tratamiento de la excepción
			System.out.println("MENSAJE ERROR: "+e)
		
		}
		
*/		
		
		
/*		WSFileServiceService wsFileservice = new WSFileServiceService()
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
		}*/
	}
	
}
