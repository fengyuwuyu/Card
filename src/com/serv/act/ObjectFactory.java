
package com.serv.act;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.serv.act package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SsologinResponseReturn_QNAME = new QName("http://act.serv.com", "return");
    private final static QName _SsologinTicket_QNAME = new QName("http://act.serv.com", "ticket");
    private final static QName _SsologinServicename_QNAME = new QName("http://act.serv.com", "servicename");
    private final static QName _SsologinClientIp_QNAME = new QName("http://act.serv.com", "clientIp");
    private final static QName _SsologinMainservicename_QNAME = new QName("http://act.serv.com", "mainservicename");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.serv.act
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ssologin }
     * 
     */
    public Ssologin createSsologin() {
        return new Ssologin();
    }

    /**
     * Create an instance of {@link com.serv.act.SsologinResponse }
     * 
     */
    public com.serv.act.SsologinResponse createSsologinResponse() {
        return new com.serv.act.SsologinResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.serv.imp.module.xsd.SsologinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://act.serv.com", name = "return", scope = com.serv.act.SsologinResponse.class)
    public JAXBElement<com.serv.imp.module.xsd.SsologinResponse> createSsologinResponseReturn(com.serv.imp.module.xsd.SsologinResponse value) {
        return new JAXBElement<com.serv.imp.module.xsd.SsologinResponse>(_SsologinResponseReturn_QNAME, com.serv.imp.module.xsd.SsologinResponse.class, com.serv.act.SsologinResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://act.serv.com", name = "ticket", scope = Ssologin.class)
    public JAXBElement<String> createSsologinTicket(String value) {
        return new JAXBElement<String>(_SsologinTicket_QNAME, String.class, Ssologin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://act.serv.com", name = "servicename", scope = Ssologin.class)
    public JAXBElement<String> createSsologinServicename(String value) {
        return new JAXBElement<String>(_SsologinServicename_QNAME, String.class, Ssologin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://act.serv.com", name = "clientIp", scope = Ssologin.class)
    public JAXBElement<String> createSsologinClientIp(String value) {
        return new JAXBElement<String>(_SsologinClientIp_QNAME, String.class, Ssologin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://act.serv.com", name = "mainservicename", scope = Ssologin.class)
    public JAXBElement<String> createSsologinMainservicename(String value) {
        return new JAXBElement<String>(_SsologinMainservicename_QNAME, String.class, Ssologin.class, value);
    }

}
