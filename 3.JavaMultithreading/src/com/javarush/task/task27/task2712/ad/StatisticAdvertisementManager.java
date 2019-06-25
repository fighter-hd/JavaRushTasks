package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){}

    private static class StatisticAdvertisementManagerHolder {
        private final static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    }

    public static StatisticAdvertisementManager getInstance() {
        return StatisticAdvertisementManagerHolder.instance;
    }

    public List<Advertisement> getActiveVideosList() {
        List<Advertisement> allVideos = storage.list();
        List<Advertisement> activeVideosList = new ArrayList<>();

        for (Advertisement video : allVideos) {
            if (video.getHits() > 0)
                activeVideosList.add(video);
        }

        return activeVideosList;
    }

    public List<Advertisement> getArchivedVideosList() {
        List<Advertisement> allVideos = storage.list();
        List<Advertisement> archivedVideosList = new ArrayList<>();

        for (Advertisement video : allVideos) {
            if (video.getHits() == 0)
                archivedVideosList.add(video);
        }

        return archivedVideosList;
    }
}
