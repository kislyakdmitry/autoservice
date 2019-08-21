package autoservice.app.repositories.generic;

import autoservice.app.domain.GenericEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public abstract class GenericCrudRepoTest<R extends CrudRepository<E, Long>, E extends GenericEntity> {

    @Autowired
    private R repository;

    private E entity = getEntity();
    private Long generatedId;

    public abstract E getEntity();

    public R getRepository() {
        return repository;
    }

    @Before
    public void setUp(){
        E savedEntity = repository.save(entity);
        generatedId = savedEntity.getId();
    }

    @Test
    public void testFindAll() {
        List<E> entities = (List<E>) repository.findAll();
        assertThat(entities).isNotEmpty();
    }

    @Test
    public void testFindById() {
        Optional<E> findEntity = repository.findById(generatedId);
        assertThat(findEntity.isPresent()).isTrue();
    }

    @Test
    public abstract void testUpdate();

    @Test
    public void testDelete() {
        repository.deleteById(generatedId);
        Optional<E> newContract = repository.findById(generatedId);
        assertThat(newContract.isPresent()).isFalse();
    }
}
