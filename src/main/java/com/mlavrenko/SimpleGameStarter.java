package com.mlavrenko;

import com.mlavrenko.command.CommandMapper;
import com.mlavrenko.controller.DefaultGameController;
import com.mlavrenko.controller.GameController;
import com.mlavrenko.helper.FileGameCaretaker;
import com.mlavrenko.helper.GameCaretaker;
import com.mlavrenko.model.game.Game;
import com.mlavrenko.model.game.MortalKombatGame;
import com.mlavrenko.utils.FileUtils;
import com.mlavrenko.view.ConsoleGameView;
import com.mlavrenko.view.GameView;
import com.mlavrenko.view.TextConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Encapsulates game start logic.
 */
class SimpleGameStarter {
    private static final String PATH = "game_memento.ser";

    private SimpleGameStarter() {
        //noop
    }

    static void start() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Consumer<GameController>> userCommands = CommandMapper.getUserCommands();

        GameController gameController = initGameController();
        gameController.showIntro();

        String command = "intro";
        while (!"exit".equals(command)) {
            command = in.readLine();
            if (userCommands.containsKey(command)) {
                userCommands.get(command).accept(gameController);
            } else {
                System.err.println(MessageFormat.format(TextConstants.WRONG_COMMAND, command));
            }
        }
        cleanUpOnExit();
    }

    private static void cleanUpOnExit() throws IOException {
        Path fileToDeletePath = Paths.get(PATH);
        Files.deleteIfExists(fileToDeletePath);
    }

    private static GameController initGameController() {
        FileUtils fileUtils = new FileUtils(PATH);
        GameCaretaker fileGameCaretaker = new FileGameCaretaker(fileUtils);
        Game game = new MortalKombatGame();
        GameView consoleView = new ConsoleGameView(game);
        return new DefaultGameController(consoleView, game, fileGameCaretaker);
    }
}
