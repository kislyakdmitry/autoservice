package autoservice.app.repositories;

import autoservice.app.domain.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractsRepo extends CrudRepository<Contract, Long> {
}