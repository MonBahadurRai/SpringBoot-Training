package training.springboot.constructorInjection.practice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersonB implements ActionButton {

    @Override
    public String greets() {
        return " From PersonB : Good Morning ";
    }

    @Override
    public String callStatusAt() {
        return "Call Rejected from 13455432";
    }
}