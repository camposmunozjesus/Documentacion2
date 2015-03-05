package gcrrhh.editor

import grails.plugins.springsecurity.Secured

import java.text.SimpleDateFormat
import java.util.Date;

import utils.BaseControler

@Secured(['ROLE_EDITOR'])
class EditorFullController extends BaseControler{

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static tipusEspais = ["Default":1, "PAS":2, "PDI":3, "BEC":4, "GES":5]
	
	static String arxiuContingutGlobal
	
	def list(){
		this.populateUserName()
		this.doSecurityCheck()

		//Encuentra el nombre del espacio - CKEditor subir ficheros
		def spaceId = params.espai?:params.arxiuEspai
		def space = tipusEspais.find{ it.value == spaceId.toInteger() }?.key

		if(params.arxiuContingut){
			params.arxiuContingut = arxiuContingutGlobal
		}
		
		try{
			//Se recupera el archivo por su ID(único)
			if(params.identity){
				def archivo = Contingut.findById(params.identity.toLong())
			
				if(archivo){
					//Se cargan los templates del espacio de donde se encuentra el HTML.
					def tmpl = Template.findAllByEspai(archivo.espai)
					//REV - 20150223 - INI - Permitir visualizar el template en pantalla del Rich Editor CKEditor 4
					Contingut contingutTotal = new Contingut()
					contingutTotal.aliesUri = archivo.aliesUri
					contingutTotal.dataActualitzacio = archivo.dataActualitzacio
					contingutTotal.dataDarrerCanvi = archivo.dataDarrerCanvi
					contingutTotal.usuariDarrerCanvi = archivo.usuariDarrerCanvi
					contingutTotal.dataCreacio = archivo.dataCreacio
					contingutTotal.usuariCreacio = archivo.usuariCreacio
					contingutTotal.descripcio = archivo.descripcio
					contingutTotal.descripcio = archivo.descripcio
					contingutTotal.idioma = archivo.idioma
					contingutTotal.ordre = archivo.ordre
					contingutTotal.pare = archivo.pare
					contingutTotal.dataIniciPublicacio = archivo.dataIniciPublicacio
					contingutTotal.dataFiPublicacio = archivo.dataFiPublicacio
					contingutTotal.espai = archivo.espai
					contingutTotal.estat = archivo.estat
					contingutTotal.titol = archivo.titol
					contingutTotal.tipusContingut = archivo.tipusContingut
					contingutTotal.contingut = archivo.contingut
					contingutTotal.template = archivo.template
					contingutTotal.permetreGSP = archivo.permetreGSP
					contingutTotal.titolHTML = archivo.titolHTML
					contingutTotal.paraulesClau = archivo.paraulesClau
					contingutTotal.observacions = archivo.observacions
					
					if(archivo.template){
						println "template: " + archivo.template
						def res = tmpl.find {
							if(it.id==archivo.template){
//								println "El res es:"+new Date() 
//								println it.contingut
								return it.contingut
							}
						}
//						println res.contingut
						println "**********************************************************"
//						println contingutTotal.contingut
						contingutTotal.contingut = res.contingut.replace("<!--pageContent-->", "<INICI-CONTINGUT>"+ archivo.contingut +"<FI-CONTINGUT>")
					}
					//REV - 20150223 - FIN
					//Llamar al editor
					[arxiu: contingutTotal, templateList: tmpl, space: space]
				}
			}
		
			else{
				def archivo
				//Si no es HTML, hay que cargar el tipo de plantilla escogida
				if(!(params.tipusContingut.equals("SHTML") && params.tipusContingut.equals("SHTML"))){
					def plantilla = Plantilla.findByAliesUri(params.tipusContingut)
					archivo = new Contingut()
					archivo.contingut=plantilla.contingut
				}
				//Se cargan los templates del espacio de donde se quiere crear del el contenido.
				def tmpl = Template.findAllByEspai(params.espai)
				[arxiu: archivo, templateList: tmpl, space: space]
			}
		}
		catch(Exception e){
			println "ERROR [controller:editor --- action:edit]: "+e
		}
	}
	
