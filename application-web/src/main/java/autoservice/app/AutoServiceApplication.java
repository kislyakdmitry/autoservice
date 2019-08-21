package autoservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "autoservice")
public class AutoServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutoServiceApplication.class, args);
	}

}
