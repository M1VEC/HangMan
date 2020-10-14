package com.pbilton.HangMan;

public class Main {

    public static void main(String[] args)  {

        UserInteraction userInteraction = new UserInteraction();
        SelectAnswer selectAnswer = new SelectAnswer();
        userInteraction.introduction();

        do {
            if(selectAnswer.setAnswer(userInteraction.selectCategory(selectAnswer))) {
                Game play = new Game(selectAnswer.getAnswer(), selectAnswer.getHint());
                play.playGame();
            }

        } while (userInteraction.playAgain());
    }
}
