package com.autoservice.services;

import com.autoservice.domain.Car;
import com.autoservice.repositories.CarsRepo;
import com.autoservice.services.impl.CarsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CarsServiceTest {
    @Mock
    private CarsRepo carsRepo;

    @InjectMocks
    private CarsServiceImpl carsService;

    @Before
    public void setUp() {
        Car car = new Car();
        car.setId(1L);
        car.setName("AudiTest");
        when(carsRepo.findById(car.getId()))
                .thenReturn(Optional.of(car));
    }

    @Test
    public void testFindUserById() {
        Long id = 1L;
        String carName = "AudiTest";
        Car found = carsService.getCarById(id);
        assertThat(found.getId())
                .isEqualTo(id);
        assertThat(found.getName())
                .isEqualTo(carName);
    }
}
