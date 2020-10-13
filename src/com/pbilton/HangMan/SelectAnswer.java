package com.pbilton.HangMan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectAnswer {
    private String selection;
    private int random;
    final String dir = System.getProperty("user.dir");
    private String[] sourceFile = new String[0];

    public boolean setAnswer(String category){
        if(setFile(category)) {
            selection = randomLines(sourceFile);
            return true;
        }
        return false;
    }

    private boolean setFile(String category){
        File fileSet = new File(dir + "\\Category" + "\\" + category);
        return readFile(fileSet);
    }

    private boolean readFile(File file) {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = reader.readLine()) != null)
                lines.add(st);
            sourceFile = lines.toArray(new String[]{});
        } catch (FileNotFoundException e) {
            System.out.println(file + " file not found!");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String randomLines(String[] sourceLines) {
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
