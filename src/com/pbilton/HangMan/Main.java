package com.pbilton.HangMan;

public class Main {

    public static void main(String[] args)  {

        UserInteraction userInteraction;
        do {
            userInteraction = new UserInteraction();
            userInteraction.introduction();

            SelectAnswer selection = new SelectAnswer();
            selection.setAnswer(userInteraction.selectCategory());

            Game play = new Game(userInteraction, selection.getAnswer(), selection.getHint());
            play.playGame();

        } while (userInteraction.playAgain());
    }
}
