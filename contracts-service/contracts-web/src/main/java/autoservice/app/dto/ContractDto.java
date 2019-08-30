package autoservice.app.dto;

import autoservice.app.domain.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ContractDto {

    private Long id;

    private Long employeeId;

    private Customer customer;

    private List<String> carVins;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
