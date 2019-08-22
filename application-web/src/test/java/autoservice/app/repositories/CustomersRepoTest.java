package autoservice.app.repositories;

import autoservice.app.domain.Customer;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import autoservice.app.TestEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomersRepoTest extends GenericCrudRepoTest<CustomersRepo, Customer, Long> {
    @Autowired
    private TestEntityFactory testEntityFactory;

    @Override
    public Customer getEntity() {
        return testEntityFactory.getCustomer();
    }

    @Override
    protected Customer updateEntity(Customer entity) {
        Customer updatedEntity = testEntityFactory.getUpdatedCustomer();
        updatedEntity.setId(entity.getId());
        return updatedEntity;
    }
}
