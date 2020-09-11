package com.deutsche.demojpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Address {
    @Id
    @GeneratedValue
    private int id;

    private String city;
    private String street;




}
