package com.mlavrenko.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("File utils test")
class FileUtilsTest {
    private static final String PATH = "object.txt";
    private FileUtils fileUtils;

    @BeforeEach
    void before() {
        fileUtils = new FileUtils(PATH);
    }

    @Test
    @DisplayName("read should return empty result when source file doesn't exist")
    void testReadFailed() {
        Optional<Object> read = fileUtils.read(Object.class);

        assertEquals(Optional.empty(), read);
    }

    @Test
    @DisplayName("read should return not empty result when source file with object exists")
    void testReadSuccess() throws IOException {
        List<String> toWrite = new ArrayList<>();
        try (FileOutputStream out = new FileOutputStream(PATH); ObjectOutputStream stream = new ObjectOutputStream(out)) {
            stream.writeObject(toWrite);
        }
        Optional<Object> read = fileUtils.read(Object.class);

        assertEquals(Optional.of(toWrite), read);
    }

    @Test
    @DisplayName("write should store object in file when object is eligible for writing")
    void testWriteSuccess() {
        boolean isWritten = fileUtils.write(new ArrayList<>());
        assertTrue(isWritten);
    }

    @Test
    @DisplayName("write should not store object in file when writing causes exception")
    void testWriteFailed() {
        boolean isWritten = fileUtils.write(new TestObject());
        assertFalse(isWritten);
    }

    private static class TestObject implements Serializable {
        private Object object = new Object();
    }

    @AfterEach
    void after() throws IOException {
        Path fileToDeletePath = Paths.get(PATH);
        Files.deleteIfExists(fileToDeletePath);
    }
}