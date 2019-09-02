package autoservice.app.dto;

import autoservice.app.domain.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContractSaveDto {
    private Customer customer;

    private List<String> carsVins;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-M-dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-M-dd")
    private LocalDate endDate;
}
