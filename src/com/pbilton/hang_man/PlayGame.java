package com.pbilton.hang_man;

public class PlayGame extends UserInteraction{

    private char[] hint;
    private char[] answer;
    private char[] userAnswer;
    private char[] available = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char guess;
    private int wrongGuessCount = 0;
    private int hintCount = 1;
    private final int maxWrong = 9;
    private boolean validInput;
    private boolean endGame = false;
    private UserInteraction userInteraction;

    public PlayGame(UserInteraction userInteraction, char[] answer, char[] hint) {
        this.userInteraction = userInteraction;
        this.answer = answer;
        this.hint = hint;
        userAnswer = new String (answer).replaceAll("\\w", "_").toCharArray(); // Copies the answer and replace all characters with _
    }

    public void play() {
        while(!endGame) {
            if(validateInput())
                compareToAnswer(guess);
            if(new String(userAnswer).equals(new String(answer)))
                endGame = winGame();
            else if(wrongGuessCount == maxWrong)
                endGame = loseGame();
        }
    }

    private boolean validateInput(){
        validInput = false;
        while (!validInput) {
                guess = getUserInput();
                for (int i = 0; i < available.length; i++) {        //checks to see if entered character is available, if it is it will replace the character with _
                    if (guess == available[i]) {                        //to signify the character has been used and no longer available
                        available[i] = '_';
                        return true;
                    }
                }
            if(guess == '?')
                hint();
            else if (!validInput)
                userInteraction.displayMessage("Please enter a valid letter! ");
            }
        return false;
    }

    private void hint(){
        if(hintCount == 1){
        wrongGuessCount++;
        DrawHangMan.printMan(wrongGuessCount);
        userInteraction.displayMessage(new String (hint));
        hintCount--;
        }
        else
            userInteraction.displayMessage("Maximum hint limit reached");
    }

    private char getUserInput(){
        userInteraction.displayUserAnswer(userAnswer);
        userInteraction.displayAlphabet(available);
        return userInteraction.enterInput();
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


