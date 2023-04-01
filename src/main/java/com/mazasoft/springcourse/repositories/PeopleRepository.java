package com.mazasoft.springcourse.repositories;

import com.mazasoft.springcourse.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByUserName(String userName);
}
