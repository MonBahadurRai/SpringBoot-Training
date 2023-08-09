package training.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@PropertySource("classpath:domain.properties")
public class FunRestController {


    //Reading the application.properties file values
    @Value("${project.name}")
    private String projectName;
    //  project.name=Spring Boot Training

    //    Injecting the application.properties custom properties
    @Value("${learning.mode}")
    private String learningMode;


    //    From Custom Properties
    @Value("${route.url}")
    private String routeUrl;

    @Value("${route.code}")
    private int routeCode;


    //Expose "/" that return "HELLO WORLD"
    @GetMapping(value = "")
    private String sayHelloWorld() {
        System.out.println(this.projectName);
        System.out.println(this.learningMode);
        return this.projectName + " : " + this.learningMode + " == > " + this.routeUrl +" at "+ this.routeCode;
    }

    @GetMapping(value = "mon")
    private String sayMon() {
        System.out.println(this.projectName);
        return "Hello Mon!";
    }
}
