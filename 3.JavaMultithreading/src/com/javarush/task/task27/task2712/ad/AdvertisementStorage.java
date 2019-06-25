package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 2000, 100 / 3, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 2000, 100 / 5, 5 * 60)); //5 min
        videos.add(new Advertisement(someContent, "Third Video", 2000, 100 / 7, 7 * 60)); //7 min
        videos.add(new Advertisement(someContent, "Fourth Video", 2000, 100 / 8, 8 * 60)); //8 min
        videos.add(new Advertisement(someContent, "Fifth Video", 2000, 100 / 10, 10 * 60)); //10 min
        videos.add(new Advertisement(someContent, "Sixth Video", 2000, 100 / 13, 13 * 60)); //13 min
        videos.add(new Advertisement(someContent, "Seventh Video", 2000, 100 / 15, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Eighth Video", 2000, 100 / 2, 2 * 60)); //2 min
        videos.add(new Advertisement(someContent, "восьмое Video", 2000, 100 / 2, 2 * 60)); //2 min
        videos.add(new Advertisement(someContent, "девятое Video", 2000, 100 / 2, 2 * 60)); //2 min

//        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
//        videos.add(new Advertisement(someContent, "Fourth Video", 2000, 60, 8 * 60)); //8 min
//        videos.add(new Advertisement(someContent, "Fifth Video", 700, 45, 5 * 60)); //5 min
//        videos.add(new Advertisement(someContent, "Sixth Video", 600, 70, 13 * 60)); //13 min
    }

    public static AdvertisementStorage getInstance() {
        return AdvertisementStorageHolder.instance;
    }

    private static class AdvertisementStorageHolder {
        private final static AdvertisementStorage instance = new AdvertisementStorage();
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
