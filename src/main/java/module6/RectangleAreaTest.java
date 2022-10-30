package module6;

public class RectangleAreaTest {
    public static void main(String[] args) {
        int[] coords = {2, 2, 12, 12};

        //Expect 100
        System.out.println(new RectangleArea(coords).getArea());
    }
}

class RectangleArea {
    private final int[] coords;

    public RectangleArea(int[] coords) {
        this.coords = coords;
    }

    public int getArea() {
        return Math.abs(coords[0] - coords[2]) * Math.abs(coords[1] - coords[3]);
    }
}
