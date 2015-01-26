package utils
import org.apache.commons.logging.LogFactory;
import javax.activation.MimetypesFileTypeMap
import javax.servlet.http.HttpServletRequest;
import grails.util.Holders;
import org.apache.commons.io.FilenameUtils;
import sig.*;

class FileUploader {
	
	private static final log = LogFactory.getLog(this)
	
	public static upload(def file, def prefix_nom, def sufix_nom)
	{			
		if (!file.empty) {	
			def realPath = Holders.config.grails.path						
				
			String extension = FilenameUtils.getExtension(file.getOriginalFilename())
			if(extension != null) {
				extension = "." + extension
			}
				
			String name = prefix_nom + extension;
			String serverPath = realPath + name;
				
			//Try to store the file				
			try
			{
				def file2upload = new File(serverPath)
				file.transferTo(file2upload)
				log.info("Archiu "+ file.getOriginalFilename() + " pujat.")
				return name;
			}
			catch (Exception e)
			{
				log.error("Error al pujar archiu: " +e.toString())
				return null;					
			}
		}
		else
		{
			log.info("Fitxer buit.")
			return null;
		}
	}
	
	public static download(fileName, response)
	{
		def realPath = Holders.config.grails.path			
		def file = new File(realPath+fileName)
			
		try
		{
			def os = response.outputStream
			response.setHeader("Content-Type", new MimetypesFileTypeMap().getContentType(file))				
			response.setHeader("Content-disposition", "attachment;filename=\"${file.name}\"")
			os << file.newInputStream()
			os.flush()
			return true;
		}
		catch(Exception e)
		{
			log.error("Problema amb el fitxer, probablement estigui borrat: "+ e.toString())
			return false;
		}
	}		
		
	public static getLogs(response)
	{
		def logsPlace = "/gpr/users/log/RLG_Info.log"
		def file = new File(logsPlace)
			
		try
		{
			def os = response.outputStream
			response.setHeader("Content-Type", new MimetypesFileTypeMap().getContentType(file))
			response.setHeader("Content-disposition", "attachment;filename=${file.name}")
			os << file.newInputStream()
			return true;
		}
		catch(Exception e)
		{			
			return false;
		}
	}
		
}


	
