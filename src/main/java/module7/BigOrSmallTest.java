package module7;

public class BigOrSmallTest {
    public static void main(String[] args) {
        //Small
        System.out.println(new BigOrSmall().calculate("Java"));

        //Big
        System.out.println(new BigOrSmall().calculate("JAVA"));

        //Same
        System.out.println(new BigOrSmall().calculate("jAvA"));
    }
}

class BigOrSmall {
    public String calculate(String text) {
        int countOfSmallLetters = 0;
        int countOfBigLetters = 0;
        String[] letters = text.split("");
        for (String letter : letters) {
            if (letter.equals(letter.toLowerCase())) {
                countOfSmallLetters++;
            } else {
                countOfBigLetters++;
            }

        }

        if (countOfSmallLetters > countOfBigLetters) {
            return "Small";
        } else if (countOfBigLetters > countOfSmallLetters) {
            return "Big";
        } else {
            return "Same";
        }
    }
}
