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
@RequestMapping("api")
public class OccurrenceResource {

    @Autowired
    private OccurrenceRepository repository;

    @Autowired
    private OccurrenceService service;

    @GetMapping("user/{idUser}/occurrences")
    public List<OccurrenceDTO> getAllOccurrencesUser(@PathVariable Long idUser){
        return service.findAllOccurrencesUser(idUser);
    }

    @GetMapping("occurrences")
    public List<Occurrence> getAllOccurrences(){
        return repository.findAll();
    }

    @GetMapping("user/{idUser}/occurrence/{occurrenceId}")
    public Occurrence getOccurrenceId(@PathVariable long occurrenceId){
        return repository.findById(occurrenceId).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("user/{idUser}/occurrence")
    public void postOccurrence(@RequestBody OccurrenceDTO occurrenceDTO, @PathVariable long idUser){
        service.save(idUser, occurrenceDTO);
    }

}
