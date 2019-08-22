package autoservice.app;

import autoservice.app.domain.*;
import autoservice.app.repositories.CarsRepo;
import autoservice.app.repositories.ContractsRepo;
import autoservice.app.repositories.CustomersRepo;
import autoservice.app.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class TestEntityFactory {
    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ContractsRepo contractsRepo;

    public Car getCar() {
        Car car = new Car();
        car.setName("UAZ");
        car.setPrice(BigDecimal.valueOf(100));
        car.setOrdered(false);
        return car;
    }

    public Car getUpdatedCar() {
        Car car = new Car();
        car.setName("BMW");
        car.setPrice(BigDecimal.valueOf(1000));
        car.setOrdered(true);
        return car;
    }

    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setUsername("customer007");
        customer.setPassword("password123");
        customer.setFirstName("Ned");
        customer.setLastName("Stark");
        customer.setRole(Role.CUSTOMER);
        return customer;
    }

    public Customer getUpdatedCustomer() {
        Customer customer = new Customer();
        customer.setUsername("customer");
        customer.setPassword("password");
        customer.setFirstName("Jon");
        customer.setLastName("Snow");
        customer.setRole(Role.CUSTOMER);
        return customer;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setUsername("customer007");
        employee.setPassword("password123");
        employee.setFirstName("Ned");
        employee.setLastName("Stark");
        employee.setRole(Role.EMPLOYEE);
        return employee;
    }

    public Employee getUpdatedEmployee() {
        Employee employee = new Employee();
        employee.setUsername("customer");
        employee.setPassword("password");
        employee.setFirstName("Jon");
        employee.setLastName("Snow");
        employee.setRole(Role.EMPLOYEE);
        return employee;
    }

    public Contract getContract() {
        Contract contract = new Contract();
        contract.setStartTime(LocalDateTime.now());
        contract.setEndTime(LocalDateTime.now());
        contract.setCustomer(customersRepo.save(getCustomer()));
        contract.setEmployee(employeeRepo.save(getEmployee()));
        contract.setCars(Collections.singletonList(carsRepo.save(getCar())));
        return contract;
    }

    public Contract getUpdatedContract() {
        Contract contract = new Contract();
        contract.setStartTime(LocalDateTime.now().minusYears(1));
        contract.setEndTime(LocalDateTime.now().minusYears(1));
        contract.setCustomer(customersRepo.save(getUpdatedCustomer()));
        contract.setEmployee(employeeRepo.save(getUpdatedEmployee()));
        contract.setCars(Collections.singletonList(carsRepo.save(getUpdatedCar())));
        return contract;
    }

    public AdditionalAgreement getAdditionalAgreement() {
        AdditionalAgreement agreement = new AdditionalAgreement();
        agreement.setContract(contractsRepo.save(getContract()));
        agreement.setCar(carsRepo.save(getCar()));
        return agreement;
    }

    public AdditionalAgreement getUpdatedAdditionalAgreement() {
        AdditionalAgreement agreement = new AdditionalAgreement();
        agreement.setContract(contractsRepo.save(getUpdatedContract()));
        agreement.setCar(carsRepo.save(getUpdatedCar()));
        return agreement;
    }
}
