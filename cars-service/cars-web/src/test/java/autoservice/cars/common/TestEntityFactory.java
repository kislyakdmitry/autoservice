package autoservice.cars.common;

import autoservice.cars.car.Car;

import java.math.BigDecimal;

public class TestEntityFactory {

    public static Car getCar(String name, BigDecimal price, String vin, Boolean available) {
        Car car = new Car();
        car.setName(name);
        car.setPrice(price);
        car.setVin(vin);
        car.setAvailable(available);
        return car;
    }
}
