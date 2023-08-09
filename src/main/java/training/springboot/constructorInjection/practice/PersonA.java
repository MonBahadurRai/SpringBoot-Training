package training.springboot.constructorInjection.practice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersonA implements ActionButton {

    @Override
    public String greets() {
        return " From PersonA : Good Evening ";
    }

    @Override
    public String callStatusAt() {
        return "Call...045434";
    }
}
