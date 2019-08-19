package autoservice.application.mappers;

import autoservice.application.dto.ContractDto;
import autoservice.data.domain.Car;
import autoservice.data.domain.Contract;
import autoservice.data.domain.Employee;
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
        if (Objects.nonNull(contractDto.getCarIds())) {
            List<Car> cars = new ArrayList<>();
            for (Long carId: contractDto.getCarIds()) {
                Car car = new Car();
                car.setId(carId);
                cars.add(car);
            }
            contract.setCars(cars);
        }
        if (Objects.nonNull(contractDto.getStartTime())) {
            contract.setStartTime(contractDto.getStartTime());
        }
        if (Objects.nonNull(contractDto.getEndTime())) {
            contract.setEndTime(contractDto.getEndTime());
        }
        return contract;
    }
}
