package com.autoservice.services.impl;

import com.autoservice.domain.Car;
import com.autoservice.exceptions.CarNotFoundException;
import com.autoservice.repositories.CarsRepo;
import com.autoservice.services.CarsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    private CarsRepo carsRepo;

    public CarsServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public CarsServiceImpl() {
    }

    public List<Car> findAll() {
        return carsRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }
}
