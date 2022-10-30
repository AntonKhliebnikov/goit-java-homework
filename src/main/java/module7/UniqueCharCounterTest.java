package module7;

public class UniqueCharCounterTest {
    public static void main(String[] args) {
        UniqueCharCounter charCounter = new UniqueCharCounter();

        //3
        System.out.println(charCounter.count("123"));

        //4
        System.out.println(charCounter.count("ab100"));

        //3
        System.out.println(charCounter.count("Java"));
    }
}

class UniqueCharCounter {
    public int count(String phrase) {
        int result = 0;
        int tempCount = 0;
        char[] symbols = phrase.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            result++;
            for (int j = i + 1; j < symbols.length; j++) {
                if (symbols[j] == symbols[i]) {
                    tempCount++;
                    break;
                }
            }
        }
        return result - tempCount;
    }
}
