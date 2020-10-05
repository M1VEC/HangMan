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
    private static String answer;
    private static String hint;

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
        int random = new Random().nextInt(setFile().length);
        selection = source[random];

        String[] split = selection.split("-");
        answer = split[0].trim();
        hint = split[1].trim();
    }

    public void setSelection(){
        randomSelection();
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }
}