	def delete(){
		try{
			//Siempre habr� params.id (hasta el momento)
			def children = Contingut.findAllByPare(params.identity.toLong())
			
			if(!children){
				def arxiu = Contingut.findById(params.identity.toLong())
				arxiu.delete(flush: true)
				flash.message = "Arxiu "+arxiu.titol+" esborrat"
				redirect(controller: "treeTable", action: "list", params : [espai: params.arxiuEspai])
			}else{
				flash.message = "No es pot esborrar perquè l'arxiu té dependències"
				redirect(controller: "treeTable", action: "list", params : [espai: params.arxiuEspai])
				//Si el contenido tiene descendientes no se puede borrar
			}
		}
		catch(Exception e){
			println "ERROR: "+e
		}
	}
	
	def create(){
		redirect(action: "list", params : [espai:params.espaiId, pare:params.parentId, tipusContingut:params.filtreTipusContingut])
	}
	
	def cancel(){
		redirect(controller: "treeTable", action: "list", params : [espai: params.arxiuEspai])
	}
	
	def save(){
		if(saveFile(params)){
			flash.message = "Arxiu \""+ params.arxiuTitol +"\" desat correctament"
			redirect(controller: "treeTable", action: "list", params : [espai: params.arxiuEspai])
		}else{
			//Aquí no se envía arxiuContingut: params.arxiuContingut debido a que si es muy grande se desborda el redirect, se usa un atributo global.
			//Por eso se le pasa vacío
			arxiuContingutGlobal = params.arxiuContingut
			flash.message="Arxiu \""+ params.arxiuTitol +"\" amb errors, no és pot desar"
			redirect(controller: "editorFull", action: "list", params: [arxiuContingut: "0", arxiuEstat:params.arxiuEstat, arxiuPermetreGSP: params.arxiuPermetreGSP, espai:params.arxiuEspai, pare:params.arxiuPare, tipusContingut:params.arxiuTipusContingut, id: params.id, arxiuTitol: params.arxiuTitol, arxiuAliesUri: params.arxiuAliesUri, arxiuDataIniciPublicacio: params.arxiuDataIniciPublicacio, arxiuDataFiPublicacio: params.arxiuDataFiPublicacio, arxiuDataActualitzacio: params.arxiuDataActualitzacio, arxiuTemplate: params.arxiuTemplate, arxiuDescripcio: params.arxiuDescripcio, arxiuParaulesClau:params.arxiuParaulesClau])
		}
	}
	
	def saveAndContinue() {
//		println "[Editor::saveAndContinue] "+new Date()+params
		if(saveFile(params)){
			flash.message="Arxiu \""+ params.arxiuTitol +"\" desat correctament"
			redirect(controller: "editorFull", action: "list", params: [espai:params.arxiuEspai, identity: params.identity])
		}else{
			//Aquí no se envía arxiuContingut: params.arxiuContingut debido a que si es muy grande se desborda el redirect, se usa un atributo global.
			//Por eso se le pasa vacío
			arxiuContingutGlobal = params.arxiuContingut
			redirect(controller: "editorFull", action: "list", params: [arxiuContingut: "0", espai:params.arxiuEspai, arxiuEstat:params.arxiuEstat, arxiuPermetreGSP: params.arxiuPermetreGSP, identity: params.identity, espai:params.arxiuEspai, pare:params.arxiuPare, tipusContingut:params.arxiuTipusContingut, arxiuTitol: params.arxiuTitol, arxiuAliesUri: params.arxiuAliesUri, arxiuDataIniciPublicacio: params.arxiuDataIniciPublicacio, arxiuDataFiPublicacio: params.arxiuDataFiPublicacio, arxiuDataActualitzacio: params.arxiuDataActualitzacio, arxiuTemplate: params.arxiuTemplate, arxiuDescripcio: params.arxiuDescripcio, arxiuParaulesClau:params.arxiuParaulesClau])
		}
	}
	
