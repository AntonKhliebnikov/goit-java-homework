package module7;

public class MathDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new MathDetector().isMath("2+2=4"));

        //false
        System.out.println(new MathDetector().isMath("1992 is great year"));

        //false
        System.out.println(new MathDetector().isMath("Venus vs Earth"));
    }
}

class MathDetector {
    public boolean isMath(String text) {
        return text.contains("=") || text.contains("+") || text.contains("-") || text.contains("*") || text.contains("/")
                || text.contains("{2}, \\d");
    }
}
