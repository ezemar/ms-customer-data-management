package br.com.sysmap.dip.core.port.in.dto;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetClientInfoByIdResponseDTO {

    private String fullName;
    private LocalDate bornDate;
    private String nationality;
    private List<Address> addressList;
    private List<Identification> individualIdentificationList;

}
