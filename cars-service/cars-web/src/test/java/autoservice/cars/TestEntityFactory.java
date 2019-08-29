package autoservice.cars;

import autoservice.cars.domain.Car;

import java.math.BigDecimal;

public class TestEntityFactory {

    public static Car getCar(String name, BigDecimal price, String vin) {
        Car car = new Car();
        car.setName(name);
        car.setPrice(price);
        car.setVin(vin);
        return car;
    }
}
