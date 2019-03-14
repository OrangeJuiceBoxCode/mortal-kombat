package com.mlavrenko.model.character;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Factory for Character objects creation.
 */
public class CharacterFactory {
    private static final List<Supplier<Character>> characters = Arrays
            .asList(SubZero::new, Raiden::new, SonyaBlade::new, ShaoKahn::new);

    private CharacterFactory() {
        //noop
    }

    /**
     * Randomly create character.
     *
     * @return character
     */
    public static Character createRandom() {
        int index = new Random().nextInt(characters.size());
        return characters.get(index).get();
    }
}
