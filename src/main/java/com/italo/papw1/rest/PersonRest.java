package com.italo.papw1.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.italo.papw1.domain.Person;
import com.italo.papw1.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonRest {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersons() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person save(@RequestBody @Valid Person person) {
        return personService.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person update(@RequestBody @Valid Person person) {
        return personService.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
