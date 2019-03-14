package com.mlavrenko.helper;

import com.mlavrenko.model.game.GameMemento;
import com.mlavrenko.utils.FileUtils;

import java.util.Optional;

/**
 * Implementation of the interface based on work with files.
 */
public class FileGameCaretaker implements GameCaretaker {
    private final FileUtils fileUtils;

    public FileGameCaretaker(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    /**
     * Reads object from file.
     */
    @Override
    public Optional<GameMemento> getMemento() {
        return fileUtils.read(GameMemento.class);
    }

    /**
     * Saves object to file.
     */
    @Override
    public boolean save(GameMemento gameMemento) {
        return fileUtils.write(gameMemento);
    }
}
