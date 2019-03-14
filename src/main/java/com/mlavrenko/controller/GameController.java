package com.mlavrenko.controller;

/**
 * Contract of game controller.
 */
public interface GameController {
    /**
     * Shows intro message.
     */
    void showIntro();

    /**
     * Shows outro message.
     */
    void showOutro();

    /**
     * Shows help message with possible steps instruction.
     */
    void showExplore();

    /**
     * Creates main player of the game.
     */
    void createCharacter();

    /**
     * Initiates fight.
     */
    void fight();

    /**
     * To save current state of the game.
     */
    void save();

    /**
     * To resume the game from saved state.
     */
    void resume();
}
