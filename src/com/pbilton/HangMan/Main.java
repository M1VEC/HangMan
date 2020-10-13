package com.pbilton.HangMan;

public class Main {

    public static void main(String[] args)  {

        UserInteraction userInteraction = new UserInteraction();
        SelectAnswer selectAnswer = new SelectAnswer();
        DrawHangMan drawHangMan = new DrawHangMan();

        do {
            userInteraction.introduction();

            if(selectAnswer.setAnswer(userInteraction.selectCategory())) {
                Game play = new Game(drawHangMan, selectAnswer.getAnswer(), selectAnswer.getHint());
                play.playGame();
            }

        } while (userInteraction.playAgain());
    }
}
