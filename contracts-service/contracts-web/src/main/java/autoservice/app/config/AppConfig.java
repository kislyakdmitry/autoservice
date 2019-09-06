package autoservice.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomPostProcessor customPostProcessor() {
        return new CustomPostProcessor();
    }
}
