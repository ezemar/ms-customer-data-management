package br.com.sysmap.dip.core.port.in.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String addressCEP;
    private String addressCity;
    private String addressComplement;
    private String addressDistrict;
    private String addressNumber;
    private String addressStreet;
    private String addressType;
    private String addressUF;

}
