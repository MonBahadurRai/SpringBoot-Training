package training.springboot.javaBeanConfig;

import training.springboot.beanScope.common.Coach;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("S");
    }

    @Override
    public String getDailyWorkout() {
        return "HEELO JAVA BEAN CONFIG";
    }
}
