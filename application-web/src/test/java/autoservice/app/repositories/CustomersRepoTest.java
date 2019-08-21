package autoservice.app.repositories;

import autoservice.app.domain.Customer;
import autoservice.app.repositories.generic.GenericCrudRepoTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomersRepoTest extends GenericCrudRepoTest<CustomersRepo, Customer> {

    @Override
    public Customer getEntity() {
        return new Customer();
    }

    @Override
    public void testUpdate() {

        String newUsername = "dima123";
        String newPass = "1234";

        Customer customer = new Customer();
        Long generatedId = super.getRepository().save(customer).getId();

        Customer savedCustomer = super.getRepository().findById(generatedId).get();
        savedCustomer.setUsername(newUsername);
        savedCustomer.setPassword(newPass);

        Customer updatedCustomer = super.getRepository().save(savedCustomer);

        assertThat(updatedCustomer).isEqualTo(savedCustomer);
    }
}
