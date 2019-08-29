package autoservice.cars.services.impl;

import autoservice.cars.domain.Car;
import autoservice.cars.exceptions.CarNotFoundException;
import autoservice.cars.repositories.CarsRepo;
import autoservice.cars.services.CarsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepo carsRepo;

    public CarsServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public List<Car> getAllCars() {
        return (List<Car>) carsRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }
}
