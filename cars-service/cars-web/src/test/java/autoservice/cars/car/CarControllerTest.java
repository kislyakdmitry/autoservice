package autoservice.cars.car;

import autoservice.cars.common.TestEntityFactory;
import autoservice.cars.car.exceptions.CarNotFoundException;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    private static final String API_URI = "/api/cars";

    private Car testCar;
    private static final Long TEST_CAR_ID = 1L;

    @Before
    public void setUp() {
        testCar = TestEntityFactory.getCar("BMW", BigDecimal.valueOf(1000.01), "vin_number", true);
        testCar.setId(TEST_CAR_ID);
    }

    @Test
    public void testGetAllCars() throws Exception {
        when(carService.getAllCars()).thenReturn(Lists.newArrayList(testCar));
        this.mockMvc.perform(get(API_URI).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id", is(testCar.getId().intValue())));
    }

    @Test
    public void testGetCarById() throws Exception {
        when(carService.getCarById(TEST_CAR_ID)).thenReturn(testCar);
        this.mockMvc.perform(get(API_URI + "/" + TEST_CAR_ID).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id",is(testCar.getId().intValue())))
                .andExpect(jsonPath("$.name", is(testCar.getName())))
                .andExpect(jsonPath("$.price", is(testCar.getPrice().doubleValue())));
    }

    @Test
    public void testGetCarById_NotFound() throws Exception {
        when(carService.getCarById(TEST_CAR_ID)).thenThrow(CarNotFoundException.class);
        this.mockMvc.perform(get(API_URI + "/" + TEST_CAR_ID).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
