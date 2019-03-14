package com.mlavrenko.model.character;

import java.io.Serializable;

/**
 * Represent character in the game.
 */
public interface Character extends Serializable {
    String describe();

    String getName();
}
