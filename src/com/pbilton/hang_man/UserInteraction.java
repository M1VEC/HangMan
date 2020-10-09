package com.pbilton.hang_man;

import java.util.Scanner;

public class UserInteraction implements UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void into(){
        System.out.println("----------------------");
        System.out.println("        Welcome to Java HangMan!");
        System.out.println();
        System.out.println("    Find the hidden film from the available letters and numbers");
        System.out.println("    If you need a hint then type \'!\' but be warned,");
        System.out.println("    it will cost you a wrong guess!");
    }

    @Override
    public char enterInput() {
        System.out.print("\n    Please enter your next letter: ");
        String input = scanner.nextLine().toUpperCase();
        return input.charAt(0);
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