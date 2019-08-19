package com.autoservice.repositories;

import com.autoservice.domain.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarsRepoTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CarsRepo carsRepo;

    @Before
    public void init() {
        Car car = new Car();
        car.setId(1L);
        car.setName("AudiTest");
        carsRepo.save(car);
    }

    @Test
    public void testFindCarById() {
        Optional<Car> car2 = carsRepo.findById(1L);

        assertThat(car2.get().getName()).isEqualTo("AudiTest");
    }

    @Test
    public void testFindAllCars() {
        List<Car> cars = carsRepo.findAll();
        assertThat(cars).isNotEmpty();
    }

}
