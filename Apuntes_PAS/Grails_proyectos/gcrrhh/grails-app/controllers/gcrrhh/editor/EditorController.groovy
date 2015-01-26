package gcrrhh.editor

import org.apache.commons.logging.LogFactory;

import edu.upc.content.WcmContent;
import edu.upc.content.WcmSpace

/**
 * Permite visualizar el arbol de contenidos de un Space (action: arbreContinguts) web y editarlos (action: edicio).
 * @author Jesus Campos
 *
 */
class EditorController {

	private static final log = LogFactory.getLog(this)
	boolean debug = false
	
    def index() { 
		redirect(action: "arbreContinguts")
	}
	
	def arbreContinguts() {
		if(debug) println "arbreContinguts"
		
		params.spaceSelected = params.spaceSelected?:''
		
		try{
			//Se carga la lista de espacios web
			def spaceList = WcmSpace.findAll()
			
			//Se carga el espacio seleccionado, o en su defecto el Default.
			
			if(debug){
				println "RES SPACES: "+spaceList.aliasuri
				println "RES SPACES: "+spaceList.identity
				println "RES SPACES: "+spaceList.name
				println "RES PAS   : "+spaceList[2].aliasuri+" - "+spaceList[2].identity+" - "+spaceList[2].name
			}
			
			
			def resultList = getSpaceChildren(spaceList[2].identity)
			
			println resultList[0].title
			println resultList[0].children.size()
			println resultList[0].children.title
			
//			resultList.each {
//				if (it.children.size() > 0){
//					
//				}
//			}
		}
		catch(Exception e){
			log.error("ERROR " +e)
			println "ERROR: "+e
		}
	}
	
	private def getSpaceChildren(spaceId){
		if(debug) println "getSpaceChild "+spaceId
		try{
			//Se carga la lista de espacios web
//			def elementChild = WcmContent.findAllByParent(spaceId)
			def query = {
				and{
					eq("space", spaceId)
					isNull("parent")
				}
				order("order_index", "asc")
			}
			
			def childrenList =  WcmContent.createCriteria().list(query)
			
			//Se carga el espacio seleccionado, o en su defecto el Default.

			
			if(debug){
				println "RES CHILDS: "+childrenList.aliasuri
				println "RES CHILDS: "+childrenList.order_index
				println "RES CHILDS: "+childrenList.identity
				println "RES CHILDS: "+childrenList.parent
			}
			
			for(child in childrenList)
			{
				child.children = getElementChildren(child.identity)
			}

			return childrenList
		}
		catch(Exception e){
			log.error("ERROR " +e)
		}
	}
	
	private def getElementChildren(elementId){
		if(debug) println "getElementChild "+elementId
		try{
			//Se cargan los hijos de cada elemento (nodo)
			def query = {
				and{
//					eq("space", spaceId)
					eq("parent", elementId)
				}
				order("order_index", "asc")
			}
			
			def childrenList =  WcmContent.createCriteria().list(query)
			
			//Se carga el espacio seleccionado, o en su defecto el Default.

//			for(child in childrenList)
//			{
//				getElementChildren(child.identity)
//			}
			
			
			if(debug){
				println "RES NODE CHILDS: "+childrenList.aliasuri
				println "RES NODE CHILDS: "+childrenList.order_index
				println "RES NODE CHILDS: "+childrenList.identity
				println "RES NODE CHILDS: "+childrenList.parent
			}
			
			return childrenList

		}
		catch(Exception e){
			log.error("ERROR " +e)
		}
	}
	
	def edit(){
		println "EDITANDO CONTENIDO"
	}
	
	def delete(){
		println "BORRANDO CONTENIDO "+new Date()+params
		try{
			//Siempre habrá params.id (hasta el momento)
			def children = WcmContent.findAllByParent(params.id.toLong())
			
			if(!children){
				def arxiu = WcmContent.findByIdentity(params.id.toLong())
				arxiu.delete(flush: true)
				flash.msg = "Arxiu "+arxiu.aliasuri+" esborrat"
				redirect(controller: "treeTable", action: "treeTable")
			}else{
				println "REDIRECT"
				flash.msg = "No es pot esborrar perqué l'arxiu té dependències"
				redirect(controller: "treeTable", action: "treeTable")
				//Si el contenido tiene descendientes no se puede borrar
			}
		}
		catch(Exception e){
			log.error("ERROR " +e)
			println "ERROR: "+e
		}
	}
}
