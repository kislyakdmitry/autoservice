package autoservice.app.repositories;

import autoservice.app.domain.Car;
import autoservice.app.repositories.generic.GenericCrudRepoTest;

import java.math.BigDecimal;

public class CarsRepoTest extends GenericCrudRepoTest<CarsRepo, Car, Long> {

    private static final String NEW_NAME = "Name";
    private static final BigDecimal NEW_PRICE = BigDecimal.valueOf(100);
    private static final boolean NEW_ORDERED_STATE = false;

    @Override
    public Car getEntity() {
        return new Car();
    }

    @Override
    protected Car updateEntity(Car entity) {
        entity.setName(NEW_NAME);
        entity.setPrice(NEW_PRICE);
        entity.setOrdered(NEW_ORDERED_STATE);
        return entity;
    }
}
