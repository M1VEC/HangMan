package com.pbilton.hang_man;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {
    private final String category;
    private String[] source;
    private String selection;
    private File file;

    public Selection(String category) {
        this.category = category;
    }

    private String[] setFile(){
        final String dir = System.getProperty("user.dir");
        if (category.equals("movies")) {
            file = new File(dir + "\\movieSelection");
        }
        return readFile();
    }

    private String[] readFile()  {
        List<String> lines = new ArrayList<String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String st;
            while ((st = reader.readLine()) != null)
                lines.add(st);
            reader.close();
            source = lines.toArray(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

    private String randomSelection() {
        int random = new Random().nextInt(setFile().length);
        selection = source[random];
        return selection;
    }

    public String getSelection() {
        return randomSelection();
    }
}
