package com.mlavrenko.model.game;

import com.mlavrenko.model.character.Character;

import java.io.Serializable;

/**
 * Represents Memento from Memento pattern.
 */
public class GameMemento implements Serializable {
    private final Character player;

    GameMemento(Character player) {
        this.player = player;
    }

    Character getPlayer() {
        return player;
    }
}
