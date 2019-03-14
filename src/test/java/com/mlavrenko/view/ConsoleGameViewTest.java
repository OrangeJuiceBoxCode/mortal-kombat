package com.mlavrenko.view;

import com.mlavrenko.model.character.SubZero;
import com.mlavrenko.model.figth.FightResult;
import com.mlavrenko.model.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Console game view test")
@ExtendWith(MockitoExtension.class)
class ConsoleGameViewTest {
    @Spy
    private GameView view;
    @Mock
    private Game game;

    @BeforeEach
    void before() {
        view = new ConsoleGameView(game);
    }

    @Test
    void displayIntro() {
        view.displayIntro();

        Mockito.verify(game).getIntro();
    }

    @Test
    void displayOutro() {
        view.displayOutro();

        Mockito.verify(game).getOutro();
    }

    @Test
    void displayExplore() {
        view.displayExplore();

        Mockito.verify(game).getHelp();
    }

    @Test
    void displayFight() {
        SubZero fighter = new SubZero();
        FightResult fightResult = Mockito.mock(FightResult.class);
        Mockito.when(fightResult.getFirstFighter()).thenReturn(fighter);
        Mockito.when(fightResult.getSecondFighter()).thenReturn(fighter);
        Mockito.when(fightResult.getWinner()).thenReturn(fighter);

        view.displayFight(fightResult);

        assertAll(
                () -> Mockito.verify(fightResult).getFirstFighter(),
                () -> Mockito.verify(fightResult).getSecondFighter(),
                () -> Mockito.verify(fightResult).getWinner()
        );
    }

    @Test
    void displayCharacter() {
        Mockito.when(game.getPlayer()).thenReturn(new SubZero());
        view.displayCharacter();

        Mockito.verify(game).getPlayer();
    }
}