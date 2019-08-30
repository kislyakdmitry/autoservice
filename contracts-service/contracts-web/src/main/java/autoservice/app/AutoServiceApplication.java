package autoservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "autoservice")
public class AutoServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutoServiceApplication.class, args);
	}

}
