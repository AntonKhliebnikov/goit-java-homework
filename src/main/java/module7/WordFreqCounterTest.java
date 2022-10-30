package module7;

public class WordFreqCounterTest {
    public static void main(String[] args) {
        WordFreqCounter freqCounter = new WordFreqCounter();

        //0.5
        System.out.println(freqCounter.countFreq("Hello Java", "Java"));

        //0
        System.out.println(freqCounter.countFreq("Hello World", "java"));
    }
}

class WordFreqCounter {
    public float countFreq(String phrase, String word) {
        float countWord = 0;
        String[] words = phrase.toLowerCase().split(" ");
        float phraseLength = words.length;

        for (String tempWord : words) {
            if (tempWord.equals(word.toLowerCase())) {
                countWord++;
            }
        }
        return countWord / phraseLength;
    }
}
