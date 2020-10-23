package com.ub.webtechnologies.service;

import com.ub.webtechnologies.model.Profile;
import com.ub.webtechnologies.model.User;
import org.springframework.stereotype.Component;

@Component
public class ProfileService {

    public Profile createProfile(User user, int points) {
        System.out.println(String.format("Request to create profile for user: %s", user.getName()));

        Profile.ProfileBuilder profileBuilder = new Profile.ProfileBuilder();
        Profile profile = profileBuilder
                .user(user)
                .points(points)
                .build();

        System.out.println(String.format("Profile for user %s - created", user.getName()));
        return profile;
    }
}
