//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.12 at 10:24:31 AM COT 
//


package com.bbva.obp.SolicitudRentas.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistroDocumentos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistroDocumentos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoDocumento" type="{http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RegistroDocumentos}TipoDocumento"/&gt;
 *         &lt;element name="tipoIdentificacionC" type="{http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RegistroDocumentos}TipoIdentificacionC"/&gt;
 *         &lt;element name="tipoDocumentoC" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoIdentificacionB" type="{http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RegistroDocumentos}TipoIdentificacionB" minOccurs="0"/&gt;
 *         &lt;element name="tipoDocumentoB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoArchivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistroDocumentos", namespace = "http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RegistroDocumentos", propOrder = {
    "tipoDocumento",
    "tipoIdentificacionC",
    "tipoDocumentoC",
    "tipoIdentificacionB",
    "tipoDocumentoB",
    "tipoArchivo"
})
public class RegistroDocumentos {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoDocumento tipoDocumento;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoIdentificacionC tipoIdentificacionC;
    @XmlElement(required = true)
    protected String tipoDocumentoC;
    @XmlElementRef(name = "tipoIdentificacionB", namespace = "http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RegistroDocumentos", type = JAXBElement.class, required = false)
    protected JAXBElement<TipoIdentificacionB> tipoIdentificacionB;
    @XmlElementRef(name = "tipoDocumentoB", namespace = "http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RegistroDocumentos", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoDocumentoB;
    @XmlElement(required = true)
    protected String tipoArchivo;

    /**
     * Gets the value of the tipoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link TipoDocumento }
     *     
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Sets the value of the tipoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDocumento }
     *     
     */
    public void setTipoDocumento(TipoDocumento value) {
        this.tipoDocumento = value;
    }

    /**
     * Gets the value of the tipoIdentificacionC property.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdentificacionC }
     *     
     */
    public TipoIdentificacionC getTipoIdentificacionC() {
        return tipoIdentificacionC;
    }

    /**
     * Sets the value of the tipoIdentificacionC property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdentificacionC }
     *     
     */
    public void setTipoIdentificacionC(TipoIdentificacionC value) {
        this.tipoIdentificacionC = value;
    }

    /**
     * Gets the value of the tipoDocumentoC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoC() {
        return tipoDocumentoC;
    }

    /**
     * Sets the value of the tipoDocumentoC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoC(String value) {
        this.tipoDocumentoC = value;
    }

    /**
     * Gets the value of the tipoIdentificacionB property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TipoIdentificacionB }{@code >}
     *     
     */
    public JAXBElement<TipoIdentificacionB> getTipoIdentificacionB() {
        return tipoIdentificacionB;
    }

    /**
     * Sets the value of the tipoIdentificacionB property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TipoIdentificacionB }{@code >}
     *     
     */
    public void setTipoIdentificacionB(JAXBElement<TipoIdentificacionB> value) {
        this.tipoIdentificacionB = value;
    }

    /**
     * Gets the value of the tipoDocumentoB property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoDocumentoB() {
        return tipoDocumentoB;
    }

    /**
     * Sets the value of the tipoDocumentoB property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoDocumentoB(JAXBElement<String> value) {
        this.tipoDocumentoB = value;
    }

    /**
     * Gets the value of the tipoArchivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoArchivo() {
        return tipoArchivo;
    }

    /**
     * Sets the value of the tipoArchivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoArchivo(String value) {
        this.tipoArchivo = value;
    }

}
