package com.ub.webtechnologies.model;

public class User {

    private final String name;
    private final String surName;
    private final int age;
    private final String information;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.surName = userBuilder.surName;
        this.age = userBuilder.age;
        this.information = userBuilder.information;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public String getInformation() {
        return information;
    }

    public static class UserBuilder {

        private String name;
        private String surName;
        private int age;
        private String information;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder information(String information) {
            this.information = information;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
