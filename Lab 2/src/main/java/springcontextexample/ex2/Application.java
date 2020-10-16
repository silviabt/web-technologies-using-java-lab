package springcontextexample.ex2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcontextexample.ex2.config.ApplicationConfig;
import springcontextexample.ex2.domain.Person;
import springcontextexample.ex2.domain.ScheduleService;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ScheduleService scheduleService = context.getBean(ScheduleService.class);

        String scheduledClass = scheduleService.scheduleClass("web programming with java", new Person("Silvia"));
//        System.out.println(scheduledClass);

        ScheduleService scheduleService2 = context.getBean(ScheduleService.class);

        if (scheduleService != scheduleService2) {
            System.out.println("Not Same class");
            System.out.println(scheduleService);
            System.out.println(scheduleService2);
        }
    }
}
