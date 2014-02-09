//Ubicació del servidor on es troba el servei web.
public String conexion = "http://195.235.66.115:10001/WSApp/WSApp/AppColoma.asmx";
	//Namespace fet servir al servei web.
public String namespace = "http://www.gramene.net/appcoloma/";
	
	
	public String getIdiomes(){
		String res=null;
	
		SoapObject rpc;
		rpc=new SoapObject( namespace, "nomMetode");
		//En el cas d'haver-hi paràmetres
		//rpc.addProperty("nomAtribut", valorAtribut);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut=rpc;
		
		envelope.dotNet=true;
		envelope.encodingStyle=SoapSerializationEnvelope.XSD;
		
		HttpTransportSE androidHttpTransport=null;
		
		try {

			androidHttpTransport = new HttpTransportSE(conexion);
			androidHttpTransport.debug=true;
			
			//SoapACtion
			androidHttpTransport.call(namespace+"nomMetode", envelope);
			
			res=androidHttpTransport.responseDump;

		} catch (Exception e) {
			// Tractament d'errors.

		}
		
		return res;
		
	}
	
}
