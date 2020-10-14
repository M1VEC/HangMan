package com.pbilton.HangMan;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelectAnswer extends UserInteraction{
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
            displayMessage("\n" + file + " file not found!");
            return false;
        } catch (IOException e) {
            displayMessage("\nAn unexpected error occurred");
        }
        return true;
    }

    private String randomLines(String[] sourceLines) {
        random = new Random().nextInt(sourceLines.length);
        return sourceLines[random].toUpperCase();
    }

    private List<String> categoryFileList(){
        File folder = new File(dir + "\\Category");
        List<String> categoryList = null;
        try (Stream<Path> list = Files.list(Paths.get(String.valueOf(folder)))) {
            categoryList = list.filter(path->path.toFile().isFile())
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            displayMessage("\nno files found!");
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<String> getCategoryList() {
        return categoryFileList();
    }

    public char[] getAnswer() {
        return selection.split("-")[0].trim().toCharArray();
    }

    public String getHint() {
        return selection.split("-")[1].trim();
    }
}
