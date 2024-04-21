import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        String line = new String();
        File myFile = new File("input.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(myFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            line = new String(buffer, 0, bytesRead);
            System.out.println(line);
            System.out.println();
        }
        inputStream.close();

        String[] text = new String[] {};
        text = line.split("\\s+");

        Map<String, Integer> length = new HashMap<>();
        for (String i : text) {
            length.putIfAbsent(i, i.length());
        }
        ArrayList<Integer> valueList = new ArrayList<>(length.values());
        Integer maxLength = Collections.max(valueList);
        String maxWord = null;
        for (String i : text) {
            if (i.length() == maxLength)
                maxWord = i;
        }

        Map<String, Integer> time = new HashMap<>();
        for (String i : text) {
            if (time.containsKey(i)) {
                time.put(i, time.get(i) + 1);
            } else {
                time.put(i, 1);
            }
        }
        ArrayList<Integer> valueList2 = new ArrayList<>(time.values());
        Integer timesWord = Collections.max(valueList2);
        String timeWords = null;
        for (var item : time.entrySet()) {
            if (item.getValue() == timesWord)
                timeWords = item.getKey();
        }

        System.out.println("Мы взяли с собой на пикник фрукты и овощи:" + text.length +
                "\nСамое длинное название фрукта (овоща):" + maxWord + ". \n" +
                "Наибольшее количество кусочков фруктов (овощей), которые у нас есть " + timeWords);
    }
}