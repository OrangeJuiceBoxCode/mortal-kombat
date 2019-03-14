package com.mlavrenko.view;

import com.mlavrenko.model.figth.FightResult;

/**
 * View abstraction.
 */
public interface GameView {
    /**
     * Displays intro message.
     */
    void displayIntro();

    /**
     * Displays outro message.
     */
    void displayOutro();

    /**
     * Displays help message.
     */
    void displayExplore();

    /**
     * Displays character.
     */
    void displayCharacter();

    /**
     * Displays successful save operation.
     */
    void displaySave();

    /**
     * Displays failed save operation.
     */
    void displaySaveFailed();

    /**
     * Displays successful resume operation.
     */
    void displayResume();

    /**
     * Displays failed resume operation.
     */
    void displayResumeFailed();

    /**
     * Displays successful fight operation.
     */
    void displayFight(FightResult fightResult);

    /**
     * Displays failed fight operation.
     */
    void displayFightFailed();
}
