package autoservice.app.customer;

import autoservice.app.common.TestEntityFactory;
import autoservice.app.common.GenericCrudRepoTest;

public class CustomersRepoTest extends GenericCrudRepoTest<CustomerRepo, Customer, Long> {

    private static final String TEST_FIRST_NAME = "Jon";
    private static final String TEST_LAST_NAME = "Snow";
    private static final String TEST_UPDATED_FIRST_NAME = "Ned";
    private static final String TEST_UPDATED_LAST_NAME = "Stark";

    @Override
    public Customer getEntity() {
        return TestEntityFactory.getCustomer(TEST_FIRST_NAME, TEST_LAST_NAME);
    }

    @Override
    protected Customer updateEntity(Customer entity) {
        Customer updatedEntity = TestEntityFactory.getCustomer(TEST_UPDATED_FIRST_NAME, TEST_UPDATED_LAST_NAME);
        updatedEntity.setId(entity.getId());
        return updatedEntity;
    }
}
