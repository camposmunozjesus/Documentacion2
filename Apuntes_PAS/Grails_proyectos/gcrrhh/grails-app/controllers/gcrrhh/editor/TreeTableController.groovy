package gcrrhh.editor

import edu.upc.content.WcmContent

class TreeTableController {

	def index(){
		redirect(action: "treeTable")	
	}
	
	
	private static int SPACE_ID = 7
	
	//Closures:
	//Elementos con parent igual a null
	def elementosPrincipales = {it.parent == null}
	
	def treeTable() {
		flash.message= flash.msg?:''
		
//		ArrayList<WcmContent> allContent = new ArrayList<WcmContent>()
		
		def allContent = WcmContent.findAllBySpace(SPACE_ID)
		println "TOTAL RESULTDOS: "+allContent.size()
		println allContent.title
		
		//Cada elemento que tenga parent = null siginifica que cuelga del árbol principal.
		//Par cada uno de ellos buscamos sus descendientes (elementos que cuelgan de él).
		//Se obtienen ordenados por su order_index
//		println allContent.findAll(elementosPrincipales).sort(ordenar).title
		def principalContent = allContent.findAll(elementosPrincipales).sort{it.title}
//		println principalContent.title
		
		def treeTable = principalContent.each(){
				it.children = getChildren(it, allContent)
		}
		
//		println "***********************************************"
//		println "******* RESULTADOS FINALES ********************"
//		println treeTable.each{
//			println it.title + " con hijos "+it.children.title+" - "+it.children.identity
//			it.children.each {
//				if(it.children!=null){
//					println "--->"+it.title + " con hijos "+it.children.title+" - "+it.children.identity
//				}
//			}
//		}.title
	
//	println "treeTable[1].children.title:"+treeTable[1].children.size()
		[content:treeTable]
	}
	
	private def getChildren(content, allContent){
//		println "*getChildren Elemento: "+content.title+ " conID: "+content.identity
		
		def children = allContent.findAll{
			it.parent == content.identity
		}
		
		if(children){
			//Se ordenan los hijos
			children = children.sort()
			
			children.each(){
				it.children = getChildren(it, allContent)
			}
		}
		
//		println "Hijos de "+content.title+ "son: "+children.title
		return children
	}
	
}
