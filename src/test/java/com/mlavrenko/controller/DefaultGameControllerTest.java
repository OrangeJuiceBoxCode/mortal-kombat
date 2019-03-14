package com.mlavrenko.controller;

import com.mlavrenko.helper.GameCaretaker;
import com.mlavrenko.model.figth.FailedFightResult;
import com.mlavrenko.model.game.Game;
import com.mlavrenko.model.game.GameMemento;
import com.mlavrenko.view.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Game controller test")
@ExtendWith(MockitoExtension.class)
class DefaultGameControllerTest {
    private GameController gameController;
    @Mock
    private GameView view;
    @Mock
    private GameCaretaker careTaker;
    @Mock
    private Game game;

    @BeforeEach
    void before() {
        gameController = new DefaultGameController(view, game, careTaker);
    }

    @Test
    @DisplayName("showIntro should call display intro when view is not null")
    void testShowIntro() {
        gameController.showIntro();

        Mockito.verify(view).displayIntro();
    }

    @Test
    @DisplayName("showOutro should call display outro when view is not null")
    void testShowOutro() {
        gameController.showOutro();

        Mockito.verify(view).displayOutro();
    }

    @Test
    @DisplayName("showExplore should call display explore when view is not null")
    void testShowExplore() {
        gameController.showExplore();

        Mockito.verify(view).displayExplore();
    }

    @Test
    @DisplayName("createCharacter should set player and call display character when view is not null")
    void testCreateCharacter() {
        gameController.createCharacter();

        assertAll(
                () -> Mockito.verify(game).setPlayer(Mockito.any()),
                () -> Mockito.verify(view).displayCharacter()
        );
    }

    @Test
    @DisplayName("fight should call fight and display fight results when player is not null")
    void testFightSuccess() {
        gameController.fight();

        assertAll(
                () -> Mockito.verify(game).fight(),
                () -> Mockito.verify(view).displayFight(Mockito.any())
        );
    }

    @Test
    @DisplayName("fight should call fight and display fight failed message when player is null")
    void testFightFailed() {
        Mockito.when(game.fight()).thenReturn(FailedFightResult.INSTANCE);
        gameController.fight();

        assertAll(
                () -> Mockito.verify(game).fight(),
                () -> Mockito.verify(view).displayFightFailed()
        );
    }

    @Test
    @DisplayName("save should call save and display save is successful when care taker saves successfully")
    void testSaveSuccess() {
        final GameMemento gameMemento = Mockito.mock(GameMemento.class);
        Mockito.when(game.save()).thenReturn(gameMemento);
        Mockito.when(careTaker.save(gameMemento)).thenReturn(true);

        gameController.save();

        assertAll(
                () -> Mockito.verify(game).save(),
                () -> Mockito.verify(view).displaySave()
        );
    }

    @Test
    @DisplayName("save should call save and display save is failed when care taker fails to save")
    void testSaveFailed() {
        gameController.save();

        assertAll(
                () -> Mockito.verify(game).save(),
                () -> Mockito.verify(view).displaySaveFailed()
        );
    }

    @Test
    @DisplayName("resume should call resume and display resume is failed when previous save result is absent")
    void testResumeFailed() {
        Mockito.when(careTaker.getMemento()).thenReturn(Optional.empty());

        gameController.resume();

        Mockito.verify(view).displayResumeFailed();
    }

    @Test
    @DisplayName("resume should call resume and display resume is successful when previous save result exists")
    void testResumeSuccess() {
        GameMemento gameMemento = Mockito.mock(GameMemento.class);
        Mockito.when(careTaker.getMemento()).thenReturn(Optional.of(gameMemento));

        gameController.resume();

        assertAll(
                () -> Mockito.verify(game).resume(gameMemento),
                () -> Mockito.verify(view).displayResume()
        );
    }
}