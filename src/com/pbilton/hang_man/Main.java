package com.pbilton.hang_man;

public class Main {

    public static void main(String[] args) {
        String category = UserInterface.selectCat();
        Selection selection = new Selection(category);
        String setSelection = selection.getSelection();
        System.out.println(setSelection);
    }
}
