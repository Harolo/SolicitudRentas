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
 * <p>Java class for TemporBeneficiario.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="TemporBeneficiario"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="V"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TemporBeneficiario", namespace = "http://servicios.webservices.bonospensionales.minhacienda.gov.co/schema/BeneficiariosDTO")
@XmlEnum
public enum TemporBeneficiario {

    V,
    T;

    public String value() {
        return name();
    }

    public static TemporBeneficiario fromValue(String v) {
        return valueOf(v);
    }

}
