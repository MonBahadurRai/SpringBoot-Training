package training.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    expose "/" that return "HELLO WORLD"


    //Reading the application.properties file values
    @Value("${project.name}")
    private String projectName;
    //  project.name=Spring Boot Training


    @GetMapping(value = "")
    private String sayHelloWorld() {
        System.out.println(this.projectName);
        return "Hello World!";
    }
}
