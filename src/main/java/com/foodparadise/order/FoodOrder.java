package com.foodparadise.order;

public class FoodOrder {

    private long foodId;
    private static long orderId = 0;

    protected FoodOrder() {
        orderId++;
    }

    public FoodOrder(long foodId) {
        this();
        this.foodId = foodId;
    }
}
