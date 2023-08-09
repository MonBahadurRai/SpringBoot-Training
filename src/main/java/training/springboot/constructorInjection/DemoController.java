package training.springboot.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


//    private final CricketCoach cricketCoach;
    private Coach coach;


//    constructor Injection

    //x For Single Dependency @Autowired is optional
//    public DemoController(CricketCoach cricketCoach) {
//        this.cricketCoach = cricketCoach;
//    }

    public DemoController(Coach coach) {
        this.coach = coach;
    }


//    @Autowired
//    public DemoController(CricketCoach cricketCoach) {
//        this.cricketCoach = cricketCoach;
//    }

//    @GetMapping(value = "/getDailyWorkout")
//    public String getCricket() {
//        return cricketCoach.getDailyWorkout();
//    }
    @GetMapping(value = "/getDailyWorkout")
    public String getCricket() {
        return coach.getDailyWorkout();
    }
}

