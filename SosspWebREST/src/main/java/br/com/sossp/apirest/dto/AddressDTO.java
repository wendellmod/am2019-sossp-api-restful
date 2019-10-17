package br.com.sossp.apirest.dto;

import br.com.sossp.apirest.models.Address;
import br.com.sossp.apirest.models.State;
import br.com.sossp.apirest.models.UserAddress;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AddressDTO {

    private Long zipcode;
    private String addressName;
    private String neighborhood;
    private String city;
    private State state;
    private int number;
    private String complement;

    public Address buildAddress(){

        Address address = new Address();
        address.setZipcode(zipcode);
        address.setAddressName(addressName);
        address.setNeighborhood(neighborhood);
        address.setCity(city);
        address.setState(state);

        return address;
    }

    public UserAddress buildUserAddress(){

        UserAddress userAddress = new UserAddress();
        userAddress.setAddressComplement(complement);
        userAddress.setNumberAddress(number);

        return userAddress;
    }

}
