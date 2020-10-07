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
    private UserInteraction userInteraction;

    public PlayGame(Selection selection, UserInteraction userInteraction) {
        this.userInteraction = userInteraction;
        this.answer = selection.getAnswer().toUpperCase().toCharArray();
        this.hint = selection.getHint();
        userAnswer = selection.getAnswer().replaceAll("\\w", "_").toCharArray();
    }

    public void play() {
        setGame();
        while(!endGame) {
            validGuess= false;
            while (!validGuess) {
                guess = userInteraction.enterLetter();
                validGuess = validateGuess();
                if (!validGuess)
                    userInteraction.displayMessage("Please enter a valid letter! ");
            }
            compare();
            userInteraction.displayUserAnswer(userAnswer);

            endGame = endGame();
            if(endGame == true)
                break;
            else
                userInteraction.displayAlphabet(available);
        }
    }

    private void setGame() {
        System.out.println();
        correctGuess = new String(answer).replaceAll("[^ ]", "").length();
        userInteraction.displayAlphabet(available);
        userInteraction.displayUserAnswer(userAnswer);
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
            userInteraction.displayMessage("    Congratulations!");
            return true;
        }
        else if(wrongGuess == 9){
            userInteraction.displayMessage("  Answer is");
            userInteraction.displayAnswer(answer);
            userInteraction.displayMessage("  Game Over!");
            return true;
        }
        else
            return false;
    }
}


