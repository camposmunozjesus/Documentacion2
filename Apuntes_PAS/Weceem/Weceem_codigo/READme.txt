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

WECEEM_descr_funcionamiento.txt: Explicación de cómo funcionan algunas cosas, cómo se debe incluir un link en una GSP, qué ruta es la real, etc..., dónde
	encontrar la GSP de la pantalla que estmos visualizando ...

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
			 
Policy_weceem: Privacidad/archivo policy.weceem. Esplica cómo hacer funcionar esta característica.			 
			 
Widgets/Menu_dspl_bootstrap: están los archivos necesarios para hacer el desplegable que se encuentra encima del menú izquierdo.

JS/20141106_opcion_cancelar.txt: muestra cómo modificar los botones que aparecen en el menú de Crear nuevo contenido (New Content)

WECEEM_Comandos_GGTS.txt:
	- Crear una clase de dominio
	- Crear el paquete WAR	
	
WECEEM_descr_funcionamiento.txt:
	- Hacer el paquete WAR.
	- Localización de archivos: dónde guarda Weceem los archivos que subimos.
	- Rutas: referenciar páginas del propio Space de manera que la aplicación sirva para varios spaces/servidores.
	- Rutas: cómo referenciar una página del Space o una imagen, qué ruta tienen las imágenes subidas con el editor CKEditor.
	- GSP donde se encuentran los spaces y pueden ser importados/exportados (Administración -> Spaces): saber dónde hay que tocar para editarla.
	- Pantalla del EDITOR: GSP donde se puede modificar la página de creación de contenidos.

WECEEM_Modificaciones.txt:
	- Permitir visualizar el menú lateral en determinados tipos de elementos.
	- Permitir visualizar en el menú lateral determinados tipos de elementos.
	- Buscador:
		- Cambiar la ubicación de la página de resultados del buscador.
		- Reconstruir índice del buscador.
	- Redireccionar vistas.
	- Paginación en la vista de Spaces (Importar/Exportar).
	- Archivo de políticas de privacidad. (ESTÁ POR HACER!!!!!!!!!)
	- Redirección de spaces en función del perfil.
	- Eliminar/activar el springSecurity-CAS.
	- Solución al cierre de sesión
	- Modificar tamaño de los editores (GSP/Rich Edior).

WECEEM_Modificaciones_CSS.txt:
	- Tamaños de tablas responsivas personalizados (Problema jumbotron en aplicación RP).
	- Carrusel



*****************************************************************************************************************************************************
------------------------------
Creación:	10-11-2014

Jesús Campos Muñoz
jesus.campos@upc.edu
------------------------------