package com.mlavrenko.model.game;

import com.mlavrenko.model.character.Character;
import com.mlavrenko.model.character.CharacterFactory;
import com.mlavrenko.model.figth.DefaultFightResult;
import com.mlavrenko.model.figth.FailedFightResult;
import com.mlavrenko.model.figth.FightResult;
import com.mlavrenko.view.TextConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MortalKombatGame implements Game {
    private Character player;

    @Override
    public void setPlayer(Character player) {
        this.player = player;
    }

    @Override
    public Character getPlayer() {
        return player;
    }

    @Override
    public String getIntro() {
        return TextConstants.INTRO;
    }

    @Override
    public GameMemento save() {
        return new GameMemento(player);
    }

    @Override
    public void resume(GameMemento gameMemento) {
        player = gameMemento.getPlayer();
    }

    @Override
    public FightResult fight() {
        return Optional.ofNullable(player).map(this::getFightResultContext).orElse(FailedFightResult.INSTANCE);
    }

    private FightResult getFightResultContext(Character player) {
        Character opponent = CharacterFactory.createRandom();
        Character winner = getRandomWinner(player, opponent);
        return new DefaultFightResult(player, opponent, winner);
    }

    private Character getRandomWinner(Character player, Character opponent) {
        final List<Character> characters = Arrays.asList(player, opponent);
        return characters.get(new Random().nextInt(characters.size()));
    }

    @Override
    public String getOutro() {
        return TextConstants.OUTRO;
    }

    @Override
    public String getHelp() {
        return TextConstants.HELP;
    }
}
