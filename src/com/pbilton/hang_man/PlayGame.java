package com.pbilton.hang_man;

public class PlayGame extends UserInteraction{

    private char[] hint;
    private char[] answer;
    private char[] userAnswer;
    private char[] available = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char guess;
    private int wrongGuessCount = 0;
    private int correctGuessCount = 0;
    private final int maxWrong = 9;
    private boolean validInput;
    private boolean endGame = false;
    private UserInteraction userInteraction;

    public PlayGame(UserInteraction userInteraction, char[] answer, char[] hint) {
        this.userInteraction = userInteraction;
        this.answer = answer;
        this.hint = hint;
        userAnswer = new String (answer).replaceAll("\\w", "_").toCharArray();
        correctGuessCount = new String(answer).replaceAll("[^ ]", "").length();
    }

    public void play() {
        while(!endGame) {
            validateInput();
            compareToAnswer();
            if(correctGuessCount == answer.length)
                endGame = winGame();
            else if(wrongGuessCount == maxWrong)
                endGame = loseGame();
        }
    }

    private void validateInput(){
        validInput = false;
        while (!validInput) {
            guess = userInput();
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

    private char userInput(){               //add code to allow the user to type hint or type the full answer
        userInteraction.displayUserAnswer(userAnswer);
        userInteraction.displayAlphabet(available);
        return userInteraction.enterLetter();
    }

    private void compareToAnswer() {
        boolean letterFound = false;
        for(int n = 0; n < answer.length; n++){
            if(guess == answer[n]){
                userAnswer[n] = guess;
                correctGuessCount++;
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


