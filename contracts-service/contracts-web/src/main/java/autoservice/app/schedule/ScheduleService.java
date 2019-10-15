package autoservice.app.schedule;

import autoservice.app.car.Car;
import autoservice.app.car.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;


@Slf4j
@Component
public class ScheduleService {
    private TaskScheduler taskScheduler;
    private CarService carService;
    private ScheduleMapper scheduleMapper;

    private ScheduledFuture scheduledFuture;
    private ScheduleDto currentSchedule;

    @Value("${cars-service.url}")
    private String CARS_API_URL;

    public ScheduleService(TaskScheduler taskScheduler, CarService carService, ScheduleMapper scheduleMapper) {
        this.taskScheduler = taskScheduler;
        this.carService = carService;
        this.scheduleMapper = scheduleMapper;
    }

    public ScheduleDto getCarUpdateSchedule() {
        return currentSchedule;
    }

    public void setCarUpdateSchedule(ScheduleDto dto) {
        CronTrigger cronTrigger = scheduleMapper.toCron(dto);
        currentSchedule = dto;
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = taskScheduler.schedule(() -> {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Car>> response
                    = restTemplate.exchange(CARS_API_URL + "cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
            });
            List<Car> cars = response.getBody();
            log.info("Retrieved " + response.getBody().size() + " cars");
            carService.updateCarList(cars);
        },
                cronTrigger);
    }
}
