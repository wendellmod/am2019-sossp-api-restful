package br.com.sossp.apirest.dto;

import br.com.sossp.apirest.models.Address;
import br.com.sossp.apirest.models.State;
import br.com.sossp.apirest.models.UserAddress;
import lombok.Data;

@Data
public class AddressDTO {

    private String name;
    private String neighborhood;
    private String city;
    private State state;
    private String zipcode;
    private int number;
    private String complement;

    public Address buildAddress(){

        Address address = new Address();
        address.setAddressName(name);
        address.setNeighborhood(neighborhood);
        address.setCity(city);
        address.setState(state);
        address.setZipcode(zipcode);

        return address;
    }

    public UserAddress buildUserAddress(){

        UserAddress userAddress = new UserAddress();
        userAddress.setAddressComplement(complement);
        userAddress.setNumberAddress(number);

        return userAddress;
    }

}
