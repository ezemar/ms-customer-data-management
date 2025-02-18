package br.com.sysmap.dip.core.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetClientInfoByIdRequestDTO {

    private String documentType;
    private String identificationId;
    
}
