package autoservice.app.repositories;

import autoservice.app.domain.Contract;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import autoservice.app.TestEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class ContractsRepoTest extends GenericCrudRepoTest<ContractsRepo, Contract, Long> {
    @Autowired
    private TestEntityFactory testEntityFactory;

    @Override
    public Contract getEntity() {
        return testEntityFactory.getContract();
    }

    @Override
    protected Contract updateEntity(Contract entity) {
        Contract updatedContract = testEntityFactory.getUpdatedContract();
        updatedContract.setId(entity.getId());
        return updatedContract;
    }
}
