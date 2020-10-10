package com.pbilton.HangMan;

public class Main {

    public static void main(String[] args) {

        UserInteraction userInteraction;
        do {
            userInteraction = new UserInteraction();
            userInteraction.introduction();

            Selection selection = new Selection("movies");
            selection.setSelection();

            Game playGame = new Game(userInteraction, selection.getAnswer(), selection.getHint());
            playGame.playGame();

        } while (userInteraction.playAgain());
    }
}
