package com.pbilton.HangMan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {
    private String selection;
    private int random;

    public void setSelection(String category){
        String[] sourceLine = setFile(category);
        selection = randomSelection(sourceLine);
    }

    private String[] setFile(String category){                             //will add more categories soon
        final String dir = System.getProperty("user.dir");
        File fileSet = null;
        if (category.equals("movies")) {
              fileSet = new File(dir + "\\movieSelection");
        }
        else if (category.equals("actors"))
            fileSet = new File(dir + "\\actorsSelection");
        return readFile(fileSet);
    }

    private String[] readFile(File file) {
        List<String> lines = new ArrayList<String>();
        String[] source = new String[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = reader.readLine()) != null)
                lines.add(st);
            source = lines.toArray(new String[]{});
        } catch (FileNotFoundException e) {
            System.out.println(file + " file not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

    private String randomSelection(String[] sourceLines) {
        random = new Random().nextInt(sourceLines.length);
        return sourceLines[random].toUpperCase();
    }

    public char[] getAnswer() {
        return selection.split("-")[0].trim().toCharArray();
    }

    public String getHint() {
        return selection.split("-")[1].trim();

    }
}
