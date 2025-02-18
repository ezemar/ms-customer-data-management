//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.0 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.02.18 às 06:20:56 AM BRT 
//


package br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub package. 
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

    private final static QName _CustomHeader_QNAME = new QName("http://web.service.sysmap.com.br/", "customHeader");
    private final static QName _GetClientInfoListRequest_QNAME = new QName("http://web.service.sysmap.com.br/", "getClientInfoListRequest");
    private final static QName _GetClientInfoListResponse_QNAME = new QName("http://web.service.sysmap.com.br/", "getClientInfoListResponse");
    private final static QName _GetClientInfoByIdRequest_QNAME = new QName("http://web.service.sysmap.com.br/", "getClientInfoByIdRequest");
    private final static QName _GetClientInfoByIdResponse_QNAME = new QName("http://web.service.sysmap.com.br/", "getClientInfoByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientListType }
     * 
     */
    public ClientListType createClientListType() {
        return new ClientListType();
    }

    /**
     * Create an instance of {@link CustomHeaderType }
     * 
     */
    public CustomHeaderType createCustomHeaderType() {
        return new CustomHeaderType();
    }

    /**
     * Create an instance of {@link OffsetLimitType }
     * 
     */
    public OffsetLimitType createOffsetLimitType() {
        return new OffsetLimitType();
    }

    /**
     * Create an instance of {@link IdentificationType }
     * 
     */
    public IdentificationType createIdentificationType() {
        return new IdentificationType();
    }

    /**
     * Create an instance of {@link ClientType }
     * 
     */
    public ClientType createClientType() {
        return new ClientType();
    }

    /**
     * Create an instance of {@link IdentificationListType }
     * 
     */
    public IdentificationListType createIdentificationListType() {
        return new IdentificationListType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link AddressListType }
     * 
     */
    public AddressListType createAddressListType() {
        return new AddressListType();
    }

    /**
     * Create an instance of {@link ClientListType.ClientList }
     * 
     */
    public ClientListType.ClientList createClientListTypeClientList() {
        return new ClientListType.ClientList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomHeaderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomHeaderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.service.sysmap.com.br/", name = "customHeader")
    public JAXBElement<CustomHeaderType> createCustomHeader(CustomHeaderType value) {
        return new JAXBElement<CustomHeaderType>(_CustomHeader_QNAME, CustomHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffsetLimitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffsetLimitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.service.sysmap.com.br/", name = "getClientInfoListRequest")
    public JAXBElement<OffsetLimitType> createGetClientInfoListRequest(OffsetLimitType value) {
        return new JAXBElement<OffsetLimitType>(_GetClientInfoListRequest_QNAME, OffsetLimitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.service.sysmap.com.br/", name = "getClientInfoListResponse")
    public JAXBElement<ClientListType> createGetClientInfoListResponse(ClientListType value) {
        return new JAXBElement<ClientListType>(_GetClientInfoListResponse_QNAME, ClientListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.service.sysmap.com.br/", name = "getClientInfoByIdRequest")
    public JAXBElement<IdentificationType> createGetClientInfoByIdRequest(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_GetClientInfoByIdRequest_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientType }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.service.sysmap.com.br/", name = "getClientInfoByIdResponse")
    public JAXBElement<ClientType> createGetClientInfoByIdResponse(ClientType value) {
        return new JAXBElement<ClientType>(_GetClientInfoByIdResponse_QNAME, ClientType.class, null, value);
    }

}
