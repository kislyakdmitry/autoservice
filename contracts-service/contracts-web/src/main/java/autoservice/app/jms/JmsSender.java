package autoservice.app.jms;

import autoservice.app.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class JmsSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendEmployee(EmployeeDto employeeDto) throws JMSException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        jmsTemplate.convertAndSend("register.topic", objectMapper.writeValueAsString(employeeDto));
    }
}
