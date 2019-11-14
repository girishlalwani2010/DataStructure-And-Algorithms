package algo.binarysearch;

/**
 * @author girish_lalwani
 *
 *Intuitively, we would expand from the given 1 * 1 black cell, "aggressively" expand to the 4 boundaries, roughly half of the remaining space. If we don't "cut" any black pixel, we know we go too far and should go back half.

This is exactly the process of binary search.

One simple way without any worry about boundary, is as follows:

Use a vertical line, to jump to the leftmost black pixel , in the range of [0, y]
Use a vertical line, to jump to the rightmost black pixel, in the range of [y, n - 1]
Use a horizontal line, to jump to the topmost black pixel, in the range of [0, x]
Use a horizontal line, to jump to the bottommost black pixel, in the range of [x, m - 1]
 *
 */
public class SmallestRectangleEnclosingBlackPixels {
	
	public int minArea(char[][] image, int x, int y) {
	    int left = leftmost(image, 0, y, true);
	    int right = rightmost(image, y, image[0].length - 1, true);
	    int top = leftmost(image, 0, x, false);
	    int bottom = rightmost(image, x, image.length - 1, false);
	    return (right - left + 1) * (bottom - top + 1);
	}

	int leftmost(char[][] image, int min, int max, boolean horizontal) {
		 int l = min, r = max;
		    while (l < r) {
		    	//here we have to check element left of mid is 1 or not as mid in the start is already one
		        int mid = l + (r-l) / 2;
		        if (!hasBlack(image, mid, horizontal)) {
		            l = mid + 1;
		        } else {
		        	//including mid as it could be the first one. 
		            r = mid;
		        }
		    }
		    return l;
	}

	int rightmost(char[][] image, int min, int max, boolean horizontal) {
		 int l = min, r = max;
		    while (l < r) {
		    	//here we have to check element right of mid is 1 or not as mid in the start is already one if we apply this l + (r-l) / 2, and then this will go in infinite looping
		        int mid = l + (r-l) / 2 + 1;
		        if (hasBlack(image, mid, horizontal)) {
		        	//including mid as it could be the last one. 
		            l = mid;
		        } else {
		            r = mid - 1;
		        }
		    }
		    return l;
	}

	boolean hasBlack(char[][] image, int mid, boolean horizontal) {
	    if (horizontal) {
	        for (int i = 0; i < image.length; i++) {
	            if (image[i][mid] == '1') {
	                return true;
	            }
	        }
	    } else {
	        for (int j = 0; j < image[0].length; j++) {
	            if (image[mid][j] == '1') {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		char [][]image = {{'0','0','1','0'},
						  {'0','1','1','0'},
		                  {'0','1','0','0'}};
		SmallestRectangleEnclosingBlackPixels smalestRect = new SmallestRectangleEnclosingBlackPixels();
		System.out.println(smalestRect.minArea(image,0,2));
	}

}
