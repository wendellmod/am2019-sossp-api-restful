package br.com.sossp.apirest.repository;

import br.com.sossp.apirest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
