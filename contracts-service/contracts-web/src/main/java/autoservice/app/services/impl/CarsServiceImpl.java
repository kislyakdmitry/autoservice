package autoservice.app.services.impl;

import autoservice.app.domain.Car;
import autoservice.app.exceptions.CarNotFoundException;
import autoservice.app.repositories.CarsRepo;
import autoservice.app.services.CarsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public void updateCarList(List<Car> cars) {
        List<Car> updatedCars = new ArrayList<>();
        List<Car> currentCars = getAllCars();
        currentCars.stream().filter(car -> !car.getAvailable()).forEach(updatedCars::add);
        updatedCars.addAll(cars);
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
