package autoservice.app.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class ScheduleDto {
    private List<Long> days;
    private LocalTime time;
}
