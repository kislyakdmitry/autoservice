package autoservice.app.repositories;

import autoservice.app.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CustomersRepoTest {
    @Autowired
    private CustomersRepo customersRepo;

    private Long generatedCustomerId;
    private final String TEST_FIRST_NAME = "Jon";
    private final String TEST_LAST_NAME = "Snow";
    private final String TEST_USERNAME = "ValarMorghulis";

    @Before
    public void setUp(){
        Customer customer = new Customer();
        customer.setFirstName(TEST_FIRST_NAME);
        customer.setLastName(TEST_LAST_NAME);
        customer.setUsername(TEST_USERNAME);
        generatedCustomerId = customersRepo.save(customer).getId();
    }

    @Test
    public void testFindByUsername() {
        Customer customer = customersRepo.findByUsername(TEST_USERNAME).get();
        assertThat(customer.getFirstName()).isEqualTo(TEST_FIRST_NAME);
        assertThat(customer.getLastName()).isEqualTo(TEST_LAST_NAME);
    }

    @Test
    public void testRead() {
        List<Customer> customers = customersRepo.findAll();
        assertThat(customers).isNotEmpty();

        Customer customer = customersRepo.findById(generatedCustomerId).get();
        assertThat(customer.getFirstName()).isEqualTo(TEST_FIRST_NAME);
        assertThat(customer.getLastName()).isEqualTo(TEST_LAST_NAME);
    }

    @Test
    public void testUpdate() {
        String newLastName = "Stark";
        Customer customer = customersRepo.findById(generatedCustomerId).get();
        customer.setLastName(newLastName);
        customersRepo.save(customer);
        Customer updatedCustomer = customersRepo.findById(generatedCustomerId).get();
        assertThat(updatedCustomer.getLastName()).isEqualTo(newLastName);
    }

    @Test
    public void testDelete() {
        customersRepo.deleteById(generatedCustomerId);
        Optional<Customer> newContract = customersRepo.findById(generatedCustomerId);
        assertThat(newContract.isPresent()).isFalse();
    }
}
