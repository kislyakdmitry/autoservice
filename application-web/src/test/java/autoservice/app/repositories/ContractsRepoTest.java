package autoservice.app.repositories;

import autoservice.app.domain.Contract;
import autoservice.app.repositories.generic.GenericCrudRepoTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class ContractsRepoTest extends GenericCrudRepoTest<ContractsRepo, Contract> {

    @Override
    public Contract getEntity() {
        return new Contract();
    }

    @Override
    public void testUpdate() {

        LocalDateTime newStartTime = LocalDateTime.now();
        LocalDateTime newEndTime = LocalDateTime.now();

        Contract contract = new Contract();
        Long generatedId = super.getRepository().save(contract).getId();

        Contract savedContract = super.getRepository().findById(generatedId).get();
        savedContract.setStartTime(newStartTime);
        savedContract.setEndTime(newEndTime);

        Contract updatedContract = super.getRepository().save(savedContract);

        assertThat(updatedContract).isEqualTo(savedContract);
    }
}
