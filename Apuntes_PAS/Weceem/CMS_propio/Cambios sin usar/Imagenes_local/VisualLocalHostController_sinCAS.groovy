package rrhh

//import grails.plugins.springsecurity.Secured

import java.text.SimpleDateFormat

import rrhh.users.Persona
import utils.BaseControler

/**
 *
 * Migas de pan: s&oacute;lo se consultan en las fichas, en el resto de lugares ya vienen los nombres y enlces correctos (hardcode).<br>
 * Cuando una URL no existe redirige a la p&aacute;gina de inicio /IniciPDIPAS/index.
 *
 */
//@Secured(['ROLE_USER'])
class VisualLocalHostController {// extends BaseControler {

	def static allowedTypes = ['SHTML', 'NHTML']
	static llistaEspais = ["Per defecte":1, "PAS":2, "PDI":3, "BEC":4, "GES":5]
	
	//PAS, PDI, BECario
	def llistaPAS = ['F1','F2','F3','F4','L1','L2','L3','V1']
	def llistaPDI = ['A1','B1','F5','F6','L4','L5','L6','L7','L8','P1', 'P2','V2','V3']
	def llistaBEC = ['D1','D2','D3','DD','EE','B2']
	
	
	//Espai per defecte, provisionalment PAS
	//s'ha de posar en funció de l'usuari del CAS
	def espaiId
	def espaiNom
	
	
	def index() {
//		println "LOCALHOST"+new Date()
//		this.populateUserName()
		
		def usuariNom = session.user //"Desconegut"
		
		//Pàgina per defecte, index
		def page = "index"
		def webPage
		
		try{
			def values = request.forwardURI.toString().split("/")
			
			//Captura aliasuri de la pàgina visitada
			if(values.size()>3)
			{
				page = values[values.size()-1]
			}
			
			//Obtenim nom de l'espai i id de la URL
			if(values.size()>2)
			{
				espaiNom = values[2]
				espaiId = llistaEspais[espaiNom]
			}
	
			def query = {
				and{
					eq("aliesUri", page)
					eq("espai", espaiId)
					//eq("estat",1)
					//'in'("tipusContingut", allowedTypes)
				}
			}
			
			//Càrrega de la pàgina Inici
			def pageContent = Contingut.createCriteria().get(query)
			
			//Si la pàgina buscada no existeix redireccionar a l'index de l'espai
			//corresponent a l'usuari CAS (provisionalment PAS)
			if(!pageContent){
				
				//Perfil de l'usuari
				def princ = springSecurityService.getPrincipal()
				
				if (princ instanceof String) {
					espaiNom = "PAS"
//					return null
				} else {
					def username = springSecurityService.getPrincipal()?.username

					//Se consigue el grupo de la persona: PAS, PDI o BECario
					def persona = Persona.findByUsuari(username.toString())
					
					if(persona){
						if(llistaPAS.contains(persona.areaPersonal.toString().toUpperCase())){
							espaiNom = "PAS"
						}
						else if(llistaPDI.contains(persona.areaPersonal.toString().toUpperCase())){
							espaiNom = "PDI"
						}
						else if(llistaBEC.contains(persona.areaPersonal.toString().toUpperCase())){
							espaiNom = "BEC"
						}
					}
					
				}
				
				espaiId = llistaEspais[espaiNom]
				
//				query = {
//					and{
//						eq("aliesUri", "index")
//						eq("espai", espaiId)
//						//eq("estat",1)
//						//'in'("tipusContingut", allowedTypes)
//					}
//				}
//				
//				//Càrrega de la pàgina Inici (index)
//				pageContent = Contingut.createCriteria().get(query)
//				
//				//Ex: "/rrhh/PAS/index/"
//				values = "/${grails.util.Metadata.current.'app.name'}/${espaiNom}/index/".split("/")
				
				//Es redirecciona per tal de tenir la URL correcta al navegador
				redirect uri: "/${espaiNom}/index"
			}
	
			//Agafem el template
			if(pageContent.template)
			{
				//Càrrega del template
				webPage = pageContent.template.contingut
				//Posar el contingut de la pàgina on toca
				webPage = webPage.replace("<!--pageContent-->", pageContent.contingut)
			}
			else{
				webPage = pageContent.contingut
			}
			
	//		if(webPage){
			//Redirecció de la pàgina
			//${grails.util.Metadata.current.'app.name'}/${space?.name}/index/Informacio_General
			// Al contingut de la pàgina NO es pot linkar amb ${grails.util.Metadata.current.'app.name'}
			webPage = webPage.replace("\${grails.util.Metadata.current.'app.name'}", "${grails.util.Metadata.current.'app.name'}")
			
			//Reemplaçaments
			if(webPage.contains("\${space?.name}")){
				webPage = webPage.replace("\${space?.name}", espaiNom)
			}
			if(webPage.contains("\${session.user}")){
				webPage = webPage.replace("\${session.user}", "")
			}
			if(webPage.contains("<!--titolContent-->")){
				webPage = webPage.replace("<!--titolContent-->", pageContent.titol)
			}
			 
			//Migas de pan (a les fitxes)
			if(webPage.contains("<!--breadCrumb-->")){ //Sólo está esta etiqueta en las fichas
				if(!pageContent.aliesUri.equals("Informacio_General") || !pageContent.aliesUri.equals("index")){
					webPage = webPage.replace("<!--breadCrumb-->", getBreadCrumb(pageContent))
				}
			}
			 
			//Cercador
			if(webPage.contains("<!--buscadorUPC-->")){
				webPage = webPage.replace("<!--buscadorUPC-->", "<form action=\"/rrhh/searcher/index\" method=\"post\"><input type=\"hidden\" name=\"espai\" value=\"${espaiNom}\"><input type=\"hidden\" name=\"max\" value=\"5\"><input name=\"query\" class=\"customSearchField\" placeholder=\"Cercar...\" onfocus=\"\" value=\"\" id=\"query\" type=\"text\"><input name=\"_action_index\" class=\"customSearchButton\" value=\"Cerca\" type=\"submit\"></form>")
			}
		 
			//Nom de l'usuari
			if(webPage.contains("<!--userName-->")){
				webPage = webPage.replace("<!--userName-->", "<span class=\"login-UPC\"> ${usuariNom} </span>")
			}
			
			//dataActualitzacio
			if(webPage.contains("<!--dataActualitzacioFitxa-->")){
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
				webPage = webPage.replace("<!--dataActualitzacioFitxa-->", sdf.format(pageContent.dataActualitzacio).toString())
			}
			
			//Imágenes localhost: /rrhh/../rrhh/
			if(webPage.contains("/rrhh/../rrhh/")){
				webPage = webPage.replace("/rrhh/../rrhh/files/", "/rrhh/rrhh_resources/")
			}
			if(webPage.contains("/gcrrhh/../rrhh/")){
				webPage = webPage.replace("/gcrrhh/../rrhh/files/", "/rrhh/rrhh_resources/")
			}
			if(webPage.contains("/rrhh/files/tecnic/")){
				webPage = webPage.replace("/rrhh/files/tecnic/", "/rrhh/rrhh_resources/tecnic/")
			}
			
			render(text: webPage, contentType: "text/html", encoding: "UTF-8")
	//		}
			
		}
		catch(Exception e){
			
		}

	}
	
