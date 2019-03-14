package com.mlavrenko.model.character;

public class Raiden implements Character {
    @Override
    public String describe() {
        return String
                .format("I'm %s!I'm thunder god. You don't have a chance to survive after my thunder hit!", getName());
    }

    @Override
    public String getName() {
        return "Raiden";
    }
}
