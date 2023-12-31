package az.ingress.ms.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
