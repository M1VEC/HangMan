package com.pbilton.HangMan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testHangMan {
    SelectAnswer selectAnswer = new SelectAnswer();
    DrawHangMan drawHangMan = new DrawHangMan();

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
    drawHangMan.printMan(5);
    }

    @Test
    public void testFileTrue(){
        Assertions.assertTrue(selectAnswer.setAnswer("movies"));
        Assertions.assertTrue(selectAnswer.setAnswer("actors"));
    }

    @Test
    public void testFileFalse(){
        Assertions.assertFalse(selectAnswer.setAnswer("movie"));
        Assertions.assertFalse(selectAnswer.setAnswer("actor"));
    }
}
