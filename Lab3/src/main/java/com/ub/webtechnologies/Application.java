package com.ub.webtechnologies;

import com.ub.webtechnologies.configuration.ApplicationConfiguration;
import com.ub.webtechnologies.model.Profile;
import com.ub.webtechnologies.model.User;
import com.ub.webtechnologies.service.ProfileService;
import com.ub.webtechnologies.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService service = context.getBean(UserService.class);
        User user = service.createUser("Silvia", 27);

        ProfileService profileService = context.getBean(ProfileService.class);
        Profile profile = profileService.createProfile(user, 0);

        System.out.println(String.format("Received profile for user: %s", profile.getUser().getName()));
    }
}
