package com.pbilton.HangMan;

import java.util.Arrays;

public class Game extends UserInteraction{

    private String hint;
    private char[] answer;
    private char[] userAnswer;
    private char[] availableCharacters = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private int wrongGuessCount = 0;
    private static final int MAX_WRONG_GUESS_COUNT = 9;
    private DrawHangMan drawHangMan = new DrawHangMan();

    public Game(char[] answer, String hint) {
        this.answer = answer;
        this.hint = hint;
        userAnswer = new String (answer).replaceAll("\\w", "_").toCharArray(); // Copies the answer and replace all characters with _
    }

    public void playGame(){
        char userGuess = userInput();
        compareToAnswer(userGuess);
        if(!endGame())
            playGame();
    }

    private char userInput(){
        char userGuess = getUserInput();
        if(isHint(userGuess))
            return userInput();
        if(!isValidInput(userGuess))
            return userInput();
        return userGuess;
    }

    private char getUserInput(){
        displayMessage("\n       " + new String(userAnswer));
        displayAlphabet(availableCharacters);
        return enterInput();
    }

    private boolean isValidInput(char guess) {
        for (int i = 0; i < availableCharacters.length; i++) {        //checks to see if entered character is available, if it is it will replace the character with _
            if (guess == availableCharacters[i] && guess != '_') {                        //to signify the character has been used and no longer available
                availableCharacters[i] = '_';
                return true;
            }
        }
        displayMessage("****** Please enter a valid letter! ******");
        return false;
    }

    private boolean compareToAnswer(char guess) {
        boolean correctCount = false;
        for(int n = 0; n < this.answer.length; n++){
            if(guess == this.answer[n]){                         //checks to see if the users guess is present in the answer at number n
                this.userAnswer[n] = guess;
                correctCount = true;
            }
        }
        if(correctCount)
            return true;
        wrongGuess();
        return false;
    }

    private boolean isHint(char userGuess) {
        if(userGuess == '?'){
            displayMessage("\n" + hint);
            if(!hint.equals("****** Maximum hint limit reached ******"))
                wrongGuess();
            hint = "****** Maximum hint limit reached ******";
            return true;
        }
        else
            return false;
    }

    private void wrongGuess(){
        wrongGuessCount++;
        drawHangMan.printMan(wrongGuessCount);
    }

    private boolean endGame(){
        if (Arrays.equals(userAnswer, answer))
            return winGame();
        else if (wrongGuessCount == MAX_WRONG_GUESS_COUNT)
            return loseGame();
        return false;
    }

    private boolean winGame(){
        winGameMessage(new String(answer));
        return true;
    }

    private boolean loseGame(){
        loseGameMessage(new String(answer));
        return true;
    }

    public boolean getValidInput(char input){
        return isValidInput(input);
    }

    public boolean getCompareToAnswer(char input){
        return compareToAnswer(input);
    }
}
