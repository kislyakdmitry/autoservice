package autoservice.app.controllers;

import autoservice.app.TestEntityFactory;
import autoservice.app.domain.Contract;
import autoservice.app.domain.Customer;
import autoservice.app.domain.Employee;
import autoservice.app.services.ContractsService;
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
import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContractsController.class)
public class ContractsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContractsService contractsService;

    private static final String API_URI = "/api/contracts";

    private Contract testContract;
    private static final Long TEST_CONTRACT_ID = 1L;

    private static final LocalDateTime TEST_START_TIME = LocalDateTime.now();
    private static final LocalDateTime TEST_END_TIME = LocalDateTime.now();
    private static final Customer TEST_CUSTOMER = TestEntityFactory.getCustomer("Jon", "Snow");
    private static final Employee TEST_EMPLOYEE = TestEntityFactory.getEmployee("epm1", "pass", "Daenerys", "Targaryen");
    private static final Car TEST_CAR = TestEntityFactory.getCar("UAZ", BigDecimal.valueOf(1000));

    @Before
    public void setUp() {
        testContract = TestEntityFactory.getContract(
                TEST_START_TIME,
                TEST_END_TIME,
                TEST_CUSTOMER,
                TEST_EMPLOYEE,
                Collections.singletonList(TEST_CAR));
        testContract.setId(TEST_CONTRACT_ID);
    }

    @Test
    public void testGetAllCars() throws Exception {
        when(contractsService.getAllContracts()).thenReturn(Lists.newArrayList(testContract));
        this.mockMvc.perform(get(API_URI).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    public void testGetCarById() throws Exception {
        when(contractsService.getContractById(TEST_CONTRACT_ID)).thenReturn(testContract);
        this.mockMvc.perform(get(API_URI + "/" + TEST_CONTRACT_ID).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testContract.getId().intValue())))
                .andExpect(jsonPath("$.employee").exists())
                .andExpect(jsonPath("$.employee.firstName", is(TEST_EMPLOYEE.getFirstName())))
                .andExpect(jsonPath("$.employee.lastName", is(TEST_EMPLOYEE.getLastName())));
    }
}
