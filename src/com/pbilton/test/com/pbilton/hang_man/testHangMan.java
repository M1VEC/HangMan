package com.pbilton.hang_man;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testHangMan {
    private String category = "movies";
    Selection movie = new Selection(category);

    @Test
    public void testList() {
        System.out.println(movie.getSelection());
    }

    @Test
    public void testDraw(){
    DrawHangMan.printMan(5);
    }
}
