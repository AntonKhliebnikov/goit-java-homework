package module7;

public class WaterCounterTest {
    public static void main(String[] args) {
        //0.07692307692307693
        System.out.println(new WaterCounter().count("Moon invaders"));

        //0
        System.out.println(new WaterCounter().count("NoWater"));
    }
}

class WaterCounter {
    public double count(String text) {
        double countSpace = 0.0;
        String[] words = text.split("");
        for (String word: words) {
            if (word.equals(" ")) {
                countSpace++;
            }
        }
        return countSpace / text.length();
    }
}
