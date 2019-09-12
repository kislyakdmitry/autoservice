package autoservice.cars.car;

import autoservice.cars.common.TestEntityFactory;
import autoservice.cars.car.exceptions.CarNotFoundException;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CarServiceTest {
    @Mock
    private CarRepo carRepo;

    @InjectMocks
    private CarService carService = new CarService(carRepo);

    private Car testCar;

    @Before
    public void setUp() {
        testCar = TestEntityFactory.getCar("BMW", BigDecimal.valueOf(1000), "vin_number", true);
    }

    @Test
    public void testGetAllCars(){
        when(carRepo.findAll()).thenReturn(Lists.newArrayList(testCar));
        List<Car> cars = carService.getAllCars();
        assertThat(cars).isNotEmpty();
    }

    @Test
    public void testGetCarById(){
        when(carRepo.findById(anyLong())).thenReturn(Optional.of(testCar));
        Car car = carService.getCarById(1L);
        assertThat(car).isEqualTo(testCar);
    }

    @Test(expected = CarNotFoundException.class)
    public void testGetCarById_ExceptionCarNotFoundException(){
        when(carRepo.findById(anyLong())).thenReturn(Optional.empty());
        carService.getCarById(1L);
    }
}
