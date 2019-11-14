package array;

public class LargestRectangleInHistogram {
	
	public static int largestRectangleArea(int[] heights) {
		if(heights.length==0){
			return 0;
		}
		return Math.max(rectangleArea(heights,1,heights.length,heights[0],0, true), 
				rectangleArea(heights,heights.length-2,0,heights[heights.length-1],heights.length-1, false));
    }

	private static int rectangleArea(int[] heights, int start, int end, int prevElement,int pointer, boolean leftArea) {
		int prevArea = prevElement;
		int j=pointer, currMin = prevElement, currArea=0,areaExcludingPrevElements=0;
		if(leftArea) {
			for(int i=start; i<end; i++) {
				currMin = Math.min(heights[i], currMin);
				currArea = currMin*((i-j)+1);
				if(currArea>=prevArea) {
					prevArea=currArea;
				}
				areaExcludingPrevElements = heights[i]*1;
				if(areaExcludingPrevElements>prevArea) {
					prevArea = areaExcludingPrevElements;
					j=i;
					currMin = heights[i];
				}
			}
		}
		else {
			for(int i=start; i>=end; i--) {
				currMin = Math.min(heights[i], currMin);
				currArea = currMin*((j-i)+1);
				if(currArea>=prevArea) {
					prevArea=currArea;
				}
				areaExcludingPrevElements = heights[i]*1;
				if(areaExcludingPrevElements>prevArea) {
					prevArea = areaExcludingPrevElements;
					j=i;
					currMin = heights[i];
				}
			}
		}
		return prevArea;
		}
		
		
	
	public static void main(String[] args) {
		//int heights[] = {2,1,5,6,2,3};
		//int heights[] = {1,2,3,4,5};
		int heights[] = {1,3,2,1,2,1};
		System.out.println(largestRectangleArea(heights));
	}

}
