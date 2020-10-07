package com.pbilton.hang_man;

public class PlayGame extends UserInteraction{

    private char[] hint;
    private char[] answer;
    private char[] userAnswer;
    private char[] available = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char guess;
    private int wrongGuess = 0;
    private int correctGuess = 0;
    private final int maxWrong = 9;
    private boolean validInput;
    private boolean endGame = false;
    private UserInteraction userInteraction;

    public PlayGame(UserInteraction userInteraction, char[] answer, char[] hint) {
        this.userInteraction = userInteraction;
        this.answer = answer;
        this.hint = hint;
        userAnswer = new String (answer).replaceAll("\\w", "_").toCharArray();
    }

    public void play() {
        setGame();
        while(!endGame) {
            validateInput();
            compareToAnswer();
            if(endGame())
                break;
            userInteraction.displayUserAnswer(userAnswer);
            userInteraction.displayAlphabet(available);
        }
    }

    private void setGame() {
        correctGuess = new String(answer).replaceAll("[^ ]", "").length();
        userInteraction.displayAlphabet(available);
        userInteraction.displayUserAnswer(userAnswer);
    }

    private void validateInput(){
        validInput = false;
        while (!validInput) {
            guess = userInteraction.enterLetter();              //add code to allow the user to type hint or type the full answer
            for (int i = 0; i < available.length; i++) {
                if (guess == available[i]) {
                    available[i] = '_';
                    validInput = true;
                    break;
                }
            }
            if(!validInput)
                userInteraction.displayMessage("Please enter a valid letter! ");
        }
    }

    private void compareToAnswer() {
        boolean letterFound = false;
        for(int n = 0; n < answer.length; n++){
            if(guess == answer[n]){
                userAnswer[n] = guess;
                correctGuess++;
                letterFound = true;
            }
        }
        if(letterFound == false) {
            wrongGuess++;
            DrawHangMan.printMan(wrongGuess);
        }
    }

    private boolean endGame(){
        if(correctGuess == answer.length){
            userInteraction.displayAnswer(answer);
            userInteraction.displayMessage("    Congratulations!");
            return true;
        }
        else if(wrongGuess == maxWrong){
            userInteraction.displayMessage("  Answer is");
            userInteraction.displayAnswer(answer);
            userInteraction.displayMessage("  Game Over!");
            return true;
        }
        else
            return false;
    }
}


