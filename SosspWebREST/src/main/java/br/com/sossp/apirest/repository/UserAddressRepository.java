package br.com.sossp.apirest.repository;

import br.com.sossp.apirest.models.UserAddress;
import br.com.sossp.apirest.models.UserAddressPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, UserAddressPK> {
}