	/**
	 *
	 */
	private String getBreadCrumb(Contingut contingut){
		def mdpAddr = "/${grails.util.Metadata.current.'app.name'}/${espaiNom}"
		def mdpStr = "<b>Sou a <span class=\"breadCrumbSeparator firstSeparator\">&raquo;</span></b>"
		def mdpAliasuri = []
		def mdpTitle = []

		//TITLE: Els dos primers valors són sempre els mateixos
		mdpAliasuri[0]="index"
		mdpAliasuri[1]="Informacio_General"
		
		mdpTitle[0]="Inici"
		mdpTitle[1]="Informaci\u00f3 general"
		
		//Si estamos en una ficha de dos columnas
		if(contingut.pare.aliesUri.equals("Informacio_General")){
			mdpAliasuri[2]=contingut.aliesUri
			mdpTitle[2] = contingut.titol
		}
		else{
			if(contingut.pare.tipusContingut.equals("FOLD")){
				mdpAliasuri[2]=contingut.pare.pare.aliesUri
				mdpTitle[2] =contingut.pare.pare.titol
			}else{
				mdpAliasuri[2]=contingut.pare.aliesUri
				mdpTitle[2] = contingut.pare.titol
			}
			mdpAliasuri[3]=contingut.aliesUri
			mdpTitle[3] = contingut.titol
		}
		
		//Generació del mapa key(aliasuri):value(title)
		def pairs = [mdpAliasuri, mdpTitle].transpose()
		def breadMap = [:]
		pairs.each{ k, v -> breadMap[k] = v }

		//Generació de l'String amb key(aliasuri):value(title).
		breadMap.each{
			 mdpAddr += "/"+it.key
			 if (!(it.key==mdpAliasuri.last())){
				 mdpStr += "<a href=\"$mdpAddr\"><span class=\"breadCrumbItem\">"+it.value+"</span></a><span class=\"breadCrumbSeparator\">&rsaquo;</span>"
			 }
			 else{
				 mdpStr += "<span class=\"breadCrumbLastItem\">"+it.value+"</span>"
			 }
		}
		
		return mdpStr
	}
}

