//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.0 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.02.18 às 06:20:56 AM BRT 
//


package br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de addressType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="addressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addressCEP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressComplement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressUF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressType", propOrder = {
    "addressCEP",
    "addressCity",
    "addressComplement",
    "addressDistrict",
    "addressNumber",
    "addressStreet",
    "addressType",
    "addressUF"
})
public class AddressType {

    protected String addressCEP;
    protected String addressCity;
    protected String addressComplement;
    protected String addressDistrict;
    protected String addressNumber;
    protected String addressStreet;
    protected String addressType;
    protected String addressUF;

    /**
     * Obtém o valor da propriedade addressCEP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCEP() {
        return addressCEP;
    }

    /**
     * Define o valor da propriedade addressCEP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCEP(String value) {
        this.addressCEP = value;
    }

    /**
     * Obtém o valor da propriedade addressCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * Define o valor da propriedade addressCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCity(String value) {
        this.addressCity = value;
    }

    /**
     * Obtém o valor da propriedade addressComplement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressComplement() {
        return addressComplement;
    }

    /**
     * Define o valor da propriedade addressComplement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressComplement(String value) {
        this.addressComplement = value;
    }

    /**
     * Obtém o valor da propriedade addressDistrict.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressDistrict() {
        return addressDistrict;
    }

    /**
     * Define o valor da propriedade addressDistrict.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressDistrict(String value) {
        this.addressDistrict = value;
    }

    /**
     * Obtém o valor da propriedade addressNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     * Define o valor da propriedade addressNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressNumber(String value) {
        this.addressNumber = value;
    }

    /**
     * Obtém o valor da propriedade addressStreet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressStreet() {
        return addressStreet;
    }

    /**
     * Define o valor da propriedade addressStreet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressStreet(String value) {
        this.addressStreet = value;
    }

    /**
     * Obtém o valor da propriedade addressType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Define o valor da propriedade addressType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Obtém o valor da propriedade addressUF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressUF() {
        return addressUF;
    }

    /**
     * Define o valor da propriedade addressUF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressUF(String value) {
        this.addressUF = value;
    }

}
