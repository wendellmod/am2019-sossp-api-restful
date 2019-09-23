package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.models.Address;
import br.com.sossp.apirest.repository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressResource {

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Address postAddress(@RequestBody Address address){
        return repository.save(address);
    }

    @PutMapping("{addressId}")
    public Address putAddress(@RequestBody Address address, @PathVariable long addressId){
        address.setAddressId(addressId);
        return repository.save(address);
    }

    @DeleteMapping("{addressId}")
    public void deleteAddress(@PathVariable long addressId){
        repository.deleteById(addressId);
    }
    // CRUD - End

}
