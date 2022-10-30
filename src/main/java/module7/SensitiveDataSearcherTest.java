package module7;

import java.util.Arrays;

public class SensitiveDataSearcherTest {
    public static void main(String[] args) {
        SensitiveDataSearcher searcher = new SensitiveDataSearcher();

        //false
        System.out.println(searcher.isSensitiveDataPresent("Hello world"));

        //true
        System.out.println(searcher.isSensitiveDataPresent("Pass: swordfish"));
    }
}

class SensitiveDataSearcher {
    public boolean isSensitiveDataPresent(String phrase) {
        String[] sensitiveData = {"pass", "key", "login", "email"};
        String[] tempArr = phrase.split("\\W");

        for (String data : sensitiveData) {
            for (String str: tempArr) {
                if (data.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
