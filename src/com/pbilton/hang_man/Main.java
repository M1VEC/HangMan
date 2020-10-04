package com.pbilton.hang_man;

public class Main {

    public static void main(String[] args) {
        String category = UserInterface.selectCat();

        Selection selection = new Selection(category);
        selection.setSelection();
        
        System.out.println(selection.getAnswer());
    }
}
