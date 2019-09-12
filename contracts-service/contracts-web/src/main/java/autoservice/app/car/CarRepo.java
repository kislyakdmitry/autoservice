package autoservice.app.car;

import autoservice.app.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    Optional<Car> findByVin(String vin);
    void deleteByAvailable(Boolean available);
    Boolean existsByVin(String vin);
}
