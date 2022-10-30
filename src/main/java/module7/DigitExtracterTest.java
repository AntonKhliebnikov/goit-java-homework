package module7;

import java.util.Arrays;

public class DigitExtracterTest {
    public static void main(String[] args) {
        DigitExtracter digitExtracter = new DigitExtracter();

        int[] extracted = digitExtracter.extract("april 5, year 2000");

        //[5, 2, 0, 0, 0]
        System.out.println(Arrays.toString(extracted));
    }
}

class DigitExtracter {
    public int[] extract(String text) {
        String[] elements = text.split("\\D");
        String str = "";

        for (String element : elements) {
            if (!element.equals("")) {
                str += element;
            }
        }

        String[] strArr = str.split("");
        int[] result = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            result[i] = Integer.parseInt(strArr[i]);
        }
        return result;
    }
}
