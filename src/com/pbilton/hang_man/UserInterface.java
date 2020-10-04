package com.pbilton.hang_man;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static String selectCat(){
        System.out.println("Category");
        System.out.println("movies");
        System.out.println("Please select a category: ");
        String category= scanner.next();
        return category;
    }
}
