package com.mlavrenko.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

/**
 * Helper to work with files.
 */
public class FileUtils {
    private final String filePath;

    public FileUtils(String filePath) {
        this.filePath = filePath;
    }

    public <T> Optional<T> read(Class<T> type) {
        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            return Optional.ofNullable(objectInputStream.readObject()).map(type::cast);
        } catch (Exception eception) {
            System.err.println("Failed to load the game.Reason:" + eception);
            return Optional.empty();
        }
    }

    public boolean write(Serializable object) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(object);
            return true;
        } catch (Exception exception) {
            System.err.println("Failed to save the game.Reason:" + exception);
            return false;
        }
    }
}
