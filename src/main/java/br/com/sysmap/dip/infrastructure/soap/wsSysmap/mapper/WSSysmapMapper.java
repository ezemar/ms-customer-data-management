package br.com.sysmap.dip.infrastructure.soap.wsSysmap.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.sysmap.dip.core.port.in.dto.Address;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.core.port.in.dto.Identification;
import br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub.ClientType;

public class WSSysmapMapper {
    
    public GetClientInfoByIdResponseDTO getClientInfoByIdResponseMap(ClientType clientTypeResponse){
        
        GetClientInfoByIdResponseDTO responseDTO = new GetClientInfoByIdResponseDTO();

        responseDTO.setFullName(clientTypeResponse.getFullName());
        responseDTO.setNationality(clientTypeResponse.getNationality());

        var xcal = clientTypeResponse.getBornDate();
        if (xcal.isValid()) {
            responseDTO.setBornDate(xcal.toGregorianCalendar().toZonedDateTime().toLocalDate());
        }
        
        List<Address> addressList = new ArrayList<Address>();
        
        clientTypeResponse.getAddressList().getAddress().forEach(addressSOAP -> {
            Address addressDTO = new Address();

            addressDTO.setAddressCEP(addressSOAP.getAddressCEP());
            addressDTO.setAddressCity(addressSOAP.getAddressCity());
            addressDTO.setAddressComplement(addressSOAP.getAddressComplement());
            addressDTO.setAddressDistrict(addressSOAP.getAddressDistrict());
            addressDTO.setAddressNumber(addressSOAP.getAddressNumber());
            addressDTO.setAddressStreet(addressSOAP.getAddressStreet());
            addressDTO.setAddressType(addressSOAP.getAddressType());
            addressDTO.setAddressUF(addressSOAP.getAddressUF());

            addressList.add(addressDTO);
        });

        responseDTO.setAddressList(addressList);

        List<Identification> identificationList = new ArrayList<Identification>();

        clientTypeResponse.getIndividualIdentificationList().getIdentification().forEach(identificationSOAP -> {
            Identification identificationDTO = new Identification();

            identificationDTO.setDocumentType(identificationSOAP.getDocumentType());
            identificationDTO.setValue(identificationSOAP.getValue());

            identificationList.add(identificationDTO);
        });

        responseDTO.setIndividualIdentificationList(identificationList);

            return responseDTO;
        }

}
