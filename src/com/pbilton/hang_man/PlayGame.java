package com.pbilton.hang_man;

public class PlayGame {

    private final String answer;
    private final String hint;
    private String userAnswer;
    private String[] available = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public PlayGame(Selection selection) {
        this.answer = selection.getAnswer().toUpperCase();
        this.hint = selection.getHint();
    }

    public void setgame(){
        System.out.println();
        userAnswer = answer.replaceAll("\\w","_");
        System.out.println("    " + userAnswer);
        System.out.println("    " + answer);
        System.out.println();
        printAlphabet();
    }

    public void printAlphabet(){
        for (String letter:available) {
            System.out.print(letter + " ");
            }
    }
}
