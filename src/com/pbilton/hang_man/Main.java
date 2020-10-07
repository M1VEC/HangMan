package com.pbilton.hang_man;

public class Main {

    public static void main(String[] args) {
        UserInteraction userInteraction;
        Selection selection;
        PlayGame playGame;
        
        do {
            userInteraction = new UserInteraction();
            String category = userInteraction.selectCat();

            selection = new Selection(category);
            selection.setSelection();

            playGame = new PlayGame(selection, userInteraction);
            playGame.play();

        } while (userInteraction.playAgain());
    }
}
