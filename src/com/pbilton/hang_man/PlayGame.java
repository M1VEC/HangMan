package com.pbilton.hang_man;

public class PlayGame {

    private String hint;
    private char[] answer;
    private char[] userAnswer;
    private char[] available = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char guess;
    private int wrongGuess = 0;
    private int correctGuess = 0;
    private boolean validGuess;
    private boolean endGame = false;

    public PlayGame(Selection selection) {
        this.answer = selection.getAnswer().toUpperCase().toCharArray();
        this.hint = selection.getHint();
        this.userAnswer = selection.getAnswer().replaceAll("\\w", "_").toCharArray();
    }

    public void play() {
        setGame();
        while(!endGame) {
            validGuess= false;
            while (!validGuess) {
                guess = UserInterface.enterLetter();
                validGuess = validateGuess();
                if (!validGuess)
                    UserInterface.displayMessage("Please enter a valid letter! ");
            }
            compare();
            UserInterface.displayUserAnswer(userAnswer);

            endGame = endGame();
            if(endGame == true)
                break;
            else
                UserInterface.displayAlphabet(available);
        }
    }

    private void setGame() {
        System.out.println();
        correctGuess = new String(answer).replaceAll("[^ ]", "").length();
        UserInterface.displayAlphabet(available);
        UserInterface.displayUserAnswer(userAnswer);
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

    private void compare() {
        boolean letterFound = false;
        for(int n = 0; n < answer.length; n++){
            if(guess == answer[n]){
                userAnswer[n] = guess;
                correctGuess++;
                letterFound = true;
            }
        }
        if(letterFound ==  false) {
            wrongGuess++;
            DrawHangMan.printMan(wrongGuess);
        }
    }

    private boolean endGame(){
        if(correctGuess == answer.length){
            UserInterface.displayMessage("    Congratulations!");
            return true;
        }
        else if(wrongGuess == 9){
            UserInterface.displayMessage("  Answer is");
            UserInterface.displayAnswer(answer);
            UserInterface.displayMessage("  Game Over!");
            return true;
        }
        else
            return false;
    }
}


