package dp;

import java.util.Arrays;
import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
	
	/**
	 * @param heights
	 * @return
	 * 
	 * calculate area for each bar, by finding leftclosest min to it and rightclosestmin to it then difference of both is the breadth and multiply that with height of bar.
	 * 
	 */
	public static int largestRectangleAreaInO3NSpace(int[] heights) {
		if(heights.length==0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int[] rightMin = new int[heights.length];
		Arrays.fill(rightMin,heights.length);
		int[] leftMin = new int[heights.length];
		Arrays.fill(leftMin, 0);
		int i=1;
		while(i<heights.length) {
			if(heights[i]>=heights[stack.peek()]) {
				stack.push(i++);
			}else {
				rightMin[stack.pop()] = i;
				if(stack.isEmpty())
					stack.push(i++);
			}
			
		}
		stack = new Stack<Integer>();
		stack.push(heights.length-1);
		i=heights.length-2;
		while(i>=0) {
			if(heights[i]>=heights[stack.peek()]) {
				stack.push(i--);
			}else {
				leftMin[stack.pop()] = i;
				if(stack.isEmpty())
					stack.push(i--);
			}
		}
		int maxArea=0;
		for(i=0; i<heights.length; i++) {
			int area = heights[i]*(rightMin[i]-leftMin[i]-1);
			maxArea = Integer.max(maxArea, area);
		}
		return maxArea;
	}
	
	public static int largestRectangleAreaInONSpace(int[] heights) { 
		 	Stack<Integer> stack = new Stack<>(); 
	        int maxArea = 0; 
	        int areaWithTop; 
	        int i = 0; 
	        while (i < heights.length) {    
	            if (stack.empty() || heights[stack.peek()] <= heights[i]) 
	                stack.push(i++); 
	            else{ 
	                areaWithTop = heights[stack.pop()] * (stack.empty() ? i : i - stack.peek() - 1); 
	                maxArea = Integer.max(areaWithTop, maxArea);
	            } 
	        } 
	        while (stack.empty() == false) { 
	            areaWithTop = heights[stack.pop()] * (stack.empty() ? i : i - stack.peek() - 1); 
	            maxArea = Integer.max(areaWithTop, maxArea);
	        } 
	       
	        return maxArea; 
    }
	
	public static void main(String[] args) {
		int []heights = {6,2,5,4,5,1,6};
		//int []heights = {1,2,3,4,2};
		System.out.println(largestRectangleAreaInO3NSpace(heights));
	}

}
