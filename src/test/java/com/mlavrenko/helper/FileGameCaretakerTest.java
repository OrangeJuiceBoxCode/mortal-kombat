package com.mlavrenko.helper;

import com.mlavrenko.model.game.GameMemento;
import com.mlavrenko.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game care tacker test")
@ExtendWith(MockitoExtension.class)
class FileGameCaretakerTest {
    @Mock
    private FileUtils fileUtils;
    private GameCaretaker fileGameCaretaker;


    @BeforeEach
    void before() {
        fileGameCaretaker = new FileGameCaretaker(fileUtils);
    }

    @Test
    @DisplayName("getMemento calls read method from utils and returns expected result when object exists")
    void testGetMemento() {
        Optional<GameMemento> expected = Optional.of(Mockito.mock(GameMemento.class));
        Mockito.when(fileUtils.read(GameMemento.class)).thenReturn(expected);

        Optional<GameMemento> actual = fileGameCaretaker.getMemento();

        assertAll(
                () -> assertSame(expected, actual),
                () -> Mockito.verify(fileUtils).read(GameMemento.class)
        );
    }

    @Test
    @DisplayName("save calls write method from utils and returns expected result when write to file was successful")
    void save() {
        GameMemento gameMemento = Mockito.mock(GameMemento.class);
        Mockito.when(fileUtils.write(gameMemento)).thenReturn(true);

        boolean isSaved = fileGameCaretaker.save(gameMemento);

        assertAll(
                () -> assertTrue(isSaved),
                () -> Mockito.verify(fileUtils).write(gameMemento)
        );
    }
}