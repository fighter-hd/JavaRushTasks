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

    public boolean isEmpty() {
        if (dishes.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public int getTotalCookingTime() {
        int totalTime = 0;

        for (Dish dish : dishes) {
            switch (dish.toString()) {
                case "Fish":
                    totalTime += Dish.Fish.getDuration();
                    break;

                case "Steak":
                    totalTime += Dish.Steak.getDuration();
                    break;

                case "Soup":
                    totalTime += Dish.Soup.getDuration();
                    break;

                case "Juice":
                    totalTime += Dish.Juice.getDuration();
                    break;

                case "Water":
                    totalTime += Dish.Water.getDuration();
                    break;
            }
        }
        
        return totalTime;
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
