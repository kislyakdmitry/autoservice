package autoservice.app.services;

import autoservice.app.domain.Car;

import java.util.List;

public interface CarsService {
    List<Car> findAll();
    Car getCarById(Long id);
}
