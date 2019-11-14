package algo.binarysearch;

import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangles {

	/**
     * @param areaSum: accumulate sum of every rectangles
     * @param treeMap: store current rectangle area sum as key, current rectangle index as value
     * @param rand: random seed, in order to random an integer number between 0 and total area sum
     * @param myRects: store original rects array, for the pick() function
     * */
    TreeMap<Integer, Integer> treeMap;
    Random rand;
    int areaSum;
    int[][] myRects;

    /**
     * The core strategy is that we pick a rectangle randomly, and then pick a point from that rectangle randomly.
     * Step 1: We can calculate area of each rectangle, and then accumulate their areas, put into the treeMap with
     * corresponding index.
     * Step 2: pick a random number from 0 to total areaSum, and then use binary search to find the position of rectangle
     * with random areaSum (by using treeMap to find ceilingKey, we can do it in O(lgn) time)
     * Step 3: after picking a random rectangle, we can randomly pick a point by randomly picking its x value and y value 
     * in the picked rectangle
     * */
    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        treeMap = new TreeMap<>();
        rand = new Random();
        myRects = rects;

        /* add weight for each rectangle by their area
           WARNING: we need to add 1 for every length and width, because number of points if one greater then value of size
           eg: if len = 2, then there exist max number of points = 3 on this line */
        int rectIndex = 0;
        for (int[] rect : rects) {
            areaSum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            treeMap.put(areaSum, rectIndex);
            rectIndex++;
        }
    }

    /* pick a rectangle, and then pick a point in this rectangle */
    public int[] pick() {
        // ceilingKey returns the least key greater than or equal to the given key, or null if there is no such key. 
        // WARNING: since nextInt() API is open bracket for the right bound, we need to add 1 for areaSum 
        int randomNum = treeMap.ceilingKey(rand.nextInt(areaSum + 1));
        int[] curRect = myRects[treeMap.get(randomNum)];
        int leftBound = curRect[0];
        int rightBound = curRect[2];
        int bottomBound = curRect[1];
        int topBound = curRect[3];

        // calculate the range of length and range of width, and then random pick an x value and a y value in the range 
        int pointX = leftBound + rand.nextInt(rightBound - leftBound + 1);
        int pointY = bottomBound + rand.nextInt(topBound - bottomBound + 1);
        return new int[]{pointX, pointY};
    }
	
}

