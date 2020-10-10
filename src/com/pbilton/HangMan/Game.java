package com.pbilton.HangMan;

import java.util.Arrays;

public class Game {

    private final String hint;
    private boolean hintUsed = false;

    private char[] answer;
    private char[] userAnswer;
    private char[] availableCharacters = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private char guess;
    private int wrongGuessCount = 0;
    private static final int MAX_WRONG_GUESS_COUNT = 9;
    private UserInteraction userInteraction;

    public Game(UserInteraction userInteraction, char[] answer, String hint) {
        this.userInteraction = userInteraction;
        this.answer = answer;
        this.hint = hint;
        userAnswer = new String (answer).replaceAll("\\w", "_").toCharArray(); // Copies the answer and replace all characters with _
    }

    public void playGame() {
        boolean endGame = false;
        while(!endGame) {
            if(validateInput())
                compareToAnswer(guess);
            if(Arrays.equals(userAnswer,answer))
                endGame = winGame();
            else if(wrongGuessCount == MAX_WRONG_GUESS_COUNT)
                endGame = loseGame();
        }
    }

    private boolean validateInput() {
        boolean validInput = false;
        while (!validInput) {
            guess = getUserInput();
            if (guess == '?') {
                hint();
                return false;
            }
            else
                for (int i = 0; i < availableCharacters.length; i++) {        //checks to see if entered character is available, if it is it will replace the character with _
                    if (guess == availableCharacters[i] && guess != '_') {                        //to signify the character has been used and no longer available
                        availableCharacters[i] = '_';
                        return true;
                    }
                }
            userInteraction.displayMessage("Please enter a valid letter! ");
        }
        return false;
    }


    private char getUserInput(){
        userInteraction.displayUserAnswer(userAnswer);
        userInteraction.displayAlphabet(availableCharacters);
        return userInteraction.enterInput();
    }

    private void hint(){
        if(!hintUsed){
        wrongGuessCount++;
        DrawHangMan.printMan(wrongGuessCount);
        userInteraction.displayMessage(hint);
        hintUsed = true;
        }
        else
            userInteraction.displayMessage("Maximum hint limit reached");
    }

    private void compareToAnswer(char guess) {
        boolean letterFound = false;
        for(int n = 0; n < answer.length; n++){
            if(guess == answer[n]){                         //checks to see if the users guess is present in the answer at number n
                userAnswer[n] = guess;
                letterFound = true;
            }
        }
        if(letterFound == false) {
            wrongGuessCount++;
            DrawHangMan.printMan(wrongGuessCount);
        }
    }

    private boolean winGame(){
        userInteraction.displayAnswer(answer);
        userInteraction.displayMessage("    Congratulations!");
        return true;
    }

    private boolean loseGame(){
        userInteraction.displayMessage("  Answer is");
        userInteraction.displayAnswer(answer);
        userInteraction.displayMessage("  Game Over!");
        return true;
    }
}


