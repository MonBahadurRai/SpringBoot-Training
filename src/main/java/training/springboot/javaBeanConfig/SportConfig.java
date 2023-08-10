package training.springboot.javaBeanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.springboot.beanScope.common.Coach;

@Configuration
public class SportConfig {
    @Bean("customBean")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
