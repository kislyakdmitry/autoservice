package autoservice.app.repositories;

import autoservice.app.repositories.generic.GenericCrudRepoTest;
import autoservice.app.domain.Car;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsRepoTest extends GenericCrudRepoTest<CarsRepo, Car> {
    @Override
    public Car getEntity() {
        return new Car();
    }

    @Override
    public void testUpdate() {

        String newName = "Name";
        BigDecimal newPrice = BigDecimal.valueOf(100);
        boolean newOrderedState = false;

        Car car = new Car();
        Long generatedId = super.getRepository().save(car).getId();

        Car savedCar = super.getRepository().findById(generatedId).get();
        savedCar.setName(newName);
        savedCar.setPrice(newPrice);
        savedCar.setOrdered(newOrderedState);

        Car updatedCar = super.getRepository().save(savedCar);

        assertThat(updatedCar).isEqualTo(savedCar);
    }
}
