package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers != null && providers.length != 0) {
            this.providers = providers.clone();

        } else {
            throw new IllegalArgumentException("Adding less than one provider is invalid operation");
        }

        this.providers = providers;
    }

    public void scan() {
        int vacancyCount = 0;

        for (Provider provider : providers) {
            vacancyCount += provider.getJavaVacancies("Kiev").size();
        }

        System.out.println(vacancyCount);
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
