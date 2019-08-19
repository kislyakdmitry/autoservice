package autoservice.application.services.impl;

import autoservice.application.exceptions.CarNotFoundException;
import autoservice.application.services.CarsService;
import autoservice.data.domain.Car;
import autoservice.data.repositories.CarsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    private CarsRepo carsRepo;

    public CarsServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public List<Car> findAll() {
        return carsRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }
}
