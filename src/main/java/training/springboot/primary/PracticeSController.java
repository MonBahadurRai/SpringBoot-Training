package training.springboot.primary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class PracticeSController {


    private final ActionButton actionButton2;

    @Autowired
    public PracticeSController(ActionButton actionButton2) {
        System.out.println("Constructor : "+getClass().getSimpleName());
        this.actionButton2 = actionButton2;
    }


    @GetMapping(value = "personPB")
    public String fromPersonB() {
        return actionButton2.greets()+" and "+actionButton2.callStatusAt();
    }

}
