package autoservice.cars.common;

import autoservice.cars.car.Car;

import java.math.BigDecimal;

public class TestEntityFactory {

    public static Car getCar(String name, BigDecimal price, String vin, Boolean available) {
        return Car.builder()
                .name(name)
                .price(price)
                .vin(vin)
                .available(available)
                .build();

    }
}
