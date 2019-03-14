package com.mlavrenko.model.figth;

import com.mlavrenko.model.character.Character;

/**
 * Represents failed fight result.
 */
public enum FailedFightResult implements FightResult {
    INSTANCE;

    @Override
    public Character getFirstFighter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Character getSecondFighter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Character getWinner() {
        throw new UnsupportedOperationException();
    }
}
