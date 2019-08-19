package autoservice.data.repositories;

import autoservice.data.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
}