	private boolean saveFile(parametros){
		println "EDITOR FULL"+new Date()
		println parametros.arxiuContingut
//		try{
//			Contingut archivo
//			
//			if(parametros.identity){
//				//Se recupera el archivo por su ID(único)
//				archivo = Contingut.findById(parametros.identity.toLong())
//			}else{
//				archivo = new Contingut()
//
//				//Campos obligatorios que no se editan
//				archivo.usuariCreacio=session.user
//				archivo.dataCreacio=new Date()
//				
//				def orden = Contingut.createCriteria().get {
//					projections {
//						max "ordre"
//					}
//				} as Integer
//				orden++
//				
//				archivo.ordre=orden
//				archivo.espai=parametros.arxiuEspai.toInteger()
////				archivo.tipusContingut=tipusContinguts.find{ it.value == parametros.arxiuTipusContingut.toInteger() }?.key
//				if(parametros.arxiuPare=='undefined'){
//					archivo.pare=null
//				}else{
//					archivo.pare=parametros.arxiuPare.toInteger()
//				}
//			}
//			
//			//Validación
//			//titol
//			if(!parametros.arxiuTitol){
//				flash.message="S'ha d'omplir el camp títol"
//				return false
//			}
//			if((parametros.arxiuTitol.size())>Contingut.MAX_TITOL_SIZE){
//				flash.message="Títol massa llarg"
//				return false
//			}
//			//contingut
//			if(!(parametros.arxiuContingut.size()>0)){
//				flash.message="No es pot deixar un document buit"
//				return false
//			}
//			//aliesUri
//			if(!parametros.arxiuAliesUri){
//				flash.message="S'ha d'omplir el camp URL"
//				return false
//			}
//			//aliesUri
//			if((parametros.arxiuAliesUri.size())>Contingut.MAX_ALIESURI_SIZE){
//				flash.message="URL massa llarga"
//				return false
//			}
//			//descripció
//			if(parametros.arxiuDescripcio){
//				if((parametros.arxiuDescripcio.size())>Contingut.MAX_DESCRIPCIO_SIZE){
//					flash.message="Descripció massa llarga"
//					return false
//				}
//			}
//			//paraulesClau
//			if(parametros.arxiuParaulesClau){
//				if((parametros.arxiuParaulesClau.size())>Contingut.MAX_PARAULES_CLAU_SIZE){
//					flash.message="El camp Paraules clau és massa llarg"
//					return false
//				}
//			}
//			
//			//Si todo se ha validado, se guardan los cambios
//			if(parametros.arxiuTipusContingut.toString().size()>5){
//				archivo.tipusContingut=parametros.arxiuTipusContingut.toString().substring(0,5)
//			}else{
//				archivo.tipusContingut=parametros.arxiuTipusContingut
//			}
//			
//			archivo.dataDarrerCanvi=new Date()
//			archivo.usuariDarrerCanvi=session.user
//			
//			//Campos recogidos del la pantalla de edición
//			//titol
//			archivo.titol=parametros.arxiuTitol
//			//Contingut
//			archivo.contingut=parametros.arxiuContingut
//			//Edición de código GSP o HTML
//			if(parametros.arxiuPermetreGSP){
//				archivo.permetreGSP= 1
//			}else{
//				archivo.permetreGSP= 0
//			}
//			//aliesUri
//			archivo.aliesUri=parametros.arxiuAliesUri
//			//Fechas
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy")
//			if(parametros.arxiuDataIniciPublicacio){
//				archivo.dataIniciPublicacio=sdf.parse(parametros.arxiuDataIniciPublicacio)
//			}
//			if(parametros.arxiuDataFiPublicacio){
//				archivo.dataFiPublicacio=sdf.parse(parametros.arxiuDataFiPublicacio)
//			}
//			if(!parametros.arxiuDataActualitzacio){
//				archivo.dataActualitzacio=new Date()
//			}else{
//				archivo.dataActualitzacio=sdf.parse(parametros.arxiuDataActualitzacio)
//			}
//			
//			archivo.paraulesClau=parametros.arxiuParaulesClau
//			archivo.descripcio=parametros.arxiuDescripcio
//			
//			archivo.estat=parametros.arxiuEstat.toInteger()
//			archivo.tipusContingut=parametros.arxiuTipusContingut
//			if(parametros.arxiuTemplate){
//				archivo.template=parametros.arxiuTemplate.toInteger()
//			}else{
//				archivo.template=null
//			}
//			
//			if(archivo.validate()){
//				archivo.save(flush: true)
//				//Una vez creado el archivo, se carga su contenido de base de datos
//				if(!params.identity){
//					params.identity=archivo.id
//				}
//			}
//			if (archivo.hasErrors()) {
//				log.error("ERROR [controller:editor --- action:saveFile]:" +"en el momento de hacer archivo.save(flush: true)")
//				archivo.errors.each{
//					println it
//				}
//				return false
//			}
//		}
//		catch(Exception e){
//			log.error("ERROR [controller:editor --- action:saveFile]:" +e)
//			return false
//		}
		
		return true
	}
	

}