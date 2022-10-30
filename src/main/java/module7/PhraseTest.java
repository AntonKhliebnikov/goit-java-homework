package module7;

import java.util.Arrays;

public class PhraseTest {
    public static void main(String[] args) {
        String[] words = {"alpha", "beta", "gamma"};

        Phrase phrase = new Phrase(words);

        //alpha beta gamma
        System.out.println(phrase);

        words[0] = "zero";

        //alpha beta gamma
        System.out.println(phrase);
    }
}

class Phrase {
    private final String[] words;

    public Phrase(String[] words) {
        this.words = Arrays.copyOf(words, words.length);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i] + " ";
        }
        return result;
    }
}
