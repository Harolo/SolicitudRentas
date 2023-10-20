//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.12 at 10:24:31 AM COT 
//


package com.bbva.obp.SolicitudRentas.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SolicitudRenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SolicitudRenta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoCausante" type="{http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/CausanteDTO}CausanteDTO"/&gt;
 *         &lt;element name="tipoRenta" type="{http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/RentaDTO}RentaDTO"/&gt;
 *         &lt;element name="tipoBeneficiarios" type="{http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/BeneficiariosDTO}BeneficiariosDTO" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SolicitudRenta", namespace = "http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/SolicitudRenta", propOrder = {
    "tipoCausante",
    "tipoRenta",
    "tipoBeneficiarios"
})
public class SolicitudRenta {

    @XmlElement(required = true)
    protected CausanteDTO tipoCausante;
    @XmlElement(required = true)
    protected RentaDTO tipoRenta;
    @XmlElement(required = true)
    protected List<BeneficiariosDTO> tipoBeneficiarios;

    /**
     * Gets the value of the tipoCausante property.
     * 
     * @return
     *     possible object is
     *     {@link CausanteDTO }
     *     
     */
    public CausanteDTO getTipoCausante() {
        return tipoCausante;
    }

    /**
     * Sets the value of the tipoCausante property.
     * 
     * @param value
     *     allowed object is
     *     {@link CausanteDTO }
     *     
     */
    public void setTipoCausante(CausanteDTO value) {
        this.tipoCausante = value;
    }

    /**
     * Gets the value of the tipoRenta property.
     * 
     * @return
     *     possible object is
     *     {@link RentaDTO }
     *     
     */
    public RentaDTO getTipoRenta() {
        return tipoRenta;
    }

    /**
     * Sets the value of the tipoRenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RentaDTO }
     *     
     */
    public void setTipoRenta(RentaDTO value) {
        this.tipoRenta = value;
    }

    /**
     * Gets the value of the tipoBeneficiarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoBeneficiarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoBeneficiarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeneficiariosDTO }
     * 
     * 
     */
    public List<BeneficiariosDTO> getTipoBeneficiarios() {
        if (tipoBeneficiarios == null) {
            tipoBeneficiarios = new ArrayList<BeneficiariosDTO>();
        }
        return this.tipoBeneficiarios;
    }

}
