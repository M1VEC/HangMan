package com.pbilton.HangMan;

import java.util.Arrays;

public class Game extends UserInteraction {

    private final String hint;
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

    public void playGame() {
        boolean endGame = false;
        char guess;
        boolean validInput = false;
        boolean hintUsed = false;

        while(!endGame) {
            do {
                guess = getUserInput();
                if(guess == '?' && hintUsed == false)
                    hintUsed = hint();
                else if(guess == '?' && hintUsed == true)
                    displayMessage("****** Maximum hint limit reached ******");
                else
                    validInput = getValidInput(guess);
            } while (!validInput);

            if(validInput)
                getCompareToAnswer(guess);
            if (Arrays.equals(userAnswer, answer))
                endGame = winGame();
            else if (wrongGuessCount == MAX_WRONG_GUESS_COUNT)
                endGame = loseGame();
        }
    }

    private boolean validateInput(char guess) {
        for (int i = 0; i < availableCharacters.length; i++) {        //checks to see if entered character is available, if it is it will replace the character with _
            if (guess == availableCharacters[i] && guess != '_') {                        //to signify the character has been used and no longer available
                availableCharacters[i] = '_';
                return true;
            }
        }
        displayMessage("****** Please enter a valid letter! ******");
        return false;
    }

    private char getUserInput(){
        displayUserAnswer(userAnswer);
        displayAlphabet(availableCharacters);
        return enterInput();
    }

    private boolean hint(){
        wrongGuess();
        displayMessage(hint);
        return true;
    }

    private boolean compareToAnswer(char guess) {
        for(int n = 0; n < this.answer.length; n++){
            if(guess == this.answer[n]){                         //checks to see if the users guess is present in the answer at number n
                this.userAnswer[n] = guess;
                return true;
            }
        }
        wrongGuess();
        return false;
    }

    private void wrongGuess(){
        wrongGuessCount++;
        drawHangMan.printMan(wrongGuessCount);
    }

    private boolean winGame(){
        displayAnswer(answer);
        displayMessage("    Congratulations!");
        return true;
    }

    private boolean loseGame(){
        displayMessage("  Answer is");
        displayAnswer(answer);
        displayMessage("  Game Over!");
        return true;
    }

    public boolean getCompareToAnswer(char guess){
        return compareToAnswer(guess);
    }

    public boolean getValidInput(char guess){
        return validateInput(guess);
    }
}


