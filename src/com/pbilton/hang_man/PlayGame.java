package com.pbilton.hang_man;

public class PlayGame {

    private String answer;
    private String hint;
    private String userAnswer;
    private String[] available = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String guess;
    private int wrongGuess = 0;
    private boolean validGuess;

    public PlayGame(Selection selection) {
        this.answer = selection.getAnswer().toUpperCase();
        this.hint = selection.getHint();
    }

    public void play() {
        setGame();
        while (!validGuess) {
            guess = UserInterface.enterLetter();
            validGuess = validateGuess();
            if (!validGuess)
                System.out.print("Please enter a letter that has not been used before");
        }
    }

    public void compare() {
    }

    private void setGame() {
        System.out.println();
        userAnswer = answer.replaceAll("\\w", "_");
        System.out.println("    " + userAnswer);
        System.out.println("    " + answer);
        System.out.println();
        printAlphabet();
    }

    private void printAlphabet() {
        for (String letter : available) {
            System.out.print(letter + " ");
        }
    }

    private boolean validateGuess() {
        for(int i = 0; i < available.length; i++) {
            if(available[i].equals(guess)){
                available[i] = available[i].replaceAll(available[i],"_");
                return true;
            }
        }
        return false;
    }
}


