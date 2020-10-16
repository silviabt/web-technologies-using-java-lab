package springcontextexample.ex2.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ScheduleService {

    public ScheduleService() {
        System.out.println("got here");
    }

    public String scheduleClass(String nameClass, Person person) {
        // todo logic for scheduling classes
        return String.format("Class %s was scheduled for: %s", nameClass, person.getName());
    }

}
