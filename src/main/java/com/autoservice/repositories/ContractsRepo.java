package com.autoservice.repositories;

import com.autoservice.domain.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractsRepo extends CrudRepository<Contract, Long> {
    List<Contract> findAll();
    Optional<Contract> findById(Long id);
    Contract save(Contract contract);
}
