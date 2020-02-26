package stack;

import java.util.LinkedList;
import java.util.Stack;

public class MaxStack {
	
	private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    private int max;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
        max = Integer.MIN_VALUE;
        maxStack.push(max);
    }
    
    public void push(int x) {
        stack.push(x);
        if(max<=x){
            maxStack.push(x);
            max = x;
        }
    }
    
    public int pop() {
        int poppedItem = stack.pop();
        if(max == poppedItem){
            maxStack.pop();
            max = maxStack.peek();
        }
        return poppedItem;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max;
    }
    
    public int popMax() {
        int returnVal = maxStack.pop();
        max = maxStack.peek();
        int size = maxStack.size();
        
        while(!stack.isEmpty()){
            if(stack.peek() == returnVal){
                stack.pop();
                break;
            }else{
                maxStack.push(stack.pop());
            }            
        }
        
        LinkedList<Integer> buffer = new LinkedList<>();
        while(maxStack.size()>size){
        	int x = maxStack.pop();
        	if(max<=x){
        		buffer.add(x);
                max = x;
            }
            stack.push(x);            
        }
        
        while(!buffer.isEmpty()) {
        	maxStack.push(buffer.remove());
        }
        
        return returnVal;
    }
    
    public static void main(String[] args) {
    	MaxStack maxStack = new MaxStack();
    	maxStack.push(5);
    	maxStack.push(1);
    	System.out.println(maxStack.popMax());
    	System.out.println(maxStack.peekMax());
	}

}
