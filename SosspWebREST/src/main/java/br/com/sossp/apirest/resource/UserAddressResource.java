package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.repository.UserAddressRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("useraddress")
public class UserAddressResource {

    private UserAddressRepository repository;

    // CRUD - Start


    // CRUD - End

}
