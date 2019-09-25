package br.com.sossp.apirest.repository;

import br.com.sossp.apirest.models.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

}
