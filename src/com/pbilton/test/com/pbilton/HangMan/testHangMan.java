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
        Game game = new Game(testAnswer,"ARNIE");
        Assertions.assertTrue(game.validateInput('E'));
        Assertions.assertTrue(game.validateInput('R'));
        Assertions.assertTrue(game.validateInput('T'));
        Assertions.assertFalse(game.validateInput('!'));
        Assertions.assertFalse(game.validateInput('='));
    }

    @Test
    public void testCompare() {
        char[] testAnswer = "The Dark Knight".toUpperCase().toCharArray();
        Game game = new Game(testAnswer,"Bat");
        Assertions.assertTrue(game.compareToAnswer('D'));
        Assertions.assertTrue(game.compareToAnswer('A'));
        Assertions.assertFalse(game.compareToAnswer('£'));
        Assertions.assertFalse(game.compareToAnswer('Q'));
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
