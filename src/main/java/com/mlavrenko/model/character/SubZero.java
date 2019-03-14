package com.mlavrenko.model.character;

public class SubZero implements Character {
    @Override
    public String describe() {
        return String.format("I'm %s!I will freeze you to death", getName());
    }

    @Override
    public String getName() {
        return "Sub-Zero";
    }
}
