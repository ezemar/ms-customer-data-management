package br.com.sysmap.dip.core.port.out;

import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdRequestDTO;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.infrastructure.AbstractGenericException;

public interface CustomerDataManagementPortOut {
    
    //OperationResponseSOAP operation1 (String authorization, OperationRequestSOAP operationRequest);
    GetClientInfoByIdResponseDTO getClientInfoById (String authorization, GetClientInfoByIdRequestDTO getClientInfoByIdRequest) throws AbstractGenericException;

}
