package br.com.sysmap.dip.api.customerDataManagement.rest;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysmap.dip.core.port.in.CustomerDataManagementPortIn;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdRequestDTO;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.infrastructure.AbstractGenericException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerDataManagementController implements CustomerDataManagementControllerAPI{

    private final CustomerDataManagementPortIn customerDataManagementPortIn;


    @Override
    public ResponseEntity<GetClientInfoByIdResponseDTO> getClientInfoById(String authorization,
            @Valid GetClientInfoByIdRequestDTO getClientInfoByIdRequest) throws DatatypeConfigurationException, AbstractGenericException {
        
        GetClientInfoByIdResponseDTO getClientInfoByIdResponseDTO = new GetClientInfoByIdResponseDTO();

        getClientInfoByIdResponseDTO = customerDataManagementPortIn.getClientInfoById(authorization, getClientInfoByIdRequest);

        return ResponseEntity.ok(getClientInfoByIdResponseDTO);
    }
    
}
