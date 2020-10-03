package com.pbilton.hang_man;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testHangMan {
    Selection movie = new Selection();
    DrawHangMan draw = new DrawHangMan();

    @Test
    public void testList() throws IOException {
        System.out.println(movie.getSelection());
    }

    @Test
    public void testDraw(){
    draw.printMan(5);
    }
}
