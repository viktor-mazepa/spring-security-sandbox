package com.mazasoft.springcourse.utils;

import com.mazasoft.springcourse.models.Person;
import com.mazasoft.springcourse.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        Person personFromDb = peopleService.loadUserByUsername(person.getUserName());
        if (personFromDb != null) {
            errors.rejectValue("userName", "", "User with current name already exists.");
        }
    }
}
