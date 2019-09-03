package autoservice.app.schedule;

import autoservice.app.domain.Car;
import autoservice.app.services.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class ScheduleTasks {
    @Value("${cars-service.url}")
    private String CARS_API_URL;

    private CarsService carsService;

    public ScheduleTasks(CarsService carsService) {
        this.carsService = carsService;
    }

    @Scheduled(fixedRate = 100000)
    public void retrieveAvailableCars() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Car>> response
                = restTemplate.exchange(CARS_API_URL + "/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
        });
        List<Car> cars = response.getBody();
        log.info("Retrieved " + response.getBody().size() + " cars");
        carsService.updateCarList(cars);
    }
}
