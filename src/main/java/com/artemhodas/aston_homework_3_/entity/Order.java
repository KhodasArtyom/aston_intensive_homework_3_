package com.artemhodas.aston_homework_3_.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToMany
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "fk_orders_id", referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_products_id", referencedColumnName = "product_id"))
    private Set<Product> products;


    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
