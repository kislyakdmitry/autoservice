package autoservice.app;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.domain.Contract;
import autoservice.app.domain.Customer;
import autoservice.app.domain.Employee;

import java.time.LocalDateTime;
import java.util.List;

public class TestEntityFactory {

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

    public static Contract getContract(LocalDateTime startTime,
                                       LocalDateTime endTime,
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
