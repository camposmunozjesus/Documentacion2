package gcrrhh.editor

import grails.plugins.springsecurity.Secured
import utils.BaseControler

@Secured(['ROLE_EDITOR'])
class TreeTableFullController extends BaseControler{

	private static int SPACE_ID = 2711
	
	static tipusEspais = ["Per defecte":1, "PAS":2, "PDI":3, "Becari":4, "Gestor":5]
//	static tipusEspais = ['Per defecte':2412, 'PAS':2711, 'PDI':3459, 'Becari':3, 'Gestor':4]
//	static tipusContinguts = ['HTML':'HTML', 'Plantilla':'PL', 'Plantilla Genèrica':'PLGEN', 'Plantilla Dues Columnes':'PL2COL']
//	static tipusContinguts = ['HTML':0, 'Plantilla':1, 'Plantilla Genèrica':1, 'Plantilla Dues Columnes':1]
	
	
	//Closures:
	//Elementos con pare igual a null
	def elementosPrincipales = {it.pare == null}
	
	
	def index(){
		redirect(action: "list")
	}

	def list() {
		this.populateUserName()
		this.doSecurityCheck()
		
		def index	//Árbol de contenidos
		def espaiId = params.espai?:tipusEspais["Per defecte"]
		def tipusContinguts =[]
		
		try{
			def allContent = Contingut.findAllByEspai(espaiId)
			//Cada elemento que tenga pare = null siginifica que cuelga del �rbol principal.
			//Par cada uno de ellos buscamos sus descendientes (elementos que cuelgan de �l).
			//Se obtienen ordenados por su order_index
			def principalContent = allContent.findAll(elementosPrincipales).sort()
			
			index = principalContent.each(){
				it.fills = getChildren(it, allContent)
			}
			
			//Carga los tipos de plantillas de BD
			def plantillas = Plantilla.list()
			
			for(int i=0;i<plantillas.size;i++)
			{
				tipusContinguts << [tipusContingut: plantillas[i].titol ,codiContingut: plantillas[i].aliesUri ]
			}
			tipusContinguts.sort{it.ordre}
			tipusContinguts.add(0,[tipusContingut: "HTML", codiContingut:"SHTML"])
			
		}catch(Exception e){
			log.error("ERROR [controller:treeTable --- action:list]:" +e)
//			println "ERROR [controller:editor --- action:edit]: "+e
		}
		
		[content:index, tipusEspais:tipusEspais, tipusContinguts:tipusContinguts, espaiId:espaiId]
	}
	
	private def getChildren(content, allContent){
		def fills = allContent.findAll{
			it.pare == content.id
		}
		
		if(fills){
			//Se ordenan los hijos
			fills = fills.sort()
			
			fills.each(){
				it.fills = getChildren(it, allContent)
			}
		}
		
		return fills
	}
	
	def create(){
//		println "[Controller:treeTable action:create]"+new Date()+params
		if(params.filtreTipusContingut)
		{
			redirect(controller:"editorFull", action:"create", params: params)
		}else{
			flash.message = "S'ha de triar un tipus de contingut a crear"
			redirect(action:"list", params : [espai:params.espaiId])
		}
	}
	
}
