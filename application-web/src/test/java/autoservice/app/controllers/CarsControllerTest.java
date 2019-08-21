package autoservice.app.controllers;

import autoservice.app.domain.Car;
import autoservice.app.services.CarsService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarsController.class)
public class CarsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarsService carsService;

    private Car testCar;

    @Before
    public void setUp() {
        testCar = new Car();
        testCar.setName("testCar");
        testCar.setPrice(BigDecimal.valueOf(100));
        testCar.setOrdered(true);
    }

    @Test
    public void testGetCar() throws Exception {
        when(carsService.getAllCars()).thenReturn(Lists.newArrayList(testCar));

        this.mockMvc.perform(get("/api/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
