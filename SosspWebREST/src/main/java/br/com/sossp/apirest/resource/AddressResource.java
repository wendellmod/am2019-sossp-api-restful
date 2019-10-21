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
@RequestMapping("api")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping("address")
    public AddressDTO getAddressById(@RequestParam Long idUser, @RequestParam Long zipcode, @RequestParam Integer numberAddress) {
        return service.findByPk(idUser, zipcode, numberAddress);
    }

    @GetMapping("user/{idUser}/addresses")
    public List<AddressDTO> getAddressesByUser(@PathVariable Long idUser) {
        return service.findAddressesByUser(idUser);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("user/{idUser}/address")
    public void postAddress(@RequestBody AddressDTO addressDTO, @PathVariable Long idUser){
        service.save(idUser, addressDTO);
    }

}
