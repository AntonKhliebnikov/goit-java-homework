package module7;

import java.util.Arrays;

public class SummaryCreatorTest {
    public static void main(String[] args) {
        SummaryCreator summaryCreator = new SummaryCreator();

        //Mars
        String shortPhrase = "bomiezjumuhevui tuigwakap";
        System.out.println(summaryCreator.create(shortPhrase));

        //Java is very po...
        String longPhrase = "Java is very popular language";
        System.out.println(summaryCreator.create(longPhrase));
    }
}

class SummaryCreator {
    public String create(String text) {
        String[] arr = text.split("");
        StringBuilder result = new StringBuilder();
        if (text.length() >= 16 && (!arr[15].equals(" "))) {
            arr = Arrays.copyOf(arr, 15);
            for (String str: arr) {
                result.append(str);
            }
            return result + "...";
        } else if (text.length() >= 16) {
            arr = Arrays.copyOf(arr, 15);
            for (String str: arr) {
                result.append(str);
            }
            return result.toString();
        }
        return text;
    }
}
