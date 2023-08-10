package training.springboot.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PersonBB implements ActionButton {

    @Override
    public String greets() {
        return " From PersonB : Good Morning ";
    }

    @Override
    public String callStatusAt() {
        return "Call Rejected from 13455432";
    }
}
