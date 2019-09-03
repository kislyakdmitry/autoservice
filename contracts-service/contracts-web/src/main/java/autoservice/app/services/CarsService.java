package autoservice.app.services;

import autoservice.app.domain.Car;

import java.util.List;

public interface CarsService {
    void save(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car getCarByVin(String vin);
    void bookCarById(Long carId);
    void updateCarList(List<Car> cars);
}
