
package com.serv.act;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://module.imp.serv.com/xsd}SsologinResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "_return"
})
@XmlRootElement(name = "ssologinResponse")
public class SsologinResponse {

    @XmlElementRef(name = "return", namespace = "http://act.serv.com", type = JAXBElement.class)
    protected JAXBElement<com.serv.imp.module.xsd.SsologinResponse> _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link com.serv.imp.module.xsd.SsologinResponse }{@code >}
     *     
     */
    public JAXBElement<com.serv.imp.module.xsd.SsologinResponse> getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link com.serv.imp.module.xsd.SsologinResponse }{@code >}
     *     
     */
    public void setReturn(JAXBElement<com.serv.imp.module.xsd.SsologinResponse> value) {
        this._return = value;
    }

}
