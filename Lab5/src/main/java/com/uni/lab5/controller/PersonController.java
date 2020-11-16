package com.uni.lab5.controller;

import com.uni.lab5.dto.PersonDto;
import com.uni.lab5.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

//    @RequestMapping(value = "/test/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String test(@PathVariable("name") String name) {
//        return "Hello from " + name;
//    }

//    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String test(@RequestParam String name) {
//        return "Hello from " + name;
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personService.save(personDto);
    }

    @DeleteMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String remove(@PathVariable("name") String name) {
        boolean result = personService.delete(name);
        return result ? String.format("Person %s was removed", name)
                : String.format("Person %s was not removed", name);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personDto) {
        PersonDto updatedPerson = personService.update(personDto);
        return new ResponseEntity<>(updatedPerson, null == updatedPerson ? HttpStatus.NO_CONTENT: HttpStatus.OK);
    }

}
