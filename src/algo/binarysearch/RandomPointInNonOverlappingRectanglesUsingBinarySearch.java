package algo.binarysearch;

import java.util.Arrays;
import java.util.Random;

public class RandomPointInNonOverlappingRectanglesUsingBinarySearch {

    private int[] accumulatedArea;
    private int[][] rects;
    private Random r;

    public RandomPointInNonOverlappingRectanglesUsingBinarySearch(int[][] rects) {
        r = new Random();
        this.rects = rects;
        accumulatedArea = new int[rects.length];
        
        for (int i = 0; i < rects.length; i++) {
            int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            accumulatedArea[i] = (i == 0) ? area : area + accumulatedArea[i - 1];
        }
    }

    public int[] pick() {
        int target = 1 + r.nextInt(accumulatedArea[accumulatedArea.length - 1]);
        int i = Arrays.binarySearch(accumulatedArea, target);
        if (i < 0) {
            i = -(i+1);
        }
        int[] rect = rects[i];
        int x = rect[0] + r.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + r.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }

}
