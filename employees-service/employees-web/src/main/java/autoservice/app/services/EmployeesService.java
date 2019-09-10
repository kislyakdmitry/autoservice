package autoservice.app.services;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

public interface EmployeesService {
    void save(final TextMessage jsonEmployee) throws JMSException, IOException;
}
