package autoservice.app.common;

import autoservice.app.additional_agreement.AdditionalAgreement;
import autoservice.app.car.Car;
import autoservice.app.contract.Contract;
import autoservice.app.customer.Customer;
import autoservice.app.employee.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TestEntityFactory {

    public static Car getCar(String name, BigDecimal price, String vin, Boolean available) {
        return Car.builder()
                .name(name)
                .available(available)
                .vin(vin)
                .price(price)
                .build();
    }

    public static Customer getCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }

    public static Employee getEmployee(String username, String password, String firstName, String lastName) {
        return Employee.builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    public static Contract getContract(LocalDate startTime,
                                       LocalDate endTime,
                                       Customer customer,
                                       Employee employee,
                                       List<Car> cars) {
        return Contract.builder()
                .cars(cars)
                .customer(customer)
                .employee(employee)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }

    public static AdditionalAgreement getAdditionalAgreement(Contract contract, Car car) {
        AdditionalAgreement agreement = new AdditionalAgreement();
        agreement.setContract(contract);
        agreement.setCar(car);
        return agreement;
    }
}
