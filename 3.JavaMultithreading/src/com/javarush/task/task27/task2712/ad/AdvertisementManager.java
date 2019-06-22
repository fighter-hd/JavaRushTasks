package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videos = storage.list();

        if (videos.isEmpty() || videos == null) {
            throw new NoVideoAvailableException();
        }

//        Collections.sort(videos, new Comparator<Advertisement>() {
//            @Override
//            public int compare(Advertisement o1, Advertisement o2) {
//                long cost1 = o1.getAmountPerOneDisplaying();
//                long cost2 = o2.getAmountPerOneDisplaying();
//
//                if (cost1 == cost2)
//                    return 0;
//
//                if (cost1 > cost2) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        for (Advertisement video : videos) {
//            ConsoleHelper.writeMessage(video.getName() + " is displaying... " + video.getAmountPerOneDisplaying()
//                                        + ", " + (video.getAmountPerOneDisplaying() * 1000 / video.getDuration()));
//        }
    }
}
