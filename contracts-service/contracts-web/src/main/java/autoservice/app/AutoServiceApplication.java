package autoservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "autoservice")
@EnableScheduling
public class AutoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoServiceApplication.class, args);
	}

}
