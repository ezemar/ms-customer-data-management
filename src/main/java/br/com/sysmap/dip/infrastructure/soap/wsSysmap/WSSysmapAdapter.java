package br.com.sysmap.dip.infrastructure.soap.wsSysmap;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.SoapMessage;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdRequestDTO;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.core.port.out.CustomerDataManagementPortOut;
import br.com.sysmap.dip.infrastructure.AbstractGenericException;
import br.com.sysmap.dip.infrastructure.soap.wsSysmap.mapper.WSSysmapMapper;
import br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub.ClientType;
import br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub.CustomHeaderType;
import br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub.IdentificationType;
import br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WSSysmapAdapter implements CustomerDataManagementPortOut {

    private WebServiceTemplate webServiceTemplate;

    public WSSysmapAdapter(@Qualifier("webServiceTemplateSysmap") WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
        ClientInterceptor loggingInterceptor = new SoapLoggingInterceptor();
        
        this.webServiceTemplate.setInterceptors(new ClientInterceptor[] { loggingInterceptor });

    }

    @SuppressWarnings("unchecked")
    @Override
    public GetClientInfoByIdResponseDTO getClientInfoById(String authorization, GetClientInfoByIdRequestDTO getClientInfoByIdRequest) throws AbstractGenericException {

        log.info("[CustomerDataManagement - GetClientInfoById [WSSysmap.getClientInfoById()] - chamando webservice");

        var factory = new ObjectFactory();
        var identificationType = factory.createIdentificationType();

        identificationType.setDocumentType(getClientInfoByIdRequest.getDocumentType());
        identificationType.setValue(getClientInfoByIdRequest.getIdentificationId());

        try {
            JAXBElement<IdentificationType> request = factory.createGetClientInfoByIdRequest(identificationType);

            // Marshal e enviar a requisição para o webservice
            //JAXBElement <ClientType> response = null;
            CustomHeaderType customHeader = new CustomHeaderType();

            customHeader.setApplication("SysMap App");
            customHeader.setJwt(authorization.split(" ")[1]);
            customHeader.setTransactionId(UUID.randomUUID().toString());
            
            // Crie o JAXBElement para o cabeçalho
            JAXBElement<CustomHeaderType> headers = factory.createCustomHeader(customHeader);
            
            var responseSOAP = (JAXBElement<ClientType>) webServiceTemplate.marshalSendAndReceive(request, message -> {
                if (message instanceof SoapMessage) {
                    SoapMessage soapMessage = (SoapMessage) message;
            
                    // Obtém o cabeçalho SOAP
                    var soapHeader = soapMessage.getSoapHeader();
            
                    try {
                        // Cria o contexto JAXB e o marshaller
                        JAXBContext context = JAXBContext.newInstance(CustomHeaderType.class);
                        Marshaller marshaller = context.createMarshaller();
            
                        // Marshaller serializa customHeader para o cabeçalho SOAP
                        marshaller.marshal(headers, soapHeader.getResult());
                    } catch (JAXBException e) {
                        // Trate a exceção JAXB se ocorrer
                        log.error("Erro ao marshaller o cabeçalho SOAP", e);
                        throw new RuntimeException("Erro ao marshaller o cabeçalho SOAP", e);
                    }
                }
            });
            
            log.info("[CustomerDataManagement - GetClientInfoById [WSSysmap.getClientInfoById()] - Concluindo consumo!");

            ClientType clientTypeResponse = responseSOAP.getValue();

            WSSysmapMapper mapper = new WSSysmapMapper();
            
            GetClientInfoByIdResponseDTO responseDTO = new GetClientInfoByIdResponseDTO();
            responseDTO = mapper.getClientInfoByIdResponseMap(clientTypeResponse);

            return responseDTO;

        } catch (Exception e) {
            log.error("[CustomerDataManagement - GetClientInfoById [WSSysmap.getClientInfoById()] - Error: {}", e.getMessage(), e);
            throw new AbstractGenericException("500", "INTERNAL SERVER ERROR", e.getMessage(), null, "dfd");
        }
    }
}
