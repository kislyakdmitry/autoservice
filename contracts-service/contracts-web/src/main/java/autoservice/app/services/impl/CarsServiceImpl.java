package autoservice.app.services.impl;

import autoservice.app.domain.Car;
import autoservice.app.exceptions.CarNotFoundException;
import autoservice.app.repositories.CarsRepo;
import autoservice.app.services.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarsServiceImpl implements CarsService {

    private CarsRepo carsRepo;

    public CarsServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = (List<Car>) carsRepo.findAll();
        return cars.stream().filter(Car::getAvailable).collect(Collectors.toList());
    }

    @Override
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

    @Override
    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }

    @Override
    public void bookCarById(Long carId) {
        Car car = getCarById(carId);
        car.setAvailable(false);
        carsRepo.save(car);
    }
}
