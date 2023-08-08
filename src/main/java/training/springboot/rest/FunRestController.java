package training.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    expose "/" that return "HELLO WORLD"

    @GetMapping(value = "")
    private String sayHelloWorld() {
         return "Hello World!";
    }
}
