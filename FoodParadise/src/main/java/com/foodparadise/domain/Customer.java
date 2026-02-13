package com.foodparadise.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Long foodOrderID;

    protected Customer(){}

    public Customer(String email, String passwordString, String firstName, String lastName) {
        this.email = email;
        this.password = passwordString;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getFoodOrders() {
        return foodOrderID;
    }

    public void setFoodOrders(Long foodOrders) {
        this.foodOrderID = foodOrders;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', email='%s', password='%s']",
                id, firstName, lastName, email, password);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
