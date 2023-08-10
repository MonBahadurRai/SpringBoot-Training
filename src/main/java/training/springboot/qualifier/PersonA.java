package training.springboot.qualifier;

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
