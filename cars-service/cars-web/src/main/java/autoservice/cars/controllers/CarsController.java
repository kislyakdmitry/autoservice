package autoservice.cars.controllers;

import autoservice.cars.services.CarsService;
import autoservice.cars.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carsService.getCarById(carId));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carsService.getAllCars());
    }

    @PutMapping("{carId}/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void bookCar(@PathVariable Long carId) {
        carsService.bookCarById(carId);
    }
}