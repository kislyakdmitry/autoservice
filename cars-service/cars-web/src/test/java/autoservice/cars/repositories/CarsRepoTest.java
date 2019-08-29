package autoservice.cars.repositories;

import autoservice.cars.TestEntityFactory;
import autoservice.cars.domain.Car;
import autoservice.cars.repositories.generic.GenericCrudRepoTest;

import java.math.BigDecimal;

public class CarsRepoTest extends GenericCrudRepoTest<CarsRepo, Car, Long> {

    private static final String TEST_CAR_NAME = "UAZ";
    private static final BigDecimal TEST_CAR_PRICE = BigDecimal.valueOf(1000);
    private static final String TEST_CAR_VIN = "vin_number";
    private static final String TEST_UPDATED_CAR_NAME = "BMW";
    private static final BigDecimal TEST_UPDATED_CAR_PRICE = BigDecimal.valueOf(1500);
    private static final String TEST_UPDATED_CAR_VIN = "vin_number_updated";

    @Override
    public Car getEntity() {
        return TestEntityFactory.getCar(TEST_CAR_NAME, TEST_CAR_PRICE, TEST_CAR_VIN);
    }

    @Override
    protected Car updateEntity(Car entity) {
        Car updatedCar = TestEntityFactory.getCar(TEST_UPDATED_CAR_NAME, TEST_UPDATED_CAR_PRICE, TEST_UPDATED_CAR_VIN);
        updatedCar.setId(entity.getId());
        return updatedCar;
    }
}
