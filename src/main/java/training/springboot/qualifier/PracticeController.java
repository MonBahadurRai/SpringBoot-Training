package training.springboot.qualifier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import training.springboot.beanScope.common.Coach;
import training.springboot.javaBeanConfig.SwimCoach;

@RestController
public class PracticeController {

    private final ActionButton actionButton1;
    private final ActionButton actionButton2;
    private Coach swimCoach;

    @Autowired
    public PracticeController(
            @Qualifier("personA") ActionButton actionButton1,
            @Qualifier("personB") ActionButton actionButton2,@Qualifier("customBean") Coach coach) {
        System.out.println("Constructor : "+getClass().getSimpleName());


        this.actionButton1 = actionButton1;
        this.actionButton2 = actionButton2;
        this.swimCoach = coach;
    }


    @GetMapping(value = "personA")
    public String fromPersonA() {
        return actionButton1.greets()+" and  "+actionButton1.callStatusAt();
    }
    @GetMapping(value = "personB")
    public String fromPersonB() {

        return actionButton2.greets()+" and "+actionButton2.callStatusAt()+" SWIM COACH Status : "+swimCoach.getDailyWorkout();
    }

}
