package com.pbilton.hang_man;

public class Main {

    public static void main(String[] args) {
        UserInteraction userInteraction = new UserInteraction();
        String category = userInteraction.selectCat();

        Selection selection = new Selection(category);
        selection.setSelection();

        PlayGame playGame = new PlayGame(selection, userInteraction);
        playGame.play();
    }
}
