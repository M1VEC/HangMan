package com.pbilton.hang_man;

import java.util.Scanner;

public class UserInteraction implements UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public String selectCat() {
        System.out.println("Category");
        System.out.println("movies");
        System.out.print("Please select a category: ");
//        String category= scanner.next();
        System.out.println();
        String category = "movies";
        return category;
    }

    @Override
    public String enterInput() {
        System.out.print("\n    Please enter your next letter: ");
        String input = scanner.nextLine().toUpperCase();
        return input;
    }

    @Override
    public void displayAlphabet(char[] available) {
        System.out.println("\n    Available characters");
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
        System.out.println("\n" + message);
    }

    @Override
    public boolean playAgain() {
        System.out.println("Would you like to play again? (Y or N)");
        String play = scanner.next();
        if (play.equalsIgnoreCase("Y"))
            return true;
        return false;
    }
}