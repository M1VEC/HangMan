package com.pbilton.HangMan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testHangMan {
    SelectAnswer selectAnswer = new SelectAnswer();

    @Test
    public void testAnswer() {
        selectAnswer.setAnswer("movies");
        System.out.println(selectAnswer.getAnswer());
    }

    @Test
    public void testValidateInput() {
        char[] testAnswer = "terminator".toUpperCase().toCharArray();
        GameOld game = new GameOld(testAnswer,"ARNIE");
        Assertions.assertTrue(game.getValidInput('E'));
        Assertions.assertTrue(game.getValidInput('R'));
        Assertions.assertTrue(game.getValidInput('T'));
        Assertions.assertFalse(game.getValidInput('!'));
        Assertions.assertFalse(game.getValidInput('='));
    }

    @Test
    public void testCompare() {
        char[] testAnswer = "The Dark Knight".toUpperCase().toCharArray();
        GameOld game = new GameOld(testAnswer,"Bat");
        Assertions.assertTrue(game.getCompareToAnswer('D'));
        Assertions.assertTrue(game.getCompareToAnswer('A'));
        Assertions.assertFalse(game.getCompareToAnswer('£'));
        Assertions.assertFalse(game.getCompareToAnswer('Q'));
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
