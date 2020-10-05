package com.pbilton.hang_man;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static String selectCat(){
        System.out.println("Category");
        System.out.println("movies");
        System.out.print("Please select a category: ");
//        String category= scanner.next();
        String category = "movies";
        return category;
    }

    public static String enterLetter(){
        System.out.print("\nPlease enter your next letter: ");
        String input = scanner.next().toUpperCase();
        return input;
    }
}
