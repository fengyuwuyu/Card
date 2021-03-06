
package com.serv.act;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.serv.imp.module.xsd.SsologinResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SsoWSPortType", targetNamespace = "http://act.serv.com")
@XmlSeeAlso({
    com.serv.act.ObjectFactory.class,
    com.serv.imp.module.xsd.ObjectFactory.class
})
public interface SsoWSPortType {


    /**
     * 
     * @param ticket
     * @param servicename
     * @param clientIp
     * @param mainservicename
     * @return
     *     returns com.serv.imp.module.xsd.SsologinResponse
     */
    @WebMethod(action = "urn:ssologin")
    @WebResult(targetNamespace = "http://act.serv.com")
    @RequestWrapper(localName = "ssologin", targetNamespace = "http://act.serv.com", className = "com.serv.act.Ssologin")
    @ResponseWrapper(localName = "ssologinResponse", targetNamespace = "http://act.serv.com", className = "com.serv.act.SsologinResponse")
    public SsologinResponse ssologin(
        @WebParam(name = "ticket", targetNamespace = "http://act.serv.com")
        String ticket,
        @WebParam(name = "clientIp", targetNamespace = "http://act.serv.com")
        String clientIp,
        @WebParam(name = "servicename", targetNamespace = "http://act.serv.com")
        String servicename,
        @WebParam(name = "mainservicename", targetNamespace = "http://act.serv.com")
        String mainservicename);
}
