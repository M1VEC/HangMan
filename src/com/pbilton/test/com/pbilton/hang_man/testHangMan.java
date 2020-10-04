package com.pbilton.hang_man;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testHangMan {
    private String category = "movies";
    Selection movie = new Selection(category);

    @Test
    public void testAnswer() {
        movie.setSelection();
        System.out.println(movie.getAnswer());
    }

    @Test
    public void testHint() {
        movie.setSelection();
        System.out.println(movie.getHint());
    }

    @Test
    public void testDraw(){
    DrawHangMan.printMan(5);
    }
}
