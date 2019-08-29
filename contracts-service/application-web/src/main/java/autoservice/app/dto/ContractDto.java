package autoservice.app.dto;

import autoservice.app.domain.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ContractDto {

    @JsonView(autoservice.app.domain.views.Views.Contracts.class)
    private Long id;

    private Long employeeId;

    @JsonView(autoservice.app.domain.views.Views.Contracts.class)
    private Customer customer;

    private List<Long> carIds;

    @JsonView(autoservice.app.domain.views.Views.Contracts.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonView(autoservice.app.domain.views.Views.Contracts.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
