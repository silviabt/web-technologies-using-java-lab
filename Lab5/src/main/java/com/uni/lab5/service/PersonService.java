package com.uni.lab5.service;

import com.uni.lab5.domain.Person;
import com.uni.lab5.dto.PersonDto;
import com.uni.lab5.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDto save(PersonDto personDto) {
        Person person = mapToEntity(personDto);
        Person savedPerson = personRepository.save(person);
        return mapToDto(savedPerson);
    }

    public PersonDto update(PersonDto personDto) {
        Person update = personRepository.update(mapToEntity(personDto));
        if (null != update) {
            return mapToDto(update);
        }
        return null;
    }

    public List<PersonDto> getAll() {
        return personRepository.getAll()
                .stream()
                .map(person -> mapToDto(person))
                .collect(Collectors.toList());
    }

    public boolean delete(String name) {
        Optional<Person> optionalPerson = personRepository.getAll()
                .stream()
                .filter(person -> person.getName().equals(name))
                .findAny();
        if (optionalPerson.isPresent()) {
            personRepository.delete(optionalPerson.get());
            return true;
        }
        return false;
    }

    private PersonDto mapToDto(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .surname(person.getSurname())
                .additionalInfo(person.getDescription())
                .build();
    }

    private Person mapToEntity(PersonDto personDto) {
        return Person.builder()
                .name(personDto.getName())
                .surname(personDto.getSurname())
                .description("Saved Person")
                .build();
    }

}
