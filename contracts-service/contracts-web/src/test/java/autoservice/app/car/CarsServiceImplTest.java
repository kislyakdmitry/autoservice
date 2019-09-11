package autoservice.app.car;

import autoservice.app.car.exceptions.CarNotFoundException;
import autoservice.app.common.TestEntityFactory;
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
public class CarsServiceImplTest {
    @Mock
    private CarRepo carsRepo;

    @InjectMocks
    private CarService carsService = new CarService(carsRepo);

    private Car testCar;

    @Before
    public void setUp() {
        testCar = TestEntityFactory.getCar("BMW", BigDecimal.valueOf(1000), "vin_number", true);
    }

    @Test
    public void testGetAllCars(){
        when(carsRepo.findAll()).thenReturn(Lists.newArrayList(testCar));
        List<Car> cars = carsService.getAllCars();
        assertThat(cars).isNotEmpty();
    }

    @Test
    public void testGetCarById(){
        when(carsRepo.findById(anyLong())).thenReturn(Optional.of(testCar));
        Car car = carsService.getCarById(1L);
        assertThat(car).isEqualTo(testCar);
    }

    @Test(expected = CarNotFoundException.class)
    public void testGetCarById_ExceptionCarNotFoundException(){
        when(carsRepo.findById(anyLong())).thenReturn(Optional.empty());
        carsService.getCarById(1L);
    }
}
