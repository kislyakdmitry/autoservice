package autoservice.app.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepo extends CrudRepository<Contract, Long> {
}
