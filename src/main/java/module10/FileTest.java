package module10;

import java.io.*;
import java.util.*;

public class FileTest {
    public static void main(String[] args) {
//        File file = new File("phonenumber.txt");
        File file = new File("word.txt");

        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
//            validatePhoneNumber(scanner);
            frequencyOfEachWord(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // Task1
    public static void validatePhoneNumber(Scanner scanner) {
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.matches("^(\\(?\\d{3}\\)?[\\s-]\\d{3}[-]\\d{4}$)")) {
                System.out.println(s);
            }
        }
    }

    // Task3
    public static void frequencyOfEachWord(Scanner scanner) {
        Map<String, Integer> words = new HashMap<>();
        StringBuilder text = new StringBuilder();
        int value = 0;
        while (scanner.hasNext()) {
            text.append(scanner.nextLine()).append("\s");
        }

        String[] data = text.toString().split(" ");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j].equals(data[i])) {
                    value++;
                    break;
                }
            }

            String word = data[i];
            Integer amount = value;
            if (!words.containsKey(word)) {
                words.put(word, amount);
            } else {
                words.put(word, words.get(word) + amount);
            }
            value = 0;
        }


        Comparator<String> comparator = (o1, o2) -> words.get(o1) < words.get(o2) ? 1 : -1;
        Map<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(words);
        System.out.println("treeMap = " + treeMap);
    }
}
