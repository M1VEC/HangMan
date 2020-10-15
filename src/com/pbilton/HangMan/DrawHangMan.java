package com.pbilton.HangMan;

public class DrawHangMan extends UserInteraction {
    private String line1 = "";
    private String line2 = "";
    private String line3 = "";
    private String line4 = "";
    private String line5 = "";

    public void printMan(int n){
        System.out.println();
        displayMessage("\n****************************");
        displayMessage("\n    Incorrect Guess");

        lines(n);

        displayMessage("\n" + line1);
        displayMessage("\n" + line2);
        displayMessage("\n" + line3);
        displayMessage("\n" + line4);
        displayMessage("\n" + line5);
        displayMessage("\n****************************");
    }

    private void lines(int n){
        switch (n){
            case 1:
                error1();
                break;
            case 2:
                error2();
                break;
            case 3:
                error3();
                break;
            case 4:
                error4();
                break;
            case 5:
                error5();
                break;
            case 6:
                error6();
                break;
            case 7:
                error7();
                break;
            case 8:
                error8();
                break;
            case 9:
                error9();
                break;
        }
    }

    private void error1(){
        line5 = "    ______";
    }

    private void error2(){
        line2 = "    |";
        line3 = "    |";
        line4 = "    |";
        line5 = "    |______";
    }

    private void error3(){
        line1 = "     ____";
        line2 = "    |   |";
    }

    private void error4(){
        line2 = "    |   |O";
    }

    private void error5(){
        line3 = "    |    |";
    }

    private void error6(){
        line3 = "    |   /|";
    }

    private void error7(){
        line3 = "    |   /|\\";
    }

    private void error8(){
        line4 = "    |   /";
    }

    private void error9(){
        line4 = "    |   / \\";
    }
}
