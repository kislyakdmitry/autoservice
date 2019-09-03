package autoservice.app;

import autoservice.app.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestEntityFactory {

    public static Car getCar(String name, BigDecimal price, String vin, Boolean available) {
        Car car = new Car();
        car.setName(name);
        car.setPrice(price);
        car.setVin(vin);
        car.setAvailable(available);
        return car;
    }

    public static Customer getCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }

    public static Employee getEmployee(String username, String password, String firstName, String lastName) {
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        return employee;
    }

    public static Contract getContract(LocalDate startTime,
                                       LocalDate endTime,
                                       Customer customer,
                                       Employee employee,
                                       List<String> cars) {
        Contract contract = new Contract();
        contract.setStartTime(startTime);
        contract.setEndTime(endTime);
        contract.setCustomer(customer);
        contract.setEmployee(employee);
        contract.setCars(cars);
        return contract;
    }

    public static AdditionalAgreement getAdditionalAgreement(Contract contract, String car) {
        AdditionalAgreement agreement = new AdditionalAgreement();
        agreement.setContract(contract);
        agreement.setCar(car);
        return agreement;
    }
}
