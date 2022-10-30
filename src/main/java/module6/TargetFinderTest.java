package module6;

import java.util.Arrays;

public class TargetFinderTest {
    public static void main(String[] args) {
        int[] aiCoords = {10, 10};
        int[][] targets = {
                {20, 20},
                {15, 14},
                {30, 5}
        };

        TargetFinder targetFinder = new TargetFinder();
        int[] nearestTarget = targetFinder.findTarget(aiCoords, targets);

        //Expect [15, 14]
        System.out.println(Arrays.toString(nearestTarget));
    }
}

class TargetFinder {

    public int[] findTarget(int[] aiCoords, int[][] targets) {
        int distanceToNearestTarget = 0;
        int temp = 0;
        int[] closestTargetCoordinates = new int[aiCoords.length];


        for (int i = 0; i < aiCoords.length - 1; i++) {
            for (int j = 0; j < targets.length; j++) {
                for (int k = 0; k < targets[j].length - 1; k++) {
                    distanceToNearestTarget = Math.toIntExact((long) Math.sqrt((targets[j][k + 1] - aiCoords[i + 1]) * (targets[j][k + 1] - aiCoords[i + 1]) +
                            (targets[j][k] - aiCoords[i]) * (targets[j][k] - aiCoords[i])));

                    if (distanceToNearestTarget > temp) {
                        temp = distanceToNearestTarget;

                    } else {
                        closestTargetCoordinates = Arrays.copyOf(targets[j], aiCoords.length);
                    }
                }
            }
        }
        return closestTargetCoordinates;
    }
}

