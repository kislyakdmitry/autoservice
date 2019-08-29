package autoservice.cars.services;

import autoservice.cars.domain.Car;

import java.util.List;

public interface CarsService {
    List<Car> getAllCars();
    Car getCarById(Long id);
    void bookCarById(Long carId);
}
