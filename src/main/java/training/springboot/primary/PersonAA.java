package training.springboot.primary;

import org.springframework.stereotype.Service;

@Service
public class PersonAA implements ActionButton {

    @Override
    public String greets() {
        return " From PersonA : Good Evening ";
    }

    @Override
    public String callStatusAt() {
        return "Call...045434";
    }
}
