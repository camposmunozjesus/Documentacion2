WECEEM - HISTORIAL DE ARCHIVOS
==============================
weceem-1.2: es el plugin de la aplicaci�n Portal.
weceem-app-master: puede ser la aplicaci�n original con la que se consigui� conectar con Oracle, pero NO est� el plugin. Seguramente es la misma que hay dentro de v1.

Copias de seguridad de la aplicaci�n: 
	D:\Weceem\Portal (
	- La carpeta "plugin" contiene la carpeta "Portal" que hay que copiar en "C:\Users\Jesus Campos\.grails\2.3.7\projects".
	- La carpeta "Portal" es la del workspace.


------------------------
LOCALIZACI�N DE ARCHIVOS
------------------------
En local, las im�genes se guardan en:
	D:\var\www\weceem.org\uploads\PAS
Indicado en la parte development del archivo Config.groovy de la aplicaci�n. Se arranca en developmant cuando se ejecuta el comando:
	run-app --verbose --stacktrace  -Dserver.port=8090


-------------------------
ARCHIVOS GENERALES WECEEM
-------------------------
WECEEM_Comandos_GGTS.txt: Describe los comandos que se deben utilizar en la aplicacci�n para crear un nuevo dominio (Plantilla Fitxa), para crea una nueva
	tarea programada (Job).

WECEEM_descr_funcionamiento.txt: Explicaci�n de c�mo funcionan algunas cosas, c�mo se debe incluir un link en una GSP, qu� ruta es la real, etc...

WECEEM_Instrucciones_Groovy.txt: C�mo detectar el nombre de la aplicaci�n en el c�digo GRAILS, por ejemplo.

WECEEM_Modificaciones.txt: Explica c�mo realizar modificaciones en el c�digo Groovy. Un ejemplo es c�mo cambiar la ubicaci�n de la p�gina de resultados
	de b�scqueda.

WECEEM_Modificaciones_CSS.txt: Explica las modificaciones realizadas en los estilos CSS del Bootstrap para poder adaptar correctamente las aplicaciones.

WECEEM_TagLibs.txt: Explica las taglibs propias de Weceem (c�mo utilizarlas) y muestra el c�digo y explica c�mo utilizar las librer�as propias.

WECEEM_Oracle.txt: Explica c�mo adaptar Weceem a la base de datos Oracle.

Instrucciones Weceem GSP_.txt: hay instrucciones que hay que extraer del c�digo que en �l se encuentra.


-------------------
D�NDE ENCONTRAR ...
-------------------
Men�s desplegables: adem�s de la carpeta donde se guardan las versiones (seg�n su funcionamiento se guardan los css, js, etc) en la carpeta JS existe un archivo relacionado con el tema.
Placeholder: para que funcione el placeholder se han efectuado cambios en el c�digo del CMS, pero adem�s, para que funcione correctamente en IExplorer
			 se ha tenido que incluir un peque�o JS que se puede encontrar en la carpeta JS.
			 
			 
Widgets/Menu_dspl_bootstrap: est�n los archivos necesarios para hacer el desplegable que se encuentra encima del men� izquierdo.

JS/20141106_opcion_cancelar.txt: muestra c�mo modificar los botones que aparecen en el men� de Crear nuevo contenido (New Content)


*****************************************************************************************************************************************************
------------------------------
Creaci�n:	10-11-2014

Jes�s Campos Mu�oz
jesus.campos@upc.edu
------------------------------