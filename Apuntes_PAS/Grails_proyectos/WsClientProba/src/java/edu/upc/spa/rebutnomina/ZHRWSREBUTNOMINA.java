package edu.upc.spa.rebutnomina;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2014-11-27T09:48:19.457+01:00
 * Generated source version: 2.4.2
 * 
 */
@WebService(targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", name = "ZHR_WS_REBUT_NOMINA")
@XmlSeeAlso({ObjectFactory.class})
public interface ZHRWSREBUTNOMINA {

    @RequestWrapper(localName = "ZhrPortalNouRebutNomina", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "edu.upc.spa.rebutnomina.ZhrPortalNouRebutNomina")
    @WebMethod(operationName = "ZhrPortalNouRebutNomina")
    @ResponseWrapper(localName = "ZhrPortalNouRebutNominaResponse", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", className = "edu.upc.spa.rebutnomina.ZhrPortalNouRebutNominaResponse")
    public void zhrPortalNouRebutNomina(
        @WebParam(name = "Period", targetNamespace = "")
        java.lang.String period,
        @WebParam(name = "Pernr", targetNamespace = "")
        java.lang.String pernr,
        @WebParam(mode = WebParam.Mode.OUT, name = "Missatges", targetNamespace = "")
        javax.xml.ws.Holder<ZhrPortalNouErrorsTable> missatges,
        @WebParam(mode = WebParam.Mode.OUT, name = "Pdf", targetNamespace = "")
        javax.xml.ws.Holder<byte[]> pdf
    );
}