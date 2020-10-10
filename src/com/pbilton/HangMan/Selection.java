package com.pbilton.HangMan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {
    private final String category;
    private String[] source;
    private String selection;
    private File file;
    private static char[] answer;
    private static char[] hint;
    private int random;

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

    private void randomSelection() {
        random = new Random().nextInt(setFile().length);
        selection = source[random].toUpperCase();

        String[] separateSelection = selection.split("-");
        answer = separateSelection[0].trim().toCharArray();
        hint = separateSelection[1].trim().toCharArray();
    }

    public void setSelection(){
        randomSelection();
    }

    public char[] getAnswer() {
        return answer;
    }

    public char[] getHint() {
        return hint;
    }
}
