package autoservice.app.common;

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
public abstract class GenericCrudRepoTest<R extends CrudRepository<E, ID>, E extends GenericEntity<ID>, ID> {

    @Autowired
    private R repository;

    private ID generatedId;

    protected abstract E getEntity();
    protected abstract E updateEntity(E entity);

    public R getRepository() {
        return repository;
    }

    private ID saveEntity(E entity) {
        return repository.save(entity).getId();
    }

    @Before
    public void setUp(){
        generatedId = saveEntity(getEntity());
    }

    @Test
    public void testFindAll() {
        List<E> entities = (List<E>) repository.findAll();
        assertThat(entities).isNotEmpty();
    }

    @Test
    public void testFindById() {
        Optional<E> foundEntity = repository.findById(generatedId);
        assertThat(foundEntity.isPresent()).isTrue();
    }

    @Test
    public void testUpdate() {
        E entity = getEntity();
        entity = updateEntity(entity);
        E updated = repository.save(entity);
        assertThat(updated).isEqualTo(entity);
    }

    @Test
    public void testDelete() {
        repository.deleteById(generatedId);
        Optional<E> deletedContract = repository.findById(generatedId);
        assertThat(deletedContract.isPresent()).isFalse();
    }
}
