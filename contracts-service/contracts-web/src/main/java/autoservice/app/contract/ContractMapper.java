package autoservice.app.contract;

import autoservice.app.car.Car;
import autoservice.app.car.CarService;
import autoservice.app.customer.CustomerService;
import autoservice.app.employee.Employee;
import autoservice.app.contract.dto.ContractDto;
import autoservice.app.contract.dto.ContractSaveDto;
import autoservice.app.employee.EmployeeService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ContractMapper {

    private CarService carService;
    private CustomerService customerService;
    private EmployeeService userDetailsService;

    public ContractMapper(CarService carService, CustomerService customerService, EmployeeService userDetailsService) {
        this.carService = carService;
        this.customerService = customerService;
        this.userDetailsService = userDetailsService;
    }

    public Contract toContract(ContractSaveDto contractSaveDto) {
        Contract contract = new Contract();
        List<Car> cars = new ArrayList<>();
        contractSaveDto.getCarsVins().stream().map(carService::getCarByVin).forEach(cars::add);
        contract.setCars(cars);

        for (Car car : cars) {
            car.setAvailable(false);
            carService.save(car);
        }

        contract.setCustomer(customerService.save(contractSaveDto.getCustomer()));

        Employee employee = new Employee();
        employee.setId(userDetailsService.getCurrentUser().getId());
        contract.setEmployee(employee);

        contract.setStartTime(contractSaveDto.getStartDate());
        contract.setEndTime(contractSaveDto.getEndDate());
        return contract;
    }

    public Contract toContract(ContractDto contractDto) {
        Contract contract = new Contract();
        if (Objects.nonNull(contractDto.getEmployeeId())) {
            Employee employee = new Employee();
            employee.setId(contractDto.getEmployeeId());
            contract.setEmployee(employee);
        }
        if (Objects.nonNull(contractDto.getStartDate())) {
            contract.setStartTime(contractDto.getStartDate());
        }
        if (Objects.nonNull(contractDto.getEndDate())) {
            contract.setEndTime(contractDto.getEndDate());
        }
        return contract;
    }

    public ContractDto toContractDto(Contract contract) {
        ContractDto contractDto = new ContractDto();
        contractDto.setId(contract.getId());
        contractDto.setStartDate(contract.getStartTime());
        contractDto.setEndDate(contract.getEndTime());
        contractDto.setCustomer(contract.getCustomer());
        List<String> vins = new ArrayList<>();
        contract.getCars().forEach(car -> vins.add(car.getVin()));
        contractDto.setCarVins(vins);
        return contractDto;
    }
}
