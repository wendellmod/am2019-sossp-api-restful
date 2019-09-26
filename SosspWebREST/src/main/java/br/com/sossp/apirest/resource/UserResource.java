package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.dto.OccurrenceDTO;
import br.com.sossp.apirest.dto.UserDTO;
import br.com.sossp.apirest.models.User;
import br.com.sossp.apirest.repository.UserRepository;
import br.com.sossp.apirest.service.OccurrenceService;
import br.com.sossp.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OccurrenceService occurrenceService;

    // CRUD - Start
    @GetMapping
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("{userId}")
    public User getUserId(@PathVariable long userId){
        return userRepository.findById(userId).get();
    }

    // POST USER
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void postUser(@RequestBody User user){
        this.userRepository.save(user);
    }

    // POST USER + ADDRESS
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("complete")
    public void postUserComplete(@RequestBody UserDTO userDTO){
        this.userService.save(userDTO);
    }

    // POST OCCURRENCE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{idUser}/occurrence")
    public void postOccurrence(@RequestBody OccurrenceDTO dto, @PathVariable long idUser){
        this.occurrenceService.save(idUser, dto);
    }

    @PutMapping("{userId}")
    public User putUser(@RequestBody User user, @PathVariable long userId){
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable long userId){
        userRepository.deleteById(userId);
    }
    // CRUD - End

}
