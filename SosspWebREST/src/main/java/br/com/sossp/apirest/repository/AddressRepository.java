package br.com.sossp.apirest.repository;

import br.com.sossp.apirest.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
