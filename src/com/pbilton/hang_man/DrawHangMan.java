package com.pbilton.hang_man;

public class DrawHangMan {

    public void printMan(int n){
        if (n == 1)
            error1();
        else if (n == 2)
            error2();
        else if (n == 3)
            error3();
        else if (n == 4)
            error4();
        else if (n == 5)
            error5();
        else if (n == 6)
            error6();
        else if (n == 7)
            error7();
        else if (n == 8)
            error8();
        else if (n == 9)
            error9();
        else if (n == 10)
            error10();
        else if (n == 11)
            error11();
    }

    private void error1(){
        System.out.println("   ______");
    }

    private void error2(){
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error3(){
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error4(){
        System.out.println("   ____");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error5(){
        System.out.println("   ____");
        System.out.println("  |   |");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error6(){
        System.out.println("   ____");
        System.out.println("  |   |O");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error7(){
        System.out.println("   ____");
        System.out.println("  |   |O");
        System.out.println("  |    |");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error8(){
        System.out.println("   ____");
        System.out.println("  |   |O");
        System.out.println("  |   /|");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error9(){
        System.out.println("   ____");
        System.out.println("  |   |O");
        System.out.println("  |   /|\\");
        System.out.println("  |");
        System.out.println("  |______");
    }

    private void error10(){
        System.out.println("   ____");
        System.out.println("  |   |O");
        System.out.println("  |   /|\\");
        System.out.println("  |   /");
        System.out.println("  |______");
    }

    private void error11(){
        System.out.println("   ____");
        System.out.println("  |   |O");
        System.out.println("  |   /|\\");
        System.out.println("  |   / \\");
        System.out.println("  |______");
    }
}
