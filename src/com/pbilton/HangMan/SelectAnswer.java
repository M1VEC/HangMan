package com.pbilton.HangMan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectAnswer {
    private String selection;
    private int random;
    private File fileSet = null;

    public void setAnswer(String category){
        if(setFile(category)) {
            String[] sourceLine = readFile(fileSet);
            selection = randomLines(sourceLine);
        }
    }

    private boolean setFile(String category){
        final String dir = System.getProperty("user.dir");
        if (category.equals("movies")) {
              fileSet = new File(dir + "\\movieSelection");
              return true;
        }
        else if (category.equals("actors")) {
            fileSet = new File(dir + "\\actorsSelection");
            return true;
        }
        else return false;
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
