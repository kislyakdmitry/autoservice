package autoservice.app.car;

import autoservice.app.car.exceptions.CarNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarService {

    private CarRepo carsRepo;

    public CarService(CarRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public List<Car> getAllCars() {
        List<Car> cars = (List<Car>) carsRepo.findAll();
        return cars.stream().filter(Car::getAvailable).collect(Collectors.toList());
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateCarList(List<Car> cars) {
        carsRepo.deleteByAvailable(true);
        for(Car car: cars) {
            if (!carsRepo.existsByVin(car.getVin())) {
                car.setId(null);
                carsRepo.save(car);
                log.info("Car vin " + car.getVin() + " added");
            }
        }
    }

    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }

    public void save(Car car) {
        carsRepo.save(car);
    }

    public Car getCarByVin(String vin) {
        return carsRepo.findByVin(vin).orElseThrow(() -> new CarNotFoundException("Car " + vin + " not found"));
    }

    public void bookCarById(Long carId) {
        Car car = getCarById(carId);
        car.setAvailable(false);
        carsRepo.save(car);
    }
}
