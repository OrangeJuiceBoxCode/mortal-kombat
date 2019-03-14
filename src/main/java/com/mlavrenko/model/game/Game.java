package com.mlavrenko.model.game;

import com.mlavrenko.model.character.Character;
import com.mlavrenko.model.figth.FightResult;

/**
 * Represents game abstraction.
 */
public interface Game {
    void setPlayer(Character player);

    Character getPlayer();

    /**
     * @return intro message
     */
    String getIntro();

    /**
     * Corresponds to Originator createMemento action from Memento pattern.
     *
     * @return object with the game state to save
     */
    GameMemento save();

    /**
     * Corresponds to Originator restore action from Memento pattern.
     *
     * @param gameMemento object with the game state to restore.
     */
    void resume(GameMemento gameMemento);

    /**
     * Allows to gain fight experience.
     *
     * @return fight result
     */
    FightResult fight();

    String getOutro();

    /**
     * Returns message with game description.
     *
     * @return help message
     */
    String getHelp();
}
