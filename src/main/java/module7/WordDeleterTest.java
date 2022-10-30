package module7;

import java.util.Arrays;

public class WordDeleterTest {
    public static void main(String[] args) {
        WordDeleter wordDeleter = new WordDeleter();

        //Hello
        System.out.println(wordDeleter.remove("mynopybi coe lutoekj taizdop lutoekj lutoekj",
                new String[]{"coe"}));

        //This Sparta
        System.out.println(wordDeleter.remove("This is Sparta", new String[]{"is"}));
    }
}

class WordDeleter {
    public String remove(String phrase, String[] words) {
        String[] tempArr = phrase.split(" ");

        for (String word : words) {
            for (int i = 0; i < tempArr.length; i++) {
                if (tempArr[i].equalsIgnoreCase(word)) {
                    tempArr[i] = "";
                    tempArr = Arrays.copyOf(tempArr, tempArr.length);
                }
            }
        }

        System.out.println(Arrays.toString(tempArr));
        String result = "";
        for (String str : tempArr) {
            if (!str.equals("")) {
                result += str + " ";
                ;
            }
        }

        return result.trim();
    }
}
