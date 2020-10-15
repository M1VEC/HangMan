package com.pbilton.HangMan;

import java.util.List;
import java.util.Scanner;

public class UserInteraction implements UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void introduction(){
        displayMessage("----------------------");
        displayMessage("\nWelcome to Java HangMan!");
        System.out.println();
        displayMessage("\nFind the hidden word from the available letters and numbers");
        displayMessage("\nIf you need a hint then type \\'?\\' but be warned,");
        displayMessage("\nit will cost you a wrong guess!");
        displayMessage("\n");
    }

    @Override
    public String selectCategory(SelectAnswer selectAnswer){
        System.out.println();
        displayMessage("Please select a category:\n");

        List<String> categories = selectAnswer.getCategoryList();
        for(int i = 0; i<categories.size();i++)
            displayMessage("\n    " + categories.get(i));

        displayMessage("\n    Selection: ");
        String category = scanner.nextLine().toLowerCase();

        if(validateCategorySelection(category, categories))
            return category;
        else if(category.length() == 0){
            displayMessage("\n****** Please enter a valid category! ******");
            return selectCategory(selectAnswer);
        }
        else
            displayMessage("\n****** Please enter a valid category! ******");
            return selectCategory(selectAnswer);
    }

    @Override
    public boolean validateCategorySelection(String category, List<String> categories) {
        return categories.contains(category);
    }

    @Override
    public char enterInput() {
        displayMessage("\nPlease enter your next letter: ");
        String input = scanner.nextLine().toUpperCase();
        if(input.length() == 0)
            return enterInput();
        return input.charAt(0);
    }

    @Override
    public void displayAlphabet(char[] available) {
        displayMessage("\nAvailable characters\n");
        for (char letter : available) {
            System.out.print(letter + " ");
        }
    }

    @Override
    public void winGameMessage(String answer) {
        System.out.println("\n    " + answer);
        System.out.println("\n    " + "Congratulations");
    }

    @Override
    public void loseGameMessage(String answer) {
        System.out.println("\n    " + "Answer is");
        System.out.println("\n      " + answer);
        System.out.println("\n    " + "Game Over!");
    }

    @Override
    public void displayMessage(String message) {
        System.out.print("    " + message);
    }

    @Override
    public boolean playAgain() {
        displayMessage("\nWould you like to play again? (Y or N): ");
        String play = scanner.next();
        return "Y".equalsIgnoreCase(play);
    }
}