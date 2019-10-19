package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.dto.AddressDTO;
import br.com.sossp.apirest.models.Address;
import br.com.sossp.apirest.repository.AddressRepository;
import br.com.sossp.apirest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class AddressResource {

    @Autowired
    private AddressService service;

    @Autowired
    private AddressRepository repository;

    @GetMapping("addresses")
    public List<Address> getAddress(){
        return repository.findAll();
    }

    @GetMapping("user/{userId}/addresses")
    public List<AddressDTO> findAddressesByUser(@PathVariable Long userId) {
        return service.findAddressesByUser(userId);
    }

    @GetMapping("{addressId}")
    public Address getAddressId(@PathVariable Long addressId){
        return repository.findById(addressId).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void postAddress(@RequestBody AddressDTO addressDTO, @PathVariable Long idUser){
        service.save(idUser, addressDTO);
    }

}
