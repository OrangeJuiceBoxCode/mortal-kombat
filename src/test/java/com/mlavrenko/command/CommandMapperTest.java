package com.mlavrenko.command;

import com.mlavrenko.controller.GameController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Command mapper test")
class CommandMapperTest {

    @Test
    @DisplayName("getUserCommands should contains expected list of commands")
    void testGetUserCommands() {
        Map<String, Consumer<GameController>> commands = CommandMapper.getUserCommands();
        Set<String> expected = Stream.of("create", "save", "resume", "fight", "explore", "exit").collect(toSet());
        assertIterableEquals(commands.keySet(), expected);
    }
}