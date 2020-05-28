package stack;

import java.util.Arrays;
import java.util.Stack;

public class NGEIILeetCode {
	
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int j=1,i=1; j<nums.length*2-1; j++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                res[stack.pop()] = nums[i]; 
            }
            stack.push(i);
            i = (i+1)%nums.length;
        }
        return res;
    }
    
    public int[] nextGreaterElementsBetterWay(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }

}
