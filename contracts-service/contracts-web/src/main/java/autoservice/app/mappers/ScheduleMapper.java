package autoservice.app.mappers;

import autoservice.app.dto.ScheduleDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ScheduleMapper {
    public CronTrigger toCron(ScheduleDto dto) {
        StringBuilder cron = new StringBuilder();
        if (Objects.nonNull(dto.getTime())) {
            //seconds
            cron.append(dto.getTime().getSecond()).append(StringUtils.SPACE);
            //minutes
            cron.append(dto.getTime().getMinute()).append(StringUtils.SPACE);
            //hours
            cron.append(dto.getTime().getHour()).append(StringUtils.SPACE);
        } else {
            cron.append("* * *").append(StringUtils.SPACE);
        }
        //day of month
        cron.append("*").append(StringUtils.SPACE);
        //month
        cron.append("*").append(StringUtils.SPACE);
        //day of week
        if (Objects.nonNull(dto.getDays()) && !dto.getDays().isEmpty()) {
            dto.getDays().forEach(day -> cron.append(day).append(','));
            cron.delete(cron.length() - 1, cron.length());
        } else {
            cron.append("*");
        }

        return new CronTrigger(cron.toString());
    }
}
