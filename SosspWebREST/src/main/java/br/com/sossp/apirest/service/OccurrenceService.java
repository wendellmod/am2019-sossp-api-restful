package br.com.sossp.apirest.service;

import br.com.sossp.apirest.dto.OccurrenceDTO;
import br.com.sossp.apirest.models.Occurrence;
import br.com.sossp.apirest.models.User;
import br.com.sossp.apirest.repository.OccurrenceRepository;
import br.com.sossp.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccurrenceService {

    private final OccurrenceRepository occurrenceRepository;
    private final UserRepository userRepository;

    @Autowired
    public OccurrenceService(OccurrenceRepository occurrenceRepository, UserRepository userRepository) {
        this.occurrenceRepository = occurrenceRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<OccurrenceDTO> findAllOccurrencesUser(Long userId) {

        return userRepository.findById(userId).get()
                .getOccurrences()
                .stream()
                .map(OccurrenceDTO::new)
                .collect(Collectors.toList());

    }

    @Transactional
    public void save(Long userId, OccurrenceDTO dto){
        userRepository.findById(userId).ifPresent(user -> {
            Occurrence occurrence = dto.buildOccurrence();

            occurrence.setUser(user);

            this.occurrenceRepository.saveAndFlush(occurrence);

        });
    }
}
