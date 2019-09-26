package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.dto.UserDTO;
import br.com.sossp.apirest.models.User;
import br.com.sossp.apirest.repository.UserRepository;
import br.com.sossp.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    // CRUD - Start
    @GetMapping
    public List<User> getUser(){
        return repository.findAll();
    }

    @GetMapping("{userId}")
    public User getUserId(@PathVariable long userId){
        return repository.findById(userId).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User postUser(@RequestBody User user){
        return repository.save(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("complete")
    public User postUserComplete(@RequestBody UserDTO user){
        return service.save(user);
    }

    @PutMapping("{userId}")
    public User putUser(@RequestBody User user, @PathVariable long userId){
        user.setUserId(userId);
        return repository.save(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable long userId){
        repository.deleteById(userId);
    }
    // CRUD - End

}
