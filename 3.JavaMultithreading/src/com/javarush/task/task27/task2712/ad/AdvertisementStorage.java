package com.javarush.task.task27.task2712.ad;

public class AdvertisementStorage {
    private AdvertisementStorage() {
    }

    private static class AdvertisementStorageHolder {
        private final static AdvertisementStorage instance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return AdvertisementStorageHolder.instance;
    }
}
