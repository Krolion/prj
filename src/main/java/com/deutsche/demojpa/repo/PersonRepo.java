package com.deutsche.demojpa.repo;

import com.deutsche.demojpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface PersonRepo extends JpaRepository<Person, Integer> {


    List<Person> findByAgeGreaterThan(int age);

    List<Person> findByAgeBetween(int min, int max);

    List<Person> findByAddressesCity(String name);

    default List<Person> onlyVasyaPerson() {
        return findByAddressesCity("Vasya");
    }
}
