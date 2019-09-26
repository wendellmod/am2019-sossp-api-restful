package br.com.sossp.apirest.service;

import br.com.sossp.apirest.dto.AddressDTO;
import br.com.sossp.apirest.models.Address;
import br.com.sossp.apirest.models.UserAddress;
import br.com.sossp.apirest.repository.AddressRepository;
import br.com.sossp.apirest.repository.UserAddressRepository;
import br.com.sossp.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository, UserAddressRepository userAddressRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.userAddressRepository = userAddressRepository;
    }

    @Transactional
    public void save(Long userId, AddressDTO addressDTO){
        userRepository.findById(userId).ifPresent(user -> {
            Address address = addressDTO.buildAddress();

            this.addressRepository.saveAndFlush(address);

            UserAddress userAddress = addressDTO.buildUserAddress();

            userAddress.setAddress(address);
            userAddress.setUser(user);

            this.userAddressRepository.saveAndFlush(userAddress);
        });
    }

}
