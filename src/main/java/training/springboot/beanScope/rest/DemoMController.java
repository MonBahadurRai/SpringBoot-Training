package training.springboot.beanScope.rest;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.beanScope.common.Coach;

@RestController
public class DemoMController {



    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoMController(
            @Qualifier("cricketSCoach") Coach theCoach,
            @Qualifier("cricketSCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkouts")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
    @PostConstruct
    public void initController() {
        System.out.println("Initializing FunRestController");
        /**
         * The @PostConstruct annotation is used in Spring to indicate a method that should be executed after a bean has been initialized by the Spring container, but before it is made available for use. This annotation is commonly used to perform initialization tasks for beans, such as setting up resources, configuring properties, or preparing the bean for use.
         *
         * In a Spring Boot application, the @PostConstruct annotated method will be invoked once the bean has been created and its dependencies have been injected. This can occur during the application's startup process, as Spring Boot initializes the beans defined in the application context.
         */
    }

    @PreDestroy
    public void destroyController() {

        System.out.println("Destroying FunRestController");
        /**
         * In Spring, the @PreDestroy annotation is used to indicate a method that should be invoked when a bean is being removed from the Spring container, typically during the shutdown of the application context. This allows you to perform cleanup tasks or release resources before the bean is destroyed.
         *
         * In a Spring Boot application, the @PreDestroy annotated method will be executed when the application context is being closed. This happens when the Spring Boot application is shutting down, which can occur when the application is explicitly terminated or when it receives a termination signal (such as pressing Ctrl+C in the console).
         */
    }

}






