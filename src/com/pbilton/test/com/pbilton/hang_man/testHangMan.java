package com.pbilton.hang_man;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testHangMan {
    Selection movie = new Selection();

    @Test
    public void testList() throws IOException {
        System.out.println(movie.getSelection());
    }

}
