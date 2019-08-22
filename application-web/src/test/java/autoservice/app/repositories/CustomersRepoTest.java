package autoservice.app.repositories;

import autoservice.app.domain.Customer;
import autoservice.app.repositories.generic.GenericCrudRepoTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomersRepoTest extends GenericCrudRepoTest<CustomersRepo, Customer, Long> {

    private static final String NEW_USERNAME = "dima123";
    private static final String NEW_PASSWORD = "1234";


    @Override
    public Customer getEntity() {
        return new Customer();
    }

    @Override
    protected Customer updateEntity(Customer entity) {
        return null;
    }
}
