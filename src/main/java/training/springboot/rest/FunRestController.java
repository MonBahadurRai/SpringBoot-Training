package training.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    //Reading the application.properties file values
    @Value("${project.name}")
    private String projectName;
    //  project.name=Spring Boot Training


    //Expose "/" that return "HELLO WORLD"
    @GetMapping(value = "")
    private String sayHelloWorld() {
        System.out.println(this.projectName);
        return "Hello World!";
    }
    @GetMapping(value = "mon")
    private String sayMon() {
        System.out.println(this.projectName);
        return "Hello Mon!";
    }
}
