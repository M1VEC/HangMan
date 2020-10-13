package com.pbilton.HangMan;

import java.util.List;
import java.util.Scanner;

public class UserInteraction implements UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void introduction(){
        displayMessage("----------------------");
        displayMessage("Welcome to Java HangMan!");
        System.out.println();
        displayMessage("Find the hidden word from the available letters and numbers");
        displayMessage("If you need a hint then type \\'?\\' but be warned,");
        displayMessage("it will cost you a wrong guess!");
    }

    @Override
    public String selectCategory(SelectAnswer selectAnswer){
        System.out.println();
        displayMessage("Please select a category:");

        List<String> categories = selectAnswer.getCategoryList();
        categories.forEach(System.out::println);

        displayMessage("Selection: ");
        String category = scanner.next().toLowerCase();
        if(validateCategorySelection(category, categories))
            return category;
        else
            displayMessage("****** Please enter a valid category! ******");
            return selectCategory(selectAnswer);
    }

    @Override
    public boolean validateCategorySelection(String category, List<String> categories) {
        return categories.contains(category);
    }

    @Override
    public char enterInput() {
        displayMessage("\nPlease enter your next letter: ");
        String input = scanner.next().toUpperCase();
        return input.charAt(0);
    }

    @Override
    public void displayAlphabet(char[] available) {
        displayMessage("\nAvailable characters");
        for (char letter : available) {
            System.out.print(letter + " ");
        }
    }

    @Override
    public void displayUserAnswer(char[] userAnswer) {
        System.out.println("\n    " + new String(userAnswer));
    }

    @Override
    public void displayAnswer(char[] answer) {
        System.out.println("\n    " + new String(answer));
    }

    @Override
    public void displayMessage(String message) {
        System.out.println("    " + message);
    }

    @Override
    public boolean playAgain() {
        displayMessage("Would you like to play again? (Y or N)");
        String play = scanner.next();
        return "Y".equalsIgnoreCase(play);
    }
}