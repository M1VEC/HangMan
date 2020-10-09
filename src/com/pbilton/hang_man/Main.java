package com.pbilton.hang_man;

public class Main {
    public static UserInteraction userInteraction;
    public static Selection selection;
    public static PlayGame playGame;

    public static void main(String[] args) {

        do {
            userInteraction = new UserInteraction();
            userInteraction.into();

            selection = new Selection("movies");
            selection.setSelection();

            playGame = new PlayGame(userInteraction, selection.getAnswer(), selection.getHint());
            playGame.play();

        } while (userInteraction.playAgain());
    }
}
