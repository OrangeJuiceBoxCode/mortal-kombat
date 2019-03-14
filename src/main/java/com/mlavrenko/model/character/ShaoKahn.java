package com.mlavrenko.model.character;

public class ShaoKahn implements Character {
    @Override
    public String describe() {
        return String.format("I'm %s!… Bow to me!You will die, mortal!", getName());
    }

    @Override
    public String getName() {
        return "Shao Kahn";
    }
}
