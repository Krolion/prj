package com.deutsche.demojpa.dao;

import com.deutsche.demojpa.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
//        entityManager.flush();
//        entityManager.remove();
    }



    public List<Person> findAll() {
        Query query = entityManager.createQuery("from Person");



        return query.getResultList();
    }
    public List<Person> findByAgeGreaterThan(int age) {
        Query query = entityManager.createQuery("from Person where age<:age");

        List<Person> list = query.setParameter("age", age).getResultList();

        return list;
    }
}
