package com.autoservice.controllers;

import com.autoservice.domain.Car;
import com.autoservice.services.CarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carsService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCar(@RequestBody Car car) {
        carsService.save(car);
    }
}
