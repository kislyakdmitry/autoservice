package autoservice.app.repositories;

import autoservice.app.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepo extends CrudRepository<Car, Long> {
}
