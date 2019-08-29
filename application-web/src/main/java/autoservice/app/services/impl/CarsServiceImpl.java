package autoservice.app.services.impl;

import autoservice.app.domain.Car;
import autoservice.app.exceptions.CarNotFoundException;
import autoservice.app.repositories.CarsRepo;
import autoservice.app.services.CarsService;
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
