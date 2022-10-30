package module7;

public class AvgWordLengthTest {
    public static void main(String[] args) {
        //6
        System.out.println(new AvgWordLength().count("Launch Rocket"));

        //4.5
        System.out.println(new AvgWordLength().count("Life is strange thing"));
    }
}

class AvgWordLength {
    public double count(String phrase) {
        double avgResult;
        double allWordsLength = 0.0;
        String[] words = phrase.split(" ");
        for (String word: words) {
           allWordsLength += word.length();
        }
        avgResult = allWordsLength / words.length;
        return avgResult;
    }
}
