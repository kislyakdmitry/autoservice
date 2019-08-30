package autoservice.app.mappers;

import autoservice.app.domain.Contract;
import autoservice.app.domain.Employee;
import autoservice.app.dto.ContractDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ContractMapper {
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
        if (Objects.nonNull(contractDto.getStartTime())) {
            contract.setStartTime(contractDto.getStartTime());
        }
        if (Objects.nonNull(contractDto.getEndTime())) {
            contract.setEndTime(contractDto.getEndTime());
        }
        return contract;
    }

    public ContractDto toContractDto(Contract contract) {
        ContractDto contractDto = new ContractDto();
        contractDto.setId(contract.getId());
        contractDto.setStartTime(contract.getStartTime());
        contractDto.setEndTime(contract.getEndTime());
        contractDto.setCustomer(contract.getCustomer());
        contractDto.setCarVins(contract.getCars());
        return contractDto;
    }
}
