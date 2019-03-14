package com.mlavrenko.controller;

import com.mlavrenko.helper.GameCaretaker;
import com.mlavrenko.model.character.Character;
import com.mlavrenko.model.character.CharacterFactory;
import com.mlavrenko.model.figth.FailedFightResult;
import com.mlavrenko.model.figth.FightResult;
import com.mlavrenko.model.game.Game;
import com.mlavrenko.model.game.GameMemento;
import com.mlavrenko.view.GameView;

import java.util.Optional;

/**
 * Default implementation of GameController interface.
 */
public class DefaultGameController implements GameController {
    private final GameView view;
    private final Game game;
    private final GameCaretaker fileGameCaretaker;

    public DefaultGameController(GameView view, Game game, GameCaretaker fileGameCaretaker) {
        this.view = view;
        this.game = game;
        this.fileGameCaretaker = fileGameCaretaker;
    }

    @Override
    public void showIntro() {
        view.displayIntro();
    }

    @Override
    public void showOutro() {
        view.displayOutro();
    }

    @Override
    public void showExplore() {
        view.displayExplore();
    }


    @Override
    public void createCharacter() {
        Character player = CharacterFactory.createRandom();
        game.setPlayer(player);
        view.displayCharacter();
    }

    @Override
    public void fight() {
        final FightResult fightResult = game.fight();
        if (fightResult == FailedFightResult.INSTANCE) {
            view.displayFightFailed();
        } else {
            view.displayFight(fightResult);
        }
    }

    @Override
    public void save() {
        GameMemento gameMemento = game.save();
        boolean saved = fileGameCaretaker.save(gameMemento);
        if (saved) {
            view.displaySave();
        } else {
            view.displaySaveFailed();
        }
    }

    @Override
    public void resume() {
        Optional<GameMemento> gameMemento = fileGameCaretaker.getMemento();
        if (gameMemento.isPresent()) {
            game.resume(gameMemento.get());
            view.displayResume();
        } else {
            view.displayResumeFailed();
        }
    }
}
