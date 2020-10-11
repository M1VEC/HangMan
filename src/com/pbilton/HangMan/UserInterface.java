package com.pbilton.HangMan;

public interface UserInterface {

     String selectCategory();

     boolean validateCategorySelection(String inputStr, String[] categoryList);

     char enterInput();

     void displayAlphabet(char[] available);

     void displayUserAnswer(char[] userAnswer);

     void displayAnswer(char[] answer);

     void displayMessage(String message);

     boolean playAgain();
}
