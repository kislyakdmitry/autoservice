package autoservice.app.contract;

import autoservice.app.car.Car;
import autoservice.app.car.CarService;
import autoservice.app.contract.dto.ContractDto;
import autoservice.app.contract.dto.ContractSaveDto;
import autoservice.app.customer.CustomerService;
import autoservice.app.employee.Employee;
import autoservice.app.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ContractMapper {

    private final CarService carService;
    private final CustomerService customerService;
    private final EmployeeService userDetailsService;

    public Contract toContract(ContractSaveDto contractSaveDto) {
        List<Car> cars = new ArrayList<>();
        contractSaveDto.getCarsVins().stream().map(carService::getCarByVin).forEach(cars::add);
        for (Car car : cars) {
            car.setAvailable(false);
            carService.save(car);
        }
        Employee employee = Employee.builder()
                .id(userDetailsService.getCurrentUser().getId())
                .build();

        return Contract.builder()
                .cars(cars)
                .employee(employee)
                .customer(customerService.save(contractSaveDto.getCustomer()))
                .startTime(contractSaveDto.getStartDate())
                .endTime(contractSaveDto.getEndDate())
                .build();
    }

    public ContractDto toContractDto(Contract contract) {
        List<String> vins = new ArrayList<>();
        contract.getCars().forEach(car -> vins.add(car.getVin()));

        return ContractDto.builder()
                .carVins(vins)
                .customer(contract.getCustomer())
                .id(contract.getId())
                .startDate(contract.getStartTime())
                .endDate(contract.getEndTime())
                .build();
    }
}
