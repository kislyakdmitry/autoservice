package com.autoservice.repositories;

import com.autoservice.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepo extends CrudRepository<Car, Long> {
    List<Car> findAll();
    Car save(Car car);
}
