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
    private AddressService addressService;

    @Autowired
    private AddressRepository repository;

    // CRUD - Start
    @GetMapping
    public List<Address> getAddress(){
        return repository.findAll();
    }

    @GetMapping("{addressId}")
    public Address getAddressId(@PathVariable long addressId){
        return repository.findById(addressId).get();
    }

    @PostMapping("user/{idUser}/address")
    public void postAddress(@RequestBody AddressDTO dto, @PathVariable long idUser){
        addressService.save(idUser, dto);
    }

    @PutMapping("{addressId}")
    public Address putAddress(@RequestBody Address address, @PathVariable long addressId){
        address.setZipcode(addressId);
        return repository.save(address);
    }

    @DeleteMapping("{addressId}")
    public void deleteAddress(@PathVariable long addressId){
        repository.deleteById(addressId);
    }
    // CRUD - End

}
