//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.10.12 at 10:24:31 AM COT 
//


package com.bbva.obp.SolicitudRentas.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoTipoBeneficiario.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="TipoTipoBeneficiario"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoTipoBeneficiario", namespace = "http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/BeneficiariosDTO")
@XmlEnum
public enum TipoTipoBeneficiario {

    N,
    C,
    H,
    M,
    P,
    E;

    public String value() {
        return name();
    }

    public static TipoTipoBeneficiario fromValue(String v) {
        return valueOf(v);
    }

}
