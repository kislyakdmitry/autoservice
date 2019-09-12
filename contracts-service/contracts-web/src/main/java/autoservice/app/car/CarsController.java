package autoservice.app.car;

import autoservice.app.schedule.ScheduleDto;
import autoservice.app.schedule.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@Slf4j
public class CarsController {
    private CarService carsService;
    private ScheduleService scheduleService;

    public CarsController(CarService carsService, ScheduleService scheduleService) {
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
