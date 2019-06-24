package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet();

    private StatisticManager() {}

    private static class StatisticManagerHolder {
        private final static StatisticManager instance = new StatisticManager();
    }

    public static StatisticManager getInstance() {
        return StatisticManagerHolder.instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            EventType[] eventArray = EventType.values();

            for (EventType eventType : eventArray) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
