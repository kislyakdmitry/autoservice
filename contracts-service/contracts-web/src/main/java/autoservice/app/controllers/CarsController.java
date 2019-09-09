package autoservice.app.controllers;

import autoservice.app.domain.Car;
import autoservice.app.dto.ScheduleDto;
import autoservice.app.services.CarsService;
import autoservice.app.services.impl.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/cars")
@Slf4j
public class CarsController {
    private CarsService carsService;
    private ScheduleService scheduleService;

    public CarsController(CarsService carsService, ScheduleService scheduleService) {
        this.carsService = carsService;
        this.scheduleService = scheduleService;
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

    @PostMapping("schedule")
    public void setCarsUpdateSchedule(@RequestBody ScheduleDto dto) {
        scheduleService.setCarUpdateSchedule(dto);
    }

    @GetMapping("schedule")
    public ResponseEntity<ScheduleDto> getSchedule() {
        return ResponseEntity.ok(scheduleService.getCarUpdateSchedule());
    }
}
