package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {}

    private static class StatisticManagerHolder {
        private final static StatisticManager instance = new StatisticManager();
    }

    public static StatisticManager getInstance() {
        return StatisticManagerHolder.instance;
    }

    public void register(EventDataRow data) {

    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            EventType[] eventArray = EventType.values();

            for (EventType eventType : eventArray) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }
    }
}
