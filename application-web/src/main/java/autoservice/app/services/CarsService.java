package autoservice.app.services;

import autoservice.app.domain.Car;

import java.util.List;

public interface CarsService {
    List<Car> getAllCars();
    Car getCarById(Long id);
}
