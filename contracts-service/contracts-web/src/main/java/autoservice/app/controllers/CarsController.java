package autoservice.app.controllers;

import autoservice.app.domain.Car;
import autoservice.app.services.CarsService;
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

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carsService.getCarById(carId));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carsService.getAllCars());
    }

    @PostMapping("{carId}/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void bookCar(@PathVariable Long carId) {
        carsService.bookCarById(carId);
    }
}
