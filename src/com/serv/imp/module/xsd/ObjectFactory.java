
package com.serv.imp.module.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.serv.imp.module.xsd package. 
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

    private final static QName _UserAccountTokenUserAccount_QNAME = new QName("http://module.imp.serv.com/xsd", "userAccount");
    private final static QName _UserAccountTokenServiceName_QNAME = new QName("http://module.imp.serv.com/xsd", "serviceName");
    private final static QName _SsologinResponseMessage_QNAME = new QName("http://module.imp.serv.com/xsd", "message");
    private final static QName _SsologinResponseFlag_QNAME = new QName("http://module.imp.serv.com/xsd", "flag");
    private final static QName _SsologinResponseUser_QNAME = new QName("http://module.imp.serv.com/xsd", "user");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.serv.imp.module.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SsologinResponse }
     * 
     */
    public SsologinResponse createSsologinResponse() {
        return new SsologinResponse();
    }

    /**
     * Create an instance of {@link UserAccountToken }
     * 
     */
    public UserAccountToken createUserAccountToken() {
        return new UserAccountToken();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://module.imp.serv.com/xsd", name = "userAccount", scope = UserAccountToken.class)
    public JAXBElement<String> createUserAccountTokenUserAccount(String value) {
        return new JAXBElement<String>(_UserAccountTokenUserAccount_QNAME, String.class, UserAccountToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://module.imp.serv.com/xsd", name = "serviceName", scope = UserAccountToken.class)
    public JAXBElement<String> createUserAccountTokenServiceName(String value) {
        return new JAXBElement<String>(_UserAccountTokenServiceName_QNAME, String.class, UserAccountToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://module.imp.serv.com/xsd", name = "message", scope = SsologinResponse.class)
    public JAXBElement<String> createSsologinResponseMessage(String value) {
        return new JAXBElement<String>(_SsologinResponseMessage_QNAME, String.class, SsologinResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://module.imp.serv.com/xsd", name = "flag", scope = SsologinResponse.class)
    public JAXBElement<String> createSsologinResponseFlag(String value) {
        return new JAXBElement<String>(_SsologinResponseFlag_QNAME, String.class, SsologinResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAccountToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://module.imp.serv.com/xsd", name = "user", scope = SsologinResponse.class)
    public JAXBElement<UserAccountToken> createSsologinResponseUser(UserAccountToken value) {
        return new JAXBElement<UserAccountToken>(_SsologinResponseUser_QNAME, UserAccountToken.class, SsologinResponse.class, value);
    }

}
