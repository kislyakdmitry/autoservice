package autoservice.app.repositories;

import autoservice.app.domain.Contract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ContractsRepoTest {
    @Autowired
    private ContractsRepo contractsRepo;

    private final LocalDateTime TEST_START_TIME = LocalDateTime.of(1995,3,21,11,45);
    private final LocalDateTime TEST_END_TIME = LocalDateTime.of(1995,3,31,11,45);

    private Long generatedContractId;

    @Before
    public void setUp(){
        Contract contract = new Contract();
        contract.setStartTime(TEST_START_TIME);
        contract.setEndTime(TEST_END_TIME);
        generatedContractId = contractsRepo.save(contract).getId();
    }

    @Test
    public void testRead() {
        List<Contract> contracts = (List<Contract>) contractsRepo.findAll();
        assertThat(contracts).isNotEmpty();

        Contract contract = contractsRepo.findById(generatedContractId).get();
        assertThat(contract.getStartTime()).isEqualTo(TEST_START_TIME);
        assertThat(contract.getEndTime()).isEqualTo(TEST_END_TIME);
    }

    @Test
    public void testUpdate() {
        LocalDateTime newEndTime = LocalDateTime.now();
        Contract contract = contractsRepo.findById(generatedContractId).get();
        contract.setEndTime(newEndTime);
        contractsRepo.save(contract);
        Contract updatedContract = contractsRepo.findById(generatedContractId).get();
        assertThat(updatedContract.getEndTime()).isEqualTo(newEndTime);
    }

    @Test
    public void testDelete() {
        contractsRepo.deleteById(generatedContractId);
        Optional<Contract> newContract = contractsRepo.findById(generatedContractId);
        assertThat(newContract.isPresent()).isFalse();
    }
}
