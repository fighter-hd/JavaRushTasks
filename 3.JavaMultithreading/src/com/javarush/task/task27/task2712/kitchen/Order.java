package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (dishes.size() > 0) {
            result.append("Your order: [");
            for (Dish dish : dishes) {
                result.append(dish + ", ");
            }

            int lastIndex = result.length();
            result.deleteCharAt(--lastIndex);
            result.deleteCharAt(--lastIndex);
            result.append("] of ");
            result.append(tablet.toString());
        }

        return result.toString();
    }
}
