package autoservice.app.services.impl;

import autoservice.app.domain.Employee;
import autoservice.app.repositories.EmployeeRepo;
import autoservice.app.services.EmployeesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

@Service(value = "userService")
public class EmployeesServiceImpl implements EmployeesService {

    private EmployeeRepo employeeRepo;

    public EmployeesServiceImpl(EmployeeRepo employeeRepo) {
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
