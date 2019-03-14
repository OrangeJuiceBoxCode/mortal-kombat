package com.mlavrenko.model.figth;

import com.mlavrenko.model.character.Character;

/**
 * Abstraction to represent result of fight action between two characters.
 */
public interface FightResult {
    Character getFirstFighter();

    Character getSecondFighter();

    Character getWinner();
}
