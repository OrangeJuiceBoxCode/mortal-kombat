package com.mlavrenko.model.figth;

import com.mlavrenko.model.character.Character;

public class DefaultFightResult implements FightResult {
    private final Character firstFighter;
    private final Character secondFighter;
    private final Character winner;

    public DefaultFightResult(Character firstFighter, Character secondFighter, Character winner) {
        this.firstFighter = firstFighter;
        this.secondFighter = secondFighter;
        this.winner = winner;
    }

    @Override
    public Character getFirstFighter() {
        return firstFighter;
    }

    @Override
    public Character getSecondFighter() {
        return secondFighter;
    }

    @Override
    public Character getWinner() {
        return winner;
    }
}
