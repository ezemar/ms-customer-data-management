package br.com.sysmap.dip.core.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sysmap.dip.core.port.in.CustomerDataManagementPortIn;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdRequestDTO;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.core.port.out.CustomerDataManagementPortOut;
import br.com.sysmap.dip.infrastructure.AbstractGenericException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerDataManagementService implements CustomerDataManagementPortIn{

    @Autowired
    private CustomerDataManagementPortOut customerDataManagementPortOut;

    @Override
    public GetClientInfoByIdResponseDTO getClientInfoById(String authorization,
            GetClientInfoByIdRequestDTO getClientInfoByIdRequest) throws AbstractGenericException {
        
            GetClientInfoByIdResponseDTO getClientInfoByIdResponseDTO = new GetClientInfoByIdResponseDTO();
            
            try{
                getClientInfoByIdResponseDTO = customerDataManagementPortOut.getClientInfoById(authorization, getClientInfoByIdRequest);
            } catch (Exception e) {
                log.error("Um erro ocorreu: " + e.getMessage());
                throw new AbstractGenericException("500", "INTERNAL SERVER ERROR", e.getMessage(), null, "dfd");
            }

            return getClientInfoByIdResponseDTO;

    }
    
}
