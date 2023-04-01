package com.mazasoft.springcourse.services;

import com.mazasoft.springcourse.models.Person;
import com.mazasoft.springcourse.repositories.PeopleRepository;
import com.mazasoft.springcourse.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("userName = " + userName);
        Optional<Person> personOptional = peopleRepository.findByUserName(userName);
        if (!personOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return new PersonDetails(personOptional.get());
        }
    }
}
