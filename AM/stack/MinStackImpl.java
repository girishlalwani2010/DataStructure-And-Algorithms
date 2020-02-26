package stack;

import java.util.LinkedList;

public class MinStackImpl {
	
	/**
	 * @author girish_lalwani
	 *
	 *For below implementation used LinkedList as Stack is deprecated, but stack can also be used. 
	 *
	 *	Method1
	 *
	 *First Stack for elements and second for minimum values
	 *
	 *6,7,4,10,11,3,20,21,2
	 *
	 *stack1 = 6,7,4,10,11,3,20,21,2
	 *stack2 = INF,6,4,3,2
	 *
	 *after poping 2
	 *stack1 = 6,7,4,10,11,3,20,21
	 *stack2 = INF,6,4,3
	 *
	 **after poping 3
	 *stack1 = 6,7,4,10,11
	 *stack2 = INF.6,4
	 *
	 *and so on
	 */
	class MinStack1{
		 	LinkedList<Integer> stack1;
		    LinkedList<Integer> stack2;
		    int min;
		    
		    public MinStack1() {
		        stack1 = new LinkedList<>();
		        stack2 = new LinkedList<>();
		        min = Integer.MAX_VALUE;
		        stack2.add(0,min);
		    }
		    
		    public void push(int x) {
		        stack1.add(0,x);
		        if(x<=min){
		            min = x;
		            stack2.add(0,x);
		        }
		    }
		    
		    public void pop() {
		        Integer item = stack1.remove();
		        if(item.intValue() == min){
		            stack2.remove();
		            min = stack2.peek();
		        }
		    }
		    
		    public int top() {
		        return stack1.peek();
		    }
		    
		    public int getMin() {
		        if(!stack1.isEmpty()){
		            // or stack2.peek();
		            return min;
		        }
		        return -1;
		    }
	}
	
	/**
	 * @author girish_lalwani
	 * Using one stack Method-2
	 * For ex: for push - 6,7,4,10,11,3,20,21,2
	 * Stack will be INF,6-actual,7,6-min,4-actual,10,11,4-min,3-actual,20,21,3-min as minimum is changed to 2 so store previous min,2
	 * suffient to understand Stack till this INF,6-actual,7,6-min,4-actual
	 */
	class MinStack2 {

	    private LinkedList<Integer> stack;
	    private int min;
	    
	    /** initialize your data structure here. */
	    public MinStack2() {
	        stack = new LinkedList<>();
	        min = Integer.MAX_VALUE;
	    }
	    
	    public void push(int x) {
	        if(x<=min){
	            stack.add(0,min);
	            min = x;
	        }
	        stack.add(0,x);
	    }
	    
	    public void pop() {
	        if(min==stack.remove()){
	            min = stack.remove();
	        }
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin(){
	        return min;
	    }
	}


}
