package com.autoservice.services;

import com.autoservice.domain.Car;

import java.util.List;

public interface CarsService {
    List<Car> findAll();
    Car getCarById(Long id);
}
