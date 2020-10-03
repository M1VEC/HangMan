package com.pbilton.hang_man;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {
    private static String movie = "C:\\Users\\phili\\IdeaProjects\\hang_man\\movieSelection";
    private static File file = new File(movie);
    private String[] source;
    private String selection;

    private void filelist() throws IOException {
        List<String> lines = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
            String st;

            while((st = reader.readLine()) != null)
                lines.add(st);
            reader.close();
            source = lines.toArray(new String[]{});
    }

    private String randomSelection() throws IOException {
        filelist();
        int random = new Random().nextInt(source.length);
        selection = source[random];
        return selection;
    }

    public String getSelection() throws IOException {
        return randomSelection();
    }
}
