package module7;

public class PunctuationMarkCounterTest {
    public static void main(String[] args) {
        PunctuationMarkCounter counter = new PunctuationMarkCounter();

        //2
        System.out.println(counter.count("Hello, world!"));

        //1
        System.out.println(counter.count("This is Sparta!"));

        //1
        System.out.println(counter.count("End."));
    }
}

class PunctuationMarkCounter {
    public int count(String phrase) {
        int result = 0;
        String[] marks = phrase.split("");
        for (String mark : marks) {
            if (mark.equals(".") || mark.equals(",") || mark.equals("!") || mark.equals(":") || mark.equals(";")) {
                result++;
            }
        }
        return result;
    }
}
