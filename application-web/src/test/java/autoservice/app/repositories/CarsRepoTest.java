package autoservice.app.repositories;

import autoservice.app.domain.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CarsRepoTest {
    @Autowired
    private CarsRepo carsRepo;

    private Long generatedCarId;
    private final String TEST_CAR_NAME = "Test car";
    private final BigDecimal TEST_CAR_PRICE = BigDecimal.valueOf(1000);

    @Before
    public void setUp() {
        Car testCar = new Car();
        testCar.setName(TEST_CAR_NAME);
        testCar.setPrice(TEST_CAR_PRICE);
        generatedCarId = carsRepo.save(testCar).getId();
    }

    @Test
    public void testRead() {
        List<Car> cars =(List<Car>) carsRepo.findAll();
        assertThat(cars).isNotEmpty();

        Car car = carsRepo.findById(generatedCarId).get();
        assertThat(car.getName()).isEqualTo(TEST_CAR_NAME);
        assertThat(car.getPrice()).isEqualTo(TEST_CAR_PRICE);
    }

    @Test
    public void testUpdate() {
        String newName = "New name";
        Car car = carsRepo.findById(generatedCarId).get();
        car.setName(newName);
        carsRepo.save(car);
        Car updatedCar = carsRepo.findById(generatedCarId).get();
        assertThat(updatedCar.getName()).isEqualTo(newName);
        assertThat(updatedCar.getId()).isEqualTo(generatedCarId);
    }

    @Test
    public void testDelete() {
        carsRepo.deleteById(generatedCarId);
        Optional<Car> newCar = carsRepo.findById(generatedCarId);
        assertThat(newCar.isPresent()).isFalse();
    }
}
