package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            Files.deleteIfExists(this.path);
            Files.createFile(this.path);

        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

        File file = path.toFile();
        file.deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

        return -1;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(this.path))) {
            output.writeObject(entry);

        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        Entry entry = null;

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(this.path))) {
            if (getFileSize() > 0) {
                entry = (Entry) input.readObject();
            }

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

        return entry;
    }

    public void remove() {
        try {
            Files.delete(this.path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
