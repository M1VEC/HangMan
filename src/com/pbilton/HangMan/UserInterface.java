package com.pbilton.HangMan;

import java.util.List;

public interface UserInterface {

     String selectCategory();

     boolean validateCategorySelection(String inputStr);

     char enterInput();

     void displayAlphabet(char[] available);

     void displayUserAnswer(char[] userAnswer);

     void displayAnswer(char[] answer);

     void displayMessage(String message);

     boolean playAgain();
}
