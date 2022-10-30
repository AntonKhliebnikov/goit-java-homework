package module7;

public class DoubleSpaceCleanerTest {
    public static void main(String[] args) {
        DoubleSpaceCleaner cleaner = new DoubleSpaceCleaner();

        //Hello World
        System.out.println(cleaner.clean("Hello World"));

        //Hello World
        System.out.println(cleaner.clean("       Hello              World          "));
    }
}

class DoubleSpaceCleaner {
    public String clean(String phrase) {
        String[] words = phrase.split(" ");
        String tempStr = "";
        for (String word : words) {
            if (!word.equals("")) {
                tempStr += word + " ";
            }
        }
        return tempStr.trim();
    }
}