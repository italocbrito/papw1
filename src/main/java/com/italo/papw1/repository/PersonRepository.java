package com.italo.papw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.italo.papw1.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
