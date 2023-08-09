package training.springboot.setterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.constructorInjection.Coach;

@RestController
public class DemoSetterController {
    private Coach myCoach;


    @Autowired
    public void setCoach(Coach coach) {
        myCoach = coach;
    }

    @GetMapping(value = "/setterInjection")
    public String getCricket() {
        return myCoach.getDailyWorkout();
    }


    @GetMapping(value = "/directSetterInjection")
    public String moss() {
        return myCoach.getDailyWorkout();
    }


}
