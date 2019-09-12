package autoservice.cars.car;

import autoservice.cars.common.TestEntityFactory;
import autoservice.cars.common.GenericCrudRepoTest;

import java.math.BigDecimal;

public class CarRepoTest extends GenericCrudRepoTest<CarRepo, Car, Long> {

    private static final String TEST_CAR_NAME = "UAZ";
    private static final BigDecimal TEST_CAR_PRICE = BigDecimal.valueOf(1000);
    private static final String TEST_CAR_VIN = "vin_number";
    private static final String TEST_UPDATED_CAR_NAME = "BMW";
    private static final BigDecimal TEST_UPDATED_CAR_PRICE = BigDecimal.valueOf(1500);
    private static final String TEST_UPDATED_CAR_VIN = "vin_number_updated";
    private static final Boolean TEST_AVAILABLE = true;
    private static final Boolean TEST_UPDATED_AVAILABLE = false;

    @Override
    public Car getEntity() {
        return TestEntityFactory.getCar(TEST_CAR_NAME, TEST_CAR_PRICE, TEST_CAR_VIN, TEST_AVAILABLE);
    }

    @Override
    protected Car updateEntity(Car entity) {
        Car updatedCar = TestEntityFactory.getCar(TEST_UPDATED_CAR_NAME, TEST_UPDATED_CAR_PRICE, TEST_UPDATED_CAR_VIN, TEST_UPDATED_AVAILABLE);
        updatedCar.setId(entity.getId());
        return updatedCar;
    }
}
