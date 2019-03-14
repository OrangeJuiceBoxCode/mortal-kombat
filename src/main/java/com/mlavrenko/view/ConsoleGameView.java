package com.mlavrenko.view;

import com.mlavrenko.model.character.Character;
import com.mlavrenko.model.figth.FightResult;
import com.mlavrenko.model.game.Game;

import java.text.MessageFormat;

import static com.mlavrenko.view.TextConstants.FAILED_FIGHT;
import static com.mlavrenko.view.TextConstants.FAILED_RESUME;
import static com.mlavrenko.view.TextConstants.FAILED_SAVE;
import static com.mlavrenko.view.TextConstants.FIGHT_PATTERN;
import static com.mlavrenko.view.TextConstants.RESUMED;
import static com.mlavrenko.view.TextConstants.SAVED;

/**
 * Displays output to console.
 */
public class ConsoleGameView implements GameView {
    private final Game game;

    public ConsoleGameView(Game game) {
        this.game = game;
    }

    @Override
    public void displayIntro() {
        display(game.getIntro());
    }

    @Override
    public void displayOutro() {
        display(game.getOutro());
    }

    @Override
    public void displayExplore() {
        display(game.getHelp());
    }

    @Override
    public void displayCharacter() {
        display(game.getPlayer().describe());
    }

    @Override
    public void displaySave() {
        display(SAVED);
    }

    @Override
    public void displayResume() {
        display(RESUMED);
    }

    @Override
    public void displayResumeFailed() {
        displayError(FAILED_RESUME);
    }

    @Override
    public void displaySaveFailed() {
        displayError(FAILED_SAVE);
    }

    @Override
    public void displayFight(FightResult fightResult) {
        Character player = fightResult.getFirstFighter();
        Character opponent = fightResult.getSecondFighter();
        Character winner = fightResult.getWinner();
        String resultMessage = MessageFormat.format(FIGHT_PATTERN, player.getName(), opponent.getName(),
                player.describe(), opponent.describe(), winner.getName());
        display(resultMessage);
    }

    @Override
    public void displayFightFailed() {
        displayError(FAILED_FIGHT);
    }

    private void displayError(String message) {
        System.err.println(message);
    }

    private void display(String toDisplay) {
        System.out.println(toDisplay);
    }
}
