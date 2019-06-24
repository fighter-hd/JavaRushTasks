package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        if (cook != null) {
            cooks.add(cook);
        }
    }

    public Map<Date, Long> getAdvertisementStatistic() {
        Map<Date, Long> allAdvertisementStatistic = new TreeMap<>(Collections.reverseOrder());

        List<VideoSelectedEventDataRow> allAdvertisementsEvent = new ArrayList<>();

        for (EventDataRow eventDataRow : statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS)) {
            allAdvertisementsEvent.add((VideoSelectedEventDataRow) eventDataRow);
        }

        for (VideoSelectedEventDataRow currentEvent : allAdvertisementsEvent) {
            long currentEventAmount = currentEvent.getAmount();
            Date dateWithoutRounding = currentEvent.getDate();

            Date currentEventDate = new Date(0);
            currentEventDate.setYear(dateWithoutRounding.getYear());
            currentEventDate.setMonth(dateWithoutRounding.getMonth());
            currentEventDate.setDate(dateWithoutRounding.getDate());

            if (allAdvertisementStatistic.containsKey(currentEventDate)) {
                long dateAmount = allAdvertisementStatistic.get(currentEventDate);
                dateAmount += currentEventAmount;
                allAdvertisementStatistic.put(currentEventDate, dateAmount);

            } else {
                allAdvertisementStatistic.put(currentEventDate, currentEventAmount);
            }
        }

        return allAdvertisementStatistic;
    }

    public Map<Date, Map<String, Integer>> getCooksStatistic() {
        Map<Date, Map<String, Integer>> cooksStatistic = new TreeMap<>(Collections.reverseOrder());

        List<CookedOrderEventDataRow> allCookingEvent = new ArrayList<>();

        for (EventDataRow eventDataRow : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
            allCookingEvent.add((CookedOrderEventDataRow) eventDataRow);
        }

        for (CookedOrderEventDataRow currentEvent : allCookingEvent) {
            Date dateWithoutRounding = currentEvent.getDate();

            Date currentEventDate = new Date(0);
            currentEventDate.setYear(dateWithoutRounding.getYear());
            currentEventDate.setMonth(dateWithoutRounding.getMonth());
            currentEventDate.setDate(dateWithoutRounding.getDate());

            String cookName = currentEvent.getCookName();
            int currentCookingTime = currentEvent.getTime();

            if (cooksStatistic.containsKey(currentEventDate)) {
                Map<String, Integer> currentDateMap = cooksStatistic.get(currentEventDate);
                Map<String, Integer> tmpDateMap = new TreeMap<>(currentDateMap);

                if (tmpDateMap.containsKey(cookName)) {
                    int dayWorkTime = tmpDateMap.get(cookName);
                    dayWorkTime += currentCookingTime;
                    tmpDateMap.put(cookName, dayWorkTime);

                } else {
                    tmpDateMap.put(cookName, currentCookingTime);
                }

                cooksStatistic.put(currentEventDate, tmpDateMap);

            } else {
                Map<String, Integer> currentDateMap = new TreeMap<>();
                currentDateMap.put(cookName, currentCookingTime);
                cooksStatistic.put(currentEventDate, currentDateMap);
            }
        }

        return cooksStatistic;
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

        private Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
