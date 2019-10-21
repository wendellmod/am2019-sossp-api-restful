package br.com.sossp.apirest.service;

import br.com.sossp.apirest.dto.AddressDTO;
import br.com.sossp.apirest.models.Address;
import br.com.sossp.apirest.models.UserAddress;
import br.com.sossp.apirest.models.UserAddressPK;
import br.com.sossp.apirest.repository.AddressRepository;
import br.com.sossp.apirest.repository.UserAddressRepository;
import br.com.sossp.apirest.repository.UserRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    // GET
    public AddressDTO findByPk(Long userId, Long zipcode, Integer numberAddress) {

        UserAddressPK pk = new UserAddressPK();
        pk.setUser(userId);
        pk.setAddress(zipcode);
        pk.setNumberAddress(numberAddress);

        return userAddressRepository.findById(pk).get()
                .getUser().getUserAddresses()
                .stream()
                .map(AddressDTO::new)
                .findFirst()
                .get();
    }

    // GET
    public List<AddressDTO> findAddressesByUser(Long userId) {
        return userRepository.findById(userId).get()
                .getUserAddresses()
                .stream()
                .map(AddressDTO::new)
                .collect(Collectors.toList());
    }

    // POST
    @Transactional
    public void save(Long userId, AddressDTO addressDTO){
        userRepository.findById(userId).ifPresent(user -> {

            Address address = addressDTO.buildAddress();

            this.addressRepository.saveAndFlush(address);

            UserAddress userAddress = addressDTO.buildUserAddress();

            userAddress.setUser(user);
            userAddress.setAddress(address);

            this.userAddressRepository.saveAndFlush(userAddress);

        });
    }

}
