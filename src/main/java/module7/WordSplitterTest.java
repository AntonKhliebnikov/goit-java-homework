package module7;

import java.util.Arrays;

public class WordSplitterTest {
    public static void main(String[] args) {
        WordSplitter wordSplitter = new WordSplitter();

        String[] words = wordSplitter.split("Hello      world");

        //[hello, world]
        System.out.println(Arrays.toString(words));
    }
}

class WordSplitter {
    public String[] split(String phrase) {
        String[] words = phrase.toLowerCase().split(" ");
        String tempStr = "";
        for (String word : words) {
            if (!word.equals("")) {
                tempStr += word + " ";
            }
        }

        return tempStr.split( " ");
    }
}
