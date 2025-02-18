package br.com.sysmap.dip.core.port.in;

import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdRequestDTO;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.infrastructure.AbstractGenericException;

public interface CustomerDataManagementPortIn {

    GetClientInfoByIdResponseDTO getClientInfoById (String authorization, GetClientInfoByIdRequestDTO getClientInfoByIdRequest) throws AbstractGenericException;

}
