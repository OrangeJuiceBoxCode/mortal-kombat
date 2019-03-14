package com.mlavrenko.command;

import com.mlavrenko.controller.GameController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Dedicated class for command mapping handling.
 */
public class CommandMapper {
    private static final Map<String, Consumer<GameController>> userCommands;

    static {
        userCommands = new HashMap<>();
        userCommands.put("create", GameController::createCharacter);
        userCommands.put("save", GameController::save);
        userCommands.put("resume", GameController::resume);
        userCommands.put("fight", GameController::fight);
        userCommands.put("explore", GameController::showExplore);
        userCommands.put("exit", GameController::showOutro);
    }

    private CommandMapper() {
        //noop
    }

    public static Map<String, Consumer<GameController>> getUserCommands() {
        return Collections.unmodifiableMap(userCommands);
    }


}
