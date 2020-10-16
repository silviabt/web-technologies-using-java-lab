package springcontextexample.ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springcontextexample.ex1.domain.Faculty;
import springcontextexample.ex1.domain.Student;

@Configuration
public class ApplicationConfig {

    @Bean
    public Faculty faculty() {
        return new Faculty();
    }

    @Bean
    public Student student(Faculty faculty) {
        return new Student(faculty);
    }

//    @Bean(value = "silvia")
//    public Student anotherStudent() {
//        return new Student("Silvia");
//    }
//
//    @Primary
//    @Bean(name = "john")
//    public Student yetAnotherStudent() {
//        return new Student("John");
//    }
//
//    @Bean("harry")
//    public Student yetAnotherStudentAgain() {
//        return new Student("Harry");
//    }
}
