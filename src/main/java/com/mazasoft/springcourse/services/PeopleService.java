package com.mazasoft.springcourse.services;

import com.mazasoft.springcourse.models.Person;
import com.mazasoft.springcourse.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person> personOptional = peopleRepository.findByUserName(userName);
        return personOptional.orElse(null);
    }

    @Transactional(readOnly = false)
    public void registerUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(DEFAULT_ROLE);
        peopleRepository.save(person);
    }
}
