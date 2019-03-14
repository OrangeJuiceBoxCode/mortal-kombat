package com.mlavrenko.model.character;

public class SonyaBlade implements Character {
    @Override
    public String describe() {
        return String.format("I'm %s!You won't escape justice, I'll punish you!", getName());
    }

    @Override
    public String getName() {
        return "Sonya Blade";
    }
}
