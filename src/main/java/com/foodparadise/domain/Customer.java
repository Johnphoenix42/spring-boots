package com.foodparadise.domain;

import jakarta.persistence.*;

import com.foodparadise.order.FoodOrder;

@Entity
@Table(name = "customer")
public class Customer {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String firstName;
    private String lastName;
    private FoodOrder[] foodOrders;

    protected Customer(){}

    public Customer(String firstName, String lastName) {
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

    public FoodOrder[] getFoodOrders() {
        return foodOrders;
    }

    public void setFoodOrders(FoodOrder[] foodOrders) {
        this.foodOrders = foodOrders;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
