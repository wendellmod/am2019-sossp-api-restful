package br.com.sossp.apirest.service;

import br.com.sossp.apirest.dto.UserDTO;
import br.com.sossp.apirest.models.User;
import br.com.sossp.apirest.models.UserAddress;
import br.com.sossp.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // POST UserComplete
    @Transactional
    public void save(UserDTO userDto) {
        User user = userDto.buildUser();

        if(CollectionUtils.isEmpty(userDto.getUserAddresses())) {
            userDto.setUserAddresses(new ArrayList<>()); // -- user to userDto
            userDto.getUserAddresses().forEach(addressDto -> { // --
                UserAddress userAddress = addressDto.buildUserAddress();
                userAddress.setUser(user);
                userAddress.setAddress(addressDto.buildAddress());

                user.getUserAddresses().add(userAddress);
            });
        }

        this.userRepository.saveAndFlush(user);

    }

}
