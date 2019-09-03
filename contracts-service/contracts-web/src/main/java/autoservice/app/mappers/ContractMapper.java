package autoservice.app.mappers;

import autoservice.app.domain.Car;
import autoservice.app.domain.Contract;
import autoservice.app.domain.Employee;
import autoservice.app.dto.ContractDto;
import autoservice.app.dto.ContractSaveDto;
import autoservice.app.services.CarsService;
import autoservice.app.services.CustomersService;
import autoservice.app.services.impl.UserDetailsServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ContractMapper {

    private CarsService carsService;
    private CustomersService customersService;
    private UserDetailsServiceImpl userDetailsService;

    public ContractMapper(CarsService carsService, CustomersService customersService, UserDetailsServiceImpl userDetailsService) {
        this.carsService = carsService;
        this.customersService = customersService;
        this.userDetailsService = userDetailsService;
    }

    public Contract toContract(ContractSaveDto contractSaveDto) {
        Contract contract = new Contract();
        List<Car> cars = new ArrayList<>();
        contractSaveDto.getCarsVins().stream().map(carsService::getCarByVin).forEach(cars::add);
        contract.setCars(cars);

        for (Car car : cars) {
            car.setAvailable(false);
            carsService.save(car);
        }

        contract.setCustomer(customersService.save(contractSaveDto.getCustomer()));

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
/*       if (Objects.nonNull(contractDto.getCarIds())) {
           List<Car> cars = new ArrayList<>();
           for (Long carId : contractDto.getCarIds()) {
               Car car = new Car();
               car.setId(carId);
               cars.add(car);
           }
           contract.setCars(cars);
       }*/
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
