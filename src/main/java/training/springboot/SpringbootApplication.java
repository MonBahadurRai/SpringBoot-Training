package training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Custom Base Packages ComponentScan in SpringBoot
@SpringBootApplication(scanBasePackages = {"training.springboot"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
