package com.mlavrenko.view;

public final class TextConstants {
    public static final String INTRO =
            "Welcome to Mortal Kombat GameStarter!\nPlease enter \"explore\" to find out more or \"exit\" to finish the game";
    public static final String HELP = "You could execute next commands:\n- create - to create new random character;" +
            "\n- fight - to fight with random opponent; \n- save/resume/exit - to save/resume/finish the game;" +
            "\n- explore - to explore the game;";
    public static final String WRONG_COMMAND = "The command {0} is unknown, please try again!";
    public static final String OUTRO = "The game is finished, see you soon!";
    static final String RESUMED = "The game is resumed!";
    static final String SAVED = "The game is saved!";
    static final String FIGHT_PATTERN = "Lets the fight begin!\n{0} is fighting against {1}" +
            "\nFirst fighter says:{2}\nSecond fighter says:{3}\n{0} hits!\n{1} hits!\nThe winner is: {4}";
    static final String FAILED_RESUME = "No game was found to resume!";
    static final String FAILED_SAVE = "Failed to save the game!";
    static final String FAILED_FIGHT = "Can't fight!Character is not created, please create a character!";

    private TextConstants() {
        //not used
    }
}
