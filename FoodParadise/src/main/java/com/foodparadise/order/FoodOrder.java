package com.foodparadise.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food_order")
public class FoodOrder {

    @Id
    @GeneratedValue
    private Long foodOrderId;
    private Long foodId;
    private Long customerId;

    protected FoodOrder() {}

    public FoodOrder(Long foodId, Long customerId) {
        this.foodId = foodId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Long getFoodOrderId() {
        return foodOrderId;
    }

    public void setFoodOrderId(Long foodOrderId) {
        this.foodOrderId = foodOrderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return String.format(
                "FoodOrder[id=%d, foodId='%s', customerId='%s']",
                foodOrderId, foodId, customerId);
    }

}
