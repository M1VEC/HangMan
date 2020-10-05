package com.pbilton.hang_man;

public class PlayGame {

    private String hint;
    private char[] answer;
    private char[] userAnswer;
//    private String[] available = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private char[] available = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char guess;
    private int wrongGuess = 0;
    private boolean validGuess;

    public PlayGame(Selection selection) {
        this.answer = selection.getAnswer().toUpperCase().toCharArray();
        this.hint = selection.getHint();
        this.userAnswer = selection.getAnswer().replaceAll("\\w", "_").toCharArray();
    }

    public void play() {
        setGame();
        while (!validGuess) {
            guess = UserInterface.enterLetter();
            validGuess = validateGuess();
            if (!validGuess)
                System.out.print("Please enter a letter that has not been used before");
        }
        printAlphabet();
        compare();
    }

    public void compare() {
        for(int n = 0; n < answer.length; n++){
            if(guess == answer[n])
                System.out.println("\n"+guess);
        }
        //compare guess to answer. If answer contains guess, replace _ with guess
        //else wrongGuess +1 and draw hangman
    }

    private void setGame() {
        System.out.println();
        printAlphabet();
        System.out.println("\n    " + new String(userAnswer));
        System.out.println( new String(answer));

    }

    private void printAlphabet() {
        for (char letter : available) {
            System.out.print(letter + " ");
        }
    }

    private boolean validateGuess() {
        for(int i = 0; i < available.length; i++) {
            if(available[i] == guess){
                available[i] = '_';
                return true;
            }
        }
        return false;
    }
}


