package module7;

import java.util.Locale;

public class NameCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new NameCounter().count("Mars is great planet"));

        //2
        System.out.println(new NameCounter().count("Moon is near Earth"));

        //0
        System.out.println(new NameCounter().count("SPACE IS GREAT"));
    }
}

class NameCounter {
    public int count(String text) {
        int result = 0;
        String[] words = text.split(" ");
        for (String word: words) {
            if (word.length() >= 2) {
                String[] letters = word.split("");
                for (int i = 0; i < letters.length - 1; i++) {
                    if (letters[i].equals(letters[i].toUpperCase()) &&
                            (letters[i + 1].equals(letters[i + 1].toLowerCase()))) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
