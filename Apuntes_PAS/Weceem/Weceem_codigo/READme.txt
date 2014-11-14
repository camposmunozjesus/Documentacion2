WECEEM - HISTORIAL DE ARCHIVOS
==============================
weceem-1.2: es el plugin de la aplicación Portal.
weceem-app-master: puede ser la aplicación original con la que se consiguió conectar con Oracle, pero NO está el plugin. Seguramente es la misma que hay dentro de v1.

Copias de seguridad de la aplicación: 
	D:\Weceem\Portal (
	- La carpeta "plugin" contiene la carpeta "Portal" que hay que copiar en "C:\Users\Jesus Campos\.grails\2.3.7\projects".
	- La carpeta "Portal" es la del workspace.


------------------------
LOCALIZACIÓN DE ARCHIVOS
------------------------
En local, las imágenes se guardan en:
	D:\var\www\weceem.org\uploads\PAS
Indicado en la parte development del archivo Config.groovy de la aplicación. Se arranca en developmant cuando se ejecuta el comando:
	run-app --verbose --stacktrace  -Dserver.port=8090


-------------------------
ARCHIVOS GENERALES WECEEM
-------------------------
WECEEM_Comandos_GGTS.txt: Describe los comandos que se deben utilizar en la aplicacción para crear un nuevo dominio (Plantilla Fitxa), para crea una nueva
	tarea programada (Job).

WECEEM_descr_funcionamiento.txt: Explicación de cómo funcionan algunas cosas, cómo se debe incluir un link en una GSP, qué ruta es la real, etc...

WECEEM_Instrucciones_Groovy.txt: Cómo detectar el nombre de la aplicación en el código GRAILS, por ejemplo.

WECEEM_Modificaciones.txt: Explica cómo realizar modificaciones en el código Groovy. Un ejemplo es cómo cambiar la ubicación de la página de resultados
	de búscqueda.

WECEEM_Modificaciones_CSS.txt: Explica las modificaciones realizadas en los estilos CSS del Bootstrap para poder adaptar correctamente las aplicaciones.

WECEEM_TagLibs.txt: Explica las taglibs propias de Weceem (cómo utilizarlas) y muestra el código y explica cómo utilizar las librerías propias.

WECEEM_Oracle.txt: Explica cómo adaptar Weceem a la base de datos Oracle.

Instrucciones Weceem GSP_.txt: hay instrucciones que hay que extraer del código que en él se encuentra.


-------------------
DÓNDE ENCONTRAR ...
-------------------
Menús desplegables: además de la carpeta donde se guardan las versiones (según su funcionamiento se guardan los css, js, etc) en la carpeta JS existe un archivo relacionado con el tema.
Placeholder: para que funcione el placeholder se han efectuado cambios en el código del CMS, pero además, para que funcione correctamente en IExplorer
			 se ha tenido que incluir un pequeño JS que se puede encontrar en la carpeta JS.
			 
			 
Widgets/Menu_dspl_bootstrap: están los archivos necesarios para hacer el desplegable que se encuentra encima del menú izquierdo.

JS/20141106_opcion_cancelar.txt: muestra cómo modificar los botones que aparecen en el menú de Crear nuevo contenido (New Content)


*****************************************************************************************************************************************************
------------------------------
Creación:	10-11-2014

Jesús Campos Muñoz
jesus.campos@upc.edu
------------------------------