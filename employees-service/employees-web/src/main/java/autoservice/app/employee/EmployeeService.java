package autoservice.app.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

@Service(value = "userService")
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @JmsListener(destination = "register.topic")
    @SendTo("register.topic")
    public void save(final TextMessage jsonEmployee) throws JMSException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(jsonEmployee.getText(), Employee.class);
        employeeRepo.save(employee);
    }
}
