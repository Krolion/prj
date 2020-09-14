package com.deutsche.demojpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Evgeny Borisov
 */

@NamedQuery(name = "allPerson",query = "from Person")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @Basic(optional = false)
    private String name;
    private int age;



    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @Singular
    private List<Address> addresses;


}













