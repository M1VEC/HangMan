package com.pbilton.HangMan;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {

        UserInteraction userInteraction;
        do {
            userInteraction = new UserInteraction();
            userInteraction.introduction();

            Selection selection = new Selection();
            selection.setSelection("movies");
            Game playGame = new Game(userInteraction, selection.getAnswer(), selection.getHint());
            playGame.playGame();

        } while (userInteraction.playAgain());
    }
}
