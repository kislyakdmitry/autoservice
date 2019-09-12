package autoservice.cars.car;

import autoservice.cars.car.exceptions.CarNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepo carsRepo;

    public CarService(CarRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public List<Car> getAllCars() {
        List<Car> cars = (List<Car>) carsRepo.findAll();
        return cars.stream().filter(Car::getAvailable).collect(Collectors.toList());
    }

    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }

    public void bookCarById(Long carId) {
        Car car = getCarById(carId);
        car.setAvailable(false);
        carsRepo.save(car);
    }
}
