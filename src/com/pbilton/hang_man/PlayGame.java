package com.pbilton.hang_man;

public class PlayGame {

    private String hint;
    private char[] Answer;
    private char[] userAnswer;
    private String tempAnswer;
    private String[] available = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String guess;
    private int wrongGuess = 0;
    private boolean validGuess;

    public PlayGame(Selection selection) {
        Answer = selection.getAnswer().toUpperCase().toCharArray();
        hint = selection.getHint();
        tempAnswer = selection.getAnswer().replaceAll("\\w", "_");
    }

    public void play() {
        setGame();

        while (!validGuess) {
            guess = UserInterface.enterLetter();
            validGuess = validateGuess();
            if (!validGuess)
                System.out.print("Please enter a letter that has not been used before");
        }
        compare();
    }

    public void compare() {
        System.out.println(userAnswer);
        //compare guess to answer. If answer contains guess, replace _ with guess
        //else wrongGuess +1 and draw hangman

    }

    private void setGame() {
        System.out.println();
        System.out.println("    " + new String(Answer));
        userAnswer = tempAnswer.toCharArray();
        System.out.println("    " + new String(userAnswer));
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


