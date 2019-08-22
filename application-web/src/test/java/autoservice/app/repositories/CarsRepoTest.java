package autoservice.app.repositories;

import autoservice.app.domain.Car;
import autoservice.app.repositories.generic.GenericCrudRepoTest;
import autoservice.app.TestEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CarsRepoTest extends GenericCrudRepoTest<CarsRepo, Car, Long> {
    @Autowired
    private TestEntityFactory testEntityFactory;

    @Override
    public Car getEntity() {
        return testEntityFactory.getCar();
    }

    @Override
    protected Car updateEntity(Car entity) {
        Car updatedCar = testEntityFactory.getUpdatedCar();
        updatedCar.setId(entity.getId());
        return updatedCar;
    }
}
