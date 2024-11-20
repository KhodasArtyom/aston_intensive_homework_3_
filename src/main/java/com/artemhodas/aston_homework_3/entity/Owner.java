package com.artemhodas.aston_homework_3.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @Column(name="owner_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "owners")
    private Set<Car> cars;

    public Owner() {
    }

    public Owner(Long id, String name, Set<Car> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
