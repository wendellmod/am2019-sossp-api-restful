package br.com.sossp.apirest.resource;

import br.com.sossp.apirest.dto.OccurrenceDTO;
import br.com.sossp.apirest.models.Occurrence;
import br.com.sossp.apirest.repository.OccurrenceRepository;
import br.com.sossp.apirest.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/occurence")
public class OccurrenceResource {

    @Autowired
    private OccurrenceRepository repository;

    @Autowired
    private OccurrenceService service;

    // CRUD - Start
    @GetMapping
    public List<Occurrence> getOccurrence(){
        return repository.findAll();
    }

    @GetMapping("{occurrenceId}")
    public Occurrence getOccurrenceId(@PathVariable long occurrenceId){
        return repository.findById(occurrenceId).get();
    }
    /*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("user/{idUser}/post")
    public void postOccurrence(@RequestBody OccurrenceDTO dto, @PathVariable long idUser){
        service.save(idUser, dto);
    }
    */
    @PutMapping("{occurrenceId}")
    public Occurrence putOccurrence(@RequestBody Occurrence occurrence, @PathVariable long occurrenceId){
        occurrence.setOccurrenceId(occurrenceId);
        return repository.save(occurrence);
    }

    @DeleteMapping("{occurrenceId}")
    public void deleteOccurrence(@PathVariable long occurrenceId){
        repository.deleteById(occurrenceId);
    }
    // CRUD - End

}
