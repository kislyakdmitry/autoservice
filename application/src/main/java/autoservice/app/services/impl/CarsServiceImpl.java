package autoservice.app.services.impl;

import autoservice.app.exceptions.CarNotFoundException;
import autoservice.app.services.CarsService;
import autoservice.data.domain.Car;
import autoservice.data.repositories.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarsRepo carsRepo;

    public List<Car> findAll() {
        return carsRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }
}
