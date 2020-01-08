package Deque;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximumFromSubArrayOfSizeK {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //corner case if k is empty
        if(nums==null || k>nums.length-1 || nums.length ==0){
            return new int[0];
        }
        
        Deque<Integer> deque = new LinkedList<>();
        int i=0;
        for(i=0; i<k; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        int[] result = new int[nums.length-k+1];
        
        for(; i<nums.length; i++){
            result[i-k] = nums[deque.peek()];
            
            while(!deque.isEmpty() && deque.peek()<=i-k) {
                deque.removeFirst();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        result[i-k] = nums[deque.peek()];
        
        return result;
    }
}