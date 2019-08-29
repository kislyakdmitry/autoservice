package autoservice.cars.repositories;

import autoservice.cars.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepo extends CrudRepository<Car, Long> {
}
