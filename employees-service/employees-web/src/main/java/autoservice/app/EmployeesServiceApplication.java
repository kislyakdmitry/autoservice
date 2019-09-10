package autoservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "autoservice")
@EnableJms
public class EmployeesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeesServiceApplication.class, args);
    }
}
