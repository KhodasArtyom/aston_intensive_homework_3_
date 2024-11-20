package com.artemhodas.aston_homework_3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "garages")
public class Garage {
    @Id
    @Column(name = "id_garage",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "garage")
    private List<Car> cars;

    public Garage() {
    }

    public Garage(Long id, String location, List<Car> cars) {
        this.id = id;
        this.location = location;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
