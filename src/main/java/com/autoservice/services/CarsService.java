package com.autoservice.services;

import com.autoservice.domain.Car;
import com.autoservice.repositories.CarsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarsService {
    private CarsRepo carsRepo;

    public CarsService(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public List<Car> findAll() {
        return carsRepo.findAll();
    }

    public Car save(Car car) {
        car.setCreated(LocalDateTime.now());
        return carsRepo.save(car);
    }
}
