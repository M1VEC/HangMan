package com.pbilton.HangMan;

import java.util.List;

public interface UserInterface {

     String selectCategory(SelectAnswer selectAnswer);

     boolean validateCategorySelection(String category, List<String> categories);

     char enterInput();

     void displayAlphabet(char[] available);

     void displayUserAnswer(char[] userAnswer);

     void displayAnswer(char[] answer);

     void displayMessage(String message);

     boolean playAgain();
}
