package autoservice.app.jms;

import autoservice.app.employee.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
@AllArgsConstructor
public class JmsSender {

    private final JmsTemplate jmsTemplate;

    public void sendEmployee(EmployeeDto employeeDto) throws JMSException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        jmsTemplate.convertAndSend("register.topic", objectMapper.writeValueAsString(employeeDto));
    }
}
