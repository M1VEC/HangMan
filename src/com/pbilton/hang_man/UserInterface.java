package com.pbilton.hang_man;

public interface UserInterface {

     String selectCat();

     String enterInput();

     void displayAlphabet(char[] available);

     void displayUserAnswer(char[] userAnswer);

     void displayAnswer(char[] answer);

     void displayMessage(String message);

     boolean playAgain();
}
