package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.models.UserAddress;
import br.com.sossp.apirest.models.UserAddressPK;
import br.com.sossp.apirest.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/useraddress")
public class UserAddressResource {

    @Autowired
    private UserAddressRepository repository;

    // CRUD - Start
    @GetMapping
    public List<UserAddress> getUserAddress(){
        return repository.findAll();
    }

    @GetMapping("{uaId}")
    public UserAddress getUserAddressId(@PathVariable UserAddressPK uaId){
        return repository.findById(uaId).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserAddress postUserAddress(@RequestBody UserAddress userAddress){
        return repository.save(userAddress);
    }
    /*
    @PutMapping("{uaId}")
    public UserAddress putUserAddress(@RequestBody UserAddress userAddress, @PathVariable UserAddressPK uaId){
        userAddress
        return repository.save(userAddress);
    }
    */
    @DeleteMapping("{uaId}")
    public void deleteUserAddress(@PathVariable UserAddressPK uaId){
        repository.deleteById(uaId);
    }
    // CRUD - End

}
