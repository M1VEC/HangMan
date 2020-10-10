package com.pbilton.HangMan;

public class DrawHangMan {
    private static String line1 = "";
    private static String line2 = "";
    private static String line3 = "";
    private static String line4 = "";
    private static String line5 = "";

    public static void printMan(int n){
        System.out.println();
        System.out.println("****************************");
        System.out.println("    Incorrect Guess");

        lines(n);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println("****************************");
    }

    private static void lines(int n){
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

    private static void error1(){
        line5 = "    ______";
    }

    private static void error2(){
        line2 = "    |";
        line3 = "    |";
        line4 = "    |";
        line5 = "    |______";
    }

    private static void error3(){
        line1 = "     ____";
        line2 = "    |   |";
    }

    private static void error4(){
        line2 = "    |   |O";
    }

    private static void error5(){
        line3 = "    |    |";
    }

    private static void error6(){
        line3 = "    |   /|";
    }

    private static void error7(){
        line3 = "    |   /|\\";
    }

    private static void error8(){
        line4 = "    |   /";
    }

    private static void error9(){
        line4 = "    |   / \\";
    }
}
