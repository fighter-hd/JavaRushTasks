package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {
    private StatisticManager() {}

    private static class StatisticManagerHolder {
        private final static StatisticManager instance = new StatisticManager();
    }

    public static StatisticManager getInstance() {
        return StatisticManagerHolder.instance;
    }

    public void register(EventDataRow data) {

    }
}
