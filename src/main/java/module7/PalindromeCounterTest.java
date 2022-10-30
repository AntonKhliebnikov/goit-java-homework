package module7;

public class PalindromeCounterTest {
    public static void main(String[] args) {
        PalindromeCounter counter = new PalindromeCounter();

        //1
        System.out.println(counter.count("Level done!"));

        //0
        System.out.println(counter.count("No palindromes"));
    }
}

class PalindromeCounter {
    public int count(String phrase) {
        int result = 0;
        String[] words = phrase.split(" ");
        String str = "";

        for (String word: words) {
            StringBuilder palindrom = new StringBuilder(word);
            palindrom.reverse();
            str = palindrom.toString();
            if (str.equalsIgnoreCase(word)) {
                result++;
            }
        }
        return result;
    }
}
