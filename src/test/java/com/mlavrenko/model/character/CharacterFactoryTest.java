package com.mlavrenko.model.character;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Character factory test")
class CharacterFactoryTest {

    @Test
    @DisplayName("createRandom should create some character")
    void testCreateRandom() {
        Character random = CharacterFactory.createRandom();

        assertNotNull(random);
    }
}