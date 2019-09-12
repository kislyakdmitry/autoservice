package autoservice.app.common;

import autoservice.app.employee.EmployeeDto;
import autoservice.app.jms.JmsSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;

@RequestMapping("api/register")
@RestController
@AllArgsConstructor
public class RegisterController {

    private JmsSender jmsSender;

    @PostMapping
    public void registerEmployee(@RequestBody EmployeeDto employeeDto) throws JMSException, JsonProcessingException {
        jmsSender.sendEmployee(employeeDto);
    }
}
