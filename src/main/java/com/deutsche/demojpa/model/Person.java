package com.deutsche.demojpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.*;
import java.util.List;

/**
 * @author Evgeny Borisov
 */

@NamedQuery(name = "allPerson",query = "from Person")

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;



    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Address> addresses;


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAge() != other.getAge()) return false;
        final Object this$addresses = this.getAddresses();
        final Object other$addresses = other.getAddresses();
        if (this$addresses == null ? other$addresses != null : !this$addresses.equals(other$addresses)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getAge();
        final Object $addresses = this.getAddresses();
        result = result * PRIME + ($addresses == null ? 43 : $addresses.hashCode());
        return result;
    }

    public String toString() {
        return "Person(id=" + this.getId() + ", name=" + this.getName() + ", age=" + this.getAge() + ", addresses=" + this.addresses + ")";
    }
}













