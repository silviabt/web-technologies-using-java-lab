package com.uni.lab5.repository;

import com.uni.lab5.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private List<Person> persons = new ArrayList<>();

    public PersonRepository() {
        loadData();
    }

    public Person save(Person person) {
        persons.add(person);
        return person;
    }

    public Person update(Person person) {
        Optional<Person> optionalPerson = persons.stream()
                .filter(person1 -> person1.getName().equals(person.getName()))
                .findAny();
        if (optionalPerson.isPresent()) {
            persons.remove(optionalPerson.get());
            persons.add(person);
            return person;
        }
        return null;
    }

    public List<Person> getAll() {
        return persons;
    }

    public void delete(Person person) {
        persons.remove(person);
    }

    private void loadData() {
        Person person1 = Person.builder()
                .name("Silvia")
                .surname("Butan")
                .build();

        persons.add(person1);

        Person person2 = Person.builder()
                .name("Maria")
                .surname("Butan")
                .build();

        persons.add(person2);
    }
}
