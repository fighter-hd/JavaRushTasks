package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (this.currentVersion <= rollbackVersion || ! this.versionHistoryMap.containsKey(rollbackVersion)) {
            return false;
        }

        for (int i = this.currentVersion; i > rollbackVersion; i--) {
            this.versionHistoryMap.remove(i);
        }

        this.currentVersion = rollbackVersion;

        return true;
    }
}
