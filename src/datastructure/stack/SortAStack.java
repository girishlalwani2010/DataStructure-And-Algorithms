package datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class SortAStack {

	public Stack<Integer> sortAStack(Stack <Integer> stack){
		
		Stack<Integer> tempStack = new Stack<Integer>();
		
		while(stack!=null && !stack.isEmpty()){
			int current = stack.pop();
			if(tempStack.isEmpty()){
				tempStack.push(current);
			}
			else{
				int previous = tempStack.peek();
				while(tempStack!=null && !tempStack.isEmpty() && previous > current){
					previous = tempStack.pop();
					stack.push(previous);
				}
				tempStack.push(current);
			}
			
		}
		
		return tempStack;
	}
	
	
	 void sortUsingRecursion(Stack<Integer> stack)
	 {
	  if (stack.isEmpty())
	   return;
	  Integer top = stack.pop();
	  sortUsingRecursion(stack);
	  insertSorted(top, stack);
	  return;
	 }

	 void insertSorted(Integer top, Stack<Integer> stack)
	 {
	  if (stack.isEmpty() || stack.peek() > top)
	  {
	   stack.push(top);
	   return;
	  }
	  Integer smaller = stack.pop();
	  insertSorted(top, stack);
	  stack.push(smaller);
	 }
	 
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		SortAStack sortAStack = new SortAStack();
		
		//Stack<Integer> sortedStack = sortAStack.sortAStack(stack);
		
		//sortAStack.sortUsingRecursion(stack);
		
		System.out.println(Arrays.toString(stack.toArray()));
		
		
		
	}
	
}
