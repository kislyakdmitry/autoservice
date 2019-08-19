package autoservice.app.services;

import autoservice.data.domain.Car;

import java.util.List;

public interface CarsService {
    List<Car> findAll();
    Car getCarById(Long id);
}
