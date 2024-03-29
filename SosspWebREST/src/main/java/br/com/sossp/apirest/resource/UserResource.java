package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.models.User;
import br.com.sossp.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public User getUserIdByEmail(@RequestParam String userEmail) {
        return repository.findByEmail(userEmail);
    }

    @GetMapping("{userId}")
    public User getUserId(@PathVariable Long userId){
        return repository.findById(userId).get();
    }

    // POST USER
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void postUser(@RequestBody User user){
        this.repository.save(user);
    }

}
