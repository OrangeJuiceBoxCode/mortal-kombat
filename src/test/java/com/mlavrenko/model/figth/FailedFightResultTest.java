package com.mlavrenko.model.figth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Failed fight result test")
class FailedFightResultTest {

    @DisplayName("getter")
    @ParameterizedTest(name = " {0} should throw exception when the method is called")
    @MethodSource("getters")
    void testGetFirstFighter(Executable getter) {
        assertThrows(UnsupportedOperationException.class, getter);
    }

    private static Stream<Executable> getters() {
        return Stream.of(
                FailedFightResult.INSTANCE::getFirstFighter,
                FailedFightResult.INSTANCE::getSecondFighter,
                FailedFightResult.INSTANCE::getWinner);
    }
}