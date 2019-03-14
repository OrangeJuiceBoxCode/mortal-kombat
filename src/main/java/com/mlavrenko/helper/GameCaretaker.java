package com.mlavrenko.helper;

import com.mlavrenko.model.game.GameMemento;

import java.util.Optional;

/**
 * Caretaker object from Memento pattern.
 */
public interface GameCaretaker {
    /**
     * Returns object which represent state of the game.
     *
     * @return game state object if exists.
     */
    Optional<GameMemento> getMemento();

    /**
     * Saves state of the game.
     *
     * @param gameMemento state of the game
     * @return <code>true<code/> if object was saved, otherwise <code>false<code/>
     */
    boolean save(GameMemento gameMemento);
}
