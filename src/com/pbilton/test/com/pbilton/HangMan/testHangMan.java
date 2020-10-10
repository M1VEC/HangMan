package com.pbilton.HangMan;

import org.junit.jupiter.api.Test;

public class testHangMan {
    private String category = "movies";
    SelectAnswer selectAnswer = new SelectAnswer();

    @Test
    public void testAnswer() {
        selectAnswer.setAnswer("movies");
        System.out.println(selectAnswer.getAnswer());
    }

    @Test
    public void testHint() {
        selectAnswer.setAnswer("actors");
        System.out.println(selectAnswer.getHint());
    }

    @Test
    public void testDraw(){
    DrawHangMan.printMan(5);
    }

    @Test
    public void testValidate(){

    }
}
