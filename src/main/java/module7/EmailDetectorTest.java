package module7;

public class EmailDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new EmailDetector().isPresent("This email is no-reply@goo.com"));

        //false
        System.out.println(new EmailDetector().isPresent("No email present, but @ there"));
    }
}

class EmailDetector {
    public boolean isPresent(String text) {
        String[] words = text.split(" ");
        for (String word: words) {
            if (word.contains("@") && word.length() >= 5) {
                return true;
            }
        }
        return false;
    }
}
