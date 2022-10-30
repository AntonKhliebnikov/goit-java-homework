package module7;

public class WordCombineTest {
    public static void main(String[] args) {
        //true
        System.out.println(new WordCombine().canCombine("Forest", "tor"));

        //true
        System.out.println(new WordCombine().canCombine("Magic", "Mama"));

        //false
        System.out.println(new WordCombine().canCombine("War", "Piece"));
    }
}

class WordCombine {
    public boolean canCombine(String sourceWord, String targetWord) {
        String[] letters = targetWord.toLowerCase().split("");
        for (String letter: letters) {
            if (sourceWord.contains(letter.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
