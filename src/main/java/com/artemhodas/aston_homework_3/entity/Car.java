package com.artemhodas.aston_homework_3.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "fk_garage_id",nullable = false)

    private Garage garage;

    @ManyToMany
    @JoinTable(name = "car_owner",
    joinColumns = @JoinColumn(name = "fk_car_id"),
    inverseJoinColumns = @JoinColumn(name = "fk_owner_id"))
    private Set<Owner> owners;

    public Car() {
    }

    public Car(Long id, String model, Garage garage, Set<Owner> owners) {
        this.id = id;
        this.model = model;
        this.garage = garage;
        this.owners = owners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
