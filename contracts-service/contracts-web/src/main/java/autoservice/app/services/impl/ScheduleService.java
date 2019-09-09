package autoservice.app.services.impl;

import autoservice.app.domain.Car;
import autoservice.app.services.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;


@Slf4j
@Component
public class ScheduleService {
    private TaskScheduler taskScheduler;
    private CarsService carsService;

    private ScheduledFuture scheduledFuture;

    @Value("${cars-service.url}")
    private String CARS_API_URL;

    public ScheduleService(TaskScheduler taskScheduler, CarsService carsService) {
        this.taskScheduler = taskScheduler;
        this.carsService = carsService;
    }

    public void setCarUpdatePeriod() {
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = taskScheduler.scheduleAtFixedRate(() -> {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Car>> response
                    = restTemplate.exchange(CARS_API_URL + "cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
            });
            List<Car> cars = response.getBody();
            log.info("Retrieved " + response.getBody().size() + " cars");
            carsService.updateCarList(cars);
        },
                10000);
    }
}
