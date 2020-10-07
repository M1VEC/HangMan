package com.pbilton.hang_man;

public interface UserInterface {

     String selectCat();

     char enterLetter();

     void displayAlphabet(char[] available);

     void displayUserAnswer(char[] userAnswer);

     void displayAnswer(char[] answer);

     void displayMessage(String message);
}
