package com.mlavrenko.model.game;

import com.mlavrenko.model.character.Character;
import com.mlavrenko.model.character.*;
import com.mlavrenko.model.figth.FailedFightResult;
import com.mlavrenko.model.figth.FightResult;
import com.mlavrenko.view.TextConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Mortal kombat game test")
class MortalKombatGameTest {
    private Game game;

    private static Stream<Arguments> messages() {
        Function<Game, String> intro = Game::getIntro;
        Function<Game, String> outro = Game::getOutro;
        Function<Game, String> help = Game::getHelp;
        return Stream.of(
                Arguments.of(TextConstants.INTRO, intro),
                Arguments.of(TextConstants.OUTRO, outro),
                Arguments.of(TextConstants.HELP, help)
        );
    }

    private static Stream<Character> characters() {
        return Stream.of(new SubZero(), new Raiden(), new SonyaBlade(), new ShaoKahn());
    }

    @BeforeEach
    void before() {
        game = new MortalKombatGame();
    }

    @DisplayName("Retrieved message ")
    @ParameterizedTest(name = "after {1} method call should be equal to expected \"{0}\"")
    @MethodSource("messages")
    void testGetIntro(String expected, Function<Game, String> messageFunction) {
        String message = messageFunction.apply(game);
        assertEquals(expected, message);
    }

    @Test
    @DisplayName("save store game state")
    void testSave() {
        Character player = new SubZero();
        game.setPlayer(player);
        GameMemento saved = game.save();

        assertEquals(player, saved.getPlayer());
    }

    @Test
    @DisplayName("resume restore game to saved state when previous state exists")
    void testResume() {
        Character player = new SubZero();
        GameMemento gameMemento = new GameMemento(player);

        game.resume(gameMemento);

        assertEquals(player, game.getPlayer());
    }

    @Test
    @DisplayName("fight returns failed fight result when character is null")
    void testFightFailed() {
        FightResult fightResult = game.fight();

        assertSame(FailedFightResult.INSTANCE, fightResult);
    }

    @DisplayName("Fight of character")
    @ParameterizedTest(name = " {0} returns not failed fight result when character is not null")
    @MethodSource("characters")
    void testFightSuccess(Character character) {
        game.setPlayer(character);
        FightResult fightResult = game.fight();

        assertAll(
                () -> assertNotSame(FailedFightResult.INSTANCE, fightResult),
                () -> assertSame(character, fightResult.getFirstFighter()),
                () -> assertNotNull(fightResult.getSecondFighter()),
                () -> assertNotNull(fightResult.getWinner())
        );
    }
}